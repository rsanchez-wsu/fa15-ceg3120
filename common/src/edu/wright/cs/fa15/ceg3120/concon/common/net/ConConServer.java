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
 * The server should only be able to instantiate 1 server or 1 client.
 */
public class ConConServer implements Runnable {
	private static final Logger LOG = LoggerFactory.getLogger(ConConServer.class);

	private int port;
	private ServerSocket serverSocket = null;
	private boolean listening = true;

	/**
	 * The single argument constructor for the server API.
	 * @param port The port on which the server will listen.
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
			new ConnectionWorker(clientSocket).start();
		}
	}

	/**
	 * Single method to stop server.
	 * TODO: add method to make sure all clients have ceased connections to server.
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
	 * Handles the actual client<->server communications.
	 */
	private static class ConnectionWorker extends Thread {

		private Socket clientSocket = null;

		/**
		 * This is a constructor.
		 * 
		 * @param clientSocket
		 *            the socket the worker is communicating over.
		 */
		public ConnectionWorker(Socket clientSocket) {
			this.clientSocket = clientSocket;
		}

		@Override
		public void run() {
			try {
				// Construct the reader and writer for the connection
				DataOutputStream toClient = new DataOutputStream(clientSocket.getOutputStream());
				BufferedReader fromClient = new BufferedReader(
						new InputStreamReader(clientSocket.getInputStream(), "UTF-8"));

				int ch = 0;
				StringBuilder message = new StringBuilder();
				while ((ch = fromClient.read()) != -1) {
					message.append(ch);
				}//Reads message from client into integer buffer

				NetworkManager.post(NetworkManager.decodeFromXml(message.toString()));

				toClient.close();
				fromClient.close();
			} catch (IOException e) {
				LOG.error("Connection Worker IO: ", e);
			}
		}
	}
}
