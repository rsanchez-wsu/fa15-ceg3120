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

package edu.wright.cs.fa15.ceg3120.concon.common;

import edu.wright.cs.fa15.ceg3120.concon.common.data.ContractorAccount;
import edu.wright.cs.fa15.ceg3120.concon.common.data.UserAccount;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * temp.
 * @author Quack
 *
 */
class NewContractorPane extends JPanel {
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new instance of <code>NewContratorPane</code>.
	 */
	public NewContractorPane() {
		super(new BorderLayout());
		JLabel temp = new JLabel("Contractor dudes need to implement this");
		add(temp, BorderLayout.CENTER);
	}
	
	/**
	 * Reads and verifies all user input creating a new HomeownerAccount with
	 * user inputted data.
	 * 
	 * @return new ContractorAccount
	 */
	public UserAccount packageAccount() {
		return new ContractorAccount();
	}
}
