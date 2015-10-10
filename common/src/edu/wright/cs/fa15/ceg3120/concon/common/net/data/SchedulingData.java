/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wright.cs.fa15.ceg3120.concon.common.net.data;

import java.io.Serializable;

/**
 *
 * @author Emily
 */
public class SchedulingData implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 8642779085161182815L;
	private String month = "";
    private int day = 0;
    private String timeRange = "";
    
    public SchedulingData() { }
    
    public SchedulingData(String month, int day, String timeRange){
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
    
}
