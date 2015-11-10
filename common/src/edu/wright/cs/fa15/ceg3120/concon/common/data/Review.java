<<<<<<< HEAD
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
 * An abstract template for a review of a contractor or a homeowner.
 * 
 * @author Jonathan Thomas
 *
 */
public abstract class Review {
	protected int id;
	protected int reviewerId;
	protected int subjectId;
	protected int jobId;
	protected String date;

	protected String text;

	// TODO Decide exactly how to store the rating. Options are:
	// Char, int, or possibly an enum. I vote enum, personally.
	protected int rating;

	/**
	 * Construct a Review object with the given values.
	 * 
	 * @param id
	 *			Unique id for the review.
	 * @param reviewerId
	 *			Id of the person doing the review.
	 * @param subjectId
	 *			Id of the person being reviewed.
	 * @param jobId
	 *			Id of the job being reviewed TODO Should this be here?
	 * @param date
	 *			Date the review was posted.
	 * @param text
	 *			Text of the review.
	 * @param rating
	 *			Rating, ranging from 1 to 5.
	 */
	public Review(int id, int reviewerId, int subjectId, int jobId, String date, String text,
			int rating) {
		this.id = id;
		this.reviewerId = reviewerId;
		this.subjectId = subjectId;
		this.jobId = jobId;
		this.date = date;
		this.text = text;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public int getReviewerId() {
		return reviewerId;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public int getJobId() {
		return jobId;
	}

	public String getDate() {
		return date;
	}

	public String getText() {
		return text;
	}

	public int getRating() {
		return rating;
	}

}
=======
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
 * An abstract template for a review of a contractor or a homeowner.
 * 
 * @author Jonathan Thomas
 *
 */
public abstract class Review {
	protected int id;
	protected int reviewerId;
	protected int subjectId;
	protected int jobId;
	protected String date;

	protected String text;

	// TODO Decide exactly how to store the rating. Options are:
	// Char, int, or possibly an enum. I vote enum, personally.
	protected int rating;

	/**
	 * Construct a Review object with the given values.
	 * 
	 * @param id
	 *			Unique id for the review.
	 * @param reviewerId
	 *			Id of the person doing the review.
	 * @param subjectId
	 *			Id of the person being reviewed.
	 * @param jobId
	 *			Id of the job being reviewed TODO Should this be here?
	 * @param date
	 *			Date the review was posted.
	 * @param text
	 *			Text of the review.
	 * @param rating
	 *			Rating, ranging from 1 to 5.
	 */
	public Review(int id, int reviewerId, int subjectId, int jobId, String date, String text,
			int rating) {
		this.id = id;
		this.reviewerId = reviewerId;
		this.subjectId = subjectId;
		this.jobId = jobId;
		this.date = date;
		this.text = text;
		this.rating = rating;
	}

	/**
	 * Javadoc needed.
	 *
	 */
	public int getId() {
		return id;
	}

	/**
	 * Javadoc needed.
	 *
	 */
	public int getReviewerId() {
		return reviewerId;
	}

	/**
	 * Javadoc needed.
	 *
	 */
	public int getSubjectId() {
		return subjectId;
	}

	/**
	 * Javadoc needed.
	 *
	 */
	public int getJobId() {
		return jobId;
	}

	/**
	 * Javadoc needed.
	 *
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Javadoc needed.
	 *
	 */
	public String getText() {
		return text;
	}

	/**
	 * Javadoc needed.
	 *
	 */
	public int getRating() {
		return rating;
	}

}
>>>>>>> master
