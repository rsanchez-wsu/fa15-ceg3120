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

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * Open Jobs Tab.
 *
 */
public class OpenJobsTab extends JLayeredPane {

	/**
	 * Javadoc needed.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Build the tab.
	 */
	public OpenJobsTab() {
		JPanel openJobs = new JPanel();
		add(openJobs);
		openJobs.setLayout(null);
	}

}
