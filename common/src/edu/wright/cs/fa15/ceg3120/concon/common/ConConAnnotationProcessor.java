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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;

/**
 * Custom annotation processor to get rid of silly warning.
 * @author NathanJent
 *
 */
@SupportedAnnotationTypes(value = {"NetworkHandler"})
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class ConConAnnotationProcessor extends AbstractProcessor {
	private static final Logger LOG = LoggerFactory.getLogger(ConConAnnotationProcessor.class);


	/* (non-Javadoc)
	 * @see javax.annotation.processing.AbstractProcessor#process(
	 * java.util.Set, javax.annotation.processing.RoundEnvironment)
	 */
	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		for (TypeElement element : annotations) {
			LOG.debug(element.getQualifiedName().toString());
		}
		return true;
	}

}
