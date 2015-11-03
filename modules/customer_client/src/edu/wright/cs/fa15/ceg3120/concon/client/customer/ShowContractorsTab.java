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

package edu.wright.cs.fa15.ceg3120.concon.client.customer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
//import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Enumeration;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 * The ShowContractorsTab class builds the tab which shows all contractors
 * currently in the database and allows the user to expand/collapse nodes
 * as necessary to view their information. The contractors tree is also
 * able to be searched, taking the user to the node if found and displaying
 * an error message if not.
 * 
 * @author Katrina Scott
 */

public class ShowContractorsTab extends JLayeredPane {
	
	private static final long serialVersionUID = 1L;
	private JTextField searchField;
	private JTree tree;
	
	/**
	 * ShowContractorsTab constructor.
	 */
	
	public ShowContractorsTab() {
		
		super();
		setLayout(new BorderLayout());
		buildPane();
		
	} // end of constructor
	
	/**
	 * Initialize builds the frame and sets up all elements (layout, panels, trees, search bar).
	 */
	
	private void buildPane() {

		// Create panel for search bar
		JPanel searchPanel = new JPanel();
		FlowLayout layout1 = (FlowLayout) searchPanel.getLayout();
		layout1.setAlignment(FlowLayout.RIGHT);
		add(searchPanel, BorderLayout.NORTH);

		JLabel searchLabel = new JLabel("Search");
		searchPanel.add(searchLabel);

		searchField = new JTextField();
		searchField.setColumns(15);
		
		// Add listener to search bar
		searchField.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent keyPressed) {
				// If enter is pressed
				if (keyPressed.getKeyCode() == KeyEvent.VK_ENTER) {
					// Get text and search tree
					String searchTerm = searchField.getText();
					TreePath path = find(searchTerm);
					if (path != null) {
						// Select and scroll to found node
						tree.setSelectionPath(path);
						tree.scrollPathToVisible(path);
					} else {
						// Display error message
						JOptionPane.showMessageDialog(null, "Contractor not found", 
								"Search Failed", JOptionPane.WARNING_MESSAGE);
					}
				} // end if-enter
			} // end keyPressed method
		});
		searchPanel.add(searchField);
		
		// Create panel for tree
		JPanel treePanel = new JPanel();
		FlowLayout layout2 = (FlowLayout) treePanel.getLayout();
		layout2.setAlignment(FlowLayout.CENTER);
		add(treePanel, BorderLayout.CENTER);
		
		// Create tree
		tree = new JTree();
		//tree.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		tree.setModel(new DefaultTreeModel(new CustomTreeNode()));
		
		// Make tree scrollable
		JScrollPane treeScroll = new JScrollPane(tree, 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		treePanel.add(treeScroll);
		
	} // end of initialize method
	
	/**
	 * The find method finds the queried term in the tree returns a
	 * path to the node. As of now, the full node must be specified 
	 * in order to be found.
	 * 
	 * @param searchTerm	The String the user searched
	 */
	
	private TreePath find(String searchTerm) {
		
		DefaultMutableTreeNode root = (DefaultMutableTreeNode)tree.getModel().getRoot();
		@SuppressWarnings("unchecked")
		Enumeration<DefaultMutableTreeNode> enumerator = root.depthFirstEnumeration();
		
		while (enumerator.hasMoreElements()) {
			DefaultMutableTreeNode node = enumerator.nextElement();
			if (node.toString().equalsIgnoreCase(searchTerm)) {
				return new TreePath(node.getPath());
			}
		}
		return null;
		
	} // end find method
	
	/**
	 * ToDo.
	 */
	
	static class CustomTreeNode extends DefaultMutableTreeNode {

		private static final long serialVersionUID = 1L;
		
		/**
		 * ToDo.
		 */
		
		public CustomTreeNode() {
			
			super("Contractors");
			
			DefaultMutableTreeNode name;
			DefaultMutableTreeNode phone;
			DefaultMutableTreeNode website;
			
			// Filled with dummy data for now to test searching and displaying
			name = new DefaultMutableTreeNode("Bob The Builder Inc.");
			phone = new DefaultMutableTreeNode("937-123-4567");
			website = new DefaultMutableTreeNode("www.bobthebuilder.com");
			name.add(phone);
			name.add(website);
			
			// This is kind of obnoxious but it makes Checkstyle happy
			DefaultMutableTreeNode job;
			DefaultMutableTreeNode rating;
			DefaultMutableTreeNode review;
			
			job = new DefaultMutableTreeNode("Job 6543");
			rating = new DefaultMutableTreeNode("*****");
			review = new DefaultMutableTreeNode("On time and fixed it perfectly!");
			job.add(rating);
			job.add(review);
			name.add(job);
			job = new DefaultMutableTreeNode("Job 4828");
			rating = new DefaultMutableTreeNode("**");
			review = new DefaultMutableTreeNode("Ruined my backyard");
			job.add(rating);
			job.add(review);
			name.add(job);
			job = new DefaultMutableTreeNode("Job 1863");
			rating = new DefaultMutableTreeNode("****");
			review = new DefaultMutableTreeNode("Exactly what I needed");
			job.add(rating);
			job.add(review);
			name.add(job);
			add(name);
			
			name = new DefaultMutableTreeNode("Handy Manny LLC.");
			phone = new DefaultMutableTreeNode("324-329-1006");
			website = new DefaultMutableTreeNode("www.handymanny.com");
			name.add(phone);
			name.add(website);
			job = new DefaultMutableTreeNode("Job 6543");
			rating = new DefaultMutableTreeNode("*****");
			review = new DefaultMutableTreeNode("On time and fixed it perfectly!");
			job.add(rating);
			job.add(review);
			name.add(job);
			job = new DefaultMutableTreeNode("Job 4828");
			rating = new DefaultMutableTreeNode("**");
			review = new DefaultMutableTreeNode("Ruined my backyard");
			job.add(rating);
			job.add(review);
			name.add(job);
			job = new DefaultMutableTreeNode("Job 1863");
			rating = new DefaultMutableTreeNode("****");
			review = new DefaultMutableTreeNode("Exactly what I needed");
			job.add(rating);
			job.add(review);
			name.add(job);
			add(name);
			
			name = new DefaultMutableTreeNode("Can We Fix It Construction");
			phone = new DefaultMutableTreeNode("616-846-9982");
			website = new DefaultMutableTreeNode("www.cwficon.com");
			name.add(phone);
			name.add(website);
			job = new DefaultMutableTreeNode("Job 6543");
			rating = new DefaultMutableTreeNode("*****");
			review = new DefaultMutableTreeNode("On time and fixed it perfectly!");
			job.add(rating);
			job.add(review);
			name.add(job);
			job = new DefaultMutableTreeNode("Job 4828");
			rating = new DefaultMutableTreeNode("**");
			review = new DefaultMutableTreeNode("Ruined my backyard");
			job.add(rating);
			job.add(review);
			name.add(job);
			job = new DefaultMutableTreeNode("Job 1863");
			rating = new DefaultMutableTreeNode("****");
			review = new DefaultMutableTreeNode("Exactly what I needed");
			job.add(rating);
			job.add(review);
			name.add(job);
			add(name);
			
			/**
			 * Ignore below- just preparing to replace testing/dummy data with 
			 * actual queried Contractor info.
			 */
			
			// Declare nodes
			// Get set of Contractors (does DB even have something for this yet?)
			// Iterate through
			// Get name, phone, website
			// Add phone and website to name node
			// Get set of jobs/reviews associated with each Contractor
			// Iterate through
			// Get job ID, rating, review
			// Add rating and review to job ID
			// Add job ID to name
			// Add name to tree
			// Repeat for all Contractors
			
		} // end of constructor
	} // end of custom node class

} // end of class
