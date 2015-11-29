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
 * Calendar Tab.
 *
 */
public class CalendarTab extends JLayeredPane {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Buil the tab.
	 */
	public CalendarTab() {
		JPanel calendar = new JPanel();
		add(calendar);
		calendar.setLayout(null);
	}
}
