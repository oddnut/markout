/*
	Document

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.parsed;

import java.io.IOException;

import net.markout.ContentWriter;
import net.markout.types.NamespaceURI;

/**
 * ParsedXML
 * 
 * Comment here.
 */
public interface Document {
	// *** Class Members ***

	// *** Interface Methods ***
	public void writeTo(ContentWriter out) throws IOException;
	public void writeTo(ContentWriter out, String xpath) throws IOException;
	public void writeTo(ContentWriter out, String xpath, NamespaceURI... namespaceURIs) throws IOException;
}
