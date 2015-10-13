package edu.wright.cs.fa15.ceg3120.concon.client.customer;

import javax.swing.JFrame;



public class HomeownerMainFrame extends JFrame {
private HomeownerMainPanel currentPanel;
	
	public HomeownerMainFrame() 
	{
		currentPanel = new HomeownerMainPanel();
		
		setupFrame();
		
	}
	
	private void setupFrame()
	{
		this.setContentPane(currentPanel);
		
	}
}
