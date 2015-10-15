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

import java.awt.Color;

import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;

/**
 * temp.
 *
 */
public class HomeownerMainPanel extends JTabbedPane {
	private static final long serialVersionUID = 1L;
	private JLayeredPane createNewJobTab;

	/**
	 * Creates a new instance of <code>HomeownerMainPanel</code>.
	 */
	public HomeownerMainPanel(HomeownerAccount user) {
		setBackground(Color.ORANGE);

		ProfileTab profileTab = new ProfileTab(user);
		profileTab.buildPane();
		addTab("Profile", null, profileTab, "View and change your profile here");
		setEnabledAt(0, true);
		setBackgroundAt(0, Color.WHITE);

		JLayeredPane openJobsTab = new JLayeredPane();
		addTab("Open Jobs", null, openJobsTab, null);

		createNewJobTab = new JLayeredPane();
		addTab("Create New Job", null, createNewJobTab, null);

		JLayeredPane showContractorTab = new JLayeredPane();
		addTab("Show Contractors", null, showContractorTab, null);

		JLayeredPane messagingTab = new JLayeredPane();
		addTab("Messaging", null, messagingTab, null);

		setupPanel();
	}

	/**
	 * temp.
	 */
	private void setupPanel() {

	}
}
