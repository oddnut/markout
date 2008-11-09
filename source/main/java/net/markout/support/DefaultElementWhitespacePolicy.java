/*
	DefaultElementWhitespacePolicy.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.support;

// *** imports ***

import net.markout.ElementWhitespacePolicy;
import net.markout.types.Whitespace;

/**
 * DefaultElementWhitespacePolicy
 *
 * Comment here.  Author: David Fogel
 */
public class DefaultElementWhitespacePolicy implements ElementWhitespacePolicy {
	// *** Class Members ***

	// *** Instance Members ***

	// *** Constructors ***
	
	public DefaultElementWhitespacePolicy() {
		
	}

	// *** ElementWhitespacePolicy Methods ***
	
	public Whitespace beforeElement(int elementDepth) {return null;}
	
	public Whitespace betweenAttributes(int elementDepth) {return null;}
	
	public Whitespace afterLastAttribute(int elementDepth) {return null;}
	
	public Whitespace afterStartTag(int elementDepth) {return null;}
	
	public Whitespace afterEmptyElement(int elementDepth) {return null;}
	
	public Whitespace beforeEndTag(int elementDepth) {return null;}
	
	public Whitespace afterEndTag(int elementDepth) {return null;}

	// *** Public Methods ***

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










/* end */
