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

package edu.wright.cs.fa15.ceg3120.concon.common.data;

/**
 * Tag used to search jobs.
 * 
 * @author Jonathan Thomas
 *
 */
public class Tag {
	private String text;

	/**
	 * Construct a new Tag.
	 * 
	 * @param text
	 *			The name of the tag.
	 */
	public Tag(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
