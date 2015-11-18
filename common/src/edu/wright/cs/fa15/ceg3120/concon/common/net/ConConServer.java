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

import edu.wright.cs.fa15.ceg3120.concon.common.net.data.ChatData;
import edu.wright.cs.fa15.ceg3120.concon.common.net.data.UserData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

//TODO have security
/**
 * Class which handles non-blocking communication with clients.
 */
public class ConConServer implements Runnable, Closeable {
	private static final Logger LOG = LoggerFactory.getLogger(ConConServer.class);

	private int port;
	private ServerSocket serverSocket = null;
	private boolean listening = true;

	/**
	 * Constructor
	 * @param port the port.
	 */
	public ConConServer(int port) {
		this.port = port;
	}

	@Override
	public void run() {
		try {
			this.serverSocket = new ServerSocket(this.port);
		} catch (IOException e) {
			LOG.error("Server Socket init: ", e);
		}
		while (listening) {
			Socket clientSocket = null;
			try {
				clientSocket = this.serverSocket.accept();
			} catch (IOException e) {
				if (!listening) {
					LOG.error("Server Stopped: ", e);
					return;
				}
				LOG.error("Client Socket: ", e);
			}
			new Thread(new ConnectionWorker(clientSocket)).start();
		}
	}

	/**
	 * Stop the server.
	 */
	@Override
	public void close() {
		this.listening = false;
		try {
			this.serverSocket.close();
		} catch (IOException e) {
			LOG.error("Server Socket: ", e);
		}
	}

	/**
	 * Stop the server.
	 */
	public void quit() {
		this.close();
	}
	
	/**
	 * The threaded class which will handle the actual communication.
	 */
	private static class ConnectionWorker implements Runnable {

		private static ConcurrentHashMap<String, Socket> socketTable = 
				new ConcurrentHashMap<String, Socket>();
		
		private Socket clientSocket = null;
		private UserData user = null;

		/**
		 * constructor.
		 * @param clientSocket the client socket.
		 */
		public ConnectionWorker(Socket clientSocket) {
			this.clientSocket = clientSocket;
		}
		
		@Override
		public void run() {
			try {
				BufferedReader fromClient = new BufferedReader(
						new InputStreamReader(clientSocket.getInputStream(), "UTF-8"));
				String line = "";
				// Loop until client closes their window
				while (clientSocket.isConnected() && line != null) {
					StringBuilder message = new StringBuilder();					
					while ((line = fromClient.readLine()) != null) {
						message.append(line);
						if (line.compareTo("</java>") == 0) {
							// Process message and relay it to the right place
							DataOutputStream toThisClient = 
									new DataOutputStream(clientSocket.getOutputStream());
							MessageHolder mh = 
									(MessageHolder)NetworkManager.decodeFromXml(message.toString());
							if (mh.getChannel().equals("end")) {
								return;
							}
							MessageHolder response = 
									NetworkManager.post(mh.getChannel(), mh.getMessage());
							if (response != null) {
								String responseXml = NetworkManager.encodeToXml(response);
								
								// Treat message according to type
								if (response.getMessage() instanceof UserData) {
									this.user = (UserData)response.getMessage();
									socketTable.put(user.getAccountName(), this.clientSocket);
								} else if (response.getMessage() instanceof ChatData) {
									ChatData chat = (ChatData)response.getMessage();
									if (socketTable.containsKey(chat.getTo())) {
										Socket otherClientSocket = socketTable.get(chat.getTo());
										DataOutputStream toOtherClient = 
												new DataOutputStream(
														otherClientSocket.getOutputStream());
										toOtherClient.writeBytes(responseXml);
									}
								}
								
								// Send response back regardless of type
								toThisClient.writeBytes(responseXml);
							}
							break;
						}
					}
				}
			} catch (IOException e) {
				LOG.error("Connection Worker IO: ", e);
			} finally {
				// Close client connection
				if (socketTable.containsKey(user.getAccountName())) {
					socketTable.remove(user.getAccountName());
				}
				if (clientSocket.isConnected()) {
					try {
						clientSocket.shutdownInput();
						clientSocket.shutdownOutput();
						clientSocket.close();
					} catch (IOException e) {
						LOG.warn("Connection  already closed.");
					}
				}
			}
		}
	}
}
