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

package edu.wright.cs.fa15.ceg3120.concon.common.net.data;

import edu.wright.cs.fa15.ceg3120.concon.common.net.ConConClient;
import edu.wright.cs.fa15.ceg3120.concon.common.net.MessageHolder;
import edu.wright.cs.fa15.ceg3120.concon.common.net.NetworkHandler;
import edu.wright.cs.fa15.ceg3120.concon.common.net.NetworkManager;

import java.io.Serializable;

/**
 * Holds basic user data.
 * 
 * @author NathanJent
 *
 */
public class UserData implements Serializable {

	private static final long serialVersionUID = -1804728648292102844L;
	
	private String accountName;
	private String uuid;

	/**
	 * UserData for passing user account information over network.
	 * Default Constructor for JavaBeans.
	 */
	public UserData() { }	
	
	/**
	 * Description. TODO Fill out.
	 * @param accountName User's account name.
	 */
	public UserData(String accountName) {
		this.accountName = accountName;
		this.uuid = "A49F"; //TODO need methods to generate new UUID
	}
	
	/**
	 * Description. TODO Fill out.
	 * @param accountName User's account name.
	 */
	public UserData(String accountName, String uuid) {
		this.accountName = accountName;
		this.uuid = uuid; //TODO need methods to generate new UUID
	}
	
	/**
	 * Persist updated user data to the database.
	 * @param user given user
	 * @return end connection message
	 */
	@NetworkHandler(channel = "persistUserData")
	public static MessageHolder persistUserData(UserData user) {
		// TODO write updated user to the database here
		return new MessageHolder("end", null);
	}

	/**
	 * Sets the current user for the client.
	 * @param user given user
	 * @return end connection message
	 */
	@NetworkHandler(channel = "returnUserData")
	public static MessageHolder setCurrentUser(UserData user) {
		ConConClient client = NetworkManager.getClient();
		client.setCurrentUser(user);
		return new MessageHolder("end", null);
	}	
	
	/**
	 * Get accountName.
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * Set accountName.
	 * @param accountName the accountName to set
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	/**
	 * Get uuid.
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * Set uuid.
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserData [accountName=" + accountName + ", uuid=" + uuid + "]";
	}
	
}
