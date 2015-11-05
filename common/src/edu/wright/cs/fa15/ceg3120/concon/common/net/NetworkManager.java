/*
 * Copyright (C) 2015
 * 
 * 
 * 
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package edu.wright.cs.fa15.ceg3120.concon.common.net;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is used to manage network connections.
 * @author Networking Team
 */
public class NetworkManager {
	
	private static final Logger LOG = LoggerFactory.getLogger(NetworkManager.class);

	private static final HashMap<String, Method> NETWORK_BUS = new HashMap<>();

	private static ConConServer server;
	private static ConConClient client;

	/**
	 * Searches a class for methods annotated with NetworkHandler and registers them to the bus.
	 * Every NetworkHandler method in a module MUST have a unique channel.
	 * @param cl Class to search.
	 * @return List containing registered NetworkHandler method channels.
	 */
	public static List<String> registerNetworkHandlerClass(Class<?> cl) {
		Method[] methods = cl.getMethods();
		List<String> registered = new ArrayList<>();
		for (Method m : methods) {
			if (m.isAnnotationPresent(NetworkHandler.class)) {
				Class<?>[] argClasses = m.getParameterTypes();
				String channel = m.getAnnotation(NetworkHandler.class).channel();
				if (argClasses.length != 1
						|| (!m.getReturnType().equals(Void.TYPE)
							&& !m.getReturnType().equals(MessageHolder.class))
						|| !argClasses[0].equals(Object.class)
						|| NETWORK_BUS.keySet().contains(channel)) {
					LOG.error("Invalid parameters on NetworkHandler method: "
							+ m.getName());
					throw new RuntimeException();
				} else {
					NETWORK_BUS.put(channel, m);
					registered.add(channel);
				}
			}
		}
		return registered;
	}

	/**
	 * Post a message to the targeted channel.
	 * @param targetChannel unique channel ID to target.
	 * @param message message to post.
	 * @return A response, or null.
	 */
	public static MessageHolder post(String targetChannel, Object message) {
		for (Map.Entry<String, Method> listener : NETWORK_BUS.entrySet()) {
			if (listener.getKey().equals(targetChannel)) {
				try {
					Object response = listener.getValue().invoke(null, message);
					if (response instanceof MessageHolder) {
						return (MessageHolder)response;
					}
				} catch (ReflectiveOperationException e) {
					LOG.error("Error while posting to " + targetChannel, e);
				}
			}
		}
		return null;
	}


	/**
<<<<<<< HEAD
	 * Start the server.
=======
	 * Start a listening server if a server or client isn't running already.
>>>>>>> refs/remotes/origin/master
	 * @param port Port to use.
	 * @return false if failed.
	 */
	public static synchronized boolean startServer(int port) {
		if (server != null || client != null) {
			return false;
		}
		server = new ConConServer(port);
		new Thread(server).start();
		return true;
	}

	/**
	 * Stops the running server.
	 */
	public static void stopServer() {
		server.quit();
		server = null;
	}

	/**
	 * Start a client to communicate with a server if a server or client isn't running already.
	 * @param host Host to use.
	 * @param port Port to use.
	 * @return false if failed.
	 */
	public static synchronized boolean startClient(String host, int port) {
		if (server != null || client != null) {
			return false;
		}
		client = new ConConClient(host, port);
		return true;
	}

	/**
	 * Stops the client.
	 */
	public static void stopClient() {
		client = null;
	}

	/**
	 * Sends a message from the client (if it exists) to a channel.
	 * @param targetChannel Channel to target.
	 * @param message Message to send.
	 * @return false if failed.
	 */
	public static boolean sendMessage(String targetChannel, Serializable message) {
		if (client == null) {
			return false;
		}
		try {
			client.sendMessage(encodeToXml(new MessageHolder(targetChannel, message)));
		} catch (IOException e) {
			LOG.error("Error while sending to " + targetChannel, e);
			return false;
		}
		return true;
	}

	/**
<<<<<<< HEAD
	 * Decodes Java Bean objects from XML received over network.
=======
	 * Decodes a previously-encoded XML string to an Object.
>>>>>>> refs/remotes/origin/master
	 * @param xml Data to parse.
	 * @return result.
<<<<<<< HEAD
	 * @throws UnsupportedEncodingException The Character Encoding is not supported.
=======
	 * @throws UnsupportedEncodingException //
>>>>>>> refs/remotes/origin/master
	 */
	protected static Object decodeFromXml(String xml) throws UnsupportedEncodingException {
		if (xml == null || xml.equals("")) {
			return null;
		}
		XMLDecoder xmlWizard = new XMLDecoder(new ByteArrayInputStream(xml.getBytes("UTF-8")));
		Object result = xmlWizard.readObject();
		xmlWizard.close();
		return result;
	}

	/**
	 * Encodes an arbitrary Object into an XML string.
	 * @param message Message to encode.
	 * @throws UnsupportedEncodingException //
	 */
	protected static String encodeToXml(Serializable message)
			throws UnsupportedEncodingException {
		if (message == null) {
			return null;
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		XMLEncoder xmlWizard = new XMLEncoder(out, "UTF-8", false, 0);
		xmlWizard.writeObject(message);
		xmlWizard.close();
		return out.toString("UTF-8");
	}
}
