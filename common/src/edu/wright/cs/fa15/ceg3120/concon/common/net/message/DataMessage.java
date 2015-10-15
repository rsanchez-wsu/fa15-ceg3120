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
 * A data message contains a list of JavaBean type NetworkData objects.
 * 
 * @author NathanJent
 *
 */
public class DataMessage extends NetworkMessage {
	
	private static final long serialVersionUID = -5735416327662546203L;
	private List<NetworkData> dataList = new ArrayList<>();

	public DataMessage() {} // Default constructor required for java beans.

	public void add(NetworkData data) {
		dataList.add(data);
	}

	public List<NetworkData> getDataList() {
		return dataList;
	}

	public void setDataList(List<NetworkData> dataList) {
		this.dataList = dataList;
	}
}
