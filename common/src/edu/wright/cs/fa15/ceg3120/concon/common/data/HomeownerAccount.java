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

import java.lang.reflect.Method;

/**
 * This class will house any homeowner specific data fields.  It also launches
 * the homeowner UI.
 * 
 * @author Quack
 *
 */
public class HomeownerAccount extends UserAccount {

	/**
	 * Creates a new instance of <code>HomeownerAccount</code>.
	 */
	public HomeownerAccount() {
		super(AccountType.HOMEOWNER);

	}

	@Override
	public void launchGui() {
		//(new CustomerClient()).buildGui();
		try {
			Class<?> homeowner = 
					Class.forName("edu.wright.cs.fa15.ceg3120.concon"
							+ ".client.customer.CustomerClient");
			Method meth = homeowner.getMethod("buildGui", this.getClass());
			meth.invoke(homeowner.newInstance(), this);
		} catch (RuntimeException e) { 
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}