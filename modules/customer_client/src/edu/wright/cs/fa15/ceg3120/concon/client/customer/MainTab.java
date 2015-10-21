package edu.wright.cs.fa15.ceg3120.concon.client.customer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class MainTab extends JLayeredPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public MainTab() {
		setForeground(Color.ORANGE);
		setBackground(Color.ORANGE);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel newsLabel = new JLabel("News");
		newsLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		newsLabel.setForeground(Color.BLUE);
		panel.add(newsLabel, BorderLayout.NORTH);
		
		JTextPane newsTextArea = new JTextPane();
		newsTextArea.setEditable(false);
		newsTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		newsTextArea.setBackground(Color.ORANGE);
		newsTextArea.setForeground(Color.BLUE);
		newsTextArea.setText("Version 1.0.12 is now available!\r\n\r\nNews!\r\n\r\nMore Stuff!");
		panel.add(newsTextArea, BorderLayout.WEST);

	}

}
