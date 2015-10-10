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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;

public class ServerGui extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	protected JTextField textField;
	protected JTextArea textArea;
	protected JRadioButton homeOwner;
	protected JRadioButton contractor;
	private static final String newline = "\n";

/**
 * CheckStyle is cancer	.
 * @param CheckStyleisCancer.
 */
	public ServerGui() { 
		
		super(new GridLayout(1, 1));

		JTabbedPane tabbedPane = new JTabbedPane();
		ImageIcon icon = createImageIcon("images/Dash.png"); //import your own logo.
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

		JComponent panel5 = createTransactionsPanel();
		tabbedPane.addTab("Transactions", icon, panel5, "Still does nothing");
		tabbedPane.setMnemonicAt(4, KeyEvent.VK_4);

		// Add the tab pane to this panel.
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
	
	protected JComponent makeDashBoard() {
		//JToolBar reportBar = new JToolBar();
		textArea = new JTextArea(10, 20);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		
		JFrame reportFrame = new JFrame("Reports");
		reportFrame.pack();
		reportFrame.setSize(new Dimension(500,250));
		reportFrame.setVisible(false);
		ImageIcon iconReport = createImageIcon("images/Report.png");
		reportFrame.setIconImage(iconReport.getImage());
		
		JComponent reportPane = new JPanel();
		reportPane = makeTextPanel("Date             "
				+ "User             Type             "
				+ "Time issued             Status");
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
		mergLabel.setPreferredSize(new Dimension(5,30));
		mergText.setLineWrap(true);
		mergText.setWrapStyleWord(true);
		
		JButton jsend = new JButton("Send");
		jsend.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				displayInTextArea("Message sent: " + mergText.getText());
				emerFrame.dispose();
			}
		});
		JButton jclear = new JButton("Clear");
		jclear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				mergText.setText("");
			}
			
		});
		JButton jclose = new JButton("Close");
		jclose.addActionListener(new ActionListener(){
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
			public void actionPerformed(ActionEvent arg0) {
				reportFrame.setVisible(true); 
			}
			
		});
		
		JButton currentUsers = new JButton("Current users");
		currentUsers.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				int number = 420;
				//access the database, request # of online users and post it.
				displayInTextArea("Current online users: " + number); 
			}
			
		});
		
		
		JButton emergencyMessages = new JButton("Emergency Message");
		emergencyMessages.addActionListener(new ActionListener() {
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
	
	protected void displayInTextArea(String actionDescription) {
		textArea.append(actionDescription + newline);
	}


	protected JComponent createControlPanel() {

		// SchedulePanel
		/*
		 * CLicking this button will evoke a JDatePicker and JSpinner to allow a
		 * user to set a date and time for the server to restart
		 */
		JPanel schedulePanel = new JPanel(new GridLayout(4, 1));
		JButton btnScheduleReboot = new JButton("Schedule Reboot");
		btnScheduleReboot.addActionListener(this);
		schedulePanel.add(btnScheduleReboot);
		/*
		 * CLicking this button will evoke a JDatePicker and JSpinner to allow a
		 * user to set a date and time for the server to complete an arbitrary
		 * command
		 */
		JButton btnScheduleTask = new JButton("Schedule Task");
		btnScheduleTask.addActionListener(this);
		schedulePanel.add(btnScheduleTask);

		JTextArea txaTask = new JTextArea();
		schedulePanel.add(txaTask);

		// LoginPanel
		JPanel loginPanel = new JPanel(new GridLayout(2, 2));
		JLabel lblUsername = new JLabel("Username");
		JTextField txtUsername = new JTextField();
		JLabel lblPassword = new JLabel("Password");
		JPasswordField txtPassword = new JPasswordField();
		loginPanel.add(lblUsername);
		loginPanel.add(txtUsername);
		loginPanel.add(lblPassword);
		loginPanel.add(txtPassword);

		// ConsolePanel
		JComponent standInConsole = makeTextPanel("Server console");
		JPanel consolePanel = new JPanel(new BorderLayout());
		consolePanel.add(loginPanel, BorderLayout.WEST);
		consolePanel.add(standInConsole, BorderLayout.CENTER);

		// MainPanel
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		mainPanel.add(schedulePanel);
		mainPanel.add(consolePanel, BorderLayout.SOUTH);
		return mainPanel;
	}

	protected JComponent createButtonsSearch() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		JPanel searching = new JPanel();
		searching.setLayout(new GridLayout(1,4));
		
		JTextField searchBar = new JTextField(25);
		searching.add(searchBar);
		JButton search = new JButton();
		search.setText("Search");
		search.addActionListener(new UserListener());
		//search.addActionListener(new ButtonListener());
		searching.add(search);

		homeOwner = new JRadioButton();
		homeOwner.setText("Homeowner");
		homeOwner.setSelected(true);
		ButtonGroup userTypes = new ButtonGroup();
		userTypes.add(homeOwner);
		searching.add(homeOwner);
		contractor = new JRadioButton();
		contractor.setText("Contractor");
		userTypes.add(contractor);
		searching.add(contractor);
		
		panel.add(searching);
		
		JPanel results = new JPanel();
		results.setLayout(new GridLayout(1,1));
		JTable searchResults = new JTable();
		JScrollPane sr = new JScrollPane();
		sr.add(searchResults);
		results.add(sr);
		
		panel.add(results);
        	return panel;
	}

	protected JComponent createButtonsMessages() {
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

	/**
	 * Creates the panel to placed in the Transactions tab of the Server Control
	 * GUI
	 * 
	 * @return the panel to be used.
	 */
	protected JComponent createTransactionsPanel() {
		
		// Users label
		DefaultListModel<String> usersModel = new DefaultListModel<>();
		// Create dummy data for JList
		usersModel.addElement("Bob");
		usersModel.addElement("Susan");
		usersModel.addElement("ConstructionsRUs");
		usersModel.addElement("Bob's Building Builders");
		usersModel.addElement("Bob");
		usersModel.addElement("Susan");
		usersModel.addElement("ConstructionsRUs");
		usersModel.addElement("Bob's Building Builders");
		usersModel.addElement("Bob");
		usersModel.addElement("Susan");
		usersModel.addElement("ConstructionsRUs");
		usersModel.addElement("Bob's Building Builders");
		usersModel.addElement("Bob");
		usersModel.addElement("Susan");
		usersModel.addElement("ConstructionsRUs");
		usersModel.addElement("Bob's Building Builders");

		JList<String> usersList = new JList<>();
		usersList.setModel(usersModel);

		JPanel usersPanel = new JPanel(new BorderLayout());
		JLabel usersLabel = new JLabel("Users:"); // TODO add label to view
		usersPanel.add(usersLabel, BorderLayout.NORTH);
		
		JScrollPane usersScrollPane = new JScrollPane(usersList);
		usersPanel.add(usersScrollPane, BorderLayout.CENTER);
		
		JButton refreshButton = new JButton("Refresh");
		//TODO add click listener
		usersPanel.add(refreshButton, BorderLayout.EAST);
		
		// Transactions Table
		JTable transactionTable = new JTable(new TransactionTableModel());
		transactionTable.setFillsViewportHeight(true);
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(new JScrollPane(transactionTable), BorderLayout.CENTER);
		panel.add(usersPanel, BorderLayout.NORTH);
		return panel;
	}

	@Override
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
		java.net.URL imgUrl = ServerGui.class.getResource(path);
		if (imgUrl != null) {
			return new ImageIcon(imgUrl);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	class TransactionTableModel extends AbstractTableModel {
		private static final long serialVersionUID = 1L;

		private String[] columnNames = { "Home Owner", "Contactor","Transaction #", "Date",
		  "Price" };

		private Object[][] dummyData = {
		  { "Kathy", "Bob's Building", new Integer(1001),
			"Aug 31, 2015", "$120.15" },
		  { "Geroge", "Home Depot", new Integer(1002),
		    "Aug 29, 2015", "$1000.00" },
		  { "Megan", "Constructors", new Integer(1003), 
		    "Aug 30, 2015", "$120.15" },
		  { "Mitch", "Joe's", new Integer(1004), 
		    "Aug 31, 2015", "$120.15"}
		};

		@Override
		public int getColumnCount() {
			return columnNames.length;
		}
		
		@Override
		public String getColumnName(int col) {
            		return columnNames[col];
        	}

		@Override
		public int getRowCount() {
			return dummyData.length;
		}

		@Override
		public Object getValueAt(int row, int col) {
			return dummyData[row][col];
		}
		
		@Override
		public Class<?> getColumnClass(int column) {
			return getValueAt(0, column).getClass();
		}
		
		/*
		 * Possible implementation of resolving transaction issues
		 */
		@Override
		public boolean isCellEditable(int row, int col) {
			return false; // Could return true on different columns.
		}
		
		@Override
		public void setValueAt(Object value, int row, int col) {
			// TODO validation
			dummyData[row][col] = value;
			fireTableCellUpdated(row, col);
		}

	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event dispatch thread.
	 */
	private static void createAndshowgui() {
		// Create and set up the window.
		JFrame frame = new JFrame("Server Control GUI");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add content to the window.
		frame.add(new ServerGui(), BorderLayout.CENTER);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

    	@SuppressWarnings("unused")
	private class ButtonListener implements ActionListener{
    		@Override
        public void actionPerformed(ActionEvent event) {
    			try {
            	//else if( there is nothing typed in the text field){
            	//	System.out.println("You must enter a name to search");
            	//}
            	//else {
            		//search database for that name
            	//}
    			} catch (Exception ex) {
    				System.out.println("Error occured searching "
    								+ "for users with that name");
    			}
    		}
    	}
    
    	private class UserListener implements ActionListener{
    		@Override
        public void actionPerformed(ActionEvent event) {
    			try {
    				System.out.println("Button Pushed");
    				JFrame userInfo = new JFrame("Detail User Info");
    				userInfo.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            	
    				JPanel info = new JPanel();
    				info.setLayout(new GridLayout(3,1));
            	
	            		JPanel editableInfo = new JPanel();
	            		editableInfo.setLayout(new GridLayout(1,4));
            	
	            		JTextField name = new JTextField(25);
	            		name.setText("Barbara Kean");
	            		editableInfo.add(name);
            	
	            		JTextField address = new JTextField(25);
	            		address.setText("123 Main St. Gotham City");
            			editableInfo.add(address);
            	
            			JTextField phone = new JTextField(13);
            			phone.setText("(555)555-5555");
            			editableInfo.add(phone);
            		
            			JTextField email = new JTextField(20);
            			email.setText("mrs.gordon@gcpd.gov");
            			editableInfo.add(email);
            	
            			info.add(editableInfo);
            	
            			JPanel functions = new JPanel();
            			functions.setLayout(new GridLayout(1,3));
            	
            			JButton message = new JButton();
            			message.setText("Send Message");
            			functions.add(message);
            	
            			JButton disable = new JButton();
            			disable.setText("Disable Account");
            			functions.add(disable);
            	
            			JButton reset = new JButton();
            			reset.setText("Reset Password");
            			functions.add(reset);
            	
            			info.add(functions);

            	
            			userInfo.add(info);
            			userInfo.pack();
            			userInfo.setVisible(true);
    			} catch (Exception ex) {
    				System.out.println("Error occured searching "
    									+ "for users "
    									+ "with that name");
    			}
    		}
    	}
    	/**
    	 * CheckStyle is cancer	.
    	 * @param CheckStyleisCancer.
    	 */
	public static void main(String[] args) {
		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// Turn off metal's use of bold fonts
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				createAndshowgui();
			}
		});
	}
}