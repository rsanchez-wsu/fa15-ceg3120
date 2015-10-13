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
 * Javadoc needed.
 *
 */
public class CustomerClient {
	
    private static final Logger LOG = LoggerFactory.getLogger(CustomerClient.class);
    private static final int WINDOW_WIDTH = 
    		Toolkit.getDefaultToolkit().getScreenSize().width - 150;
    private static final int WINDOW_HEIGHT = 
    		Toolkit.getDefaultToolkit().getScreenSize().height - 150;

    @SuppressWarnings("unused")
    private HomeownerAccount user;
    
    /**
     * Javadoc needed.
     */
    public CustomerClient() {
        user = null;
    }
    
//    public HomeownerAccount getUser() {
//        return user;
//    }
    
    /**
     * Temp.
     */
    public void buildGui(HomeownerAccount user) {
        this.user = user;
        JFrame custFrame = new JFrame("TEMP TITLE");
        custFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        // build UI here

        custFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        custFrame.addWindowListener(new MyWindowAdapter());

        custFrame.setVisible(true);
    }// end buildGui

    /**
     * we probably don't need a main if this is launched from LogininPopUp...
     * 
     * @param args
     *            temp
     */
    public static void main(String[] args) {
		LOG.trace("Starting Customer client...");
        NetworkManager.startClient("localhost", 9667);
        NetworkMessage message = new ChatMessage("Hello World", null, null);
        NetworkManager.sendMessage(message);
        new CustomerClient().buildGui(new HomeownerAccount());
    }
    
    /**
     * Javadoc needed.
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