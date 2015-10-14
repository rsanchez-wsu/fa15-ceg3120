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

import edu.wright.cs.fa15.ceg3120.concon.common.data.HomeownerAccount;
//import edu.wright.cs.fa15.ceg3120.concon.common.data.HomeownerAccount;
import edu.wright.cs.fa15.ceg3120.concon.common.net.NetworkManager;
import edu.wright.cs.fa15.ceg3120.concon.common.net.message.ChatMessage;
import edu.wright.cs.fa15.ceg3120.concon.common.net.message.NetworkMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 * This class contains the launch point for the Homeowner UI.
 * 
 * @author Quack
 *
 */
public class CustomerClient {
	// LOG is currently unused. Remove this suppress when it gets used.
	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(CustomerClient.class);

	private static final int WINDOW_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width - 150;
	private static final int WINDOW_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height
			- 150;

	private HomeownerAccount user;
	
	/**
	 * Creates a new instance of <code>CustomerClient</code>.
	 */
	public CustomerClient() {
		user = null;
	}
	
//	public HomeownerAccount getUser() {
//		return user;
//	}
	
	/**
	 * Creates the Homeowner UI.
	 */
	public void buildGui(HomeownerAccount user) {
		this.user = user;
		JFrame custFrame = new JFrame("TEMP TITLE");
		custFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		HomeownerMainPanel currentPanel = new HomeownerMainPanel(this.user);
		
		custFrame.setContentPane(currentPanel);
		// build UI here

		custFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		custFrame.addWindowListener(new MyWindowAdapter());

		custFrame.setVisible(true);
	}// end buildGui

	/**
	 * we probably don't need a main if this is launched from LogininPopUp...
	 * 
	 * @param args
	 *			temp
	 */
	public static void main(String[] args) {
		NetworkManager.startClient("localhost", 9667);
		NetworkMessage message = new ChatMessage("Hello World", null, null);
		NetworkManager.sendMessage(message);
		HomeownerAccount user = new HomeownerAccount();
		user.setUuid("Debug");
		char[] ps = {'a','b', 'c'};
		user.setPswd(ps);
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setAddress1("123 Nowhere St");
		user.setCity("Lost");
		user.setEmailAddress("test123@temp.com");
		new CustomerClient().buildGui(user);
	}
	
	/**
	 * This class extends WindowAdapter to give the frame a new default closing
	 * operation.  Asks the user for confirmation before closing.
	 * 
	 * @author Quack
	 *
	 */
	static class MyWindowAdapter extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent ev) {
			int result = JOptionPane.showConfirmDialog(null, "Do you really wish to exit?",
					"Exit?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (result == 0) {
				// release any network/file resources
				System.exit(0);
			}
		}
	}
}