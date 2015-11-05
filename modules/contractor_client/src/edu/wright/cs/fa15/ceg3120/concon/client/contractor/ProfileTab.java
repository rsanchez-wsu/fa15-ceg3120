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

package edu.wright.cs.fa15.ceg3120.concon.client.contractor;

import edu.wright.cs.fa15.ceg3120.concon.common.NewContractorPane;
import edu.wright.cs.fa15.ceg3120.concon.common.data.ContractorAccount;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

/**
 * This JPanel constructs the Profile tab in the Contractor Client.
 * 
 *
 */
public class ProfileTab extends JLayeredPane {
	/**
	 * Action for clicking Cancel JButton.
	 *
	 */
	public static final class ActionCancelClick implements ActionListener {
		/**
		 * Clears fields and sets their visibility to false.
		 */
		public void actionPerformed(ActionEvent arg0) {
			clearProfileUpdates();
			editProfileCancel();
		}
	}

	/**
	 * Action for clicking Clear JButton.
	 *
	 */
	public static final class ActionClearClick implements ActionListener {
		/**
		 * Clears fields.
		 */
		public void actionPerformed(ActionEvent arg0) {
			clearProfileUpdates();
		}
	}

	/**
	 * Action for clicking Edit JButton.
	 *
	 */
	public static final class ActionEditClick implements ActionListener {
		/**
		 * Sets fields' visibility to true.
		 */
		public void actionPerformed(ActionEvent arg0) {
			editProfile();
		}
	}

	/**
	 * Action for clicking Save JButton.
	 *
	 */
	public static final class ActionSaveClick implements ActionListener {
		/**
		 * Saves field data to ContractorAccount user.
		 */
		public void actionPerformed(ActionEvent arg0) {
			saveProfileUpdates();
		}
	}

	private static final long serialVersionUID = 1L;
	public static final ContractorAccount user = new ContractorAccount();
	public static final Container subCont = new Container();
	public static final JButton btnEdit = new JButton("Edit Profile");
	public static final JButton btnSave = new JButton("Save");
	public static final JButton btnClear = new JButton("Clear");
	public static final JButton btnCancel = new JButton("Cancel");
	
	/**
	 * Creates a new instance of <code>ProfileTab</code>.
	 */
	public ProfileTab(ContractorAccount inUser) {
		super();
		setLayout(new BorderLayout());
		initializeUser(inUser);
		buildPane();
	}
	
	/**
	 * Initializes values of local user to that from ContractorAccount user.
	 * @param inUser is ContractorAccount user.
	 */
	public static void initializeUser(ContractorAccount inUser) {
		user.setAccountType(inUser.getAccountType());
		user.setAddress1(inUser.getAddress1());
		user.setAddress2(inUser.getAddress2());
		user.setCity(inUser.getCity());
		user.setCompanyName(inUser.getCompanyName());
		user.setEmailAddress(inUser.getEmailAddress());
		user.setFirstName(inUser.getFirstName());
		user.setLastName(inUser.getLastName());
		user.setPhoneNumber(inUser.getPhoneNumber());
		user.setPswd(inUser.getPswd());
		user.setState(inUser.getState());
		user.setUuid(inUser.getUuid());
		user.setZipCode(inUser.getZipCode());
	}
	
	/**
	 * Builds the JLayeredPane.
	 */
	public void buildPane() {
		//revalidate(); not resizing. may have to change the default size thingy
		NewContractorPane profile = new NewContractorPane(user);
		profile.setMaximumSize(new Dimension(300, 350));
		add(profile, BorderLayout.CENTER);
		subCont.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		btnEdit.setVisible(true);
		btnEdit.addActionListener(new ActionEditClick());
		subCont.add(btnEdit);
		
		btnSave.setVisible(false);
		btnSave.addActionListener(new ActionSaveClick());
		subCont.add(btnSave);
		
		btnClear.setVisible(false);
		btnClear.addActionListener(new ActionClearClick());
		subCont.add(btnClear);

		btnCancel.setVisible(false);
		btnCancel.addActionListener(new ActionCancelClick());
		subCont.add(btnCancel);
		subCont.setVisible(true);
		add(subCont, BorderLayout.SOUTH);
	}
	
	/**
	 * This method sets the edit profile fields to visible.
	 */
	public static void editProfile() {
		NewContractorPane.showFields();
		changeVisibility(true);
	}
	
	/**
	 * This method saves the updated profile information.
	 */
	public static void saveProfileUpdates() {
		int loop = 0;
		while (loop < 1) {
			boolean passTest = NewContractorPane.testPasswords(
					NewContractorPane.getPassword1Text(), 
					NewContractorPane.getPassword2Text());
			if (passTest == false) {
				JOptionPane.showMessageDialog(null, "Passwords do not match!");
				loop++;
				break;
			} else {
				user.setUuid(NewContractorPane.getUuidText());
				user.setPswd(NewContractorPane.getPassword1Text());
				user.setFirstName(NewContractorPane.getFirstNameText());
				user.setLastName(NewContractorPane.getLastNameText());
				user.setCompanyName(NewContractorPane.getCompanyNameText());
				user.setAddress1(NewContractorPane.getAddress1Text());
				user.setAddress2(NewContractorPane.getAddress2Text());
				user.setCity(NewContractorPane.getCityText());
				user.setState(NewContractorPane.getStateText());
				user.setZipCode(NewContractorPane.getZipCodeText());
				user.setPhoneNumber(NewContractorPane.getPhoneNumberText());
				user.setEmailAddress(NewContractorPane.getEmailAddressText());
				loop++;
				break;
			}
		}
	}
	
	/**
	 * This method clears changes made to the profile edit fields.
	 */
	public static void clearProfileUpdates() {
		NewContractorPane.setUuidText((user == null) ? "" : user.getUuid());
		NewContractorPane.setPasswordText((user == null) ? "" 
				: Arrays.toString(user.getPswd()));
		NewContractorPane.setFirstNameText((user == null) ? "" : user.getFirstName());
		NewContractorPane.setLastNameText((user == null) ? "" : user.getLastName());
		NewContractorPane.setCompanyNameText((user == null) ? "" : user.getCompanyName());
		NewContractorPane.setAddress1Text((user == null) ? "" : user.getAddress1());
		NewContractorPane.setAddress2Text((user == null) ? "" : user.getAddress2());
		NewContractorPane.setCityText((user == null) ? "" : user.getCity());
		
		if (user != null) {
			String userState = user.getState();
			NewContractorPane.setStateText(userState);
		}
	}
	
	/**
	 * Changes the visibility of the buttons based on the passed Boolean value.
	 * @param visBool True or False.
	 */
	public static void changeVisibility(Boolean visBool) {
		ProfileTab.btnCancel.setVisible(visBool);
		ProfileTab.btnClear.setVisible(visBool);
		ProfileTab.btnSave.setVisible(visBool);
	}
	
	/**
	 * This method hides the profile edit fields.
	 */
	public static void editProfileCancel() {
		NewContractorPane.hideFields();
		changeVisibility(false);	
	}
}
