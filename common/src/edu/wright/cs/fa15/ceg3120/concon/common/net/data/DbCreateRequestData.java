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

import edu.wright.cs.fa15.ceg3120.concon.common.data.RequestObject;
import edu.wright.cs.fa15.ceg3120.concon.common.data.RequestType;

/**
 * Data object containing a database "create" request.
 * 
 * @author Jonathan Thomas
 *
 */
public class DbCreateRequestData {
	
	/**
	 * Create an empty object.
	 */
	public DbCreateRequestData() {
		
	}
	
	/**
	 * Create a DbCreateRequestData object to hold the RequestObject given.
	 * @param request RequestObject to transfer.
	 * @throws RequestTypeMismatchException Thrown if the request type of {@code request}
	 * 				is not CREATE.
	 */
	public DbCreateRequestData(RequestObject request) throws RequestTypeMismatchException {
		if (request.getRequestType() != RequestType.CREATE) {
			throw new RequestTypeMismatchException(RequestType.CREATE, request.getRequestType());
		}
		
		// Do stuff.
	}

}
