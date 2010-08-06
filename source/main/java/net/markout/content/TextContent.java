/*
	TextContent.java

	Author: David Fogel
	Copyright 2010 David Fogel
	All rights reserved.
*/

package net.markout.content;

import java.io.IOException;
import java.io.Writer;

/**
 * TextContent
 * 
 * Comment here.
 */
public interface TextContent {
	// *** Class Members ***

	// *** Interface Methods ***
	public void writeTo(Writer out) throws IOException;
}
