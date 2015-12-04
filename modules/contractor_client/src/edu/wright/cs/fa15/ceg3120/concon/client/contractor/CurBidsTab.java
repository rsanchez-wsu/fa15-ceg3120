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

import edu.wright.cs.fa15.ceg3120.concon.client.contractor.OpenJobClass;

import java.awt.Container;
//import java.awt.GridLayout;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Current Bids Tabs.
 *
 */
public class CurBidsTab extends JLayeredPane {
	private static final long serialVersionUID = 1L;
	private static JLabel[] lblCurrentBids = new JLabel[10];
	private static JButton[] update = new JButton[10];
	private static double[] currentBids = new double[10];
	private static double[] previousBids = new double[10];
	private static ArrayList<OpenJobClass> myJobList = new ArrayList<OpenJobClass>();
	private static ArrayList<OpenJobClass> myCurJobList = new ArrayList<OpenJobClass>();
	private static DecimalFormat f1 = new DecimalFormat("$##.00");
	private static Container cont = new Container();
	private static Container newCont = new Container();
	private static Container tempCont = new Container();
	
	private static final int WINDOW_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width
			- 150;
	private static final int WINDOW_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height
			- 150;
	private static final int WINDOW_HEIGHT_QUARTER = (Toolkit.getDefaultToolkit()
			.getScreenSize().height - 150) / 4;
	
	/**
	 * Create the panel.
	 */
	public CurBidsTab() {
		JPanel curBidsTab = new JPanel();
		add(curBidsTab);
		curBidsTab.setLayout(null);
		addContainer();
		
		/**
		 * The code below can be removed after ensuring all fuctionality of the new 
		 * current bids tab is working properly.
		 */
/*		for (int i = 0; i < 5; i++) {
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
		}*/
	}
	
	/**
	 * Adds CurBids tab fields container.
	 */
	private void addContainer() {
		add(addFields());
	}
	
	/**
	 * This method constructs the container that holds the objects of the CurBids tab.
	 * @return.
	 */
	private Container addFields() {
//		tempCont = new Container();
		tempCont.setBounds(6, 6, WINDOW_WIDTH, 
				(WINDOW_HEIGHT - WINDOW_HEIGHT_QUARTER));
//		GridLayout myLayout = new GridLayout(0, 2);
		tempCont.setLayout(null);
		lblCurrentBids = new JLabel[10];
		update = new JButton[10];
		currentBids = new double[10];
		previousBids = new double[10];
		for (int i = 0; i < myJobList.size(); i++) {
			if (myJobList.get(i).getJobCurBid() > 0) {
				myJobList.get(i).setJobPrevBid(myJobList.get(i).getJobCurBid());
				currentBids[i] = myJobList.get(i).getJobCurBid();
				myCurJobList.set(i, myJobList.get(i));
			} else {
				currentBids[i] = myJobList.get(i).getJobCurBid();
				myCurJobList.set(i, myJobList.get(i));
			}
			lblCurrentBids[i].setBounds(30, ((i * 20) + 10), 200, 20);
			tempCont.add(lblCurrentBids[i]);
			update[i] = new JButton("Update Bid");
			update[i].setBounds(250, ((i * 20) + 10), 200, 20);
			tempCont.add(update[i]);
		}
		
		
		return tempCont;
	}
	
	/**
	 * This method adds an OpenJobClass object to the MyJobList array.
	 * @param curOpenJob.
	 */
	public static Boolean addToMyJobList(OpenJobClass curOpenJob) {
		int tracker = 0;
		if (myJobList.size() < 1) {
			myJobList.add(curOpenJob);
			tracker = 0;
		} else {
			for (int i = 0; i < myJobList.size(); i++) {
				if (myJobList.get(i).getJobNumber() == curOpenJob.getJobNumber()) {
					System.out.println("Job already exists!");
					tracker++;
				}
			}			
		}
		if (tracker < 1) {
			myJobList.add(curOpenJob);
			updateCurrentBidsTab();
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * This method updates the Current Bids tab when a bid is submitted from the Search tab.
	 */
	public static void updateCurrentBidsTab() {
//		newCont = new Container();
		Vector<Integer> vecTest = new Vector<Integer>();
		if (myCurJobList.isEmpty()) {
			for (int i = 0; i < myJobList.size(); i++) {
				myCurJobList.add(myJobList.get(i));
			}
			currentBids[0] = myCurJobList.get(0).getJobCurBid();
			previousBids[0] = myCurJobList.get(0).getJobPrevBid();
			update[0] = new JButton("Update Bid");
			if (previousBids[0] < 1) {
				lblCurrentBids[0] = new JLabel("You have a bid for " + f1.format(currentBids[0]));
				newCont.add(lblCurrentBids[0]);
				newCont.add(update[0]);
			} else if (currentBids[0] > previousBids[0]) {
				lblCurrentBids[0] = new JLabel("<html>You have a bid for "
						+ f1.format(currentBids[0]) + "<br>You have been outbid by " 
							+ f1.format(previousBids[0]) + "</html>");
				lblCurrentBids[0].setBounds(30, 10, 200, 20);
				newCont.add(lblCurrentBids[0]);
				update[0].setBounds(250, 10, 200, 20);
				newCont.add(update[0]);
			} else {
				JOptionPane.showMessageDialog(null, 
						"You must enter a bid less than the previous bid",
							"Invalid Bid", JOptionPane.ERROR_MESSAGE);
			}
		} else if (myCurJobList.size() != myJobList.size()) {
			for (int i = 0; i < myCurJobList.size(); i++) {
				vecTest.add(myCurJobList.get(i).getJobNumber());
			}
			for (int j = 0; j < myJobList.size(); j++) {
				if (vecTest.contains(myJobList.get(j).getJobNumber()) == false) {
					myCurJobList.add(myJobList.get(j));
				}
			}
			for (int k = 0; k < myCurJobList.size(); k++) {
				if (currentBids[k] == 0) {
					currentBids[k] = myCurJobList.get(k).getJobCurBid();
					previousBids[k] = myCurJobList.get(k).getJobPrevBid();
					update[k] = new JButton("Update Bid");
					update[k].setBounds(250, ((k * 20) + 10), 200, 20);
					if (previousBids[k] < 1) {
						lblCurrentBids[k] = new JLabel("You have a bid for " 
								+ f1.format(currentBids[k]));
						lblCurrentBids[k].setBounds(30, ((k * 20) + 10), 200, 20);
						if (lblCurrentBids[k].getParent() == cont) {
							// Do nothing as label exists
						} else {
							newCont.add(lblCurrentBids[k]);
							newCont.add(update[k]);
						}
					} else if (currentBids[k] > previousBids[k]) {
						lblCurrentBids[k] = new JLabel("<html>You have a bid for "
								+ f1.format(currentBids[k]) + "<br>You have been outbid by " 
									+ f1.format(previousBids[k]) + "</html>");
						lblCurrentBids[k].setBounds(30, ((k * 20) + 10), 200, 20);
						if (lblCurrentBids[k].getParent() == cont) {
							// Do nothing as label exists
						} else {
							newCont.add(lblCurrentBids[k]);
							newCont.add(update[k]);
						}
					} else {
						JOptionPane.showMessageDialog(null, 
								"You must enter a bid less than the previous bid",
									"Invalid Bid", JOptionPane.ERROR_MESSAGE);
					}
				}
			}			
		}
		cont = newCont;
		cont.validate();
		cont.repaint();
	}
}
