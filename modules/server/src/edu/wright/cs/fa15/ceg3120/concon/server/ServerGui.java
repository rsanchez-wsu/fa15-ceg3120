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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
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
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;

/**
 * 1.
 * */
public class ServerGui extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	public JTextField textField;
	public JTextArea textArea;
	public JRadioButton homeOwner;
	public JRadioButton contractor;
	public static final String newline = "\n";

/**
 * main GUI class call sub classes to form components.
 * @param GUIcomponents
 * 
 */
	public ServerGui() { 
		
		super(new GridLayout(1, 1));

		JTabbedPane tabbedPane = new JTabbedPane();
		
		tabbedPane.addTab("Dash board", CreateImageIcon.iconDashBoard, 
						MakeDashBoard.panelDashBoard, "Does nothing");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);


		JComponent panel2 = new CreateButtonsSearch();
		tabbedPane.addTab("User's info", CreateImageIcon.icon, panel2,
						"Does twice as much nothing");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		JComponent panel3 = createButtonsMessages();
		tabbedPane.addTab("Messages", CreateImageIcon.icon, panel3, "Still does nothing");
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

		JComponent panel4 = createControlPanel();
		panel4.setPreferredSize(new Dimension(410, 50));
		tabbedPane.addTab("Remote Control", CreateImageIcon.icon, 
						panel4, "Does nothing at all");
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_5);

		JComponent panel5 = createTransactionsPanel();
		tabbedPane.addTab("Transactions", CreateImageIcon.icon, 
						panel5, "Still does nothing");
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
	
	/**
	 * Not sure this name makes sense.
	 */
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
	
	/**
	 * Default class model for Transaction Table.
	 */
	static class TransactionTableModel extends AbstractTableModel {
		/**
		 * Default class model for Transaction Table.
		 */
		private static final long serialVersionUID = 1L;

		private String[] columnNames = { "Home Owner", "Contactor","Transaction #", "Date",
		 	"Price" };

		private Object[][] dummyData = {
			{ "Kathy", "Bob's Building", Integer.valueOf(1001),
			"Aug 31, 2015", "$120.15" },
			{ "Geroge", "Home Depot", Integer.valueOf(1002),
			"Aug 29, 2015", "$1000.00" },
			{ "Megan", "Constructors", Integer.valueOf(1003), 
			"Aug 30, 2015", "$120.15" },
			{ "Mitch", "Joe's", Integer.valueOf(1004), 
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
	
		/**
    	 * Main class.
    	 * @param GUICreateandShow
    	 * 
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