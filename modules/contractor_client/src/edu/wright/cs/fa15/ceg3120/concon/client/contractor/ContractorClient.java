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
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class ContractorClient {

	private JFrame frame;
	
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
		
		JPanel calendarTab = new JPanel();
		pageTabs.addTab("Calendar", null, calendarTab, null);
		
		JPanel openJobsTab = new JPanel();
		pageTabs.addTab("Open Jobs", null, openJobsTab, null);
	}
}