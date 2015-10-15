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

public class CreateButtonsSearch extends JPanel{


	private static final long serialVersionUID = 1L;
	protected JRadioButton contractor;
	protected JRadioButton homeOwner;
	
	/**
	 * Creates a panel for the User's Tab.
	 */
	public CreateButtonsSearch() {
		super();
		this.setLayout(new FlowLayout());
		
		JPanel searching = new JPanel();
		searching.setLayout(new GridLayout(1,4));
		
		JTextField searchBar = new JTextField(25);
		searching.add(searchBar);
		JButton search = new JButton();
		search.setText("Search");
		search.addActionListener(new UserListener());
		//search.addActionListener(new ButtonListener());
		searching.add(search);

		homeOwner = new JRadioButton();
		homeOwner.setText("Homeowner");
		homeOwner.setSelected(true);
		ButtonGroup userTypes = new ButtonGroup();
		userTypes.add(homeOwner);
		searching.add(homeOwner);
		contractor = new JRadioButton();
		contractor.setText("Contractor");
		userTypes.add(contractor);
		searching.add(contractor);
		
		this.add(searching);
		
		JPanel results = new JPanel();
		results.setLayout(new GridLayout(1,1));
		JTable searchResults = new JTable();
		JScrollPane sr = new JScrollPane();
		sr.add(searchResults);
		results.add(sr);
		
		this.add(results);
	}
	
	@SuppressWarnings("unused")
	private class ButtonListener implements ActionListener{
    		@Override
        public void actionPerformed(ActionEvent event) {
    			try {
            	//else if( there is nothing typed in the text field){
    				//TODO add search functionality
            	//	System.out.println("You must enter a name to search");
            	//}
            	//else {
            		//search database for that name
            	//}
    			} catch (Exception ex) {
    				System.out.println("Error occured searching "
    								+ "for users with that name");
    			}
    		}
    	}
    
    	private class UserListener implements ActionListener{
    		@Override
        public void actionPerformed(ActionEvent event) {
    			try { //TODO format this window better
    				System.out.println("Button Pushed");
    				JFrame userInfo = new JFrame("Detail User Info");
    				userInfo.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            	
    				JPanel info = new JPanel();
    				info.setLayout(new GridLayout(3,1));
    				
            			JPanel editableInfo = new JPanel();
            			editableInfo.setLayout(new GridLayout(1,4));
            	
	            		JTextField name = new JTextField(25);
	            		name.setText("Barbara Kean");
	            		editableInfo.add(name);
            	
	            		JTextField address = new JTextField(25);
	            		address.setText("123 Main St. Gotham City");
            			editableInfo.add(address);
            	
            			JTextField phone = new JTextField(13);
            			phone.setText("(555)555-5555");
            			editableInfo.add(phone);
            		
            			JTextField email = new JTextField(20);
            			email.setText("mrs.gordon@gcpd.gov");
            			editableInfo.add(email);
            	
            			info.add(editableInfo);
            	
            			JPanel functions = new JPanel();
            			functions.setLayout(new GridLayout(1,3));
            	
            			JButton message = new JButton();
            			message.setText("Send Message");
            			functions.add(message);
            	
            			JButton disable = new JButton();
            			disable.setText("Disable Account");
            			functions.add(disable);
            	
            			JButton reset = new JButton();
            			reset.setText("Reset Password");
            			functions.add(reset);
            	
            			info.add(functions);

            	
            			userInfo.add(info);
            			userInfo.pack();
            			userInfo.setVisible(true);
    			} catch (Exception ex) {
    				//F
    				//U
    				//Checkstyle
    				System.out.println("Error occured "
    								+ "searching for users with "
    								+ "that name");
    			} //end catch
    		}//end ActionPerformed
    	}//end UserListener
	
}//end CreateButtonsSearch