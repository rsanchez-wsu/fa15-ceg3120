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

package edu.wright.cs.fa15.ceg3120.concon.server;

import edu.wright.cs.fa15.ceg3120.concon.common.net.ConConClient;
import edu.wright.cs.fa15.ceg3120.concon.common.net.NetworkManager;
import edu.wright.cs.fa15.ceg3120.concon.common.net.data.ChatData;
import edu.wright.cs.fa15.ceg3120.concon.common.net.data.LoginData;
import edu.wright.cs.fa15.ceg3120.concon.common.net.data.UserData;
import edu.wright.cs.fa15.ceg3120.concon.common.ui.ChatPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * Test client for testing network message sending.
 */
public class TestClient {
	private static final Logger LOG = LoggerFactory.getLogger(TestClient.class);
	private static ConConClient client;
	private static ChatPanel chatPanel;
	
	/**
	 * Main entry point. TODO Expand.
	 * @param args Arguments.
	 */
	public static void main(String[] args) {
		NetworkManager.registerNetworkHandlerClass(LoginData.class);
		NetworkManager.registerNetworkHandlerClass(UserData.class);
		NetworkManager.registerNetworkHandlerClass(ChatData.class);
		
		LOG.trace("Starting client...");
		NetworkManager.startClient("127.0.0.1", 9667);
		client = NetworkManager.getClient();
		
		// create a test user to send messages to
		// normally you would initialize with the selected user from a list
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame clientFrame = new JFrame();
				String name = JOptionPane.showInputDialog(clientFrame, "Enter username:");
				String pass = JOptionPane.showInputDialog(clientFrame, "Enter password:");
				String to = JOptionPane.showInputDialog(clientFrame, "Enter user to chat with:");
				
				NetworkManager.sendMessage("login", new LoginData(name, pass));
				UserData testUser = new UserData(to);
				chatPanel = new ChatPanel(client, testUser);
				
				clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				clientFrame.getContentPane().add(chatPanel);
				clientFrame.setSize(400, 400);
				clientFrame.setVisible(true);
			}
			
		});
	}

	/**
	 * Get chatPanel.
	 * @return the chatPanel
	 */
	public static ChatPanel getChatPanel() {
		return chatPanel;
	}
}
