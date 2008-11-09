/*
	CharRef.java
	
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
 * CharRef
 *
 * Comment here.  Author: David Fogel
 */
public class CharRef extends XMLChunk {
	// *** Class Members ***

	// *** Instance Members ***
	private char theChar;

	// *** Constructors ***
	public CharRef(char c) {
		if ( ! XMLChar.isXMLChar(c))
			throw new IllegalXMLCharacterException(c);
		theChar = c;
	}
	
	// *** Object Methods ***
	
	public boolean equals(Object o) {
		if (o == null || !(o instanceof CharRef))
			return false;
		return theChar == ((CharRef)o).theChar;
	}
	
	public int hashCode() {
		return (int) theChar;
	}
	
	public String toString() {
		return "&#" + (int) theChar + ";";
	}

	// *** XMLChunk Methods ***
	
	public void writeTo(Writer out) throws IOException {
		out.write("&#" + (int) theChar + ";");
	}

	// *** Public Methods ***

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










// end
