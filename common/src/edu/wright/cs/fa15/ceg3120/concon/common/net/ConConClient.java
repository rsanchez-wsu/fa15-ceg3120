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

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

//TODO have security
public class ConConClient {
	private String host;
	private int port;

	public ConConClient(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public void sendMessage(String message) {
		new DisptatchMessage(message).start();
	}

	private class DisptatchMessage extends Thread {
		private String message;

		public DisptatchMessage(String message) {
			this.message = message;
		}

		@Override
		public void run() {
			try {
				Socket clientSocket = new Socket(host, port);
				DataOutputStream toServer = new DataOutputStream(
						clientSocket.getOutputStream());
				BufferedReader fromServer = new BufferedReader(
						new InputStreamReader(clientSocket.getInputStream()));

				toServer.writeBytes(message);
				// Remove this when the value in response is actually used.
				@SuppressWarnings("unused")
				String response = "";
				int ch = 0;
				while ((ch = fromServer.read()) != -1) {
					response += (char) ch;
				}

				// do something

				clientSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
