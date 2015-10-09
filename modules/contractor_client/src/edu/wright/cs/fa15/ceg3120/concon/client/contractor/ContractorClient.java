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


import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ContractorClient extends JFrame implements ActionListener {


	private static final long serialVersionUID = 1L;
	private static JFrame frame;
	private static JLabel lblShowCurLastName;
	private static JLabel lblShowCurFirstName;
	private static JLabel lblShowCurCompanyName;
	private static JLabel lblShowCurAddress1;
	private static JLabel lblShowCurAddress2;
	private static JLabel lblShowCurCity;
	private static JLabel lblShowCurState;
	private static JLabel lblShowCurZipCode;
	private static JTextField txtLastNameUpdate;
	private static JTextField txtFirstNameUpdate;
	private static JTextField txtCompanyNameUpdate;
	private static JTextField txtAddress1Update;
	private static JTextField txtAddress2Update;
	private static JTextField txtCityUpdate;
	private static JTextField txtStateUpdate;
	private static JTextField txtZipCodeUpdate;
	private static String strLastName = "Person";
	private static String strFirstName = "Random";
	private static String strCompanyName = "ConCon";
	private static String strAddress1 = "123 Main Street";
	private static String strAddress2 = "";
	private static String strCity = "Dayton";
	private static String strState = "OH";
	private static int intZipCode = 45400;
	private static JPanel profileTab;
	private static JLabel lblNewProfile;
	private static JLabel lblLastNameUpdate;
	private static JLabel lblFirstNameUpdate;
	private static JLabel lblCompanyNameUpdate;
	private static JLabel lblAddress1Update;
	private static JLabel lblAddress2Update;
	private static JLabel lblCityUpdate;
	private static JLabel lblStateUpdate;
	private static JLabel lblZipCodeUpdate;
	private static JButton btnSave;
	private static JButton btnCancel;
	private static JButton btnClear;
	private static String[] job1;
	private static String[] job2;
	private static String[] job3;
	private static String[] job4;
	private static Vector<String[]> jobList = new Vector<String[]>();
	private static int intSearch = 0;
	private static String[] columnNames = {"Job Number", "Title", "Description", "City", "Cost", 
										   "Duration", "Zip Code"};
	private static DefaultTableModel model1 = null;
	
	/**
	 * Create the application.
	 */
	public ContractorClient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private static void initialize() {
		frame = new JFrame();		
		frame.setBounds(100, 100, 725, 475);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		Container c0 = frame.getContentPane();
		c0.setBackground(Color.orange);
		ImageIcon imgIcon = new ImageIcon("images/c2-icon.png");
		frame.setIconImage(imgIcon.getImage());
		frame.setTitle("Contractor Connect");
		frame.addWindowListener(new WindowAdapter() {
			@Override
		    public void windowClosing(WindowEvent w0) { 
		        int exit = JOptionPane.showConfirmDialog(frame, "Do you want to exit?");
		        if (exit == JOptionPane.YES_OPTION) {
		            System.exit(0);
		        }
		    }
		});
		frame.getContentPane().setLayout(null);

		JPanel banner = new JPanel();
		banner.setBounds(6, 0, 703, 127);
//		BufferedImage logo = new BufferedImage(127, 127, BufferedImage.TYPE_INT_RGB);
		ImageIcon imageIcon = new ImageIcon("images/c2-image.png");
		Image image = imageIcon.getImage();
		Image newImg = image.getScaledInstance(127, 127, java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newImg);		
		JLabel picLabel = new JLabel(imageIcon);
		banner.add(picLabel);	
		picLabel.setOpaque(true);
		picLabel.setBackground(Color.darkGray);

		frame.getContentPane().add(banner);
		banner.setOpaque(false);
		JTabbedPane pageTabs = new JTabbedPane(JTabbedPane.TOP);
		pageTabs.setBounds(6, 127, 703, 309);
		frame.getContentPane().add(pageTabs);

		JPanel main = new JPanel();
		pageTabs.addTab("Main", null, main, "Return to main page");
		main.setLayout(null);

		JTree mainTree = new JTree();
		mainTree.setModel(new DefaultTreeModel(
						new DefaultMutableTreeNode("Main") {
							/**
							 * Create the tree.
							 */
							private static final long serialVersionUID = 1L;

							{
								DefaultMutableTreeNode node1;
								DefaultMutableTreeNode node2;
								DefaultMutableTreeNode node3;
								node1 = new DefaultMutableTreeNode("Previous Jobs");
								node2 = new DefaultMutableTreeNode("Electrical");
								node3 = new DefaultMutableTreeNode("Jan 12 2014");
								node3.add(new DefaultMutableTreeNode("Description"));
								node3.add(new DefaultMutableTreeNode("Photos"));
								node2.add(node3);
								node3 = new DefaultMutableTreeNode("Feb 9 2014");
								node3.add(new DefaultMutableTreeNode("Description"));
								node3.add(new DefaultMutableTreeNode("Photos"));
								node2.add(node3);
								node1.add(node2);
								node2 = new DefaultMutableTreeNode("Plumbing");
								node3 = new DefaultMutableTreeNode("Mar 24 2015");
								node3.add(new DefaultMutableTreeNode("Description"));
								node3.add(new DefaultMutableTreeNode("Photos"));
								node2.add(node3);
								node1.add(node2);
								node2 = new DefaultMutableTreeNode("Outdoor");
								node3 = new DefaultMutableTreeNode("Jul 17 2015");
								node3.add(new DefaultMutableTreeNode("Description"));
								node3.add(new DefaultMutableTreeNode("Photos"));
								node2.add(node3);
								node1.add(node2);
								add(node1);
								node1 = new DefaultMutableTreeNode("Reviews");
								node1.add(new DefaultMutableTreeNode("All"));
								node1.add(new DefaultMutableTreeNode("Positive"));
								node1.add(new DefaultMutableTreeNode("Negative"));
								add(node1);
								}
							}
		));
		main.add(mainTree);
		mainTree.setBounds(6, 6, 160, 275);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(172, 6, 526, 275);
		main.add(textPane);

		final JPanel curBidsTab = new JPanel();
		pageTabs.addTab("Current Bids", null, curBidsTab, null);
		GridLayout myLayout = new GridLayout(0, 2);
		curBidsTab.setLayout(myLayout);
		final DecimalFormat f0 = new DecimalFormat("##.00");
		final JLabel[] currentBids = new JLabel[10];
		final JButton[] update = new JButton[10];
		for (int i = 0; i < 5; i++) {
			final int j = i;
			currentBids[i] = new JLabel("You have a bid for " + f0.format(Math.random() * 115));
			curBidsTab.add(currentBids[i]);
			update[i] = new JButton("Update Bid");
			curBidsTab.add(update[i]);
			
			update[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent a0) {
					try {
						String input = JOptionPane.showInputDialog(frame, "Enter new bid");
						if (input != null) {
							double newBid = Double.parseDouble(input);
							currentBids[j].setText("You have a bid for " + f0.format(newBid));
							curBidsTab.validate();
							curBidsTab.repaint();
						}
						
					} catch (IllegalArgumentException e) {
						JOptionPane.showMessageDialog(frame, "Invalid Input");
					}

				}

			});
		}

		JPanel notificationsTab = new JPanel();
		pageTabs.addTab("Notifications", null, notificationsTab, null);
		String clientName;
		String jobLocation;
		String jobDate;
		final JLabel[] jobs = new JLabel[10];
		final JButton[] acknowledge = new JButton[10];
		for (int i = 0; i <= 5; i++) {
			final int list = i;
			clientName = "Get name of client from database";
			jobLocation = "Get location from database";
			jobDate = "Get date from database";
			jobs[i] = new JLabel(clientName + " needs work done at " 
					+ jobLocation + " on " + jobDate);
			notificationsTab.add(jobs[i]);
			acknowledge[i] = new JButton("Okay");
			notificationsTab.add(acknowledge[i]);
			acknowledge[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e0) {
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
		searchTab.setLayout(null);
		
		populateJobListArray();
		
		JLabel lblSearchTabMain = new JLabel("Search Options:");
		searchTab.add(lblSearchTabMain);
		lblSearchTabMain.setBounds(5,5,120,20);
		String[] searchOptions = {"Show All", "Distance", "Max Cost", "Max Duration"};
		final JComboBox<String> cboSearchOptions = new JComboBox<String>(searchOptions);
		searchTab.add(cboSearchOptions);
		cboSearchOptions.setBounds(140, 5, 120, 20);
		cboSearchOptions.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e1) {
//				final String strTest = cboSearchOptions.getSelectedItem().toString();
				switch (cboSearchOptions.getSelectedItem().toString()) {
				case "Show All":
					intSearch = 0;
					break;
				case "Distance":
					intSearch = 1;
					break;
				case "Max Cost":
					intSearch = 2;
					break;
				case "Max Duration":
					intSearch = 3;
					break;
				default:
					intSearch = 0;
					break;
				}
				
			}
		});
		
		buildTable();
		final JTable tblSearchResults = new JTable(model1);
		tblSearchResults.setModel(model1);
		JScrollPane jscSearchResults = new JScrollPane(tblSearchResults);
		jscSearchResults.setBounds(45, 45, 605, 200);
		searchTab.add(jscSearchResults);		
		
		final JTextField txtSearchOptions = new JTextField();
		txtSearchOptions.setBounds(275, 5, 240, 20);
		searchTab.add(txtSearchOptions);
		
		JButton btnSearchGo = new JButton("Search");
		btnSearchGo.setBounds(530, 5, 120, 20);
		searchTab.add(btnSearchGo);
		
		btnSearchGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				columnNames[6] = "Zip Code";
				buildTable();
				tblSearchResults.setModel(model1);
				tblSearchResults.validate();
				tblSearchResults.repaint();
				populateJobListArray();
				model1.setRowCount(0);
				switch (intSearch) {
				case 0:
					columnNames[6] = "Zip Code";
					for (int i = 0; i < jobList.size(); i++) {
						String[] tempArray = jobList.elementAt(i);
						model1.addRow(tempArray);
					}	
					break;
				case 1:
					columnNames[6] = "Distance";
					buildTable();
					tblSearchResults.setModel(model1);
					tblSearchResults.validate();
					tblSearchResults.repaint();
					populateJobListArray();
					final String tempDistance = txtSearchOptions.getText();
					double curDistance = 0;
					int tempDistanceInt = 0;
					if (tempDistance.length() > 0) {
						tempDistanceInt = Integer.parseInt(tempDistance);
					}
					for (int i = 0; i < jobList.size(); i++) {
						String[] tempArray = null;
						tempArray = jobList.elementAt(i);
						try {
							curDistance = distanceCalculator(intZipCode, 
									Integer.parseInt(tempArray[6]));
						} catch (NumberFormatException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
						if (curDistance <= tempDistanceInt) {
							String[] newArray = tempArray;
							newArray[6] = (f0.format(curDistance));
							model1.addRow(newArray);
						}
					}
					break;
				case 2:
					final String tempCost = txtSearchOptions.getText(); 
					int tempCostInt = 0;
					if (tempCost.length() > 0) {
						tempCostInt = Integer.parseInt(tempCost);
					}
					for (int i = 0; i < jobList.size(); i++) {
						String[] tempArray = jobList.elementAt(i);
						if (Integer.parseInt(tempArray[4]) <= tempCostInt) {
							model1.addRow(tempArray);
						}
					}
					break;
				case 3:
					final String tempDuration = txtSearchOptions.getText();
					int tempDurationInt = 0;
					if (tempDuration.length() > 0) {
						tempDurationInt = Integer.parseInt(tempDuration);
					}
					for (int i = 0; i < jobList.size(); i++) {
						String[] tempArray = jobList.elementAt(i);
						if (Integer.parseInt(tempArray[5]) <= tempDurationInt) {
							model1.addRow(tempArray);
						}
					}
					break;
				default:
					model1.setRowCount(0);
					for (int i = 0; i < jobList.size(); i++) {
						String[] tempArray = jobList.elementAt(i);
						model1.addRow(tempArray);
					}	
					break;
				}
			}
		});
		
		JPanel paymentsTab = new JPanel();
		pageTabs.addTab("Payments", null, paymentsTab, null);
		paymentsTab.setLayout(null);
		
		JLabel paymentsSearchLabel = new JLabel("Search job number:");
		paymentsTab.add(paymentsSearchLabel);
		paymentsSearchLabel.setBounds(5,5,120,20);
		
		JButton paymentsSearchButton = new JButton("Search");
		paymentsSearchButton.setBounds(530, 5, 120, 20);
		paymentsTab.add(paymentsSearchButton);
		
		final JTextField paymentsSearchOptions = new JTextField();
        paymentsSearchOptions.setBounds(275, 5, 240, 20);
		paymentsTab.add(paymentsSearchOptions);
		
		String[] columnName = {"Job Number", "Cost", "Payments", "Balance"};
        final DefaultTableModel payments = new DefaultTableModel(columnName, 0);
        JTable tblPaymentsResults2 = new JTable(payments);
        tblPaymentsResults2.setModel(payments);
        JScrollPane paymentsResults = new JScrollPane(tblPaymentsResults2);
        paymentsResults.setBounds(45, 45, 605, 100);
        paymentsTab.add(paymentsResults);
        	
		profileTab = new JPanel();
		pageTabs.addTab("Edit Profile", null, profileTab, null);
		profileTab.setLayout(null);

		populateProfileTab();

		JPanel calendarTab = new JPanel();
		pageTabs.addTab("Calendar", null, calendarTab, null);

		JPanel openJobsTab = new JPanel();
		pageTabs.addTab("Open Jobs", null, openJobsTab, null);
	}

	/**
	 * This method populates the Profile Editor tab.
	 * @author Joshua Thomas
	 */
	public static void populateProfileTab() {
		
		JButton btnEdit = new JButton("Edit Profile");
		profileTab.add(btnEdit);
		btnEdit.setBounds(145, 247, 120, 23);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editProfile();
			}
		});
		
		JLabel lblCurProfile = new JLabel("Current Profile Settings:");
		profileTab.add(lblCurProfile);
		lblCurProfile.setBounds(30, 5, 200, 20);

		JLabel lblFirstName = new JLabel("First Name:");
		profileTab.add(lblFirstName);
		lblFirstName.setBounds(15, 35, 120, 20);

		lblShowCurFirstName = new JLabel();
		profileTab.add(lblShowCurFirstName);
		lblShowCurFirstName.setBounds(145, 35, 120, 20);
		lblShowCurFirstName.setText(strFirstName);

		JLabel lblLastName = new JLabel("Last Name:");
		profileTab.add(lblLastName);
		lblLastName.setBounds(15, 60, 120, 20);

		lblShowCurLastName = new JLabel();
		profileTab.add(lblShowCurLastName);
		lblShowCurLastName.setBounds(145, 60, 120, 20);
		lblShowCurLastName.setText(strLastName);

		JLabel lblCompanyName = new JLabel("Company Name:");
		profileTab.add(lblCompanyName);
		lblCompanyName.setBounds(15, 85, 120, 20);

		lblShowCurCompanyName = new JLabel();
		profileTab.add(lblShowCurCompanyName);
		lblShowCurCompanyName.setBounds(145, 85, 120, 20);
		lblShowCurCompanyName.setText(strCompanyName);

		JLabel lblAddress1 = new JLabel("Address:");
		profileTab.add(lblAddress1);
		lblAddress1.setBounds(15, 110, 120, 20);

		lblShowCurAddress1 = new JLabel();
		profileTab.add(lblShowCurAddress1);
		lblShowCurAddress1.setBounds(145, 110, 120, 20);
		lblShowCurAddress1.setText(strAddress1);

		JLabel lblAddress2 = new JLabel("Address (cont):");
		profileTab.add(lblAddress2);
		lblAddress2.setBounds(15, 135, 120, 20);

		lblShowCurAddress2 = new JLabel();
		profileTab.add(lblShowCurAddress2);
		lblShowCurAddress2.setBounds(145, 135, 120, 20);
		lblShowCurAddress2.setText(strAddress2);

		JLabel lblCity = new JLabel("City:");
		profileTab.add(lblCity);
		lblCity.setBounds(15, 160, 120, 20);

		lblShowCurCity = new JLabel();
		profileTab.add(lblShowCurCity);
		lblShowCurCity.setBounds(145, 160, 120, 20);
		lblShowCurCity.setText(strCity);

		JLabel lblState = new JLabel("State:");
		profileTab.add(lblState);
		lblState.setBounds(15, 185, 120, 20);

		lblShowCurState = new JLabel();
		profileTab.add(lblShowCurState);
		lblShowCurState.setBounds(145, 185, 120, 20);
		lblShowCurState.setText(strState);
		
		JLabel lblZipCode = new JLabel("Zip Code:");
		profileTab.add(lblZipCode);
		lblZipCode.setBounds(15, 210, 120, 20);

		lblShowCurZipCode = new JLabel();
		profileTab.add(lblShowCurZipCode);
		lblShowCurZipCode.setBounds(145, 210, 120, 20);
		lblShowCurZipCode.setText(String.format("%05d", intZipCode));

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

		btnSave = new JButton("Save");
		profileTab.add(btnSave);
		btnSave.setBounds(345, 247, 80, 23);
		btnSave.setVisible(false);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveProfileUpdates();
			}
		});
		
		btnClear = new JButton("Clear");
		profileTab.add(btnClear);
		btnClear.setBounds(430, 247, 80, 23);
		btnClear.setVisible(false);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearProfileUpdates();
			}
		});

		btnCancel = new JButton("Cancel");
		profileTab.add(btnCancel);
		btnCancel.setBounds(515, 247, 80, 23);
		btnCancel.setVisible(false);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearProfileUpdates();
				editProfileCancel();
			}
		});
	}

	/**
	 * This method makes the "updated information" portion of the edit profile tab visible.
	 * @author Joshua Thomas
	 */
	public static void editProfile() {
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
		btnClear.setVisible(true);
		btnCancel.setVisible(true);
		profileTab.revalidate();
	}

	/**
	 * This method saves the updated profile information to the local variables.
	 * In time, it will push the updates to the database.
	 * @author Joshua Thomas
	 */
	public static void saveProfileUpdates() {
		if (txtLastNameUpdate.getText().length() > 0) {
			strLastName = txtLastNameUpdate.getText();
		}
		if (txtFirstNameUpdate.getText().length() > 0) {
			strFirstName = txtFirstNameUpdate.getText();
		}
		if (txtCompanyNameUpdate.getText().length() > 0) {
			strCompanyName = txtCompanyNameUpdate.getText();		
		}
		if (txtAddress1Update.getText().length() > 0) {
			strAddress1 = txtAddress1Update.getText();
		}
		if (txtAddress2Update.getText().length() > 0) {
			strAddress2 = txtAddress2Update.getText();
		}
		if (txtCityUpdate.getText().length() > 0) {
			strCity = txtCityUpdate.getText();
		}
		if (txtStateUpdate.getText().length() > 0) {
			strState = txtStateUpdate.getText();
		}
		if (txtZipCodeUpdate.getText().length() > 0) {
			int issueChecker = 0;
			if (txtZipCodeUpdate.getText().length() != 5) {
				issueChecker = 1;
			}
			for (int i = 0; i < txtZipCodeUpdate.getText().length(); i++) {
				char c0 = txtZipCodeUpdate.getText().charAt(i);
				if (Character.isDigit(c0)) {
					// do nothing if character is a digit
				} else {
					issueChecker = 1;
				}
			}
			while (issueChecker > 0) {
				//strTzc stands for string Test Zip Code
				String strTzc = JOptionPane.showInputDialog( 
								profileTab,
								"Please enter a valid Zip Code",
								null);
				if (strTzc.length() != 5) {
					issueChecker = 1;
				} else {
					int issueTracker = 0;
					for (int j = 0; j < strTzc.length(); j++) {
						char c1 = strTzc.charAt(j);
						if (Character.isDigit(c1)) {
							if (j == 4 && issueTracker == 0) {
								txtZipCodeUpdate.setText(strTzc);
								intZipCode = Integer.parseInt(txtZipCodeUpdate.getText());
								issueChecker = 0;
								break;
							}
						} else {
							issueTracker++;
						}
					}
				}

			}
		}
		profileTab.revalidate();
	}
	
	/**
	 * This method populates a job list array for building and testing the Search functions.
	 */
	public static void populateJobListArray() {
		job1 = new String[] {"001", "Hole in Wall","Kid smashed head through drywall", 
							  "Dayton", "500", "7", "45402"};
		job2 = new String[] {"002", "New Toilet", "Would like new toilet installed", 
							  "Englewood", "100", "1", "45322"};
		job3 = new String[] {"017", "Replace Wall Outlet", "Need new outlet installed", 
							  "Centerville", "100", "1", "45458"};
		job4 = new String[] {"042", "New Porch", "I want a large enclosed porch built "
				+ "on the back of my house", "Kettering", 
							  "3500", "14", "45429"};
		jobList.removeAllElements();
		jobList.add(0,job1);
		jobList.add(1,job2);
		jobList.add(2,job3);
		jobList.add(3,job4);
	}
	
	/**
	 * This method calculates the distance between two ZIP codes.
	 * Contractor Connection registered with ZipCodeAPI.com on the free plan to get static API code.
	 * Registered under Joshua Thomas' email address (thomas.611@wright.edu).
	 */
	public static double distanceCalculator(int zip1, int zip2) throws IOException {
		String strApiKey = "DyJlPe7F6MgACobvKEUcqeOMf5TCJ1VmAEIpSQ5YDlyfKKLuoFGOTuA9AuMkvHH6";
		String url1 = "https://www.zipcodeapi.com/rest/";
		String query = url1 + strApiKey + "/distance.xml/" + zip1 + "/" + zip2 + "/mile";

		HttpURLConnection urlConnection = (HttpURLConnection) new URL(query).openConnection();	
		InputStream result = urlConnection.getInputStream();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		double distance = 0;	
		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(result);
			NodeList list = doc.getElementsByTagName("distance");
			distance = Double.parseDouble(list.item(0).getTextContent());
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} finally {
			urlConnection.disconnect();
			result.close();
			
		}
		return distance;
	}

	@Override
	public void actionPerformed(ActionEvent e0) {

	}
	
	/**
	 * This method clears the entries in the "update profile" section of the profile editor tab.
	 * @author Joshua Thomas 
	 */
	public static void clearProfileUpdates() {
		txtLastNameUpdate.setText(null);
		txtFirstNameUpdate.setText(null);
		txtCompanyNameUpdate.setText(null);
		txtAddress1Update.setText(null);
		txtAddress2Update.setText(null);
		txtCityUpdate.setText(null);
		txtStateUpdate.setText(null);
		txtZipCodeUpdate.setText(null);
	}

	/**
	 * This method sets visible to false for the "update profile" section of the profile editor tab.
	 * @author Joshua Thomas
	 */
	public static void editProfileCancel() {
		lblNewProfile.setVisible(false);
		txtLastNameUpdate.setVisible(false);
		txtFirstNameUpdate.setVisible(false);
		txtCompanyNameUpdate.setVisible(false);
		txtAddress1Update.setVisible(false);
		txtAddress2Update.setVisible(false);
		txtCityUpdate.setVisible(false);
		txtStateUpdate.setVisible(false);
		txtZipCodeUpdate.setVisible(false);
		btnSave.setVisible(false);
		btnClear.setVisible(false);
		btnCancel.setVisible(false);
		lblLastNameUpdate.setVisible(false);
		lblFirstNameUpdate.setVisible(false);
		lblCompanyNameUpdate.setVisible(false);
		lblAddress1Update.setVisible(false);
		lblAddress2Update.setVisible(false);
		lblCityUpdate.setVisible(false);
		lblStateUpdate.setVisible(false);
		lblZipCodeUpdate.setVisible(false);
		profileTab.validate();
		profileTab.repaint();
	}
	
	public static void buildTable() {
		model1 = new DefaultTableModel(columnNames, 0);
	}

	/**
	 * This method sets up the initial window.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContractorClient.initialize();
//					ContractorClient window = new ContractorClient();
					ContractorClient.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}
}
