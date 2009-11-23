/*
	HtmlDocumentWriterImpl.java

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
 * HtmlDocumentWriterImpl
 * 
 * THIS IS A GENERATED FILE, DO NOT EDIT!
 */
public class HtmlDocumentWriterImpl extends BasicDocumentWriter implements HtmlDocumentWriter {
	// *** Class Members ***
	

	// *** Constructors ***
	public HtmlDocumentWriterImpl(EnhancedXMLOutputContext out) {super(out);}

	// *** Public Methods ***
	
	public HtmlContentWriter html() throws IOException {
		return (HtmlContentWriter) rootElement(HTML);
	}
	public HtmlContentWriter html(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) rootElement(HTML, attributes);
	}

	// *** Protected Methods ***
	protected BasicElementWriter createRootElementWriter(XMLOutputContext out) {
		return new HtmlElementWriter((EnhancedXMLOutputContext) out);
	}

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}



