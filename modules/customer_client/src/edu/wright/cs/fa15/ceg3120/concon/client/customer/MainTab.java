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

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
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
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLayeredPane layeredPane = new JLayeredPane();
		panel.add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(new BorderLayout(0, 0));

		JLayeredPane layeredPaneNews = new JLayeredPane();
		add(layeredPaneNews, BorderLayout.NORTH);
		layeredPaneNews.setBackground(Color.WHITE);
		layeredPaneNews.setLayout(new BorderLayout(0, 0));
		
		JTextPane txtpnNews = new JTextPane();
		txtpnNews.setForeground(Color.BLUE);
		txtpnNews.setEditable(false);
		txtpnNews.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtpnNews.setText("News\r\n");
		txtpnNews.setBackground(Color.ORANGE);

		layeredPaneNews.add(txtpnNews, BorderLayout.CENTER);
		
		JSeparator separator = new JSeparator();
		
		layeredPaneNews.add(separator, BorderLayout.SOUTH);

		separator.setBackground(Color.BLUE);
		separator.setToolTipText("");
		
		JTextPane textPane = new JTextPane();
		add(textPane, BorderLayout.CENTER);
		textPane.setBackground(Color.ORANGE);
		
		JTextPane newsTextPane = new JTextPane();
		add(newsTextPane, BorderLayout.CENTER);
		newsTextPane.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		newsTextPane.setBackground(Color.ORANGE);
		newsTextPane.setForeground(Color.BLUE);
		newsTextPane.setText("Version 1.0.12 is now available!\r\n\r\nNews!\r\n\r\nMore Stuff!");
		
		JScrollBar newsTextScrollBar = new JScrollBar();
		add(newsTextScrollBar, BorderLayout.EAST);

	}

}
