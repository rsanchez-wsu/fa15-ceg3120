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

import java.awt.Image;

/**
 * Model for a JobRequest.
 * 
 * @author Quack
 *
 */
public class JobRequest implements DatabaseEntity {

	private static final long serialVersionUID = 3240132603096376471L;
	/**
	 * Signifies whether this request is a new job or a request for all jobs from a given account.
	 */
	private String requestType;
	/** User making request. */
	private HomeownerAccount user;
	/** Earliest construction can begin. */
	private String dateRangeStart;
	/** Latest date construction can begin. */
	private String dateRangeEnd;
	/** What type of job this is (plumbing, electrical, etc). */
	private String jobField;
	/** User description of what they want done. */
	private String jobDescr;
	/** Images of what the future jobsite looks like now. */
	private transient Image[] picsOfCurrentState;// do we want to allow multiple images?
	// or maybe convert to a ByteArrayInputStream[] and pass raw data around?

	/**
	 * Creates a new instance of <code>JobRequest</code>.
	 */
	public JobRequest() {
		picsOfCurrentState = null;
	}

	/**
	 * Get dateRangeStart.
	 * @return dateRangeStart
	 */
	public String getDateRangeStart() {
		return dateRangeStart;
	}

	/**
	 * Set dateRangeStart.
	 * @param dateRangeStart String
	 */
	public void setDateRangeStart(String dateRangeStart) {
		this.dateRangeStart = dateRangeStart;
	}

	/**
	 * XXX.
	 * @return dateRangeEnd
	 */
	public String getDateRangeEnd() {
		return dateRangeEnd;
	}

	/**
	 * Javadoc needed.
	 *
	 */
	public void setDateRangeEnd(String dateRangeEnd) {
		this.dateRangeEnd = dateRangeEnd;
	}

	/**
	 * Javadoc needed.
	 *
	 */
	public String getRequestType() {
		return requestType;
	}

	/**
	 * Javadoc needed.
	 *
	 */
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	/**
	 * Javadoc needed.
	 *
	 */
	public HomeownerAccount getUser() {
		// clone this?
		return user;
	}

	/**
	 * Javadoc needed.
	 *
	 */
	public void setUser(HomeownerAccount user) {
		this.user = user;
	}

	/**
	 * Javadoc needed.
	 *
	 */
	public String getJobField() {
		return jobField;
	}

	/**
	 * Javadoc needed.
	 *
	 */
	public void setJobField(String jobField) {
		this.jobField = jobField;
	}

	/**
	 * Javadoc needed.
	 *
	 */
	public String getJobDescr() {
		return jobDescr;
	}
	/**
	 * Javadoc needed.
	 *
	 */
	public void setJobDescr(String jobDescr) {
		this.jobDescr = jobDescr;
	}
	/**
	 * Javadoc needed.
	 *
	 */
	public Image[] getPicsOfCurrentState() {
		return (picsOfCurrentState == null) ? null : picsOfCurrentState.clone();
	}
	/**
	 * Javadoc needed.
	 *
	 */
	public void setPicsOfCurrentState(Image[] picsOfCurrentState) {
		this.picsOfCurrentState = picsOfCurrentState.clone();
	}

}