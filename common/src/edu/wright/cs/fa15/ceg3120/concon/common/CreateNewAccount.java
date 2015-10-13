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

import edu.wright.cs.fa15.ceg3120.concon.common.data.HomeownerAccount;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Used to create a new user account and pass it to the login window.
 * 
 * @author Paul Quackenbush
 *
 */
public class CreateNewAccount {

    private JFrame newAccountFrame;
    private JPanel centers;
    private JComboBox<String> myBox;
    
    /**
     * Construct a new CreateNewAccount window.
     */
    public CreateNewAccount() {
        newAccountFrame = new JFrame();
        centers = new JPanel();
    }
    
    /**
     * Entry point. Testing purposes only.
     * @param args Arguments
     */
    public static void main(String[] args) {
        new CreateNewAccount().buildGui();
    }
    /**
     * temp comment.
     * 
     * @return nothing yet
     */
    public boolean buildGui() {
        newAccountFrame = new JFrame("Create New Account");
        // build UI
        newAccountFrame.setSize(300, 300);
        newAccountFrame.setLocationRelativeTo(null);
        newAccountFrame.setLayout(new BorderLayout());
        
        String[] forCombo = {"Homeowner Account", "Contractor Account", "Server Admin"};
        
        Container norths = new Container();
        norths.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JLabel boxLabel = new JLabel("Account Type");
        myBox = new JComboBox<>(forCombo);
        norths.add(boxLabel);
        norths.add(myBox);
        
        myBox.addActionListener(new ComboListener(this));
        
        
        centers = new NewHomeownerPane();
        
        Container subCont = new Container();
        subCont.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton submit = new JButton("Submit");
        subCont.add(submit);
        
        newAccountFrame.add(norths, BorderLayout.NORTH);
        newAccountFrame.add(centers, BorderLayout.CENTER);
        newAccountFrame.add(subCont, BorderLayout.SOUTH);
        
        newAccountFrame.setVisible(true);

        // This is solely for functionality testings
//        SwingUtilities.invokeLater(new Runnable() {
//            
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(2000);
//                    newAccountFrame.dispose();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });

        try {
            LoginPopUp.addUserToQueue(new HomeownerAccount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } //end functionality test stuffs
        
        
        return true;
    }

    /**
     * This listener will ensure that the pane required to build each account
     * type is displayed when selected in the JComboBox.
     * <p>Requires a reference to CreateNewAccount.  Must also be a static
     * inner class. Thanks for not allowing anon classes findbugs...</p>
     * 
     * @author Quack
     * @since 10/08/2015
     */
    static class ComboListener implements ActionListener {
        private CreateNewAccount window;
        
        /**
         * Create a new ComboListener for this frame.
         * @param window Frame to apply to.
         */
        public ComboListener(CreateNewAccount window) {
            super();
            this.window = window;
        }
        
        @Override
        public void actionPerformed(ActionEvent ev) {
            int selected = window.myBox.getSelectedIndex();
            
            if (selected == 0 && !(window.centers instanceof NewHomeownerPane)) {
                window.newAccountFrame.remove(window.centers);
                window.centers = new NewHomeownerPane();
                window.newAccountFrame.add(window.centers, BorderLayout.CENTER);
                window.newAccountFrame.validate();
                System.out.println("new HomeownerPane created and added");
            } else if (selected == 1 && !(window.centers instanceof NewContractorPane)) {
                window.newAccountFrame.remove(window.centers);
                window.centers = new NewContractorPane();
                window.newAccountFrame.add(window.centers, BorderLayout.CENTER);
                window.newAccountFrame.validate();
                System.out.println("new NewContractorPane created and added");
            } else if (selected == 2 && !(window.centers instanceof NewServerAdminPane)) {
                window.newAccountFrame.remove(window.centers);
                window.centers = new NewServerAdminPane();
                window.newAccountFrame.add(window.centers, BorderLayout.CENTER);
                window.newAccountFrame.validate();
                System.out.println("new NewServerAdmin created and added");
            }
        }//end actionPerformed
    }//end ComboListener
}//end CreateNewAccount
