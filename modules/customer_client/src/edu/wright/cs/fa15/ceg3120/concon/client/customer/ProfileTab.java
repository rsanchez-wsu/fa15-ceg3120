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

import edu.wright.cs.fa15.ceg3120.concon.common.NewHomeownerPane;
import edu.wright.cs.fa15.ceg3120.concon.common.data.HomeownerAccount;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLayeredPane;

/**
 * This JPanel will be used to construct the Profile tab in the Customer Client.
 * 
 * @author Quack
 *
 */
public class ProfileTab extends JLayeredPane {
	private static final long serialVersionUID = 1L;
	private HomeownerAccount user;
	
	/**
	 * Creates a new instance of <code>ProfileTab</code>.
	 */
	public ProfileTab(HomeownerAccount user) {
		super();
		setLayout(new BorderLayout());
		this.user = user;
	}
	
	/**
	 * Builds the JLayeredPane.
	 */
	public void buildPane() {
		NewHomeownerPane profile = new NewHomeownerPane(user);
		profile.setMaximumSize(new Dimension(300, 350));
		add(profile, BorderLayout.CENTER);
		//revalidate(); not resizing. may have to change the default size thingy
		
		Container subCont = new Container();
		subCont.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JButton submit = new JButton("Submit");
		subCont.add(submit);
		
		add(subCont, BorderLayout.SOUTH);
	}

}
