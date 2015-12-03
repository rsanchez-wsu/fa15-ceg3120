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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
//import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * Calendar Tab.
 *
 */
public class CalendarTab extends JLayeredPane {
	private static final long serialVersionUID = 1L;
	private static final int WINDOW_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width
			- 150;
	private static final int WINDOW_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height
			- 150;
	private static final int WINDOW_HEIGHT_QUARTER = (Toolkit.getDefaultToolkit()
			.getScreenSize().height - 150) / 4;
	
	private static JLabel lblMonth;
	private static JLabel lblYear;
	private static JButton btnPrev;
	private static JButton btnNext;
	private static JTable tblCalendar;
	private static JComboBox<String> cmbYear;
//	private static JPanel frmMain;
//	private static Container pane;
	private static DefaultTableModel mtblCalendar; //Table model
	private static JScrollPane stblCalendar; //The scrollpane
	private static JPanel pnlCalendar;
	private static int realYear;
	private static int realMonth;
	private static int realDay;
	private static int currentYear;
	private static int currentMonth;
	
	/**
	 * Build the tab.
	 */
	public CalendarTab() {
		JPanel calendar = new JPanel();
		add(calendar, BorderLayout.CENTER);
		calendar.setLayout(null);
		addContainer();
	}
	
	/**
	 * Adds container to pane.
	 */
	private void addContainer() {
		add(addFields());
	}
	/**
	 * Adds fields to container.
	 */
	private static Container addFields() {
		Container cont = new Container();
		cont.setBounds(6, 6, WINDOW_WIDTH, 
				(WINDOW_HEIGHT - WINDOW_HEIGHT_QUARTER));
		cont.setLayout(null);

		//Look and feel
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Something's wrong!",
					"ClassNotFoundException", JOptionPane.ERROR_MESSAGE);
		} catch (InstantiationException e) {
			JOptionPane.showMessageDialog(null, "Something's wrong!",
					"InstantiationException", JOptionPane.ERROR_MESSAGE);
		} catch (IllegalAccessException e) {
			JOptionPane.showMessageDialog(null, "Something's wrong!",
					"IllegalAccessException", JOptionPane.ERROR_MESSAGE);
		} catch (UnsupportedLookAndFeelException e) {
			JOptionPane.showMessageDialog(null, "Something's wrong!",
					"UnsupportedLookAndFeelException", JOptionPane.ERROR_MESSAGE);
		}

		//Prepare frame
//		frmMain = new JFrame("Calendar Manager"); //Create frame
//		frmMain.setSize(330, 375); //Set size to 400x400 pixels
//        pane = frmMain.getContentPane(); //Get content pane
//		pane.setLayout(null); //Apply null layout

		//Create controls
		lblMonth = new JLabel("January");
		lblYear = new JLabel("Change year:");
		cmbYear = new JComboBox<String>();
		btnPrev = new JButton("<-");
		btnNext = new JButton("->");
		mtblCalendar = new DefaultTableModel() {
			
			/**
			 * Javadoc.
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
				}
			};
		tblCalendar = new JTable(mtblCalendar);
		stblCalendar = new JScrollPane(tblCalendar);
		pnlCalendar = new JPanel(null);

		//Set border
		pnlCalendar.setBorder(BorderFactory.createTitledBorder("Calendar"));

		//Register action listeners
		btnPrev.addActionListener(new BtnPrevAction());
		btnNext.addActionListener(new BtnNextAction());
		cmbYear.addActionListener(new CmbYearAction());

		//Add controls to pane
		pnlCalendar.add(lblMonth);
		pnlCalendar.add(lblYear);
		pnlCalendar.add(cmbYear);
		pnlCalendar.add(btnPrev);
		pnlCalendar.add(btnNext);
		pnlCalendar.add(stblCalendar);
		cont.add(pnlCalendar);

		//Set bounds
		pnlCalendar.setBounds(0, 0, 320, 335);
		lblMonth.setBounds(160 - lblMonth.getPreferredSize().width / 2, 25, 100, 25);
		lblYear.setBounds(10, 305, 80, 20);
		cmbYear.setBounds(230, 305, 80, 20);
		btnPrev.setBounds(10, 25, 50, 25);
		btnNext.setBounds(260, 25, 50, 25);
		stblCalendar.setBounds(10, 50, 300, 250);

		//Make frame visible
//      frmMain.setResizable(false);
//		frmMain.setVisible(true);

		//Get real month/year
		GregorianCalendar cal = new GregorianCalendar(); //Create calendar
		realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); //Get day
		realMonth = cal.get(GregorianCalendar.MONTH); //Get month
		realYear = cal.get(GregorianCalendar.YEAR); //Get year
		currentMonth = realMonth; //Match month and year
		currentYear = realYear;

		//Add headers
		String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; //All headers
		for (int i = 0; i < 7; i++) {
			mtblCalendar.addColumn(headers[i]);
		}

		tblCalendar.getParent().setBackground(tblCalendar.getBackground()); //Set background

		//No resize/reorder
		tblCalendar.getTableHeader().setResizingAllowed(false);
		tblCalendar.getTableHeader().setReorderingAllowed(false);

		//Single cell selection
		tblCalendar.setColumnSelectionAllowed(true);
		tblCalendar.setRowSelectionAllowed(true);
		tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		//Set row/column count
		tblCalendar.setRowHeight(38);
		mtblCalendar.setColumnCount(7);
		mtblCalendar.setRowCount(6);

		//Populate table
		for (int i = realYear - 100; i <= realYear + 100; i++) {
			cmbYear.addItem(String.valueOf(i));
		}

		//Refresh calendar
		refreshCalendar(Integer.valueOf(realMonth), Integer.valueOf(realYear)); //Refresh calendar
		cont.add(pnlCalendar);
//		cont.add(pane);
		return cont;
	}

	/**
	 * Javadoc needed.
	 * @param month.
	 * @param year.
	 */
	public static void refreshCalendar(int month, int year) {
		//Allow/disallow buttons
		btnPrev.setEnabled(true);
		btnNext.setEnabled(true);
		if (month == 0 && year <= realYear  - 10) {
			btnPrev.setEnabled(false);
		} //Too early
		if (month == 11 && year >= realYear + 100) {
			btnNext.setEnabled(false);
		} //Too late
		String[] months =  {"January", "February", "March", "April", "May", "June", 
				"July", "August", "September", "October", "November", "December"};
		lblMonth.setText(months[month]); //Refresh the month label (at the top)
		lblMonth.setBounds(160 - lblMonth.getPreferredSize().width / 2,
				25, 180, 25); //Re-align label with calendar
		cmbYear.setSelectedItem(String.valueOf(year)); //Select the correct year in the combo box

		//Clear table
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				mtblCalendar.setValueAt(null, i, j);
			}
		}

//		int nod; //Number of Days
//		int som; //Start Of Month
		
		//Get first day of month and number of days
		GregorianCalendar cal = new GregorianCalendar(year, month, 1);
		int nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		int som = cal.get(GregorianCalendar.DAY_OF_WEEK);

		//Draw calendar
		for (int i = 1; i <= nod; i++) {
			int row = ((i + som - 2) / 7);
			int column  =  (i + som - 2) % 7;
			mtblCalendar.setValueAt(i, row, column);
		}

		//Apply renderers
		tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new TblCalendarRenderer());
	}

	/**
	 * Javadoc needed.
	 *
	 */
	static class TblCalendarRenderer extends DefaultTableCellRenderer {
		
		/**
		 * Javadoc needed.
		 * 
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * Javadoc needed.
		 */
		public Component getTableCellRendererComponent(JTable table, Object value, 
				boolean selected, boolean focused, int row, int column) {
			super.getTableCellRendererComponent(table, value, selected, focused, row, column);
			if (column == 0 || column == 6) { //Week-end
				setBackground(new Color(255, 220, 220));
			} else { //Week
				setBackground(new Color(255, 255, 255));
			}
			if (value != null) {
				if (Integer.parseInt(value.toString()) == realDay 
						&& currentMonth == realMonth && currentYear == realYear) { //Today
					setBackground(new Color(220, 220, 255));
				}
			}
			setBorder(null);
			setForeground(Color.black);
			return this;
		}
	}

	/**
	 * Javadoc needed.
	 *
	 */
	static class BtnPrevAction implements ActionListener {
		/**
		 * Javadoc needed.
		 */
		public void actionPerformed(ActionEvent e0) {
			if (currentMonth == 0) { //Back one year
				currentMonth = 11;
				currentYear -= 1;
			} else { //Back one month
				currentMonth -= 1;
			}
			refreshCalendar(Integer.valueOf(currentMonth), Integer.valueOf(currentYear));
		}
	}
	
	/**
	 * Javadoc needed.
	 *
	 */
	static class BtnNextAction implements ActionListener {
		/**
		 * Javadoc needed.
		 */
		public void actionPerformed(ActionEvent e1) {
			if (currentMonth == 11) { //Foward one year
				currentMonth = 0;
				currentYear += 1;
			} else { //Foward one month
				currentMonth += 1;
			}
			refreshCalendar(Integer.valueOf(currentMonth), Integer.valueOf(currentYear));
		}
	}
	
	/**
	 * Javadoc needed.
	 *
	 */
	static class CmbYearAction implements ActionListener {
		/**
		 * Javadoc needed.
		 */
		public void actionPerformed(ActionEvent e2) {
			if (cmbYear.getSelectedItem() != null) {
				String b0 = cmbYear.getSelectedItem().toString();
				currentYear = Integer.parseInt(b0);
				refreshCalendar(Integer.valueOf(currentMonth), Integer.valueOf(currentYear));
			}
		}
	}
}