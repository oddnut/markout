/*
	ContentValidator.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.dtd;

// *** imports ***

import net.markout.types.Name;

/**
 * ContentValidator
 *
 * Comment here.  Author: David Fogel
 */
public interface ContentValidator {
	// *** Class Members ***

	// *** Public Methods ***
	
	public void reset();
	
	public boolean validateCharData();
	
	public boolean validateNext(Name elementName);
	
	public boolean validateClose();
}










/* end */