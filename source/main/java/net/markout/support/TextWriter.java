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

import net.markout.*;
import net.markout.types.XMLChar;
import net.markout.types.XMLString;

/**
 * TextWriter
 *
 * Comment here.  Author: David Fogel
 */
class TextWriter extends Writer {
	// *** Class Members ***
	public enum Mode {text, cdata}
	
	private static final int BUFFER_SIZE = 1024; // probably this is more than enough, 
													// since we're sure to have down-stream buffering.
	
	private static final char[] BAD = "]]>".toCharArray();
	private static final char LAST_BAD = BAD[BAD.length - 1]; // '>'
	
	private static final XMLString CDATA_START = new XMLString("<![CDATA[");
	private static final XMLString CDATA_END = new XMLString("]]>");

	// *** Instance Members ***
	
	private XMLChunkWriter out;
	
	private Mode mode;
	private int badIndex;
	
	private char[] buf;
	private int next;
	
	private boolean isOpen;

	// *** Constructors ***
	
	public TextWriter(XMLChunkWriter out) {
		super(out);
		this.out = out;
		buf = new char[BUFFER_SIZE];
		next = 0;
		isOpen = false;
		mode = Mode.text;
	}

	// *** Writer Methods ***
	
	public void write(int c) throws IOException {
		
		checkOpen();
		
		if (mode == Mode.text)
			processTextChar((char)c);
		else // mode == Mode.cdata
			processCDataChar((char)c);
	}
	
	public void write(char cbuf[], int offset, int length) throws IOException {
		
		checkOpen();
		
		if (	offset < 0 ||
				offset > cbuf.length ||
				length < 0 ||
				(offset + length) > cbuf.length)
			throw new IndexOutOfBoundsException("offset and length are invalid for buffer");
		
		if (length == 0)
			return;
		
		int end = offset + length;
		
		if (mode == Mode.text)
			for (int i = offset ; i < end ; i++)
				processTextChar(cbuf[i]);
		else // mode == Mode.cdata
			for (int i = offset ; i < end ; i++)
				processCDataChar(cbuf[i]);
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
		
		if (mode == Mode.text)
			for (int i = offset ; i < end ; i++)
				processTextChar(s.charAt(i));
		else // mode == Mode.cdata
			for (int i = offset ; i < end ; i++)
				processCDataChar(s.charAt(i));
	}
	
	public void flush() throws IOException {
		
		checkOpen();
		
		flushBuffer();
		
		//out.flush(); //  maybe we shouldn't call flush() on the writer here..?
	}
	
	public void close() throws IOException {
		
		if (!isOpen)
			return;
		
		flushBuffer();
		
		if (mode == Mode.cdata)
			out.write(CDATA_END);
		
		isOpen = false;
	}

	// *** Public Methods ***
	
	public void open(Mode mode) throws IOException {
		
		if (isOpen)
			throw new IllegalStateException("TextWriter already open");
		
		this.mode = mode;
		badIndex = 0;
		next = 0;
		
		if (mode == Mode.cdata)
			out.write(CDATA_START);
		
		isOpen = true;
	}
	
	public boolean isOpen() {
		
		return isOpen;
	}
	
	public Mode getMode() {return mode;} 
	
	public void flushBuffer() throws IOException {
		if (next == 0)
			return;
		out.write(buf, 0, next);
		next = 0;
	}

	// *** Protected Methods ***
	
	// *** Package Methods ***

	// *** Private Methods ***
	
	private final void checkOpen() throws IOException {
		if (!isOpen)
			throw new IOException("Text writer is closed");
	}
	
	private final void processCDataChar(char c) throws IOException {
		
		XMLChar.checkIsXMLChar((char)c);
		
		// make sure we don't contain the string "]]>"
		if (c == BAD[badIndex]) {
			if (c == LAST_BAD)
				throw new IllegalXMLException("CDATA_END ( ']]>' ) found in text");
			badIndex++;
		} else if (badIndex != 0) // reset the badIndex
			badIndex = 0;
		
		if (next >= buf.length)
			flushBuffer();
		buf[next] = (char) c;
		next++;
	}
	
	private final void processTextChar(char c) throws IOException {
		
		XMLChar.checkIsXMLChar((char)c);
		
		switch (c) {
		case '&':
			flushBuffer();
			out.write(XML.AMPERSAND_REF);
			break;
		case '<':
			flushBuffer();
			out.write(XML.LESS_THAN_REF);
			break;
		case '>':
			flushBuffer();
			out.write(XML.GREATER_THAN_REF);
			break;
		default:
			if (next >= buf.length)
				flushBuffer();
			buf[next] = (char) c;
			next++;
		}
	}

	// *** Private Classes ***
}










// end
