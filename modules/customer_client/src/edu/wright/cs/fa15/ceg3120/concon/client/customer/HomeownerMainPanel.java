package edu.wright.cs.fa15.ceg3120.concon.client.customer;

import javax.swing.*;

import java.awt.Color;


public class HomeownerMainPanel  extends JTabbedPane  {
	private JLayeredPane Tab3;
	

	
	public HomeownerMainPanel() 
	{
		setBackground(Color.ORANGE);
		
		JLayeredPane Tab1 = new JLayeredPane();
		addTab("Tab1", null, Tab1, null);
		setEnabledAt(0, true);
		setBackgroundAt(0, Color.WHITE);
		
		JLayeredPane Tab2 = new JLayeredPane();
		addTab("Tab2", null, Tab2, null);
		
		Tab3 = new JLayeredPane();
		addTab("Tab3", null, Tab3, null);
		
		JLayeredPane Tab4 = new JLayeredPane();
		addTab("Tab4", null, Tab4, null);
		
		JLayeredPane Tab5 = new JLayeredPane();
		addTab("Tab5", null, Tab5, null);
		
		
		setupPanel();
	}

	private void setupPanel()
	{
		
	
	
	}
}
