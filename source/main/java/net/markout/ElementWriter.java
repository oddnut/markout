/*
	ElementWriter.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout;

import java.io.IOException;
import java.util.List;

import net.markout.types.*;

/**
 * ElementWriter
 *
 * Comment here.  Author: David Fogel
 */
public interface ElementWriter {
	// *** Class Members ***

	// *** Public Methods ***
	
	// --- Writer State ---
	public List<Name> getElementNameStack();
	
	// --- Attributes ---
	public void attributes(Attributes attributes) throws IOException;
	public void attribute(Name name, AttValue value) throws IOException;
	public void space(Whitespace space) throws IOException;
	
	// --- Content ---
	public ContentWriter content() throws IOException;
	
	// --- Closing (optional) ---
	public void close() throws IOException;
}










// end
