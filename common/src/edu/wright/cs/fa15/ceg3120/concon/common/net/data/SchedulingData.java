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


/**
 * Description. TODO Fill out.
 * @author Emily
 */
public class SchedulingData implements Serializable {

	private static final long serialVersionUID = 8642779085161182815L;
	
	private String month = "";
    private int day = 0;
    private String timeRange = "";
    
    public SchedulingData() { }
    
    /**
     * Description. TODO Fill out.
     * @param month Month.
     * @param day Day.
     * @param timeRange Time range.
     */
    public SchedulingData(String month, int day, String timeRange) {
        this.month = month;
        this.day = day;
        this.timeRange = timeRange;
    }

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getTimeRange() {
		return timeRange;
	}

	public void setTimeRange(String timeRange) {
		this.timeRange = timeRange;
	}

	@Override
	public String toString() {
		return "SchedulingData [month=" + month + ", day=" + day + ", timeRange=" + timeRange + "]";
	}
    
}
