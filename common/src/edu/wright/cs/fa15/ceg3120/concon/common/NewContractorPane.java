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

import edu.wright.cs.fa15.ceg3120.concon.common.data.ContractorAccount;
import edu.wright.cs.fa15.ceg3120.concon.common.data.UserAccount;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Arrays;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.MaskFormatter;

//import com.google.common.collect.ImmutableList;

/**
 * temp.
 * @author Quack
 *
 */
public class NewContractorPane extends JPanel {
	private static final long serialVersionUID = 1L;
	private ContractorAccount user;
	private static JLabel lblShowCurUuid = new JLabel();
	private static JLabel lblShowCurPassword = new JLabel();
	private static JLabel lblShowCurLastName = new JLabel();
	private static JLabel lblShowCurFirstName = new JLabel();
	private static JLabel lblShowCurCompanyName = new JLabel();
	private static JLabel lblShowCurAddress1 = new JLabel();
	private static JLabel lblShowCurAddress2 = new JLabel();
	private static JLabel lblShowCurCity = new JLabel();
	private static JLabel lblShowCurState = new JLabel();
	private static JLabel lblShowCurZipCode = new JLabel();
	private static JLabel lblShowCurPhoneNumber = new JLabel();
	private static JLabel lblShowCurEmailAddress = new JLabel();
	private static final JTextField txtUuidUpdate = new JTextField();
	private static final JPasswordField txtPassword1Update = new JPasswordField();
	private static final JPasswordField txtPassword2Update = new JPasswordField();
	private static final JTextField txtLastNameUpdate = new JTextField();
	private static final JTextField txtFirstNameUpdate = new JTextField();
	private static final JTextField txtCompanyNameUpdate = new JTextField();
	private static final JTextField txtAddress1Update = new JTextField();
	private static final JTextField txtAddress2Update = new JTextField();
	private static final JTextField txtCityUpdate = new JTextField();
	private static final JFormattedTextField txtZipCodeUpdate = new JFormattedTextField(
			createFormatter("#####"));
	private static final JFormattedTextField txtPhoneNumberUpdate = new JFormattedTextField(
			createFormatter("###-###-####"));
	private static final JFormattedTextField txtEmailAddressUpdate = new JFormattedTextField();
	private static final JLabel lblNewProfile = new JLabel("Update Profile Settings:");
	private static final JLabel lblNewUuid = new JLabel("Username: ");
	private static final JLabel lblNewPassword1 = new JLabel("Password: ");
	private static final JLabel lblNewPassword2 = new JLabel("Confirm Password: ");
	private static final JLabel lblNewFirstName = new JLabel("First Name: ");
	private static final JLabel lblNewLastName = new JLabel("Last Name: ");
	private static final JLabel lblNewCompanyName = new JLabel("Company Name: ");
	private static final JLabel lblNewAddress1 = new JLabel("Address: ");
	private static final JLabel lblNewAddress2 = new JLabel("Address (cont): ");
	private static final JLabel lblNewCity = new JLabel("City: ");
	private static final JLabel lblNewState = new JLabel("State: ");
	private static final JLabel lblNewZipCode = new JLabel("ZIP Code: ");
	private static final JLabel lblNewPhoneNumber = new JLabel("Phone Number: ");
	private static final JLabel lblNewEmailAddress = new JLabel("Email Address: ");
	
	private static final String[] states = 
	{ "NONE", "AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "IA", 
			"ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", 
			"MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", 
			"RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY"};
//	private static final ImmutableList<String> states1 = ImmutableList.of(
//			"NONE", "AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "IA", 
//			"ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", 
//			"MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", 
//			"RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY"
//			);
	private static final JComboBox<String> cboStateUpdate = new JComboBox<String>(states);

	/**
	 * Creates a new instance of <code>NewContratorPane</code>.
	 */
	public NewContractorPane(ContractorAccount user) {
		super(new BorderLayout());
		this.user = user;
		addContainers();
	}
	
	/**
	 * Adds current profile information and user input fields.
	 */
	private void addContainers() {
		add(addTextFields());
	}
	
	/**
	 * Constructs the Container holding all the label and user input fields.
	 * 
	 * @return a Container holding all the user input fields
	 */
	private Container addTextFields() {
		Container cont = new Container();
		cont.setLayout(null);
		final JLabel lblCurProfile = new JLabel("Current Profile Settings:");
		lblCurProfile.setBounds(30, 5, 200, 20);
		
		final JLabel lblUuid = new JLabel("Username: ");
		lblUuid.setBounds(15, 35, 120, 20);
		
		lblShowCurUuid.setText((user == null) ? "" : user.getUuid());
		lblShowCurUuid.setBounds(145, 35, 200, 20);
		
		final JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setBounds(15, 55, 120, 20);
		
		lblShowCurPassword.setText((user == null) ? "" 
				: Arrays.toString(user.getPswd()));
		lblShowCurPassword.setBounds(145, 55, 200, 20);

		final JLabel lblFirstName = new JLabel("First Name: ");
		lblFirstName.setBounds(15, 95, 120, 20);

		lblShowCurFirstName.setText((user == null) ? "" : user.getFirstName());
		lblShowCurFirstName.setBounds(145, 95, 200, 20);
		
		final JLabel lblLastName = new JLabel("Last Name: ");
		lblLastName.setBounds(15, 115, 120, 20);
		
		lblShowCurLastName.setText((user == null) ? "" : user.getLastName());
		lblShowCurLastName.setBounds(145, 115, 200, 20);
		
		final JLabel lblCompanyName = new JLabel("Company Name: ");
		lblCompanyName.setBounds(15, 135, 120, 20);
		
		lblShowCurCompanyName.setText((user == null) ? "" : user.getCompanyName());
		lblShowCurCompanyName.setBounds(145, 135, 200, 20);
		
		final JLabel lblAddress1 = new JLabel("Address: ");
		lblAddress1.setBounds(15, 155, 120, 20);
		
		lblShowCurAddress1.setText((user == null) ? "" : user.getAddress1());
		lblShowCurAddress1.setBounds(145, 155, 200, 20);
		
		final JLabel lblAddress2 = new JLabel("Address: ");
		lblAddress2.setBounds(15, 175, 120, 20);
		
		lblShowCurAddress2.setText((user == null) ? "" : user.getAddress2());
		lblShowCurAddress2.setBounds(145, 175, 200, 20);
		
		final JLabel lblCity = new JLabel("City: ");
		lblCity.setBounds(15, 195, 120, 20);
		
		lblShowCurCity.setText((user == null) ? "" : user.getCity());
		lblShowCurCity.setBounds(145, 195, 200, 20);
		
		final JLabel lblState = new JLabel("State: ");
		lblState.setBounds(15, 215, 120, 20);
		
		lblShowCurState.setText((user == null) ? "" : user.getState());
		lblShowCurState.setBounds(145, 215, 200, 20);
		
		final JLabel lblZipCode = new JLabel("ZIP Code: ");
		lblZipCode.setBounds(15, 235, 120, 20);
		
		lblShowCurZipCode.setText((user == null) ? "" : user.getZipCode());
		lblShowCurZipCode.setBounds(145, 235, 200, 20);
		
		final JLabel lblPhoneNumber = new JLabel("Phone Number: ");
		lblPhoneNumber.setBounds(15, 255, 120, 20);
		
		lblShowCurPhoneNumber.setText((user == null) ? "" : user.getPhoneNumber());
		lblShowCurPhoneNumber.setBounds(145, 255, 200, 20);
		
		final JLabel lblEmailAddress = new JLabel("Email Address: ");
		lblEmailAddress.setBounds(15, 275, 120, 20);
		
		lblShowCurEmailAddress.setText((user == null) ? "" : user.getEmailAddress());
		lblShowCurEmailAddress.setBounds(145, 275, 200, 20);
		
		lblNewProfile.setBounds(460, 5, 200, 20);
		lblNewProfile.setVisible(false);
		
		lblNewUuid.setBounds(445, 35, 120, 20);
		lblNewUuid.setVisible(false);
		
		txtUuidUpdate.setText((user == null) ? "" : user.getUuid());
		txtUuidUpdate.setBounds(575, 35, 200, 20);
		txtUuidUpdate.setVisible(false);
		
		lblNewPassword1.setBounds(445, 55, 120, 20);
		lblNewPassword1.setVisible(false);
		
		txtPassword1Update.setText((user == null) ? "" 
				: Arrays.toString(user.getPswd()));
		txtPassword1Update.setBounds(575, 55, 200, 20);
		txtPassword1Update.setVisible(false);
		
		lblNewPassword2.setBounds(445, 75, 120, 20);
		lblNewPassword2.setVisible(false);
		
		txtPassword2Update.setText((user == null) ? "" 
				: Arrays.toString(user.getPswd()));
		txtPassword2Update.setBounds(575, 75, 200, 20);
		txtPassword2Update.setVisible(false);
		
		lblNewFirstName.setBounds(445, 95, 120, 20);
		lblNewFirstName.setVisible(false);
		
		txtFirstNameUpdate.setText((user == null) ? "" : user.getFirstName());
		txtFirstNameUpdate.setBounds(575, 95, 200, 20);
		txtFirstNameUpdate.setVisible(false);
		
		lblNewLastName.setBounds(445, 115, 120, 20);
		lblNewLastName.setVisible(false);
		
		txtLastNameUpdate.setText((user == null) ? "" : user.getLastName());
		txtLastNameUpdate.setBounds(575, 115, 200, 20);
		txtLastNameUpdate.setVisible(false);
		
		lblNewCompanyName.setBounds(445, 135, 120, 20);
		lblNewCompanyName.setVisible(false);
		
		txtCompanyNameUpdate.setText((user == null) ? "" : user.getCompanyName());
		txtCompanyNameUpdate.setBounds(575, 135, 200, 20);
		txtCompanyNameUpdate.setVisible(false);
		
		lblNewAddress1.setBounds(445, 155, 120, 20);
		lblNewAddress1.setVisible(false);
		
		txtAddress1Update.setText((user == null) ? "" : user.getAddress1());
		txtAddress1Update.setBounds(575, 155, 200, 20);
		txtAddress1Update.setVisible(false);
		
		lblNewAddress2.setBounds(445, 175, 120, 20);
		lblNewAddress2.setVisible(false);
		
		txtAddress2Update.setText((user == null) ? "" : user.getAddress2());
		txtAddress2Update.setBounds(575, 175, 200, 20);
		txtAddress2Update.setVisible(false);
		
		lblNewCity.setBounds(445, 195, 120, 20);
		lblNewCity.setVisible(false);
		
		txtCityUpdate.setText((user == null) ? "" : user.getCity());
		txtCityUpdate.setBounds(575, 195, 200, 20);
		txtCityUpdate.setVisible(false);
		
		lblNewState.setBounds(445, 215, 120, 20);
		lblNewState.setVisible(false);

		cboStateUpdate.setBounds(575, 215, 200, 20);
		cboStateUpdate.setVisible(false);
		if (user != null) {
			String userState = user.getState();
			for (int i = 0; i < states.length; ++i) {
				if (states[i].equalsIgnoreCase(userState)) {
					cboStateUpdate.setSelectedIndex(i);
					break;
				}
			}
		}

		lblNewZipCode.setBounds(445, 235, 120, 20);
		lblNewZipCode.setVisible(false);

		txtZipCodeUpdate.addFocusListener(new MyTextFocusListener(txtZipCodeUpdate));
		txtZipCodeUpdate.setText((user == null) ? "" : user.getZipCode());
		txtZipCodeUpdate.setBounds(575, 235, 200, 20);
		txtZipCodeUpdate.setVisible(false);
		
		lblNewPhoneNumber.setBounds(445, 255, 120, 20);
		lblNewPhoneNumber.setVisible(false);
		
		txtPhoneNumberUpdate.addFocusListener(new MyTextFocusListener(txtPhoneNumberUpdate));
		txtPhoneNumberUpdate.setText((user == null) ? "" : user.getPhoneNumber());
		txtPhoneNumberUpdate.setBounds(575, 255, 200, 20);
		txtPhoneNumberUpdate.setVisible(false);
		
		lblNewEmailAddress.setBounds(445, 275, 200, 20);
		lblNewEmailAddress.setVisible(false);
		
		((AbstractDocument)txtEmailAddressUpdate.getDocument()).setDocumentFilter(
				new DocumentEmailFilter());
		txtEmailAddressUpdate.setName("email");
		txtEmailAddressUpdate.addFocusListener(new MyTextFocusListener(txtEmailAddressUpdate));
		txtEmailAddressUpdate.setText((user == null) ? "" : user.getEmailAddress());
		txtEmailAddressUpdate.setBounds(575, 275, 200, 20);
		txtEmailAddressUpdate.setVisible(false);
		
		cont.add(lblCurProfile);
		cont.add(lblUuid);
		cont.add(lblShowCurUuid);
		cont.add(lblPassword);
		cont.add(lblShowCurPassword);
		cont.add(lblFirstName);
		cont.add(lblShowCurFirstName);
		cont.add(lblLastName);
		cont.add(lblShowCurLastName);
		cont.add(lblCompanyName);
		cont.add(lblShowCurCompanyName);
		cont.add(lblAddress1);
		cont.add(lblShowCurAddress1);
		cont.add(lblAddress2);
		cont.add(lblShowCurAddress2);
		cont.add(lblCity);
		cont.add(lblShowCurCity);
		cont.add(lblState);
		cont.add(lblShowCurState);
		cont.add(lblZipCode);
		cont.add(lblShowCurZipCode);
		cont.add(lblPhoneNumber);
		cont.add(lblShowCurPhoneNumber);
		cont.add(lblEmailAddress);
		cont.add(lblShowCurEmailAddress);
		cont.add(lblNewProfile);
		cont.add(lblNewUuid);
		cont.add(txtUuidUpdate);
		cont.add(lblNewPassword1);
		cont.add(txtPassword1Update);
		cont.add(lblNewPassword2);
		cont.add(txtPassword2Update);
		cont.add(lblNewFirstName);
		cont.add(txtFirstNameUpdate);
		cont.add(lblNewLastName);
		cont.add(txtLastNameUpdate);
		cont.add(lblNewCompanyName);
		cont.add(txtCompanyNameUpdate);
		cont.add(lblNewAddress1);
		cont.add(txtAddress1Update);
		cont.add(lblNewAddress2);
		cont.add(txtAddress2Update);
		cont.add(lblNewCity);
		cont.add(txtCityUpdate);
		cont.add(lblNewState);
		cont.add(cboStateUpdate);
		cont.add(lblNewZipCode);
		cont.add(txtZipCodeUpdate);
		cont.add(lblNewPhoneNumber);
		cont.add(txtPhoneNumberUpdate);
		cont.add(lblNewEmailAddress);
		cont.add(txtEmailAddressUpdate);
		
		return cont;
	}
	
	/**
	 * Sets up Mask Formatter
	 * @param str String input.
	 * @return MaskFormatter format.
	 */
	protected static MaskFormatter createFormatter(String str) {
		MaskFormatter format = null;
		try {
			format = new MaskFormatter(str);
		} catch (java.text.ParseException exc) {
			System.err.println("formatter is bad: " + exc.getMessage());
		}
		return format;
	}
	
	/**
	 * Reads and verifies all user input creating a new HomeownerAccount with
	 * user inputted data.
	 * 
	 * @return new ContractorAccount
	 */
	public UserAccount packageAccount() {
		return new ContractorAccount();
	}
	
	/**
	 * Basic setter for Uuid Update text field.
	 * @param text Uuid.
	 */
	public static void setUuidText(String text) {
		txtUuidUpdate.setText(text);
	}
	
	/**
	 * Basic getter for Uuid Update textd field.
	 */
	public static String getUuidText() {
		return txtUuidUpdate.getText();
	}
	
	/**
	 * Basic setter for Password Update text field.
	 * @param text Password.
	 */
	public static void setPasswordText(String text) {
		txtPassword1Update.setText(text);
		txtPassword2Update.setText(text);
	}
	
	/**
	 * Basic getter for Password Update 1 text field.
	 */
	public static char[] getPassword1Text() {
		return txtPassword1Update.getPassword();
	}
	
	/**
	 * Basic getter for Password Update 2 text field.
	 */
	public static char[] getPassword2Text() {
		return txtPassword2Update.getPassword();
	}
	
	/**
	 * Basic setter for First Name Update text field.
	 * @param text First Name.
	 */
	public static void setFirstNameText(String text) {
		txtFirstNameUpdate.setText(text);
	}
	
	/**
	 * Basic getter for First Name Update text field.
	 */
	public static String getFirstNameText() {
		return txtFirstNameUpdate.getText();
	}
	
	/**
	 * Basic setter for Last Name Update text field.
	 * @param text Last Name.
	 */
	public static void setLastNameText(String text) {
		txtLastNameUpdate.setText(text);
	}
	
	/**
	 * Basic getter for Last Name Update text field.
	 */
	public static String getLastNameText() {
		return txtLastNameUpdate.getText();
	}
	
	/**
	 * Basic setter for Company Name Update text field.
	 * @param text Company Name.
	 */
	public static void setCompanyNameText(String text) {
		txtCompanyNameUpdate.setText(text);
	}
	
	/**
	 * Basic getter for Company Name Update text field.
	 */
	public static String getCompanyNameText() {
		return txtCompanyNameUpdate.getText();
	}
	
	/**
	 * Basic setter for Address1 Update text field.
	 * @param text Address1.
	 */
	public static void setAddress1Text(String text) {
		txtAddress1Update.setText(text);
	}
	
	/**
	 * Basic getter for Address1 Update text field.
	 */
	public static String getAddress1Text() {
		return txtAddress1Update.getText();
	}
	
	/**
	 * Basic setter for Address2 Update text field.
	 * @param text Address2.
	 */
	public static void setAddress2Text(String text) {
		txtAddress2Update.setText(text);
	}
	
	/**
	 * Basic getter for Address2 Update text field.
	 */
	public static String getAddress2Text() {
		return txtAddress2Update.getText();
	}
	
	/**
	 * Basic setter for City Update text field.
	 * @param text City.
	 */
	public static void setCityText(String text) {
		txtCityUpdate.setText(text);
	}
	
	/**
	 * Basic getter for City text field.
	 */
	public static String getCityText() {
		return txtCityUpdate.getText();
	}
	
	/**
	 * Basic setter for State Update field.
	 * @param text State.
	 */
	public static void setStateText(String text) {
		for (int i = 0; i < states.length; ++i) {
			if (states[i].equalsIgnoreCase(text)) {
				cboStateUpdate.setSelectedIndex(i);
				break;
			}
		}
	}
	
	/**
	 * Basic getter for State Update field.
	 */
	public static String getStateText() {
		return (String) cboStateUpdate.getSelectedItem();
	}
	
	/**
	 * Basic setter for ZIP Code Update text field.
	 * @param text ZIP Code.
	 */
	public static void setZipCodeText(String text) {
		txtZipCodeUpdate.setText(text);
	}
	
	/**
	 * Basic getter for ZIP Code Update text field.
	 */
	public static String getZipCodeText() {
		return txtZipCodeUpdate.getText();
	}
	
	/**
	 * Basic setter for Phone Number Update text field.
	 * @param text Phone Number.
	 */
	public static void setPhoneNumberText(String text) {
		txtPhoneNumberUpdate.setText(text);
	}
	
	/**
	 * Basic getter for Phone Number Update text field.
	 */
	public static String getPhoneNumberText() {
		return txtPhoneNumberUpdate.getText();
	}
	
	/**
	 * Basic setter for Email Address Update text field.
	 * @param text Email Address.
	 */
	public static void setEmailAddressText(String text) {
		txtEmailAddressUpdate.setText(text);
	}
	
	/**
	 * Basic getter for Email Address Update text field.
	 */
	public static String getEmailAddressText() {
		return txtEmailAddressUpdate.getText();
	}
	
	/**
	 * This method tests whether text in password fields match each other.
	 * @param pass1 Password1Update text.
	 * @param pass2 Password2Update text.
	 * @return True or false.
	 */
	public static Boolean testPasswords(char[] pass1, char[] pass2) {
		Boolean testBool = null;
		int tester = 0;
		if (pass1.length == pass2.length) {
			System.out.println(pass1);
			System.out.println(pass2);
			for (int i = 0; i < pass1.length; i++) {
				if (pass1[i] != pass2[i]) {
					tester = 0;
				} else {
					tester++;
				}
			}
			if (tester > 0) {
				testBool = true;
			} else {
				testBool = false;
			}
		} else {
			testBool = false;
		}
		
		return testBool;
	}
	
	/**
	 * This method hides the profile update fields.
	 */
	public static void hideFields() {
		lblNewProfile.setVisible(false);
		lblNewUuid.setVisible(false);
		lblNewPassword1.setVisible(false);
		lblNewPassword2.setVisible(false);
		lblNewFirstName.setVisible(false);
		lblNewLastName.setVisible(false);
		lblNewCompanyName.setVisible(false);
		lblNewAddress1.setVisible(false);
		lblNewAddress2.setVisible(false);
		lblNewCity.setVisible(false);
		lblNewState.setVisible(false);
		lblNewZipCode.setVisible(false);
		lblNewPhoneNumber.setVisible(false);
		lblNewEmailAddress.setVisible(false);
		txtUuidUpdate.setVisible(false);
		txtPassword1Update.setVisible(false);
		txtPassword2Update.setVisible(false);
		txtFirstNameUpdate.setVisible(false);
		txtLastNameUpdate.setVisible(false);
		txtCompanyNameUpdate.setVisible(false);
		txtAddress1Update.setVisible(false);
		txtAddress2Update.setVisible(false);
		txtCityUpdate.setVisible(false);
		cboStateUpdate.setVisible(false);
		txtZipCodeUpdate.setVisible(false);
		txtPhoneNumberUpdate.setVisible(false);
		txtEmailAddressUpdate.setVisible(false);
	}
	
	/**
	 * This method makes the edit profile fields visible.
	 */
	public static void showFields() {
		lblNewProfile.setVisible(true);
		lblNewUuid.setVisible(true);
		lblNewPassword1.setVisible(true);
		lblNewPassword2.setVisible(true);
		lblNewFirstName.setVisible(true);
		lblNewLastName.setVisible(true);
		lblNewCompanyName.setVisible(true);
		lblNewAddress1.setVisible(true);
		lblNewAddress2.setVisible(true);
		lblNewCity.setVisible(true);
		lblNewState.setVisible(true);
		lblNewZipCode.setVisible(true);
		lblNewPhoneNumber.setVisible(true);
		lblNewEmailAddress.setVisible(true);
		txtUuidUpdate.setVisible(true);
		txtPassword1Update.setVisible(true);
		txtPassword2Update.setVisible(true);
		txtFirstNameUpdate.setVisible(true);
		txtLastNameUpdate.setVisible(true);
		txtCompanyNameUpdate.setVisible(true);
		txtAddress1Update.setVisible(true);
		txtAddress2Update.setVisible(true);
		txtCityUpdate.setVisible(true);
		cboStateUpdate.setVisible(true);
		txtZipCodeUpdate.setVisible(true);
		txtPhoneNumberUpdate.setVisible(true);
		txtEmailAddressUpdate.setVisible(true);
	}

	/**
	 * My very own variant of the FocusListener. 
	 * 
	 * @author Quack
	 *
	 */
	private static class MyTextFocusListener implements FocusListener {
		private JTextField field;
		
		/**
		 * Creates a new instance of <code>MyTextFocusListener</code>.
		 * 
		 * @param field the text field that this listener is listening to
		 */
		public MyTextFocusListener(JFormattedTextField field) {
			this.field = field;
		}
		
		@Override
		public void focusLost(FocusEvent ev) {
			// Verify email upon focusLostEvent
			String name = field.getName();
			AbstractDocument doc = (AbstractDocument) field.getDocument();
			DocumentFilter filt = doc.getDocumentFilter();
			if (name != null && field.getName().equals("email")) {
				if (filt instanceof DocumentEmailFilter) {
					try {
						((DocumentEmailFilter)filt).setToFilter(true);
						String contents = doc.getText(0, doc.getLength());
						doc.remove(0, doc.getLength());
						doc.insertString(0, contents, null);
						((DocumentEmailFilter)filt).setToFilter(false);
					} catch (BadLocationException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		@Override
		public void focusGained(FocusEvent ev) {
			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					// insert caret at start of text field
					field.setCaretPosition(0);
				}
			});
			
		}
	}//end MyTextFocusListener
}
