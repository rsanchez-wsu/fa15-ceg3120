/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wright.cs.fa15.ceg3120.concon.paysched;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

//import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Emily
 */
public class PaymentSchedulingWindow extends JFrame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(new Runnable(){
    		public void run(){
    	    	   
        TabbedFrame paymentAndScheduling = new TabbedFrame();
        paymentAndScheduling.setDefaultCloseOperation(EXIT_ON_CLOSE);
        paymentAndScheduling.setSize(475, 300);
        //TabbedFrame grid = new TabbedFrame();
        //grid.setVisible(true);
        //paymentAndScheduling.add(grid);
        paymentAndScheduling.setVisible(true);}
    	});
    }
}
    

