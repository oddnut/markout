/*
	DefaultWhitespacePolicy.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.support;

// *** imports ***

import net.markout.ElementWhitespacePolicy;
import net.markout.WhitespacePolicy;
import net.markout.types.Name;
import net.markout.types.Whitespace;

/**
 * DefaultWhitespacePolicy
 *
 * Comment here.  Author: David Fogel
 */
public class DefaultWhitespacePolicy implements WhitespacePolicy {
	// *** Class Members ***

	// *** Instance Members ***

	// *** Constructors ***
	
	public DefaultWhitespacePolicy() {
	}

	// *** WhitespacePolicy Methods ***
	
	public Whitespace afterXMLVersion() {
		return Whitespace.NEW_LINE;
	}
	
	public Whitespace afterDTD() {
		return Whitespace.NEW_LINE;
	}
	
	public Whitespace afterRoot() {
		return Whitespace.NEW_LINE;
	}
	
	public Whitespace afterComment() {
		return Whitespace.NEW_LINE;
	}
	
	public Whitespace afterPI() {
		return Whitespace.NEW_LINE;
	}
	
	public Whitespace beforeClose() {
		return Whitespace.NEW_LINE;
	}
	
	public ElementWhitespacePolicy forElement(Name elementType) {
		return ElementWhitespacePolicy.DEFAULT;
	}

	// *** Public Methods ***

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










/* end */
