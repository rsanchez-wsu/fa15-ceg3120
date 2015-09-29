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

package edu.wright.cs.fa15.ceg3120.concon.common;

import edu.wright.cs.fa15.ceg3120.concon.common.data.HomeOwnerAccount;
import edu.wright.cs.fa15.ceg3120.concon.common.data.UserAccount;

import javax.swing.JFrame;

public class CreateNewAccount {

    /**
     * temp comment.
     * 
     * @return nothing yet
     */
    public UserAccount buildGui() {
        JFrame newAccountFrame = new JFrame("Create New Account");
        // build UI

        newAccountFrame.setVisible(true);

        try { //This is solely for functionality testings
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        newAccountFrame.dispose();
        try {
            LoginPopUp.addUserToQueue(new HomeOwnerAccount());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // returns a subclass of UserAccount from input
        // UserAccount toRet = new HomeOwnerAccount(),
        // UserAccount toRet = new ContractorAccount(),
        // etc
        return null;
    }
}
