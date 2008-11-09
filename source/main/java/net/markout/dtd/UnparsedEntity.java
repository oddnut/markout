/*
	UnparsedEntity.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.dtd;

// *** imports ***

import net.markout.types.*;

/**
 * UnparsedEntity
 *
 * Comment here.  Author: David Fogel
 */
public class UnparsedEntity extends Entity implements External {
	// *** Class Members ***

	// *** Instance Members ***
	private SystemLiteral theSystemID;
	private PublicIDLiteral thePublicID;
	private Name theNotationName;

	// *** Constructors ***
	
	public UnparsedEntity(Name name, PublicIDLiteral publicID, SystemLiteral systemID, Name notationName) {
		super(name);
		
		theSystemID = systemID;
		thePublicID = publicID;
		theNotationName = notationName;
	}

	// *** Entity Methods ***
	
	public boolean isParsed() {
		return false;
	}
	
	// *** External Methods ***
	
	public SystemLiteral getSystemID() {
		return theSystemID;
	}
	
	public PublicIDLiteral getPublicID() {
		return thePublicID;
	}

	// *** Public Methods ***

	public Name getNotationName() {
		return theNotationName;
	}
	
	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










/* end */