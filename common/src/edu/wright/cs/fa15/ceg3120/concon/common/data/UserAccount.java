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
	/** Username. */
	private String uuid;
	/** The account type of the object (HOMEOWNER, CONTRACTOR, or SERVER_ADMIN). */
	private AccountType accountType;
	/** Encrypted user password. */
	private char[] pswd;
	/** Response from database. */
	private String dbResponse;
	/** TODO description.*/
	private String strFirstName;
	/** TODO description.*/
	private String strLastName;
	/** TODO description.*/
	private String strAddress1;
	/** TODO description.*/
	private String strAddress2;
	/** TODO description.*/
	private String strCity;
	/** TODO description.*/
	private String strState;
	/** TODO description.*/
	private String zipCode;
	/** TODO description.*/
	private String strPhoneNumber;
	/** TODO description.*/
	private String strEmailAddress;
	
	/**
	 * Creates a new instance of <code>UserAccount</code>.
	 */
	public UserAccount() {
		uuid = "DEBUG";
	}

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
	 * Gets the uuid for the user.
	 *
	 * @return username
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * Set the uuid for the user.
	 *
	 * @param uuid username
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * Gets the type of account.
	 * @return {@link edu.wright.cs.fa15.ceg3120.concon.common.data.AccountType}
	 */
	public AccountType getAccountType() {
		return accountType;
	}

	/**
	 * Set the account type for the user.
	 *
	 * @param accountType the type of account
	 *
	 * @see edu.wright.cs.fa15.ceg3120.concon.common.data.AccountType
	 */
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	/**
	 * Gets the encrypted password.
	 *
	 * @return encrypted password
	 */
	public char[] getPswd() {
		return pswd == null ? null : pswd.clone();
	}

	/**
	 * If used this should salt and hash the password before storing.
	 *
	 * @param pswd char[] representation of the password
	 */
	public void setPswd(char[] pswd) {
		this.pswd = pswd.clone();
	}

	/**
	 * Gets the response from the database.  If no network call has been made,
	 * this will return an empty String.
	 *
	 * @return response from the database
	 */
	public String getdbResponse() {
		return dbResponse;
	}

	/**
	 * Sets the response from the database for use in error reporting.
	 *
	 * @param dbResponse response from the database
	 */
	public void setdbResponse(String dbResponse) {
		this.dbResponse = dbResponse;
	}

	/**
	 * Sets the first name of the user.
	 *
	 * @param strFn first name of the user
	 */
	public void setFirstName(String strFn) {
		strFirstName = strFn;
	}

	/**
	 * Set the last name of the user.
	 *
	 * @param strLn last name of the user
	 */
	public void setLastName(String strLn) {
		strLastName = strLn;
	}

	/**
	 * Sets the first line of the street address.
	 *
	 * @param strAdd1 mailing address line 1
	 */
	public void setAddress1(String strAdd1) {
		strAddress1 = strAdd1;
	}

	/**
	 * Sets the second line of the street address.
	 *
	 * @param strAdd2 mailing address line 2
	 */
	public void setAddress2(String strAdd2) {
		strAddress2 = strAdd2;
	}

	/**
	 * Sets the users city.
	 *
	 * @param strCt user's city
	 */
	public void setCity(String strCt) {
		strCity = strCt;
	}

	/**
	 * Sets the user's state. Must be a valid two character abbreviation.
	 *
	 * @param strSt two character string abbreviation for state
	 */
	public void setState(String strSt) {
		strState = strSt;
	}

	/**
	 * Sets the user's zip code.
	 *
	 * @param zip String representation of the zip code
	 */
	public void setZipCode(String zip) {
		zipCode = zip;
	}

	/**
	 * Sets the user's phone number.
	 *
	 * @param strPhone String representation of the phone number
	 */
	public void setPhoneNumber(String strPhone) {
		strPhoneNumber = strPhone;
	}

	/**
	 * Sets the user's email.
	 *
	 * @param strEmail must currently match this RegEx pattern:
	 *	    ^[A-Za-z0-9_]+?@.+?\..+$
	 */
	public void setEmailAddress(String strEmail) {
		strEmailAddress = strEmail;
	}

	/**
	 * Gets the user's first name.
	 *
	 * @return first name
	 */
	public String getFirstName() {
		return strFirstName;
	}

	/**
	 * Gets the user's last name.
	 *
	 * @return last name
	 */
	public String getLastName() {
		return strLastName;
	}

	/**
	 * Gets the first line of the user's mailing address.
	 *
	 * @return mailing address line 1
	 */
	public String getAddress1() {
		return strAddress1;
	}

	/**
	 * Gets the second line of the user's mailing address.
	 *
	 * @return mailing address line 2
	 */
	public String getAddress2() {
		return strAddress2;
	}

	/**
	 * Gets the user's city.
	 *
	 * @return city
	 */
	public String getCity() {
		return strCity;
	}

	/**
	 * Gets the user's state.
	 *
	 * @return two character abbreviation of the user's state
	 */
	public String getState() {
		return strState;
	}

	/**
	 * Gets the user's zip-code.
	 *
	 * @return String representation of zip-code
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * Gets the user's phone number.
	 *
	 * @return String representation of phone number
	 */
	public String getPhoneNumber() {
		return strPhoneNumber;
	}

	/**
	 * Gets the user's email.
	 *
	 * @return email address
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
