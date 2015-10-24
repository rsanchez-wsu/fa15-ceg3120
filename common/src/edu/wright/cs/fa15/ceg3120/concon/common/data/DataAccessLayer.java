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

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	private final static String sContractorAccount = "ContractorAccount";
	private final static String sContractorReview  = "ContractorReview";
	private final static String sHomeownerAccount  = "HomeownerAccount";
	private final static String sHomeownerReview   = "HomeownerReview";
	private final static String sJobRequest		   = "JobRequest";
	private final static String sReview			   = "Review";
	private final static String sServerAdminAccount= "ServerAdminAccount";
	private final static String sTag			   = "Tag";
	private final static String sUserAccount       = "UserAccount";
	
	private static ArrayList<RequestObject> requestQueue = new ArrayList<>();
	
	/**
	 * This function takes in a generic object with a request type.  
	 * Then, the data is combined into a single object, RequestObject, and added to
	 * a list to be processed later.
	 * 
	 * This list allows us to keep in line which request we need to handle first.  This will
	 * help avoid DataBase issues that would otherwise arise.
	 * 
	 * @param final inputData
	 * @param final reqType
	 * @return
	 */
	public void sendDatabaseRequest(final Object inputData, final RequestType reqType){
		// -- Throw in a log to keep track of our data and type.
		LOG.trace("-- DataAccessLayer.sendDatabaseRequest. " + 
				inputData.getClass().toString() + "; " + 
				"Req: " + reqType.toString() );
		
		// -- Make sure that we have the data that we need.
		if( inputData != null && reqType != null){
			RequestObject reqObject = new RequestObject( inputData, reqType );
			requestQueue.add(reqObject);
		}
	}		
	
	/**
	 * This function will process the inputData of a message with a request type of Create.
	 * Once the inputData format is completed, we will then use this function to 
	 * push data into a table in the database.
	 * 
	 * @param inputObject
	 * @return
	 */
	private static boolean processCreateRequest(RequestObject inputObject){
		return false;
	}
	
	/**
	 * Take the input data and return the information that was initially requested.
	 * @param inputData
	 * @return
	 */
	private static boolean processReadRequest(RequestObject inputObject){
		return false;
	}
	
	/**
	 * Take the input data and process an update to the database.
	 * @param inputData
	 * @return
	 */
	private static boolean processUpdateRequest(RequestObject inputObject){
		return false;
	}
	/**
	 * Take the input data and process a delete on an object in the database.
	 * @param inputData
	 * @return
	 */
	private static boolean processDeleteRequest(RequestObject inputObject){
		return false;
	}
	
	
	
	/**
	 * Once designed out, this function will commit an object to the database.
	 * @param inputData
	 * @return
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
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.trace("Starting Data Access Layer...");
		DataAccessLayer dal = new DataAccessLayer();
		dal.start();
	}

	@Override
	public void run() {
		// -- Create a continuous loop to be searching for requests in the request queue.
		for(;;){
			// -- Check to see if we have something, otherwise move on.
			if( requestQueue.size() > 0 ){
				// -- Grab the last object in the queue to give it priority.
				RequestObject currentRequest = requestQueue.get( requestQueue.size() - 1 );
				
				// -- Check to see what type of request we are working with.
				switch( currentRequest.getRequestType() ){
				case CREATE:
					processCreateRequest(currentRequest);
					break;
				case READ:
					processReadRequest(currentRequest);
					break;
				case UPDATE:
					processUpdateRequest(currentRequest);
					break;
				case DELETE:
					processDeleteRequest(currentRequest);
					break;
				default: break;
				}
				// -- Finally, after handling the request, we must remove it from the queue.
				requestQueue.remove(currentRequest);
			}
		}
	}
}