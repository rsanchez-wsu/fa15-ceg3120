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
//import edu.wright.cs.fa15.ceg3120.concon.common.net.NetworkManager;

import java.io.Serializable;


/**
 * Description.
 * @author Emily
 *
 */
public class PaymentData implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private double amountOwed = 0.0;
	private double amountInWallet = 0.0;
	private double amountRemaining = 0.0;
	
	/**
	 * Default Constructor.
	 */
	public PaymentData(){}
	
	/**
	 * 3 Param constructor.
	 */
	public PaymentData(double ao, double aw, double ar) {
		this.amountOwed = ao;
		this.amountInWallet = aw;
		this.amountRemaining = ar;
	}
	
	/**
	 * Sets amountOwed.
	 * @param ao amount owed
	 */
	public void setAmountOwed(double ao) {
		this.amountOwed = ao;
	}
	
	/**
	 * Gets amountOwed.
	 * @return amountOwed
	 */
	public double getAmountOwed() {
		return this.amountOwed;
	}
	
	/**
	 * Sets amountInWallet.
	 * @param aw amount in wallet
	 */
	public void setAmountInWallet(double aw) {
		this.amountInWallet = aw;
	}
	
	/**
	 * Gets amountInWallet.
	 * @return amountInWallet
	 */
	public double getAmountInWallet() {
		return this.amountInWallet;
	}
	
	/**
	 * Sets amountRemaining.
	 * @param ar amount remaining in wallet
	 */
	public void setAmountRemaining(double ar) {
		this.amountRemaining = ar;
	}
	
	/**
	 * Gets amountRemaining.
	 * @return amountRemaining
	 */
	public double getAmountRemaining() {
		return amountInWallet - amountOwed;
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
		return "PaymentData [amountOwed=" + amountOwed + ", amountInWallet=" + amountInWallet 
				+ ", amountRemaining=" + amountRemaining + "]";
	}
	
}//end of class
