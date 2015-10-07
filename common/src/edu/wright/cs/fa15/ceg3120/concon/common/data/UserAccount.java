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
    // other common data fields
    // perhaps encrypted pswd?

    public UserAccount(AccountType accountType) {
        uuid = "Debug";
        this.accountType = accountType;
    }

    /**
     * Creates a new instance of <code>UserAccount</code>.
     * 
     * @param uuid
     *            - (String)
     * @param type
     *            - (AccountType)
     * @param pswd
     *            - (char[])
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

//    public char[] getPswd() {
//        return pswd;
//    }

    public void setPswd(char[] pswd) {
        this.pswd = pswd.clone();
    }

    /**
     * Launches the account type specific GUI.
     */
    public void launchGui(){}

}
