/*
	IndentedWhitespacePolicy.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.support;

import net.markout.ElementWhitespacePolicy;
import net.markout.WhitespacePolicy;
import net.markout.types.Name;
import net.markout.types.Whitespace;

// *** imports ***

/**
 * IndentedWhitespacePolicy
 *
 * Comment here.  Author: David Fogel
 */
public class IndentedWhitespacePolicy implements WhitespacePolicy, ElementWhitespacePolicy{
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
	
	public IndentedWhitespacePolicy() {
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
		return this;
	}
	
	// *** ElementWhitespacePolicy Methods ***
	
	public Whitespace beforeElement(int elementDepth) {
		return INDENTS[elementDepth < INDENTS.length ? elementDepth : INDENTS.length - 1];
	}
	
	public Whitespace betweenAttributes(int elementDepth) {
		return null;
	}
	
	public Whitespace afterLastAttribute(int elementDepth) {
		return null;
	}
	
	public Whitespace afterStartTag(int elementDepth) {
		return null;
	}
	
	public Whitespace afterEmptyElement(int elementDepth) {
		return null;
	}
	
	public Whitespace beforeEndTag(int elementDepth) {
		return INDENTS[elementDepth < INDENTS.length ? elementDepth : INDENTS.length - 1];
	}
	
	public Whitespace afterEndTag(int elementDepth) {
		return null;
	}

	// *** Public Methods ***

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










/* end */