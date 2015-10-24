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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for accessing database. Will be communicating with db through network stack.
 */
@SuppressWarnings("unused")
public class DataAccessLayer {
	
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
	
	/**
	 * Take in a generic object and a request type.  This function will act as the distributor
	 * of work for the data access layer.  The work will be passed out based on the request type.
	 * 
	 * Each new request will create it's own thread which will allows multiple requests to be handled.
	 * 
	 * Inputs are set to final as they are not to be modified on their way to the DB.
	 * 
	 * @param final inputData
	 * @param final reqType
	 * @return
	 */
	public static void sendDatabaseRequest(final Object inputData, final RequestType reqType){
		
		LOG.trace("-- DataAccessLayer.sendDatabaseRequest. " + 
				inputData.getClass().toString() + "; " + 
				"Req: " + reqType.toString() );
		
		// -- Make sure that we have data to process. If not, move on and don't do anything.
		if( inputData != null && reqType != null ){
			
			// -- Using a switch statement here to sort out what type of request that we have.
			switch(reqType){
			case CREATE:
				// -- Create a new thread with the create request message type.
				Thread newCreateThread = new Thread() {
				    public void run() {
				        try {
				        	// -- More work to be done here.
				        	processCreateRequest(inputData);
				        } catch( Exception e ) {
				        	// -- Thread failed, log it.
				        	logFailedThreadRequest( e, reqType);
				        }
				    }
				};
				newCreateThread.start();
				break;
				
			case DELETE:
				// -- Create a new thread with the delete request type.
				Thread newDeleteThread = new Thread() {
				    public void run() {
				        try {
				        	// -- More work to be done here.
				        	processDeleteRequest(inputData);
				        } catch( Exception e ) {
				        	// -- Thread failed, log it.
				        	logFailedThreadRequest( e, reqType);
				        }
				    }
				};
				newDeleteThread.start();
				break;
				
			case READ:
				// -- Creates a thread that will handle the Read request message type.
				Thread newReadThread = new Thread() {
				    public void run() {
				        try {
				        	// -- More work to be done here.
				        	processReadRequest(inputData);
				        } catch( Exception e ) {
				        	// -- Thread failed, log it.
				        	logFailedThreadRequest( e, reqType);
				        }
				    }
				};
				newReadThread.start();
				break;
				
			case UPDATE:
				// -- Create a thread for the Update request message type.
				Thread newUpdateThread = new Thread() {
				    public void run() {
				        try {
				        	// -- More work to be done here.
				        	processUpdateRequest(inputData);
				        } catch( Exception e ) {
				        	// -- Thread failed, log it.
				        	logFailedThreadRequest( e, reqType);
				        }
				    }
				};
				newUpdateThread.start();
				break;
			default:
				// -- The request was not an enum of RequestType.java, log it and ignore it.
				LOG.trace("-- DataAccessLayer.sendDatabaseRequest. Invalid request" + 
						inputData.getClass().toString() + "; " + 
						"Req: " + reqType.toString() );
				break;
			}
		}
	}
	
	/**
	 * This function will process the inputData of a message with a request type of Create.
	 * Once the inputData format is completed, we will then use this function to 
	 * push data into a table in the database.
	 * 
	 * @param inputData
	 * @return
	 */
	private static boolean processCreateRequest(Object inputData){
		return false;
	}
	
	/**
	 * Take the input data and return the information that was initially requested.
	 * @param inputData
	 * @return
	 */
	private static boolean processReadRequest(Object inputData){
		return false;
	}
	
	/**
	 * Take the input data and process an update to the database.
	 * @param inputData
	 * @return
	 */
	private static boolean processUpdateRequest(Object inputData){
		return false;
	}
	/**
	 * Take the input data and process a delete on an object in the database.
	 * @param inputData
	 * @return
	 */
	private static boolean processDeleteRequest(Object inputData){
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
	 * Generic function that will log the errors if a thread fails.
	 * The Exception will be printed as well as the request type.
	 * @param e
	 * @param reqType
	 */
	private static void logFailedThreadRequest( Exception e, RequestType reqType ){
		LOG.trace("FAILED: -- DataAccessLayer. Failed to start thread for " + 
				reqType.toString() + " request.\n" + " -- Error: " + e.toString() );
	}
	
	/**
	 * Main class.  Needed at least one in the package. Log a simple line of text.
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.trace("Starting Data Access Layer...");
	}
}