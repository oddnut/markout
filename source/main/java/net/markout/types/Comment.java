/*
	Comment.java
	
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
 * Comment
 *
 * Comment here.  Author: David Fogel
 */
public class Comment extends XMLString{
	// *** Class Members ***

	// *** Instance Members ***

	// *** Constructors ***
	
	public Comment(String s) {
		super(s);
	}
	
	public Comment(String s, int beginIndex, int endIndex) {
		super(s.substring(beginIndex, endIndex));
	}

	// *** XMLString Methods ***
	
	protected void check() {
		
		int dashCount = 0;
		
		int length = theString.length();
		
		for (int i = 0 ; i < length ; i++) {
			char c = theString.charAt(i);
			// check legal xml char
			if ( ! XMLChar.isXMLChar(c))
				throw new IllegalXMLCharacterException(c);
			
			// make sure we don't contain the string "--"
			if ( c == '-' ) {
				if ( dashCount > 0 )
					throw new IllegalXMLStringException(theString, "Comment");
				dashCount++;
			} else {
				// reset
				dashCount = 0;
			}
		}
		// make sure we don't end with a dash
		if (dashCount > 1)
			throw new IllegalXMLStringException(theString, "Comment");
	}

	// *** Public Methods ***

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










// end
