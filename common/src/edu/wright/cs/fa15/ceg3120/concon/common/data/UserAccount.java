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

import java.io.Serializable;

/**
 * This class is intended to be the super class for all account types.
 * 
 * @author Quack
 *
 */
public class UserAccount implements Serializable{
	private static final long serialVersionUID = 1L;
	/** Description. */
	private String uuid;
	/** Description. */
	private AccountType accountType;
	/** Description. */
	private char[] pswd;
	/** Response from database. */
	private String dbResponse;
	// other common data fields
	private String strFirstName;
	private String strLastName;
	private String strAddress1;
	private String strAddress2;
	private String strCity;
	private String strState;
	private String zipCode;
	private String strPhoneNumber;
	private String strEmailAddress;

	/**
	 * Creates a new instance of <code>UserAccount</code>.
	 * 
	 * @param accountType (AccountType)
	 */
	public UserAccount(AccountType accountType) {
		uuid = "Debug";
		this.accountType = accountType;
	}

	/**
	 * Creates a new instance of <code>UserAccount</code>.
	 * 
	 * @param uuid (String)
	 * @param type (AccountType)
	 * @param pswd (char[])
	 */
	public UserAccount(String uuid, AccountType type, char[] pswd) {
		this.uuid = uuid;
		accountType = type;
		this.pswd = pswd.clone(); // XXX this WILL need changed
	}

	/**
	 * Javadoc needed.
	 *
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * Javadoc needed.
	 *
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * Javadoc needed.
	 *
	 */
	public AccountType getAccountType() {
		return accountType;
	}

	/**
	 * Javadoc needed.
	 *
	 */
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	/**
	 * Javadoc needed.
	 *
	 */
	public char[] getPswd() {
		return pswd.clone();
	}

	/**
	 * Javadoc needed.
	 *
	 */
	public void setPswd(char[] pswd) {
		this.pswd = pswd.clone();
	}

	/**
	 * Javadoc needed.
	 *
	 */
	public String getdbResponse() {
		return dbResponse;
	}

	/**
	 * Javadoc needed.
	 *
	 */
	public void setdbResponse(String dbResponse) {
		this.dbResponse = dbResponse;
	}
	
	/**
	 * Javadoc needed.
	 *
	 */
	public void setFirstName(String strFn) {
		strFirstName = strFn;
	}
	
	/**
	 * Javadoc needed.
	 *
	 */
	public void setLastName(String strLn) {
		strLastName = strLn;
	}
	
	/**
	 * Javadoc needed.
	 *
	 */
	public void setAddress1(String strAdd1) {
		strAddress1 = strAdd1;
	}
	
	/**
	 * Javadoc needed.
	 *
	 */
	public void setAddress2(String strAdd2) {
		strAddress2 = strAdd2;
	}
	
	/**
	 * Javadoc needed.
	 *
	 */
	public void setCity(String strCt) {
		strCity = strCt;
	}
	
	/**
	 * Javadoc needed.
	 *
	 */
	public void setState(String strSt) {
		strState = strSt;
	}
	
	/**
	 * Javadoc needed.
	 *
	 */
	public void setZipCode(String zip) {
		zipCode = zip;
	}
	
	/**
	 * Javadoc needed.
	 *
	 */
	public void setPhoneNumber(String strPhone) {
		strPhoneNumber = strPhone;
	}
	
	/**
	 * Javadoc needed.
	 *
	 */
	public void setEmailAddress(String strEmail) {
		strEmailAddress = strEmail;
	}
	
	/**
	 * Javadoc needed.
	 *
	 */
	public String getFirstName() {
		return strFirstName;
	}
	
	/**
	 * Javadoc needed.
	 *
	 */
	public String getLastName() {
		return strLastName;
	}
	
	/**
	 * Javadoc needed.
	 *
	 */
	public String getAddress1() {
		return strAddress1;
	}
	
	/**
	 * Javadoc needed.
	 *
	 */
	public String getAddress2() {
		return strAddress2;
	}
	
	/**
	 * Javadoc needed.
	 *
	 */
	public String getCity() {
		return strCity;
	}
	
	/**
	 * Javadoc needed.
	 *
	 */
	public String getState() {
		return strState;
	}
	
	/**
	 * Javadoc needed.
	 *
	 */
	public String getZipCode() {
		return zipCode;
	}
	
	/**
	 * Javadoc needed.
	 *
	 */
	public String getPhoneNumber() {
		return strPhoneNumber;
	}
	
	/**
	 * Javadoc needed.
	 *
	 */
	public String getEmailAddress() {
		return strEmailAddress;
	}


	/**
	 * Launches the account type specific GUI.
	 * <p>Must be given functionality by UserAccount sub-classes.</p>
	 */
	public void launchGui() {}
}
