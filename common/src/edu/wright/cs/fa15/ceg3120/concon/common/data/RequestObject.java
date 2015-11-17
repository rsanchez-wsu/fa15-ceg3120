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

import java.io.Serializable;

/**
 * Class that will be used to hold the request data and request type together in a queue.
 * 
 * <p>This class is a JavaBean.
 * @author Moorman
 *
 */
public class RequestObject implements Serializable {

	private static final long serialVersionUID = -5760907638618079855L;
	private DatabaseEntity data;
	private RequestType requestType;
	
	/**
	 * Default no-arg constructor.
	 */
	public RequestObject() {
		
	}
	
	/**
	 * Construct a RequestObject.
	 * @param inputData Data being requested.
	 * @param reqType Type of request.
	 */
	public RequestObject( DatabaseEntity inputData, RequestType reqType ) {
		this.data = inputData;
		this.requestType = reqType;
	}
	
	/**
	 * Get the data being requested.
	 * @return data DatabaseEntity.
	 */
	public DatabaseEntity getData() {
		return this.data;
	}
	
	/**
	 * Gets the class type of the data contained in the request object.
	 * @return class type of data
	 */
	public Class<?> getDataClass() {
		return this.data.getClass();
	}
	
	/**
	 * Get the type of request.
	 * @return RequestType.
	 */
	public RequestType getRequestType() {
		return this.requestType;
	}
	
	/**
	 * Set the data property of this object.
	 * @param data Any Object that is being sent as an argument to the database.
	 */
	public void setData(DatabaseEntity data) {
		this.data = data;
	}
	
	/**
	 * Set the request type.
	 * @param reqType RequestType enum field.
	 */
	public void setRequestType(RequestType reqType) {
		this.requestType = reqType;
	}
}
