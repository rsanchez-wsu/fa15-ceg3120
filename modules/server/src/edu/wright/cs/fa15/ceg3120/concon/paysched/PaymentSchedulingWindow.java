/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wright.cs.fa15.ceg3120.concon.paysched;

import javax.swing.JFrame;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Emily
 */
public class PaymentSchedulingWindow {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame paymentAndScheduling = new JFrame("Payment and Scheduling");
        paymentAndScheduling.setDefaultCloseOperation(EXIT_ON_CLOSE);
        paymentAndScheduling.setSize(475, 300);
        TabbedFrame grid = new TabbedFrame();
        grid.setVisible(true);
        paymentAndScheduling.add(grid);
        paymentAndScheduling.setVisible(true);
    }
    
}
