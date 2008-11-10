/*
	ArrayXMLChunkWriter.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.support;

// *** imports ***

import java.io.IOException;
import java.util.ArrayList;

import net.markout.types.XMLChunk;
import net.markout.types.XMLString;

/**
 * ArrayXMLChunkWriter
 *
 * Comment here.  Author: David Fogel
 */
public class ArrayXMLChunkWriter extends XMLChunkWriter {
	// *** Class Members ***

	// *** Instance Members ***
	private ArrayList<XMLChunk> theChunks;

	// *** Constructors ***
	public ArrayXMLChunkWriter() {
		theChunks = new ArrayList<XMLChunk>();
	}

	// *** XMLChunkwriter Methods ***
	
	public void write(XMLChunk chunk) throws IOException {
		theChunks.add(chunk);
	}
	
	public void write(XMLChunk[] chunks) throws IOException {
		for (int i = 0 ; i < chunks.length ; i++)
			theChunks.add(chunks[i]);
	}
	
	public void write(XMLChunk[] chunks, int offset, int length) throws IOException {
		if (offset < 0 ||
			offset > chunks.length ||
			length < 0 ||
			(offset + length) > chunks.length)
			throw new IndexOutOfBoundsException("offset and length are invalid for buffer");
		
		int end = offset + length;
		for (int i = offset ; i < end ; i++)
			theChunks.add(chunks[i]);
	}
	
	public void write(char cbuf[], int offset, int length) throws IOException {
		theChunks.add(new XMLString(new String(cbuf, offset, length)));
	}
	
	public void flush() throws IOException {
		// nothing to do.
	}
	
	public void close() throws IOException {
		// nothing to do.
	}

	// *** Public Methods ***
	
	public XMLChunk[] toXMLChunkArray() {
		return theChunks.toArray(new XMLChunk[theChunks.size()]);
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










/* end */
