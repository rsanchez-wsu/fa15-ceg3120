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
 * A reviewe posting of a contractor.
 *
 * @author Jonathan Thomas
 *
 */
public class ContractorReview extends Review {

	/**
	 * Construct a contractor review with the given data.
	 * @param id uid of the review.
	 * @param reviewerId uuid of the homeowner doing the reivew.
	 * @param subjectId uuid of the contractor being reviewed.
	 * @param jobId uid of the job the contractor performed.
	 * @param date String representation of the date.
	 * @param text String with the body text of the review.
	 * @param rating overall rating of the contractor.
	 */
	public ContractorReview(int id, int reviewerId, int subjectId, int jobId, String date,
			String text, int rating) {
		super(id, reviewerId, subjectId, jobId, date, text, rating);
	}
}