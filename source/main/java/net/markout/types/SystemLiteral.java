/*
	SystemLiteral.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.types;

// *** imports ***

import java.io.IOException;
import java.io.Writer;

import net.markout.IllegalXMLCharacterException;
import net.markout.IllegalXMLStringException;

/**
 * SystemLiteral
 *
 * Comment here.  Author: David Fogel
 */
public class SystemLiteral extends XMLString {
	// *** Class Members ***

	// *** Instance Members ***
	private char theContainedQuote;

	// *** Constructors ***
	public SystemLiteral(String s) {
		super(s);
	}
	
	public SystemLiteral(String s, int beginIndex, int endIndex) {
		super(s.substring(beginIndex, endIndex));
	}

	// *** XMLString Methods ***
	
	public String toString() {
		String q = theContainedQuote == '"' ? "'" : "\"";
		return q + theString + q;
	}
	
	public void writeTo(Writer out) throws IOException{
		char q = theContainedQuote == '"' ? '\'' : '"';
		out.write(q);
		out.write(theString);
		out.write(q);
	}
	
	protected void check() {
		
		theContainedQuote = 0;
		
		int length = theString.length();
		for (int i = 0 ; i < length ; i++) {
			char c = theString.charAt(i);
			if ( ! XMLChar.isXMLChar(c))
				throw new IllegalXMLCharacterException(c);
			if (c == '"' || c == '\'') {
				if (theContainedQuote == 0)
					theContainedQuote = c;
				else if (theContainedQuote != c)
					throw new IllegalXMLStringException(theString, "SystemLiteral");
			}
		}
	}

	// *** Public Methods ***
	
	public boolean containsDoubleQuote() {
		return theContainedQuote == '"';
	}
	
	public boolean containsSingleQuote() {
		return theContainedQuote == '\'';
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










// end
