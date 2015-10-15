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

package edu.wright.cs.fa15.ceg3120.concon.common.net;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Holds a pool of connection threads.
 * @author NathanJent
 *
 */
public class ConnectionPool {
    private static final Logger LOG = LoggerFactory.getLogger(ConnectionPool.class);

	private LinkedBlockingQueue<Thread> pool;
	private final long waitTime = 60000; // milliseconds

	private boolean pooling = false;

	private Thread poolHandler;
	
	/**
	 * Default constructor.
	 */
	public ConnectionPool() {
		pool = new LinkedBlockingQueue<>(10);
	}
	
	/**
	 * Initializes pool to the given capacity.
	 */
	public ConnectionPool(int capacity) {
		pool = new LinkedBlockingQueue<>(capacity);
		poolHandler = new Thread(new Runnable() {

			@Override
			public void run() {
				while (isPooling()) {
					Thread connection;
					try {
						connection = pool.take(); // take waits if no connection in queue
						if (connection.isAlive()) {
							pool.put(connection); // put waits if queue is full
						}
					} catch (InterruptedException e) {
						LOG.warn("Connection pool handler interrupted.");
					}
				}
			}
			
		});
	}

	protected synchronized boolean isPooling() {
		return this.pooling ;
	}

	/**
	 * Shutdown all the threads in the connection pool.
	 */
	public void shutdown() {
    	while (!pool.isEmpty()) {
    		Thread connThread;
    		try {
    			// Wait on pool to become available then remove thread
				connThread = pool.poll(waitTime, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e1) {
				// Peek on pool if interrupted
				connThread = pool.peek();
			}
    		connThread.interrupt();
    		try {
	    		// Wait a while for existing tasks to terminate
	    		connThread.join(waitTime);
    		} catch (InterruptedException ie) {
			    // (Re-)Cancel if current thread also interrupted
				try {
					connThread.join();
				} catch (InterruptedException e) {
					LOG.error("Lingering connection threads may exist: ", e);
				}
				
				// Preserve interrupt status
			    Thread.currentThread().interrupt();
			}
    	}
	}

	/**
	 * Adds another connection Runnable to the pool.
	 * @param connection Runnable to be thrown into the thread pool and started.
	 */
	public void add(Runnable connection) {
		try {
			Thread connThread = new Thread(connection);
			pool.offer(connThread, waitTime, TimeUnit.MILLISECONDS);
			connThread.start();
		} catch (InterruptedException e) {
			LOG.error("Could not create connection thread: ", e);
		}
		if (!poolHandler.isAlive()) {
			poolHandler.start();
		}
	}

}
