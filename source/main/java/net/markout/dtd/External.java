/*
	External.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.dtd;

// *** imports ***

import net.markout.types.PublicIDLiteral;
import net.markout.types.SystemLiteral;

/**
 * External
 *
 * Comment here.  Author: David Fogel
 */
public interface External {
	// *** Class Members ***

	// *** Public Methods ***
	
	public SystemLiteral getSystemID();
	
	public PublicIDLiteral getPublicID();
}










/* end */