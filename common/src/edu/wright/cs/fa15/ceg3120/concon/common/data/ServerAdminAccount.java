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
 * ServerAdminAccount holds user data for an admin-type user.
 *
 * @author Quack
 *
 */
public class ServerAdminAccount extends UserAccount implements DatabaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * Construct a new server admin account.
	 */
	public ServerAdminAccount() {
		super(AccountType.SERVER_ADMIN);
	}

	@Override
	public void launchGui() {

	}

}
