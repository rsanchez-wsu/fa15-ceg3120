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

package edu.wright.cs.fa15.ceg3120.concon.common.net.message;

import edu.wright.cs.fa15.ceg3120.concon.common.net.data.NetworkData;

import java.util.ArrayList;
import java.util.List;

/**
 * A data response message contains a list of JavaBean type 
 * NetworkData objects returned as a result of a data request.
 * @author NathanJent
 *
 */
public class DataResponseMessage extends NetworkMessage {
	
	private static final long serialVersionUID = 5810385430906109196L;
	private List<NetworkData> dataList = new ArrayList<>();
	
	/**
	 * Response message from a database request.
	 * Default constructor required for java beans.
	 */
	public DataResponseMessage() {}

	/**
	 * Add data objects to the message.
	 *
	 */
	public void add(NetworkData data) {
		dataList.add(data);
	}

	/**
	 * Get data objects from the message.
	 *
	 */
	public List<NetworkData> getDataList() {
		return dataList;
	}

	/**
	 * Set the list of data objects for the message.
	 */
	public void setDataList(List<NetworkData> dataList) {
		this.dataList = dataList;
	}
}
