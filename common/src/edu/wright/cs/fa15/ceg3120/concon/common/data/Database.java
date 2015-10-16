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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class for connecting to embedded Derby databases.
 * @author Cody Bensman
 */
public class Database {
	//This URL will need to be changed per database.
	private String url = "jdbc:derby:/home/cbensman/Test_DB_Connection;create=true";
	private Statement statement = null;
	private ResultSet results = null;
	private Connection conn = null;
	
	/**
	 * No argument constructor.
	 */
	public Database() {}
	
	/**
	 * Connect to database.
	 */
	private void connect() {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			conn = DriverManager.getConnection(url);
			statement = this.conn.createStatement();
		} catch (SQLException | ClassNotFoundException
				| IllegalAccessException | InstantiationException e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Close connection to the database.
	 */
	private void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Method to update database.
	 */
	public void writeDatabase(String stmt) {
		this.connect();
		try {
			statement.executeUpdate(stmt);
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		this.closeConnection();
	}
	
	/**
	 * Method to read from database.
	 * Returns a ResultSet object.
	 */
	public ResultSet readDatabase(String stmt) {
		this.connect();
		try {
			results = statement.executeQuery(stmt);
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		this.closeConnection();
		return results;
	}
}