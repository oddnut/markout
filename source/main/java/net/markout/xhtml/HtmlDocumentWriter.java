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

import static net.markout.xhtml.XHTML.*;

/**
 * HtmlDocumentWriter
 * 
 * THIS IS A GENERATED FILE, DO NOT EDIT!
 */
public class HtmlDocumentWriter extends BasicDocumentWriter {
	// *** Class Members ***
	

	// *** Constructors ***
	public HtmlDocumentWriter(XMLChunkWriter out) {super(out);}

	// *** Public Methods ***
	
	public HtmlContentWriter html() throws IOException {
		return (HtmlContentWriter) rootElement(HTML);
	}
	public HtmlContentWriter html(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) rootElement(HTML, attributes);
	}

	// *** Protected Methods ***
	protected BasicElementWriter createRootElementWriter(XMLChunkWriter out) {
		return new HtmlElementWriter(out);
	}

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}



