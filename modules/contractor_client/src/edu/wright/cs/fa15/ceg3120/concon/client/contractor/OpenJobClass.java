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

package edu.wright.cs.fa15.ceg3120.concon.client.contractor;

/**
 * Class for populating job information in the search feature.
 * This class includes the setters and getters.
 *
 */
public class OpenJobClass {
	private int jobNumber;
	private String jobTitle;
	private String jobDescription;
	private String jobCity;
	private int jobCost;
	private int jobDuration;
	private int jobZipCode;
	private double jobDistance;
	private double jobCurBid;
	private double jobPrevBid;
	
	/**
	 * Sets job number for OpenJob object.
	 * @param num is INT job number from method.
	 */
	public void setJobNumber(int num) {
		jobNumber = num;
	}
	
	/**
	 * Sets job title for OpenJob object.
	 * @param title is string job title from method.
	 */
	public void setJobTitle(String title) {
		jobTitle = title;
	}
	
	/**
	 * Sets job description for OpenJob object.
	 * @param desc is string job description from method.
	 */
	public void setJobDesc(String desc) {
		jobDescription = desc;
	}
	
	/**
	 * Sets job city for OpenJob object.
	 * @param city is string job city from method.
	 */
	public void setJobCity(String city) {
		jobCity = city;
	}
	
	/**
	 * Sets job cost for OpenJob object.
	 * @param cost is INT job cost from method.
	 */
	public void setJobCost(int cost) {
		jobCost = cost;
	}
	
	/**
	 * Sets job duration for OpenJob object.
	 * @param dur is INT job duration from method.
	 */
	public void setJobDuration(int dur) {
		jobDuration = dur;
	}
	
	/**
	 * Sets job ZIP code for OpenJob object.
	 * @param zip is INT job ZIP code from method.
	 */
	public void setJobZipCode(int zip) {
		jobZipCode = zip;
	}
	
	/**
	 * Sets job distance for OpenJob object.
	 * @param distance is double distance from method.
	 */
	public void setJobDistance(double distance) {
		jobDistance = distance;
	}
	
	/**
	 * Sets job current bid for OpenJob object.
	 * @param curBid is double current bid.
	 */
	public void setJobCurBid(double curBid) {
		jobCurBid = curBid;
	}
	
	/**
	 * Sets job previous bid for OpenJob object.
	 * @param prevBid is double previous bid.
	 */
	public void setJobPrevBid(double prevBid) {
		jobPrevBid = prevBid;
	}
	
	/**
	 * Gets job number from OpenJob object.
	 * @return INT job number to method.
	 */
	public int getJobNumber() {
		return jobNumber;
	}
	
	/**
	 * Gets job title from OpenJob object.
	 * @return string job title to method.
	 */
	public String getJobTitle() {
		return jobTitle;
	}
	
	/**
	 * Gets job description from OpenJob object.
	 * @return string job description to method.
	 */
	public String getJobDesc() {
		return jobDescription;
	}
	
	/**
	 * Gets job city from OpenJob object.
	 * @return string job city to method.
	 */
	public String getJobCity() {
		return jobCity;
	}
	
	/**
	 * Gets job cost from OpenJob object.
	 * @return INT job cost to method.
	 */
	public int getJobCost() {
		return jobCost;
	}
	
	/**
	 * Gets job duration from OpenJob object.
	 * @return INT job duration to method.
	 */
	public int getJobDuration() {
		return jobDuration;
	}
	
	/**
	 * Gets job ZIP code from OpenJob object.
	 * @return INT job ZIP code to method.
	 */
	public int getJobZipCode() {
		return jobZipCode;
	}
	
	/**
	 * Gets job distance from OpenJob object.
	 * @return double job distance to method.
	 */
	public double getJobDistance() {
		return jobDistance;
	}
	
	/**
	 * Gets job current bid from OpenJob object.
	 * @return double job current bid to method.
	 */
	public double getJobCurBid() {
		return jobCurBid;
	}
	
	/**
	 * Gets job previous bid from OpenJob object.
	 * @return double job previous bid to method.
	 */
	public double getJobPrevBid() {
		return jobPrevBid;
	}
}
