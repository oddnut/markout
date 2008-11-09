/*
	Target.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.types;

// *** imports ***

import net.markout.IllegalXMLStringException;

/**
 * Target
 *
 * Comment here.  Author: David Fogel
 */
public class Target extends Name {
	// *** Class Members ***

	// *** Instance Members ***

	// *** Constructors ***
	
	public Target(String name) {
		super(name);
	}
	
	public Target(String s, int beginIndex, int endIndex) {
		super(s.substring(beginIndex, endIndex));
	}

	// *** Name Methods ***
	
	protected void check() {
		
		super.check();
		
		if (theString.equalsIgnoreCase("xml"))
			throw new IllegalXMLStringException(theString, "Target");
	}

	// *** Public Methods ***

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










// end
