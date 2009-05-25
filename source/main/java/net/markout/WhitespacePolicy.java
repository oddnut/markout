/*
	WhitespacePolicy.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout;

// *** imports ***

import net.markout.types.Name;
import net.markout.types.Whitespace;

/**
 * WhitespacePolicy
 *
 * Comment here.  Author: David Fogel
 */
public interface WhitespacePolicy {
	// *** Class Members ***
	public static final WhitespacePolicy DEFAULT = new WhitespacePolicy() {
		public Whitespace forPosition(DocPosition position) {
			return Whitespace.NEW_LINE;
		}
		public Whitespace forPosition(Name elementName, int depth, ElementPosition position) {
			return null;
		}
	};
	
	enum DocPosition {	after_version,
						after_dtd,
						after_root,
						after_comment,
						after_pi,
						before_close}
	
	enum ElementPosition {	before_element,
							between_attributes,
							after_attributes,
							after_start,
							after_empty,
							before_end,
							after_end}

	// *** Public Methods ***
	
	public Whitespace forPosition(DocPosition position);
	
	public Whitespace forPosition(Name elementName, int depth, ElementPosition position);
}










/* end */
