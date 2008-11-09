/*
	IllegalXMLStringException.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout;

// *** imports ***

/**
 * IllegalXMLStringException
 *
 * Comment here.  Author: David Fogel
 */
public class IllegalXMLStringException extends IllegalXMLException {
	// *** Class Members ***

	// *** Instance Members ***

	// *** Constructors ***
	public IllegalXMLStringException(String badString, String type) {
		super("The string \"" + badString + "\" is invalid for the XML type " + type + ".");
	}
	
	public IllegalXMLStringException(String message) {
		super(message);
	}

	// *** Interface Methods ***

	// *** Public Methods ***

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










// end
