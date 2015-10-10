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
<<<<<<< HEAD
        this.pswd = (char[])pswd.clone(); // XXX this WILL need changed
=======
        this.pswd = pswd.clone(); // XXX this WILL need changed
>>>>>>> origin/HomeOwnerUIBase
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
<<<<<<< HEAD
        return (char[])pswd.clone();
    }

    public void setPswd(char[] pswd) {
        this.pswd = (char[])pswd.clone();
=======
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
>>>>>>> origin/HomeOwnerUIBase
    }

    /**
     * Launches the account type specific GUI.
     * <p>Must be given functionality by UserAccount sub-classes.</p>
     */
    public void launchGui(){}
}
