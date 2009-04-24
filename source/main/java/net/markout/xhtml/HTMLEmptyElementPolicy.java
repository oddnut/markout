/*
	HTMLEmptyElementPolicy.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.xhtml;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import net.markout.EmptyElementPolicy;
import net.markout.types.Name;
import static net.markout.xhtml.XHTML.*;

/**
 * HTMLEmptyElementPolicy
 * 
 * Comment here.
 */
public class HTMLEmptyElementPolicy implements EmptyElementPolicy {
	// *** Class Members ***
	private static Set<Name> EMPTY = new HashSet<Name>(Arrays.asList(
			AREA, BASE, BASEFONT, BR, COL, FRAME, HR, IMG, INPUT, ISINDEX, LINK, META, PARAM));

	// *** Instance Members ***

	// *** Constructors ***

	// *** EmptyElementPolicy Methods ***
	public boolean isRenderableAsEmptyElement(Name elementName) {
		return EMPTY.contains(elementName);
	}
	
	public boolean requiresSpaceBeforeClosing() {
		return true;
	}

	// *** Public Methods ***

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}
