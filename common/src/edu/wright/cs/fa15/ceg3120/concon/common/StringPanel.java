package edu.wright.cs.fa15.ceg3120.concon.common;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StringPanel extends JPanel 
{
	private JButton loginButton;
	private SpringLayout currentLayout;
	private JTextField textField;
	private JPasswordField passwordField;
	
	
	
	public StringPanel() 
	{
		setBackground(Color.ORANGE);
		loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		currentLayout = new SpringLayout();
		
		setupPanel();
	}

	private void setupPanel()
	{
		this.setLayout(currentLayout);
		this.add(loginButton);
		
		JButton btnCreateAccount = new JButton("Create Account");
		currentLayout.putConstraint(SpringLayout.SOUTH, btnCreateAccount, -10, SpringLayout.SOUTH, this);
		currentLayout.putConstraint(SpringLayout.EAST, btnCreateAccount, -10, SpringLayout.EAST, this);
		add(btnCreateAccount);
		
		JLabel lblHomeOwnerLogin = new JLabel("Contractor App Login ");
		currentLayout.putConstraint(SpringLayout.NORTH, lblHomeOwnerLogin, 32, SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.WEST, lblHomeOwnerLogin, 98, SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.EAST, lblHomeOwnerLogin, -144, SpringLayout.EAST, this);
		lblHomeOwnerLogin.setForeground(new Color(0, 0, 0));
		lblHomeOwnerLogin.setFont(new Font("Times New Roman", Font.BOLD, 19));
		add(lblHomeOwnerLogin);
		
		textField = new JTextField();
		currentLayout.putConstraint(SpringLayout.SOUTH, lblHomeOwnerLogin, -34, SpringLayout.NORTH, textField);
		currentLayout.putConstraint(SpringLayout.EAST, loginButton, 0, SpringLayout.EAST, textField);
		currentLayout.putConstraint(SpringLayout.WEST, textField, 125, SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.EAST, textField, -181, SpringLayout.EAST, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, textField, -156, SpringLayout.SOUTH, this);
		add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		currentLayout.putConstraint(SpringLayout.NORTH, loginButton, 6, SpringLayout.SOUTH, passwordField);
		currentLayout.putConstraint(SpringLayout.NORTH, passwordField, 6, SpringLayout.SOUTH, textField);
		currentLayout.putConstraint(SpringLayout.WEST, passwordField, 0, SpringLayout.WEST, textField);
		currentLayout.putConstraint(SpringLayout.SOUTH, passwordField, 49, SpringLayout.NORTH, textField);
		currentLayout.putConstraint(SpringLayout.EAST, passwordField, -181, SpringLayout.EAST, this);
		passwordField.setBackground(Color.WHITE);
		passwordField.setToolTipText("");
		add(passwordField);
		
		JLabel lblAccountName = new JLabel("Account Name ");
		currentLayout.putConstraint(SpringLayout.NORTH, lblAccountName, 3, SpringLayout.NORTH, textField);
		currentLayout.putConstraint(SpringLayout.EAST, lblAccountName, -6, SpringLayout.WEST, textField);
		lblAccountName.setForeground(Color.BLACK);
		lblAccountName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		add(lblAccountName);
		
		JLabel lblPassword = new JLabel("Password");
		currentLayout.putConstraint(SpringLayout.SOUTH, lblPassword, 0, SpringLayout.SOUTH, passwordField);
		currentLayout.putConstraint(SpringLayout.EAST, lblPassword, -6, SpringLayout.WEST, passwordField);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		add(lblPassword);
	}
}
