
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

import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/*
 *
 * @author Emily
 */
@SuppressWarnings("serial")	//This class will never be serialized.
public class TabbedFrame extends JFrame{
	
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton submitButton; //submit button for scheduling
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
    private javax.swing.JButton paymentApprove; //Button for payment approve on payment tab
    private javax.swing.JButton paymentCancel; //Button for payment cancel on payment tab
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
        submitButton = new JButton();
        
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
        paymentApprove = new javax.swing.JButton();
        paymentCancel = new javax.swing.JButton();
        amountOwedLabel = new JLabel();
        amountInWalletLabel = new JLabel();
        amountRemainingLabel = new JLabel();
        amountOwed = new JTextField();
        amountInWallet = new JTextField();
        amountRemaining = new JTextField();
        
        
//////////////////////////////////////////////////////////
//Payment Tab. Set label text, text field values and 
//text for JButtons.
//////////////////////////////////////////////////////////
        DecimalFormat df = new DecimalFormat("##.00");
        Double owed = 9.75;
        Double wallet = 15.25;
        Double remaining = wallet - owed;
        amountOwed.setText("$" + df.format(owed));
        amountInWallet.setText("$" + df.format(wallet));
        amountRemaining.setText("$" + df.format(remaining));
        amountOwedLabel.setText("Amount Owed:");
        amountInWalletLabel.setText("Amount in Wallet:");
        amountRemainingLabel.setText("Amount Remaining");
        amountOwed.setEditable(false);
        amountInWallet.setEditable(false);
        amountRemaining.setEditable(false);
        paymentApprove.setText("Approve");
        paymentCancel.setText("Cancel");
        
        

        javax.swing.GroupLayout jpanel1Layout = new javax.swing.GroupLayout(paymentTabPanel);
        paymentTabPanel.setLayout(jpanel1Layout);
        jpanel1Layout.setHorizontalGroup(
            jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(paymentApprove)
                .addGap(46, 46, 46)
                .addComponent(paymentCancel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment
                		.LEADING)
                    .addGroup(jpanel1Layout.createSequentialGroup()
                        .addComponent(amountOwedLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                        		javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(amountOwed, javax.swing.GroupLayout.PREFERRED_SIZE,
                        		93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpanel1Layout.createSequentialGroup()
                        .addComponent(amountInWalletLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                        		javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(amountInWallet, javax.swing.GroupLayout.PREFERRED_SIZE, 93,
                        		javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpanel1Layout.createSequentialGroup()
                        .addComponent(amountRemainingLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50,
                        		Short.MAX_VALUE)
                        .addComponent(amountRemaining, javax.swing.GroupLayout
                        		.PREFERRED_SIZE, 93,javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(90, 90, 90))
        );
        jpanel1Layout.setVerticalGroup(
            jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment
                		.BASELINE)
                    .addComponent(amountOwedLabel)
                    .addComponent(amountOwed, javax.swing.GroupLayout.PREFERRED_SIZE,
                    		javax.swing.GroupLayout.DEFAULT_SIZE,
                    		javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment
                		.BASELINE)
                    .addComponent(amountInWalletLabel)
                    .addComponent(amountInWallet, javax.swing.GroupLayout.PREFERRED_SIZE,
                    		javax.swing.GroupLayout.DEFAULT_SIZE,
                    		javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment
                		.BASELINE)
                    .addComponent(amountRemainingLabel)
                    .addComponent(amountRemaining, javax.swing.GroupLayout.PREFERRED_SIZE, 
                    		javax.swing.GroupLayout.DEFAULT_SIZE,
                    		javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50,
                		Short.MAX_VALUE)
                .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment
                		.BASELINE)
                    .addComponent(paymentApprove)
                    .addComponent(paymentCancel))
                .addGap(41, 41, 41))
        );

        
           
       
        jtabbedPane.addTab("Payment", paymentTabPanel);
        
//////////////////////////////////////////////////////////
//Scheduling Tab. Set label text, text field values and 
//text for jbuttons.
//////////////////////////////////////////////////////////
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        monthsList.setModel(new DefaultComboBoxModel(new String[] { "January", "Feburary", "March",
          "April", "June", "July", "August", "September",
          "October", "November", "December" }));

        daysList.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5",
          "6", "7", "8", "9", "10", "11", "12", "13",
          "14", "15", "16", "17", "18", "19", "20",
          "21", "22", "23", "24", "25",
          "26", "27", "28", "29", "30", "31" }));

        timesList.setBackground(new java.awt.Color(255, 102, 51));
        timesList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2:30 - 4:30" }));

        schedulingTabHeader.setText("Select The Month, Day, and Perferred time frame");

        submitButton.setText("Submit");
        submitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbutton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpanel2Layout = new javax.swing.GroupLayout(schedulingTabPanel);
        schedulingTabPanel.setLayout(jpanel2Layout);
        jpanel2Layout.setHorizontalGroup(
            jpanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel2Layout.createSequentialGroup()
                .addGroup(jpanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment
                		.LEADING)
                    .addGroup(jpanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(monthsList, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                        		javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(daysList, javax.swing.GroupLayout.PREFERRED_SIZE,
                        		134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(timesList, javax.swing.GroupLayout.PREFERRED_SIZE,
                        		131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpanel2Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(schedulingTabHeader))
                    .addGroup(jpanel2Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(submitButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpanel2Layout.setVerticalGroup(
            jpanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(schedulingTabHeader)
                .addGap(18, 18, 18)
                .addGroup(jpanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment
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
                .addComponent(submitButton)
                .addGap(59, 59, 59))
        );

        jtabbedPane.addTab("Scheduling", schedulingTabPanel);

        
        
//////////////////////////////////////////////////////////
//Overview Tab. Set label text, text field values and 
//text for jbuttons.
//////////////////////////////////////////////////////////
        totalPaymentOverview.setText("Total Payment:");

        totalPaymentLabel.setText("$0.00");

        finalScheduledApptTime.setText("Scheduled Appointment Time:");

        finalScheduledApptLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtextField2ActionPerformed(evt);
            }
        });

        confirmButton.setText("Confirm");
        confirmButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbutton2MouseClicked(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbutton3MouseClicked(evt);
            }
        });

        chosenContractor.setText("Contractor Chosen:");

        chosenContractorLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtextField3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpanel3Layout = new javax.swing.GroupLayout(overviewTabPanel);
        overviewTabPanel.setLayout(jpanel3Layout);
        jpanel3Layout.setHorizontalGroup(
            jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel3Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(confirmButton)
                .addGap(46, 46, 46)
                .addComponent(cancelButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment
                		.LEADING)
                    .addGroup(jpanel3Layout.createSequentialGroup()
                        .addComponent(chosenContractor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                        		javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chosenContractorLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
                        		93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpanel3Layout.createSequentialGroup()
                        .addComponent(totalPaymentOverview)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                        		javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalPaymentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93,
                        		javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpanel3Layout.createSequentialGroup()
                        .addComponent(finalScheduledApptTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50,
                        		Short.MAX_VALUE)
                        .addComponent(finalScheduledApptLabel, javax.swing.GroupLayout
                        		.PREFERRED_SIZE, 93,javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(90, 90, 90))
        );
        jpanel3Layout.setVerticalGroup(
            jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment
                		.BASELINE)
                    .addComponent(chosenContractor)
                    .addComponent(chosenContractorLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
                    		javax.swing.GroupLayout.DEFAULT_SIZE,
                    		javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment
                		.BASELINE)
                    .addComponent(totalPaymentOverview)
                    .addComponent(totalPaymentLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
                    		javax.swing.GroupLayout.DEFAULT_SIZE,
                    		javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment
                		.BASELINE)
                    .addComponent(finalScheduledApptTime)
                    .addComponent(finalScheduledApptLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 
                    		javax.swing.GroupLayout.DEFAULT_SIZE,
                    		javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50,
                		Short.MAX_VALUE)
                .addGroup(jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment
                		.BASELINE)
                    .addComponent(confirmButton)
                    .addComponent(cancelButton))
                .addGap(41, 41, 41))
        );

        jtabbedPane.addTab("Overview", overviewTabPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 400,
            		Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbutton1MouseClicked(java.awt.event.MouseEvent evt) {
    	//GEN-FIRST:event_jButton1MouseClicked
        month = (String)monthsList.getSelectedItem();
        //day must be string to prevent errors
        //ask team if ok to store this way
        day = (String)daysList.getSelectedItem();
        timeRange = (String)timesList.getSelectedItem();
        //SchedulingData<?> data = new SchedulingData<>(month,day,timeRange);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jbutton2MouseClicked(java.awt.event.MouseEvent evt) {
    	 /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddMoneyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AddMoneyFrame().setVisible(true);
        });
    }//GEN-LAST:event_jButton2MouseClicked

    private void jbutton3MouseClicked(java.awt.event.MouseEvent evt) {
    	//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseClicked

    private void jtextField2ActionPerformed(java.awt.event.ActionEvent evt) {
    	//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed
    
    private void jtextField3ActionPerformed(java.awt.event.ActionEvent evt) {
    	//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    /**This is the main method.
     * 
     * @param args arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : 
            		javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TabbedFrame.class.getName())
            	.log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TabbedFrame.class.getName())
            	.log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TabbedFrame.class.getName())
            	.log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TabbedFrame.class.getName())
            	.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TabbedFrame().setVisible(true);
            }
        });
    }

    String month;
    String day;
    String timeRange;
   
}
