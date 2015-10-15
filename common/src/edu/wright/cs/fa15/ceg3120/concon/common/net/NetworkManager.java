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
import edu.wright.cs.fa15.ceg3120.concon.common.net.message.DataMessage;
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
					System.out.println("Invalid parameters on NetworkHandler method: " 
							+ m.getName());
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
				try {
					System.out.println("Recieved message: " + message);
					//if (message instanceof NetworkMessageSomethingSomething)
					//   listener.getKey().invoke(null, (NetworkMessageSomethingSomething)message);
					// etc
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}


	/**
	 * Description. TODO Fill out.
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
	 * Description. TODO Fill out.
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
	 * Description. TODO Fill out.
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
	 * Description. TODO Fill out.
	 * @param xml Data to parse.
	 * @return result.
	 * @throws UnsupportedEncodingException TODO Reason.
	 */
	protected static NetworkMessage decodeFromXml(String xml) throws UnsupportedEncodingException {
		//some reflection wizardry or switching or something
		XMLDecoder xmlWizard = new XMLDecoder(new ByteArrayInputStream(xml.getBytes("UTF-8")));
		NetworkMessage result = (NetworkMessage) xmlWizard.readObject();
		xmlWizard.close();
		return result;
	}

	/**
	 * Description. TODO Fill out.
	 * @param message Message to encode.
	 * @return encoded data.
	 * @throws UnsupportedEncodingException TODO Reason.
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