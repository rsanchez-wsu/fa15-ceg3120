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

package edu.wright.cs.fa15.ceg3120.concon.paysched;

import java.awt.event.KeyEvent;

import javax.swing.JTextField;

/**a needed class until i can find a better solution to the integer only text fields.
 * 
 * @author Jason Gottweis
 *
 */
public class IntegerTextField extends JTextField {
	
	/**a serial number for this class.
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final String badchars = "`~!@#$%^&*()_+=\\|\"':;?/>.<, ";

	/**a process key event to ensure nothing but numbers.
	 * 
	 */
	public void processKeyEvent(KeyEvent ev) {

		char charA = ev.getKeyChar();

		if ((Character.isLetter(charA) && !ev.isAltDown()) 
				|| badchars.indexOf(charA) > -1) {
			ev.consume();
			return;
		}
		if (charA == '-' && getDocument().getLength() > 0) { 
			ev.consume();
		} else {
			super.processKeyEvent(ev);
		}

	}
}


