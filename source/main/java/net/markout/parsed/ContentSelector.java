/*
	ContentSelector.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.parsed;

import java.util.List;

import net.markout.types.Attribute;
import net.markout.types.Name;

/**
 * ContentSelector
 * 
 * Comment here.
 */
public interface ContentSelector {
	// *** Class Members ***
	public enum Selection {skip, element, element_content}

	// *** Interface Methods ***
	public Selection select(List<Name> elementNameStack, Name currentElement, Attribute[] attributes);
	
}
