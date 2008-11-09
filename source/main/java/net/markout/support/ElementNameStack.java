/*
	ElementNameStack.java

	Copyright 2004-2007 David Fogel
	All rights reserved.
*/

// *** package ***
package net.markout.support;

import java.util.AbstractList;
import java.util.List;

import net.markout.types.*;

// *** imports ***

public class ElementNameStack extends AbstractList<Name> {
	// *** Class Members ***

	// *** Instance Members ****
	private List<Name> theParent;
	private Name theName;
	private int theSize;

	// *** Constructors ***
	
	public ElementNameStack(Name name) {
		this(null, name);
	}
	
	public ElementNameStack(List<Name> parent, Name name) {
		theParent = parent;
		theName = name;
		theSize = theParent == null ? 1 : theParent.size() + 1;
	}

	// *** AbstractList Methods ***
	
	public Name get(int index) {
		if (index < 0 || index >= theSize)
			throw new IndexOutOfBoundsException();
		
		if (index == (theSize - 1))
			return theName;
		
		return theParent.get(index);
	}

	
	public int size() {
		return theSize;
	}

	// *** Public Methods ***
	
	public void set(Name name) {
		
		theName = name;
	}
	
	public List<Name> getParent() {
		
		return theParent;
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***

}






// end