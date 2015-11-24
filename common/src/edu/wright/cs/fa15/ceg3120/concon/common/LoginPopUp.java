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

import edu.wright.cs.fa15.ceg3120.concon.common.data.RequestType;
import edu.wright.cs.fa15.ceg3120.concon.common.data.UserAccount;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 * This is the main launch point for the UIs.  It is responsible for creating
 * the unified login window, interfacing with the net-stack, and launching the
 * UI corresponding the account type of the user once verified at the database
 * level.
 * 
 * @author Paul Quackenbush
 *
 */
public class LoginPopUp implements Serializable{
	private static final long serialVersionUID = 1L;
	private UserAccount user;
	private static ArrayBlockingQueue<UserAccount> incoming = new ArrayBlockingQueue<>(3);

	private JButton loginButton;
	private JButton btnCreateAccount;
	private transient SpringLayout currentLayout;
	private JTextField uuidField;
	private JPasswordField passwordField;
	private Resources imageResources;
	private static final String ICON_IMG = "icon.png";
	
	/**
	 * Creates a new instance of <code>LogininPopUp</code>.
	 */
	public LoginPopUp() {
		user = null;
		loginButton = new JButton();
		btnCreateAccount = new JButton();
		uuidField = new JTextField();
		passwordField = new JPasswordField();
		imageResources = new Resources();
	}

	/**
	 * temp.
	 */
	private void buildGui() {
		final JFrame loginFrame = new StringFrame(this);
		loginFrame.setSize(500, 300);
		loginFrame.setLocationRelativeTo(null);
		uuidField.requestFocus();
		
		loginFrame.setIconImage(imageResources.getImage(ICON_IMG ).getImage());
		
		loginFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		loginFrame.addWindowListener(new MyWindowAdapter(user));

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
						launchNewAccountGui();
						loginButton.setEnabled(true);
						btnCreateAccount.setEnabled(true);
					}
				});
				
			}
		});

		/*
		 * need action listener for login button that will block until we receive a response from
		 * Networking so user can be set properly. Preferably a blocking mechanism that will timeout
		 * when we want it to.
		 */
		loginButton.addActionListener(new LoginListener(loginFrame));
		uuidField.addKeyListener(new LoginListener(loginFrame));
		passwordField.addKeyListener(new LoginListener(loginFrame));

	}// end buildGui

	/**
	 * Use this method to pass data to the UserAccount queue.
	 * <p>
	 * More description to come...
	 * </p>
	 * 
	 * @param user (UserAccount sub-class)
	 * 
	 * @return true if the item was successfully inserted
	 * 
	 * @throws InterruptedException
	 *			 thrown if interrupted...
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
		// TODO do more stuffs? maybe/ maybe not
		
	}// end launchNewAccountGUI

	/**
	 * Creates the text field panel for the UI.
	 * 
	 * @return Fully constructed text field panel
	 */
	public FieldPanel createFieldPanel() {
		return new FieldPanel();
	}
	
	/**
	 * Makes findBugs quiet...
	 */
	public void readObject() { // XXX
		currentLayout = new SpringLayout();
	}
	
	/**
	 * Entry point for the main unit.
	 * 
	 * @param args Command line arguments
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
	
	/**
	 * Listener for the login functionality.
	 * 
	 * @author Quack
	 *
	 */
	private class LoginListener extends KeyAdapter implements ActionListener{
		JFrame loginFrame;
		
		/**
		 * Creates a new instance of <code>LoginListener</code>.
		 * @param frame JFrame
		 */
		public LoginListener(JFrame frame) {
			loginFrame = frame;
		}
		
		@Override
		public void keyPressed(KeyEvent ev) {
			int keyPress = ev.getKeyCode();
			if (keyPress == KeyEvent.VK_ENTER) {
				actionPerformed(null);
			}
		}

		@Override
		public void actionPerformed(ActionEvent ev) {
			if (verifyFields()) {
				// user has been set
				// blah blah... shipped user to network, reset user to null
				loginButton.setEnabled(false);
				btnCreateAccount.setEnabled(false);
				
				/* Add invocation of ArrayBlockingQueue.poll(long, TimeUnit)
				 * to the end of the EDT execution queue to ensure a "happens
				 * after" relationship with the JButton.setEnabled(boolean)
				 * calls. 
				 */
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						try {
							//this needs to come out
							(new CreateNewAccount()).buildGui();
							// remove above
							user = incoming.poll(5, TimeUnit.SECONDS);
						} catch (InterruptedException e) {
							e.printStackTrace();
							JOptionPane.showConfirmDialog(null,
									"The program experienced an internal error."
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
								//user = new ServerAdminAccount();
								if (user.getClass().equals(UserAccount.class)) {
									JOptionPane.showMessageDialog(null,
											"Database Response:\n   " 
													+ (user.getdbResponse() == null 
													? "ERROR" : user.getdbResponse()),
											"Error", JOptionPane.ERROR_MESSAGE);
									loginButton.setEnabled(true);
									btnCreateAccount.setEnabled(true);
								} else {
									user.launchGui();
								}
							} else {
								JOptionPane.showMessageDialog(null,
										"Your request timed out."
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
		
		/**
		 * Verifies that the user has supplied input.
		 * @return true iff all fields have been filled
		 */
		public boolean verifyFields() {
			String uuid = uuidField.getText();
			if (uuid.length() > 0) {
				if (passwordField.getPassword().length > 0) {
					// XXX encrypt pswd before creating new UserAccount
					user = new UserAccount(uuid, null, passwordField.getPassword(),
							RequestType.LOOK_UP);
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
		}//end verifyFields
	}//end LoginListener
	
	/**
	 * temp.
	 * @author Quack
	 *
	 */
	private class MyWindowAdapter extends WindowAdapter{
		//private UserAccount user;
		
		/**
		 * Creates a new instance of <code>MyWindowAdapter</code>.
		 * 
		 * @param user the user
		 */
		public MyWindowAdapter(UserAccount user) {
			//this.user = user;
		}
		
		@Override
		public void windowClosing(WindowEvent ev) {
				// release any network/file resources
			if (user != null) {
				if (user.getPswd() != null) {
					char[] overwrite = new char[user.getPswd().length];
					for (int i = 0; i < overwrite.length; ++i) {
						overwrite[i] = '\0';
					}
					user.setPswd(overwrite);
					System.out.println("overwrite:" + Arrays.toString(user.getPswd()));
				}
			} // end if(user != null)
			System.exit(0);
		}
	}//end MyWindowAdapter

/*############################################################################*/
/*############################################################################*/
/*############################################################################*/

	/**
	 * TODO Explain.
	 * 
	 * @author Corey Miller
	 *
	 */
	public static class StringFrame extends JFrame {
		private static final long serialVersionUID = 1L;
		private FieldPanel currentPanel;
		private LoginPopUp popup;
		
		/**
		 * Creates a new instance of <code>StringFrame</code>.
		 */
		public StringFrame(LoginPopUp popUp) {
			super("Login");
			this.popup = popUp;
			currentPanel = popup.createFieldPanel();
			setupFrame();

		}

		/**
		 * Retrieve the content pane from {@code currentPanel}.
		 */
		private void setupFrame() {
			this.setContentPane(currentPanel);
		}

	}
	
	/**
	 * JPanel containing the login text fields.
	 * 
	 * @author Corey Miller
	 */
	public class FieldPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		ImageIcon img;
		
		/**
		 * Creates a new instance of <code>FieldPanel</code>.
		 */
		public FieldPanel() {
			setBackground(Color.ORANGE);
			loginButton = new JButton("Login");
			currentLayout = new SpringLayout();

			try {
				img = imageResources.getImage("ceg3120_logos.png");
			} catch (Exception e) {
				e.printStackTrace();
				/*handled in paint()*/
			}
			
			setupPanel();
		}
		
		@Override
		public void paint(Graphics graphics) {
			
			super.paint(graphics);
			if (img != null) {
				graphics.drawImage(img.getImage(), 
						this.getWidth() - 235, 
						this.getHeight() - 290, 
						300, 
						300,
						this
				);
			} else {
				graphics.drawString("No image", 400, 200);
			} 
			
		} //end paint 

		/**
		 * Generate the panel.
		 */
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
	} //ends FieldPanel
}//end LoginPopUp
