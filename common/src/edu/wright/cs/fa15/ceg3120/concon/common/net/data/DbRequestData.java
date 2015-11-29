/*
 * Copyright (C) 2015
 *
 * Database request data object that will be sent over the network.
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

import edu.wright.cs.fa15.ceg3120.concon.common.data.RequestObject;
import edu.wright.cs.fa15.ceg3120.concon.common.net.MessageHolder;
import edu.wright.cs.fa15.ceg3120.concon.common.net.NetworkHandler;

import java.io.Serializable;

/**
 * Stuff.
 * @author Jonathan Thomas
 *
 */
public class DbRequestData implements Serializable {
	private static final long serialVersionUID = 4577414213278554076L;
	
	RequestObject request;
	
	/**
	 * Default no-arg constructor.
	 */
	public DbRequestData() {
		
	}
	
	/**
	 * Construct a new DbRequestData object with the given RequestObject.
	 * @param request RequestObject to use.
	 */
	public DbRequestData(RequestObject request) {
		this.request = request;
	}
	
	/**
	 * Set the RequestObject for this data object.
	 * @param request RequestObject to use.
	 */
	public void setRequest(RequestObject request) {
		this.request = request;
	}
	
	/**
	 * Get the RequestObject contained in this object.
	 * @return A RequestObject object.
	 */
	public RequestObject getRequest() {
		return request;
	}
	
	/**
	 * Send a data request to the server over the network.
	 * @param request DbRequestData object containing the RequestObject to use.
	 * @return A MessageHolder object containing the request to be sent.
	 */
	@NetworkHandler(channel = "toServer")
	public static MessageHolder sendRequestToServer(DbRequestData request) {
		
		return new MessageHolder("fromClient", request);
	}
	
	/**
	 * Receive a request from the client, process it, and send back any result.
	 * @param request DbRequestData object containing the request to be processed.
	 * @return MessageHolder object containing the result.
	 */
	@NetworkHandler(channel = "fromClient")
	public static MessageHolder recieveRequestFromClient(DbRequestData request) {
		// TODO Do something with the request
		
		DbRequestData result = new DbRequestData();
		
		return new MessageHolder("toClient", result);
	}
	
	/**
	 * Accept the results of a data request from the server over the network.
	 * @param result The result of the database query, contained in a DbRequestObject.
	 * @return Null MessageHolder that ends the communication.
	 */
	@NetworkHandler(channel = "toClient")
	public static MessageHolder receiveResultFromServer(DbRequestData result) {
		
		return new MessageHolder("end", null);
	}

}
