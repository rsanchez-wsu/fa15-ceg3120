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

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;

public class LoginPopUp {

    private UserAccount user;
    private static ArrayBlockingQueue<UserAccount> incoming;

    private JButton loginButton;
    private JButton btnCreateAccount;
    private SpringLayout currentLayout;
    private JTextField uuidField;
    private JPasswordField passwordField;
    
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
        final JFrame loginFrame = new StringFrame();
        loginFrame.setSize(500, 300);
        uuidField.requestFocus();

        loginFrame.setVisible(true);

        // if new account link/button clicked
        btnCreateAccount.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ev) {
                loginButton.setEnabled(false);
                btnCreateAccount.setEnabled(false);
                SwingUtilities.invokeLater(new Runnable() {
                    
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        launchNewAccountGui();// set focusable not doing what i want <_<
                    }
                });
                loginButton.setEnabled(false);
                btnCreateAccount.setEnabled(false);
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
                if (verifyFields()) {
                    // user has been set
                    // blah blah... shipped user to network, reset user to null
                    loginButton.setEnabled(false);
                    btnCreateAccount.setEnabled(false);
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                //this needs to come out
                                (new CreateNewAccount()).buildGui();
                                // remove above
                                user = incoming.poll(5, TimeUnit.SECONDS);
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                                JOptionPane.showConfirmDialog(null,
                                        "There was an issue with your request"
                                        + "\nPlease try again...",
                                        "Error", JOptionPane.OK_OPTION,
                                        JOptionPane.ERROR_MESSAGE);
                            } finally {
                                System.out.println(user + " test");
                                if (user != null) {
                                    /*
                                     * Schedule the loginFrame to be disposed on the EDT before
                                     * launching the new GUI.
                                     */
                                    SwingUtilities.invokeLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            loginFrame.dispose();
                                        }
                                    });
                                    user.launchGui();
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                            "There was an issue with your request"
                                            + "\nPlease try again...",
                                            "Error", JOptionPane.ERROR_MESSAGE);
                                    loginButton.setEnabled(true);
                                    btnCreateAccount.setEnabled(true);
                                }
                            } //end try/catch/finally
                        } //end run
                    });

                }
            }// end actionPerformed
            
            public boolean verifyFields() {
                String uuid = uuidField.getText();
                if (uuid.length() > 0) {
                    if (passwordField.getPassword().length > 0) {
                        user = new UserAccount(uuid, null, passwordField.getPassword());
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "The password field is blank." + "\nPlease try agian...",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(null,
                            "The Username field is blank.\nPlease try agian...",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                return true;
            }
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

    @SuppressWarnings("serial")
    public class StringFrame extends JFrame {
        private FieldPanel currentPanel;

        /**
         * Creates a new instance of <code>StringFrame</code>.
         */
        public StringFrame() {
            super("Login");
            currentPanel = new FieldPanel();

            setupFrame();

        }

        private void setupFrame() {
            this.setContentPane(currentPanel);

        }

    }
    
    @SuppressWarnings("serial")
    public class FieldPanel extends JPanel {

        /**
         * Creates a new instance of <code>FieldPanel</code>.
         */
        public FieldPanel() {
            setBackground(Color.ORANGE);
            loginButton = new JButton("Login");
            loginButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                }
            });
            currentLayout = new SpringLayout();

            setupPanel();
        }

        private void setupPanel() {
            this.setLayout(currentLayout);
            this.add(loginButton);

            btnCreateAccount = new JButton("Create Account");
            currentLayout.putConstraint(SpringLayout.SOUTH, btnCreateAccount, -10,
                    SpringLayout.SOUTH, this);
            currentLayout.putConstraint(SpringLayout.EAST, btnCreateAccount, -10, SpringLayout.EAST,
                    this);
            add(btnCreateAccount);

            JLabel lblHomeOwnerLogin = new JLabel("Contractor App Login ");
            currentLayout.putConstraint(SpringLayout.NORTH, lblHomeOwnerLogin, 32,
                    SpringLayout.NORTH, this);
            currentLayout.putConstraint(SpringLayout.WEST, lblHomeOwnerLogin, 98, SpringLayout.WEST,
                    this);
            currentLayout.putConstraint(SpringLayout.EAST, lblHomeOwnerLogin, -144,
                    SpringLayout.EAST, this);
            lblHomeOwnerLogin.setForeground(new Color(0, 0, 0));
            lblHomeOwnerLogin.setFont(new Font("Times New Roman", Font.BOLD, 19));
            add(lblHomeOwnerLogin);

            uuidField = new JTextField();
            currentLayout.putConstraint(SpringLayout.SOUTH, lblHomeOwnerLogin, -34,
                    SpringLayout.NORTH, uuidField);
            currentLayout.putConstraint(SpringLayout.EAST, loginButton, 0, SpringLayout.EAST,
                    uuidField);
            currentLayout.putConstraint(SpringLayout.WEST, uuidField, 125, SpringLayout.WEST, this);
            currentLayout.putConstraint(SpringLayout.EAST, uuidField, -181, SpringLayout.EAST,
                    this);
            currentLayout.putConstraint(SpringLayout.SOUTH, uuidField, -156, SpringLayout.SOUTH,
                    this);
            add(uuidField);
            uuidField.setColumns(10);

            passwordField = new JPasswordField();
            currentLayout.putConstraint(SpringLayout.NORTH, loginButton, 6, SpringLayout.SOUTH,
                    passwordField);
            currentLayout.putConstraint(SpringLayout.NORTH, passwordField, 6, SpringLayout.SOUTH,
                    uuidField);
            currentLayout.putConstraint(SpringLayout.WEST, passwordField, 0, SpringLayout.WEST,
                    uuidField);
            currentLayout.putConstraint(SpringLayout.SOUTH, passwordField, 49, SpringLayout.NORTH,
                    uuidField);
            currentLayout.putConstraint(SpringLayout.EAST, passwordField, -181, SpringLayout.EAST,
                    this);
            passwordField.setBackground(Color.WHITE);
            passwordField.setToolTipText("");
            add(passwordField);

            JLabel lblAccountName = new JLabel("Account Name ");
            currentLayout.putConstraint(SpringLayout.NORTH, lblAccountName, 3, SpringLayout.NORTH,
                    uuidField);
            currentLayout.putConstraint(SpringLayout.EAST, lblAccountName, -6, SpringLayout.WEST,
                    uuidField);
            lblAccountName.setForeground(Color.BLACK);
            lblAccountName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
            add(lblAccountName);

            JLabel lblPassword = new JLabel("Password");
            currentLayout.putConstraint(SpringLayout.SOUTH, lblPassword, 0, SpringLayout.SOUTH,
                    passwordField);
            currentLayout.putConstraint(SpringLayout.EAST, lblPassword, -6, SpringLayout.WEST,
                    passwordField);
            lblPassword.setForeground(Color.BLACK);
            lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 12));
            add(lblPassword);
        }
    }
}
