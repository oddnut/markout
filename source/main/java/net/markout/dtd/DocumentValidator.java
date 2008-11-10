/*
	DocumentValidator.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.dtd;

// *** imports ***

import java.util.*;

import net.markout.types.AttValue;
import net.markout.types.Name;

/**
 * DocumentValidator
 *
 * Comment here.  Author: David Fogel
 */
public class DocumentValidator {
	// *** Class Members ***

	// *** Instance Members ***
	
	private DTD theDTD;
	
	private Set<AttValue> theIDVals;
	private Set<AttValue> thePendingIDRefs;
	
	private List<Set<Name>> theProhibitionsStack;

	// *** Constructors ***
	
	public DocumentValidator(DTD dtd) {
		theDTD = dtd;
		theIDVals = new HashSet<AttValue>();
		thePendingIDRefs = new HashSet<AttValue>();
		theProhibitionsStack = new ArrayList<Set<Name>>();
	}

	// *** Interface Methods ***

	// *** Public Methods ***
	
	public DTD getDTD() {
		return theDTD;
	}
	
	public void pushProhibitionSet(Set<Name> prohibitions) {
		theProhibitionsStack.add(prohibitions);
	}
	
	public Set<Name> popProhibitionSet() {
		return theProhibitionsStack.remove(theProhibitionsStack.size() - 1);
	}
	
	public void validateDescendant(Name elementName) {
		int length = theProhibitionsStack.size();
		for (int i = 0 ; i < length ; i++) {
			Set<Name> s = theProhibitionsStack.get(i);
			if (s.contains(elementName))
				throw new ValidationException("Descendant prohibited: element " + 
						elementName.toString() + " not allowed in some ancestor element.");
		}
	}
	
	public void validateIDValue(AttValue id) {
		if (theIDVals.contains(id))
			throw new ValidationException("Attribute value of type ID specified twice.");
		theIDVals.add(id);
		thePendingIDRefs.remove(id); // if it's there...
	}
	
	public void addIDRef(AttValue id) {
		if (theIDVals.contains(id))
			return; // already specified
		thePendingIDRefs.add(id);
	}
	
	public void close() {
		if ( !thePendingIDRefs.isEmpty())
			throw new ValidationException(
					"Missing ID specifications referenced elsewhere in document: " +
					thePendingIDRefs.toString());
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










/* end */