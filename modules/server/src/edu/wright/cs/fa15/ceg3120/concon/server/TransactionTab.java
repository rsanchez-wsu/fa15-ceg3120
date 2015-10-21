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

/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package edu.wright.cs.fa15.ceg3120.concon.server;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;


/**
 * This class is responsible for creating the Transaction Tab of the Server Admin GUI.
 * @author Quintin
 *
 */
public class TransactionTab extends JComponent{
	
	/**
	 * Serial version UID needed because JComponent implements serializable.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Creates the panel to placed in the Transactions tab of the Server Control
	 * GUI
	 * 
	 * @return the panel to be used.
	 */
	public static JComponent createTransactionTable() {
		/* Model used for the list of users. This has to be a ListModel so that the information can
		 * be pulled from the database.
		 */
		DefaultListModel<String> usersModel = new DefaultListModel<>();
		
		// Create dummy data for JList
		usersModel.addElement("Bob");
		usersModel.addElement("Susan");
		usersModel.addElement("ConstructionsRUs");
		usersModel.addElement("Bob's Building Builders");
		usersModel.addElement("Bob");
		usersModel.addElement("Susan");
		usersModel.addElement("ConstructionsRUs");
		usersModel.addElement("Bob's Building Builders");
		usersModel.addElement("Bob");
		usersModel.addElement("Susan");
		usersModel.addElement("ConstructionsRUs");
		usersModel.addElement("Bob's Building Builders");
		usersModel.addElement("Bob");
		usersModel.addElement("Susan");
		usersModel.addElement("ConstructionsRUs");
		usersModel.addElement("Bob's Building Builders");

		JList<String> usersList = new JList<>();
		usersList.setModel(usersModel);

		JPanel usersPanel = new JPanel(new BorderLayout());
		// Users label
		JLabel usersLabel = new JLabel("Users:");
		usersPanel.add(usersLabel, BorderLayout.NORTH);
		
		JScrollPane usersScrollPane = new JScrollPane(usersList);
		usersPanel.add(usersScrollPane, BorderLayout.CENTER);
		
		JButton refreshButton = new JButton("Refresh");
		//TODO add click listener
		usersPanel.add(refreshButton, BorderLayout.EAST);
		
		// Transactions Table
		JTable transactionTable = new JTable(new TransactionTableModel());
		transactionTable.setFillsViewportHeight(true);
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(new JScrollPane(transactionTable), BorderLayout.CENTER);
		panel.add(usersPanel, BorderLayout.NORTH);
		return panel;
	}
	
	/**
	 * Default class model for Transaction Table.
	 */
	static class TransactionTableModel extends AbstractTableModel {
		/**
		 * Default class model for Transaction Table.
		 */
		private static final long serialVersionUID = 1L;

		private String[] columnNames = {"Home Owner", "Contactor","Transaction #", "Date", "Price"};

		private Object[][] dummyData = {
										{ "Kathy", "Bob's Building", Integer.valueOf(1001),
			"Aug 31, 2015", "$120.15" },
										{ "Geroge", "Home Depot", Integer.valueOf(1002),
			"Aug 29, 2015", "$1000.00" },
										{ "Megan", "Constructors", Integer.valueOf(1003), 
			"Aug 30, 2015", "$120.15" },
										{ "Mitch", "Joe's", Integer.valueOf(1004), 
			"Aug 31, 2015", "$120.15"}
		};

		@Override
		public int getColumnCount() {
			return columnNames.length;
		}
		
		@Override
		public String getColumnName(int col) {
			return columnNames[col];
		}

		@Override
		public int getRowCount() {
			return dummyData.length;
		}

		@Override
		public Object getValueAt(int row, int col) {
			return dummyData[row][col];
		}
		
		@Override
		public Class<?> getColumnClass(int column) {
			return getValueAt(0, column).getClass();
		}
		
		/*
		 * Possible implementation of resolving transaction issues
		 */
		@Override
		public boolean isCellEditable(int row, int col) {
			return false; // Could return true on different columns.
		}
		
		@Override
		public void setValueAt(Object value, int row, int col) {
			// TODO validation
			dummyData[row][col] = value;
			fireTableCellUpdated(row, col);
		}

	}
}
