/*
	AttributeWriter.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.types;

// *** imports ***

import java.io.*;

import net.markout.IllegalXMLCharacterException;
import net.markout.XML;
import net.markout.types.Attribute.QuoteType;

/**
 * AttributeWriter
 *
 * Comment here.  Author: David Fogel
 */
public class AttributeWriter extends Writer {
	// *** Class Members ***

	// *** Instance Members ***
	private Name name;
	
	private CharArrayWriter chars;
	
	private Attribute.QuoteType quoteType;

	// *** Constructors ***
	
	public AttributeWriter(Name name) {
		this(name, QuoteType.DOUBLE);
	}
	
	public AttributeWriter(Name name, Attribute.QuoteType quoteType) {
		this.name = name;
		this.chars = new CharArrayWriter();
		this.quoteType = quoteType;
		if (quoteType == null)
			throw new IllegalArgumentException("the QuoteType parameter may not be null");
	}
	
	// *** Writer Methods ***
	
	public void write(char[] cbuf, int offset, int length) throws IOException {
		char outerQ = quoteType.getQuoteChar().getChar();
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
				
				XML.AMPERSAND_REF.writeTo(chars);
				
			} else if (c == '<') {
				
				XML.LESS_THAN_REF.writeTo(chars);
				
			} else if (c == outerQ) { // we need to escape the quote being used for
										// enclosing the attribute value, whichever it is.
				quoteType.getQuoteRef().writeTo(chars);
				
			} else {
				
				chars.write(c);
			}
		}
	}
	
	public void write(String str, int offset, int length) throws IOException {
		char outerQ = quoteType.getQuoteChar().getChar();
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
				
				XML.AMPERSAND_REF.writeTo(chars);
				
			} else if (c == '<') {
				
				XML.LESS_THAN_REF.writeTo(chars);
				
			} else if (c == outerQ) { // we need to escape the quote being used for
				// enclosing the attribute value, whichever it is.
				quoteType.getQuoteRef().writeTo(chars);
				
			} else {
				
				chars.write(c);
			}
		}
	}
	
	public void flush() throws IOException {
		// does nothing
	}
	
	public void close() throws IOException {
		flush();
		// does nothing.
	}
	
	// *** Object Methods ***
	public String toString() {
		return toAttribute().toString();
	}

	// *** Public Methods ***
	
	public Attribute toAttribute() {
		String value = chars.toString();
		return Attribute.createAttribtueForPreparsedValue(name, value, quoteType);
	}
	
	public void reset() {
		chars.reset();
	}
	
	public void reference(CharRef charRef) throws IOException {
		charRef.writeTo(chars);
	}
	
	public void reference(Name entityName) throws IOException {
		// keep track of which entities we add so we can validate them at elementWriter.attribute() time.
		//if (theEntityRefs == null)
		//	theEntityRefs = new HashSet<Name>();
		//theEntityRefs.add(entityName);
		
		entityName.writeTo(chars);
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










/* end */
