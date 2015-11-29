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
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * Notifications Tab.
 *
 */
public class NotifTab extends JLayeredPane {
	private static final JPanel notifications = new JPanel();
	private static Container cont = new Container();
	private static Color defaultColor = null;
	private static int list = 0;
	private static JButton[] acknowledge = null;
	private static JLabel[] jobs = null;
	
	private static final int WINDOW_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width
			- 150;
	private static final int WINDOW_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height
			- 150;
	private static final int WINDOW_HEIGHT_QUARTER = (Toolkit.getDefaultToolkit()
			.getScreenSize().height - 150) / 4;
	
	/**
	 * Action for when all notifications have been cleared.
	 *
	 */
	public static final class ActionAllNotificationsCleared implements
			ActionListener {

		/**
		 * Javadoc needed.
		 * @param defaultColor.
		 * @param list.
		 * @param acknowledge.
		 * @param jobs.
		 */
		public ActionAllNotificationsCleared(Color defaultColor1, int list1,
				JButton[] acknowledge1, JLabel[] jobs1) {
			defaultColor = defaultColor1;
			list = list1;
			acknowledge = acknowledge1;
			jobs = jobs1;
			
		}

		@Override  
		public void actionPerformed(ActionEvent e0) {
			cont.remove(acknowledge[list]);
			cont.remove(jobs[list]);
			list--;
			setNotif(getNotif() - 1);  
			if (getNotif() < 1) {  
				notifications.setBackground(defaultColor);  
			}
			cont.validate();
			cont.repaint(); 
		}
	}

	private static final long serialVersionUID = 1L;
	private static int curNotif = 0;
	
	/**
	 * Build the tab.
	 */
	public NotifTab() {
		add(notifications, BorderLayout.CENTER);
		notifications.setLayout(null);
		
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
//		Container cont = new Container();
		cont.setBounds(6, 6, WINDOW_WIDTH, 
				(WINDOW_HEIGHT - WINDOW_HEIGHT_QUARTER));
		cont.setLayout(new GridLayout(0,2));
		
		setNotif(6);  
		if (getNotif() > 0) {  
			notifications.setBackground(Color.RED);  
		}  
		final Color defaultColor = new Color(238,238,238);  
		String clientName;  
		String jobLocation;  
		String jobDate;  
		final JLabel[] jobs = new JLabel[10];  
		final JButton[] acknowledge = new JButton[10];  
		for (int i = 0; i <= 5; i++) {  
			final int list = i;  
			clientName = "Get name of client from database";  
			jobLocation = "Get location from database";  
			jobDate = "Get date from database";  
			jobs[i] = new JLabel(clientName + " needs work done at "   
			+ jobLocation + " on " + jobDate);  
			cont.add(jobs[i]);  
			acknowledge[i] = new JButton("Okay");  
			cont.add(acknowledge[i]);  
			acknowledge[i].addActionListener(
					new ActionAllNotificationsCleared(defaultColor, list, acknowledge,
					jobs));  
		} 
		
		return cont;
	}
	
	/**
	 * This method sets the current amount of notifications for the user. Used to
	 * set the color of the tab to notify the user.
	 * @param notif New value of the current notifications.
	 */
	public static void setNotif(int notif) {
		curNotif = notif;
	}
	
	/**
	 * Gets and returns the current number of notifications.
	 * @return Returns the current value.
	 */
	public static int getNotif() {
		return curNotif;
	}
}