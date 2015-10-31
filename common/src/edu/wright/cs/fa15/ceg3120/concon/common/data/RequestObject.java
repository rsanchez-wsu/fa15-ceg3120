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


package edu.wright.cs.fa15.ceg3120.concon.common.data;

/**
 * Class that will be used to hold the request data and request type together in a queue.
 * @author Moorman
 *
 */
public class RequestObject {

	private Object data;
	private RequestType requestType;
	
	/**
	 * Javadoc needed.
	 * @param inputData Object.
	 * @param reqType RequestType.
	 */
	public RequestObject( Object inputData, RequestType reqType ) {
		this.data = inputData;
		this.requestType = reqType;
	}
	
	/**
	 * Javadoc needed.
	 * @return Object data.
	 */
	public Object getData() {
		return this.data;
	}
	
	/**
	 * Javadoc needed.
	 * @return RequestType requestType;
	 */
	public RequestType getRequestType() {
		return this.requestType;
	}
}
