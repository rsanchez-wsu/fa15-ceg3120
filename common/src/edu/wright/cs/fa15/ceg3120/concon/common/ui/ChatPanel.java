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

package edu.wright.cs.fa15.ceg3120.concon.common.ui;

import edu.wright.cs.fa15.ceg3120.concon.common.net.ConConClient;
import edu.wright.cs.fa15.ceg3120.concon.common.net.NetworkManager;
import edu.wright.cs.fa15.ceg3120.concon.common.net.data.ChatData;
import edu.wright.cs.fa15.ceg3120.concon.common.net.data.UserData;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * User interface for chat messages.
 * @author NathanJent
 *
 */
public class ChatPanel extends JPanel {

	private static final long serialVersionUID = 9195112434638392386L;
	private static JTextArea textArea = new JTextArea();
	private transient ConConClient client;
	private UserData recipient;

	/**
	 * Create the panel.
	 */
	public ChatPanel(ConConClient client, UserData recipient) {
		this.client = client;
		this.recipient = recipient;
		final GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{306, 77, 0};
		gridBagLayout.rowHeights = new int[]{135, 37, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		final JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbcScrollPane = new GridBagConstraints();
		gbcScrollPane.gridwidth = 2;
		gbcScrollPane.insets = new Insets(0, 0, 5, 5);
		gbcScrollPane.fill = GridBagConstraints.BOTH;
		gbcScrollPane.gridx = 0;
		gbcScrollPane.gridy = 0;
		add(scrollPane, gbcScrollPane);

		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		final JFormattedTextField formattedTextField = new JFormattedTextField();
		GridBagConstraints gbcFormattedTextField = new GridBagConstraints();
		gbcFormattedTextField.fill = GridBagConstraints.BOTH;
		gbcFormattedTextField.insets = new Insets(0, 0, 0, 5);
		gbcFormattedTextField.gridx = 0;
		gbcFormattedTextField.gridy = 1;
		add(formattedTextField, gbcFormattedTextField);
		
		final JButton btnSend = new JButton("Send");
		GridBagConstraints gbcBtnSend = new GridBagConstraints();
		gbcBtnSend.fill = GridBagConstraints.HORIZONTAL;
		gbcBtnSend.gridx = 1;
		gbcBtnSend.gridy = 1;
		add(btnSend, gbcBtnSend);
		
		btnSend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ev) {
				sendMessage(
						formattedTextField.getText()
				);
				formattedTextField.setText("");
			}
			
		});
		
		formattedTextField.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					sendMessage(
							formattedTextField.getText()
					);
					formattedTextField.setText("");					
				}	
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
			}
			
		});
	}

	/**
	 * Sends a message over the network.
	 * @param text the message text
	 */
	private void sendMessage(String text) {
		NetworkManager.sendMessage(
				"chatPost", 
				new ChatData(text, client.getCurrentUser().getAccountName(),
						recipient.getAccountName()));
	}
	
	/**
	 * Append a string to the chat area.
	 * @param str string to append
	 */
	public void appendToChatArea(String str) {
		textArea.append(str);
	}

	/**
	 * Get recipient.
	 * @return the recipient
	 */
	public UserData getRecipient() {
		return recipient;
	}

	/**
	 * Set recipient.
	 * @param recipient the recipient to set
	 */
	public void setRecipient(UserData recipient) {
		this.recipient = recipient;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChatPanel [recipient=" + recipient + "]";
	}
}
