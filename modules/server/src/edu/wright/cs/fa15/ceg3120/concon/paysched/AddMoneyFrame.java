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

package edu.wright.cs.fa15.ceg3120.concon.paysched;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;

/**
 * 
 * @author temp.
 *
 */
@SuppressWarnings("serial") //used for versioning when class is serialized
public class AddMoneyFrame extends JFrame {
	
	//Declare variables
	private javax.swing.JButton okButton;
	private javax.swing.JButton cancelButton;
	private javax.swing.JLabel amountToAddLabel;
	private javax.swing.JTextField amountToAddTextField;
	
	/**
     * Call components of GUI in constructor.
     */
	public AddMoneyFrame() {
		initComponents();
	}

	/**
     * Sets up every component in the window.
     */
	private void initComponents() {
		//Initialize variables
		amountToAddLabel = new javax.swing.JLabel();
		amountToAddTextField = new javax.swing.JTextField();
		okButton = new javax.swing.JButton();
		cancelButton = new javax.swing.JButton();


		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


////////////////////////////////////////////////////////
/////Adding money labels and text fields
		amountToAddLabel.setText("Amount to Add:");

		amountToAddTextField.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				amountToAddActionPerformed(evt);
			}
		});
////////////////////////////////////////////////////////
/////OK Button and Action Listener
		okButton.setText("OK");
		okButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				okButtonActionPerformed(evt);
			}
		});
////////////////////////////////////////////////////////
/////Cancel Button and Action Listener
		cancelButton.setText("CANCEL");
		cancelButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelButtonActionPerformed(evt);
			}
		});

////////////////////////////////////////////////////////
/////Layout for GUI
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		//Set the horizontal positions of the label, text field, and buttons
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
				.addGap(109, 109, 109)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addComponent(amountToAddLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90,
							javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71,
							javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, 
						false)
					.addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(amountToAddTextField))
				.addContainerGap(112, Short.MAX_VALUE))
		);//end of horizontal layout
		//Set the vertical positions of the label, text field, and buttons
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
				.addGap(85, 85, 85)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
					.addComponent(amountToAddLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
							javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(amountToAddTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
							javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(31, 31, 31)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
					.addComponent(cancelButton)
					.addComponent(okButton))
				.addContainerGap(128, Short.MAX_VALUE))
		);//end of vertical layout

		pack();   

	}//end of initCoponents     

/////////////////////////////////////////////////////////////////////
///Action Performers for Text Fields and Buttons

	/**
     * Action Performer for amountToAdd text field.
     * @param evt temp.
     */
	private void amountToAddActionPerformed(ActionEvent evt) { 

	}//end of amountToAddACtionPerformed                                           

	/**
     * Action Performer for OK Button.
     * @param evt temp.
     */
	private void okButtonActionPerformed(ActionEvent evt) { 

	}//end of okButtonActionPerformed                                         

	/**
     * Action Performer for Cancel Button.
     * @param evt temp.
     */
	private void cancelButtonActionPerformed(ActionEvent evt) { 
		this.dispose();//Only exits out of AddMoneyFrame GUI
	}//end of cencelButtonActionPerformed              


}
