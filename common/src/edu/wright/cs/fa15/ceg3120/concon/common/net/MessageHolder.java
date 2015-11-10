<<<<<<< HEAD:common/src/edu/wright/cs/fa15/ceg3120/concon/common/net/message/NetworkMessage.java
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

import java.io.Serializable;

public abstract class NetworkMessage implements Serializable {
	
	private static final long serialVersionUID = -8618792710721202266L;

	public NetworkMessage() {}
	
}
=======
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
	private static final long serialVersionUID = 31628748572L;

	public String channel;
	public Serializable message;

	/**
	 * Constructor.
	 * @param channel the channel.
	 * @param message the message.
	 */
	public MessageHolder(String channel, Serializable message) {
		this.channel = channel;
		this.message = message;
	}
}
>>>>>>> master:common/src/edu/wright/cs/fa15/ceg3120/concon/common/net/MessageHolder.java
