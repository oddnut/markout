/*
	EmptyContentModel.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.dtd;

// *** imports ***

import net.markout.types.Name;

/**
 * EmptyContentModel
 *
 * Comment here.  Author: David Fogel
 */
class EmptyContentModel implements ContentModel, ContentValidator {
	// *** Class Members ***

	// *** Instance Members ***

	// *** Constructors ***

	// *** ContentModel Methods ***
	
	public ContentValidator getValidator() {return this;}
	
	// *** ContentValidator Methods ***
	
	public void reset() {}
	
	public boolean validateCharData() {
		return false;
	}
	
	public boolean validateNext(Name elementName) {
		return false;
	}
	
	public boolean validateClose() {
		return true;
	}

	// *** Public Methods ***
	
	public String toString() {
		return "EMPTY";
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










/* end */