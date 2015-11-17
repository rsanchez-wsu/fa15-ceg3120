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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This class will create prepared statements for execution against the database.
 *
 */
public class ConConStatements {

	/**
	 * No argument constructor.
	 */
	public ConConStatements() {
		
	}
	
	/**
	 * Creates a list of prepared statements to be executed against the database,
	 * @param object A request object that has been sent from the client to perform a statement.
	 * @return An array list that contains one or more prepared statements.
	 */
	public static ArrayList<PreparedStatement> generateStatementList(
			RequestObject object, Connection conn) {
		ArrayList<PreparedStatement> statementList = new ArrayList<PreparedStatement>();
		
		switch (object.getRequestType()) {
		case CREATE:
			statementList = createPreparedStatements(object, conn);
			break;
		case READ:
			statementList = readPreparedStatements(object, conn);
			break;
		case UPDATE:
			statementList = updatePreparedStatements(object, conn);
			break;
		case DELETE:
			statementList = deletePreparedStatement(object, conn);
			break;
		default:
			break;
		}
		
		return statementList;
	}
	
	/**
	 * Method to execute a list of prepared statements.
	 * @return A list of result sets that contains the data obtained from the query.
	 */
	public static ArrayList<ResultSet> executeQueryPreparedStatements(
			ArrayList<PreparedStatement> list,Connection conn) {
		ArrayList<ResultSet> resultList = new ArrayList<ResultSet>();
		
		for (int i = 0; i < list.size(); i++) {
			try {
				ResultSet results = list.get(i).executeQuery();
				resultList.add(results);
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		
		list.removeAll(list);
		
		return resultList;
	}
	
	/**
	 * Method to execute a list of prepared statements.
	 */
	public static void executeUpdatePreparedStatement(
			ArrayList<PreparedStatement> list, Connection conn) {
		for (int i = 0; i < list.size(); i++) {
			try {
				list.get(i).executeUpdate();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		list.removeAll(list);
	}
	
	/**
	 * Determines the object type of the request object and creates prepared statements
	 * for CREATE to be executed against the database.
	 * @param ob Request object that will be needed for the prepared statement.
	 */
	private static ArrayList<PreparedStatement> createPreparedStatements(RequestObject ob, 
																				Connection conn) {
		ArrayList<PreparedStatement> list = new ArrayList<PreparedStatement>();
		
		if (ob.getDataClass().equals(ContractorAccount.class)) {
			
			ContractorAccount account = (ContractorAccount) ob.getData();
			
			PreparedStatement createUserAccount = null;
			
			String stmt1 = "INSERT INTO USER_ACCOUNTS (ACCOUNT_TYPE, USERNAME, PASSWORD)"
					+ "VALUES (?, ?, ?)";
			String stmt2 = "INSERT INTO CONTRACTOR_ACCOUNTS (USERNAME,ACCOUNT_CREATED,"
					+ "NUM_JOBS_COMPLETED,PROFILE_IMAGE,FIRST_NAME,LAST_NAME,STREET_ADDRESS_1,"
					+ "STREET_ADDRESS_2,CITY,STATE,ZIPCODE,PHONE_NUMBER,"
					+ "EMAIL) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				createUserAccount = conn.prepareStatement(stmt1);
				createUserAccount.setString(0, account.getAccountType().toString());
				createUserAccount.setString(1, account.getFirstName());
				//This will need worked on.
				//createUserAccount.setString(2, account.getPswd().toString());
				list.add(createUserAccount);
			} catch (SQLException e) {
				System.out.println(e);
			}
			try {
				createUserAccount = conn.prepareStatement(stmt2);
				//Need to bind the properties to the place holders still.
				
				list.add(createUserAccount);
			} catch (SQLException e) {
				System.out.println(e);
			}
			
		} else if (ob.getDataClass().equals(HomeownerAccount.class)) {
			
		} else if (ob.getDataClass().equals(ServerAdminAccount.class)) {
			
		} else if (ob.getDataClass().equals(ContractorReview.class)) {
			
		} else if (ob.getDataClass().equals(HomeownerReview.class)) {
			
		} else if (ob.getDataClass().equals(JobRequest.class)) {
			
		} else if (ob.getDataClass().equals(HomeownerReview.class)) {
			
		}
		
		return list;
	}
	
	/**
	 * Determines the object type of the request object and creates prepared statements
	 * for READ to be executed against the database.
	 * @param ob Request object that will be needed for the prepared statement.
	 */
	private static ArrayList<PreparedStatement> readPreparedStatements(
			RequestObject ob, Connection conn) {
		ArrayList<PreparedStatement> list = new ArrayList<PreparedStatement>();
		
		if (ob.getDataClass().equals(ContractorAccount.class)) {
			
		} else if (ob.getDataClass().equals(HomeownerAccount.class)) {
			
		} else if (ob.getDataClass().equals(ServerAdminAccount.class)) {
			
		} else if (ob.getDataClass().equals(ContractorReview.class)) {
			
		} else if (ob.getDataClass().equals(HomeownerReview.class)) {
			
		} else if (ob.getDataClass().equals(JobRequest.class)) {
			
		} else if (ob.getDataClass().equals(HomeownerReview.class)) {
			
		}
		
		return list;
	}
	
	/**
	 * Determines the object type of the request object and creates prepared statements
	 * for UPDATE to be executed against the database.
	 * @param ob Request object that will be needed for the prepared statement.
	 */
	private static ArrayList<PreparedStatement> updatePreparedStatements(
			RequestObject ob, Connection conn) {
		ArrayList<PreparedStatement> list = new ArrayList<PreparedStatement>();
		
		if (ob.getDataClass().equals(ContractorAccount.class)) {
			
		} else if (ob.getDataClass().equals(HomeownerAccount.class)) {
			
		} else if (ob.getDataClass().equals(ServerAdminAccount.class)) {
			
		} else if (ob.getDataClass().equals(ContractorReview.class)) {
			
		} else if (ob.getDataClass().equals(HomeownerReview.class)) {
			
		} else if (ob.getDataClass().equals(JobRequest.class)) {
			
		} else if (ob.getDataClass().equals(HomeownerReview.class)) {
			
		}
		
		return list;
	}
	
	/**
	 * Determines the object type of the request object and creates prepared statements
	 * for DELETE to be executed against the database.
	 * @param ob Request object that will be needed for the prepared statement.
	 */
	private static ArrayList<PreparedStatement> deletePreparedStatement(
			RequestObject ob, Connection conn) {
		ArrayList<PreparedStatement> list = new ArrayList<PreparedStatement>();
		
		if (ob.getDataClass().equals(ContractorAccount.class)) {
			
		} else if (ob.getDataClass().equals(HomeownerAccount.class)) {
			
		} else if (ob.getDataClass().equals(ServerAdminAccount.class)) {
			
		} else if (ob.getDataClass().equals(ContractorReview.class)) {
			
		} else if (ob.getDataClass().equals(HomeownerReview.class)) {
			
		} else if (ob.getDataClass().equals(JobRequest.class)) {
			
		} else if (ob.getDataClass().equals(HomeownerReview.class)) {
			
		}
		
		return list;
	}
	
	/**
	 * Processes the result set from an executed query.
	 * @param results the result set from an executed query.
	 * @return an object constructed from data retrieved from the result set.
	 */
	/*private Object processResultSet(ResultSet results) {
		Object ob = null;
		
		return ob;
	}*/
}
