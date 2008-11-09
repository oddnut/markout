/*
	MixedContentModel.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.dtd;

// *** imports ***

import java.util.*;

import net.markout.types.Name;

/**
 * MixedContentModel
 *
 * Comment here.  Author: David Fogel
 */
public class MixedContentModel implements ContentModel, ContentValidator {
	// *** Class Members ***

	// *** Instance Members ***
	private Set theAllowedNames;

	// *** Constructors ***
	public MixedContentModel() {
		this(null);
	}
	
	public MixedContentModel(Collection allowedElementNames) {
		if (allowedElementNames != null)
			theAllowedNames = new HashSet(allowedElementNames);
		else
			theAllowedNames = new HashSet();
	}

	// *** ContentModel Methods ***
	
	public ContentValidator getValidator() {return this;}
	
	// *** ContentValidator Methods ***
	
	public void reset() {}
	
	public boolean validateCharData() {
		return true;
	}
	
	public boolean validateNext(Name elementName) {
		return theAllowedNames.contains(elementName);
	}
	
	public boolean validateClose() {
		return true;
	}

	// *** Public Methods ***
	
	public void addAllowedName(Name name) {
		theAllowedNames.add(name);
	}
	
	public void addAllowedNames(Collection names) {
		theAllowedNames.addAll(names);
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("MIXED: (#PCDATA");
		
		Iterator i = theAllowedNames.iterator();
		while (i.hasNext()) {
			sb.append("|");
			sb.append(i.next().toString());
		}
		
		sb.append(")");
		
		return sb.toString();
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










/* end */