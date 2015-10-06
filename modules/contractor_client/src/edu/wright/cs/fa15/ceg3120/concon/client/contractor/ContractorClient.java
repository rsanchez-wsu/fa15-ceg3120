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

package edu.wright.cs.fa15.ceg3120.concon.client.contractor;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.text.NumberFormatter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class ContractorClient extends JFrame implements ActionListener {

	private JFrame frame;
	private JTextField txtLastName;
	private JTextField txtFirstName;
	private JTextField txtCompanyName;
	private JTextField txtAddress1;
	private JTextField txtAddress2;
	private JTextField txtCity;
	private JTextField txtState;
	private JTextField txtZipCode;
	private JTextField txtLastNameUpdate;
	private JTextField txtFirstNameUpdate;
	private JTextField txtCompanyNameUpdate;
	private JTextField txtAddress1Update;
	private JTextField txtAddress2Update;
	private JTextField txtCityUpdate;
	private JTextField txtStateUpdate;
	private JTextField txtZipCodeUpdate;
	public String strLastName = "Person";
	public String strFirstName = "Random";
	public String strCompanyName = "ConCon";
	public String strAddress1 = "123 Main Street";
	public String strAddress2 = "";
	public String strCity = "Dayton";
	public String strState = "OH";
	public int intZipCode = 45402;
/*	public String strLastName;
	public String strFirstName;
	public String strCompanyName;
	public String strAddress1;
	public String strAddress2;
	public String strCity;
	public String strState;
	public int intZipCode;*/
	private JPanel profileTab;
	private JLabel lblNewProfile;
	private JLabel lblLastNameUpdate;
	private JLabel lblFirstNameUpdate;
	private JLabel lblCompanyNameUpdate;
	private JLabel lblAddress1Update;
	private JLabel lblAddress2Update;
	private JLabel lblCityUpdate;
	private JLabel lblStateUpdate;
	private JLabel lblZipCodeUpdate;
	private JButton btnSave;
	private JButton btnCancel;
	
//	private final Action action = new SwingAction();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContractorClient window = new ContractorClient();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ContractorClient() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 725, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel banner = new JPanel();
		banner.setBounds(6, 0, 703, 127);
		frame.getContentPane().add(banner);
		
		JTabbedPane pageTabs = new JTabbedPane(JTabbedPane.TOP);
		pageTabs.setBounds(6, 127, 703, 309);
		frame.getContentPane().add(pageTabs);
		
		JPanel main = new JPanel();
		pageTabs.addTab("Main", null, main, "Return to main page");
		main.setLayout(null);
		
		JTree mainTree = new JTree();
		mainTree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Main") {
				{
					DefaultMutableTreeNode node_1;
					DefaultMutableTreeNode node_2;
					DefaultMutableTreeNode node_3;
					node_1 = new DefaultMutableTreeNode("Previous Jobs");
						node_2 = new DefaultMutableTreeNode("Electrical");
							node_3 = new DefaultMutableTreeNode("Jan 12 2014");
								node_3.add(new DefaultMutableTreeNode("Description"));
								node_3.add(new DefaultMutableTreeNode("Photos"));
							node_2.add(node_3);
							node_3 = new DefaultMutableTreeNode("Feb 9 2014");
								node_3.add(new DefaultMutableTreeNode("Description"));
								node_3.add(new DefaultMutableTreeNode("Photos"));
							node_2.add(node_3);
						node_1.add(node_2);
						node_2 = new DefaultMutableTreeNode("Plumbing");
							node_3 = new DefaultMutableTreeNode("Mar 24 2015");
								node_3.add(new DefaultMutableTreeNode("Description"));
								node_3.add(new DefaultMutableTreeNode("Photos"));
							node_2.add(node_3);
						node_1.add(node_2);
						node_2 = new DefaultMutableTreeNode("Outdoor");
							node_3 = new DefaultMutableTreeNode("July 17 2015");
								node_3.add(new DefaultMutableTreeNode("Description"));
								node_3.add(new DefaultMutableTreeNode("Photos"));
							node_2.add(node_3);
						node_1.add(node_2);
					node_1 = new DefaultMutableTreeNode("Reviews");
						node_1.add(new DefaultMutableTreeNode("All"));
						node_1.add(new DefaultMutableTreeNode("Positive"));
						node_1.add(new DefaultMutableTreeNode("Negative"));
				}
			}
		));
		main.add(mainTree);
		mainTree.setBounds(6, 6, 160, 275);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(172, 6, 526, 275);
		main.add(textPane);
		
		JPanel curBidsTab = new JPanel();
		pageTabs.addTab("Current Bids", null, curBidsTab, null);
		curBidsTab.setLayout(null);
		NumberFormat numberFormat = NumberFormat.getIntegerInstance();
		NumberFormatter formatter = new NumberFormatter(numberFormat);
		formatter.setAllowsInvalid(false);
		final JFormattedTextField bid = new JFormattedTextField(formatter);
		bid.setBounds(1, 10, 100, 20);
		curBidsTab.add(bid);
		
		
		JPanel notificationsTab = new JPanel();
		pageTabs.addTab("Notifications", null, notificationsTab, null);
		String clientName, jobLocation, jobDate;
		final JLabel[] jobs = new JLabel[10];
		final JButton[] acknowledge = new JButton[10];
		for (int i = 0; i <= 5; i++) {
			final int list = i;
			clientName = "Get name of client from database";
			jobLocation = "Get location from database";
			jobDate = "Get date from database";
			jobs[i] = new JLabel(clientName + " needs work done at " + jobLocation + " on " + jobDate);
			notificationsTab.add(jobs[i]);
			acknowledge[i] = new JButton("Okay");
			notificationsTab.add(acknowledge[i]);
			acknowledge[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Container parent = acknowledge[list].getParent();
					parent.remove(acknowledge[list]);
					parent.remove(jobs[list]);
					parent.validate();
					parent.repaint();
				}				
			});
		}
				
		JPanel searchTab = new JPanel();
		pageTabs.addTab("Search", null, searchTab, null);
		
		JPanel paymentsTab = new JPanel();
		pageTabs.addTab("Payments", null, paymentsTab, null);
		
		profileTab = new JPanel();
		pageTabs.addTab("Edit Profile", null, profileTab, null);
		profileTab.setLayout(null);
		
		populateProfileTab();
		
		JPanel calendarTab = new JPanel();
		pageTabs.addTab("Calendar", null, calendarTab, null);
		
		JPanel openJobsTab = new JPanel();
		pageTabs.addTab("Open Jobs", null, openJobsTab, null);
	}
	
	public void populateProfileTab() {
		JLabel lblCurProfile = new JLabel("Current Profile Settings:");
		profileTab.add(lblCurProfile);
		lblCurProfile.setBounds(30, 5, 200, 20);
		
		JLabel lblFirstName = new JLabel("First Name:");
		profileTab.add(lblFirstName);
		lblFirstName.setBounds(15, 35, 120, 20);
		
		txtFirstName = new JTextField();
		txtFirstName.setEditable(false);
		profileTab.add(txtFirstName);
		txtFirstName.setBounds(145, 35, 120, 20);
				
		JLabel lblLastName = new JLabel("Last Name:");
		profileTab.add(lblLastName);
		lblLastName.setBounds(15, 60, 120, 20);
		
		txtLastName = new JTextField();
		txtLastName.setEditable(false);
		profileTab.add(txtLastName);
		txtLastName.setBounds(145, 60, 120, 20);

		JLabel lblCompanyName = new JLabel("Company Name:");
		profileTab.add(lblCompanyName);
		lblCompanyName.setBounds(15, 85, 120, 20);
		
		txtCompanyName = new JTextField();
		txtCompanyName.setEditable(false);
		profileTab.add(txtCompanyName);
		txtCompanyName.setBounds(145, 85, 120, 20);
		
		JLabel lblAddress1 = new JLabel("Address:");
		profileTab.add(lblAddress1);
		lblAddress1.setBounds(15, 110, 120, 20);
		
		txtAddress1 = new JTextField();
		txtAddress1.setEditable(false);
		profileTab.add(txtAddress1);
		txtAddress1.setBounds(145, 110, 120, 20);
		
		JLabel lblAddress2 = new JLabel("Address (cont):");
		profileTab.add(lblAddress2);
		lblAddress2.setBounds(15, 135, 120, 20);
		
		txtAddress2 = new JTextField();
		txtAddress2.setEditable(false);
		profileTab.add(txtAddress2);
		txtAddress2.setBounds(145, 135, 120, 20);
		
		JLabel lblCity = new JLabel("City:");
		profileTab.add(lblCity);
		lblCity.setBounds(15, 160, 120, 20);
		
		txtCity = new JTextField();
		txtCity.setEditable(false);
		profileTab.add(txtCity);
		txtCity.setBounds(145, 160, 120, 20);
		
		JLabel lblState = new JLabel("State:");
		profileTab.add(lblState);
		lblState.setBounds(15, 185, 120, 20);
		
		txtState = new JTextField();
		txtState.setEditable(false);
		profileTab.add(txtState);
		txtState.setBounds(145, 185, 120, 20);
		
		JLabel lblZipCode = new JLabel("Zip Code:");
		profileTab.add(lblZipCode);
		lblZipCode.setBounds(15, 210, 120, 20);
		
		txtZipCode = new JTextField();
		txtZipCode.setEditable(false);
		profileTab.add(txtZipCode);
		txtZipCode.setBounds(145, 210, 120, 20);
		
		lblNewProfile = new JLabel("Updated Profile Settings:");
		profileTab.add(lblNewProfile);		
		lblNewProfile.setBounds(360, 5, 200, 20);
		lblNewProfile.setVisible(false);
		
		lblFirstNameUpdate = new JLabel("First Name:");
		profileTab.add(lblFirstNameUpdate);
		lblFirstNameUpdate.setBounds(345, 35, 120, 20);
		lblFirstNameUpdate.setVisible(false);
		
		txtFirstNameUpdate = new JTextField();
		profileTab.add(txtFirstNameUpdate);
		txtFirstNameUpdate.setBounds(475, 35, 120, 20);
		txtFirstNameUpdate.setVisible(false);
				
		lblLastNameUpdate = new JLabel("Last Name:");
		profileTab.add(lblLastNameUpdate);
		lblLastNameUpdate.setBounds(345, 60, 120, 20);
		lblLastNameUpdate.setVisible(false);
		
		txtLastNameUpdate = new JTextField();
		profileTab.add(txtLastNameUpdate);
		txtLastNameUpdate.setBounds(475, 60, 120, 20);
		txtLastNameUpdate.setVisible(false);

		lblCompanyNameUpdate = new JLabel("Company Name:");
		profileTab.add(lblCompanyNameUpdate);
		lblCompanyNameUpdate.setBounds(345, 85, 120, 20);
		lblCompanyNameUpdate.setVisible(false);
		
		txtCompanyNameUpdate = new JTextField();
		profileTab.add(txtCompanyNameUpdate);
		txtCompanyNameUpdate.setBounds(475, 85, 120, 20);
		txtCompanyNameUpdate.setVisible(false);
		
		lblAddress1Update = new JLabel("Address:");
		profileTab.add(lblAddress1Update);
		lblAddress1Update.setBounds(345, 110, 120, 20);
		lblAddress1Update.setVisible(false);
		
		txtAddress1Update = new JTextField();
		profileTab.add(txtAddress1Update);
		txtAddress1Update.setBounds(475, 110, 120, 20);
		txtAddress1Update.setVisible(false);
		
		lblAddress2Update = new JLabel("Address (cont):");
		profileTab.add(lblAddress2Update);
		lblAddress2Update.setBounds(345, 135, 120, 20);
		lblAddress2Update.setVisible(false);
		
		txtAddress2Update = new JTextField();
		profileTab.add(txtAddress2Update);
		txtAddress2Update.setBounds(475, 135, 120, 20);
		txtAddress2Update.setVisible(false);
		
		lblCityUpdate = new JLabel("City:");
		profileTab.add(lblCityUpdate);
		lblCityUpdate.setBounds(345, 160, 120, 20);
		lblCityUpdate.setVisible(false);
		
		txtCityUpdate = new JTextField();
		profileTab.add(txtCityUpdate);
		txtCityUpdate.setBounds(475, 160, 120, 20);
		txtCityUpdate.setVisible(false);
		
		lblStateUpdate = new JLabel("State:");
		profileTab.add(lblStateUpdate);
		lblStateUpdate.setBounds(345, 185, 120, 20);
		lblStateUpdate.setVisible(false);
		
		txtStateUpdate = new JTextField();
		profileTab.add(txtStateUpdate);
		txtStateUpdate.setBounds(475, 185, 120, 20);
		txtStateUpdate.setVisible(false);
		
		lblZipCodeUpdate = new JLabel("Zip Code:");
		profileTab.add(lblZipCodeUpdate);
		lblZipCodeUpdate.setBounds(345, 210, 120, 20);
		lblZipCodeUpdate.setVisible(false);
		
		txtZipCodeUpdate = new JTextField();
		profileTab.add(txtZipCodeUpdate);
		txtZipCodeUpdate.setBounds(475, 210, 120, 20);
		txtZipCodeUpdate.setVisible(false);
		
		JButton btnLoad = new JButton("Load Profile");
		profileTab.add(btnLoad);
		btnLoad.setBounds(145, 247, 120, 23);
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadProfile();
			}
		});
		
		btnSave = new JButton("Save Changes");
		profileTab.add(btnSave);
		btnSave.setBounds(345, 247, 120, 23);
		btnSave.setVisible(false);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveProfileUpdates();
			}
		});
		
		btnCancel = new JButton("Cancel");
		profileTab.add(btnCancel);
		btnCancel.setBounds(475, 247, 120, 23);
		btnCancel.setVisible(false);		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearProfileUpdates();
			}
		});
	}
	
	public void loadProfile() {
		lblNewProfile.setVisible(true);
		lblLastNameUpdate.setVisible(true);
		lblFirstNameUpdate.setVisible(true);
		lblCompanyNameUpdate.setVisible(true);
		lblAddress1Update.setVisible(true);
		lblAddress2Update.setVisible(true);
		lblCityUpdate.setVisible(true);
		lblStateUpdate.setVisible(true);
		lblZipCodeUpdate.setVisible(true);
		txtLastNameUpdate.setVisible(true);
		txtFirstNameUpdate.setVisible(true);
		txtCompanyNameUpdate.setVisible(true);
		txtAddress1Update.setVisible(true);
		txtAddress2Update.setVisible(true);
		txtCityUpdate.setVisible(true);
		txtStateUpdate.setVisible(true);
		txtZipCodeUpdate.setVisible(true);
		btnSave.setVisible(true);
		btnCancel.setVisible(true);
		txtLastName.setText(strLastName);
		txtFirstName.setText(strFirstName);
		txtCompanyName.setText(strCompanyName);
		txtAddress1.setText(strAddress1);
		txtAddress2.setText(strAddress2);
		txtCity.setText(strCity);
		txtState.setText(strState);
		txtZipCode.setText(String.format("%05d", intZipCode));
		profileTab.revalidate();
	}
	
	public void clearProfileUpdates() {
		txtLastNameUpdate.setText(null);
		txtFirstNameUpdate.setText(null);
		txtCompanyNameUpdate.setText(null);
		txtAddress1Update.setText(null);
		txtAddress2Update.setText(null);
		txtCityUpdate.setText(null);
		txtStateUpdate.setText(null);
		txtZipCodeUpdate.setText(null);
	}
	
	public void saveProfileUpdates() {
		if (txtLastNameUpdate.getText().length() < 1) {	
		} else {
			strLastName = txtLastNameUpdate.getText();			
		}
		if (txtFirstNameUpdate.getText().length() < 1) {
		} else {
			strFirstName = txtFirstNameUpdate.getText();	
		}
		if (txtCompanyNameUpdate.getText().length() < 1) {
		} else {
			strCompanyName = txtCompanyNameUpdate.getText();	
		}
		if (txtAddress1Update.getText().length() < 1) {
		} else {
			strAddress1 = txtAddress1Update.getText();			
		}
		if (txtAddress2Update.getText().length() < 1) {
		} else {
			strAddress2 = txtAddress2Update.getText();
		}
		if (txtCityUpdate.getText().length() < 1) {
		} else {
			strCity = txtCityUpdate.getText();
		}
		if (txtStateUpdate.getText().length() < 1) {
		} else {
			strState = txtStateUpdate.getText();
		}
		if (txtZipCodeUpdate.getText().length() < 1) {
		} else {
			int issueChecker = 0;
			if (txtZipCodeUpdate.getText().length() != 5)
			{
				issueChecker = 1;
			}
			for (int i=0; i<txtZipCodeUpdate.getText().length(); i++) {
				char c = txtZipCodeUpdate.getText().charAt(i);
				if (Character.isDigit(c)) {
				} else {
					issueChecker = 1;
				}
			}
			while (issueChecker > 0) {
				String strTestZipCode = JOptionPane.showInputDialog(profileTab, "Please enter a valid Zip Code", null);
				if (strTestZipCode.length() != 5)
				{
					issueChecker = 1;
				}
				else {
					for (int j=0; j<strTestZipCode.length(); j++) {
						char c1 = strTestZipCode.charAt(j);
						if (Character.isDigit(c1)) {
							if (j >= strTestZipCode.length()-1) {
								txtZipCodeUpdate.setText(strTestZipCode);
								issueChecker = 0;
							}
						}					
					}					
				}

			}
			intZipCode = Integer.parseInt(txtZipCodeUpdate.getText());	
		}
		loadProfile();
		profileTab.revalidate();
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		
	}
	
	
/*	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}*/
}
//>>>>>>> branch 'Contractor-GUI' of https://github.com/rsanchez-wsu/fa15-ceg3120.git
