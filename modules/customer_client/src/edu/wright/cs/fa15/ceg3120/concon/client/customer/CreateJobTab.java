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

package edu.wright.cs.fa15.ceg3120.concon.client.customer;

import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * This class is used to create our "create a job" tab, it uses text fields to read in data from
 * customers.
 * @author brianknotts
 *
 */
public class CreateJobTab extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField txtName;
	private JTextField txtLastName;
	private JTextField txtAddress;
	private JTextField txtCity;
	private JTextField txtState;
	private JTextField txtZip;
	private JTextField txtStartingBid;
	private JTextPane txtpnJobDescription;
	private JPanel imagePanel;
	private JLabel image;
	private JButton btnCreateJob;
	
	/**
	 * constructor that initializes basic default panel objects.
	 */
	public CreateJobTab() {
		setOpaque(false);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel jobDescriptionImagePanel = new JPanel();
		add(jobDescriptionImagePanel);
		jobDescriptionImagePanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		//code block for initializing the size/location of the image panel for job image
		imagePanel = new JPanel();
		jobDescriptionImagePanel.add(imagePanel);
		GridBagLayout gblImagePanel = new GridBagLayout();
		gblImagePanel.columnWidths = new int[]{224, 0, 0};
		gblImagePanel.rowHeights = new int[]{175, 0};
		gblImagePanel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gblImagePanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		imagePanel.setLayout(gblImagePanel);
		
		//sets the layout and load image button size/location
		GridBagConstraints gbcbtnUploadImage = new GridBagConstraints();
		gbcbtnUploadImage.gridwidth = 2;
		gbcbtnUploadImage.anchor = GridBagConstraints.SOUTH;
		gbcbtnUploadImage.insets = new Insets(0, 0, 0, 5);
		gbcbtnUploadImage.gridx = 0;
		gbcbtnUploadImage.gridy = 0;
		
		image = new JLabel();
		imagePanel.add(image);
		JButton btnUploadImage = new JButton("Upload Image");
		imagePanel.add(btnUploadImage, gbcbtnUploadImage);
		btnUploadImage.addActionListener(new MyListener(image));
		
		txtpnJobDescription = new JTextPane();
		txtpnJobDescription.setText(" Job Description");
		jobDescriptionImagePanel.add(txtpnJobDescription);
		
		JPanel customerInfoPanel = new JPanel();
		add(customerInfoPanel);
		customerInfoPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		txtName = new JTextField();
		txtName.setText("First Name");
		customerInfoPanel.add(txtName);
		txtName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setText("Last Name");
		customerInfoPanel.add(txtLastName);
		txtLastName.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setText("Address ");
		customerInfoPanel.add(txtAddress);
		txtAddress.setColumns(10);
		
		txtCity = new JTextField();
		txtCity.setText("City");
		customerInfoPanel.add(txtCity);
		txtCity.setColumns(10);
		
		txtState = new JTextField();
		txtState.setText("State");
		customerInfoPanel.add(txtState);
		txtState.setColumns(10);
		
		txtZip = new JTextField();
		txtZip.setText("Zip");
		customerInfoPanel.add(txtZip);
		txtZip.setColumns(10);
		
		txtStartingBid = new JTextField();
		customerInfoPanel.add(txtStartingBid);
		txtStartingBid.setText("Starting Bid");
		txtStartingBid.setColumns(10);
		
		btnCreateJob = new JButton("Create Job");
		customerInfoPanel.add(btnCreateJob);
		btnCreateJob.addActionListener(new CreateJobListener());
	}
	
	/**
	 * Basic listener for action on upload image - code to come later.
	 * @author brianknotts
	 *
	 */
	private static class MyListener implements ActionListener {
		private JLabel image;
		
		/**
		 * Create a new instance of <code>MyListener</code>.
		 * @param image JLabel to hold the image
		 */
		public MyListener(JLabel image) {
			this.image = image;
		}

		@Override
		public void actionPerformed(ActionEvent ex) {
			// TODO Auto-generated method stub
			final JFileChooser choose = new JFileChooser();
			String[] extensions = ImageIO.getReaderFileSuffixes();
			
			for (String ext : extensions) {
				FileFilter filter = new FileNameExtensionFilter(
						"." + ext + " files", ext);
				choose.addChoosableFileFilter(filter);
			}
			
			choose.setAcceptAllFileFilterUsed(false);
			
			int choice = choose.showOpenDialog(null);
			if (choice == JFileChooser.APPROVE_OPTION) {
				File imageFile = choose.getSelectedFile();
				ImageIcon profilePic = new ImageIcon(imageFile.getAbsolutePath());
				BufferedImage resized = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);
				Graphics2D g2 = resized.createGraphics();
				
				g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
						RenderingHints.VALUE_INTERPOLATION_BILINEAR);
				g2.drawImage(profilePic.getImage(), 0, 0, 200, 200, null);
				g2.dispose();
				profilePic.setImage(resized);
				
				image.setIcon(profilePic);
			}
		
			System.out.print("");
		}
		
	}
	
	/**
	 * basic action listener for handling the create job click event - code to come later.
	 * @author brianknotts
	 *
	 */
	private static class CreateJobListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ex) {
			// TODO Auto-generated method stub
			System.out.print("");
		}
		
	}
}
