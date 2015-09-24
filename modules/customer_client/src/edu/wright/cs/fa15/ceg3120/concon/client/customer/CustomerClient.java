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

package edu.wright.cs.fa15.ceg3120.concon.client.customer;

import java.awt.Toolkit;
import javax.swing.JFrame;

import edu.wright.cs.fa15.ceg3120.concon.common.data.HomeOwnerAccount;

public class CustomerClient{

    private static final int WINDOW_WIDTH =
            Toolkit.getDefaultToolkit().getScreenSize().width - 150;
    private static final int WINDOW_HEIGHT =
            Toolkit.getDefaultToolkit().getScreenSize().height - 150;
    
    public void buildGui() {
        JFrame mainFrame = new JFrame("TEMP TITLE");
        mainFrame.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        
        //build UI here
        
        mainFrame.setVisible(true);
    }
    
    //we probably don't need a main if this is launched from LogininPopUp...
    public static void main(String[] args) {
        HomeOwnerAccount justToRemoveWarningForNow = new HomeOwnerAccount();
        System.out.println(justToRemoveWarningForNow.getAccountType());
    }
}