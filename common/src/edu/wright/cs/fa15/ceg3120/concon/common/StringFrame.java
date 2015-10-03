package edu.wright.cs.fa15.ceg3120.concon.common;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class StringFrame extends JFrame 
{
	private StringPanel currentPanel;
	
	public StringFrame() 
	{
		currentPanel = new StringPanel();
		
		setupFrame();
		
	}
	
	private void setupFrame()
	{
		this.setContentPane(currentPanel);
		
	}

}
