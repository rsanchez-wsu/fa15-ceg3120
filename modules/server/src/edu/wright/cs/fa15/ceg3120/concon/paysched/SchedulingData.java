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
 
    private String month = "";
    private int day = 0;
    private String timeRange = "";
    
    /**Constructs the data to send.
     * 
     * @param month month to send
     * @param day day to send
     * @param timeRange time to send
     */
    public SchedulingData(String month, int day, String timeRange) {
        this.month = month;
        this.day = day;
        this.timeRange = timeRange;
    }
    
}
