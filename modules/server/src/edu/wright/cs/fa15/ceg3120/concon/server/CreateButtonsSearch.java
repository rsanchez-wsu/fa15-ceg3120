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
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

public class CreateButtonsSearch extends JPanel{


	private static final long serialVersionUID = 1L;
	protected JRadioButton contractor;
	protected JRadioButton homeOwner;
	protected JTextField searchBar;
	
	/**
	 * Creates a panel for the User's Tab.
	 */
	public CreateButtonsSearch() {
		super();
		this.setLayout(new BorderLayout());
		
		JPanel functionality = new JPanel();
		functionality.setLayout(new GridLayout(2,4));
		
		searchBar = new JTextField(25);
		functionality.add(searchBar);
		JButton search = new JButton();
		search.setText("Search");
		search.addActionListener(new SearchListener());
		functionality.add(search);
		
		homeOwner = new JRadioButton();
		homeOwner.setText("Homeowner");
		homeOwner.setSelected(true);
		ButtonGroup userTypes = new ButtonGroup();
		userTypes.add(homeOwner);
		functionality.add(homeOwner);
		contractor = new JRadioButton();
		contractor.setText("Contractor");
		userTypes.add(contractor);
		functionality.add(contractor);
		
		JButton message = new JButton();
		message.setText("Send Message");
		message.addActionListener(new MessageListener());
		functionality.add(message);

		JButton disable = new JButton();
		disable.setText("Disable Account");
		disable.addActionListener(new DisableListener());
		functionality.add(disable);

		JButton reset = new JButton();
		reset.setText("Reset Password");
		reset.addActionListener(new ResetListener());
		functionality.add(reset);
		
		this.add(functionality, BorderLayout.NORTH);
		
		JTable users = new JTable(new UserTableModel());
		users.setFillsViewportHeight(true);		
		
		this.add(new JScrollPane(users), BorderLayout.CENTER);
	}//end constructor
	
	class UserTableModel extends AbstractTableModel { //Copied from Transactions tab
		private static final long serialVersionUID = 1L;

		private String[] columnNames = { "Name", "Phone Number","Address", "E-Mail" };

		private Object[][] dummyData = {
		  { "Kathy", "(555)555-5555", "123 Main St.", "Kathy@gmail.com" },
		  { "Geroge", "(555)555-5555", "456 S. West Dr.", "George@yahoo.com" },
		  { "Megan", "(555)555-5555", "789 Oak Rd.", "Megan@hotmail.com" },
		  { "Mitch", "(555)555-5555","1011 Maple Ave.", "Mitch@aol.com"},
		  { "Barbara", "(555)555-5555", "1213  Pennyworth Blvd","mrs.gordon@gcpd.gov"}
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
		 * Possible implementation of resolving issues
		 */
		@Override
		public boolean isCellEditable(int row, int col) {
			return true; // Could return true on different columns.
		}
		
		@Override
		public void setValueAt(Object value, int row, int col) {
			// TODO validation
			dummyData[row][col] = value;
			fireTableCellUpdated(row, col);
		}

	}//end UserTableModel
	
	
	private class SearchListener implements ActionListener{
    		@Override
        public void actionPerformed(ActionEvent event) {
    			try {
    				if (searchBar.getText().isEmpty()) {
    					System.out.println("You must enter a name to search");
    				} else {
    					System.out.println("The search is not empty");
    					//TODO add search functionality, probably return a 2D array
    				}
    			} catch (Exception ex) {
    				System.out.println("Error occured searching "
    								+ "for users with that name");
    			} //end catch
    		}//end actionPerformed
    	}//end SearchListener
	
	private class ResetListener implements ActionListener{
		@Override
    public void actionPerformed(ActionEvent event) {
			try {
				//TODO add search functionality, probably return a 2D array
			} catch (Exception ex) {
				System.out.println("Error occured resetting");
			} //end catch
		}//end actionPerformed
	}//end ResetListener
	
	private class DisableListener implements ActionListener{
		@Override
    public void actionPerformed(ActionEvent event) {
			try {
				//TODO add search functionality, probably return a 2D array
			} catch (Exception ex) {
				System.out.println("Error occured disabling");
			} //end catch
		}//end actionPerformed
	}//end DisableListener
	
	private class MessageListener implements ActionListener{
		@Override
    public void actionPerformed(ActionEvent event) {
			try {
				//TODO add search functionality, probably return a 2D array
			} catch (Exception ex) {
				System.out.println("Error occured sending message");
			} //end catch
		}//end actionPerformed
	}//end MessageListener
	
	
	
	
}//end CreateButtonsSearch