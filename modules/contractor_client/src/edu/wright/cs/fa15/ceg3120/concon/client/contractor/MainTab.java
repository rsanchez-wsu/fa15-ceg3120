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
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

/**
 * Main contractor tab.
 *
 */
public class MainTab extends JLayeredPane {
	/**
	 * Javadoc needed.
	 *
	 */
	public static final class NewDefaultMutableTreeNode extends
			DefaultMutableTreeNode {
		/**
		 * Creates the tree.
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

		/**
		 * Javadoc needed.
		 * @param userObject.
		 */
		public NewDefaultMutableTreeNode(Object userObject) {
			super(userObject);
		}
	}
	
	private static final long serialVersionUID = 1L;
	private JTree mainTree;
	
	private static JTextPane thisTextPane = new JTextPane();
	
	private static final int WINDOW_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width
			- 150;
	private static final int WINDOW_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height
			- 150;
	private static final int WINDOW_HEIGHT_QUARTER = (Toolkit.getDefaultToolkit()
			.getScreenSize().height - 150) / 4;
	
	/**
	 * Create the panel.
	 */
	public MainTab() {
		JPanel main = new JPanel();
		add(main);
		main.setLayout(null);

		addContainer();

	}
	
	/**
	 * Add container to main tab.
	 */
	private void addContainer() {
		add(addFields());
	}
	
	/**
	 * Add elements to the container.
	 */
	private Container addFields() {
		Container cont = new Container();
		cont.setLayout(null);
		cont.setBounds(0, 0, WINDOW_WIDTH - 12, (WINDOW_HEIGHT - WINDOW_HEIGHT_QUARTER) - 12);
		mainTree = new JTree();
		mainTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		mainTree.addTreeSelectionListener((TreeSelectionListener) new SelectionListener());
		mainTree.setModel(new DefaultTreeModel(
						new NewDefaultMutableTreeNode("Main")
		));

		mainTree.setBounds(6, 6, (WINDOW_WIDTH / 4), (((WINDOW_HEIGHT 
				- (WINDOW_HEIGHT / 4)) - 48)));

		thisTextPane.setBounds((WINDOW_WIDTH / 4) + 6, 6, ((WINDOW_WIDTH 
				- (WINDOW_WIDTH / 4)) - 30), 
				(((WINDOW_HEIGHT - (WINDOW_HEIGHT / 4)) - 48)));
		thisTextPane.setText(getMaintext());
		add(mainTree);
		add(thisTextPane);


		Dimension mainTreeMaxSize = new Dimension((WINDOW_WIDTH / 4),
				(WINDOW_HEIGHT - WINDOW_HEIGHT_QUARTER));
		mainTree.setMaximumSize(mainTreeMaxSize);
		mainTree.setBounds(0, 0,mainTreeMaxSize.width, mainTreeMaxSize.height);
		Dimension thisTextPaneMaxSize = new Dimension(((WINDOW_WIDTH - (WINDOW_WIDTH / 4))),
				(WINDOW_HEIGHT - WINDOW_HEIGHT_QUARTER));
		thisTextPane.setMaximumSize(thisTextPaneMaxSize);
		thisTextPane.setBounds((mainTreeMaxSize.width + 6), 0,
				thisTextPaneMaxSize.width, thisTextPaneMaxSize.height);
		
		cont.add(mainTree);
		cont.add(thisTextPane);
		
		return cont;

	}
	
	/**
	 * This class listens for selection made by the user on the Jtree and changes
	 * the text in the text pane accordingly.
	 * @author Bret Tagliaferri
	 */
	public static class SelectionListener implements TreeSelectionListener {
		String treeText;
		/**
		 * Method that changes text based on tree selection.
		 */
		public void valueChanged(TreeSelectionEvent se) {
			JTree tree = (JTree) se.getSource();
			DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree
					.getLastSelectedPathComponent();			    
			String selectedNodeName = selectedNode.toString();	    
			if (selectedNodeName.equals("Main")) {
				treeText = getMaintext();
				thisTextPane.setText(treeText);
			} else if (selectedNodeName.equals("Description")) {
				treeText = getDescription();
				thisTextPane.setText(treeText);		
			} else if (selectedNodeName.equals("Photos")) {
				treeText = getPhoto();
				thisTextPane.setText(treeText);		 
			}	  
		}
	}
	
	/**
     * Changes the text pane when the main node is selected.
     * @return String containing text for main node.
     */
	public static String getMaintext() {
		String mainText = "";
		mainText = "This is the main page!";
		return mainText;
	}
	/**
     * Changes the text pane when a Description node is selected.
     * @return String containing text for Description node.
     */
	public static String getDescription() {
		String description = "";
		description = "This is a description of the previous job!";
		return description;
	}
	/**
	 * Changes the text pane when a Photo node is selected.
	 * @return String containing text for the Photo node.
	 */
	public static String getPhoto() {
		String photo = "";
		photo = "Insert picture here!";
		return photo;
	}
}