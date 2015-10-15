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
 * This class is intended to be the super class for all account types.
 * 
 * @author Quack
 *
 */
public class UserAccount {

    /** Description. */
    private String uuid;
    /** Description. */
    private AccountType accountType;
    /** Description. */
    private char[] pswd;
    /** Response from database. */
    private String dbResponse;
    // other common data fields
    // perhaps encrypted pswd?
	private String strFirstName;
	private String strLastName;
	private String strAddress1;
	private String strAddress2;
	private String strCity;
	private String strState;
	private int intZipCode;
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
     * Get the user's unique ID
     * @return String representation of the ID. 
     */
    public String getUuid() {
        return uuid;
    }

    /** 
     * Set the user's ID.
     * @param uuid String representation of the ID.
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * Get the user's account type.
     * @return an AccountType
     */
    public AccountType getAccountType() {
        return accountType;
    }

    /**
     * Set the user's account type.
     * @param accountType an AccountType
     */
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    /**
     * Get the user's password.
     * @return character array representation of the password.
     */
    public char[] getPswd() {
        return pswd.clone();
    }

    /**
     * Set the user's password.
     * @param pswd character array
     */
    public void setPswd(char[] pswd) {
        this.pswd = pswd.clone();
    }

    /**
     * Get user's database response. TODO What is this?
     * @return String representation of dbresponse.
     */
    public String getdbResponse() {
        return dbResponse;
    }

    /**
     * Set the user's database response. TODO What is this?
     * @param dbResponse String representation of dbresponse.
     */
    public void setdbResponse(String dbResponse) {
        this.dbResponse = dbResponse;
    }
    
    /**
     * Set user's first name.
     * @param strFn String
     */
    public void setFirstName(String strFn) {
    	strFirstName = strFn;
    }
    
    /**
     * Set user's last name.
     * @param strLn String
     */
    public void setLastName(String strLn) {
    	strLastName = strLn;
    }
    
    /**
     * 
     * @param strAdd1
     */
    public void setAddress1(String strAdd1) {
    	strAddress1 = strAdd1;
    }
    
    /**
     * 
     * @param strAdd2
     */
    public void setAddress2(String strAdd2) {
    	strAddress2 = strAdd2;
    }
    
    /**
     * 
     * @param strCt
     */
    public void setCity(String strCt) {
    	strCity = strCt;
    }
    
    /**
     * 
     * @param strSt
     */
    public void setState(String strSt) {
    	strState = strSt;
    }
    
    /**
     * 
     * @param zip
     */
    public void setZipCode(int zip) {
    	intZipCode = zip;
    }
    
    /**
     * 
     * @param strPhone
     */
    public void setPhoneNumber(String strPhone) {
    	strPhoneNumber = strPhone;
    }
    
    /**
     * 
     * @param strEmail
     */
    public void setEmailAddress(String strEmail) {
    	strEmailAddress = strEmail;
    }
    
    /**
     * 
     * @return
     */
    public String getFirstName() {
    	return strFirstName;
    }
    
    /**
     * 
     * @return
     */
    public String getLastName() {
    	return strLastName;
    }
    
    /**
     * 
     * @return
     */
    public String getAddress1() {
    	return strAddress1;
    }
    
    /**
     * 
     * @return
     */
    public String getAddress2() {
    	return strAddress2;
    }
    
    /**
     * 
     * @return
     */
    public String getCity() {
    	return strCity;
    }
    
    /**
     * 
     * @return
     */
    public String getState() {
    	return strState;
    }
    
    /**
     * 
     * @return
     */
    public int getZipCode() {
    	return intZipCode;
    }
    
    /**
     * 
     * @return
     */
    public String getPhoneNumber() {
    	return strPhoneNumber;
    }
    
    /**
     * 
     * @return
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
