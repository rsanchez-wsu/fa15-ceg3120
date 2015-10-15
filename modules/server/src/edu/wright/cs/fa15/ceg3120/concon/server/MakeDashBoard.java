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
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class MakeDashBoard {
	private static JTextArea textArea;
	private static final String newline = "\n";
	static JComponent panelDashBoard = makeBoard();
	
	protected static JComponent makeBoard() {
		
		textArea = new JTextArea(10, 20);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		
		final JFrame reportFrame = new JFrame("Reports");
		reportFrame.pack();
		reportFrame.setSize(new Dimension(500,250));
		reportFrame.setVisible(false);
		
		reportFrame.setIconImage(CreateImageIcon.iconReport.getImage());
		reportFrame.add(CreateServerReportPanel.createReportPanel, BorderLayout.NORTH);
		
		final JFrame emerFrame = new JFrame("Emergency Message");
		emerFrame.pack();
		emerFrame.setVisible(false);
		emerFrame.setResizable(false);
		emerFrame.setSize(new Dimension(300,150));
		
		emerFrame.setIconImage(CreateImageIcon.iconMessage.getImage());
		
		final JTextArea mergText = new JTextArea(10, 50);
		JLabel mergLabel = new JLabel("Enter the message:");
		mergLabel.setPreferredSize(new Dimension(5,30));
		mergText.setLineWrap(true);
		mergText.setWrapStyleWord(true);
		
		JButton jsend = new JButton("Send");
		jsend.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				displayInTextArea("Message sent: " + mergText.getText());
				emerFrame.dispose();
			}
		});
		JButton jclear = new JButton("Clear");
		jclear.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mergText.setText("");
			}
			
		});
		JButton jclose = new JButton("Close");
		jclose.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				emerFrame.dispose();
			}
			
		});
		
		JPanel emerPane = new JPanel();
		emerPane.setLayout(new BorderLayout());
		emerPane.add(jsend, BorderLayout.WEST);
		emerPane.add(jclear,  BorderLayout.CENTER);
		emerPane.add(jclose, BorderLayout.EAST);
		
		JPanel emerPane1 = new JPanel();
		JScrollPane scrollPane = new JScrollPane(mergText);
		emerPane1.add(emerPane,  BorderLayout.CENTER);
		emerFrame.add(mergLabel, BorderLayout.NORTH);
		emerFrame.add(scrollPane,BorderLayout.CENTER);
		emerFrame.add(emerPane1, BorderLayout.SOUTH);
	
		JButton toolButtons = null;
		toolButtons = new JButton("Server Status");
		toolButtons.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				displayInTextArea("Server is offline.");
			}
			
		});
		JToolBar toolBar = new JToolBar();
		toolBar.add(toolButtons, BorderLayout.NORTH);
		
		JPanel contentPane = new JPanel();
		JScrollPane pane = new JScrollPane(textArea);
		contentPane.setLayout(new BorderLayout());
		contentPane.setPreferredSize(new Dimension(400, 100));
		contentPane.add(toolBar, BorderLayout.NORTH);
		contentPane.add(pane, BorderLayout.WEST);
		//pop up reviewing all news reports from users (abusive, scam...etc reports)
		
		JButton buttonReports = new JButton("Reports");
		buttonReports.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				reportFrame.setVisible(true); 
				
			}
			
		});
		
		JButton currentUsers = new JButton("Current users");
		currentUsers.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int number = 420;
				//access the database, request # of online users and post it.
				displayInTextArea("Current online users: " + number); 
			}
			
		});
		
		
		JButton emergencyMessages = new JButton("Emergency Message");
		emergencyMessages.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					emerFrame.setVisible(true);
				}
		});
		toolBar.add(emergencyMessages, BorderLayout.NORTH);
		toolBar.add(buttonReports, BorderLayout.NORTH);
		toolBar.add(currentUsers, BorderLayout.NORTH);
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(contentPane);
		return mainPanel;
		
	}
	
	protected static void displayInTextArea(String actionDescription) {
		textArea.append(actionDescription + newline);
	}
}
