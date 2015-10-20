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

/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package edu.wright.cs.fa15.ceg3120.concon.server;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * This class is used to create the messaging tab of the Server Admin GUI.
 * @author Quintin
 *
 */
public class MessagingTab {
	
	//TODO make the tab look better.
	
	/**
	 * Creates the messaging tab and returns the JPanel that was created.
	 * @return the panel to add that has been created.
	 */
	public static JComponent createMessagingTab() {
		/*
		 * Instantiation of the north panel. This panel will hold the two list
		 * views to select the users that will receive the message.
		 */
		DefaultListModel<String> usersModel = new DefaultListModel<>();
		// Create dummy data for JList
		usersModel.addElement("Bob");
		usersModel.addElement("Susan");
		usersModel.addElement("ConstructionsRUs");
		usersModel.addElement("Bob's Building Builders");

		JList<String> usersList = new JList<>();
		usersList.setModel(usersModel);

		JLabel usersLabel = new JLabel("Users:"); // TODO add label to view
		JPanel usersPanel = new JPanel(new BorderLayout());
		JScrollPane usersScrollPane = new JScrollPane(usersList);
		usersPanel.add(usersLabel, BorderLayout.NORTH);
		usersPanel.add(usersScrollPane, BorderLayout.CENTER);

		JPanel northPanel = new JPanel();
		northPanel.add(usersPanel);

		// Buttons for moving selections from one pane to another.
		JPanel buttonPanel = new JPanel(new BorderLayout());
		JButton button = new JButton("Add all");
		// TODO add listener
		buttonPanel.add(button, BorderLayout.NORTH);
		button = new JButton("-->");
		// TODO add listener
		buttonPanel.add(button, BorderLayout.EAST);
		button = new JButton("<--");
		buttonPanel.add(button, BorderLayout.SOUTH);
		northPanel.add(buttonPanel);

		JPanel selectedPanel = new JPanel(new BorderLayout());
		JLabel selectedLabel = new JLabel("Selected:");
		JList<String> selectedList = new JList<>();
		DefaultListModel<String> selectedModel = new DefaultListModel<>();
		selectedModel.addElement("Bob");
		selectedList.setModel(selectedModel);
		JScrollPane selectedScrollPane = new JScrollPane(selectedList);
		selectedPanel.add(selectedLabel, BorderLayout.NORTH);
		selectedPanel.add(selectedScrollPane, BorderLayout.CENTER);
		northPanel.add(selectedPanel);

		/*
		 * Instantiation of the center panel. This panel will hold the editor
		 * pane that will be used to edit the message to be sent.
		 */
		JPanel centerPanel = new JPanel(new BorderLayout());
		JLabel messageLabel = new JLabel("Message:");
		JEditorPane messageText = new JEditorPane();
		JScrollPane messageScrollPane = new JScrollPane(messageText);
		centerPanel.add(messageLabel, BorderLayout.NORTH);
		centerPanel.add(messageScrollPane, BorderLayout.CENTER);

		/*
		 * Instantiation of the east panel. This panel will hold two buttons.
		 * One to clear all data one to send message.
		 */
		JPanel eastPanel = new JPanel();
		button = new JButton("Clear");
		// TODO add listener
		eastPanel.add(button);
		button = new JButton("Send");
		// TODO add listener
		eastPanel.add(button);

		JPanel panel = new JPanel(new BorderLayout());

		panel.add(northPanel, BorderLayout.NORTH);
		panel.add(centerPanel, BorderLayout.CENTER);
		panel.add(eastPanel, BorderLayout.EAST);

		return panel;
	}
}
