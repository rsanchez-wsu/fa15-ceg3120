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

package edu.wright.cs.fa15.ceg3120.concon.paysched;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

//import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Emily
 */
public class PaymentSchedulingWindow extends JFrame{

	private static final long serialVersionUID = 1L;

	/**
	 * Main entry point.
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				   
				TabbedFrame paymentAndScheduling = new TabbedFrame();
				paymentAndScheduling.setDefaultCloseOperation(EXIT_ON_CLOSE);
				paymentAndScheduling.setSize(475, 300);
				paymentAndScheduling.setVisible(true);
			}
		});
	}
}
	

