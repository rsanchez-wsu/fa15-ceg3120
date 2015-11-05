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

import edu.wright.cs.fa15.ceg3120.concon.client.contractor.ContractorMainPanel;
import edu.wright.cs.fa15.ceg3120.concon.common.data.AccountType;
import edu.wright.cs.fa15.ceg3120.concon.common.data.ContractorAccount;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * This class creates the main frame and calls methods and classes to populate it.
 * 
 *
 */
public class ContractorClient extends JFrame implements ActionListener {

	/**
	 * Action for trying to close window by hitting X in corner.
	 *
	 */
	public static final class ActionTryToCloseWindow extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent w0) { 
			int exit = JOptionPane.showConfirmDialog(myFrame, "Do you want to exit?", 
					"Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (exit == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}
	
	private static ContractorAccount account = new ContractorAccount();
	private static final Logger LOG = LoggerFactory.getLogger(ContractorClient.class);
	private static final long serialVersionUID = 1L;
	private static JPanel curBidsTab;
	private static ArrayList<OpenJobClass> myJobList = new ArrayList<OpenJobClass>();
	private static ArrayList<OpenJobClass> myCurJobList = new ArrayList<OpenJobClass>();
	public static final JTabbedPane pageTabs = new JTabbedPane(JTabbedPane.TOP);
	private static DecimalFormat f1 = new DecimalFormat("$##.00");
	private static JLabel[] lblCurrentBids = new JLabel[10];
	private static JButton[] update = new JButton[10];
	private static double[] currentBids = new double[10];
	private static double[] previousBids = new double[10];
	public static final JFrame myFrame = new JFrame();
	private static final int WINDOW_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width
			- 150;
	private static final int WINDOW_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height
			- 150;
	private static final int WINDOW_HEIGHT_QUARTER = Toolkit.getDefaultToolkit()
			.getScreenSize().height	/ 4;
	private ContractorAccount user;
	
	/**
	 * Create the application.
	 */
	public ContractorClient() {		
		user = null;
	}
	
	/**
	 * Build the GUI.
	 */
	public void buildGui(ContractorAccount inUser) {
		user = inUser;
		myFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		myFrame.setLocationRelativeTo(null);
		myFrame.getContentPane().setLayout(null);
		myFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		Container c0 = myFrame.getContentPane();
		c0.setBackground(Color.orange);
		ImageIcon imgIcon = new ImageIcon("images/c2-icon.png");
		myFrame.setIconImage(imgIcon.getImage());
		myFrame.setTitle("Contractor Connect");
		myFrame.addWindowListener(new ActionTryToCloseWindow());
		
		JPanel banner = new JPanel();
		banner.setLayout(null);
		banner.setBounds(6, 0, (WINDOW_WIDTH - 12), WINDOW_HEIGHT_QUARTER);
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

		myFrame.getContentPane().add(banner);
		banner.setOpaque(false);
		JTabbedPane myPageTabs = pageTabs;
		myPageTabs = new ContractorMainPanel(user);
		myPageTabs.setBounds(6, WINDOW_HEIGHT_QUARTER, (WINDOW_WIDTH - 30), 
				(((WINDOW_HEIGHT - WINDOW_HEIGHT_QUARTER) - 48)));
		myFrame.getContentPane().add(myPageTabs, JTabbedPane.TOP);
		myFrame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public static void initialize() {
		account.setAccountType(AccountType.CONTRACTOR);
	}
	
	/**
	 * This method opens a web browser.
	 */
	public static void openWebpage(URL url) {
		URI uri = null;
		try {
			uri = url.toURI();
		} catch (URISyntaxException e1) {
			JOptionPane.showMessageDialog(myFrame, "The given URL is invalid", 
					"Invalid URL", JOptionPane.ERROR_MESSAGE);
		}
		Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
		if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
			try {
				desktop.browse(uri);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(myFrame, "The webpage couldn't open",
						"Couldn't Open Page", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * This method updates the Current Bids tab when a bid is submitted from the Search tab.
	 */
	public static void updateCurrentBidsTab() {
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
				curBidsTab.add(lblCurrentBids[0]);
				curBidsTab.add(update[0]);
			} else if (currentBids[0] > previousBids[0]) {
				lblCurrentBids[0] = new JLabel("<html>You have a bid for "
						+ f1.format(currentBids[0]) + "<br>You have been outbid by " 
							+ f1.format(previousBids[0]) + "</html>");
				curBidsTab.add(lblCurrentBids[0]);
				curBidsTab.add(update[0]);
			} else {
				JOptionPane.showMessageDialog(myFrame, 
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
					if (previousBids[k] < 1) {
						lblCurrentBids[k] = new JLabel("You have a bid for " 
								+ f1.format(currentBids[k]));
						if (lblCurrentBids[k].getParent() == curBidsTab) {
							// Do nothing as label exists
						} else {
							curBidsTab.add(lblCurrentBids[k]);
							curBidsTab.add(update[k]);
						}
					} else if (currentBids[k] > previousBids[k]) {
						lblCurrentBids[k] = new JLabel("<html>You have a bid for "
								+ f1.format(currentBids[k]) + "<br>You have been outbid by " 
									+ f1.format(previousBids[k]) + "</html>");
						if (lblCurrentBids[k].getParent() == curBidsTab) {
							// Do nothing as label exists
						} else {
							curBidsTab.add(lblCurrentBids[k]);
							curBidsTab.add(update[k]);
						}
					} else {
						JOptionPane.showMessageDialog(myFrame, 
								"You must enter a bid less than the previous bid",
									"Invalid Bid", JOptionPane.ERROR_MESSAGE);
					}
				}
			}			
		}
		curBidsTab.validate();
		curBidsTab.repaint();
	}
	
	/**
	 * This method sets up the initial window.
	 */
	public static void main(String[] args) {
		LOG.trace("Starting Contractor client...");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
//				try {
					ContractorAccount user = new ContractorAccount();
					user.setUuid("Debug");
					char[] ps = {'a','b', 'c'};
					user.setPswd(ps);
					user.setFirstName("Random");
					user.setLastName("Person");
					user.setAddress1("123 Main Street");
					user.setAddress2("Suite 500");
					user.setState("OH");
					user.setZipCode("45402");
					user.setPhoneNumber("123-456-7890");
					user.setCity("Dayton");
					user.setEmailAddress("test123@temp.com");
					new ContractorClient().buildGui(user);
//				} catch (Exception e) {
	//				JOptionPane.showMessageDialog(myFrame, "The "
		//					+ "GUI couldn't build", "GUI Failure", JOptionPane.ERROR_MESSAGE);
		//		}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e0) {
		// TODO Auto-generated method stub
		
	}
}
