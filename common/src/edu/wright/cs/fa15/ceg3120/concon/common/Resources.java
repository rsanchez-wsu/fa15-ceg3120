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

import java.io.Serializable;

import javax.swing.ImageIcon;

/**
 * Access resources such as images.
 * 
 * @author NathanJent
 *
 */
public final class Resources implements Serializable{
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new <code>Resources</code> instance.
	 */
	public Resources() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Gets an ImageIcon representation of the image at the given path.
	 * 
	 * @param img String representation of the path to the image
	 * 
	 * @return an ImageIcon of the image at the given path
	 */
	public ImageIcon getImage(String img) {
		return new ImageIcon(getClass().getResource(img));
	}

}
