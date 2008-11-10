/*
	EntityValue.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.types;

// *** imports ***

import java.io.CharArrayWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.markout.IllegalXMLCharacterException;
import net.markout.XML;
import net.markout.support.XMLChunkWriter;

/**
 * EntityValue
 *
 * Comment here.  Author: David Fogel
 */
public class EntityValue {
	// *** Class Members ***

	// *** Instance Members ***
	
	private XMLChunk[] theChunks;
	
	private char theQuoteChar;

	// *** Constructors ***
	
	public EntityValue(String text) {
		parse(text);
	}
	
	EntityValue(XMLChunk[] chunks, char quoteChar) {
		theChunks = chunks;
		theQuoteChar = quoteChar;
	}
	
	// *** Object Methods ***
	
	public boolean equals(Object o) {
		if (o == null || !(o instanceof EntityValue))
			return false;
		return theChunks.equals(((EntityValue)o).theChunks);
	}
	
	public int hashCode() {
		return theChunks.hashCode();
	}
	
	public String toString() {
		CharArrayWriter caw = new CharArrayWriter();
		try {
			
			caw.write(theQuoteChar);
			
			for (int i = 0 ; i < theChunks.length ; i++)
				theChunks[i].writeTo(caw);
			
			caw.write(theQuoteChar);
			
		} catch(IOException ioe){}
		
		return caw.toString();
	}

	// *** Public Methods ***
	
	public void writeTo(XMLChunkWriter writer) throws IOException {
		if (theQuoteChar == '\'')
			writer.write(XMLChar.SINGLE_QUOTE_CHAR);
		else
			writer.write(XMLChar.DOUBLE_QUOTE_CHAR);
		
		writer.write(theChunks);
		
		if (theQuoteChar == '\'')
			writer.write(XMLChar.SINGLE_QUOTE_CHAR);
		else
			writer.write(XMLChar.DOUBLE_QUOTE_CHAR);
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***
	
	/**
	 * Parses the text, escaping markup delimiters and outer quotes.
	 * Uses the original string unless it encounter something which
	 * needs escaping, at which point it copies everything to a 
	 * buffer from then on.
	 */
	private final void parse(String text) {
		
		int length = text.length();
		List<XMLChunk> chunks = new ArrayList<XMLChunk>();
		char outerQ = 0;
		char innerQ = 0;
		int currentStart = 0;
		int i;
		for (i = 0 ; i < length ; i++) {
			
			char c = text.charAt(i);
			
			if ( ! XMLChar.isXMLChar(c))
				throw new IllegalXMLCharacterException(c);
			
			if (c == '&') {
				
				if (i > currentStart)
					chunks.add(new XMLString(text, currentStart, i));
				
				chunks.add(XML.AMPERSAND_REF);
				
				currentStart = i + 1;
				
			} else if (c == '%') {
				
				if (i > currentStart)
					chunks.add(new XMLString(text, currentStart, i));
				
				chunks.add(XML.PERCENT_REF);
				
				currentStart = i + 1;
				
			} else if (c == '<') {
				
				if (i > currentStart)
					chunks.add(new XMLString(text, currentStart, i));
				
				chunks.add(XML.LESS_THAN_REF);
				
				currentStart = i + 1;
				
			} else if (c == outerQ) { // we need to escape the quote being used for
				// enclosing the entity value, whichever it is.
				if (i > currentStart)
					chunks.add(new XMLString(text, currentStart, i));
				
				if (c == '"')
					chunks.add(XML.DOUBLE_QUOTE_REF);
				else
					chunks.add(XML.SINGLE_QUOTE_REF);
				
				currentStart = i + 1;
				
			} else {
				
				if (c == '"' && innerQ == 0) {
					innerQ = '"';
					outerQ = '\'';
				} else if (c == '\'' && innerQ == 0) {
					innerQ = '\'';
					outerQ = '"';
				}
			}
		}
		
		if (i > currentStart) // at this point, i == text.length
			chunks.add(new XMLString(text, currentStart, i));
		
		theQuoteChar = outerQ != 0 ? outerQ : '"';
		theChunks = (XMLChunk[]) chunks.toArray(new XMLChunk[chunks.size()]);
	}

	// *** Private Classes ***
}










// end
