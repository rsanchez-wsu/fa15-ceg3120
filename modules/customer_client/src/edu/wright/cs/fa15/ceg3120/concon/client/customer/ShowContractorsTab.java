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

//import edu.wright.cs.fa15.ceg3120.concon.common.data.ContractorAccount;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Enumeration;
import java.util.regex.Pattern;

//import javax.swing.JButton;
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
					TreePath[] paths = find(searchTerm);
					if (paths != null) {
						// Selects and expands to found nodes
						tree.setSelectionPaths(paths);
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
		add(treePanel, BorderLayout.CENTER);
		
		// Create tree
		tree = new JTree();
		//tree.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		tree.setModel(new DefaultTreeModel(new CustomTreeNode()));
		tree.setExpandsSelectedPaths(true);
		
		// Make tree scrollable
		JScrollPane treeScroll = new JScrollPane(tree, 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		treePanel.add(treeScroll);
		
		/**
		 * Ignore below- commented out because it caused the build to fail
		 * will uncomment when ready to implement.
		 */
		
		/*
		JButton messageButton = new JButton("Message Contractor");
		messageButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent click) {
				
				// will actually implement once the messaging tab is set up
				
				// get selected node in tree
				// open messaging tab, autofill to selected contractor
				
			}
		});
		add(messageButton, BorderLayout.SOUTH);
		*/
		
	} // end of initialize method
	
	/**
	 * The find method matches the queried term with nodes in the tree
	 * and returns paths to the node. The term may be any case and anywhere
	 * in the node.
	 * 
	 * @param searchTerm	The String the user searched
	 * @return				Returns an array of paths to matching nodes, or
	 * 						if none found, return null
	 */
	
	private TreePath[] find(String searchTerm) {
		
		DefaultMutableTreeNode root = (DefaultMutableTreeNode)tree.getModel().getRoot();
		@SuppressWarnings("unchecked")
		Enumeration<DefaultMutableTreeNode> enumerator = root.depthFirstEnumeration();
		// temporary - allows max of 50 nodes to be selected
		TreePath[] allPaths = new TreePath[50];
		int index = 0;
		
		// creates pattern to match searched term
		String escapedFragment = Pattern.quote(searchTerm);
		String fragmentAnywhereInString = ".*" + escapedFragment + ".*";
		String caseInsensitiveFragment = "(?i)" + fragmentAnywhereInString;
		
		while (enumerator.hasMoreElements()) {
			DefaultMutableTreeNode node = enumerator.nextElement();
			if (node.toString().matches(caseInsensitiveFragment)) {
				allPaths[index] = new TreePath(node.getPath());
				index++;
			} // end of if-matched
		} // end of enumerator while
		
		// if index is never incremented, return null
		if (index == 0) {
			return null;
		// otherwise, return paths
		} else {
			return allPaths;
		}
		
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
			
			name = new DefaultMutableTreeNode("The Other Bob Corp.");
			phone = new DefaultMutableTreeNode("624-987-4756");
			website = new DefaultMutableTreeNode("www.notbobthebuilder.com");
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
			
			/*
			// Declare nodes
			// Get set of Contractors - temporarily just a new ContractorAccount 
			ContractorAccount contractor = new ContractorAccount();
			// Iterate through
			// Get name, phone, website/email (company?)
			name = new DefaultMutableTreeNode(contractor.getFirstName() + " " + 
				contractor.getLastName());
			phone = new DefaultMutableTreeNode(contractor.getPhoneNumber());
			website = new DefaultMutableTreeNode(contractor.getEmailAddress());
			// Add phone and website to name node
			name.add(phone);
			name.add(website);
			// Get set of jobs/reviews associated with each Contractor
			// Iterate through
			// Get job ID, rating, review
			// Add rating and review to job ID
			// Add job ID to name
			// Add name to tree
			// Repeat for all Contractors
			*/
			
		} // end of constructor
	} // end of custom node class

} // end of class
