/*
	ElementWriter.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.support;

import java.io.IOException;
import java.util.List;

import net.markout.ContentWriter;
import net.markout.types.Attribute;
import net.markout.types.Name;

/**
 * ElementWriter
 * 
 * Comment here.
 */
public interface ElementWriter extends ContentWriter {
	// *** Class Members ***

	// *** Interface Methods ***
	
	// --- Namespace ---
	public void prepareNamespace(Namespace parentNamespace);
	
	// --- Opening ---
	public void open(Name elementName) throws IOException;
	public void open(Name elementName, List<Name> parentElementNames) throws IOException;
	
	// --- Attributes ---
	public void attribute(Attribute att) throws IOException;
	
	// --- Closing ---
	public void close() throws IOException;
}
