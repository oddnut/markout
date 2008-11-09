/*
	NameContentModel.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.dtd;

// *** imports ***

import net.markout.types.Name;

/**
 * NameContentModel
 *
 * Comment here.  Author: David Fogel
 */
public class NameContentModel implements ContentModel {
	// *** Class Members ***

	// *** Instance Members ***
	
	private Name theName;

	// *** Constructors ***
	
	public NameContentModel(Name elementName) {
		theName = elementName;
	}

	// *** ContentModel Methods ***
	
	public ContentValidator getValidator() {
		return new NameValidator();
	}

	// *** Public Methods ***
	
	public String toString() {
		return theName.toString();
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
	
	private class NameValidator implements ContentValidator {
		
		boolean done;
		
		public NameValidator() {
			done = false;
		}
		
		public void reset() {
			done = false;
		}
		
		public boolean validateCharData() {
			return false;
		}
		
		public boolean validateNext(Name elementName) {
			
			if (!done && theName.equals(elementName)) {
				done = true;
				return true;
			}
			
			return false;
			
		}
		
		public boolean validateClose() {
			
			return done;
		}
	}
}










/* end */