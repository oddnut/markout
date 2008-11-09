/*
	XMLChunk.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.types;

// *** imports ***

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * XMLChunk
 *
 * Comment here.  Author: David Fogel
 */
public abstract class XMLChunk {
	// *** Class Members ***
	
	private static final int CACHE_INITIAL_SIZE = 5;
	private static final int CACHE_INCREMENT = 5;
	
	private static ArrayList theCharsetIndexes = new ArrayList();

	// *** Instance Members ***
	private byte[][] theByteCache;

	// *** Constructors ***
	
	public XMLChunk() {
		theByteCache = null;
	}

	// *** Interface Methods ***

	// *** Public Methods ***
	
	abstract public void writeTo(Writer out) throws IOException;
	
	public boolean containsBytes(int index) {
		if (theByteCache == null || 
			index >= theByteCache.length)
			return false;
		
		return (theByteCache[index] != null);
	}
	
	public byte[] getBytes(int index) {
		if (theByteCache == null || 
			index >= theByteCache.length)
			return null;
		
		return theByteCache[index];
	}
	
	public void setBytes(int index, byte[] bytes) {
		synchronized(this) {
			
			if (theByteCache == null)
				theByteCache = new byte[CACHE_INITIAL_SIZE][];
			
			if (index >= theByteCache.length) {
				// grow the array
				byte[][] newArray = new byte[index + CACHE_INCREMENT][];
				for (int i = 0 ; i < theByteCache.length ; i++)
					newArray[i] = theByteCache[i];
				theByteCache = newArray;
			}
			
			theByteCache[index] = bytes;
		}
	}
	
	public static int indexOf(Charset charset) {
		int result;
		synchronized(theCharsetIndexes) {
			result = theCharsetIndexes.indexOf(charset);
			if (result == -1) {
				theCharsetIndexes.add(charset);
				result = theCharsetIndexes.size() - 1;
			}
		}
		return result;
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










// end
