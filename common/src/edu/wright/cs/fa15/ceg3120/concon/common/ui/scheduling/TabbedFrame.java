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

package edu.wright.cs.fa15.ceg3120.concon.common.ui.scheduling;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 *
 * @author Emily.
 */
@SuppressWarnings("serial")
public class TabbedFrame extends JFrame{
	
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jbutton1;
	private javax.swing.JButton jbutton2;
	private javax.swing.JButton jbutton3;
	private JComboBox<?> jcomboBox1;
	private JComboBox<?> jcomboBox2;
	private JComboBox<?> jcomboBox3;
	private JLabel jlabel1;
	private JLabel jlabel2;
	private JLabel jlabel3;
	private JLabel jlabel4;
	private JLabel jlabel5;
	private JPanel jpanel1;
	private JPanel jpanel2;
	private JPanel jpanel3;
	private JTabbedPane jtabbedPane1;
	private JTextField jtextField1;
	private JTextField jtextField2;
	private JTextField jtextField3;
	// End of variables declaration//GEN-END:variables

	/**
	 * Creates new form TabbedFrame.
	 */
	public TabbedFrame() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jlabel1 = new javax.swing.JLabel();
		jtabbedPane1 = new javax.swing.JTabbedPane();
		jpanel1 = new javax.swing.JPanel();
		jpanel2 = new javax.swing.JPanel();
		jcomboBox1 = new JComboBox<>();
		jcomboBox2 = new JComboBox<>();
		jcomboBox3 = new JComboBox<>();
		jlabel2 = new JLabel();
		jbutton1 = new JButton();
		jpanel3 = new JPanel();
		jlabel3 = new JLabel();
		jtextField1 = new JTextField();
		jlabel4 = new javax.swing.JLabel();
		jtextField2 = new javax.swing.JTextField();
		jbutton2 = new javax.swing.JButton();
		jbutton3 = new javax.swing.JButton();
		jlabel5 = new javax.swing.JLabel();
		jtextField3 = new javax.swing.JTextField();

		jlabel1.setText("Select The Month, Day, and Perferred time frame");

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		javax.swing.GroupLayout jpanel1Layout = new javax.swing.GroupLayout(jpanel1);
		jpanel1.setLayout(jpanel1Layout);
		jpanel1Layout.setHorizontalGroup(
				jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 409, Short.MAX_VALUE)
		);
		jpanel1Layout.setVerticalGroup(
				jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 272, Short.MAX_VALUE)
		);

		jtabbedPane1.addTab("Payment", jpanel1);

		jcomboBox1.setModel(new DefaultComboBoxModel(new String[] { "January", "Feburary", ""
				+ "March", "April", "June", "July", "August", "September", "October"
						+ "", "November", "December" }));

		jcomboBox2.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5"
				+ "", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18"
						+ "", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29"
								+ "", "30", "31" }));

		jcomboBox3.setBackground(new java.awt.Color(255, 102, 51));
		jcomboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2:30 - 4:30" }));

		jlabel2.setText("Select The Month, Day, and Perferred time frame");

		jbutton1.setText("Submit");
		jbutton1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jbutton1MouseClicked(evt);
			}
		});

		javax.swing.GroupLayout jpanel2Layout = new javax.swing.GroupLayout(jpanel2);
		jpanel2.setLayout(jpanel2Layout);
		jpanel2Layout.setHorizontalGroup(
				jpanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpanel2Layout.createSequentialGroup()
				.addGroup(jpanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment
						.LEADING)
					.addGroup(jpanel2Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jcomboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jcomboBox2, javax.swing.GroupLayout.PREFERRED_SIZE,
								134, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(14, 14, 14)
						.addComponent(jcomboBox3, javax.swing.GroupLayout.PREFERRED_SIZE,
								131, javax.swing.GroupLayout.PREFERRED_SIZE))
					.addGroup(jpanel2Layout.createSequentialGroup()
						.addGap(79, 79, 79)
						.addComponent(jlabel2))
					.addGroup(jpanel2Layout.createSequentialGroup()
						.addGap(160, 160, 160)
						.addComponent(jbutton1)))
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		jpanel2Layout.setVerticalGroup(
				jpanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpanel2Layout.createSequentialGroup()
				.addGap(53, 53, 53)
				.addComponent(jlabel2)
				.addGap(18, 18, 18)
				.addGroup(jpanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment
						.BASELINE)
					.addComponent(jcomboBox1, javax.swing.GroupLayout.PREFERRED_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(jcomboBox2, javax.swing.GroupLayout.PREFERRED_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(jcomboBox3, javax.swing.GroupLayout.PREFERRED_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
						85, Short.MAX_VALUE)
				.addComponent(jbutton1)
				.addGap(59, 59, 59))
		);

		jtabbedPane1.addTab("Scheduling", jpanel2);

		jlabel3.setText("Total Payment:");

		jtextField1.setText("$");

		jlabel4.setText("Scheduled Appointment Time:");

		jtextField2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jtextField2ActionPerformed(evt);
			}
		});

		jbutton2.setText("Confirm");
		jbutton2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jbutton2MouseClicked(evt);
			}
		});

		jbutton3.setText("Cancel");
		jbutton3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jbutton3MouseClicked(evt);
			}
		});

		jlabel5.setText("Contractor Chosen:");

		jtextField3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jtextField3ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jpanel3Layout = new javax.swing.GroupLayout(jpanel3);
		jpanel3.setLayout(jpanel3Layout);
		jpanel3Layout.setHorizontalGroup(
				jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpanel3Layout.createSequentialGroup()
				.addGap(100, 100, 100)
				.addComponent(jbutton2)
				.addGap(46, 46, 46)
				.addComponent(jbutton3)
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(jpanel3Layout.createSequentialGroup()
				.addGap(34, 34, 34)
				.addGroup(jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment
						.LEADING)
					.addGroup(jpanel3Layout.createSequentialGroup()
						.addComponent(jlabel5)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jtextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 93,
								javax.swing.GroupLayout.PREFERRED_SIZE))
					.addGroup(jpanel3Layout.createSequentialGroup()
						.addComponent(jlabel3)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jtextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 93,
								javax.swing.GroupLayout.PREFERRED_SIZE))
					.addGroup(jpanel3Layout.createSequentialGroup()
						.addComponent(jlabel4)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50,
								Short.MAX_VALUE)
						.addComponent(jtextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 93,
								javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addGap(90, 90, 90))
		);
		jpanel3Layout.setVerticalGroup(
				jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpanel3Layout.createSequentialGroup()
				.addGap(37, 37, 37)
				.addGroup(jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment
						.BASELINE)
					.addComponent(jlabel5)
					.addComponent(jtextField3, javax.swing.GroupLayout.PREFERRED_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(31, 31, 31)
				.addGroup(jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment
						.BASELINE)
					.addComponent(jlabel3)
					.addComponent(jtextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(30, 30, 30)
				.addGroup(jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment
						.BASELINE)
					.addComponent(jlabel4)
					.addComponent(jtextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 
							javax.swing.GroupLayout.DEFAULT_SIZE,
							javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50,
						Short.MAX_VALUE)
				.addGroup(jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment
						.BASELINE)
					.addComponent(jbutton2)
					.addComponent(jbutton3))
				.addGap(41, 41, 41))
		);

		jtabbedPane1.addTab("Overview", jpanel3);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jtabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400,
					Short.MAX_VALUE)
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jtabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, 
						Short.MAX_VALUE)
		);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * Javadoc needed.
	 * @param evt.
	 */
	private void jbutton1MouseClicked(java.awt.event.MouseEvent evt) {
		//GEN-FIRST:event_jButton1MouseClicked
		month = (String)jcomboBox1.getSelectedItem();
		//day must be string to prevent errors
		//ask team if ok to store this way
		day = (String)jcomboBox2.getSelectedItem();
		timeRange = (String)jcomboBox3.getSelectedItem();
		//SchedulingData<?> data = new SchedulingData<>(month,day,timeRange);
	}//GEN-LAST:event_jButton1MouseClicked

	/**
	 * Javadoc needed.
	 * @param evt.
	 */
	private void jbutton2MouseClicked(java.awt.event.MouseEvent evt) {
		//GEN-FIRST:event_jButton2MouseClicked
		// TODO add your handling code here:
	}//GEN-LAST:event_jButton2MouseClicked

	/**
	 * Javadoc needed.
	 * @param evt.
	 */
	private void jbutton3MouseClicked(java.awt.event.MouseEvent evt) {
		//GEN-FIRST:event_jButton3MouseClicked
		// TODO add your handling code here:
	}//GEN-LAST:event_jButton3MouseClicked

	/**
	 * Javadoc needed.
	 * @param evt.
	 */
	private void jtextField2ActionPerformed(java.awt.event.ActionEvent evt) {
		//GEN-FIRST:event_jTextField2ActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_jTextField2ActionPerformed

	/**
	 * Javadoc needed.
	 * @param evt.
	 */
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
