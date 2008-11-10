/*
	IllegalXMLCharacterException.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout;

// *** imports ***

/**
 * IllegalXMLCharacterException
 *
 * Comment here.  Author: David Fogel
 */
public class IllegalXMLCharacterException extends IllegalXMLException {
	// *** Class Members ***
	private static final long serialVersionUID = 1L;

	// *** Instance Members ***

	// *** Constructors ***
	public IllegalXMLCharacterException(char c) {
		super("The character \"" + Integer.toString((int) c, 16) + "\" is not a legal XML character.");
	}

	// *** Interface Methods ***

	// *** Public Methods ***

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










// end
