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

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JSplitPane;
import javax.swing.JEditorPane;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class ContractorClient {

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
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(172, 6, 526, 275);
		main.add(textPane);
		
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
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Reviews");
						node_1.add(new DefaultMutableTreeNode("All"));
						node_1.add(new DefaultMutableTreeNode("Positive"));
						node_1.add(new DefaultMutableTreeNode("Negative"));
					add(node_1);
				}
			}
		));
		mainTree.setBounds(6, 6, 160, 275);
		main.add(mainTree);
		
		JPanel curBidsTab = new JPanel();
		pageTabs.addTab("Current Bids", null, curBidsTab, null);
		
		JPanel notificationsTab = new JPanel();
		pageTabs.addTab("Notifications", null, notificationsTab, null);
		
		JPanel searchTab = new JPanel();
		pageTabs.addTab("Search", null, searchTab, null);
		
		JPanel paymentsTab = new JPanel();
		pageTabs.addTab("Payments", null, paymentsTab, null);
		
		JPanel profileTab = new JPanel();
		pageTabs.addTab("Edit Profile", null, profileTab, null);
		profileTab.setLayout(null);
		
		JLabel lblCurProfile = new JLabel("Current Profile Settings:");
		lblCurProfile.setBounds(30, 5, 200, 20);
		profileTab.add(lblCurProfile);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(15, 35, 120, 20);
		profileTab.add(lblLastName);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(145, 35, 120, 20);
		profileTab.add(txtLastName);
		txtLastName.setColumns(1);
		txtLastName.setText(strLastName);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(15, 60, 120, 20);
		profileTab.add(lblFirstName);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(145, 60, 120, 20);
		profileTab.add(txtFirstName);
		txtFirstName.setColumns(1);
		txtFirstName.setText(strFirstName);
		
		JLabel lblCompanyName = new JLabel("Company Name:");
		lblCompanyName.setBounds(15, 85, 120, 20);
		profileTab.add(lblCompanyName);
		
		txtCompanyName = new JTextField();
		txtCompanyName.setBounds(145, 85, 120, 20);
		profileTab.add(txtCompanyName);
		txtCompanyName.setColumns(1);
		txtCompanyName.setText(strCompanyName);
		
		JLabel lblAddress1 = new JLabel("Address:");
		lblAddress1.setBounds(15, 110, 120, 20);
		profileTab.add(lblAddress1);
		
		txtAddress1 = new JTextField();
		txtAddress1.setBounds(145, 110, 120, 20);
		profileTab.add(txtAddress1);
		txtAddress1.setColumns(1);
		txtAddress1.setText(strAddress1);
		
		JLabel lblAddress2 = new JLabel("Address (cont):");
		lblAddress2.setBounds(15, 135, 120, 20);
		profileTab.add(lblAddress2);
		
		txtAddress2 = new JTextField();
		txtAddress2.setBounds(145, 135, 120, 20);
		profileTab.add(txtAddress2);
		txtAddress2.setColumns(1);
		txtAddress2.setText(strAddress2);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setBounds(15, 160, 120, 20);
		profileTab.add(lblCity);
		
		txtCity = new JTextField();
		txtCity.setBounds(145, 160, 120, 20);
		profileTab.add(txtCity);
		txtCity.setColumns(1);
		txtCity.setText(strCity);
		
		JLabel lblState = new JLabel("State:");
		lblState.setBounds(15, 185, 120, 20);
		profileTab.add(lblState);
		
		txtState = new JTextField();
		txtState.setBounds(145, 185, 120, 20);
		profileTab.add(txtState);
		txtState.setColumns(1);
		txtState.setText(strState);
		
		JLabel lblZipCode = new JLabel("Zip Code:");
		lblZipCode.setBounds(15, 210, 120, 20);
		profileTab.add(lblZipCode);
		
		txtZipCode = new JTextField();
		txtZipCode.setBounds(145, 210, 120, 20);
		profileTab.add(txtZipCode);
		txtZipCode.setColumns(1);
		txtZipCode.setText(Integer.toString(intZipCode));
		JLabel lblNewProfile = new JLabel("Updated Profile Settings:");
		lblNewProfile.setBounds(360, 5, 200, 20);
		profileTab.add(lblNewProfile);		
		
		JLabel lblLastNameUpdate = new JLabel("Last Name:");
		lblLastNameUpdate.setBounds(345, 35, 120, 20);
		profileTab.add(lblLastNameUpdate);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(475, 35, 120, 20);
		profileTab.add(txtLastName);
		txtLastName.setColumns(1);
		
		JLabel lblFirstNameUpdate = new JLabel("First Name:");
		lblFirstNameUpdate.setBounds(345, 60, 120, 20);
		profileTab.add(lblFirstNameUpdate);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(475, 60, 120, 20);
		profileTab.add(txtFirstName);
		txtFirstName.setColumns(1);
		
		JLabel lblCompanyNameUpdate = new JLabel("Company Name:");
		lblCompanyNameUpdate.setBounds(345, 85, 120, 20);
		profileTab.add(lblCompanyNameUpdate);
		
		txtCompanyName = new JTextField();
		txtCompanyName.setBounds(475, 85, 120, 20);
		profileTab.add(txtCompanyName);
		txtCompanyName.setColumns(1);
		
		JLabel lblAddress1Update = new JLabel("Address:");
		lblAddress1Update.setBounds(345, 110, 120, 20);
		profileTab.add(lblAddress1Update);
		
		txtAddress1 = new JTextField();
		txtAddress1.setBounds(475, 110, 120, 20);
		profileTab.add(txtAddress1);
		txtAddress1.setColumns(1);
		
		JLabel lblAddress2Update = new JLabel("Address (cont):");
		lblAddress2Update.setBounds(345, 135, 120, 20);
		profileTab.add(lblAddress2Update);
		
		txtAddress2 = new JTextField();
		txtAddress2.setBounds(475, 135, 120, 20);
		profileTab.add(txtAddress2);
		txtAddress2.setColumns(1);
		
		JLabel lblCityUpdate = new JLabel("City:");
		lblCityUpdate.setBounds(345, 160, 120, 20);
		profileTab.add(lblCityUpdate);
		
		txtCity = new JTextField();
		txtCity.setBounds(475, 160, 120, 20);
		profileTab.add(txtCity);
		txtCity.setColumns(1);
		
		JLabel lblStateUpdate = new JLabel("State:");
		lblStateUpdate.setBounds(345, 185, 120, 20);
		profileTab.add(lblStateUpdate);
		
		txtState = new JTextField();
		txtState.setBounds(475, 185, 120, 20);
		profileTab.add(txtState);
		txtState.setColumns(1);
		
		JLabel lblZipCodeUpdate = new JLabel("Zip Code:");
		lblZipCodeUpdate.setBounds(345, 210, 120, 20);
		profileTab.add(lblZipCodeUpdate);
		
		txtZipCode = new JTextField();
		txtZipCode.setBounds(475, 210, 120, 20);
		profileTab.add(txtZipCode);
		txtZipCode.setColumns(1);
		
		JButton btnSave = new JButton("Save Changes");
		btnSave.setBounds(345, 247, 120, 23);
		profileTab.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clear();
			}
		});
		btnCancel.setBounds(475, 247, 120, 23);
		profileTab.add(btnCancel);
		
		JPanel calendarTab = new JPanel();
		pageTabs.addTab("Calendar", null, calendarTab, null);
		
		JPanel openJobsTab = new JPanel();
		pageTabs.addTab("Open Jobs", null, openJobsTab, null);
	}
	
	public void clear(){
//		txtLastNameUpdate.setText(null);
//		txtFirstNameUpdate.setText(null);
//		txtCompanyNameUpdate.setText(null);
//		txtAddress1Update.setText(null);
//		txtAddress2Update.setText(null);
//		txtCityUpdate.setText(null);
//		txtStateUpdate.setText(null);
//		txtZipCodeUpdate.setText(null);
	}
}