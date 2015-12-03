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

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Payments Tab.
 *
 */
public class PaymentsTab extends JLayeredPane {
	private static final long serialVersionUID = 1L;
	private static final int WINDOW_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width
			- 150;
	private static final int WINDOW_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height
			- 150;
	private static final int WINDOW_HEIGHT_QUARTER = (Toolkit.getDefaultToolkit()
			.getScreenSize().height - 150) / 4;
	
	/**
	 * This method creates and populates the Payments tab.
	 */
	public PaymentsTab() {
		JPanel payments = new JPanel();
		add(payments, BorderLayout.CENTER);
		payments.setLayout(null);
		addContainer();
	}
	
	/**
	 * Adds container to pane.
	 */
	private void addContainer() {
		add(addFields());
	}
	
	/**
	 * Adds fields to container.
	 */
	private static Container addFields() {
		Container cont = new Container();
		cont.setBounds(6, 6, WINDOW_WIDTH, 
				(WINDOW_HEIGHT - WINDOW_HEIGHT_QUARTER));
		cont.setLayout(null);
		
		
		JLabel paymentsSearchLabel = new JLabel("Search job number:");
		cont.add(paymentsSearchLabel);
		paymentsSearchLabel.setBounds(5,5,120,20);
		
		JButton paymentsSearchButton = new JButton("Search");
		paymentsSearchButton.setBounds(530, 5, 120, 20);
		cont.add(paymentsSearchButton);
		
		final JTextField paymentsSearchOptions = new JTextField();
		paymentsSearchOptions.setBounds(275, 5, 240, 20);
		cont.add(paymentsSearchOptions);
		
		String[] columnName = {"Job Number", "Cost", "Payments", "Balance"};
		final DefaultTableModel paymentsModel = new DefaultTableModel(columnName, 0);
		JTable tblPaymentsResults2 = new JTable(paymentsModel);
		tblPaymentsResults2.setModel(paymentsModel);
		JScrollPane paymentsResults = new JScrollPane(tblPaymentsResults2);
		paymentsResults.setBounds(45, 45, 605, 100);
		cont.add(paymentsResults);
		
		return cont;
	}
}