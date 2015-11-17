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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//TODO have security
/**
 * Class which handles non-blocking communication with clients.
 */
public class ConConServer implements Runnable {
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
	public void quit() {
		this.listening = false;
		try {
			this.serverSocket.close();
		} catch (IOException e) {
			LOG.error("Server Socket: ", e);
		}
	}

	/**
	 * The threaded class which will handle the actual communication.
	 */
	private static class ConnectionWorker implements Runnable {

		private Socket clientSocket = null;

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
				// Construct the reader and writer for the connection
				DataOutputStream toClient = 
						new DataOutputStream(clientSocket.getOutputStream());
				BufferedReader fromClient = new BufferedReader(
						new InputStreamReader(clientSocket.getInputStream(), "UTF-8"));
				StringBuilder message = new StringBuilder();					
				String line;
				while (clientSocket.isConnected()) {
					while ((line = fromClient.readLine()) != null) {
						message.append(line);
						if (line.compareTo("</java>") == 0) {
							break;
						}
					}
					
					MessageHolder mh = 
							(MessageHolder)NetworkManager.decodeFromXml(message.toString());
					if (mh.getChannel().equals("end")) {
						break;
					}
					MessageHolder response = 
							NetworkManager.post(mh.getChannel(), mh.getMessage());
					if (response != null) {
						String responseXml = NetworkManager.encodeToXml(response);
						
						if (mh.getMessage() instanceof ChatData) {
							ChatData responseMessage = (ChatData)mh.getMessage();
							String to = responseMessage.getTo();
							
							// Change this to send to the user specified in the "to" field
							toClient.writeBytes(responseXml);
						} else {
							toClient.writeBytes(responseXml);
						}
					}
				}
			} catch (IOException e) {
				LOG.error("Connection Worker IO: ", e);
			} finally {
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
