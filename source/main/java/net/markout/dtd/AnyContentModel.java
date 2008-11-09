/*
	AnyContentModel.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.dtd;

// *** imports ***

import net.markout.types.Name;

/**
 * AnyContentModel
 *
 * Comment here.  Author: David Fogel
 */
class AnyContentModel implements ContentModel, ContentValidator {
	// *** Class Members ***

	// *** Instance Members ***

	// *** Constructors ***

	// *** ContentModel Methods ***
	
	public ContentValidator getValidator() {return this;}
	
	// *** ContentValidator Methods ***
	
	public void reset() {}
	
	public boolean validateCharData() {
		return true;
	}
	
	public boolean validateNext(Name elementName) {
		return true;
	}
	
	public boolean validateClose() {
		return true;
	}

	// *** Public Methods ***
	
	public String toString() {
		return "ANY";
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










/* end */