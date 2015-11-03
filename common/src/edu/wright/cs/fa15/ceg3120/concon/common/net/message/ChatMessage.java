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

import edu.wright.cs.fa15.ceg3120.concon.common.net.NetworkManager;
import edu.wright.cs.fa15.ceg3120.concon.common.net.data.UserData;

/**
 * ChatMessage is used to send messages to and from other users through the server.
 * This may not be around for long.
 * @author Networking team
 * @version 1
 * 
 */
public class ChatMessage extends NetworkManager {

//	private static final long serialVersionUID = -2279299798905393963L;
	private String message;
	private UserData from;
	private UserData to;

	/**
	 * Add a message and send it to another user.
	 * Default constructor required for java beans.
	 */
	public ChatMessage() {} // 

	/**
	 * Send a message to another user.
	 * @param message Message text.
	 * @param from Sender.
	 * @param to Recipient.
	 */
	public ChatMessage(String message, UserData from, UserData to) {
		this.message = message;
		this.from = from;
		this.to = to;
	}

	/**
	 * Getter for String message.
	 * @return String message.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Setter for String message.
	 * @param message.
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Getter for UserData from.
	 * @return UserData from.
	 */
	public UserData getFrom() {
		return from;
	}

	/**
	 * Setter for UserData from.
	 * @param from.
	 */
	public void setFrom(UserData from) {
		this.from = from;
	}

	/**
	 * Getter for UserData to.
	 * @return UserData to.
	 */
	public UserData getTo() {
		return to;
	}

	/**
	 * Setter for UserDat to.
	 * @param to.
	 */
	public void setTo(UserData to) {
		this.to = to;
	}

	/**
	 * Javadoc needed.
	 */
	public String toString() {
		return "ChatMessage [message=" + message + ", from=" + from + ", to=" + to + "]";
	}
}
