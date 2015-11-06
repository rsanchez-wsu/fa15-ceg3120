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

package edu.wright.cs.fa15.ceg3120.concon.common.net;

import java.io.Serializable;

/**
 * A basic tuple class for holding any object and a channel identifier.
 */
public class MessageHolder implements Serializable {

	private static final long serialVersionUID = 7203906416485915160L;
	private String channel;
	private Serializable message;

	/**
	 * Defaault Constructor for Javabeans.
	 */
	public MessageHolder() { }

	/**
	 * Constructor.
	 * @param channel the channel.
	 * @param message the message.
	 */
	public MessageHolder(String channel, Serializable message) {
		this.channel = channel;
		this.message = message;
	}

	/**
	 * Get channel.
	 * @return the channel
	 */
	public String getChannel() {
		return channel;
	}

	/**
	 * Set channel.
	 * @param channel the channel to set
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}

	/**
	 * Get message.
	 * @return the message
	 */
	public Serializable getMessage() {
		return message;
	}

	/**
	 * Set message.
	 * @param message the message to set
	 */
	public void setMessage(Serializable message) {
		this.message = message;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MessageHolder [channel=" + channel + ", message=" + message + "]";
	}
}
