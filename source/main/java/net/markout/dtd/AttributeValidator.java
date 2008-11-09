/*
	AttributeValidator.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.dtd;

// *** imports ***

import net.markout.types.AttValue;
import net.markout.types.Name;

/**
 * AttributeValidator
 *
 * Comment here.  Author: David Fogel
 */
public interface AttributeValidator {
	// *** Class Members ***

	// *** Public Methods ***
	
	public void validateNext(Name attributeName, AttValue value, DocumentValidator docValidator);
	
	public void close();
}










/* end */