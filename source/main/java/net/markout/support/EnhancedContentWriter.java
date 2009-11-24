/*
	EnhancedContentWriter.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.support;

import net.markout.ContentWriter;

/**
 * EnhancedContentWriter
 * 
 * Comment here.
 */
public interface EnhancedContentWriter extends ContentWriter {
	// *** Class Members ***

	// *** Interface Methods ***
	public <T extends ContentWriter> T as(Class<T> enhancedType);
}
