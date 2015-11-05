/**
 * 
 */
package edu.wright.cs.fa15.ceg3120.concon.server;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author jkern
 * Provides the interface to be added to a tab in ServerGui to
 * allow control of the Con^2 project database
 *
 */
public class DatabaseControlTab {

	/**
	 * @param args
	 */
	public static JComponent createDBControlTab(){
		
		// SchedulePanel
		/*
		 * CLicking this button will evoke a JDatePicker and JSpinner to allow a
		 * user to set a date and time for the server to restart
		 */
		JPanel schedulePanel = new JPanel(new GridLayout(4, 1));
		JButton btnScheduleReboot = new JButton("Schedule Reboot");
//		btnScheduleReboot.addActionListener(this);
		schedulePanel.add(btnScheduleReboot);
		/*
		 * CLicking this button will evoke a JDatePicker and JSpinner to allow a
		 * user to set a date and time for the server to complete an arbitrary
		 * command
		 */
		JButton btnScheduleTask = new JButton("Schedule Task");
//		btnScheduleTask.addActionListener(this);
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
	 * Makes and returns a Textpanel Jcomponent.
	 */
	protected static JComponent makeTextPanel(String text) {
		JPanel panel = new JPanel(false);
		JLabel filler = new JLabel(text);
		filler.setHorizontalAlignment(JLabel.CENTER);
		panel.setLayout(new GridLayout(1, 1));
		panel.add(filler);
		return panel;
	}
}
