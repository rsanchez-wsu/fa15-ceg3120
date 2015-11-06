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
				while (!clientSocket.isClosed()) {
					// Construct the reader and writer for the connection
					DataOutputStream toClient = 
							new DataOutputStream(clientSocket.getOutputStream());
					BufferedReader fromClient = new BufferedReader(
							new InputStreamReader(clientSocket.getInputStream(), "UTF-8"));
	
					int ch;
					StringBuilder message = new StringBuilder();
					while ((ch = fromClient.read()) != -1) {
						message.append((char) ch);
					}//Reads message from client into integer buffer
					while (message.toString().length() > 0) {
						MessageHolder mh = 
								(MessageHolder)NetworkManager.decodeFromXml(message.toString());
						MessageHolder response = 
								NetworkManager.post(mh.getChannel(), mh.getMessage());
						if (response != null) {
							toClient.writeBytes(NetworkManager.encodeToXml(response));
							ch = 0;
							message = new StringBuilder();
							while ((ch = fromClient.read()) != -1) {
								message.append((char)ch);
							}//Reads message from client into integer buffer
						}
					}
					toClient.close();
					fromClient.close();
				}
			} catch (IOException e) {
				LOG.error("Connection Worker IO: ", e);
			}
		}
	}
}
