/*
	AttValue.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.types;

// *** imports ***

import java.io.*;
import java.util.Collection;

import net.markout.IllegalXMLCharacterException;
import net.markout.XML;

/**
 * AttValue
 *
 * Comment here.  Author: David Fogel
 */
public class AttValue extends XMLChunk implements Comparable {
	// *** Class Members ***

	// *** Instance Members ***
	
	private String theValue;
	
	private char theQuoteChar;
	
	private Name[] theEntityRefs;

	// *** Constructors ***
	
	public AttValue(String text) {
		theQuoteChar = '"';
		theEntityRefs = null;
		parse(text);
	}
	
	AttValue(String text, char quoteChar, Collection entityRefs) {
		theQuoteChar = quoteChar;
		theValue = text;
		
		if (entityRefs != null && entityRefs.size() > 0)
			theEntityRefs = (Name[]) entityRefs.toArray(new Name[entityRefs.size()]);
		else
			theEntityRefs = null;
	}
	
	// *** Object Methods ***
	
	public boolean equals(Object o) {
		if (o == null || !(o instanceof AttValue))
			return false;
		return theValue.equals(((AttValue)o).theValue);
	}
	
	public int hashCode() {
		return theValue.hashCode();
	}
	
	public String toString() {
		//String q = String.valueOf(theQuoteChar);
		//return q + theValue + q;
		return theValue;
	}
	
	// *** Comparable Methods ***
	
	public int compareTo(Object o) {
		return theValue.compareTo(((AttValue)o).theValue);
	}

	// *** XMLChunk Methods ***
	
	public void writeTo(Writer out) throws IOException {
		out.write(theQuoteChar);
		out.write(theValue);
		out.write(theQuoteChar);
	}

	// *** Public Methods ***
	// TODO - lets get rid of this...
	public String getUnquotedValue() {
		return theValue;
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***
	
	/**
	 * Parses the text, escaping markup delimeters and outer quotes.
	 * Uses the original string unless it encounter something which
	 * needs escaping, at which point it copies everything to a 
	 * buffer from then on.
	 */
	private final void parse(String text) {
		
		int length = text.length();
		CharArrayWriter cOut = null;
		char outerQ = 0;
		char innerQ = 0;
		
		try {
		for (int i = 0 ; i < length ; i++) {
			
			char c = text.charAt(i);
			
			if ( ! XMLChar.isXMLChar(c))
				throw new IllegalXMLCharacterException(c);
			
			if (c == '&') {
				
				if (cOut == null) {
					cOut = new CharArrayWriter();
					cOut.write(text, 0, i);
				}
				XML.AMPERSAND_REF.writeTo(cOut);
				
			} else if (c == '<') {
				
				if (cOut == null) {
					cOut = new CharArrayWriter();
					cOut.write(text, 0, i);
				}
				XML.LESS_THAN_REF.writeTo(cOut);
				
			} else if (c == outerQ) { // we need to escape the quote being used for
										// enclosing the attribute value, whichever it is.
				if (cOut == null) {
					cOut = new CharArrayWriter();
					cOut.write(text, 0, i);
				}
				if (c == '"')
					XML.DOUBLE_QUOTE_REF.writeTo(cOut);
				else
					XML.SINGLE_QUOTE_REF.writeTo(cOut);
				
			} else {
				
				if (c == '"' && innerQ == 0) {
					innerQ = '"';
					outerQ = '\'';
				} else if (c == '\'' && innerQ == 0) {
					innerQ = '\'';
					outerQ = '"';
				}
				
				if (cOut != null)
					cOut.write(c);
			}
		}
		} catch (IOException ioe) {
			// This actually can't happen, since we're using the CharArrayWriter,
			// however, calling writeTo() on the CharRefs declares IOException,
			// so we have to catch it.
		}
		
		theQuoteChar = outerQ != 0 ? outerQ : '"';
		theValue = cOut != null ? cOut.toString() : text;
	}

	// *** Private Classes ***
}










// end
