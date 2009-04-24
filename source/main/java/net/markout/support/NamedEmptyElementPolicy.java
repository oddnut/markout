/*
	NamedEmptyElementPolicy.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.support;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import net.markout.EmptyElementPolicy;
import net.markout.types.Name;

/**
 * NamedEmptyElementPolicy
 * 
 * Comment here.
 */
public class NamedEmptyElementPolicy implements EmptyElementPolicy {
	// *** Class Members ***

	// *** Instance Members ***
	private Set<Name> allowedEmptyNames;
	private boolean requiresSpace;

	// *** Constructors ***
	public NamedEmptyElementPolicy(Name... names) {
		allowedEmptyNames = new HashSet<Name>(Arrays.asList(names));
		requiresSpace = false;
	}

	// *** EmptyElementPolicy Methods ***
	public boolean isRenderableAsEmptyElement(Name elementName) {
		return allowedEmptyNames.contains(elementName);
	}
	
	public boolean requiresSpaceBeforeClosing() {
		return requiresSpace;
	}

	// *** Public Methods ***
	public void setRequiresSpaceBeforeClosing(boolean requiresSpace) {
		this.requiresSpace = requiresSpace;
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}
