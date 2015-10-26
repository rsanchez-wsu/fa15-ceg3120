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
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 * News and Announcements Tab.
 * 
 * @author Corey
 *
 */
public class MainTab extends JLayeredPane {
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
