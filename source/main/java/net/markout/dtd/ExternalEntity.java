/*
	ExternalEntity.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.dtd;

// *** imports ***

import net.markout.types.*;

/**
 * ExternalEntity
 *
 * Comment here.  Author: David Fogel
 */
public class ExternalEntity extends Entity implements External {
	// *** Class Members ***

	// *** Instance Members ***
	private SystemLiteral theSystemID;
	private PublicIDLiteral thePublicID;

	// *** Constructors ***
	
	public ExternalEntity(Name name, PublicIDLiteral publicID, SystemLiteral systemID) {
		super(name);
		theSystemID = systemID;
		thePublicID = publicID;
	}

	// *** Entity Methods ***
	
	public boolean isParsed() {
		return true;
	}
	
	// *** External Methods***
	
	public SystemLiteral getSystemID() {
		return theSystemID;
	}
	
	public PublicIDLiteral getPublicID() {
		return thePublicID;
	}

	// *** Public Methods ***

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










/* end */