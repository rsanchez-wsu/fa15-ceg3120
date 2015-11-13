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

package edu.wright.cs.fa15.ceg3120.concon.common.data;

/**
 * Enumeration of valid request types.
 * 
 * @author Connor
 *
 */
public enum TableDictionary {
	/**
	 * Enumeration of valid request types.
	 * <p>
	 * Valid options:
	 * </p>
	 * <p>
	 * CREATE, READ, UPDATE, DELETE
	 * </p>
	 * 
	 * @author Connor
	 *
	 */
		/** All bids that have been created. */
		BIDS, PLACED_BIDS, OPEN_BIDS, COMPLETED_BIDS, JOBS, 
		OPEN_JOB, ENDING_JOBS, COMPLETED_JOBS, USER_ACCOUNTS, 
		HOMEOWNER_ACCOUNTS, CONTRACTOR_ACCOUNTS, 
		SERVER_ADMIN_ACCOUNTS, REVIEWS, CONTRACTOR_REVIEWS, 
		HOMEOWNER_REVIEWS, JOB_REVIEWS, TRANSACTION, PAYMENTS, 
		REFUNDS, PAYMENT_PLANS, REFUND_PLANS, PLANS_IN_PROGRESS, 
		FINISHED_PLANS, FINISHED_PAYMENT_PLANS, FINISHED_REFUND_PLANS, 
		PAYMENT_ACCOUNTS, HOMEOWNER_PAYMENT_ACCOUNTS, 
		CONTRACTOR_PAYMENT_ACCOUNTS
}
