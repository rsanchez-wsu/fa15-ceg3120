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

package edu.wright.cs.fa15.ceg3120.concon.common.data;

/**
 * Javadoc needed.
 *
 */
public class ContractorAccount extends UserAccount {

	// Contractor specific data fields
	private static final long serialVersionUID = 1L;
	private String strCompanyName;

	/**
	 * Javadoc needed.
	 *
	 */
	public ContractorAccount() {
		super(AccountType.CONTRACTOR);
	}
	
	/**
	 * Javadoc needed.
	 *
	 */
	public void setCompanyName(String strCn) {
		strCompanyName = strCn;
	}

	/**
	 * Javadoc needed.
	 *
	 */
	public String getCompanyName() {
		return strCompanyName;
	}

	@Override
	public void launchGui() {

	}

}
