/*
	EncName.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.types;

// *** imports ***

import net.markout.IllegalXMLStringException;

/**
 * EncName
 *
 * Comment here.  Author: David Fogel
 */
public class EncName extends XMLString {
	// *** Class Members ***

	// *** Instance Members ***

	// *** Constructors ***
	public EncName(String s) {
		super(s);
	}
	
	public EncName(String s, int beginIndex, int endIndex) {
		super(s.substring(beginIndex, endIndex));
	}

	// *** XMLString Methods ***
	
	protected void check() {
		
		int length = theString.length();
		
		if (length == 0)
			throw new IllegalXMLStringException("EncNames can't be zero-length");
		
		char c = theString.charAt(0);
		if ( ! XMLChar.isEncNameStartChar(c))
			throw new IllegalXMLStringException(theString, "EncName");
		
		for (int i = 1 ; i < length ; i++) {
			c = theString.charAt(i);
			if ( ! XMLChar.isEncNameChar(c))
				throw new IllegalXMLStringException(theString, "EncName");
		}
	}

	// *** Public Methods ***

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










// end
