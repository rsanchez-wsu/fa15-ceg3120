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

package edu.wright.cs.fa15.ceg3120.concon.client.contractor;

import edu.wright.cs.fa15.ceg3120.concon.common.data.ContractorAccount;

import javax.swing.JTabbedPane;

/**
 * This class creates the <code>JTabbedPane</code> and adds the tabs.
 *
 */
public class ContractorMainPanel extends JTabbedPane {
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new instance of <code>ContractorMainPanel</code>.
	 */
	public ContractorMainPanel(ContractorAccount user) {
		MainTab mainTab = new MainTab();
		addTab("Main", null, mainTab, "Return to main page");
		
		CurBidsTab curBidsTab = new CurBidsTab();
		addTab("Current Bids", null, curBidsTab, "Current Bids");

		NotifTab notifTab = new NotifTab();
		addTab("Notifications", null, notifTab, "Notifications");
		
		SearchTab searchTab = new SearchTab();
		addTab("Search", null, searchTab, "Search");
		
		PaymentsTab paymentsTab = new PaymentsTab();
		addTab("Payments", null, paymentsTab, "Check Payment Status");
		
		ProfileTab profileTab = null;
		profileTab = new ProfileTab(user);
		addTab("Profile", null, profileTab, "Edit Profile Settings");
		setEnabledAt(0, true);
		
		CalendarTab calendarTab = new CalendarTab();
		addTab("Calendar", null, calendarTab, "Check Schedule");

		OpenJobsTab openJobsTab = new OpenJobsTab();
		addTab("Open Jobs", null, openJobsTab, null);
	}
}