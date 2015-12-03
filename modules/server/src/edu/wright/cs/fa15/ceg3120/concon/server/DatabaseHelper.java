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

/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package edu.wright.cs.fa15.ceg3120.concon.server;

import org.apache.derby.iapi.sql.PreparedStatement;
import org.apache.derby.iapi.sql.ResultSet;

import java.sql.Connection;


/**
 * DatabaseHelper is a bridge to be used between the database and the actual code. All  database 
 * access will be sent through this class.
 * @author Quintin
 *
 */
public class DatabaseHelper {
	Connection connection = null;
	
	/**
	 * Constructor to instantiate and connect to the database.
	 */
	public DatabaseHelper() {
		//Connect to database 
		try {
			// Code to connect here
			
		} catch (Exception CHaNGe_THiS) {
			// Log connection failure and possible reason
			System.out.println("Connection failed");
		}
	}
	
	/**
	 * Prepares a SQL statement to query a set a users from the database.
	 * @param argument One or more string arguments to be used in the WHERE clause of the prepared
	 *	    SQL statement. If the string is argument is NULL, all users will be retrieved.
	 * @return The result set of users that is returned from the database.
	 */
	public ResultSet getUsers(String... argument) {
		ResultSet results = null;
		if (argument[0] == null) {
			// Return all users
		} else {
			// Return users using arguments
		}
		return results;
	}
	
	/**
	 * Prepares a SQL statement to update a specific user's information in the database.
	 * @param uid The unique ID for the user to be updated.
	 * @param columns The columns which to update using the information from data.
	 * @param data The data to input into the columns specified.
	 * @return True if the row was correctly updated false if otherwise.
	 */
	public boolean update(String uid, String[] columns, String[] data) {
		int rowsUpdated = 0; // The database should return 1 for rows updated.
		
		return rowsUpdated > 0;
	}
	
	/**
	 * Prepares a statement to remove a specified user from the database.
	 * @param uid The unique ID for the user to be updated.
	 * @return True on a successful removal from the database, false if otherwise.
	 */
	public boolean removeUser(String uid) {
		boolean userRemoved = false;
		// When transaction is complete, set userRemoved to true.
		
		return userRemoved;
	}
	
	/**
	 * Executes the custom prepared statement on the database.
	 * @param statement The custom statement to be executed.
	 * @return The result set returned from the statement.
	 */
	public ResultSet buildQuery(PreparedStatement statement) {
		ResultSet results = null;
		// Execute statement and return the results.
		return results;
	}

}
