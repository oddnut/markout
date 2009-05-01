/*
	SelectableContent.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.content;

/**
 * SelectableContent
 * 
 * Comment here.
 */
public interface SelectableContent extends Content{
	// *** Class Members ***

	// *** Interface Methods ***
	public Content select(XPath xpath);
}
