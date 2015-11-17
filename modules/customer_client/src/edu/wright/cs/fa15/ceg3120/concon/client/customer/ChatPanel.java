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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.border.EmptyBorder;
/**
 * This class will launch a window for users to live chat.
 * Will possibly need to change to be a tab.
 * @author Joe
 */
public class ChatPanel extends JDialog {

	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Not sure if needed. 
	 */
	public static void main(String[] args) {
		try {
			ChatPanel dialog = new ChatPanel();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog window.
	 */
	public ChatPanel() {
		setTitle("Chat Window");
		setResizable(false);
		setBackground(Color.orange);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.ORANGE);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setRows(12);
		textArea.setColumns(40);
		JScrollPane scrollPane = new JScrollPane(textArea);
		contentPanel.add(scrollPane, BorderLayout.CENTER);
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				textField = new JTextField();
				textField.setAlignmentX(Component.LEFT_ALIGNMENT);
				textField.setHorizontalAlignment(JTextField.LEFT);
				buttonPane.add(textField);
				textField.setColumns(32);
			}
			{
				JButton sendButton = new JButton("Send");
				sendButton.addActionListener(new SendBtnListener());
				sendButton.setActionCommand("OK");
				buttonPane.add(sendButton);
				getRootPane().setDefaultButton(sendButton);
			}
		}
	}
	
	/**
	 * action listener for handling the send button.
	 *
	 */
	private static class SendBtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ex) {
			// TODO implement action for send button
		
		}
		
	}
}
