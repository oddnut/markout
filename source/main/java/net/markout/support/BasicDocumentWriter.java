/*
	BasicDocumentWriter.java

	Copyright 2004-2007 David Fogel
	All rights reserved.
*/

// *** package ***
package net.markout.support;

import java.io.IOException;
import java.util.Arrays;

import net.markout.*;
import net.markout.types.*;

// *** imports ***


/**
 * BasicDocumentWriter
 * 
 * Comment Here! Author: David Fogel
 */
public class BasicDocumentWriter implements DocumentWriter, DTDWriter {
	// *** Class Members ***
	
	private static final XMLString VERSION_START = new XMLString("<?xml version=\"1.0\"");
	private static final XMLString VERSION_ENC = new XMLString("encoding");
	private static final XMLString VERSION_SA = new XMLString("standalone");
	private static final XMLString VERSION_END = new XMLString(" ?>");
	
	private static final XMLString YES = new XMLString("yes");
	private static final XMLString NO = new XMLString("no");
	
	private static final XMLString COMMENT_START = new XMLString("<!--");
	private static final XMLString COMMENT_END = new XMLString("-->");
	
	private static final XMLString PI_START = new XMLString("<?");
	private static final XMLString PI_END = new XMLString("?>");
	
	private static final XMLString DOCTYPE_START = new XMLString("<!DOCTYPE");
	private static final XMLString SYSTEM = new XMLString("SYSTEM");
	private static final XMLString PUBLIC = new XMLString("PUBLIC");
	
	
	private enum State {START, VERSION, DTD, ROOT, END}

	// *** Instance Members ****
	
	private XMLChunkWriter theWriter;
	
	private BasicElementWriter theElementWriter;
	
	private State theState;

	// *** Constructors ***
	
	public BasicDocumentWriter(XMLChunkWriter out) {
		
		theWriter = out;
		
		theState = State.START;
		
		theElementWriter = createRootElementWriter(theWriter);
	}

	// *** DocumentWriter Methods ***
	
	// --- XML Version Declaration ---
	public void xmlVersion() throws IOException {
		
		if (theState != State.START)
			throw new MalformedXMLException("XML Version declared at illegal location.");
		theState = State.VERSION;
		
		theWriter.write(VERSION_START);
		theWriter.write(VERSION_END);
	}
	
	public void xmlVersion(EncName encoding) throws IOException {
		
		if (theState != State.START)
			throw new MalformedXMLException("XML Version declared at illegal location.");
		theState = State.VERSION;
		
		theWriter.write(VERSION_START);
		if (encoding != null) {
			theWriter.write(XMLChar.SPACE_CHAR);
			theWriter.write(VERSION_ENC);
			theWriter.write(XMLChar.EQUALS_CHAR);
			theWriter.write(XMLChar.DOUBLE_QUOTE_CHAR);
			theWriter.write(encoding);
			theWriter.write(XMLChar.DOUBLE_QUOTE_CHAR);
		}
		theWriter.write(VERSION_END);
	}
	
	public void xmlVersion(EncName encoding, boolean standalone) throws IOException {
		
		if (theState != State.START)
			throw new MalformedXMLException("XML Version declared at illegal location.");
		theState = State.VERSION;
		
		theWriter.write(VERSION_START);
		if (encoding != null) {
			theWriter.write(XMLChar.SPACE_CHAR);
			theWriter.write(VERSION_ENC);
			theWriter.write(XMLChar.EQUALS_CHAR);
			theWriter.write(XMLChar.DOUBLE_QUOTE_CHAR);
			theWriter.write(encoding);
			theWriter.write(XMLChar.DOUBLE_QUOTE_CHAR);
		}
		theWriter.write(XMLChar.SPACE_CHAR);
		theWriter.write(VERSION_SA);
		theWriter.write(XMLChar.EQUALS_CHAR);
		theWriter.write(XMLChar.DOUBLE_QUOTE_CHAR);
		if (standalone)
			theWriter.write(YES);
		else
			theWriter.write(NO);
		theWriter.write(XMLChar.EQUALS_CHAR);
		theWriter.write(XMLChar.DOUBLE_QUOTE_CHAR);
		theWriter.write(VERSION_END);
	}
	
	// --- Document Type Definition ---
	public DTDWriter dtd(	Name rootElementName,
							PublicIDLiteral publicID,
							SystemLiteral systemID) throws IOException {
		
		switch(theState) {
			case START:
			case VERSION:
				break;
			default:
				throw new MalformedXMLException("DTD Version declared at illegal location.");
		}
		theState = State.DTD;
		
		theWriter.write(DOCTYPE_START);
		theWriter.write(XMLChar.SPACE_CHAR);
		theWriter.write(rootElementName);
		
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
		
		return this;
	}
	
	// --- Root Element ---
	public ContentWriter rootElement(Name elementName) throws IOException {
		return rootElement(elementName, (Attribute[]) null);
	}
	
	public ContentWriter rootElement(Name elementName, Attribute... attributes) throws IOException {
		
		switch(theState) {
			case ROOT:
			case END:
				throw new MalformedXMLException("Root element declared more than once.");
			case DTD:
				closeDTDWriter();
		}
		theState = State.ROOT;
		
		theElementWriter.open(elementName);
		
		if (attributes != null) {
			Arrays.sort(attributes);
			for (Attribute a : attributes)
				theElementWriter.attribute(a);
		}
		
		return theElementWriter.content();
	}
	
	public void emptyRootElement(Name elementName) throws IOException {
		emptyRootElement(elementName, (Attribute[]) null);
	}
	
	public void emptyRootElement(Name elementName, Attribute... attributes) throws IOException {
		
		switch(theState) {
			case ROOT:
			case END:
				throw new MalformedXMLException("Root element declared more than once.");
			case DTD:
				closeDTDWriter();
		}
		theState = State.ROOT;
	
		theElementWriter.open(elementName);
		
		if (attributes != null) {
			Arrays.sort(attributes);
			for (Attribute a : attributes)
				theElementWriter.attribute(a);
		}
		
		theElementWriter.close();
	}
	
	// --- Misc Document Parts ---
	
	public void comment(Comment c) throws IOException {
		
		switch(theState) {
			case START:
			case END:
				throw new MalformedXMLException("Comment created at illegal location.");
			case DTD:
				closeDTDWriter();
				break;
			case ROOT:
				theElementWriter.close();	
		}
		
		theWriter.write(COMMENT_START);
		theWriter.write(c);
		theWriter.write(COMMENT_END);
	}
	
	public void pi(Target target, Instruction instruction) throws IOException {
		
		switch(theState) {
			case START:
			case END:
				throw new MalformedXMLException("Processing Instruction created at illegal location.");
			case DTD:
				closeDTDWriter();
				break;
			case ROOT:
				theElementWriter.close();	
		}
		
		theWriter.write(PI_START);
		theWriter.write(target);
		if (instruction != null) {
			theWriter.write(XMLChar.SPACE_CHAR);
			theWriter.write(instruction);
		}
		theWriter.write(PI_END);
	}
	
	public void space(Whitespace space) throws IOException {
		
		switch(theState) {
			case START:
			case END:
				throw new MalformedXMLException("White space created at illegal location.");
			case DTD:
				closeDTDWriter();
				break;
			case ROOT:
				theElementWriter.close();	
		}
		
		theWriter.write(space);
	}
	
	// --- Closing ---	
	public void close() throws IOException {
		
		switch(theState) {
			case DTD:
				closeDTDWriter();
			case START:
			case VERSION:
				throw new MalformedXMLException("Document closed without a root element.");
			case END:
				return; // I guess it's okay to close a document more than once...
			case ROOT:
				theElementWriter.close();	
		}
		theState = State.END;
		
		theWriter.flush();
	}
	
	// *** DTDWriter Methods ***
	// none yet!

	// *** Public Methods ***
	
	public XMLChunkWriter getXMLChunkWriter() {
		
		return theWriter;
	}
	
	public void reset() throws IOException {
		
		if (theState != State.END)
			close();
		
		theState = State.START;
	}

	// *** Protected Methods ***
	
	protected void closeDTDWriter() throws IOException {
		//if (theState == State.DTD)
			theWriter.write(XMLChar.GREATER_THAN_CHAR);
	}
	
	/* This can be overridden by subclasses to provide subclasses of ElementWriter */
	protected BasicElementWriter createRootElementWriter(XMLChunkWriter out) {
		
		return new BasicElementWriter(out);
	}

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***

}






// end