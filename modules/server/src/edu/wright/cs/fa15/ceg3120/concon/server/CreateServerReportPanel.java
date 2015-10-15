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

/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package edu.wright.cs.fa15.ceg3120.concon.server;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class CreateServerReportPanel {
	static JComponent createReportPanel = reportPanel();
	/*
	 * Creates server reports into the report panel
	 * initially this was supposed to be a new tab but when I saw the updates 
	 * I think it would make the most sense to put this here.
	 */
	protected static JComponent reportPanel() {
        	final JPanel mainPanel = new JPanel(new BorderLayout());
        
        	String[] dataOptions = { "System Errors", "Database Errors", 
        				"System Resets and Backups"};
     
        	final JComboBox<String> dataOptionList = new JComboBox<String>(dataOptions);
        
        	dataOptionList.setSelectedIndex(0);
        	JPanel systemerrorspanel = new JPanel(new BorderLayout());
        	systemerrorspanel.add(new JTextField("Current System Errors"));
        	JTable errorsList;
    	
        	errorsList = getSysErrorsFromDataBase();
        	JScrollPane errorScroll = new JScrollPane(errorsList);
        	systemerrorspanel.add(errorScroll, BorderLayout.CENTER);
        	mainPanel.add(systemerrorspanel, BorderLayout.CENTER);
        	dataOptionList.addItemListener(new ItemListener() {
        		public void itemStateChanged(ItemEvent arg0) {
        			mainPanel.removeAll();
        			mainPanel.add(dataOptionList, BorderLayout.NORTH);
        			
        			if (dataOptionList.getSelectedIndex() == 0) {
        				JPanel syserrorspanel = new JPanel(new BorderLayout());
        				syserrorspanel.add(new JTextField("Current System Errors"));
        				JTable errorsList;
                	
        				errorsList = getSysErrorsFromDataBase();
        				JScrollPane errorScroll = new JScrollPane(errorsList);
        				syserrorspanel.add(errorScroll, BorderLayout.CENTER);
        				mainPanel.add(syserrorspanel, BorderLayout.CENTER);
        			}
        			
        			else if (dataOptionList.getSelectedIndex() == 1) {
        				JPanel databaseErrorPanel = new JPanel(new BorderLayout());
        				databaseErrorPanel.add(new JTextField(
        						  "Current Database Errors"));
        				JTable errorsList;
        				//TODO refine this once the database calling is worked out
        				errorsList = getrrorsfromDatabase();
        				JScrollPane errorScroll = new JScrollPane(errorsList);
        				databaseErrorPanel.add(errorScroll, BorderLayout.CENTER);
        				mainPanel.add(databaseErrorPanel, BorderLayout.CENTER);	
        				
        			}
        			
        			else if (dataOptionList.getSelectedIndex() == 2) {
        				JPanel sysresetpanel = new JPanel(new BorderLayout());
        				sysresetpanel.add(new JTextField("\nResets and Backups"));
        				JList<String> resetList = new JList<>();
        				//TODO refine this once the database calling is worked out
        				resetList = getResetAndBackupsFromDataBase();
        				sysresetpanel.add(resetList, BorderLayout.CENTER);
        				mainPanel.add(sysresetpanel, BorderLayout.CENTER);
        			}
        			mainPanel.revalidate();
        			mainPanel.repaint();
        		}
        	});

        //Lay out the demo.
        	mainPanel.add(dataOptionList, BorderLayout.NORTH);
    
        	return mainPanel;
    	}
	
	/*
	 * is the same as system errors but might change or be combined based on 
	 * how database calling will end up working
	 */
	protected static JTable getrrorsfromDatabase() {
		String errorCount;
		errorCount = "10";//TODO add database call for this
		
		//CHANGE IF COLUMNS ARE CHANGED FOR THE REPORTS
		Object[] columnTitles = {"Error", "Date", "Status"};
		Object[][] errorData = new String[Integer.parseInt(errorCount)] [3];
		/////////////////////////////////////////////
		
		for (int i = 0; i < Float.valueOf(errorCount); ++i) {
			errorData[i][0] = "Culpa";//replace with calls to database
			errorData[i][1] = "Datum";
			errorData[i][2] = "Est";		
		}
		JTable errorTable = new JTable( errorData, columnTitles);
		return errorTable;
	} 

	protected static JList<String> getResetAndBackupsFromDataBase() {
		
		JList<String> resetAndBackupList = new JList<String>();
		DefaultListModel<String> selectedModel = new DefaultListModel<>();
		selectedModel.addElement("Last System Reset On: ");//TODO get database call
		selectedModel.addElement("Last Backup On: ");//TODO get database call
		
		resetAndBackupList.setModel(selectedModel);
		
		return resetAndBackupList;
	}

	protected static JTable getSysErrorsFromDataBase() {
		String errorCount;
		errorCount = "10";//TODO add database call for this
		
		//CHANGE IF COLUMNS ARE CHANGED FOR THE REPORTS
		Object[] columnTitles = {"Error", "Date", "Status"};
		Object[][] errorData = new String[Integer.parseInt(errorCount)] [3];
		/////////////////////////////////////////////
		
		for (int i = 0; i < Float.valueOf(errorCount); ++i) {
			errorData[i][0] = "Culpa";//replace with calls to database
			errorData[i][1] = "Datum";
			errorData[i][2] = "Est";		
		}
		JTable errorTable = new JTable( errorData, columnTitles);
		return errorTable;
	}
}
