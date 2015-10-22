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

/*
 * The following imports will be utilized once we are able to create and save
 * account information other than locally
 * 
 * import edu.wright.cs.fa15.ceg3120.concon.common.data.AccountType;
 * import edu.wright.cs.fa15.ceg3120.concon.common.data.ContractorAccount;
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;
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
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
//import java.util.Scanner;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
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
import javax.swing.table.TableCellRenderer;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

/**
 * Javadoc needed.
 * 
 *
 */
public class ContractorClient extends JFrame implements ActionListener {

/* The following variable to be implemented when AccountType and ContractorAccount
 * imports are implemented
 * 
 * 	private static ContractorAccount account = new ContractorAccount();
*/
	private static final Logger LOG = LoggerFactory.getLogger(ContractorClient.class);
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
	private static JLabel lblShowCurPhoneNumber;
	private static JLabel lblShowCurEmailAddress;
	private static JTextField txtLastNameUpdate;
	private static JTextField txtFirstNameUpdate;
	private static JTextField txtCompanyNameUpdate;
	private static JTextField txtAddress1Update;
	private static JTextField txtAddress2Update;
	private static JTextField txtCityUpdate;
	private static JTextField txtStateUpdate;
	private static JTextField txtZipCodeUpdate;
	private static JTextField txtPhoneNumberUpdate;
	private static JTextField txtEmailAddressUpdate;
	private static String strLastName = "Person";
	private static String strFirstName = "Random";
	private static String strCompanyName = "ConCon";
	private static String strAddress1 = "123 Main Street";
	private static String strAddress2 = "";
	private static String strCity = "Dayton";
	private static String strState = "OH";
	private static int intZipCode = 45400;
	private static String strPhoneNumber = "937-555-1212";
	private static String strEmailAddress = "thomas.611@wright.edu";
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
	private static JLabel lblPhoneNumberUpdate;
	private static JLabel lblEmailAddressUpdate;
	private static JButton btnSave;
	private static JButton btnCancel;
	private static JButton btnClear;
	private static JLabel lblNumResults1 = new JLabel();
	private static JLabel lblNumResults2 = new JLabel();
	private static JLabel lblNumResults3 = new JLabel();
	private static JLabel lblNumResults4 = new JLabel();
	private static JLabel lblNumResults5 = new JLabel();
	private static JLabel lblNumResults6 = new JLabel();
	private static ArrayList<OpenJob> jobList = new ArrayList<OpenJob>();
	private static Vector<Object> tempVec = new Vector<Object>();
	private static int intSearch = 0;
	private static int curNotif = 0;
	private static String[] columnNames = {"Job Number", "Title", "Description", "City", "Cost", 
											"Duration", "Zip Code"};
	private static DefaultTableModel model1 = null;
	private static JTabbedPane pageTabs = new JTabbedPane(JTabbedPane.TOP);
	private static DecimalFormat f0 = new DecimalFormat("##.00");
	
	/**
	 * This method sets the current amount of notifications for the user. Used to
	 * set the color of the tab to notify the user.
	 * @param curNotif New value of the current notifications.
	 */
	private static void setNotif(int curNotif) {
		ContractorClient.curNotif = curNotif;
	}
	
	/**
	 * Gets and returns the current number of notifications.
	 * @return Returns the current value.
	 */
	private static int getNotif() {
		return curNotif;
	}
	
	/**
	 * Class for populating job information in the search feature.
	 * This class includes the setters and getters.
	 *
	 */
	public static class OpenJob {
		private int jobNumber;
		private String jobTitle;
		private String jobDescription;
		private String jobCity;
		private int jobCost;
		private int jobDuration;
		private int jobZipCode;
		private double jobDistance;
		
		/**
		 * Sets job number for OpenJob object.
		 * @param num is int job number from method.
		 */
		public void setJobNumber(int num) {
			jobNumber = num;
		}
		
		/**
		 * Sets job title for OpenJob object.
		 * @param title is string job title from method.
		 */
		public void setJobTitle(String title) {
			jobTitle = title;
		}
		
		/**
		 * Sets job description for OpenJob object.
		 * @param desc is string job description from method.
		 */
		public void setJobDesc(String desc) {
			jobDescription = desc;
		}
		
		/**
		 * Sets job city for OpenJob object.
		 * @param city is string job city from method.
		 */
		public void setJobCity(String city) {
			jobCity = city;
		}
		
		/**
		 * Sets job cost for OpenJob object.
		 * @param cost is int job cost from method.
		 */
		public void setJobCost(int cost) {
			jobCost = cost;
		}
		
		/**
		 * Sets job duration for OpenJob object.
		 * @param dur is int job duration from method.
		 */
		public void setJobDuration(int dur) {
			jobDuration = dur;
		}
		
		/**
		 * Sets job zip code for OpenJob object.
		 * @param zip is int job zip code from method.
		 */
		public void setJobZipCode(int zip) {
			jobZipCode = zip;
		}
		
		/**
		 * Sets job distance for OpenJob object.
		 * @param distance is double distance from method.
		 */
		public void setJobDistance(double distance) {
			jobDistance = distance;
		}
		
		/**
		 * Gets job number from OpenJob object.
		 * @return int job number to method.
		 */
		public int getJobNumber() {
			return jobNumber;
		}
		
		/**
		 * Gets job title from OpenJob object.
		 * @return string job title to method.
		 */
		public String getJobTitle() {
			return jobTitle;
		}
		
		/**
		 * Gets job description from OpenJob object.
		 * @return string job description to method.
		 */
		public String getJobDesc() {
			return jobDescription;
		}
		
		/**
		 * Gets job city from OpenJob object.
		 * @return string job city to method.
		 */
		public String getJobCity() {
			return jobCity;
		}
		
		/**
		 * Gets job cost from OpenJob object.
		 * @return int job cost to method.
		 */
		public int getJobCost() {
			return jobCost;
		}
		
		/**
		 * Gets job duration from OpenJob object.
		 * @return int job duration to method.
		 */
		public int getJobDuration() {
			return jobDuration;
		}
		
		/**
		 * Gets job zip code from OpenJob object.
		 * @return int job zip code to method.
		 */
		public int getJobZipCode() {
			return jobZipCode;
		}
		
		/**
		 * Gets job distane from OpenJob object.
		 * @return double job distance to method.
		 */
		public double getJobDistance() {
			return jobDistance;
		}
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
	private static void initialize() {
/*
 * The following line to be implemented when AccountType and ContractorAccount
 * imports are implemented
 * 
 * 		account.setAccountType(AccountType.CONTRACTOR);
 */
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
				int exit = JOptionPane.showConfirmDialog(frame, "Do you want to exit?", 
						"Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (exit == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		frame.getContentPane().setLayout(null);
		lblNumResults1.setText("Showing results ");
		lblNumResults3.setText(" to ");
		lblNumResults5.setText(" of" );

		JPanel banner = new JPanel();
		banner.setLayout(null);
		banner.setBounds(6, 0, 703, 127);
		ImageIcon imageIcon = new ImageIcon("images/c2-image.png");
		Image image = imageIcon.getImage();
		Image newImg = image.getScaledInstance((int) (banner.getHeight() * .9), 
				(int) (banner.getHeight() * .9), java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newImg);		
		JLabel picLabel = new JLabel(imageIcon);
		banner.add(picLabel);	
		picLabel.setBounds((int) ((banner.getWidth() * .95) - (banner.getHeight() * .75)),
				(int) (banner.getHeight() * .05),(int) (banner.getHeight() * .90),
				(int) (banner.getHeight() * .90));
		picLabel.setOpaque(true);
		picLabel.setBackground(Color.darkGray);

		frame.getContentPane().add(banner);
		banner.setOpaque(false);
		pageTabs = new JTabbedPane(JTabbedPane.TOP);
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

		buildCurrentBidsTab();
		
		buildNotificationsTab();
		
		buildSearchTab();
		
		buildPaymentsTab();

		buildProfileEditorTab();

		buildCalendarTab();

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

		JLabel lblLastName = new JLabel("Last Name:");
		profileTab.add(lblLastName);
		lblLastName.setBounds(15, 55, 120, 20);

		lblShowCurLastName = new JLabel();
		profileTab.add(lblShowCurLastName);
		lblShowCurLastName.setBounds(145, 55, 120, 20);

		JLabel lblCompanyName = new JLabel("Company Name:");
		profileTab.add(lblCompanyName);
		lblCompanyName.setBounds(15, 75, 120, 20);

		lblShowCurCompanyName = new JLabel();
		profileTab.add(lblShowCurCompanyName);
		lblShowCurCompanyName.setBounds(145, 75, 120, 20);

		JLabel lblAddress1 = new JLabel("Address:");
		profileTab.add(lblAddress1);
		lblAddress1.setBounds(15, 95, 120, 20);

		lblShowCurAddress1 = new JLabel();
		profileTab.add(lblShowCurAddress1);
		lblShowCurAddress1.setBounds(145, 95, 120, 20);

		JLabel lblAddress2 = new JLabel("Address (cont):");
		profileTab.add(lblAddress2);
		lblAddress2.setBounds(15, 115, 120, 20);

		lblShowCurAddress2 = new JLabel();
		profileTab.add(lblShowCurAddress2);
		lblShowCurAddress2.setBounds(145, 115, 120, 20);

		JLabel lblCity = new JLabel("City:");
		profileTab.add(lblCity);
		lblCity.setBounds(15, 135, 120, 20);

		lblShowCurCity = new JLabel();
		profileTab.add(lblShowCurCity);
		lblShowCurCity.setBounds(145, 135, 120, 20);

		JLabel lblState = new JLabel("State:");
		profileTab.add(lblState);
		lblState.setBounds(15, 155, 120, 20);

		lblShowCurState = new JLabel();
		profileTab.add(lblShowCurState);
		lblShowCurState.setBounds(145, 155, 120, 20);
		
		JLabel lblZipCode = new JLabel("Zip Code:");
		profileTab.add(lblZipCode);
		lblZipCode.setBounds(15, 175, 120, 20);

		lblShowCurZipCode = new JLabel();
		profileTab.add(lblShowCurZipCode);
		lblShowCurZipCode.setBounds(145, 175, 120, 20);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		profileTab.add(lblPhoneNumber);
		lblPhoneNumber.setBounds(15, 195, 120, 20);
		
		lblShowCurPhoneNumber = new JLabel();
		profileTab.add(lblShowCurPhoneNumber);
		lblShowCurPhoneNumber.setBounds(145, 195, 120, 20);
		
		JLabel lblEmailAddress = new JLabel("Email Address:");
		profileTab.add(lblEmailAddress);
		lblEmailAddress.setBounds(15, 215, 120, 20);
		
		lblShowCurEmailAddress = new JLabel();
		profileTab.add(lblShowCurEmailAddress);
		lblShowCurEmailAddress.setBounds(145, 215, 120, 20);

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
		lblLastNameUpdate.setBounds(345, 55, 120, 20);
		lblLastNameUpdate.setVisible(false);

		txtLastNameUpdate = new JTextField();
		profileTab.add(txtLastNameUpdate);
		txtLastNameUpdate.setBounds(475, 55, 120, 20);
		txtLastNameUpdate.setVisible(false);

		lblCompanyNameUpdate = new JLabel("Company Name:");
		profileTab.add(lblCompanyNameUpdate);
		lblCompanyNameUpdate.setBounds(345, 75, 120, 20);
		lblCompanyNameUpdate.setVisible(false);

		txtCompanyNameUpdate = new JTextField();
		profileTab.add(txtCompanyNameUpdate);
		txtCompanyNameUpdate.setBounds(475, 75, 120, 20);
		txtCompanyNameUpdate.setVisible(false);

		lblAddress1Update = new JLabel("Address:");
		profileTab.add(lblAddress1Update);
		lblAddress1Update.setBounds(345, 95, 120, 20);
		lblAddress1Update.setVisible(false);

		txtAddress1Update = new JTextField();
		profileTab.add(txtAddress1Update);
		txtAddress1Update.setBounds(475, 95, 120, 20);
		txtAddress1Update.setVisible(false);

		lblAddress2Update = new JLabel("Address (cont):");
		profileTab.add(lblAddress2Update);
		lblAddress2Update.setBounds(345, 115, 120, 20);
		lblAddress2Update.setVisible(false);

		txtAddress2Update = new JTextField();
		profileTab.add(txtAddress2Update);
		txtAddress2Update.setBounds(475, 115, 120, 20);
		txtAddress2Update.setVisible(false);

		lblCityUpdate = new JLabel("City:");
		profileTab.add(lblCityUpdate);
		lblCityUpdate.setBounds(345, 135, 120, 20);
		lblCityUpdate.setVisible(false);

		txtCityUpdate = new JTextField();
		profileTab.add(txtCityUpdate);
		txtCityUpdate.setBounds(475, 135, 120, 20);
		txtCityUpdate.setVisible(false);

		lblStateUpdate = new JLabel("State:");
		profileTab.add(lblStateUpdate);
		lblStateUpdate.setBounds(345, 155, 120, 20);
		lblStateUpdate.setVisible(false);

		txtStateUpdate = new JTextField();
		profileTab.add(txtStateUpdate);
		txtStateUpdate.setBounds(475, 155, 120, 20);
		txtStateUpdate.setVisible(false);

		lblZipCodeUpdate = new JLabel("Zip Code:");
		profileTab.add(lblZipCodeUpdate);
		lblZipCodeUpdate.setBounds(345, 175, 120, 20);
		lblZipCodeUpdate.setVisible(false);

		txtZipCodeUpdate = new JTextField();
		profileTab.add(txtZipCodeUpdate);
		txtZipCodeUpdate.setBounds(475, 175, 120, 20);
		txtZipCodeUpdate.setVisible(false);
		
		lblPhoneNumberUpdate = new JLabel("Phone Number:");
		profileTab.add(lblPhoneNumberUpdate);
		lblPhoneNumberUpdate.setBounds(345, 195, 120, 20);
		lblPhoneNumberUpdate.setVisible(false);
		
		txtPhoneNumberUpdate = new JTextField();
		profileTab.add(txtPhoneNumberUpdate);
		txtPhoneNumberUpdate.setBounds(475, 195, 120, 20);
		txtPhoneNumberUpdate.setVisible(false);
		
		lblEmailAddressUpdate = new JLabel("Email Address:");
		profileTab.add(lblEmailAddressUpdate);
		lblEmailAddressUpdate.setBounds(345, 215, 120, 20);
		lblEmailAddressUpdate.setVisible(false);
		
		txtEmailAddressUpdate = new JTextField();
		profileTab.add(txtEmailAddressUpdate);
		txtEmailAddressUpdate.setBounds(475, 215, 120, 20);
		txtEmailAddressUpdate.setVisible(false);

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
		
		loadCurrentProfile();
	}
	
	/**
	 * This method loads the current profile.
	 */
	public static void loadCurrentProfile() {
		lblShowCurFirstName.setText(strFirstName);
		lblShowCurLastName.setText(strLastName);
		lblShowCurCompanyName.setText(strCompanyName);
		lblShowCurAddress1.setText(strAddress1);
		lblShowCurAddress2.setText(strAddress2);
		lblShowCurCity.setText(strCity);
		lblShowCurState.setText(strState);
		lblShowCurZipCode.setText(String.format("%05d", intZipCode));
		lblShowCurPhoneNumber.setText(strPhoneNumber);
		lblShowCurEmailAddress.setText(strEmailAddress);
/*
 * The following code to be implemented when the AccountType and ContractorAccount
 * imports are implemented.
 *  
 *		lblShowCurFirstName.setText(account.getFirstName());
 *		lblShowCurLastName.setText(account.getLastName());
 *		lblShowCurCompanyName.setText(account.getCompanyName());
 *		lblShowCurAddress1.setText(account.getAddress1());
 *		lblShowCurAddress2.setText(account.getAddress2());
 *		lblShowCurCity.setText(account.getCity());
 *		lblShowCurState.setText(account.getState());
 *		lblShowCurZipCode.setText(String.format("%05d", account.getZipCode()));
 *		lblShowCurPhoneNumber.setText(account.getPhoneNumber());
 *		lblShowCurEmailAddress.setText(account.getEmailAddress());
 */
	}

	/**
	 * This method makes the "updated information" elements of the edit profile tab visible.
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
		lblPhoneNumberUpdate.setVisible(true);
		lblEmailAddressUpdate.setVisible(true);
		txtLastNameUpdate.setVisible(true);
		txtFirstNameUpdate.setVisible(true);
		txtCompanyNameUpdate.setVisible(true);
		txtAddress1Update.setVisible(true);
		txtAddress2Update.setVisible(true);
		txtCityUpdate.setVisible(true);
		txtStateUpdate.setVisible(true);
		txtZipCodeUpdate.setVisible(true);
		txtPhoneNumberUpdate.setVisible(true);
		txtEmailAddressUpdate.setVisible(true);
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
/*
 * The following line to be implemented when the AccountType and ContractorAccount
 * imports are implemented. The above line will be removed.
 * 
 * 			account.setLastName(txtLastNameUpdate.getText());
 */
		}
		if (txtFirstNameUpdate.getText().length() > 0) {
			strFirstName = txtFirstNameUpdate.getText();
/*
 * The following line to be implemented when the AccountType and ContractorAccount
 * imports are implemented. The above line will be removed.
 * 
 * 			account.setFirstName(txtFirstNameUpdate.getText());
 */
		}
		if (txtCompanyNameUpdate.getText().length() > 0) {
			strCompanyName = txtCompanyNameUpdate.getText();
/*
 * The following line to be implemented when the AccountType and ContractorAccount
 * imports are implemented. The above line will be removed.
 * 
 * 			account.setCompanyName(txtCompanyNameUpdate.getText()); 
 */		
		}
		if (txtAddress1Update.getText().length() > 0) {
			strAddress1 = txtAddress1Update.getText();
/*
 * The following line to be implemented when the AccountType and ContractorAccount
 * imports are implemented. The above line will be removed.
 * 
 * 			account.setAddress1(txtAddress1Update.getText());
 */
		}
		if (txtAddress2Update.getText().length() > 0) {
			strAddress2 = txtAddress2Update.getText();
/*
 * The following line to be implemented when the AccountType and ContractorAccount
 * imports are implemented. The above line will be removed.
 * 
 * 			account.setAddress2(txtAddress2Update.getText());
 */
		}
		if (txtCityUpdate.getText().length() > 0) {
			strCity = txtCityUpdate.getText();
/*
 * The following line to be implemented when the AccountType and ContractorAccount
 * imports are implemented. The above line will be removed.
 * 
 * 			account.setCity(txtCityUpdate.getText());
 */
		}
		if (txtStateUpdate.getText().length() > 0) {
			strState = txtStateUpdate.getText();
/*
 * The following line to be implemented when the AccountType and ContractorAccount
 * imports are implemented. The above line will be removed.
 * 
 * 			account.setState(txtStateUpdate.getText());
 */
		}
		if (txtZipCodeUpdate.getText().length() > 0) {
			int issueChecker = 0;
			if (txtZipCodeUpdate.getText().length() != 5) {
				issueChecker = 1;
			}
			for (int i = 0; i < txtZipCodeUpdate.getText().length(); i++) {
				char c0 = txtZipCodeUpdate.getText().charAt(i);
				if (Character.isDigit(c0)) {
					// move to next index i in above for loop if character is a digit
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
/*
 * The following line to be implemented when the AccountType and ContractorAccount
 * imports are implemented. The above line will be removed.
 * 
 * 								account.setZipCode(Integer.parseInt(txtZipCodeUpdate.getText()));
 */
								issueChecker = 0;
								break;
							}
						} else {
							issueTracker++;
						}
					}
				}
			}
			intZipCode = Integer.parseInt(txtZipCodeUpdate.getText());
		}
		if (txtPhoneNumberUpdate.getText().length() > 0) {
			strPhoneNumber = txtPhoneNumberUpdate.getText();
/*
 * The following line to be implemented when the AccountType and ContractorAccount
 * imports are implemented. The above line will be removed.
 * 
 * 			account.setPhoneNumber(txtPhoneNumberUpdate.getText());
 */		
		}
		if (txtEmailAddressUpdate.getText().length() > 0) {
			strEmailAddress = txtEmailAddressUpdate.getText();
/*
 * The following line to be implemented when the AccountType and ContractorAccount
 * imports are implemented. The above line will be removed.
 * 
 * 			account.setEmailAddress(txtEmailAddressUpdate.getText());
 */
		}
		loadCurrentProfile();
		profileTab.revalidate();
		profileTab.repaint();
	}
	
	/**
	 * This method populates a job list array for building and testing the Search functions.
	 * Method will be modified when database access is implemented.
	 */
	public static void populateJobListArray() {
		OpenJob job1 = new OpenJob();
		job1.setJobNumber(1);
		job1.setJobTitle("Hole in Wall");
		job1.setJobDesc("Kid smashed head through drywall");
		job1.setJobCity("Dayton");
		job1.setJobCost(500);
		job1.setJobDuration(1);
		job1.setJobZipCode(45402);
		job1.setJobDistance(-1);
		OpenJob job2 = new OpenJob();
		job2.setJobNumber(2);
		job2.setJobTitle("New Toilet");
		job2.setJobDesc("Would like new toilet installed");
		job2.setJobCity("Englewood");
		job2.setJobCost(100);
		job2.setJobDuration(2);
		job2.setJobZipCode(45322);
		job2.setJobDistance(-1);
		OpenJob job3 = new OpenJob();
		job3.setJobNumber(17);
		job3.setJobTitle("Replace Wall Outlet");
		job3.setJobDesc("New new electrical outlet installed");
		job3.setJobCity("Centerville");
		job3.setJobCost(100);
		job3.setJobDuration(1);
		job3.setJobZipCode(45458);
		job3.setJobDistance(-1);
		OpenJob job4 = new OpenJob();
		job4.setJobNumber(42);
		job4.setJobTitle("New Porch");
		job4.setJobDesc("I want a large enclosed porch built on the back of my house");
		job4.setJobCity("Kettering");
		job4.setJobCost(3500);
		job4.setJobDuration(14);
		job4.setJobZipCode(45429);
		job4.setJobDistance(-1);
		jobList.clear();
		jobList.add(job1);
		jobList.add(job2);
		jobList.add(job3);
		jobList.add(job4);
	}
	
/* CHANGE TO BE MADE TO distanceCalculator() ONCE DATABASE IS IMPLEMENTED:
 * Change to "Zip Codes by Radius" via ZipCodeAPI and then compare results
 * with database results to limit requests pushed to ZipCodeAPI and streamline
 * search process
 */
	
/**
 * This method calculates the distance between two ZIP codes.
 * Contractor Connection registered with ZipCodeAPI.com on the free plan to get static API code.
 * Registered under Joshua Thomas' email address (thomas.611@wright.edu).
 * Units used: miles
 * @throws XMLStreamException 
 * 
 */
	public static Double[][] distanceCalculator(int zip, int distance) throws IOException, 
	XMLStreamException {
		String strApiKey = "DyJlPe7F6MgACobvKEUcqeOMf5TCJ1VmAEIpSQ5YDlyfKKLuoFGOTuA9AuMkvHH6";
		String url1 = "https://www.zipcodeapi.com/rest/";
		String query = url1 + strApiKey + "/radius.xml/" + zip + "/" + distance + "/mile";		
		
		HttpURLConnection urlConnection = (HttpURLConnection) new URL(query).openConnection();	
		InputStream result = urlConnection.getInputStream();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Double[][] strDistanceArray = new Double[50][2];
		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(result);
			NodeList list = doc.getElementsByTagName("zip_code");
			if (list.getLength() <= 50) {
				for (int j = 0; j < list.getLength(); j++) {
					Node prop = list.item(j);
					NamedNodeMap attr = prop.getAttributes();
					if (null != attr) {
						Node p0 = attr.getNamedItem("distance");
						strDistanceArray[j][0] = Double.parseDouble(list.item(j).getTextContent());
						strDistanceArray[j][1] = Double.parseDouble(p0.getNodeValue());
					}
				}
			} else {
				for (int j = 0; j < 50; j++) {
					Node prop = list.item(j);
					NamedNodeMap attr = prop.getAttributes();
					if (null != attr) {
						Node p0 = attr.getNamedItem("distance");
						strDistanceArray[j][0] = Double.parseDouble(list.item(j).getTextContent());
						strDistanceArray[j][1] = Double.parseDouble(p0.getNodeValue());
					}
				}
			}
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}  finally {
			urlConnection.disconnect();
			result.close();
		}
		return strDistanceArray;		
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
		txtPhoneNumberUpdate.setText(null);
		txtEmailAddressUpdate.setText(null);
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
		txtPhoneNumberUpdate.setVisible(false);
		txtEmailAddressUpdate.setVisible(false);
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
		lblPhoneNumberUpdate.setVisible(false);
		lblEmailAddressUpdate.setVisible(false);
		profileTab.validate();
		profileTab.repaint();
	}
	
	/**
	 * This method sets the table model.
	 */
	public static void buildTable() {
		model1 = new DefaultTableModel(columnNames, 0);
	}
	
	/**
	 * Populates tempVec with values from OpenJob class.
	 * @param newJob is of type OpenJob.
	 * @return returns tempVec.
	 */
	public static Vector<Object> fillTempVec(OpenJob newJob) {
		Vector<Object> newVec = new Vector<Object>();
		newVec.clear();
		newVec.add(0, newJob.getJobNumber());
		newVec.add(1, newJob.getJobTitle());
		newVec.add(2, newJob.getJobDesc());
		newVec.add(3, newJob.getJobCity());
		newVec.add(4, newJob.getJobCost());
		newVec.add(5, newJob.getJobDuration());
		newVec.add(6, newJob.getJobZipCode());
		if (newJob.getJobDistance() > -1) {
			newVec.add(7, newJob.getJobDistance());
		}
		
		return newVec;
	}
	
	/**
	 * Needs Javadoc.
	 */
	
	public static void openWebpage(URL url) {
		URI uri = null;
		try {
			uri = url.toURI();
		} catch (URISyntaxException e1) {
			JOptionPane.showMessageDialog(frame, "The given URL is invalid", 
					"Invalid URL", JOptionPane.ERROR_MESSAGE);
		}
		Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
		if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
			try {
				desktop.browse(uri);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(frame, "The webpage couldn't open",
						"Couldn't Open Page", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	
	/**
	 * This method hides the search result labels on the search tab.
	 */
	public static void hideResultLabels() {
		lblNumResults1.setVisible(false);
		lblNumResults2.setVisible(false);
		lblNumResults3.setVisible(false);
		lblNumResults4.setVisible(false);
		lblNumResults5.setVisible(false);
		lblNumResults6.setVisible(false);
	}
	
	/**
	 * This method makes the search result labels on the search tab visible.
	 */
	public static void showResultLabels() {
		lblNumResults1.setVisible(true);
		lblNumResults2.setVisible(true);
		lblNumResults3.setVisible(true);
		lblNumResults4.setVisible(true);
		lblNumResults5.setVisible(true);
		lblNumResults6.setVisible(true);
	}
	
	/**
	 * This method builds and populates the search tab, thereby shrinking the size
	 * of the main method.
	 */
	public static void buildSearchTab() {
		JPanel searchTab = new JPanel();
		pageTabs.addTab("Search", null, searchTab, null);
		searchTab.setLayout(null);
		
		populateJobListArray();
		
		JLabel lblSearchTabMain = new JLabel("Search Options:");
		searchTab.add(lblSearchTabMain);
		lblSearchTabMain.setBounds(5,5,120,20);
		
		final JTextField txtSearchOptions = new JTextField();
		txtSearchOptions.setBounds(275, 5, 240, 20);
		searchTab.add(txtSearchOptions);
		txtSearchOptions.setVisible(false);
		
		String[] searchOptions = {"Show All", "Distance", "Max Cost", "Max Duration"};
		final JComboBox<String> cboSearchOptions = new JComboBox<String>(searchOptions);
		searchTab.add(cboSearchOptions);
		cboSearchOptions.setBounds(140, 5, 120, 20);
		cboSearchOptions.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e1) {
				switch (cboSearchOptions.getSelectedItem().toString()) {
				case "Show All":
					intSearch = 0;
					txtSearchOptions.setVisible(false);
					break;
				case "Distance":
					intSearch = 1;
					txtSearchOptions.setVisible(true);
					break;
				case "Max Cost":
					intSearch = 2;
					txtSearchOptions.setVisible(true);
					break;
				case "Max Duration":
					intSearch = 3;
					txtSearchOptions.setVisible(true);
					break;
				default:
					intSearch = 0;
					break;
				}
				
			}
		});
		
		buildTable();
		final JTable tblSearchResults = new JTable(model1) {
			
			private static final long serialVersionUID = 3500811875821636172L;

			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component c0 = super.prepareRenderer(renderer, row, column);
				if (c0 instanceof JComponent) {
					if (column > 0 && column < 3) {
						JComponent jc = (JComponent) c0;
						jc.setToolTipText((String) getValueAt(row, column));
					} else {
						JComponent jc = (JComponent) c0;
						jc.setToolTipText("");
					}
				}
				return c0;
			}
			
		};
//		tblSearchResults.setAutoCreateRowSorter(true);
		JScrollPane jscSearchResults = new JScrollPane(tblSearchResults);
		jscSearchResults.setBounds(45, 45, 605, 200);
		searchTab.add(jscSearchResults);
		
		hideResultLabels();
		
		lblNumResults1.setBounds(250, 250, 100, 20);
		searchTab.add(lblNumResults1);
		
		lblNumResults2.setBounds(350, 250, 20, 20);
		searchTab.add(lblNumResults2);
		
		lblNumResults3.setBounds(370, 250, 20, 20);
		searchTab.add(lblNumResults3);
		
		lblNumResults4.setBounds(390, 250, 20, 20);
		searchTab.add(lblNumResults4);
		
		lblNumResults5.setBounds(410, 250, 20, 20);
		searchTab.add(lblNumResults5);
		
		lblNumResults6.setBounds(430, 250, 20, 20);
		searchTab.add(lblNumResults6);
		
		JButton btnSearchGo = new JButton("Search");
		btnSearchGo.setBounds(530, 5, 120, 20);
		searchTab.add(btnSearchGo);
		
		btnSearchGo.addActionListener(new ActionListener() {
			int intResultCount = 0;
			public void actionPerformed(ActionEvent arg0) {
				buildTable();
				populateJobListArray();
				switch (intSearch) {
				case 0:
					intResultCount = 0;
					model1.setRowCount(0);
					columnNames[6] = "Zip Code";
					tblSearchResults.setModel(model1);
					for (int i = 0; i < jobList.size(); i++) {
						intResultCount++;
						tempVec = fillTempVec(jobList.get(i));
						model1.addRow(tempVec);
					}
					lblNumResults2.setText("1");
					lblNumResults4.setText(String.valueOf(intResultCount));
					lblNumResults6.setText(String.valueOf(intResultCount));
					showResultLabels();
					break;
				case 1:
					intResultCount = 0;
					model1.addColumn("Distance");
					tblSearchResults.setModel(model1);
					int curZip = intZipCode;
					final String tempDistance = txtSearchOptions.getText();
					Double[][] curDistanceArray = new Double[50][2];
					int tempDistanceInt = 0;
					String strDistance = null;
					if (tempDistance.length() > 0) {
						tempDistanceInt = Integer.parseInt(tempDistance);
					} else {
						int issueChecker = 1;
						while (issueChecker > 0) {
							strDistance = JOptionPane.showInputDialog( 
											profileTab,
											"Please enter a distance (greater than 0)",
											null);
							if (strDistance.length() < 1 || Integer.parseInt(strDistance) < 1) {
								issueChecker = 1;
							} else {
								int issueTracker = 0;
								for (int j = 0; j < strDistance.length(); j++) {
									char c1 = strDistance.charAt(j);
									if (Character.isDigit(c1)) {
										if (j == strDistance.length() - 1 && issueTracker == 0) {
											txtSearchOptions.setText(strDistance);
											issueChecker = 0;
											break;
										}
									} else {
										issueTracker++;
									}
								}
							}
						}
						tempDistanceInt = Integer.parseInt(strDistance);
					}
					try {
						curDistanceArray = distanceCalculator(curZip, tempDistanceInt);
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (XMLStreamException e1) {
						e1.printStackTrace();
					}
					
					for (int j = 0; j < jobList.size(); j++) {
						for (int k = 0; k < curDistanceArray.length; k++) {
							if (curDistanceArray[k][0] == null 
									|| curDistanceArray[k][1] == null) {
								// Do nothing if the array is null at this point
							} else {
								if (jobList.get(j).getJobZipCode() 
										== curDistanceArray[k][0].intValue()) {
									intResultCount++;
									tempVec = fillTempVec(jobList.get(j));
									tempVec.add(7, f0.format(curDistanceArray[k][1]));
									model1.addRow(tempVec);
								}
							}
						}
					}
					lblNumResults2.setText("1");
					lblNumResults4.setText(String.valueOf(intResultCount));
					lblNumResults6.setText(String.valueOf(intResultCount));
					showResultLabels();
					break;
				case 2:
					intResultCount = 0;
					model1.setRowCount(0);
					columnNames[6] = "Zip Code";
					tblSearchResults.setModel(model1);
					final String tempCost = txtSearchOptions.getText(); 
					int tempCostInt = 0;
					if (tempCost.length() > 0) {
						tempCostInt = Integer.parseInt(tempCost);
					}
					for (int i = 0; i < jobList.size(); i++) {
						if (jobList.get(i).jobCost <= tempCostInt) {
							intResultCount++;
							tempVec = fillTempVec(jobList.get(i));
							model1.addRow(tempVec);
						}
					}
					lblNumResults2.setText("1");
					lblNumResults4.setText(String.valueOf(intResultCount));
					lblNumResults6.setText(String.valueOf(intResultCount));
					showResultLabels();
					break;
				case 3:
					intResultCount = 0;
					model1.setRowCount(0);
					columnNames[6] = "Zip Code";
					tblSearchResults.setModel(model1);
					final String tempDuration = txtSearchOptions.getText();
					int tempDurationInt = 0;
					if (tempDuration.length() > 0) {
						tempDurationInt = Integer.parseInt(tempDuration);
					}
					for (int i = 0; i < jobList.size(); i++) {
//						Object[] tempArray = jobList.elementData(i);
						if (jobList.get(i).jobDuration <= tempDurationInt) {
							intResultCount++;
							tempVec = fillTempVec(jobList.get(i));
							model1.addRow(tempVec);
						}
					}
					lblNumResults2.setText("1");
					lblNumResults4.setText(String.valueOf(intResultCount));
					lblNumResults6.setText(String.valueOf(intResultCount));
					showResultLabels();
					break;
				default:
					intResultCount = 0;
					model1.setRowCount(0);
					columnNames[6] = "Zip Code";
					tblSearchResults.setModel(model1);
					for (int i = 0; i < jobList.size(); i++) {
						intResultCount++;
						tempVec = fillTempVec(jobList.get(i));
						model1.addRow(tempVec);
					}
					lblNumResults2.setText("1");
					lblNumResults4.setText(String.valueOf(intResultCount));
					lblNumResults6.setText(String.valueOf(intResultCount));
					showResultLabels();
					break;
				}
			}
		});
	}
	
	/**
	 * This method creates and populates the Payments tab.
	 */
	public static void buildPaymentsTab() {
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
	}
	
	/**
	 * This method builds an populates the Notifications tab.
	 */
	public static void buildNotificationsTab() {
		JPanel notificationsTab = new JPanel();
		pageTabs.addTab("Notifications", null, notificationsTab, null);
		setNotif(6);
		if (getNotif() > 0) {
			pageTabs.setBackgroundAt(2, Color.RED);
		}
		final Color defaultColor = new Color(238,238,238);
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
					setNotif(getNotif() - 1);
					if (getNotif() < 1) {
						pageTabs.setBackgroundAt(2, defaultColor);
					}
					parent.validate();
					parent.repaint();
				}
			});
		}
	}
	
	/**
	 * This method builds and populates the Current Bids tab.
	 */
	public static void buildCurrentBidsTab() {
		final JPanel curBidsTab = new JPanel();
		pageTabs.addTab("Current Bids", null, curBidsTab, null);
		GridLayout myLayout = new GridLayout(0, 2);
		curBidsTab.setLayout(myLayout);
		f0 = new DecimalFormat("##.00");
		final JLabel[] lblCurrentBids = new JLabel[10];
		final JButton[] update = new JButton[10];
		final double[] currentBids = new double[10];
		final double[] previousBids = new double[10];
		for (int i = 0; i < 5; i++) {
			final int j = i;
			currentBids[i] = Math.random() * 115;
			previousBids[i] = Math.random() * 115;
			if (currentBids[i] > previousBids[i]) {
				lblCurrentBids[i] = new JLabel("<html>You have a bid for "
						+ f0.format(currentBids[i]) + "<br>You have been outbid by " 
							+ f0.format(previousBids[i]) + "</html>");
			} else {
				lblCurrentBids[i] = new JLabel("You have a bid for " + f0.format(currentBids[i]));
			}
			curBidsTab.add(lblCurrentBids[i]);
			update[i] = new JButton("Update Bid");
			curBidsTab.add(update[i]);
			update[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent a0) {
					try {
						String input = JOptionPane.showInputDialog(frame, "Enter new bid");
						if (input != null) {
							currentBids[j] = Double.parseDouble(input);
							if (currentBids[j] > previousBids[j]) {
								JOptionPane.showMessageDialog(frame, 
										"You must enter a bid less than the previous bid",
											"Invalid Bid", JOptionPane.ERROR_MESSAGE);
							} else {
								lblCurrentBids[j].setText("You have a bid for "
										+ f0.format(currentBids[j]));
								curBidsTab.validate();
								curBidsTab.repaint();
							}
						}
						
					} catch (IllegalArgumentException e) {
						JOptionPane.showMessageDialog(frame, "Invalid Input");
					}

				}

			});
		}

	}

	/**
	 * This method builds and populates the calendar tab.
	 */
	public static void buildCalendarTab() {
		JPanel calendarTab = new JPanel();
		pageTabs.addTab("Calendar", null, calendarTab, null);
	}

	/**
	 * This method builds and populates the profile editor tab.
	 */
	public static void buildProfileEditorTab() {
		profileTab = new JPanel();
		pageTabs.addTab("Edit Profile", null, profileTab, null);
		profileTab.setLayout(null);

		populateProfileTab();
	}
	
	/**
	 * This method sets up the initial window.
	 */
	public static void main(String[] args) {
		LOG.trace("Starting Contractor client...");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContractorClient.initialize();
					ContractorClient.frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "The "
							+ "GUI couldn't build", "GUI Failure", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
	}
}
