/*
	Whitespace.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.types;

// *** imports ***

import net.markout.IllegalXMLStringException;

/**
 * Whitespace
 *
 * Comment here.  Author: David Fogel
 */
public class Whitespace extends CharData {
	// *** Class Members ***
	
	public final static Whitespace NEW_LINE = new Whitespace("\n");
	public final static Whitespace SPACE = new Whitespace(" ");
	public final static Whitespace TAB = new Whitespace("\t");

	// *** Instance Members ***

	// *** Constructors ***

	public Whitespace(String s) {
		super(s);
	}
	
	public Whitespace(String s, int beginIndex, int endIndex) {
		super(s.substring(beginIndex, endIndex));
	}
	
	// *** XMLString Methods ***
	
	protected void check() {
		
		int length = theString.length();
		
		if (length == 0)
			throw new IllegalXMLStringException("WhiteSpace can't be zero-length");
		
		for (int i = 0 ; i < length ; i++) {
			char c = theString.charAt(i);
			if ( ! XMLChar.isWhiteSpaceChar(c))
				throw new IllegalXMLStringException(theString, "WhiteSpace");
		}
	}

	// *** Public Methods ***

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










// end
