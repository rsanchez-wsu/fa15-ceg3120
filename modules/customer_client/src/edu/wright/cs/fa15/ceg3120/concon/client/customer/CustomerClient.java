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

import edu.wright.cs.fa15.ceg3120.concon.common.net.NetworkManager;
import edu.wright.cs.fa15.ceg3120.concon.common.net.message.BeanMessage;

public class CustomerClient {
    // LOG is currently unused. Remove this suppress when it gets used.
    @SuppressWarnings("unused")
    private static final Logger LOG = LoggerFactory.getLogger(CustomerClient.class);

    private static final int WINDOW_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width - 150;
    private static final int WINDOW_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height
            - 150;

    /**
     * Temp.
     */
    public void buildGui() {
        JFrame custFrame = new JFrame("TEMP TITLE");
        custFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        // build UI here

        custFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        custFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent ev) {
                int result = JOptionPane.showConfirmDialog(null, "Do you really wish to exit?",
                        "Exit?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == 0) {
                    // release any network/file resources
                    System.exit(0);
                }
            }
        });

        custFrame.setVisible(true);
    }// end buildGui

	public static void main(String[] args) {
		NetworkManager.startClient("localhost", 9667);
		BeanMessage message = new BeanMessage("Hello World");
		NetworkManager.sendMessage(message);
	}
}