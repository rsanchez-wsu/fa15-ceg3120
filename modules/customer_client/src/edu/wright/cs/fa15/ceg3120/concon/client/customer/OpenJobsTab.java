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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel lblSearchJobs = new JLabel("Search Jobs");
		panel.add(lblSearchJobs);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(22);
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JTree tree = new JTree();
		tree.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("View") {
				private static final long serialVersionUID = 1L;

				{
					DefaultMutableTreeNode node_1;
					DefaultMutableTreeNode node_2;
					DefaultMutableTreeNode node_3;
					node_1 = new DefaultMutableTreeNode("Jobs");
						node_2 = new DefaultMutableTreeNode("Job - Info\t");
							node_3 = new DefaultMutableTreeNode("Contractor Bid");
								node_3.add(new DefaultMutableTreeNode("Contractor Profile"));
							node_2.add(node_3);
							node_3 = new DefaultMutableTreeNode("Contractor Bid");
								node_3.add(new DefaultMutableTreeNode("Contractor Profile"));
							node_2.add(node_3);
						node_1.add(node_2);
						node_2 = new DefaultMutableTreeNode("Job - Info");
							node_3 = new DefaultMutableTreeNode("Contrator Bid");
								node_3.add(new DefaultMutableTreeNode("Contractor Profile"));
							node_2.add(node_3);
							node_3 = new DefaultMutableTreeNode("Contrator Bid");
								node_3.add(new DefaultMutableTreeNode("Contractor Profile"));
							node_2.add(node_3);
							node_3 = new DefaultMutableTreeNode("Contrator Bid");
								node_3.add(new DefaultMutableTreeNode("Contractor Profile"));
							node_2.add(node_3);
						node_1.add(node_2);
						node_2 = new DefaultMutableTreeNode("Job - Info");
							node_3 = new DefaultMutableTreeNode("Contrator Bid");
								node_3.add(new DefaultMutableTreeNode("Contractor Profile"));
							node_2.add(node_3);
							node_2.add(new DefaultMutableTreeNode(""));
						node_1.add(node_2);
					add(node_1);
				}
			}
		));
		panel_1.add(tree);
	}

}
