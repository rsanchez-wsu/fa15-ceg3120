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
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
/**
 * Class.
 */
public class OpenJobsTab {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpenJobsTab window = new OpenJobsTab();
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
	public OpenJobsTab() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		frame.getContentPane().add(panel, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new SubmitButtonListener());

		JLabel lblSearchJobs = new JLabel("Search Jobs");
		panel.add(lblSearchJobs);

		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(22);
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(btnNewButton);

		JPanel panel1 = new JPanel();
		frame.getContentPane().add(panel1, BorderLayout.CENTER);

		JTree tree = new JTree();
		tree.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode1()));
		panel1.add(tree);
	}
	/**
	 * TODO.
	 * @author aaron
	 *
	 */
	static class SubmitButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	/**
	 * TODO.
	 * @author aaron
	 *
	 */
	static class DefaultMutableTreeNode1 extends DefaultMutableTreeNode {

		private static final long serialVersionUID = 1L;
		/**
		 * Todo.
		 */
		public DefaultMutableTreeNode1() {
			super("View");
			DefaultMutableTreeNode node1;
			DefaultMutableTreeNode node2;
			DefaultMutableTreeNode node3;
			node1 = new DefaultMutableTreeNode("Jobs");
			node2 = new DefaultMutableTreeNode("Job - Info\t");
			node3 = new DefaultMutableTreeNode("Contractor Bid");
			node3.add(new DefaultMutableTreeNode("Contractor Profile"));
			node2.add(node3);
			node3 = new DefaultMutableTreeNode("Contractor Bid");
			node3.add(new DefaultMutableTreeNode("Contractor Profile"));
			node2.add(node3);
			node1.add(node2);
			node2 = new DefaultMutableTreeNode("Job - Info");
			node3 = new DefaultMutableTreeNode("Contrator Bid");
			node3.add(new DefaultMutableTreeNode("Contractor Profile"));
			node2.add(node3);
			node3 = new DefaultMutableTreeNode("Contrator Bid");
			node3.add(new DefaultMutableTreeNode("Contractor Profile"));
			node2.add(node3);
			node3 = new DefaultMutableTreeNode("Contrator Bid");
			node3.add(new DefaultMutableTreeNode("Contractor Profile"));
			node2.add(node3);
			node1.add(node2);
			node2 = new DefaultMutableTreeNode("Job - Info");
			node3 = new DefaultMutableTreeNode("Contrator Bid");
			node3.add(new DefaultMutableTreeNode("Contractor Profile"));
			node2.add(node3);
			node2.add(new DefaultMutableTreeNode(""));
			node1.add(node2);
			add(node1);
		}
		
	}
}
