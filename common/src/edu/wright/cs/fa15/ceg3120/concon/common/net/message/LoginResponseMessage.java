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

import edu.wright.cs.fa15.ceg3120.concon.common.net.ConConClient;
import edu.wright.cs.fa15.ceg3120.concon.common.net.NetworkHandler;
import edu.wright.cs.fa15.ceg3120.concon.common.net.NetworkManager;
import edu.wright.cs.fa15.ceg3120.concon.common.net.data.UserData;
import edu.wright.cs.fa15.ceg3120.concon.common.ui.ChatPanel;

/**
 * LoginResponseMessage is used to return user data to the logged in client.
 * @author Networking team
 * @version 1
 * 
 */
public class LoginResponseMessage extends NetworkMessage {

	private static final long serialVersionUID = 1L;
	private UserData user;

	/**
	 * Create login response message.
	 * Default constructor required for java beans.
	 */
	public LoginResponseMessage() {} // 

	/**
	 * Create login verification message.
	 * @param user the user logging in.
	 */
	public LoginResponseMessage(UserData user) {
		this.user = user;
	}

	/**
	 * Get user data.
	 * @return user
	 */
	public UserData getUser() {
		return user;
	}

	/**
	 * Set user.
	 * @param user the user
	 */
	public void setUsername(UserData user) {
		this.user = user;
	}
	
	/**
	 * Sets the current user for the client.
	 */
	@NetworkHandler
	public void setCurrentUser(LoginResponseMessage message) {
		ConConClient client = NetworkManager.getClient();
		client.setCurrentUser(message.getUser());
		client.appendChat(message.getUser().getFirstName() + " connected.");
	}

	@Override
	public String toString() {
		return "LoginResponseMessage [user=" + user + "]";
	}
}
