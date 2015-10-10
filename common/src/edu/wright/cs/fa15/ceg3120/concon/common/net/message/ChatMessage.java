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

public class ChatMessage extends NetworkMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2279299798905393963L;
	private String message;
	private UserData from;
	private UserData to;

	public ChatMessage() {} // Default constructor required for java beans.

	public ChatMessage(String message, UserData from, UserData to)
	{
		this.message = message;
		this.from = from;
		this.to = to;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserData getFrom() {
		return from;
	}

	public void setFrom(UserData from) {
		this.from = from;
	}

	public UserData getTo() {
		return to;
	}

	public void setTo(UserData to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return "BeanMessage [message=" + message + "]";
	}
}
