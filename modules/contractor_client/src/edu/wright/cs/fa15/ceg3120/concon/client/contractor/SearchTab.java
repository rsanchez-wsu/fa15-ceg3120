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

import edu.wright.cs.fa15.ceg3120.concon.client.contractor.CurBidsTab;
import edu.wright.cs.fa15.ceg3120.concon.client.contractor.OpenJob;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;


/**
 * Calendar Tab.
 *
 */
public class SearchTab extends JLayeredPane {
	/**
	 * Javaoc needed.
	 *
	 */
	public static final class RenderPrepare extends JTable {
		private static final long serialVersionUID = 1L;

		/**
		 * Javadoc needed.
		 * @param dm.
		 */
		public RenderPrepare(TableModel dm) {
			super(dm);
		}

		/**
		 * Javaoc needed.
		 */
		public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
			Component c0 = super.prepareRenderer(renderer, row, column);
			if (c0 instanceof JComponent) {
				if (column > 0 && column < 2) {
					JComponent jc = (JComponent) c0;
					jc.setToolTipText((String) getValueAt(row, column));
				} else if (column > 1 && column < 3) {
					JComponent jc = (JComponent) c0;
					jc.setToolTipText((String) getValueAt(row, column));
					Dimension d0 = jc.getPreferredSize();
					if (d0.getWidth() > 200) {
						final String html1 = "<html><body style='width:";
						final String html2 = "px'>";
						final String html3 = "</body></html>";
						jc.setToolTipText(html1 + 200 + html2
								+ (String) getValueAt(row, column)
								+ html3);							
					}
				} else {
					JComponent jc = (JComponent) c0;
					jc.setToolTipText("");
				}
			}
			return c0;
		}
	}

	/**
	 * Action when Job Details JButton is clicked.
	 *
	 */
	public static final class ActionBtnJobDetailsClick implements
			ActionListener {
		private final JTable tblSearchResults;
		int intTableLength = -1;
		int intSelectedRow = -1;

		/**
		 * Javadoc needed.
		 * @param tblSearchResults.
		 */
		public ActionBtnJobDetailsClick(JTable tblSearchResults) {
			this.tblSearchResults = tblSearchResults;
		}

		/**
		 * Javadoc needed.
		 */
		public void actionPerformed(ActionEvent arg0) {
			intTableLength = tblSearchResults.getRowCount();
			if (intTableLength > 0) {
				if (tblSearchResults.getSelectedRowCount() > 0 
						&& tblSearchResults.getSelectedRowCount() < 2) {
					intSelectedRow = tblSearchResults.getSelectedRow();
					showJobDetailsDialog(jobList.get(intSelectedRow));
				} else if (tblSearchResults.getSelectedRowCount() > 1) {
					JOptionPane.showMessageDialog(null, "Please only "
							+ "select one row to display details.");
				} else {
					JOptionPane.showMessageDialog(null, "You must "
							+ "select a row to view the details.");
				}
			}
		}
	}

	/**
	 * Action for when selection is made in ComboBox.
	 *
	 */
	public static final class ComboBoxSelectionMade implements ActionListener {
		private final JComboBox<String> cboSearchOptions;
		private final JTextField txtSearchOptions;

		/**
		 * Javadoc needed.
		 * @param cboSearchOptions.
		 * @param txtSearchOptions.
		 */
		public ComboBoxSelectionMade(JComboBox<String> cboSearchOptions,
				JTextField txtSearchOptions) {
			this.cboSearchOptions = cboSearchOptions;
			this.txtSearchOptions = txtSearchOptions;
		}

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
	}

	/**
	 * Action for when btnSearchGo is clicked.
	 *
	 */
	public static final class ActionBtnSearchGoClick implements ActionListener {
		private final JTextField txtSearchOptions;
		private final JTable tblSearchResults;
		int intResultCount = 0;

		/**
		 * Javadoc needed.
		 * @param txtSearchOptions.
		 * @param tblSearchResults.
		 */
		public ActionBtnSearchGoClick(JTextField txtSearchOptions,
				JTable tblSearchResults) {
			this.txtSearchOptions = txtSearchOptions;
			this.tblSearchResults = tblSearchResults;
		}

		/**
		 * Javadoc needed.
		 */
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
				int curZip = Integer.parseInt(ProfileTab.user.getZipCode());
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
										null,
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
					if (jobList.get(i).getJobCost() <= tempCostInt) {
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
					if (jobList.get(i).getJobDuration() <= tempDurationInt) {
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
	}

	private static final long serialVersionUID = 1L;
	private static Vector<Object> tempVec = new Vector<Object>();
	private static int intSearch = 0;
	private static DefaultTableModel model1 = null;
	private static DecimalFormat f0 = new DecimalFormat("##.00");
	private static String[] columnNames 
	= {"Job Number", "Title", "Description", "City", "Cost", "Duration", "Zip Code"};
	private static ArrayList<OpenJob> jobList = new ArrayList<OpenJob>();
	private static JLabel lblNumResults1 = new JLabel();
	private static JLabel lblNumResults2 = new JLabel();
	private static JLabel lblNumResults3 = new JLabel();
	private static JLabel lblNumResults4 = new JLabel();
	private static JLabel lblNumResults5 = new JLabel();
	private static JLabel lblNumResults6 = new JLabel();
	private static JButton btnJobDetails = new JButton();
	private static ArrayList<OpenJob> myJobList = new ArrayList<OpenJob>();
	
	/**
	 * Build the tab.
	 */
	public SearchTab() {
		JPanel searchTab = new JPanel();
		add(searchTab, BorderLayout.CENTER);
		searchTab.setVisible(true);
		searchTab.setLayout(null);
		
		populateJobListArray();
		
		lblNumResults1.setText("Showing results ");
		lblNumResults3.setText(" to ");
		lblNumResults5.setText(" of" );
		
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
		cboSearchOptions.addActionListener(
				new ComboBoxSelectionMade(cboSearchOptions, txtSearchOptions));
		
		buildTable();
		final JTable tblSearchResults = new RenderPrepare(model1);
		JScrollPane jscSearchResults = new JScrollPane(tblSearchResults);
		jscSearchResults.setBounds(45, 45, 610, 200);
		searchTab.add(jscSearchResults);
		
		hideResultLabels();
		
		lblNumResults1.setBounds(45, 250, 100, 20);
		searchTab.add(lblNumResults1);
		
		lblNumResults2.setBounds(145, 250, 20, 20);
		searchTab.add(lblNumResults2);
		
		lblNumResults3.setBounds(165, 250, 20, 20);
		searchTab.add(lblNumResults3);
		
		lblNumResults4.setBounds(185, 250, 20, 20);
		searchTab.add(lblNumResults4);
		
		lblNumResults5.setBounds(205, 250, 20, 20);
		searchTab.add(lblNumResults5);
		
		lblNumResults6.setBounds(225, 250, 20, 20);
		searchTab.add(lblNumResults6);
		
		btnJobDetails.setBounds(535, 250, 120, 20);
		btnJobDetails.setText("Details");
		searchTab.add(btnJobDetails);
		
		btnJobDetails.addActionListener(new ActionBtnJobDetailsClick(tblSearchResults));
		
		JButton btnSearchGo = new JButton("Search");
		btnSearchGo.setBounds(535, 5, 120, 20);
		searchTab.add(btnSearchGo);
		
		btnSearchGo.addActionListener(new ActionBtnSearchGoClick(
				txtSearchOptions, tblSearchResults));
	}
	
	/**
	 * This method sets the table model.
	 */
	public static void buildTable() {
		model1 = new DefaultTableModel(columnNames, 0) {

			private static final long serialVersionUID = 1L;
			
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
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
		OpenJob job5 = new OpenJob();
		job5.setJobNumber(125);
		job5.setJobTitle("Lorem Ipsum");
		job5.setJobDesc("Is simply dummy text of the printing and typesetting industry."
				+ " Lorem Ipsum has been the industry's standard dummy text ever since"
				+ " the 1500s, when an unknown printer took a galley of type and scrambled"
				+ " it to make a type specimen book.");
		job5.setJobCity("Vandalia");
		job5.setJobCost(1000);
		job5.setJobDuration(10);
		job5.setJobZipCode(45377);
		job5.setJobDistance(-1);
		jobList.clear();
		jobList.add(job1);
		jobList.add(job2);
		jobList.add(job3);
		jobList.add(job4);
		jobList.add(job5);
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
		btnJobDetails.setVisible(false);
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
		btnJobDetails.setVisible(true);
	}
	
	/**
	 * Javadoc needed.
	 */
	public static void showJobDetailsDialog(OpenJob curJob) {
		final OpenJob currentJob = curJob;
		final JDialog dlgJobDetails = new JDialog();
		dlgJobDetails.setBounds(250, 150, 400, 300);
		dlgJobDetails.setVisible(true);
		Container c0 = dlgJobDetails.getContentPane();
		c0.setBackground(Color.orange);
		ImageIcon imgIcon = new ImageIcon("images/c2-icon.png");
		dlgJobDetails.setIconImage(imgIcon.getImage());
		dlgJobDetails.setTitle("Job Details");
		dlgJobDetails.setLayout(null);
		
		JTextField txtTitleLabel = new JTextField("Title:");
		dlgJobDetails.add(txtTitleLabel);
		txtTitleLabel.setBounds(15, 15, 80, 20);
		txtTitleLabel.setEditable(false);
		
		JTextField txtDescLabel = new JTextField("Description:");
		txtDescLabel.setBounds(15, 45, 80, 20);
		dlgJobDetails.add(txtDescLabel);
		txtDescLabel.setEditable(false);
		
		JTextField txtCityLabel = new JTextField("City:");
		txtCityLabel.setBounds(15, 115, 80, 20);
		dlgJobDetails.add(txtCityLabel);
		txtCityLabel.setEditable(false);
		
		JTextField txtCostLabel = new JTextField("Cost:");
		txtCostLabel.setBounds(15, 145, 80, 20);
		dlgJobDetails.add(txtCostLabel);
		txtCostLabel.setEditable(false);
		
		JTextField txtDurLabel = new JTextField("Duration:");
		txtDurLabel.setBounds(15, 175, 80, 20);
		dlgJobDetails.add(txtDurLabel);
		txtDurLabel.setEditable(false);		
		
		JTextField txtTitleText = new JTextField(currentJob.getJobTitle());
		txtTitleText.setBounds(145, 15, 200, 20);
		dlgJobDetails.add(txtTitleText);
		txtTitleText.setEditable(false);
		
		final String html1 = "<html><body style='width: ";
		final String html2 = " px'>";
		JLabel lblDescText = new JLabel(html1 + 150 + html2 + currentJob.getJobDesc());
		JScrollPane scrDesc = new JScrollPane(lblDescText, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrDesc.setBounds(145, 45, 200, 60);
		dlgJobDetails.add(scrDesc);
		
		JTextField txtCityText = new JTextField(currentJob.getJobCity());
		txtCityText.setBounds(145, 115, 120, 20);
		dlgJobDetails.add(txtCityText);
		txtCityText.setEditable(false);
		
		JTextField txtCostText = new JTextField(f0.format(currentJob.getJobCost()));
		txtCostText.setBounds(145, 145, 120, 20);
		dlgJobDetails.add(txtCostText);
		txtCostText.setEditable(false);
		
		JTextField txtDurText = new JTextField();
		int testNum = currentJob.getJobDuration();
		if (testNum > 1) {
			txtDurText.setText(String.valueOf(currentJob.getJobDuration()) + " days");
		} else {
			txtDurText.setText(String.valueOf(currentJob.getJobDuration()) + " day");
		}
		txtDurText.setBounds(145, 175, 120, 20);
		dlgJobDetails.add(txtDurText);
		txtDurText.setEditable(false);
		
		JTextField txtBidLabel = new JTextField("Enter a bid:");
		txtBidLabel.setBounds(15, 205, 80, 20);
		dlgJobDetails.add(txtBidLabel);
		txtBidLabel.setEditable(false);
		
		final JTextField txtBidText = new JTextField();
		txtBidText.setBounds(145, 205, 80, 20);
		dlgJobDetails.add(txtBidText);
		
		JButton btnSubmitBid = new JButton("Submit Bid");
		btnSubmitBid.setBounds(245, 205, 100, 20);
		dlgJobDetails.add(btnSubmitBid);
		
		btnSubmitBid.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int intChecker = 0;
				currentJob.setJobCurBid(Double.parseDouble(txtBidText.getText()));
				if (myJobList.size() < 1) {
					myJobList.add(currentJob);
					System.out.println("*** " + myJobList.indexOf(currentJob));
					CurBidsTab.updateCurrentBidsTab();
					dlgJobDetails.dispose();
				} else {
					for (int i = 0; i < myJobList.size(); i++) {
						if (myJobList.get(i).getJobNumber() == currentJob.getJobNumber()) {
							intChecker++;
							JOptionPane.showMessageDialog(null, "You have already bid "
									+ "on this job. Please check your current bids.");
							dlgJobDetails.dispose();
						}
					}
					if (intChecker < 1) {
						myJobList.add(currentJob);
						CurBidsTab.updateCurrentBidsTab();
						dlgJobDetails.dispose();
					}
				}
			}
		});
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
		newVec.add(4, f0.format(newJob.getJobCost()));
		int testNum = newJob.getJobDuration();
		if (testNum > 1) {
			newVec.add(5, newJob.getJobDuration() + " days");
		} else {
			newVec.add(5, newJob.getJobDuration() + " day");
		}
		newVec.add(6, newJob.getJobZipCode());
		if (newJob.getJobDistance() > -1) {
			newVec.add(7, newJob.getJobDistance());
		}
		
		return newVec;
	}
	
	/**
	 * This method calculates the distance between ZIP codes 
	 * by pulling all ZIP codes within a radius.
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
}