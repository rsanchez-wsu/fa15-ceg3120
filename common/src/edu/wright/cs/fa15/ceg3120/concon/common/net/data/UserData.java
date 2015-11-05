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

package edu.wright.cs.fa15.ceg3120.concon.common.net.data;

import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 * Holds basic user data.
 * 
 * @author NathanJent
 *
 */
public class UserData implements Serializable {

	private static final long serialVersionUID = -1804728648292102844L;
	
	private String firstName;
	private String lastName;
	private String uuid;
	private ImageIcon avatar;

	/**
	 * Javadoc needed.
	 *
	 */
	public UserData() { }	
	
	/**
	 * Description. TODO Fill out.
	 * @param firstName User's first name.
	 * @param lastName User's last name.
	 */
	public UserData(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.uuid = "A49F"; //TODO need methods to generate new UUID
	}

	/**
	 * Javadoc needed.
	 *
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Javadoc needed.
	 *
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Javadoc needed.
	 *
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Javadoc needed.
	 *
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Javadoc needed.
	 *
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * Javadoc needed.
	 *
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * Javadoc needed.
	 *
	 */
	public ImageIcon getAvatar() {
		return avatar;
	}

	/**
	 * Javadoc needed.
	 *
	 */
	public void setAvatar(ImageIcon avatar) {
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", uuid=" + uuid + "]";
	}
	
}
