/*
	AttValueWriter.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.types;

// *** imports ***

import java.io.*;
import java.util.HashSet;
import java.util.Set;

import net.markout.IllegalXMLCharacterException;
import net.markout.XML;

/**
 * AttValueWriter
 *
 * Comment here.  Author: David Fogel
 */
public class AttValueWriter extends Writer {
	// *** Class Members ***

	// *** Instance Members ***
	
	private CharArrayWriter theChars;
	
	private char theOuterQ;
	private char theInnerQ;
	
	private Set<Name> theEntityRefs;

	// *** Constructors ***
	
	public AttValueWriter() {
		theChars = new CharArrayWriter();
		theOuterQ = 0;
		theInnerQ = 0;
		theEntityRefs = null;
	}
	
	// *** Writer Methods ***
	
	public void write(char cbuf[], int offset, int length) throws IOException {
		
		int end = offset + length;
		if (offset < 0 ||
			offset > cbuf.length ||
			length < 0 ||
			end > cbuf.length)
			throw new IndexOutOfBoundsException("offset and length are invalid for buffer");
		
		for (int i = 0 ; i < end ; i++) {
			
			char c = cbuf[i];
			
			if ( ! XMLChar.isXMLChar(c))
				throw new IllegalXMLCharacterException(c);
			
			if (c == '&') {
				
				XML.AMPERSAND_REF.writeTo(theChars);
				
			} else if (c == '<') {
				
				XML.LESS_THAN_REF.writeTo(theChars);
				
			} else if (c == theOuterQ) { // we need to escape the quote being used for
										// enclosing the attribute value, whichever it is.
				if (c == '"')
					XML.DOUBLE_QUOTE_REF.writeTo(theChars);
				else
					XML.SINGLE_QUOTE_REF.writeTo(theChars);
				
			} else {
				
				if (c == '"' && theInnerQ == 0) {
					theInnerQ = '"';
					theOuterQ = '\'';
				} else if (c == '\'' && theInnerQ == 0) {
					theInnerQ = '\'';
					theOuterQ = '"';
				}
				
				theChars.write(c);
			}
		}
	}
	
	public void write(String str, int offset, int length) throws IOException {
		int strlen = str.length();
		int end = offset + length;
		if (offset < 0 ||
				offset > strlen ||
				length < 0 ||
				end > strlen)
			throw new IndexOutOfBoundsException("offset and length are invalid for string");
		
		for (int i = 0 ; i < end ; i++) {
			
			char c = str.charAt(i);
			
			if ( ! XMLChar.isXMLChar(c))
				throw new IllegalXMLCharacterException(c);
			
			if (c == '&') {
				
				XML.AMPERSAND_REF.writeTo(theChars);
				
			} else if (c == '<') {
				
				XML.LESS_THAN_REF.writeTo(theChars);
				
			} else if (c == theOuterQ) { // we need to escape the quote being used for
				// enclosing the attribute value, whichever it is.
				if (c == '"')
					XML.DOUBLE_QUOTE_REF.writeTo(theChars);
				else
					XML.SINGLE_QUOTE_REF.writeTo(theChars);
				
			} else {
				
				if (c == '"' && theInnerQ == 0) {
					theInnerQ = '"';
					theOuterQ = '\'';
				} else if (c == '\'' && theInnerQ == 0) {
					theInnerQ = '\'';
					theOuterQ = '"';
				}
				
				theChars.write(c);
			}
		}
	}
	
	public void flush() throws IOException {
		// does nothing
	}
	
	public void close() throws IOException {
		// does nothing.
	}

	// *** Public Methods ***
	
	public AttValue toAttValue() {
		String value = theChars.toString();
		return new AttValue(value, theOuterQ != 0 ? theOuterQ : '"', theEntityRefs);
	}
	
	public void reset() {
		theChars.reset();
		theOuterQ = 0;
		theInnerQ = 0;
	}
	
	public void reference(CharRef charRef) throws IOException {
		charRef.writeTo(theChars);
	}
	
	public void reference(Name entityName) throws IOException {
		// keep track of which entities we add so we can validate them at elementWriter.attribute() time.
		if (theEntityRefs == null)
			theEntityRefs = new HashSet<Name>();
		theEntityRefs.add(entityName);
		
		entityName.writeTo(theChars);
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










/* end */
