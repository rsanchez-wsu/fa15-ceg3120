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

/*
 *	TabbedFrame class
 *	Group 3 - Payment-Scheduling
 *  Initially started in NetBeans
 *	Authored by Emily Novak, Jason Gottweis, Dallas Miller, 
 *		John Rosen, Alex Woodie, and Binh Nguyen.
 *
 */

package edu.wright.cs.fa15.ceg3120.concon.paysched;

import edu.wright.cs.fa15.ceg3120.concon.common.net.data.SchedulingData;
import edu.wright.cs.fa15.ceg3120.concon.paysched.PaymentData;

import java.awt.Color;
import java.text.DecimalFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**Class for tabbed window.
 *
 * @author Emily
 */
@SuppressWarnings("serial")	//This class will never be serialized.
public class TabbedFrame extends JFrame{
		
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton confirmButton; //confirm button for overview
	private javax.swing.JButton cancelButton; //cancel button for overview
	private JComboBox<?> monthsList; //Months box for scheduling
	private JComboBox<?> daysList; //Days box for scheduling
	private JComboBox<?> timesList; //Available times box for scheduling
	private JLabel schedulingTabHeader; //Scheduling Tab Header Label
	private JLabel totalPaymentOverview; //Total Payment for Overview tab
	private JLabel finalScheduledApptTime; //Scheduled Appointment time for Overview Tab
	private JLabel chosenContractor; //Chosen contractor for Overview Tab
	private JPanel paymentTabPanel; //Payment tab panel
	private JPanel schedulingTabPanel; //Scheduling tab panel
	private JPanel overviewTabPanel; //Overview tab panel
	private JTabbedPane jtabbedPane; //All three tabs panel
	private JTextField totalPaymentLabel; //Total payment amount
	private JTextField finalScheduledApptLabel; //Final scheduled appointment time
	private JTextField chosenContractorLabel; //Chosen Contractor

	//added by Jon
	private JButton addMoneyButton;
	private JLabel amountOwedLabel; //Label attached to the amount owed text box
	private JLabel amountInWalletLabel; // Label attached to the amount in wallet text box
	private JLabel amountRemainingLabel; //label attached to the amount remaining text box
	private JTextField amountOwed; //Will display the amount of money owed in the payment tab
	private JTextField amountInWallet; 
	//Will display the amount of money currently in the user's wallet in the payment tab
	private JTextField amountRemaining; 
	//will display the amount of money remaining after the
	//amount owed is subtracted from the amount in wallet

	// End of variables declaration//GEN-END:variables

	/**
     * Creates new form TabbedFrame.
     */
	public TabbedFrame() {
		initComponents();
	}

	/**
     * This method is called from within the constructor to initialize the form.
     */
	//Suppresses warnings that complain about rawtypes
	@SuppressWarnings({ "unchecked", "rawtypes" })	
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		//Tabs and Panes
		overviewTabPanel = new JPanel();
		jtabbedPane = new javax.swing.JTabbedPane();
		paymentTabPanel = new JPanel();
		schedulingTabPanel = new javax.swing.JPanel();

		//Scheduling tab Variables
		monthsList = new JComboBox<>();
		daysList = new JComboBox<>();
		timesList = new JComboBox<>();
		schedulingTabHeader = new JLabel();
		final SchedulingData sd = new SchedulingData();

		//Overview Tab Variables
		totalPaymentOverview = new JLabel();
		totalPaymentLabel = new JTextField();
		finalScheduledApptTime = new javax.swing.JLabel();
		finalScheduledApptLabel = new javax.swing.JTextField();
		confirmButton = new javax.swing.JButton();
		cancelButton = new javax.swing.JButton();
		chosenContractor = new javax.swing.JLabel();
		chosenContractorLabel = new javax.swing.JTextField();

		//Payment tab variables

		addMoneyButton = new javax.swing.JButton();
		amountOwedLabel = new JLabel();
		amountInWalletLabel = new JLabel();
		amountRemainingLabel = new JLabel();
		amountOwed = new JTextField();
		amountInWallet = new JTextField();
		amountRemaining = new JTextField();
		
		jtabbedPane.setBackground(Color.orange);   
//////////////////////////////////////////////////////////
//Payment Tab. Set label text, text field values and 
//text for JButtons.
//////////////////////////////////////////////////////////
		// decimal format for 2 decimal places for currency
		DecimalFormat currency = new DecimalFormat("##.00");
		//double values for owed and amount in wallet
		Double owed = 9.75;
		Double wallet = 15.25;
		Double remaining = wallet - owed;

		amountOwed.setText("$" + currency.format(owed));
		amountInWallet.setText("$" + currency.format(wallet));
		amountRemaining.setText("$" + currency.format(remaining));
		amountOwedLabel.setText("Amount Owed:");
		amountInWalletLabel.setText("Amount in Wallet:");
		amountRemainingLabel.setText("Amount Remaining");
		amountOwed.setEditable(false);
		amountInWallet.setEditable(false);
		amountRemaining.setEditable(false);
		addMoneyButton.setText("Add ConCoin");
		addMoneyButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				addMoneyButtonListener(evt);
			}
		});

		javax.swing.GroupLayout paymentLayout = new javax.swing.GroupLayout(paymentTabPanel);
		paymentTabPanel.setLayout(paymentLayout);
		paymentLayout.setHorizontalGroup(
				paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(paymentLayout.createSequentialGroup()
				.addGap(34, 34, 34)
				.addGroup(paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment
						.LEADING)
					.addGroup(paymentLayout.createSequentialGroup()
						.addComponent(amountOwedLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(amountOwed, javax.swing.GroupLayout.PREFERRED_SIZE,
								93, javax.swing.GroupLayout.PREFERRED_SIZE))
					.addGroup(paymentLayout.createSequentialGroup()
						.addComponent(amountInWalletLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(amountInWallet, javax.swing.GroupLayout.PREFERRED_SIZE, 93,
								javax.swing.GroupLayout.PREFERRED_SIZE))
					.addGroup(paymentLayout.createSequentialGroup()
							.addComponent(addMoneyButton)
							.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGroup(paymentLayout.createSequentialGroup()
						.addComponent(amountRemainingLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50,
								Short.MAX_VALUE)
						.addComponent(amountRemaining, javax.swing.GroupLayout
								.PREFERRED_SIZE, 93,javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addGap(90, 90, 90))
		);
		paymentLayout.setVerticalGroup(
				paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(paymentLayout.createSequentialGroup()
				.addGap(37, 37, 37)
				.addGroup(paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment
						.BASELINE)
					.addComponent(amountOwedLabel)
					.addComponent(amountOwed, javax.swing.GroupLayout.PREFERRED_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(31, 31, 31)
				.addGroup(paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment
						.BASELINE)
					.addComponent(amountInWalletLabel)
					.addComponent(amountInWallet, javax.swing.GroupLayout.PREFERRED_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGroup(paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment
						.BASELINE)
						.addComponent(addMoneyButton, javax.swing.GroupLayout.PREFERRED_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.PREFERRED_SIZE))
				
				.addGroup(paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment
						.BASELINE)
					.addComponent(amountRemainingLabel)
					.addComponent(amountRemaining, javax.swing.GroupLayout.PREFERRED_SIZE, 
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50,
						Short.MAX_VALUE)
				.addGroup(paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment
						.BASELINE))
				.addGap(41, 41, 41))
		);
		
		PaymentData pd = new PaymentData();

		//Set values for payment object
		pd.setAmountOwed(owed);
		pd.setAmountInWallet(wallet);
		pd.setAmountRemaining(remaining);
		
		
		paymentTabPanel.setBackground(Color.orange);

		jtabbedPane.addTab("Payment", paymentTabPanel);

//////////////////////////////////////////////////////////
//Scheduling Tab. Set label text, text field values and 
//text for jbuttons.
//////////////////////////////////////////////////////////

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		//Combo box that lists available months that have appointments. 
		monthsList.setModel(new DefaultComboBoxModel(new String[] { "January", "Feburary", "March",
				"April", "June", "July", "August", "September",
				"October", "November", "December" }));

		//Combo box that lists available dates during selected months
		daysList.setModel(new DefaultComboBoxModel(new Integer[] { 1,2,3,4,5}));

		//Combo box that lists available dates during selected months
		timesList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { 
				"2:30 - 4:30 PM",
				"10:30 AM - 12:30 PM"}));

		schedulingTabHeader.setText("Select The Month, Day, and Perferred time frame");
		
		javax.swing.GroupLayout schedulingLayout = new javax.swing.GroupLayout(schedulingTabPanel);
		schedulingTabPanel.setLayout(schedulingLayout);
		//Set horizontal layout for elements in tab
		schedulingLayout.setHorizontalGroup(
				schedulingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(schedulingLayout.createSequentialGroup())
				.addGroup(schedulingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment
						.LEADING)
					.addGroup(schedulingLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(monthsList, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(daysList, javax.swing.GroupLayout.PREFERRED_SIZE,
								134, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(14, 14, 14)
						.addComponent(timesList, javax.swing.GroupLayout.PREFERRED_SIZE,
								131, javax.swing.GroupLayout.PREFERRED_SIZE))
					.addGroup(schedulingLayout.createSequentialGroup()
						.addGap(79, 79, 79)
						.addComponent(schedulingTabHeader))
					)
		);
		//Set vertical layout for elements in tab
		schedulingLayout.setVerticalGroup(
				schedulingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(schedulingLayout.createSequentialGroup()
				.addGap(53, 53, 53)
				.addComponent(schedulingTabHeader)
				.addGap(18, 18, 18)
				.addGroup(schedulingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment
						.BASELINE)
					.addComponent(monthsList, javax.swing.GroupLayout.PREFERRED_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(daysList, javax.swing.GroupLayout.PREFERRED_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(timesList, javax.swing.GroupLayout.PREFERRED_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
						85, Short.MAX_VALUE)
				.addGap(59, 59, 59))
		);

		//Set values for scheduling object
		sd.setMonth((String)monthsList.getSelectedItem());
		sd.setDay((int)daysList.getSelectedItem());
		sd.setTimeRange((String) timesList.getSelectedItem());
		
		//Add Scheduling tab to GUI
		schedulingTabPanel.setBackground(Color.orange);
		jtabbedPane.addTab("Scheduling *", schedulingTabPanel);



//////////////////////////////////////////////////////////
//Overview Tab. Set label text, text field values and 
//text for jbuttons.
//////////////////////////////////////////////////////////
		totalPaymentOverview.setText("Total Payment:");
		
		totalPaymentLabel.setText("$" + currency.format(pd.getAmountOwed()));
		totalPaymentLabel.setEditable(false);

		finalScheduledApptTime.setText("Scheduled "
				+ "Appointment Time:");
		
		finalScheduledApptLabel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				SchedulingData sch = scheduledApptLabelListener(evt);
				finalScheduledApptLabel.setText(sch.getMonth() + " " 
						+ sch.getDay() + " between " + sch.getTimeRange());
				
			}
		});
		
		finalScheduledApptLabel.setEditable(false);
		
		

		confirmButton.setText("Confirm");
		
		confirmButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				confirmButtonListener(evt);
			}
		});


		cancelButton.setText("Cancel");
		cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				cancelButtonListener(evt);
			}
		});

		chosenContractor.setText("Contractor Chosen:");
		chosenContractorLabel.setEditable(false);

		chosenContractorLabel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				choseCOntractorLabelListener(evt);
			}
		});

		javax.swing.GroupLayout overviewLayout = new javax.swing.GroupLayout(overviewTabPanel);
		overviewTabPanel.setLayout(overviewLayout);
		overviewLayout.setHorizontalGroup(
				overviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(overviewLayout.createSequentialGroup()
				.addGap(100, 100, 100)
				.addComponent(confirmButton)
				.addGap(46, 46, 46)
				.addComponent(cancelButton)
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(overviewLayout.createSequentialGroup()
				.addGap(34, 34, 34)
				.addGroup(overviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment
						.LEADING)
					.addGroup(overviewLayout.createSequentialGroup()
						.addComponent(chosenContractor)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(chosenContractorLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
								93, javax.swing.GroupLayout.PREFERRED_SIZE))
					.addGroup(overviewLayout.createSequentialGroup()
						.addComponent(totalPaymentOverview)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(totalPaymentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93,
								javax.swing.GroupLayout.PREFERRED_SIZE))
					.addGroup(overviewLayout.createSequentialGroup()
						.addComponent(finalScheduledApptTime)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50,
								Short.MAX_VALUE)
						.addComponent(finalScheduledApptLabel, javax.swing.GroupLayout
								.PREFERRED_SIZE, 93,javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addGap(90, 90, 90))
		);
		overviewLayout.setVerticalGroup(
				overviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(overviewLayout.createSequentialGroup()
				.addGap(37, 37, 37)
				.addGroup(overviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment
						.BASELINE)
					.addComponent(chosenContractor)
					.addComponent(chosenContractorLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(31, 31, 31)
				.addGroup(overviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment
						.BASELINE)
					.addComponent(totalPaymentOverview)
					.addComponent(totalPaymentLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(30, 30, 30)
				.addGroup(overviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment
						.BASELINE)
					.addComponent(finalScheduledApptTime)
					.addComponent(finalScheduledApptLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50,
						Short.MAX_VALUE)
				.addGroup(overviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment
						.BASELINE)
					.addComponent(confirmButton)
					.addComponent(cancelButton))
				.addGap(41, 41, 41))
		);

		overviewTabPanel.setBackground(Color.orange);
		jtabbedPane.addTab("Overview *", overviewTabPanel);

		ChangeListener changeListener = new ChangeListener(){

			public void stateChanged(ChangeEvent e2) {

				tabbedChangedListener(e2);


			}
		};

		jtabbedPane.addChangeListener(changeListener);


		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jtabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 425,
					Short.MAX_VALUE)
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jtabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 240,
						Short.MAX_VALUE)
		);

		pack();
	}// </editor-fold>//GEN-END:initComponents


	/**This is the main method.
     * 
     * @param args arguments
     */
	public static void main(String[] args) {

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TabbedFrame().setVisible(true);
			}
		});
	}

/////////////////////////////////////////////////////////////////////
///Action Listener for Text Fields and Buttons    

	/**
     * Action Listener for Submit Button.
     * @param evt temp.
     */
	private void confirmButtonListener(java.awt.event.MouseEvent evt) {
		
	}//GEN-LAST:event_confirmButtonListener
	
	/**
     * Action Listener for AddMoney Button
     * Calls AddMoneyFrame to let user enter more money into their account
     * if insufficient funds to pay for job.
     * @param evt temp.
     */
	private void addMoneyButtonListener(java.awt.event.MouseEvent evt) { 
		AddMoneyFrame addMoney = new AddMoneyFrame();
		addMoney.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		addMoney.setSize(400, 300);
		addMoney.setVisible(true);
			
	
	}//GEN-LAST:event_jButton2MouseClicked

	/**
     * Action Listener for Cancel Button.
     * Cancels entire transaction and closes out of GUI
     * @param evt temp.
     */
	private void cancelButtonListener(java.awt.event.MouseEvent evt) {
		this.dispose();
	}//GEN-LAST:event_cancelButtonListener

	/**
     * Action Listener for scheduledAppt Label.
     * @param evt temp.
     */
	private SchedulingData scheduledApptLabelListener(java.awt.event.ActionEvent evt) {
		SchedulingData sd = new SchedulingData((String)monthsList.getSelectedItem(), 
				(int)daysList.getSelectedItem(), (String)monthsList.getSelectedItem());
		return sd;
	}//GEN-LAST:event_scheduledApptLabelListener

	/**
     * Action Listener for scheduledAppt Label.
     * @param evt temp.
     */
	private void choseCOntractorLabelListener(java.awt.event.ActionEvent evt) {

	}//GEN-LAST:event_choseCOntractorLabelListener

	/**
	 * Javadoc needed.
	 * @param e3.
	 */
	public void tabbedChangedListener(ChangeEvent e3) {
		JTabbedPane sourceTabbedPane = (JTabbedPane) e3.getSource();
		int index = sourceTabbedPane.getSelectedIndex();
		//System.out.println("Tab changed to: " + sourceTabbedPane.getTitleAt(index));
		if (sourceTabbedPane.getTitleAt(index).equals("Scheduling *")) {
			sourceTabbedPane.setTitleAt(index, "Scheduling");
		}
		if (sourceTabbedPane.getTitleAt(index).equals("Overview *")) {

			sourceTabbedPane.setTitleAt(index, "Overview");     

		}
	}
}