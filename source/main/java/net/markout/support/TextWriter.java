/*
	TextWriter.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.support;

// *** imports ***

import java.io.IOException;
import java.io.Writer;

import net.markout.IllegalXMLCharacterException;
import net.markout.XML;
import net.markout.types.XMLChar;

/**
 * TextWriter
 *
 * Comment here.  Author: David Fogel
 */
class TextWriter extends Writer {
	// *** Class Members ***
	
	private static final int BUFFER_SIZE = 1024; // probably this is more than enough, 
													// since we're sure to have down-stream buffering.

	// *** Instance Members ***
	
	private XMLChunkWriter theWriter;
	
	private char[] theBuffer;
	private int theNext;
	
	private boolean isOpen;

	// *** Constructors ***
	
	public TextWriter(XMLChunkWriter writer) {
		super(writer);
		theWriter = writer;
		theBuffer = new char[BUFFER_SIZE];
		theNext = 0;
		isOpen = false;
	}

	// *** Writer Methods ***
	
	public void write(char c) throws IOException {
		
		checkOpen();
		
		if ( ! XMLChar.isXMLChar(c))
			throw new IllegalXMLCharacterException(c);
		
		if (c == '&') {
			
			flushBuffer();
			theWriter.write(XML.AMPERSAND_REF);
			
		} else if (c == '<') {
			
			flushBuffer();
			theWriter.write(XML.LESS_THAN_REF);
			
		} else if (c == '>') { // this gets us out of having to check for "]]>"...
			
			flushBuffer();
			theWriter.write(XML.GREATER_THAN_REF);
			
		} else {
		
			if (theNext >= theBuffer.length)
				flushBuffer();
			theBuffer[theNext] = c;
			theNext++;
		}
	}
	
	public void write(char cbuf[], int offset, int length) throws IOException {
		
		checkOpen();
		
		if (offset < 0 ||
				offset > cbuf.length ||
				length < 0 ||
				(offset + length) > cbuf.length)
			throw new IndexOutOfBoundsException("offset and length are invalid for buffer");
		
		if (length == 0)
			return;
		
		int end = offset + length;
		for (int i = offset ; i < end ; i++) {
			
			char c = cbuf[i];
			
			if ( ! XMLChar.isXMLChar(c))
				throw new IllegalXMLCharacterException(c);
			
			if (c == '&') {
				
				flushBuffer();
				theWriter.write(XML.AMPERSAND_REF);
				
			} else if (c == '<') {
				
				flushBuffer();
				theWriter.write(XML.LESS_THAN_REF);
				
			} else if (c == '>') { // this gets us out of having to check for "]]>"...
				
				flushBuffer();
				theWriter.write(XML.GREATER_THAN_REF);
				
			} else {
				
				if (theNext >= theBuffer.length)
					flushBuffer();
				theBuffer[theNext] = c;
				theNext++;
			}
		}
	}
	
	public void write(String s, int offset, int length) throws IOException {
		
		checkOpen();
		
		int sl = s.length();
		
		if (offset < 0 ||
				offset > sl ||
				length < 0 ||
				(offset + length) > sl)
			throw new IndexOutOfBoundsException("offset and length are invalid for String");
		
		if (length == 0)
			return;
		
		int end = offset + length;
		for (int i = offset ; i < end ; i++) {
			
			char c = s.charAt(i);
			
			if ( ! XMLChar.isXMLChar(c))
				throw new IllegalXMLCharacterException(c);
			
			if (c == '&') {
				
				flushBuffer();
				theWriter.write(XML.AMPERSAND_REF);
				
			} else if (c == '<') {
				
				flushBuffer();
				theWriter.write(XML.LESS_THAN_REF);
				
			} else if (c == '>') { // this gets us out of having to check for "]]>"...
				
				flushBuffer();
				theWriter.write(XML.GREATER_THAN_REF);
				
			} else {
				
				if (theNext >= theBuffer.length)
					flushBuffer();
				theBuffer[theNext] = c;
				theNext++;
			}
		}
	}
	
	public void flush() throws IOException {
		
		checkOpen();
		
		flushBuffer();
		
		//theWriter.flush(); //  maybe we shouldn't call flush() on the writer here..?
	}
	
	public void close() throws IOException {
		
		if (!isOpen)
			return;
		
		flushBuffer();
		
		isOpen = false;
	}

	// *** Public Methods ***
	
	public void open() {
		
		isOpen = true;
	}
	
	public void flushBuffer() throws IOException {
		if (theNext == 0)
			return;
		theWriter.write(theBuffer, 0, theNext);
		theNext = 0;
	}

	// *** Protected Methods ***
	
	// *** Package Methods ***

	// *** Private Methods ***
	
	private void checkOpen() throws IOException {
		if (!isOpen)
			throw new IOException("Text writer is closed");
	}

	// *** Private Classes ***
}










// end
