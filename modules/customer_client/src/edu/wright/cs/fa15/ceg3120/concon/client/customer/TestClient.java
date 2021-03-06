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

package edu.wright.cs.fa15.ceg3120.concon.client.customer;

import edu.wright.cs.fa15.ceg3120.concon.common.net.ConConClient;
import edu.wright.cs.fa15.ceg3120.concon.common.net.NetworkManager;
import edu.wright.cs.fa15.ceg3120.concon.common.net.data.ChatData;
import edu.wright.cs.fa15.ceg3120.concon.common.net.data.LoginData;
import edu.wright.cs.fa15.ceg3120.concon.common.net.data.UserData;
import edu.wright.cs.fa15.ceg3120.concon.common.ui.ChatPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * Test client for testing network message sending.
 */
public class TestClient implements WindowListener {
	
	private static final Logger LOG = LoggerFactory.getLogger(TestClient.class);
	private static final int POLLING_RATE = 3;
	private static final int POLLING_DELAY = 10;
	
	private static ConConClient client;
	private static ChatPanel chatPanel;
	private static ScheduledFuture<?> updateHandle;
	private static boolean closing;
	
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
		UserData testUser = new UserData("ContractorGuy");
		chatPanel = new ChatPanel(client, testUser);
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame clientFrame = new JFrame();
				String name = JOptionPane.showInputDialog(clientFrame, "Enter username:");
				String pass = JOptionPane.showInputDialog(clientFrame, "Enter password:");
				NetworkManager.sendMessage("login", new LoginData(name, pass));
				
				clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				clientFrame.getContentPane().add(chatPanel);
				clientFrame.setSize(400, 400);
				clientFrame.setVisible(true);
			}
			
		});
		
		final ScheduledExecutorService updateScheduler =
				Executors.newScheduledThreadPool(1);
		
		final Runnable fetcher = new Runnable() {

			@Override
			public void run() {
				ChatData getMessages = new ChatData();
				NetworkManager.sendMessage("fetchMessages", getMessages);
				
				if (isClosing()) {
					updateHandle.cancel(true);
				}
			}
		
		};
		updateHandle = updateScheduler.scheduleAtFixedRate(
				fetcher, POLLING_DELAY, POLLING_RATE, TimeUnit.SECONDS);
	}

	/**
	 * True when application is closing.
	 * @return true if the test client application is closing
	 */
	protected static synchronized boolean isClosing() {
		return closing;
	}

	/**
	 * Set closing.
	 * @param closing set true if application is closing
	 */
	public static synchronized void setClosing(boolean closing) {
		TestClient.closing = closing;
	}

	/**
	 * Get chatPanel.
	 * @return the chatPanel
	 */
	public static ChatPanel getChatPanel() {
		return chatPanel;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowActivated(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowClosed(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowClosing(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowClosing(WindowEvent arg0) {
		setClosing(true);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowDeactivated(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowDeiconified(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowIconified(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowOpened(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
