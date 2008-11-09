/*
	WhitespacePolicy.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout;

// *** imports ***

import net.markout.types.Name;
import net.markout.types.Whitespace;

/**
 * WhitespacePolicy
 *
 * Comment here.  Author: David Fogel
 */
public interface WhitespacePolicy {
	// *** Class Members ***

	// *** Public Methods ***
	
	public Whitespace afterXMLVersion();
	
	public Whitespace afterDTD();
	
	public Whitespace afterRoot();
	
	public Whitespace afterComment();
	
	public Whitespace afterPI();
	
	public Whitespace beforeClose();
	
	public ElementWhitespacePolicy forElement(Name elementType);
}










/* end */
