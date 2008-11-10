/*
	XMLString.java
	
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

/**
 * XMLString
 *
 * Comment here.  Author: David Fogel
 */
public class XMLString extends XMLChunk implements Comparable<XMLString> {
	// *** Class Members ***

	// *** Instance Members ***
	
	protected String theString;

	// *** Constructors ***
	
	public XMLString(String s) {
		theString = s;
		check();
	}
	
	public XMLString(String s, int beginIndex, int endIndex) {
		this(s.substring(beginIndex, endIndex));
	}

	// *** Object Methods ***
	
	public boolean equals(Object o) {
		if (o == null || !(o instanceof XMLString))
			return false;
		return theString.equals(((XMLString)o).theString);
	}
	
	public int hashCode() {
		return theString.hashCode();
	}
	
	public String toString() {
		return theString;
	}
	
	// *** Comparable Methods ***
	
	public int compareTo(XMLString o) {
		return theString.compareTo(o.theString);
	}
	
	// *** XMLChunk Methods ***
	
	public int length(){
		return theString.length();
	}
	
	public void writeTo(Writer out) throws IOException {
		out.write(theString);
	}

	// *** Public Methods ***
	
	public static final boolean isXMLString(String s) {
		int length = s.length();
		for (int i = 0; i < length ; i++) {
			char c = s.charAt(i);
			if ( ! XMLChar.isXMLChar(c))
				return false;
		}
		return true;
	}

	// *** Protected Methods ***
	
	protected void check() {
		int length = theString.length();
		for (int i = 0; i < length ; i++) {
			char c = theString.charAt(i);
			if ( ! XMLChar.isXMLChar(c))
				throw new IllegalXMLCharacterException(c);
		}
	}

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










// end
