/*
	IndentedWhitespacePolicy.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.support;

import net.markout.WhitespacePolicy;
import net.markout.types.Name;
import net.markout.types.Whitespace;

// *** imports ***

/**
 * IndentedWhitespacePolicy
 *
 * Comment here.  Author: David Fogel
 */
public class IndentedWhitespacePolicy implements WhitespacePolicy {
	// *** Class Members ***
	
	private static Whitespace[] INDENTS;
	
	static {
		INDENTS = new Whitespace[10];
		String space = "\n\t\t\t\t\t\t\t\t\t\t\t";
		for (int i = 0 ; i < 10 ; i++) {
			INDENTS[i] = new Whitespace(space.substring(0, i + 1));
		}
	}

	// *** Instance Members ***

	// *** Constructors ***
	
	// *** WhitespacePolicy Methods ***
	
	public Whitespace forPosition(DocPosition position) {
		return Whitespace.NEW_LINE;
	}

	public Whitespace forPosition(Name elementName, int depth, ElementPosition position) {
		
		switch (position) {
		case before_element:
		case before_end:
			return INDENTS[depth < INDENTS.length ? depth : INDENTS.length - 1];
		}
		
		return null;
	}

	// *** Public Methods ***

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










/* end */