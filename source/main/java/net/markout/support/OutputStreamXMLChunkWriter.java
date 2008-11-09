/*
	OutputStreamXMLChunkWriter.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.support;

// *** imports ***

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

import net.markout.types.XMLChunk;

/**
 * OutputStreamXMLChunkWriter
 *
 * Comment here.  Author: David Fogel
 */
public class OutputStreamXMLChunkWriter extends XMLChunkWriter {
	// *** Class Members ***
	
	public static final String DEFAULT_CHARSET_NAME = "UTF-8";
	
	private static final int DEFAULT_CHAR_BUFFER_SIZE = 1000;
	
	//private static final int MAX_LENGTH_FOR_CACHE = 1000;

	// *** Instance Members ***
	
	private OutputStream theOut;
	private CharsetEncoder theEncoder;
	
	private int theCharsetIndex;
	
	private CustomCharArrayWriter theCAWriter;
	
	private Writer theDirectWriter;
	private boolean needsDirectFlush;

	// *** Constructors ***
	
	public OutputStreamXMLChunkWriter(OutputStream out) {
		this(out, DEFAULT_CHARSET_NAME);
	}
	
	public OutputStreamXMLChunkWriter(OutputStream out, String charsetName) {
		this(out, Charset.forName(charsetName).newEncoder());
	}
	
	public OutputStreamXMLChunkWriter(OutputStream out, CharsetEncoder encoder) {
		super(out);
		
		theOut = out;
		theEncoder = encoder;
		theEncoder.reset();
		
		theCharsetIndex = XMLChunk.indexOf(encoder.charset());
		
		theCAWriter = new CustomCharArrayWriter(DEFAULT_CHAR_BUFFER_SIZE);
		
		// TODO - figure out if it was safe to get rid of the BufferedWriter.  it's a bit faster, 
		// but mainly will use less memory when we scale up.
		//theDirectWriter = new BufferedWriter(new OutputStreamWriter(theOut, theEncoder.charset().newEncoder()));
		theDirectWriter = new OutputStreamWriter(theOut, theEncoder.charset().newEncoder());
		needsDirectFlush = false;
	}

	// *** XMLChunkWriter Methods ***
	
	public void write(XMLChunk chunk) throws IOException {
		
		checkOpen();
		
		byte[] bytes = chunk.getBytes(theCharsetIndex);
		
		if (bytes == null) {
			
			theCAWriter.reset();
			chunk.writeTo(theCAWriter);
			CharBuffer cb = CharBuffer.wrap(theCAWriter.getBuffer(), 0 , theCAWriter.size());
			
			ByteBuffer bb = theEncoder.encode(cb);
			
			bytes = bb.array();
			
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
				
				theCAWriter.reset();
				chunk.writeTo(theCAWriter);
				CharBuffer cb = CharBuffer.wrap(theCAWriter.getBuffer(), 0 , theCAWriter.size());
				
				ByteBuffer bb = theEncoder.encode(cb);
				
				bytes = bb.array();
				
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
		
		// TODO this isn't quite right...
		theDirectWriter.write(cbuf, off, len);
		needsDirectFlush = true;
		return;
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
		
		theDirectWriter.close(); // should close theOut.
		
		theDirectWriter = null;
		
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
	
	private static class CustomCharArrayWriter extends CharArrayWriter {
		
		public CustomCharArrayWriter(int initialSize) {
			super(initialSize);
		}
		
		public char[] getBuffer() {
			return buf;
		}
	}
}










// end
