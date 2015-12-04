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

import edu.wright.cs.fa15.ceg3120.concon.common.net.MessageHolder;
import edu.wright.cs.fa15.ceg3120.concon.common.net.NetworkHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * An abstract template for a review of a contractor or a homeowner.
 * 
 * @author Jonathan Thomas
 *
 */
public abstract class Review implements DatabaseEntity {
	private static final long serialVersionUID = -8844610057484026737L;
	private static final String FETCH_STMT = 
			"SELECT id, reviewerId, subjectId, jobId, date, text, rating "
			+ "FROM reviews WHERE id = ?";
	private static final String INSERT_STMT = 
					"INSERT INTO reviews (reviewerId, subjectId, jobId, date, text, rating) "
					+ "VALUES (?, ?, ?, ?, ?, ?)"
					+ "ON DUPLICATE KEY UPDATE text=VALUES(text), rating=VALUES(rating)";
	private int id;
	private int reviewerId;
	private int subjectId;
	private int jobId;
	private String date;
	private String text;

	// TODO Decide exactly how to store the rating. Options are:
	// Char, int, or possibly an enum. I vote enum, personally.
	private int rating;

	/**
	 * Construct a Review object with the given values.
	 * 
	 * @param id Unique id for the review.
	 * @param reviewerId Id of the person doing the review.
	 * @param subjectId Id of the person being reviewed.
	 * @param jobId Id of the job being reviewed TODO Should this be here?
	 * @param date Date the review was posted.
	 * @param text Text of the review.
	 * @param rating Rating, ranging from 1 to 5.
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
	 * Fetch review from database.
	 * @param review An updated review.
	 * @return the message
	 */
	@NetworkHandler(channel = "fetchReview")
	public MessageHolder fetch(Review review) {
		boolean success = true;
		try {
			Database db = new Database();
			PreparedStatement fetchStmt = null;
			fetchStmt = db.getConnection().prepareStatement(FETCH_STMT);
			try {
				fetchStmt.setInt(1, review.id);
				ResultSet rs = fetchStmt.executeQuery();
				while (rs.next()) {
					review.id = rs.getInt(1);
					review.reviewerId = rs.getInt(2);
					review.subjectId = rs.getInt(3);
					review.jobId = rs.getInt(4);
					review.date = rs.getString(5);
					review.text = rs.getString(6);
					review.rating = rs.getInt(7);
				}
			} catch (SQLException e) {
				success = false;
			} finally {
				try {
					fetchStmt.close();
				} catch (NullPointerException e) {
					// ignore
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (success) {
			return new MessageHolder("returnedReview", review);
		}
		return new MessageHolder("sqlFailed", review);
	}
	
	/**
	 * Insert review into database.
	 * @param review An updated review.
	 * @return the message
	 */
	@NetworkHandler(channel = "returnedReview")
	public MessageHolder returned(Review review) {
		//TODO update UI with requested review details
		return new MessageHolder("end", review);
	}
	
	/**
	 * Insert review into database.
	 * @param review An updated review.
	 * @return the message
	 */
	@NetworkHandler(channel = "insertUpdateReview")
	public MessageHolder insertUpdate(Review review) {
		boolean success = true;
		try {
			Database db = new Database();
			PreparedStatement insertUpdateStmt = null;
			insertUpdateStmt = db.getConnection().prepareStatement(INSERT_STMT);
			try {					
				insertUpdateStmt.setInt(1, review.reviewerId);
				insertUpdateStmt.setInt(2, review.subjectId);
				insertUpdateStmt.setInt(3, review.jobId);
				insertUpdateStmt.setString(4, review.date);
				insertUpdateStmt.setString(5, review.text);
				insertUpdateStmt.setInt(6, review.rating);
				insertUpdateStmt.execute();
			} catch (SQLException e) {
				success = false;
			} finally {
				try {
					insertUpdateStmt.close();
				} catch (NullPointerException e) {
					// ignore
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (success) {
			return new MessageHolder("updateSucceeded", review);
		}
		return new MessageHolder("updateFailed", review);
	}
	
	/**
	 * Successful reply to client.
	 * @param review An updated review.
	 * @return the message
	 */
	@NetworkHandler(channel = "updateSucceeded")
	public MessageHolder successfulUpdate(Review review) {
		//TODO client updates UI
		return new MessageHolder("end", review);
	}
	
	/**
	 * Failed reply to client SQL.
	 * @param review An updated review.
	 * @return the message
	 */
	@NetworkHandler(channel = "sqlFailed")
	public MessageHolder failedUpdate(Review review) {
		//TODO client handles error
		return new MessageHolder("end", review);
	}

	/**
	 * Get id.
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set id.
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get reviewerId.
	 * @return the reviewerId
	 */
	public int getReviewerId() {
		return reviewerId;
	}

	/**
	 * Set reviewerId.
	 * @param reviewerId the reviewerId to set
	 */
	public void setReviewerId(int reviewerId) {
		this.reviewerId = reviewerId;
	}

	/**
	 * Get subjectId.
	 * @return the subjectId
	 */
	public int getSubjectId() {
		return subjectId;
	}

	/**
	 * Set subjectId.
	 * @param subjectId the subjectId to set
	 */
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	/**
	 * Get jobId.
	 * @return the jobId
	 */
	public int getJobId() {
		return jobId;
	}

	/**
	 * Set jobId.
	 * @param jobId the jobId to set
	 */
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	/**
	 * Get date.
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Set date.
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Get text.
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Set text.
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Get rating.
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * Set rating.
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Review [id=" + id + ", reviewerId=" + reviewerId + ", subjectId=" + subjectId
				+ ", jobId=" + jobId + ", date=" + date + ", text=" + text + ", rating=" + rating
				+ "]";
	}
}
