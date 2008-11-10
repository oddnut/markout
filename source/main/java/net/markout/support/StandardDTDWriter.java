/*
	StandardDTDWriter.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.support;

// *** imports ***

import java.io.IOException;

import net.markout.DTDWriter;
import net.markout.MalformedXMLException;
import net.markout.types.*;

/**
 * StandardDTDWriter
 *
 * Comment here.  Author: David Fogel
 */
class StandardDTDWriter implements DTDWriter {
	// *** Class Members ***

	// *** Instance Members ***
	
	private StandardDocumentWriter theDocWriter;
	
	private XMLChunkWriter theWriter;
	
	private boolean isOpen;

	// *** Constructors ***
	
	public StandardDTDWriter(StandardDocumentWriter docWriter) {
		
		theDocWriter = docWriter;
		
		theWriter = theDocWriter.getXMLChunkWriter();
		
		isOpen = false;
	}

	// *** DTDWriter Methods ***

	// *** Public Methods ***
	
	private static final XMLString DOCTYPE_START = new XMLString("<!DOCTYPE");
	private static final XMLString SYSTEM = new XMLString("SYSTEM");
	private static final XMLString PUBLIC = new XMLString("PUBLIC");
	
	public void open(	Name rootElementType,
						PublicIDLiteral publicID,
						SystemLiteral systemID) throws IOException {
		
		if (isOpen)
			throw new MalformedXMLException("DTD already open.");
		
		theWriter.write(DOCTYPE_START);
		theWriter.write(XMLChar.SPACE_CHAR);
		theWriter.write(rootElementType);
		
		if (publicID != null && systemID != null) {
			
			theWriter.write(XMLChar.SPACE_CHAR);
			theWriter.write(PUBLIC);
			theWriter.write(XMLChar.SPACE_CHAR);
			theWriter.write(publicID);
			theWriter.write(XMLChar.SPACE_CHAR);
			theWriter.write(systemID);
			
		} else if (systemID != null) {
			
			theWriter.write(XMLChar.SPACE_CHAR);
			theWriter.write(SYSTEM);
			theWriter.write(XMLChar.SPACE_CHAR);
			theWriter.write(systemID);
		}
		
		isOpen = true;
	}
	
	public boolean isOpen() {
		return isOpen;
	}
	
	public void close() throws IOException {
		
		if (!isOpen)
			return;
		
		theWriter.write(XMLChar.GREATER_THAN_CHAR);
		
		isOpen = false;
	}

	// *** Protected Methods ***
	
	protected final void writeIfNotNull(XMLChunk chunk) throws IOException {
		if (chunk != null)
			theWriter.write(chunk);
	}

	// *** Package Methods ***

	// *** Private Methods ***
	/* we'll need this at some point...
	private void checkOpen() {
		if (!isOpen)
			throw new MalformedXMLException("Can't write DTD content at this location, DTDWriter is closed");
	}
	*/
	// *** Private Classes ***
}










// end
