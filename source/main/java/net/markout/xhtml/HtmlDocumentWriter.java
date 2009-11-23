/*
	HtmlDocumentWriter.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.xhtml;

import java.io.IOException;

import net.markout.*;
import net.markout.types.*;

/**
 * HtmlDocumentWriter
 * 
 * THIS IS A GENERATED FILE, DO NOT EDIT!
 */
public interface HtmlDocumentWriter extends DocumentWriter {
	// *** Class Members ***

	// *** Public Methods ***
	
	public HtmlContentWriter html() throws IOException;
	public HtmlContentWriter html(Attribute... attributes) throws IOException;
	
}



