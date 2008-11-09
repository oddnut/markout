/*
	CharData.java
	
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
 * CharData
 *
 * Comment here.  Author: David Fogel
 */
public class CharData extends XMLString {
	// *** Class Members ***

	// *** Instance Members ***

	// *** Constructors ***
	
	public CharData(String s) {
		super(s);
	}
	
	public CharData(String s, int beginIndex, int endIndex) {
		super(s.substring(beginIndex, endIndex));
	}

	// *** XMLString Methods ***
	
	protected void check() {
		
		char[] bad = "]]>".toCharArray();
		int badIndex = 0;
		char nextBad = bad[badIndex];
		
		int length = theString.length();
		
		for (int i = 0 ; i < length ; i++) {
			char c = theString.charAt(i);
			// check legal xml char
			if ( ! XMLChar.isXMLChar(c))
				throw new IllegalXMLCharacterException(c);
			
			// check no start-delimeters
			if ( c == '<' || c == '&' )
				throw new IllegalXMLStringException(theString, "CharData");
			
			// make sure we don't contain the string "]]>"
			if ( c == nextBad ) {
				if ( nextBad == '>' )
					throw new IllegalXMLStringException(theString, "CharData");
				badIndex++;
				nextBad = bad[badIndex];
			} else if (badIndex != 0) {
				// reset
				badIndex = 0;
				nextBad = bad[badIndex];
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
