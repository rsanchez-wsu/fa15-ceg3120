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

import edu.wright.cs.fa15.ceg3120.concon.common.data.UserAccount;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class LoginPopUp {

    private UserAccount user;
    private static ArrayBlockingQueue<UserAccount> incoming;

    /**
     * Creates a new instance of <code>LogininPopUp</code>.
     */
    public LoginPopUp() {
        user = null;
        incoming = new ArrayBlockingQueue<>(3);
    }

    /**
     * temp.
     */
    private void buildGui() {
        final JFrame loginFrame = new JFrame("Login");
        loginFrame.setSize(200, 100);
        // TODO Auto-generated method stub
        // Build login UI here

        // This is just me testing a few things. Feel free to overwrite it :)
        loginFrame.setLayout(new GridLayout(1, 2));
        final JButton loginButton = new JButton("Login");
        loginFrame.add(loginButton);

        final JButton createNewButton = new JButton("Create New Account");
        loginFrame.add(createNewButton);
        // ends Paul's playground

        loginFrame.setVisible(true);

        // if new account link/button clicked
        createNewButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ev) {
                loginFrame.setFocusable(false);
                launchNewAccountGui();// set focusable not doing what i want <_<
                loginFrame.setFocusable(true);
            }
        });

        /*
         * need action listener for login button that will block until we receive a response from
         * Networking so user can be set properly. Preferably a blocking mechanism that will timeout
         * when we want it to.
         */
        loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ev) {

                // blah blah... shipped user to network, reset user to null
                try {
                    loginButton.setEnabled(false);
                    createNewButton.setEnabled(false);
                    user = incoming.poll(5, TimeUnit.SECONDS);
                } catch (InterruptedException e1) {
                    JOptionPane.showConfirmDialog(null,
                            "There was an issue with your request" + "\nPlease try agian...",
                            "Error", JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE);
                } finally {
                    if (user != null) {
                        /*
                         * Schedule the loginFrame to be disposed on the EDT before launching the
                         * new GUI.
                         */
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                loginFrame.dispose();
                            }
                        });
                        user.launchGui();
                    } else {
                        JOptionPane.showConfirmDialog(null,
                                "There was an issue with your request" + "\nPlease try agian...",
                                "Error", JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE);
                        loginButton.setEnabled(true);
                        createNewButton.setEnabled(true);
                    }
                }
            }// end actionPerformed
        });

    }// end buildGui

    /**
     * Use this method to pass data to the UserAccount queue.
     * <p>
     * More description to come...
     * </p>
     * 
     * @param user
     *            (UserAccount sub-class)
     * @return true if the item was successfully inserted
     * @throws InterruptedException
     *             thrown if interrupted...
     */
    public static boolean addUserToQueue(UserAccount user) throws InterruptedException {
        System.out.println("added user to queue.");
        return incoming.offer(user, 1, TimeUnit.SECONDS);
    }

    /**
     * Launches the Create New User GUI and renders the login window unresponsive until
     * CreateNewAccountGUI.buildGUI returns. At least it would in theory...
     */
    private void launchNewAccountGui() {
        (new CreateNewAccount()).buildGui();
        try {
            user = incoming.poll(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Reenabling buttons...");

    }// end launchNewAccountGUI

    /**
     * Entry point for the main unit.
     * 
     * @param args
     *            - Command line arguments
     */
    public static void main(String[] args) {
        // Schedules the GUI construction on the EDT
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                (new LoginPopUp()).buildGui();
            }
        });

    }

}
