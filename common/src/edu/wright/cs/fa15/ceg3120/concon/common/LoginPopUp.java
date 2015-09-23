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

public class LoginPopUp{

	private UserAccount user;
	
	private void buildGui() {
		JFrame loginFrame = new JFrame("TEMP TITLE");
		// TODO Auto-generated method stub
		//Build login UI here
		
		loginFrame.setVisible(true);
		
		
		launchNewAccountGui();
		//wait for user to be set
		
		if(user != null){
			loginFrame.dispose();
			user.launchGui();
		}
	}
	
	/**
	 * Launches the Create New User GUI and renders the login window
	 * unresponsive until CreateNewAccountGUI.buildGUI returns
	 */
	private void launchNewAccountGui() {
		user = (new CreateNewAccount()).buildGui();
	}//end launchNewAccountGUI
	
	/**
	 * Temp comment.
	 * @param args - Command line arguments
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				(new LoginPopUp()).buildGui();
			}
		});

	}

	

}
