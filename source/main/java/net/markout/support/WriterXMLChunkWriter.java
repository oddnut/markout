/*
	WriterXMLChunkWriter.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.support;

import java.io.IOException;
import java.io.Writer;

import net.markout.types.XMLChunk;

/**
 * WriterXMLChunkWriter
 *
 * Comment here.  Author: David Fogel
 */
public class WriterXMLChunkWriter extends XMLChunkWriter {
	// *** Class Members ***

	// *** Instance Members ***
	
	private Writer theWriter;

	// *** Constructors ***
	
	public WriterXMLChunkWriter(Writer out) {
		super(out);
		theWriter = out;
	}

	// *** XMLChunkWriter Methods ***
	
	public void write(XMLChunk chunk) throws IOException {
		
		checkOpen();
		
		chunk.writeTo(theWriter);
	}
	
	public void write(XMLChunk[] chunks) throws IOException {
		
		checkOpen();
		
		for (int i = 0 ; i < chunks.length ; i++)
			chunks[i].writeTo(theWriter);
	}
	
	public void write(XMLChunk[] chunks, int offset, int length) throws IOException {
		
		checkOpen();
		
		if (offset < 0 ||
				offset > chunks.length ||
				length < 0 ||
				(offset + length) > chunks.length)
			throw new IndexOutOfBoundsException("offset and length are invalid for buffer");
		
		if (length == 0)
			return;

		int end = offset + length;
		for (int i = offset ; i < end ; i++) {
			
			chunks[i].writeTo(theWriter);
		}
	}
	
	public void write(char cbuf[], int off, int len) throws IOException {
		
		checkOpen();
		
		theWriter.write(cbuf, off, len);
	}

	public void flush() throws IOException {
		
		checkOpen();
		
		theWriter.flush();
	}

	public void close() throws IOException {
		
		if (theWriter == null)
			return;
		
		theWriter.close();
		
		theWriter = null;
	}
	
	// *** Public Methods ***

	// *** Protected Methods ***
	
	protected void checkOpen() throws IOException {
		if (theWriter == null)
			throw new IOException("Writer already closed");
	}

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***

}










// end
