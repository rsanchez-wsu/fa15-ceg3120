package edu.wright.cs.fa15.ceg3120.concon.server;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class CreateButtonsSearch extends JPanel{

	protected JRadioButton contractor;
	protected JRadioButton homeOwner;
	
	/**
	 * Creates a panel for the User's Tab.
	 */
	public CreateButtonsSearch() {
		super();
		this.setLayout(new FlowLayout());
		
		JPanel searching = new JPanel();
		searching.setLayout(new GridLayout(1,4));
		
		JTextField searchBar = new JTextField(25);
		searching.add(searchBar);
		JButton search = new JButton();
		search.setText("Search");
		search.addActionListener(new UserListener());
		//search.addActionListener(new ButtonListener());
		searching.add(search);

		homeOwner = new JRadioButton();
		homeOwner.setText("Homeowner");
		homeOwner.setSelected(true);
		ButtonGroup userTypes = new ButtonGroup();
		userTypes.add(homeOwner);
		searching.add(homeOwner);
		contractor = new JRadioButton();
		contractor.setText("Contractor");
		userTypes.add(contractor);
		searching.add(contractor);
		
		this.add(searching);
		
		JPanel results = new JPanel();
		results.setLayout(new GridLayout(1,1));
		JTable searchResults = new JTable();
		JScrollPane sr = new JScrollPane();
		sr.add(searchResults);
		results.add(sr);
		
		this.add(results);
	}
	
	@SuppressWarnings("unused")
	private class ButtonListener implements ActionListener{
    		@Override
        public void actionPerformed(ActionEvent event) {
    			try {
            	//else if( there is nothing typed in the text field){ //TODO add search functionality
            	//	System.out.println("You must enter a name to search");
            	//}
            	//else {
            		//search database for that name
            	//}
    			} catch (Exception ex) {
    				System.out.println("Error occured searching "
    								+ "for users with that name");
    			}
    		}
    	}
    
    	private class UserListener implements ActionListener{
    		@Override
        public void actionPerformed(ActionEvent event) {
    			try { //TODO format this window better
    				System.out.println("Button Pushed");
    				JFrame userInfo = new JFrame("Detail User Info");
    				userInfo.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            	
    				JPanel info = new JPanel();
    				info.setLayout(new GridLayout(3,1));
    				
            			JPanel editableInfo = new JPanel();
            			editableInfo.setLayout(new GridLayout(1,4));
            	
	            		JTextField name = new JTextField(25);
	            		name.setText("Barbara Kean");
	            		editableInfo.add(name);
            	
	            		JTextField address = new JTextField(25);
	            		address.setText("123 Main St. Gotham City");
            			editableInfo.add(address);
            	
            			JTextField phone = new JTextField(13);
            			phone.setText("(555)555-5555");
            			editableInfo.add(phone);
            		
            			JTextField email = new JTextField(20);
            			email.setText("mrs.gordon@gcpd.gov");
            			editableInfo.add(email);
            	
            			info.add(editableInfo);
            	
            			JPanel functions = new JPanel();
            			functions.setLayout(new GridLayout(1,3));
            	
            			JButton message = new JButton();
            			message.setText("Send Message");
            			functions.add(message);
            	
            			JButton disable = new JButton();
            			disable.setText("Disable Account");
            			functions.add(disable);
            	
            			JButton reset = new JButton();
            			reset.setText("Reset Password");
            			functions.add(reset);
            	
            			info.add(functions);

            	
            			userInfo.add(info);
            			userInfo.pack();
            			userInfo.setVisible(true);
    			} catch (Exception ex) {
    				System.out.println("Error occured searching for users with that name");
    			}//end catch
    		}//end ActionPerformed
    	}//end UserListener
	
}//end CreateButtonsSearch