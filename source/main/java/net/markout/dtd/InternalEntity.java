/*
	InternalEntity.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.dtd;

// *** imports ***

import net.markout.types.EntityValue;
import net.markout.types.Name;

/**
 * InternalEntity
 *
 * Comment here.  Author: David Fogel
 */
public class InternalEntity extends Entity {
	// *** Class Members ***

	// *** Instance Members ***
	private EntityValue theValue;

	// *** Constructors ***
	
	public InternalEntity(Name name, EntityValue value) {
		super(name);
		theValue = value;
	}

	// *** Entity Methods ***
	
	public boolean isParsed() {
		return true;
	}

	// *** Public Methods ***
	
	public EntityValue getValue() {
		return theValue;
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










/* end */