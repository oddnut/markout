/*
	EmptyElementPolicy.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.parsed;

import net.markout.types.Name;

/**
 * EmptyElementPolicy
 * 
 * Comment here.
 */
public interface EmptyElementPolicy {
	// *** Class Members ***

	// *** Interface Methods ***
	
	public boolean isRenderedAsEmptyElement(Name elementName);
}
