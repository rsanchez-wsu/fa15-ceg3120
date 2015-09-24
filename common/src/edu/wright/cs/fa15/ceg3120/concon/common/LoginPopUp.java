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

package edu.wright.cs.fa15.ceg3120.concon.common;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import edu.wright.cs.fa15.ceg3120.concon.common.data.UserAccount;

public class LoginPopUp{

	private UserAccount user;
	
	/**
	 * Creates a new instance of <code>LogininPopUp</code>.
	 */
	public LoginPopUp() {
		user = null;
	}
	
	/**
	 * Temp comment.
	 */
	private void buildGui() {
		JFrame loginFrame = new JFrame("TEMP TITLE");
		// TODO Auto-generated method stub
		//Build login UI here
		
		/*
		  need action listener for submit button that will block until
		  we receive a response from Networking so user can be set properly.
		  Preferably a blocking mechanism that will timeout when we want it
		  to.
		*/
		loginFrame.setVisible(true);
		
		//if new account link/button clicked
		launchNewAccountGui();
		//wait for user to be set
		
		if (user != null) {
			/* Schedule the loginFrame to be disposed on the EDT before
			  launching the new GUI. */
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					loginFrame.dispose();
				}
			}); 
			user.launchGui();
		}
	}//end buildGui
	
	/**
	 * Launches the Create New User GUI and renders the login window
	 * unresponsive until CreateNewAccountGUI.buildGUI returns.
	 */
	private void launchNewAccountGui() {
		user = (new CreateNewAccount()).buildGui();
	}//end launchNewAccountGUI
	
	/**
	 * Entry point for the main unit.
	 * 
	 * @param args - Command line arguments
	 */
	public static void main(String[] args) {
		// Schedules the GUI construction on the EDT
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				(new LoginPopUp()).buildGui();
			}
		});

	}

	

}
