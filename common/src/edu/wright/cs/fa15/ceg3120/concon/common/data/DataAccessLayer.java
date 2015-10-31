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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Class for accessing database. Will be communicating with db through network stack.
 */
@SuppressWarnings("unused")
public class DataAccessLayer extends Thread{
	
	private String statement = "";
	private static final Logger LOG = LoggerFactory.getLogger( DataAccessLayer.class );
	
	/*
	 * Final static string that will be used to help identify the objects coming into the
	 * data access layer.  The object that is coming in must have a class type of the following:
	 * */
	private static final String sContractorAccount  = "ContractorAccount";
	private static final String sContractorReview   = "ContractorReview";
	private static final String sHomeownerAccount   = "HomeownerAccount";
	private static final String sHomeownerReview    = "HomeownerReview";
	private static final String sJobRequest		    = "JobRequest";
	private static final String sReview			    = "Review";
	private static final String sServerAdminAccount = "ServerAdminAccount";
	private static final String sTag			    = "Tag";
	private static final String sUserAccount        = "UserAccount";
	
	private static ArrayList<RequestObject> requestQueue = new ArrayList<>();
	
	/**
	 * This function takes in a generic object with a request type.  
	 * Then, the data is combined into a single object, RequestObject, and added to
	 * a list to be processed later.
	 * .
	 * This list allows us to keep in line which request we need to handle first.  This will
	 * help avoid DataBase issues that would otherwise arise.
	 */
//	 @param final inputData
//	 @param final reqType
//	 @return
	public boolean sendDatabaseRequest(final Object inputData, final RequestType reqType) {
		// -- Throw in a log to keep track of our data and type.
		if (inputData == null && reqType == null) {
			LOG.trace("-- DataAccessLayer.sendDatabaseRequest. " 
					+ "" + "; " + "Req: " + "" );
		} else if (inputData == null) {
			LOG.trace("-- DataAccessLayer.sendDatabaseRequest. " 
					+ "" + "; " + "Req: " + reqType.toString() );
		} else if (reqType == null) {
			LOG.trace("-- DataAccessLayer.sendDatabaseRequest. " 
					+ inputData.getClass().toString() + "; " 
					+ "Req: " + "" );
		} else {
			LOG.trace("-- DataAccessLayer.sendDatabaseRequest. " 
					+ inputData.getClass().toString() + "; " 
					+ "Req: " + reqType.toString() );			
		}
		
		// -- Make sure that we have the data that we need.
		if ( inputData != null && reqType != null) {
			
			// -- Make sure that we are not READ request, this must be handled another way.
			if ( reqType != RequestType.READ ) {
				
				// -- Otherwise, create the request object and add it to the queue.
				RequestObject reqObject = new RequestObject( inputData, reqType );
				requestQueue.add(reqObject);
				
				// -- Return success.
				return true;
			}
		}
		// -- The request was not added to the list.
		return false;
	}	
	
	/**
	 * Since we must return data on a read, this must be handled differently than a post
	 * to the DB.  
	 * .
	 * Take the input data and request type and process it.
	 */
//	 @param inputData
//	 @param reqType
//	 @return
	public String getDatabaseData(Object inputData, RequestType reqType) {
		// -- Throw in a log to keep track of where we are at in the log.
		if (inputData == null) {
			LOG.trace("-- DataAccessLayer.getDatabaseData"
					+ "" + "; " + "Req: " + reqType.toString() );
		} else {
			LOG.trace("-- DataAccessLayer.getDatabaseData" 
					+ inputData.getClass().toString() + "; " 
					+ "Req: " + reqType.toString() );			
		}

		
		String returnData = "";
		
		// -- We will only work for READ requests.
		if ( reqType == RequestType.READ && inputData != null ) {
			returnData = processReadRequest( inputData );
		}
		
		// -- Return what we found.
		return returnData;
	}
	
	/**
	 * This function will process the inputData of a message with a request type of Create.
	 * Once the inputData format is completed, we will then use this function to 
	 * push data into a table in the database.
	 */
//	 @param inputObject
//	 @return
	private static boolean processCreateRequest(RequestObject inputObject) {
		return false;
	}
	
	/**
	 * Take the input data and return the information that was requested.
	 * @param inputData Object inputData.
	 * @return empty String.
	 */
	private static String processReadRequest(Object inputData) {
		return "";
	}
	
	/**
	 * Take the input data and process an update to the database.
	 */
//	 @param inputData
//	 @return
	private static boolean processUpdateRequest(RequestObject inputObject) {
		return false;
	}
	/**
	 * Take the input data and process a delete on an object in the database.
	 * 
	 * @return boolean false.
	 */
//	@param inputData
	private static boolean processDeleteRequest(RequestObject inputObject) {
		return false;
	}
	
	/**
	 * Once designed out, this function will commit an object to the database.
	 * @param inputData Object inputData.
	 * @return boolean value
	 */
	/*public static boolean commitDataObject(Object inputData){
		
		if( inputData != null ){
			if( inputData.getClass().equals(ContractorAccount.class) ){
				
			}
			else if( inputData.getClass().equals(ContractorReview.class) ){
				
			}
			else if( inputData.getClass().equals(HomeownerAccount.class) ){
				
			}
			else if( inputData.getClass().equals(HomeownerReview.class) ){
				
			}
			else if( inputData.getClass().equals(JobRequest.class) ){
				
			}
			else if( inputData.getClass().equals(Review.class) ){
				
			}
			else if( inputData.getClass().equals(ServerAdminAccount.class) ){
				
			}
			else if( inputData.getClass().equals(Tag.class) ){
				
			}
			else{
				
			}
		}
		
		
		// -- Return false, we did not commit the object.
		return false;
	}*/
	
	/**
	 * Main class.  Needed at least one in the package. Log a simple line of text.
	 * @param args.
	 */
	public static void main(String[] args) {
		LOG.trace("Starting Data Access Layer...");
		DataAccessLayer dal = new DataAccessLayer();
		dal.start();
	}

	/**
	 * Run the loop that will check for request objects in the request list.
	 * .
	 * NOTE:  This will not check for requests for Read requests.  Since Reading will need
	 * to be synchronous to return a string of data.  Otherwise, take the request off of the
	 * list, perform it in the background and move on.
	 */
	@Override
	public void run() {
		// -- Create a continuous loop to be searching for requests in the request queue.
		for (;;) {
			// -- Check to see if we have something, otherwise move on.
			if ( requestQueue.size() > 0 ) {
				// -- Grab the object that was added first.
				RequestObject currentRequest = requestQueue.get( 0 );
				
				// -- Check to see what type of request we are working with.
				switch ( currentRequest.getRequestType() ) {
				case CREATE:
					processCreateRequest( currentRequest );
					break;
				case UPDATE:
					processUpdateRequest( currentRequest );
					break;
				case DELETE:
					processDeleteRequest( currentRequest );
					break;
				default:
					break;
				}
				// -- Finally, after handling the request, we must remove it from the queue.
				requestQueue.remove( currentRequest );
			}
		}
	}
}