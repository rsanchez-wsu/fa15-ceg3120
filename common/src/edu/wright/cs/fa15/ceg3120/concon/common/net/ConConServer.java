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
public class ConConServer implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(ConConServer.class);
	
    private ConnectionPool pool;
	private int port;
	private ServerSocket serverSocket = null;
	private boolean listening = true;

    public ConConServer(int port, int poolSize) {
        this.port = port;
        pool = new ConnectionPool(poolSize);
    }

    @Override
    public void run() {
        while (listening) {
	        try {
	            this.serverSocket = new ServerSocket(this.port);
	        	pool.add(new ConnectionWorker(serverSocket.accept()));
	        } catch (IOException e) {
	        	pool.shutdown();
	        }
        }
    }

	/**
     * Closes the Server Socket and patiently shuts down the thread pool.
     */
    public void quit() {
        this.listening = false;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            LOG.error("Server Socketnot closed: ", e);
        }
        pool.shutdown(); 
    }

    /**
     * Manages client socket data streams.
     */
    private static class ConnectionWorker implements Runnable {

        private final Socket clientSocket;

		public ConnectionWorker(Socket clientSocket) {
			this.clientSocket = clientSocket;
		}

        @Override
        public void run() {
            try {
            	LOG.trace("Connection Received: " + clientSocket.getInetAddress());
                DataOutputStream toClient = new DataOutputStream(clientSocket.getOutputStream());
                BufferedReader fromClient = new BufferedReader(
                		new InputStreamReader(clientSocket.getInputStream(), "UTF-8"));

				int ch = 0;
				StringBuilder message = new StringBuilder();
				while ((ch = fromClient.read()) != -1) {
					message.append(ch);
				}

				NetworkManager.post(NetworkManager.decodeFromXml(message.toString()));

                toClient.close();
                fromClient.close();
            } catch (IOException e) {
                LOG.error("Connection Worker IO: ", e);
            }
        }
    }
}
