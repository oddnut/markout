/*
	XML.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout;

// *** imports ***

import java.io.*;

import net.markout.dtd.DTD;
import net.markout.support.*;
import net.markout.types.CharRef;

/**
 * XML
 *
 * Comment here.  Author: David Fogel
 */
public class XML {
	// *** Class Members ***

	// *** Instance Members ***
	
	public static final CharRef AMPERSAND_REF = new CharRef('&');
	public static final CharRef PERCENT_REF = new CharRef('%');
	public static final CharRef LESS_THAN_REF = new CharRef('<');
	public static final CharRef GREATER_THAN_REF = new CharRef('>');
	public static final CharRef SINGLE_QUOTE_REF = new CharRef('\'');
	public static final CharRef DOUBLE_QUOTE_REF = new CharRef('"');

	// *** Constructors ***

	// *** Interface Methods ***

	// *** Public Methods ***
	
	public static DocumentWriter documentWriter(Writer dest) throws IOException {
		
		return new StandardDocumentWriter(new WriterXMLChunkWriter(dest));
	}
	
	public static DocumentWriter documentWriter(OutputStream dest) throws IOException {
		
		return new StandardDocumentWriter(new OSXMLChunkWriter(dest));
	}
	
	public static DocumentWriter documentWriter(OutputStream dest, String charsetName) throws IOException {
		
		return new StandardDocumentWriter(new OSXMLChunkWriter(dest, charsetName));
	}
	
	public static DocumentWriter documentWriter(Writer dest, DTD dtd) throws IOException {
		
		return new StandardDocumentWriter(new WriterXMLChunkWriter(dest), dtd);
	}
	
	public static DocumentWriter documentWriter(OutputStream dest, DTD dtd) throws IOException {
		
		return new StandardDocumentWriter(new OSXMLChunkWriter(dest), dtd);
	}
	
	public static DocumentWriter documentWriter(OutputStream dest, String charsetName, DTD dtd) throws IOException {
		
		return new StandardDocumentWriter(new OSXMLChunkWriter(dest, charsetName), dtd);
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










// end
