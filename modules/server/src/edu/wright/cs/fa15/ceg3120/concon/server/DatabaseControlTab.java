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
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Provides the interface to be added to a tab in ServerGui to
 * allow control of the Con^2 project database.
 * @author jkern
 */
public class DatabaseControlTab {

	/**
	 * Creates the control tab and returns it.
	 */
	public static JComponent createDbControlTab() {
		
		// SchedulePanel
		/*
		 * CLicking this button will evoke a JDatePicker and JSpinner to allow a
		 * user to set a date and time for the server to restart
		 */
		JPanel schedulePanel = new JPanel(new GridLayout(4, 1));
		JButton btnScheduleReboot = new JButton("Schedule Reboot");
//		btnScheduleReboot.addActionListener(this);
		schedulePanel.add(btnScheduleReboot);
		/*
		 * CLicking this button will evoke a JDatePicker and JSpinner to allow a
		 * user to set a date and time for the server to complete an arbitrary
		 * command
		 */
		JButton btnScheduleTask = new JButton("Schedule Task");
//		btnScheduleTask.addActionListener(this);
		schedulePanel.add(btnScheduleTask);

		JTextArea txaTask = new JTextArea();
		schedulePanel.add(txaTask);

		// LoginPanel
		JPanel loginPanel = new JPanel(new GridLayout(2, 2));
		JLabel lblUsername = new JLabel("Username");
		JTextField txtUsername = new JTextField();
		JLabel lblPassword = new JLabel("Password");
		JPasswordField txtPassword = new JPasswordField();
		loginPanel.add(lblUsername);
		loginPanel.add(txtUsername);
		loginPanel.add(lblPassword);
		loginPanel.add(txtPassword);

		// ConsolePanel
		JComponent standInConsole = makeTextPanel("Server console");
		JPanel consolePanel = new JPanel(new BorderLayout());
		consolePanel.add(loginPanel, BorderLayout.WEST);
		consolePanel.add(standInConsole, BorderLayout.CENTER);

		// MainPanel
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		mainPanel.add(schedulePanel);
		mainPanel.add(consolePanel, BorderLayout.SOUTH);
		return mainPanel;
	}

	/**
	 * Makes and returns a Textpanel Jcomponent.
	 */
	protected static JComponent makeTextPanel(String text) {
		JPanel panel = new JPanel(false);
		JLabel filler = new JLabel(text);
		filler.setHorizontalAlignment(JLabel.CENTER);
		panel.setLayout(new GridLayout(1, 1));
		panel.add(filler);
		return panel;
	}
}
