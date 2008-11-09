/*
	ElementWhitespacePolicy.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout;

// *** imports ***

import net.markout.support.DefaultElementWhitespacePolicy;
import net.markout.types.Whitespace;

/**
 * ElementWhitespacePolicy
 *
 * Comment here.  Author: David Fogel
 */
public interface ElementWhitespacePolicy {
	// *** Class Members ***
	
	public static final ElementWhitespacePolicy DEFAULT = new DefaultElementWhitespacePolicy();

	// *** Public Methods ***
	
	public Whitespace beforeElement(int elementDepth);
	
	public Whitespace betweenAttributes(int elementDepth);
	
	public Whitespace afterLastAttribute(int elementDepth);
	
	public Whitespace afterStartTag(int elementDepth);
	
	public Whitespace afterEmptyElement(int elementDepth);
	
	public Whitespace beforeEndTag(int elementDepth);
	
	public Whitespace afterEndTag(int elementDepth);
}










/* end */
