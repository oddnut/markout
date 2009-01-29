/*
	AttValue.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.types;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.Writer;

import net.markout.IllegalXMLCharacterException;
import net.markout.XML;

/**
 * AttValue
 * 
 * Comment here.
 */
public abstract class AttValue extends XMLChunk {
	// *** Class Members ***
	public enum QuoteType {
		DOUBLE(XMLChar.DOUBLE_QUOTE_CHAR, XML.DOUBLE_QUOTE_REF),
		SINGLE(XMLChar.SINGLE_QUOTE_CHAR, XML.SINGLE_QUOTE_REF);
		
		private XMLChar quoteChar;
		private CharRef quoteRef;
		QuoteType(XMLChar quoteChar, CharRef quoteRef) {
			this.quoteChar = quoteChar;
			this.quoteRef = quoteRef;
		}
		public XMLChar getQuoteChar() {return quoteChar;}
		public boolean matchesChar(char c) {return quoteChar.getChar() == c;}
		public CharRef getQuoteRef() {return quoteRef;}
	}

	// *** Instance Members ***
	protected String value;
	protected QuoteType quoteType;

	// *** Constructors ***
	AttValue() {} // for package use only
	
	AttValue(String text, QuoteType quoteType) {
		this.quoteType = quoteType;
		if (quoteType == null)
			throw new IllegalArgumentException("the QuoteType parameter may not be null");
		this.value = parse(text);
	}
	
	// *** Object Methods ***
	public String toString() {
		char q = quoteType.getQuoteChar().getChar();
		return new StringBuilder().append(q).append(value).append(q).toString();
	}
	
	public boolean equals(Object o) {
		if (o == null || !(o instanceof AttValue))
			return false;
		AttValue a = (AttValue) o;
		return value.equals(a.value);
	}
	
	public int hashCode() {
		return value.hashCode();
	}

	// *** XMLChunk Methods ***
	public void writeTo(Writer out) throws IOException {
		out.write(value);
	}

	// *** Public Methods ***
	public String getValueString() {return value;}
	
	public QuoteType getQuoteType() {return quoteType;}
	
	public XMLChar getQuoteChar() {return quoteType.getQuoteChar();}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***
	
	/**
	 * Parses the text, escaping markup delimeters and outer quotes.
	 * Uses the original string unless it encounter something which
	 * needs escaping, at which point it copies everything to a 
	 * buffer from then on.
	 */
	private String parse(String text) {
		
		int length = text.length();
		CharArrayWriter cOut = null;
		char outerQ = quoteType.getQuoteChar().getChar();
		
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
				quoteType.getQuoteRef().writeTo(cOut);
				
			} else {
				
				if (cOut != null)
					cOut.write(c);
			}
		}
		} catch (IOException ioe) {
			// This actually can't happen, since we're using the CharArrayWriter,
			// however, calling writeTo() on the CharRefs declares IOException,
			// so we have to catch it.
		}
		
		return cOut != null ? cOut.toString() : text;
	}

	// *** Private Classes ***
}
