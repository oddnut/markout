/*
	CData.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.types;

// *** imports ***

import net.markout.IllegalXMLCharacterException;
import net.markout.IllegalXMLStringException;

/**
 * CData
 *
 * Comment here.  Author: David Fogel
 */
public class CData extends XMLString {
	// *** Class Members ***
	private static final char[] BAD = "]]>".toCharArray();
	private static final char LAST_BAD = BAD[BAD.length - 1]; // '>'

	// *** Instance Members ***

	// *** Constructors ***
	
	public CData(String s) {
		super(s);
	}
	
	public CData(String s, int beginIndex, int endIndex) {
		super(s.substring(beginIndex, endIndex));
	}

	// *** XMLString Methods ***
	
	protected void check() {
		
		int badIndex = 0;
		char nextBad = BAD[badIndex];
		
		int length = theString.length();
		
		for (int i = 0 ; i < length ; i++) {
			char c = theString.charAt(i);
			// check legal xml char
			if ( ! XMLChar.isXMLChar(c))
				throw new IllegalXMLCharacterException(c);
			
			// make sure we don't contain the string "]]>"
			if ( c == nextBad ) {
				if ( nextBad == LAST_BAD )
					throw new IllegalXMLStringException(theString, "CData");
				badIndex++;
				nextBad = BAD[badIndex];
			} else if (badIndex != 0) {
				// reset
				badIndex = 0;
				nextBad = BAD[badIndex];
			}
		}
	}

	// *** Public Methods ***

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










// end
