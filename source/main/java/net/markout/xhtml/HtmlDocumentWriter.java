/*
	HtmlDocumentWriter.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.xhtml;

import java.io.IOException;

//import net.markout.*;
import net.markout.support.*;
import net.markout.types.*;

/**
 * HtmlDocumentWriter
 * 
 * THIS IS A GENERATED FILE, DO NOT EDIT!
 */
public class HtmlDocumentWriter extends BasicDocumentWriter {
	// *** Class Members ***
	private static final Name ROOT_ELEMENT = new Name("html");

	// *** Constructors ***
	public HtmlDocumentWriter(XMLChunkWriter out) {super(out);}

	// *** Public Methods ***
	
	public HtmlContentWriter html(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) rootElement(ROOT_ELEMENT, attributes);
	}
	
	public void emptyHtml(Attribute... attributes) throws IOException {
		emptyRootElement(ROOT_ELEMENT, attributes);
	}

	// *** Protected Methods ***
	protected BasicElementWriter createRootElementWriter(XMLChunkWriter out) {
		return new HtmlElementWriter(out);
	}

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}



