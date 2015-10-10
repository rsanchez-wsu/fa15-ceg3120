/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wright.cs.fa15.ceg3120.concon.paysched;

/**this class for the data to send to others.
 *
 * @author Emily
 */
public class SchedulingData<T> {
 
    private String month;
    private String day;
    private String timeRange;
    
    /**Constructs the data to send.
     * 
     * @param month month to send
     * @param day day to send
     * @param timeRange time to send
     */
    
    public SchedulingData(){} //Default constructor
    
    public SchedulingData(String month, String day, String timeRange) {
        this.month = month;
        this.day = day;
        this.timeRange = timeRange;
    }
    
    public void setMonth(String x){
    	month = x;
    }
    
    public void setDay(String y){
    	day = y;
    }
    
    public void setTimeRange(String z){
    	timeRange = z;
    }
    
}
