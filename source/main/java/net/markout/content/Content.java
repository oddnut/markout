/*
	Content.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.content;

import java.io.IOException;

import net.markout.ContentWriter;

/**
 * Content
 * 
 * Comment here.
 */
public interface Content {
	// *** Class Members ***

	// *** Interface Methods ***
	public void writeTo(ContentWriter out) throws IOException;
}
