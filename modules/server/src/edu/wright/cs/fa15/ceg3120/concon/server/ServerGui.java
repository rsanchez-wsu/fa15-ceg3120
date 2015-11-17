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

//package components;

package edu.wright.cs.fa15.ceg3120.concon.server;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * ServerGui is the main JPanel class that contains a tabbedPane of
 * other classes need for administration of the Con^2 project server.
 * 
 * */
public class ServerGui extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	public JTextField textField;
	public JTextArea textArea;
	public JRadioButton homeOwner;
	public JRadioButton contractor;
	public static final String newline = "\n";
	
	private JTabbedPane tabbedPane;

/**
 * main GUI class call sub classes to form components.
 * @param GUIcomponents
 * 
 */
	public ServerGui() { 
		
		super(new GridLayout(1, 1));
		
		// Create tabbedPane and add all need tabs to it
		tabbedPane = new JTabbedPane();
		
		tabbedPane.addTab("Dash board", CreateImageIcon.iconDashBoard, 
						MakeDashBoard.panelDashBoard, "Main Dashboard");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		JComponent panel2 = new CreateButtonsSearch(this);
		tabbedPane.addTab("User's info", CreateImageIcon.icon, panel2,
						"User Infor and Messaging");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		JComponent panel3 = MessagingTab.createMessagingTab();
		tabbedPane.addTab("Messages", CreateImageIcon.icon, panel3, "Message Users");
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

		JComponent panel4 = DatabaseControlTab.createDbControlTab();
		panel4.setPreferredSize(new Dimension(410, 50));
		tabbedPane.addTab("Remote Control", CreateImageIcon.icon, 
						panel4, "Schedule Tasks");
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_5);

		JComponent panel5 = TransactionTab.createTransactionTable();
		tabbedPane.addTab("Transactions", CreateImageIcon.icon, 
						panel5, "User Transactions");
		tabbedPane.setMnemonicAt(4, KeyEvent.VK_4);

		// Add the tab pane to this panel.
		add(tabbedPane);

		// The following line enables to use scrolling tabs.
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
	}
	
	/**
	 * Changes the currently selected tab to newTabIndex.
	 * @param newTabIndex the index of the tab to switch to.
	 */
	public void switchTabs(int newTabIndex) {
		tabbedPane.setSelectedIndex(newTabIndex);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		String text = textField.getText();
		textArea.append(text + newline);
		textField.selectAll();

		// Make sure the new text is visible, even if there
		// was a selection in the text area.
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}
	
	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event dispatch thread.
	 */
	private static void createAndshowgui() {
		// Create and set up the window.
		JFrame frame = new JFrame("Server Control GUI");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(CreateImageIcon.iconLogo.getImage());
		// Add content to the window.
		frame.add(new ServerGui(), BorderLayout.CENTER);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}	
	
	/**
     * Main class.
     * @param GUICreateandShow
     * 
     */
	public static void main(String[] args) {
		
		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// Turn off metal's use of bold fonts
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				createAndshowgui();
			}
		});
	}
}