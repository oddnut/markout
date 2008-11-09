/*
	Entity.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.dtd;

// *** imports ***

import net.markout.types.Name;

/**
 * Entity
 *
 * Comment here.  Author: David Fogel
 */
public abstract class Entity {
	// *** Class Members ***

	// *** Instance Members ***
	
	private Name theName;

	// *** Constructors ***
	
	public Entity(Name name) {
		theName = name;
	}
	
	// *** Interface Methods ***

	// *** Public Methods ***
	
	public Name getName() {
		return theName;
	}
	
	abstract public boolean isParsed();

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










/* end */