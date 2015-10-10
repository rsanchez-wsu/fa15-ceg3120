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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public char[] getPswd() {
        return pswd.clone();
    }

    public void setPswd(char[] pswd) {
        this.pswd = pswd.clone();
    }

    public String getdbResponse() {
        return dbResponse;
    }

    public void setdbResponse(String dbResponse) {
        this.dbResponse = dbResponse;
    }
    
    public void setFirstName(String strFn) {
    	strFirstName = strFn;
    }
    
    public void setLastName(String strLn) {
    	strLastName = strLn;
    }
    
    public void setAddress1(String strAdd1) {
    	strAddress1 = strAdd1;
    }
    
    public void setAddress2(String strAdd2) {
    	strAddress2 = strAdd2;
    }
    
    public void setCity(String strCt) {
    	strCity = strCt;
    }
    
    public void setState(String strSt) {
    	strState = strSt;
    }
    
    public void setZipCode(int zip) {
    	intZipCode = zip;
    }
    
    public void setPhoneNumber(String strPhone) {
    	strPhoneNumber = strPhone;
    }
    
    public void setEmailAddress(String strEmail) {
    	strEmailAddress = strEmail;
    }
    
    public String getFirstName() {
    	return strFirstName;
    }
    
    public String getLastName() {
    	return strLastName;
    }
    
    
    public String getAddress1() {
    	return strAddress1;
    }
    
    public String getAddress2() {
    	return strAddress2;
    }
    
    public String getCity() {
    	return strCity;
    }
    
    public String getState() {
    	return strState;
    }
    
    public int getZipCode() {
    	return intZipCode;
    }
    
    public String getPhoneNumber() {
    	return strPhoneNumber;
    }
    
    public String getEmailAddress() {
    	return strEmailAddress;
    }


    /**
     * Launches the account type specific GUI.
     * <p>Must be given functionality by UserAccount sub-classes.</p>
     */
    public void launchGui() {}
}
