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
import edu.wright.cs.fa15.ceg3120.concon.common.data.UserAccount;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
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

/**
 * temp.
 * @author Quack
 *
 */
public class NewHomeownerPane extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField uuidText;
	private JTextField pswd1Field;
	private JTextField pswd2Field;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField add1Text;
	private JTextField add2Text;
	private JTextField cityText;
	private JComboBox<String> stateText;
	private JFormattedTextField zipText;
	private JFormattedTextField phoneText;
	private JFormattedTextField emailText;
	
	private HomeownerAccount user;

	/**
	 * Creates a new instance of <code>NewHomeOwnerPane</code>.
	 */
	public NewHomeownerPane(HomeownerAccount user) {
		super(new BorderLayout());
		this.user = user;
		addContainers();
	}

	/**
	 * Adds the image and user input areas to the Pane.
	 */
	private void addContainers() {
		//add(addImageArea(), BorderLayout.SOUTH);
		add(addTextFields(), BorderLayout.CENTER);
	}
	
	// private Container addImageArea() {
	// return null;
	// }

	/**
	 * Constructs the Container holding all the label and user input fields.
	 * 
	 * @return a Container holding all the user input fields
	 */
	private Container addTextFields() {
		Container cont = new Container();
		cont.setLayout(new GridLayout(12, 2));
		
		try {
			final JLabel uuidLabel = new JLabel("Username:");
			uuidText = new JTextField((user == null) ? "" : user.getUuid());
	
			final JLabel password1Label = new JLabel("Password:");
			pswd1Field = new JPasswordField((user == null) ? "" : Arrays.toString(user.getPswd()));
	
			final JLabel password2Label = new JLabel("Confirm Password:");
			pswd2Field = new JPasswordField((user == null) ? "" : Arrays.toString(user.getPswd()));
	
			final JLabel firstNameLabel = new JLabel("First Name:");
			firstNameField = new JTextField((user == null) ? "" : user.getFirstName());
			
			final JLabel lastNameLabel = new JLabel("last Name:");
			lastNameField = new JTextField((user == null) ? "" : user.getLastName());
			
			final JLabel add1Label = new JLabel("Street Address 1:");
			add1Text = new JTextField((user == null) ? "" : user.getAddress1());
	
			final JLabel add2Label = new JLabel("Street Address 2:");
			add2Text = new JTextField((user == null) ? "" : user.getAddress2());
			
			final JLabel cityLabel = new JLabel("City:");
			cityText = new JTextField((user == null) ? "" : user.getCity());
	
			final JLabel stateLabel = new JLabel("State:");
			String[] states = { "AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DE", "FL", "GA", "HI",
								"IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI",
								"MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV",
								"NY", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT",
								"VA", "VT", "WA", "WI", "WV", "WY" };
			stateText = new JComboBox<>(states);
	
			final JLabel zipLabel = new JLabel("Zip Code:");

			MaskFormatter format = new MaskFormatter("#####");
			format.setPlaceholderCharacter('#');
			zipText = new JFormattedTextField(format);
			zipText.addFocusListener(new MyTextFocusListener(zipText));
			
			final JLabel phoneLabel = new JLabel("Phone:");
			format = new MaskFormatter("###-###-####");
			format.setPlaceholderCharacter('#');
			phoneText = new JFormattedTextField(format);
			phoneText.addFocusListener(new MyTextFocusListener(phoneText));
	
			final JLabel emailLabel = new JLabel("Email:");
			emailText = new JFormattedTextField();
			((AbstractDocument)emailText.getDocument()).setDocumentFilter(
					new DocumentEmailFilter());
			emailText.setName("email");
			emailText.addFocusListener(new MyTextFocusListener(emailText));
			emailText.setText((user == null) ? "" : user.getEmailAddress());
	
			cont.add(uuidLabel);
			cont.add(uuidText);
			cont.add(password1Label);
			cont.add(pswd1Field);
			cont.add(password2Label);
			cont.add(pswd2Field);
			cont.add(firstNameLabel);
			cont.add(firstNameField);
			cont.add(lastNameLabel);
			cont.add(lastNameField);
			cont.add(add1Label);
			cont.add(add1Text);
			cont.add(add2Label);
			cont.add(add2Text);
			cont.add(cityLabel);
			cont.add(cityText);
			cont.add(stateLabel);
			cont.add(stateText);
			cont.add(zipLabel);
			cont.add(zipText);
			cont.add(phoneLabel);
			cont.add(phoneText);
			cont.add(emailLabel);
			cont.add(emailText);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return cont;
	}
	
	/**
	 * Reads and verifies all user input creating a new HomeownerAccount with
	 * user inputted data.
	 * 
	 * @return new HomeownerAccount
	 */
	public UserAccount packageAccount() {
		return new HomeownerAccount();
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
