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

package edu.wright.cs.fa15.ceg3120.concon.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 * This filter will be used to ensure a valid email address is used.
 * 
 * @author Quack
 *
 */
public class DocumentEmailFilter extends DocumentFilter {
	private Pattern regEx;
	private boolean filter;
	
	/**
	 * Creates a new instance of <code>DocumentEmailFilter</code>.
	 */
	public DocumentEmailFilter() {
		regEx = Pattern.compile("^[A-Za-z0-9_]+?@.+?\\..+$");
//		regEx = Pattern.compile("^(?=[A-Z0-9][A-Z0-9._%+-]{5,253}+$)"
//				+ "[A-Z0-9._%+-]{1,64}+@(?:(?=[A-Z0-9-]{1,63}+\\.)"
//				+ "[A-Z0-9]++(?:-[A-Z0-9]++)*+\\.){1,8}+[A-Z]{2,63}+$");
		filter = false;
	}// ^[A-Za-z0-9_][^!#$%^&*()+=<>?,.\\/\\\\\\[\\]\\{\\}`~]+?@.+?\\..+$
	
	/**
	 * Set whether to apply the filter.
	 * 
	 * @param filt true if filter is to be applied
	 */
	public void setToFilter(boolean filt) {
		filter = filt;
	}

	@Override
	public void insertString(DocumentFilter.FilterBypass fb, int offset,
			String text, AttributeSet attr) {
		if (filter) {
			try {
				AbstractDocument doc = (AbstractDocument) fb.getDocument();
				int length = doc.getLength();
				//String docContents = doc.getText(0, length);
				System.out.println("Contents: " + text);
				Matcher matcher = regEx.matcher(text);
				System.out.println(matcher.matches());
				if (!matcher.matches()) {
					remove(fb, 0, length);
					JOptionPane.showMessageDialog(null,
							"Your email:"
							+ "\n     \"" + text + "\""
							+ "\ndoes not match the predefined format."
							+ "\nPlease try again...",
							"Error", JOptionPane.ERROR_MESSAGE);
				} else {
					super.insertString(fb, 0, text, attr);
				}
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}
	}
}