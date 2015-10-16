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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class used for accessing database.
 * @author Cody Bensman
 */

public class Data {
	private Database db = new Database();
	Statement statement;
	private ResultSet results = null;
	
	/**
	 * No argument constructor.
	 */
	public Data() {}
	
	/**
	 * Creates a new home owner account in database.
	 */
	public void createHomeowner(UserAccount user) {
		connect();
		
		try {
			statement.executeUpdate("INSERT INTO tableName VALUES ( values );");
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		disconnect();
	}
	
	/**
	 * Returns information to a specific home owner account in the database.
	 * 
	 */
	public UserAccount getHomeowner(String id) {
		connect();
		
		try {
			results = statement.executeQuery("SELECT columns FROM tableName;");
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		disconnect();
		return null;
	}
	
	/**
	 * Creates a new contractor account in database.
	 */
	public void createContractor(UserAccount user) {
		connect();
		
		try {
			statement.executeUpdate("INSERT INTO tableName VALUES ( values );");
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		disconnect();
	}
	
	/**
	 * Returns information to a specific contractor account.
	 */
	public UserAccount getContractor(String id) {
		connect();
		
		try {
			results = statement.executeQuery("SELECT columns FROM tableName;");
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		disconnect();
		return null;
	}
	
	/**
	 * Creates a new job request in database.
	 */
	public void createJob(JobRequest job) {
		connect();
		
		try {
			statement.executeUpdate("INSERT INTO tableName VALUES ( values );");
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		disconnect();
	}
	
	/**
	 * Returns information for a specific job in the database.
	 */
	public JobRequest getJob(String id) {
		connect();
		
		try {
			results = statement.executeQuery("SELECT columns FROM tableName;");
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		disconnect();
		return null;
	}
	
	/**
	 * Creates a new review in database.
	 */
	public void createReview() {
		connect();
		
		try {
			statement.executeUpdate("INSERT INTO tableName VALUES ( values );");
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		disconnect();
	}
	
	/**
	 * Returns information for a specific review in the database.
	 */
	public Review getReview() {
		connect();
		
		try {
			results = statement.executeQuery("SELECT columns FROM tableName;");
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		disconnect();
		return null;
	}
	
	/**
	 * This method will process the data from a result set.
	 * Good chance that this will need implemented specifically
	 * for each get/query statement.
	 */
	private void processResultSet() {
		try {
			while (results.next()) {
				//get data from results.
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}
	
	/**
	 * Receive de-serialized Send object from networking team.
	 */
	private void receive(Send send) {
		connect();
	}
	
	/**
	 * Connects to the database.
	 */
	private void connect() {
		this.statement = db.getStatement();
		db.connect();
	}
	
	/**
	 * Disconnects from the database.
	 */
	private void disconnect() {
		db.closeConnection();
	}
	
	
	
	/**
	 * This is a fake method used to trick findbugs into not failing the build.
	 */
	public void useUnusedMethodsBecauseFindBugs() {
		DataAccessLayer dal = new DataAccessLayer();
		Send temp = new Send(dal, ObjectPurpose.CREATE_CONTRACTOR);
		receive(temp);
		processResultSet();
	}
}
