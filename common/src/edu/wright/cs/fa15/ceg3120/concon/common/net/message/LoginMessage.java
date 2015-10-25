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

package edu.wright.cs.fa15.ceg3120.concon.common.net.message;

import edu.wright.cs.fa15.ceg3120.concon.common.net.data.UserData;

/**
 * LogonMessage is used to send the login info to the server.
 * @author Networking team
 * @version 1
 * 
 */
public class LoginMessage extends NetworkMessage {

	private static final long serialVersionUID = -2279299798905393963L;
	private UserData user;

	/**
	 * Create login message.
	 * Default constructor required for java beans.
	 */
	public LoginMessage() {} // 

	/**
	 * Create login message.
	 * @param user The user logging in.
	 */
	public LoginMessage(UserData user) {
		this.user = user;
	}

	/**
	 * Getter for UserData from.
	 * @return UserData from.
	 */
	public UserData getUser() {
		return user;
	}

	/**
	 * Setter for UserData from.
	 * @param from.
	 */
	public void setUser(UserData user) {
		this.user = user;
	}
	
	/**
	 * This method is called when logging on to the server.
	 */
	public void login() {
		System.out.println("Logging in...");
	}

	@Override
	public String toString() {
		return "LogonMessage [user=" + user + "]";
	}
}
