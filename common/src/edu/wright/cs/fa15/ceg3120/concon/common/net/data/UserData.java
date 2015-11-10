<<<<<<< HEAD
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


import javax.swing.ImageIcon;

/**
 * Holds basic user data.
 * 
 * @author NathanJent
 *
 */
public class UserData implements NetworkData {

	private static final long serialVersionUID = -1804728648292102844L;
	
	private String firstName;
	private String lastName;
	private String uuid;
	private ImageIcon  avatar;

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public ImageIcon getAvatar() {
		return avatar;
	}

	public void setAvatar(ImageIcon avatar) {
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", uuid=" + uuid + "]";
	}
	
}
=======
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
	 * UserData for passing user account information over network.
	 * Default Constructor for JavaBeans.
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
	 * Get firstName.
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Set firstName.
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Get lastName.
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Set lastName.
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Get uuid.
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * Set uuid.
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * Get avatar.
	 * @return the avatar
	 */
	public ImageIcon getAvatar() {
		return avatar;
	}

	/**
	 * Set avatar.
	 * @param avatar the avatar to set
	 */
	public void setAvatar(ImageIcon avatar) {
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", uuid=" + uuid + "]";
	}
	
}
>>>>>>> master
