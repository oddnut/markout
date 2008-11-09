/*
	Text.java
	
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

/**
 * Text
 *
 * Comment here.  Author: David Fogel
 */
public class Text extends XMLChunk {
// *** Class Members ***

	// *** Instance Members ***
	
	private String theValue;

	// *** Constructors ***
	
	public Text(String text) {
		this(text, false);
	}
	
	Text(String text, boolean preparsed) {
		if (!preparsed)
			parse(text);
		else
			theValue = text;
	}
	
	// *** Object Methods ***
	
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Text))
			return false;
		return theValue.equals(((Text)o).theValue);
	}
	
	public int hashCode() {
		return theValue.hashCode();
	}
	
	public String toString() {
		return theValue;
	}

	// *** XMLChunk Methods ***
	
	public void writeTo(Writer out) throws IOException {
		out.write(theValue);
	}

	// *** Public Methods ***

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
					
				} else if (c == '>') { // this gets us out of having to check for "]]>"...
					
					if (cOut == null) {
						cOut = new CharArrayWriter();
						cOut.write(text, 0, i);
					}
					XML.GREATER_THAN_REF.writeTo(cOut);
					
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
		
		theValue = cOut != null ? cOut.toString() : text;
	}

	// *** Private Classes ***
}










// end
