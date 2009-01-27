/*
	Attribute.java

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
 * Attribute
 * 
 * Comment here.
 */
public class Attribute extends XMLChunk implements Comparable<Attribute>{
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
	private Name name;
	
	private String value;
	
	private QuoteType quoteType;

	// *** Constructors ***
	public Attribute(Name name, String text) {
		this(name, text, QuoteType.DOUBLE);
	}
	
	public Attribute(Name name, String text, QuoteType quoteType) {
		this.name = name;
		this.quoteType = quoteType;
		if (quoteType == null)
			throw new IllegalArgumentException("the QuoteType parameter may not be null");
		this.value = parse(text);
	}
	
	Attribute() {} // for package use only

	// *** Object Methods ***
	public String toString() {
		char q = quoteType.getQuoteChar().getChar();
		return name.toString() + "=" + q + value.toString() + q;
	}
	
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Attribute))
			return false;
		Attribute a = (Attribute) o;
		return name.equals(a.name) && value.equals(a.value);
	}
	
	public int hashCode() {
		return name.hashCode() ^ value.hashCode();
	}
	
	// *** Comparable Methods ***
	public int compareTo(Attribute o) {
		int c = name.compareTo(o.name);
		if (c == 0)
			c = value.compareTo(o.value);
		return c;
	}
	
	// *** XMLChunk Methods ***
	public void writeTo(Writer out) throws IOException {
		out.write(value);
	}

	// *** Public Methods ***
	public Name getName() {return name;}

	public String getValueString() {return value;}
	
	public QuoteType getQuoteType() {return quoteType;}
	
	public XMLChar getQuoteChar() {return quoteType.getQuoteChar();}

	// *** Protected Methods ***

	// *** Package Methods ***
	static Attribute createAttribtueForPreparsedValue(Name name, String value, QuoteType quoteType) {
		Attribute result = new Attribute();
		result.name = name;
		result.value = value;
		result.quoteType = quoteType;
		return result;
	}

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
