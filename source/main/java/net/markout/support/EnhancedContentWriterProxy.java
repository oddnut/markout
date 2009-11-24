/*
	EnhancedContentWriterProxy.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.support;

import net.markout.ContentWriter;

/**
 * EnhancedContentWriterProxy
 * 
 * Comment here.
 */
public class EnhancedContentWriterProxy extends ContentWriterProxy implements EnhancedContentWriter {
	// *** Class Members ***

	// *** Instance Members ***

	// *** Constructors ***
	public EnhancedContentWriterProxy(EnhancedContentWriter target) {
		super(target);
	}

	// *** Interface Methods ***

	// *** Public Methods ***
	
	public <T extends ContentWriter> T as(Class<T> enhancedType) {
		return ((EnhancedContentWriter) target).as(enhancedType);
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}
