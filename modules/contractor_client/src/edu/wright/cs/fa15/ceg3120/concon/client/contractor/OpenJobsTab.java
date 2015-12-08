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
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Open Jobs Tab.
 *
 */
public class OpenJobsTab extends JLayeredPane {

	private static final long serialVersionUID = 1L;
	
	private static final int WINDOW_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width
			- 150;
	private static final int WINDOW_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height
			- 150;
	private static final int WINDOW_HEIGHT_QUARTER = (Toolkit.getDefaultToolkit()
			.getScreenSize().height - 150) / 4;
	
	/**
	 * Build the tab.
	 */
	public OpenJobsTab() {
		JPanel openJobs = new JPanel();
		add(openJobs);
		openJobs.setLayout(null);
		
		addContainer();
		
	}
	
	/**
	 * Adds container to panel.
	 */
	private void addContainer() {
		add(addFields());
	}
	
	/**
	 * Adds fields to container.
	 * @return container.
	 */
	private static Container addFields() {
		Container cont = new Container();
		cont.setBounds(6, 6, WINDOW_WIDTH, 
				(WINDOW_HEIGHT - WINDOW_HEIGHT_QUARTER));
		cont.setLayout(null);
		
		JLabel openJobSearchLabel = new JLabel("Search for open jobs");
		cont.add(openJobSearchLabel);
		openJobSearchLabel.setBounds(900, 5, 120, 20);
		
		JButton openJobSearchButton = new JButton("Search");
		openJobSearchButton.setBounds(1025, 5, 120, 20);
		cont.add(openJobSearchButton);
		
		String[] columnName = {"Job Number", "Location", "Date Started", "Balance"};
		final DefaultTableModel openJob = new DefaultTableModel(columnName, 0);
		JTable tblOpenJobResults = new JTable(openJob);
		JScrollPane openJobResults = new JScrollPane(tblOpenJobResults);
		openJobResults.setBounds(45, 45, 1100, 275);
		cont.add(openJobResults);
		
		return cont;
	}

}
