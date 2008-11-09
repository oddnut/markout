/*
	XMLChunkWriter.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.support;

// *** imports ***

import java.io.IOException;
import java.io.Writer;

import net.markout.types.XMLChunk;

/**
 * XMLChunkWriter
 *
 * Comment here.  Author: David Fogel
 */
public abstract class XMLChunkWriter extends Writer {
	// *** Class Members ***
	
	// *** Constructors ***
	
	public XMLChunkWriter() {
		
	}
	
	public XMLChunkWriter(Object lock) {
		super(lock);
	}

	// *** Public Methods ***
	
	abstract public void write(XMLChunk chunk) throws IOException;
	
	abstract public void write(XMLChunk[] chunks) throws IOException;
	
	abstract public void write(XMLChunk[] chunks, int offset, int length) throws IOException;

}










// end
