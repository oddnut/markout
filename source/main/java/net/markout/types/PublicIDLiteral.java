/*
	PublicIDLiteral.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.types;

// *** imports ***

import java.io.IOException;
import java.io.Writer;

import net.markout.IllegalXMLStringException;

/**
 * PublicIDLiteral
 *
 * Comment here.  Author: David Fogel
 */
public class PublicIDLiteral extends XMLString {
	// *** Class Members ***

	// *** Instance Members ***

	// *** Constructors ***
	public PublicIDLiteral(String s) {
		super(s);
	}
	
	public PublicIDLiteral(String s, int beginIndex, int endIndex) {
		super(s.substring(beginIndex, endIndex));
	}

	// *** XMLString Methods ***
	
	public String toString() {
		return "\"" + theString + "\"";
	}
	
	public void writeTo(Writer out) throws IOException {
		out.write('"');
		out.write(theString);
		out.write('"');
	}
	
	protected void check() {
		
		int length = theString.length();
		
		for (int i = 0 ; i < length ; i++) {
			char c = theString.charAt(i);
			if ( ! XMLChar.isPublicIDChar(c))
				throw new IllegalXMLStringException(theString, "PublicIDLiteral");
		}
	}

	// *** Public Methods ***

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










// end
