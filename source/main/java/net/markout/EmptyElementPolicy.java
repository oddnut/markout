/*
	EmptyElementPolicy.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout;

import net.markout.types.Name;

/**
 * EmptyElementPolicy
 * 
 * Comment here.
 */
public interface EmptyElementPolicy {
	// *** Class Members ***
	public static EmptyElementPolicy DEFAULT = new EmptyElementPolicy() {
		public boolean isRenderableAsEmptyElement(Name elementName) {
			return true;
		}
		public boolean requiresSpaceBeforeClosing() {
			return false;
		}
	};
	
	public static EmptyElementPolicy DEFAULT_REQUIRES_SPACE = new EmptyElementPolicy() {
		public boolean isRenderableAsEmptyElement(Name elementName) {
			return true;
		}
		public boolean requiresSpaceBeforeClosing() {
			return true;
		}
	};

	// *** Interface Methods ***
	
	public boolean isRenderableAsEmptyElement(Name elementName);
	
	public boolean requiresSpaceBeforeClosing();
}
