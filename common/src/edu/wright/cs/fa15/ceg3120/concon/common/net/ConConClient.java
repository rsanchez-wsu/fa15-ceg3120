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

import edu.wright.cs.fa15.ceg3120.concon.common.net.data.UserData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;



//TODO have security
/**
 * Class which handles non-blocking communication with a server.
 */
public class ConConClient implements Closeable {
	private static final Logger LOG = LoggerFactory.getLogger(ConConClient.class);
	
	private Socket sock;

	private UserData currentUser;
	
	/**
	 * Constructs a client which will talk to the designated host:port.
	 * @param host an IP address or similar.
	 * @param port will fail if in use.
	 */
	public ConConClient(String host, int port) {
		try {
			this.sock = new Socket(host, port);
		} catch (IOException e) {
			LOG.error("ConCon Client IO: ", e);
		}
	}

	/**
	 * Sends an XML-encoded message to the server.
	 * @param message Message to be sent
	 */
	public void sendMessage(String message) {
		new Thread(new DispatchMessage(message)).start();
	}
	
	/**
	 * Closes the client.
	 */
	@Override
	public void close() {
		try {
			if (sock.isConnected()) {
				sock.shutdownInput();
				sock.shutdownOutput();
				sock.close();
			}
		} catch (IOException e) {
			LOG.error("ConCon Client Close: ", e);
		}
	}
	
	/**
	 * The threaded class which will handle the actual sending of messages.
	 */
	private class DispatchMessage implements Runnable {
		private String message;

		/**
		 * Constructor.
		 * @param message the message.
		 */
		public DispatchMessage(String message) {
			this.message = message;
		}

		@Override
		public void run() {
			try {
				Socket clientSocket = sock;
				DataOutputStream toServer =
						new DataOutputStream(clientSocket.getOutputStream());
				BufferedReader fromServer =	new BufferedReader(
						new InputStreamReader(
								clientSocket.getInputStream(), 
								StandardCharsets.UTF_8));
				
				while (message != null) {
					// Send message
					toServer.writeBytes(message);
					
					// Receive reply
					StringBuilder response = new StringBuilder();
					String line;
					while ((line = fromServer.readLine()) != null) {
						response.append(line);
						if (line.compareTo("</java>") == 0) {
							break;
						}
					}
					
					// Process reply
					MessageHolder result =
							(MessageHolder)NetworkManager.decodeFromXml(response.toString());
					if (result != null) {
						MessageHolder mh = 
								NetworkManager.post(result.getChannel(), result.getMessage());
						if (mh.getChannel().equals("end")) {
							break;
						}
						message = NetworkManager.encodeToXml(mh);
					} else {
						message = null;
					}
				}
			} catch (IOException e) {
				LOG.error("Dispatch Message IO: ", e);
			}
		}
	}

	/**
	 * Sets the current user.
	 * @param user current user
	 */
	public void setCurrentUser(UserData user) {
		currentUser = user;
	}
	
	/**
	 * Get the current user.
	 * @return current logged in user if connected
	 */
	public UserData getCurrentUser() {
		return currentUser;
	}
}
