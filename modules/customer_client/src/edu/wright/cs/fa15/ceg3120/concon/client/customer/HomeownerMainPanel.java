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

import java.awt.Color;

import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;

/**
 * temp.
 *
 */
public class HomeownerMainPanel extends JTabbedPane {
	private static final long serialVersionUID = 1L;
	private JLayeredPane tab3;

	/**
	 * Creates a new instance of <code>HomeownerMainPanel</code>.
	 */
	public HomeownerMainPanel() {
		setBackground(Color.ORANGE);

		JLayeredPane tab1 = new JLayeredPane();
		addTab("tab1", null, tab1, null);
		setEnabledAt(0, true);
		setBackgroundAt(0, Color.WHITE);

		JLayeredPane tab2 = new JLayeredPane();
		addTab("tab2", null, tab2, null);

		tab3 = new JLayeredPane();
		addTab("tab3", null, tab3, null);

		JLayeredPane tab4 = new JLayeredPane();
		addTab("tab4", null, tab4, null);

		JLayeredPane tab5 = new JLayeredPane();
		addTab("tab5", null, tab5, null);

		setupPanel();
	}

	/**
	 * temp.
	 */
	private void setupPanel() {

	}
}
