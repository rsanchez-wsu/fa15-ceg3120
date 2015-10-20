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
	private static final Logger LOG = LoggerFactory.getLogger(DataAccessLayer.class);
	
	private static volatile ServerSocket serverSocket = null;
	
	Socket socket = null;

	/*
	 * Initializes
	 */
	private static void initializeSocketListener( int iPort ){
		
		// -- Check to see if the serverSocket is null or closed. If so, open it. -- CM
		if( serverSocket == null ){
			try{
				
				serverSocket = new ServerSocket( iPort );
				
				// -- Create our thread that will be listening on the specified port. -- CM
				Thread socketListenerThread = new Thread(new Runnable() {
				    public void run() {
				    	try{
				    		// -- Start accepting input.
							Socket clientSocket = serverSocket.accept();
							
							// -- Runs a continuous loop that will grab input on the socket. -- CM
							for(;;){
								if( clientSocket.isConnected() 
										&& clientSocket.getInputStream().toString().length() > 0 ) {
									// -- If we reached here, the inputstream had some value in it. Handle it.
									
								}
							}// -- End of continuous loop
							
						}catch( Exception e ){
							// -- Exception caught, what happened and what do we do?
							LOG.debug( e.toString() );
						}
				   }}); // -- End of Thread()
				
				// -- Start the thread.
				socketListenerThread.start();
				
			}catch( Exception e ){
				// -- Exception caught, what happened and what do we do? -- CM
				LOG.debug( e.toString() );
			}	
		}
	}
	
	/**
	 * Main method, starts the process of listening
	 */
	public static void main(String[] args) {
		LOG.trace("Starting Data Access Layer...");
		
		int iPort = 4001; 
		
		initializeSocketListener(iPort);
		
	}
}