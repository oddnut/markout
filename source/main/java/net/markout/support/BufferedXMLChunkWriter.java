/*
	BufferedXMLChunkWriter.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.support;

// *** imports ***

import java.io.IOException;

import net.markout.types.XMLChunk;

/**
 * BufferedXMLChunkWriter
 *
 * Comment here.  Author: David Fogel
 */
public class BufferedXMLChunkWriter extends XMLChunkWriter{
	// *** Class Members ***
	
	public final static int DEFAULT_BUFFER_SIZE = 1000; // is this good?

	// *** Instance Members ***
	private XMLChunk[] theBuffer;
	private int theNext;
	
	private XMLChunkWriter theWriter;

	// *** Constructors ***
	public BufferedXMLChunkWriter(XMLChunkWriter out) {
		this(out, DEFAULT_BUFFER_SIZE);
	}
	
	public BufferedXMLChunkWriter(XMLChunkWriter out, int bufferSize) {
		super(out);
		
		if (bufferSize < 1)
			throw new IllegalArgumentException("Buffer size can't be < 1");
		
		theBuffer = new XMLChunk[bufferSize];
		theNext = 0;
		
		theWriter = out;
	}

	// *** XMLChunkWriter Methods ***
	
	public void write(XMLChunk chunk) throws IOException {
		checkOpen();
		
		if (theNext >= theBuffer.length)
			flushBuffer();
		
		theBuffer[theNext] = chunk;
		theNext++;
	}
	
	public void write(XMLChunk[] chunks) throws IOException {
		write(chunks, 0, chunks.length);
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
		
		if (length >= theBuffer.length) {
			// just go direct to wrapped writer
			flushBuffer();
			theWriter.write(chunks, offset, length);
			return;
		}
		
		// could probably get slightly faster with a System.arrayCopy(), but really
		// it's unlikely that anyone will call this with more than a handful of XMLChunks...?
		int end = offset + length;
		for (int i = offset ; i < end ; i++) {
			
			if (theNext >= theBuffer.length)
				flushBuffer();
			
			theBuffer[theNext] = chunks[i];
			theNext++;
		}
	}
	
	public void write(char cbuf[], int off, int len) throws IOException {
		
		flushBuffer();
		
		theWriter.write(cbuf, off, len);
	}
	
	public void flush() throws IOException {
		checkOpen();
		
		flushBuffer();
		
		theWriter.flush();
	}
	
	public void close() throws IOException {
		
		if (theWriter == null)
			return;
		
		flushBuffer();
		
		theWriter.close();
		
		theWriter = null;
	}

	// *** Public Methods ***
	
	public void reset(XMLChunkWriter out) {
		theWriter = out;
		theNext = 0;
	}

	// *** Protected Methods ***
	
	protected void checkOpen() throws IOException {
		if (theWriter == null)
			throw new IOException("XMLChunkWriter already closed");
	}
	
	protected void flushBuffer() throws IOException {
		checkOpen();
		if (theNext == 0)
			return;
		theWriter.write(theBuffer, 0, theNext);
		theNext = 0;
	}

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










// end
