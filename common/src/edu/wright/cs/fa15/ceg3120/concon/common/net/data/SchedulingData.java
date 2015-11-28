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

//import edu.wright.cs.fa15.ceg3120.concon.common.net.NetworkManager;
import java.io.Serializable;



/**
 * Description.
 * @author Emily
 */
public class SchedulingData implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	
	private String month = "";
	private int day = 0;
	private String timeRange = "";
	
	/**
	 * Description. No argument constructor for SchedulingData.
	 */
	public SchedulingData() { }
	
	/**
	 * Description. 
	 * @param month Month.
	 * @param day Day.
	 * @param timeRange Time range.
	 */
	public SchedulingData(String month, int day, String timeRange) {
		this.month = month;
		this.day = day;
		this.timeRange = timeRange;
	}

	/**
	 * Get month.
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * Set month.
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * Get day.
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Set day.
	 * @param day the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * Get timeRange.
	 * @return the timeRange
	 */
	public String getTimeRange() {
		return timeRange;
	}

	/**
	 * Set timeRange.
	 * @param timeRange the timeRange to set
	 */
	public void setTimeRange(String timeRange) {
		this.timeRange = timeRange;
	}
	/*
	 * Returns a string with all of the classes' data
	 * in a readable form
	 * 
	 * @return A string with the classes' parameters
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SchedulingData [month=" + month + ", day=" + day + ", timeRange=" + timeRange + "]";
	}
	
}