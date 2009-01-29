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

import net.markout.support.*;
import net.markout.types.CharRef;

/**
 * XML
 *
 * Comment here.  Author: David Fogel
 */
public class XML {
	// *** Class Members ***
	public static final CharRef AMPERSAND_REF = new CharRef('&');
	public static final CharRef PERCENT_REF = new CharRef('%');
	public static final CharRef LESS_THAN_REF = new CharRef('<');
	public static final CharRef GREATER_THAN_REF = new CharRef('>');
	public static final CharRef SINGLE_QUOTE_REF = new CharRef('\'');
	public static final CharRef DOUBLE_QUOTE_REF = new CharRef('"');

	// *** Instance Members ***

	// *** Constructors ***

	// *** Interface Methods ***

	// *** Public Methods ***
	
	public static DocumentWriter documentWriter(Writer dest) throws IOException {
		
		return new BasicDocumentWriter(new WriterXMLChunkWriter(dest));
	}
	
	public static DocumentWriter documentWriter(OutputStream dest) throws IOException {
		
		return new BasicDocumentWriter(new OSXMLChunkWriter(dest));
	}
	
	public static DocumentWriter documentWriter(OutputStream dest, String charsetName) throws IOException {
		
		return new BasicDocumentWriter(new OSXMLChunkWriter(dest, charsetName));
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










// end
