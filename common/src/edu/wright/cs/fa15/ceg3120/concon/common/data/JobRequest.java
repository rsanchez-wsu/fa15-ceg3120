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

public class JobRequest {

	/** 
	 * Signifies whether this request is a new job or a request for all jobs
	 * from a given account.
	 */
	private String requestType;
	/** User making request. */
	private HomeOwnerAccount user;
	/** Earliest construction can begin. */
	private String dateRangeStart;
	/** Latest date construction can begin. */
	private String dateRangeEnd;
    
	public JobRequest() {
		
	}

	public String getDateRangeStart() {
		return dateRangeStart;
	}

	public void setDateRangeStart(String dateRangeStart) {
		this.dateRangeStart = dateRangeStart;
	}

	public String getDateRangeEnd() {
		return dateRangeEnd;
	}

	public void setDateRangeEnd(String dateRangeEnd) {
		this.dateRangeEnd = dateRangeEnd;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public HomeOwnerAccount getUser() {
		//clone this?
		return user;
	}

	public void setUser(HomeOwnerAccount user) {
		this.user = user;
	}

}
