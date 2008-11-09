/*
	OSXMLChunkWriter.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.support;

// *** imports ***

import java.io.*;
import java.nio.charset.Charset;

import net.markout.types.XMLChunk;

/**
 * OSXMLChunkWriter
 *
 * Comment here.  Author: David Fogel
 */
public class OSXMLChunkWriter extends XMLChunkWriter {
	// *** Class Members ***
	
	public static final String DEFAULT_CHARSET_NAME = "UTF-8";
	
	//private static final int MAX_LENGTH_FOR_CACHE = 1000;

	// *** Instance Members ***
	
	private OutputStream theOut;
	
	private int theCharsetIndex;
	
	private Writer theDirectWriter;
	
	private boolean needsDirectFlush;
	
	private ByteArrayOutputStream theBAOS;
	
	private Writer theCacheWriter;

	// *** Constructors ***
	
	public OSXMLChunkWriter(OutputStream out) throws IOException {
		this(out, DEFAULT_CHARSET_NAME);
	}
	
	public OSXMLChunkWriter(OutputStream out, String charsetName) throws IOException {
		super(out);
		
		theOut = out;
		
		theCharsetIndex = XMLChunk.indexOf(Charset.forName(charsetName));
		
		// TODO - figure out if it was safe to get rid of the BufferedWriter.  it's a bit faster, 
		// but mainly will use less memory when we scale up.
		//theDirectWriter = new BufferedWriter(new OutputStreamWriter(theOut, charsetName));
		//theDirectWriter = new BufferedWriter(new OutputStreamWriter(theOut, charsetName), 1024);
		theDirectWriter = new OutputStreamWriter(theOut, charsetName);
		needsDirectFlush = false;
		
		theBAOS = new ByteArrayOutputStream();
		
		theCacheWriter = new OutputStreamWriter(theBAOS, charsetName);
	}

	// *** XMLChunkWriter Methods ***
	
	public void write(XMLChunk chunk) throws IOException {
		
		checkOpen();
		
		byte[] bytes = chunk.getBytes(theCharsetIndex);
		
		if (bytes == null) {
			
			theBAOS.reset();
			chunk.writeTo(theCacheWriter);
			theCacheWriter.flush();
			
			bytes = theBAOS.toByteArray();
			
			chunk.setBytes(theCharsetIndex, bytes);
		}
		
		if (needsDirectFlush) {
			theDirectWriter.flush();
			needsDirectFlush = false;
		}
		
		theOut.write(bytes, 0, bytes.length);
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
		
		int end = offset + length;
		for (int i = offset ; i < end ; i++) {
			
			XMLChunk chunk = chunks[i];
			
			byte[] bytes = chunk.getBytes(theCharsetIndex);
			
			if (bytes == null) {
				
				theBAOS.reset();
				chunk.writeTo(theCacheWriter);
				theCacheWriter.flush();
				
				bytes = theBAOS.toByteArray();
				
				chunk.setBytes(theCharsetIndex, bytes);
			}
			
			if (needsDirectFlush) {
				theDirectWriter.flush();
				needsDirectFlush = false;
			}
			
			theOut.write(bytes, 0, bytes.length);
		}
	}
	
	public void write(char cbuf[], int off, int len) throws IOException {
		
		checkOpen();
		
		theDirectWriter.write(cbuf, off, len);
		needsDirectFlush = true;
	}
	
	public void flush() throws IOException {
		
		checkOpen();
		
		if (needsDirectFlush) {
			theDirectWriter.flush();
			needsDirectFlush = false;
		}
		
		theOut.flush();
		
	}
	
	public void close() throws IOException {
		
		if (theOut == null)
			return;
		
		if (needsDirectFlush) {
			theDirectWriter.flush();
			needsDirectFlush = false;
		}
		
		theDirectWriter = null;
		
		theOut.close();
		
		theOut = null;
	}

	// *** Public Methods ***

	// *** Protected Methods ***
	
	protected void checkOpen() throws IOException {
		if (theOut == null)
			throw new IOException("OutputStream already closed");
	}

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










// end
