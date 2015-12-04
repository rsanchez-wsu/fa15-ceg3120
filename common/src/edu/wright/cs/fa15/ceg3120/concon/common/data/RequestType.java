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

/**
 * Enumeration of valid request types.
 * <p>Valid options:</p>
 * <p>CREATE, READ, UPDATE, DELETE, LOOK_UP</p>
 * <p>**********************************************************</p>
 * <br>
 * <p>CREATE:</p>
 * <p>&nbsp;&nbsp;&nbsp;&nbsp;Request to create new entry in DB</p>
 * <p>READ:</p>
 * <p>&nbsp;&nbsp;&nbsp;&nbsp;Request data for provided entry from DB</p>
 * <p>UPDATE:</p>
 * <p>&nbsp;&nbsp;&nbsp;&nbsp;Request to update entry in DB</p>
 * <p>DELETE:</p>
 * <p>&nbsp;&nbsp;&nbsp;&nbsp;Request to delete entry in DB</p>
 * <p>LOOK_UP:</p>
 * <p>&nbsp;&nbsp;&nbsp;&nbsp;Request to validate and return entry in DB</p>
 * 
 * @author Connor
 *
 */
public enum RequestType {
	CREATE, READ, UPDATE, DELETE, LOOK_UP
}
