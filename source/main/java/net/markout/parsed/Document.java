/*
	Document

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.parsed;

import java.io.IOException;

import net.markout.ContentWriter;

/**
 * ParsedXML
 * 
 * Comment here.
 */
public interface Document {
	// *** Class Members ***

	// *** Interface Methods ***
	public void writeTo(ContentWriter out, ContentSelector selector) throws IOException;
}
