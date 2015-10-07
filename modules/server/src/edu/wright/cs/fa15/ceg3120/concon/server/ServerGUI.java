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

//package components;
package edu.wright.cs.fa15.ceg3120.concon.server;

/*
 * TabbedPaneDemo.java requires one additional file:
 *   images/middle.gif.
 */
import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ServerGUI extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTextField textField;
	protected JTextArea textArea;
	private final static String newline = "\n";

	public ServerGUI() {
		super(new GridLayout(1, 1));

		JTabbedPane tabbedPane = new JTabbedPane();
		ImageIcon icon = createImageIcon("images/3.png");
		ImageIcon iconDashBoard = createImageIcon("images/Dash.png");
		
		JComponent panel1 = makeDashBoard();
		tabbedPane.addTab("Dash board", iconDashBoard, panel1, "Does nothing");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		JComponent panel2 = createButtonsSearch();
		tabbedPane.addTab("User's info", icon, panel2,
				"Does twice as much nothing");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		JComponent panel3 = createButtonsMessages();
		tabbedPane.addTab("Messages", icon, panel3, "Still does nothing");
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

		JComponent panel4 = createControlPanel();
		panel4.setPreferredSize(new Dimension(410, 50));
		tabbedPane
				.addTab("Remote Control", icon, panel4, "Does nothing at all");
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_5);

		JComponent panel5 = makeTextPanel("Panel #5");
		tabbedPane.addTab("Transactions", icon, panel5, "Still does nothing");
		tabbedPane.setMnemonicAt(4, KeyEvent.VK_4);

		// Add the tabbed pane to this panel.
		add(tabbedPane);

		// The following line enables to use scrolling tabs.
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}

	protected JComponent makeTextPanel(String text) {
		JPanel panel = new JPanel(false);
		JLabel filler = new JLabel(text);
		filler.setHorizontalAlignment(JLabel.CENTER);
		panel.setLayout(new GridLayout(1, 1));
		panel.add(filler);
		
	
		return panel;
	}
	
	protected JComponent makeDashBoard(){
		JPanel mainPanel = new JPanel(new BorderLayout());
		JToolBar toolBar = new JToolBar();
		JToolBar reportBar = new JToolBar();
		textArea = new JTextArea(10, 20);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		JScrollPane Pane = new JScrollPane(textArea);
		JPanel contentPane = new JPanel();
		JComponent reportPane = new JPanel();
		
		JFrame reportFrame = new JFrame("Reports");
		reportFrame.pack();
		reportFrame.setSize(new Dimension(500,250));
		reportFrame.setVisible(false);
		ImageIcon iconReport = createImageIcon("images/Report.png");
		reportFrame.setIconImage(iconReport.getImage());
		reportPane = makeTextPanel("Date             User             Type             Time issued             Status");
		reportFrame.add(reportPane, BorderLayout.NORTH);
		
		JFrame emerFrame = new JFrame("Emergency Message");
		emerFrame.pack();
		emerFrame.setVisible(false);
		emerFrame.setResizable(false);
		emerFrame.setSize(new Dimension(300,150));
		ImageIcon iconMessage = createImageIcon("images/Message.png");
		emerFrame.setIconImage(iconMessage.getImage());
		
		JTextArea mergText = new JTextArea(10, 50);
		JLabel mergLabel = new JLabel("Enter the message:");
		JScrollPane scrollPane = new JScrollPane(mergText);
		mergLabel.setPreferredSize(new Dimension(5,30));
		mergText.setLineWrap(true);
		mergText.setWrapStyleWord(true);
		
		JButton jSend = new JButton("Send");
		jSend.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				displayInTextArea("Message sent: " + mergText.getText());
				emerFrame.dispose();
			}
		});
		JButton jClear = new JButton("Clear");
		jClear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				mergText.setText("");
			}
			
		});
		JButton jClose = new JButton("Close");
		jClose.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				emerFrame.dispose();
			}
			
		});
		
		JPanel emerPane = new JPanel();
		emerPane.setLayout(new BorderLayout());
		emerPane.add(jSend, BorderLayout.WEST);
		emerPane.add(jClear,  BorderLayout.CENTER);
		emerPane.add(jClose, BorderLayout.EAST);
		
		JPanel emerPane1 = new JPanel();
		emerPane1.add(emerPane,  BorderLayout.CENTER);
		
		emerFrame.add(mergLabel, BorderLayout.NORTH);
		emerFrame.add(scrollPane,BorderLayout.CENTER);
		emerFrame.add(emerPane1, BorderLayout.SOUTH);
	
		
		
		contentPane.setLayout(new BorderLayout());
		contentPane.setPreferredSize(new Dimension(400, 100));
		contentPane.add(toolBar, BorderLayout.NORTH);
		contentPane.add(Pane, BorderLayout.WEST);
		
		JButton toolButtons = null;
		toolButtons = new JButton("Server Status");
		toolButtons.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				displayInTextArea("Server is offline.");
			}
			
		});
		toolBar.add(toolButtons, BorderLayout.NORTH);
		
		//pop up reviewing all news reports from users (abusive, scam...etc reports)
		JButton buttonReports = null;
		buttonReports = new JButton("Reports");
		buttonReports.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                reportFrame.setVisible(true);
            }
		});
		JButton currentUsers = null;
		currentUsers = new JButton("Current users");
		currentUsers.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				int number = 420;
				displayInTextArea("Current online users: " + number); //access the database, request # of online users and post it.
			}
			
		});
		
		JButton emergencyMessages = null;
		emergencyMessages = new JButton("Emergency Message");
		emergencyMessages.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                emerFrame.setVisible(true);
            }
		});
		toolBar.add(emergencyMessages, BorderLayout.NORTH);
		toolBar.add(buttonReports, BorderLayout.NORTH);
		toolBar.add(currentUsers, BorderLayout.NORTH);
		mainPanel.add(contentPane);
		return mainPanel;
		
	}
	
	protected void displayInTextArea(String actionDescription) {
		textArea.append(actionDescription + newline);
	}
	
	
	protected JComponent createControlPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        JPanel schedulePanel = new JPanel(new GridLayout(4,1));	
        JPanel consolePanel = new JPanel(new BorderLayout());
        JPanel loginPanel = new JPanel(new GridLayout(2,2));
        
        // SchedulePanel
        /*
         * CLicking this button will evoke a JDatePicker and JSpinner
         * to allow a user to set a date and time for the server to 
         * restart
         */
        JButton btnScheduleReboot = new JButton("Schedule Reboot");
        btnScheduleReboot.addActionListener(this);
        schedulePanel.add(btnScheduleReboot);
        /*
         * CLicking this button will evoke a JDatePicker and JSpinner
         * to allow a user to set a date and time for the server to 
         * complete an arbitrary command 
         */
        JButton btnScheduleTask = new JButton("Schedule Task");
        btnScheduleTask.addActionListener(this);
        schedulePanel.add(btnScheduleTask);
        
        JTextArea txaTask = new JTextArea();
        schedulePanel.add(txaTask);

        JComponent standInConsole = makeTextPanel("Server console");
        
        // LoginPanel
        JLabel lblUsername = new JLabel("Username");
        JTextField txtUsername = new JTextField();
        JLabel lblPassword = new JLabel("Password");
        JPasswordField txtPassword = new JPasswordField();
        loginPanel.add(lblUsername);
        loginPanel.add(txtUsername);
        loginPanel.add(lblPassword);
        loginPanel.add(txtPassword);
        
        // ConsolePanel
        consolePanel.add(loginPanel, BorderLayout.WEST);
        consolePanel.add(standInConsole, BorderLayout.CENTER);
        
        // MainPanel
        mainPanel.setBorder(BorderFactory.createEmptyBorder(0, 0,
                                                0, 0));
        mainPanel.add(schedulePanel);
        mainPanel.add(consolePanel, BorderLayout.SOUTH);
        return mainPanel;
    }

	protected JComponent createButtonsSearch() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.TRAILING));

		JButton button = new JButton("Search");
		button.addActionListener(this);
		panel.add(button);
		JButton button2 = new JButton("Disable");
		button.addActionListener(this);
		panel.add(button2);
		JButton button3 = new JButton("Terminate");
		button.addActionListener(this);
		panel.add(button3);

		button = new JButton("Clear");
		button.addActionListener(this);
		button.setActionCommand("clear");
		panel.add(button);

		panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		return panel;
	}

	protected JComponent createButtonsMessages() {
		JPanel panel = new JPanel(new BorderLayout());
		
		JPanel northPanel = new JPanel();
		
		JPanel usersPanel = new JPanel(new BorderLayout());
		JLabel usersLabel = new JLabel("Users:"); // TODO add label to view
		JList<String> usersList = new JList<>(); 
		DefaultListModel<String> usersModel = new DefaultListModel<>();
		usersModel.addElement("Bob");
		usersModel.addElement("Susan");
		usersModel.addElement("ConstructionsRUs");
		usersModel.addElement("Bob's Building Builders");
		usersList.setModel(usersModel);
		JScrollPane usersScrollPane = new JScrollPane(usersList);
		usersPanel.add(usersLabel, BorderLayout.NORTH);
		usersPanel.add(usersScrollPane, BorderLayout.CENTER);
		northPanel.add(usersPanel);
		
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
		
		JPanel centerPanel = new JPanel(new BorderLayout());
		JLabel messageLabel = new JLabel("Message:");
		JEditorPane messageText = new JEditorPane();
		JScrollPane messageScrollPane = new JScrollPane(messageText);
		centerPanel.add(messageLabel, BorderLayout.NORTH);
		centerPanel.add(messageScrollPane, BorderLayout.CENTER);
		
		JPanel eastPanel = new JPanel();
		button = new JButton("Clear");
		//TODO add listener
		eastPanel.add(button);
		button = new JButton("Send");
		//TODO add listener
		eastPanel.add(button);
		
		panel.add(northPanel, BorderLayout.NORTH);
		panel.add(centerPanel, BorderLayout.CENTER);
		panel.add(eastPanel, BorderLayout.EAST);
		
		return panel;
	}

	public void actionPerformed(ActionEvent evt) {
		String text = textField.getText();
		textArea.append(text + newline);
		textField.selectAll();

		// Make sure the new text is visible, even if there
		// was a selection in the text area.
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = ServerGUI.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
	
	

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event dispatch thread.
	 */
	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("Server Control GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Add content to the window.
		frame.add(new ServerGUI(), BorderLayout.CENTER);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Turn off metal's use of bold fonts
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				createAndShowGUI();
			}
		});
	}
}
