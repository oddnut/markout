/*
	Notation.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.dtd;

// *** imports ***

import net.markout.types.*;

/**
 * Notation
 *
 * Comment here.  Author: David Fogel
 */
public class Notation implements External {
	// *** Class Members ***

	// *** Instance Members ***
	private Name theName;
	private SystemLiteral theSystemID;
	private PublicIDLiteral thePublicID;

	// *** Constructors ***
	
	public Notation(Name name, PublicIDLiteral publicID, SystemLiteral systemID) {
		theName = name;
		theSystemID = systemID;
		thePublicID = publicID;
	}

	// *** External Methods ***
	
	public SystemLiteral getSystemID() {
		return theSystemID;
	}
	
	public PublicIDLiteral getPublicID() {
		return thePublicID;
	}

	// *** Public Methods ***
	
	public Name getName() {
		return theName;
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










/* end */