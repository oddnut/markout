/*
	NmToken.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.types;

// *** imports ***

import net.markout.IllegalXMLStringException;

/**
 * NmToken
 *
 * Comment here.  Author: David Fogel
 */
public class NmToken extends XMLString {
	// *** Class Members ***

	// *** Instance Members ***

	// *** Constructors ***
	public NmToken(String name) {
		super(name);
	}

	// *** XMLString Methods ***
	
	protected void check() {
		
		int length = theString.length();
		
		if (length == 0)
			throw new IllegalXMLStringException("XML NmTokens can't be zero-length");
		
		for (int i = 0 ; i < length ; i++) {
			char c = theString.charAt(i);
			if ( ! XMLChar.isNameChar(c))
				throw new IllegalXMLStringException(theString, "NmToken");
		}
	}

	// *** Public Methods ***
	
	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










// end
