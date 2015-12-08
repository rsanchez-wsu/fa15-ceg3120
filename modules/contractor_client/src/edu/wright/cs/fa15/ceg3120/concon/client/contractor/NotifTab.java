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
import java.awt.Container;
import java.awt.FlowLayout;
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
	private static final int WINDOW_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width
			- 150;
	private static final int WINDOW_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height
			- 150;
	private static final int WINDOW_HEIGHT_QUARTER = (Toolkit.getDefaultToolkit()
			.getScreenSize().height - 150) / 4;
	private static final long serialVersionUID = 1L;
	private static int curIndex = 0;
	
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
		cont.setLayout(new FlowLayout());
		String[] populateArray = new String[6];
		final int size = populateArray.length;
		final String[] notifArray = populateArray(populateArray);
		final JLabel notif = new JLabel();
		notif.setSize(100, 50);
		notif.setText(notifArray[getIndex()]);
		final JButton accept = new JButton("Dismiss Notification");
		accept.setSize(200, 50);
		cont.add(notif);
		cont.add(accept);
		accept.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (getIndex() + 1 > size - 1) {
					cont.remove(notif);
					cont.remove(accept);
					cont.revalidate();
					cont.repaint();
				} else {
					setIndex(getIndex() + 1);
					notif.setText(notifArray[getIndex()]);
				}
				
			}
			
		});
		return cont;
	}
	/**
	 * This method populates the array of values for the label.
	 * @param notifArray The array to be populated
	 * @return Returns the populated array
	 */
	
	private static String[] populateArray(String[] notifArray) {
		for (int i = 0; i < notifArray.length; i++) {
			notifArray[i] = "This is notif number " + (i + 1);
		}
		return notifArray;
	}
	
	/**
	 * This method sets the index.
	 * @param index New value for the index
	 */
	
	private static void setIndex(int index) {
		curIndex = index;
	}
	
	/**
	 * This method gets the value of the index.
	 * @return Returns the value of the index
	 */
	
	private static int getIndex() {
		return curIndex;
	}
}