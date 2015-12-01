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

import edu.wright.cs.fa15.ceg3120.concon.common.data.RequestType;

import java.util.HashMap;

/**
 * Exception thrown when a request data object is created with the wrong type of request.
 * @author Jonathan Thomas
 *
 */
public class RequestTypeMismatchException extends Throwable {
	private static final long serialVersionUID = 262001356481065106L;
	
	/**
	 * Create a new exception.
	 */
	public RequestTypeMismatchException() {
		
	}
	
	/**
	 * Create a new exception with a detailed error message.
	 * @param desired The RequestType that should have been used.
	 * @param given The RequestType that was given by mistake.
	 */
	public RequestTypeMismatchException(RequestType desired, RequestType given) {
		super("A database request transfer object was create with type \"" 
				+ typeToNameMap.get(given) + "\" when type \"" + typeToNameMap.get(desired)
				+ "\" was desired.");
	}
	
	private static final HashMap<RequestType, String> typeToNameMap = new HashMap<>();
	
	static {
		typeToNameMap.put(RequestType.CREATE, "CREATE");
		typeToNameMap.put(RequestType.DELETE, "DELETE");
		typeToNameMap.put(RequestType.READ, "READ");
		typeToNameMap.put(RequestType.UPDATE, "UPDATE");
	}

}
