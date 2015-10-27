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

import edu.wright.cs.fa15.ceg3120.concon.common.net.message.ChatMessage;
import edu.wright.cs.fa15.ceg3120.concon.common.net.message.LoginReplyMessage;
import edu.wright.cs.fa15.ceg3120.concon.common.net.message.LoginRequestMessage;
import edu.wright.cs.fa15.ceg3120.concon.common.net.message.NetworkMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is used to manage network connections.
 * @author Networking Team
 *
 */
public class NetworkManager {
	
	private static final Logger LOG = LoggerFactory.getLogger(NetworkManager.class);
	

	private static final HashMap<Method, Class<?>> NETWORK_BUS = new HashMap<Method, Class<?>>();

	private static ConConServer server;
	private static ConConClient client;

	/**
	 * Description. TODO Fill out.
	 * @param cl Class to register.
	 */
	public static void registerNetworkClass(Class<?> cl) {
		Method[] methods = cl.getMethods();
		for (Method m : methods) {
			if (m.isAnnotationPresent((Class<? extends Annotation>) NetworkHandler.class)) {
				Class<?>[] argClasses = m.getParameterTypes();
				if (argClasses.length != 1 
						|| !NetworkMessage.class.isAssignableFrom(argClasses[0])
						|| NETWORK_BUS.values().contains(argClasses[0])) {
					LOG.error("Invalid parameters on NetworkHandler method: " + m.getName());
				} else {
					NETWORK_BUS.put(m, argClasses[0]);
				}
			}
		}
	}

	/**
	 * Description. TODO Fill out.
	 * @param message Message to post.
	 */
	public static NetworkMessage post(NetworkMessage message) {
		for (Map.Entry<Method, Class<?>> listener : NETWORK_BUS.entrySet()) {
			if (listener.getValue().isAssignableFrom(message.getClass())) {
				LOG.debug("Recieved message: " + message);
				try {
					if (message instanceof LoginRequestMessage) {
						listener.getKey().invoke("login", (LoginRequestMessage)message);
					} else if (message instanceof LoginReplyMessage) {
						listener.getKey().invoke("setCurrentUser", (LoginReplyMessage)message);
					} else if (message instanceof ChatMessage) {
						listener.getKey().invoke(null, (ChatMessage)message);
					}
				} catch (IllegalAccessException e) {
					LOG.error("Could not access: ", e);
				} catch (IllegalArgumentException e) {
					LOG.error("Wrong Argument: ", e);
				} catch (InvocationTargetException e) {
					LOG.error("Could not invoke: ", e);
				}
			}
		}
		return null;
	}


	/**
	 * Start the server.
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
	 * Method safely stops the server.
	 */
	public static void stopServer() {
		server.quit();
		server = null;
	}

	/**
	 * Start the client.
	 * 
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
	 * Deletes the client object.
	 * Collects the garbage.
	 */
	public static void stopClient() {
		client = null;
	}

	/**
	 * Send a network message.
	 * 
	 * @param message Message to send.
	 * @return false if failed.
	 */
	public static boolean sendMessage(NetworkMessage message) {
		if (client == null) {
			return false;
		}
		try {
			client.sendMessage(encodeToXml(message));
		} catch (UnsupportedEncodingException e) {
			LOG.warn("Improper message encoding: ", e);
		}
		return true;
	}

	/**
	 * Decodes Java Bean objects from XML received over network.
	 * @param xml Data to parse.
	 * @return result.
	 * @throws UnsupportedEncodingException The Character Encoding is not supported.
	 */
	protected static NetworkMessage decodeFromXml(String xml) throws UnsupportedEncodingException {
		//some reflection wizardry or switching or something
		XMLDecoder xmlWizard = new XMLDecoder(new ByteArrayInputStream(xml.getBytes("UTF-8")));
		NetworkMessage result = (NetworkMessage) xmlWizard.readObject();
		xmlWizard.close();
		return result;
	}

	/**
	 * Encodes Java Bean objects to XML sent over network.
	 * @param message Message to encode.
	 * @return encoded data.
	 * @throws UnsupportedEncodingException The Character Encoding is not supported.
	 */
	protected static String encodeToXml(NetworkMessage message) 
			throws UnsupportedEncodingException {
		//some reflection wizardry or switching or something
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		XMLEncoder xmlWizard = new XMLEncoder(out, "UTF-8", false, 0);
		xmlWizard.writeObject(message);
		xmlWizard.close();
		return out.toString("UTF-8");
	}
}