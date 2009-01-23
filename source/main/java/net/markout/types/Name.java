/*
	Name.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.types;

// *** imports ***

import net.markout.IllegalXMLStringException;

/**
 * Name
 *
 * Comment here.  Author: David Fogel
 */
public class Name extends XMLString {
	// *** Class Members ***

	// *** Instance Members ***

	// *** Constructors ***
	public Name(String name) {
		super(name);
	}
	
	public Name(String s, int beginIndex, int endIndex) {
		super(s.substring(beginIndex, endIndex));
	}

	// *** XMLString Methods ***
	
	protected void check() {
		
		int length = theString.length();
		
		if (length == 0)
			throw new IllegalXMLStringException("XML Names can't be zero-length");
		
		char c = theString.charAt(0);
		if ( ! XMLChar.isNameStartChar(c))
			throw new IllegalXMLStringException(theString, "Name");
		
		for (int i = 1 ; i < length ; i++) {
			c = theString.charAt(i);
			if ( ! XMLChar.isNameChar(c))
				throw new IllegalXMLStringException(theString, "Name");
		}
	}

	// *** Public Methods ***
	public Attribute att(String attValue) {
		
		return new Attribute(this, new AttValue(attValue));
	}
	
	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










// end
