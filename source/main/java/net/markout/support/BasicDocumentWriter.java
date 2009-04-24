/*
	BasicDocumentWriter.java

	Copyright 2004-2009 David Fogel
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
	
	private XMLOutputContext out;
	
	private BasicElementWriter elementWriter;
	
	private State state;

	// *** Constructors ***
	
	public BasicDocumentWriter(XMLOutputContext outputContext) {
		
		this.out = outputContext;
		
		state = State.START;
		
		elementWriter = createRootElementWriter(out);
	}

	// *** DocumentWriter Methods ***
	
	// --- Empty Element Policy ---
	public void setEmptyElementPolicy(EmptyElementPolicy emptyPolicy) {
		out.setEmptyElementPolicy(emptyPolicy);
	}
	
	// --- XML Version Declaration ---
	public void xmlVersion() throws IOException {
		
		if (state != State.START)
			throw new MalformedXMLException("XML Version declared at illegal location.");
		state = State.VERSION;
		
		out.writer.write(VERSION_START);
		out.writer.write(VERSION_END);
	}
	
	public void xmlVersion(EncName encoding) throws IOException {
		
		if (state != State.START)
			throw new MalformedXMLException("XML Version declared at illegal location.");
		state = State.VERSION;
		
		out.writer.write(VERSION_START);
		if (encoding != null) {
			out.writer.write(XMLChar.SPACE_CHAR);
			out.writer.write(VERSION_ENC);
			out.writer.write(XMLChar.EQUALS_CHAR);
			out.writer.write(XMLChar.DOUBLE_QUOTE_CHAR);
			out.writer.write(encoding);
			out.writer.write(XMLChar.DOUBLE_QUOTE_CHAR);
		}
		out.writer.write(VERSION_END);
	}
	
	public void xmlVersion(EncName encoding, boolean standalone) throws IOException {
		
		if (state != State.START)
			throw new MalformedXMLException("XML Version declared at illegal location.");
		state = State.VERSION;
		
		out.writer.write(VERSION_START);
		if (encoding != null) {
			out.writer.write(XMLChar.SPACE_CHAR);
			out.writer.write(VERSION_ENC);
			out.writer.write(XMLChar.EQUALS_CHAR);
			out.writer.write(XMLChar.DOUBLE_QUOTE_CHAR);
			out.writer.write(encoding);
			out.writer.write(XMLChar.DOUBLE_QUOTE_CHAR);
		}
		out.writer.write(XMLChar.SPACE_CHAR);
		out.writer.write(VERSION_SA);
		out.writer.write(XMLChar.EQUALS_CHAR);
		out.writer.write(XMLChar.DOUBLE_QUOTE_CHAR);
		if (standalone)
			out.writer.write(YES);
		else
			out.writer.write(NO);
		out.writer.write(XMLChar.EQUALS_CHAR);
		out.writer.write(XMLChar.DOUBLE_QUOTE_CHAR);
		out.writer.write(VERSION_END);
	}
	
	// --- Document Type Definition ---
	public DTDWriter dtd(	Name rootElementName,
							PublicIDLiteral publicID,
							SystemLiteral systemID) throws IOException {
		
		switch(state) {
			case START:
			case VERSION:
				break;
			default:
				throw new MalformedXMLException("DTD Version declared at illegal location.");
		}
		state = State.DTD;
		
		out.writer.write(DOCTYPE_START);
		out.writer.write(XMLChar.SPACE_CHAR);
		out.writer.write(rootElementName);
		
		if (publicID != null && systemID != null) {
			
			out.writer.write(XMLChar.SPACE_CHAR);
			out.writer.write(PUBLIC);
			out.writer.write(XMLChar.SPACE_CHAR);
			out.writer.write(publicID);
			out.writer.write(XMLChar.SPACE_CHAR);
			out.writer.write(systemID);
			
		} else if (systemID != null) {
			
			out.writer.write(XMLChar.SPACE_CHAR);
			out.writer.write(SYSTEM);
			out.writer.write(XMLChar.SPACE_CHAR);
			out.writer.write(systemID);
		}
		
		return this;
	}
	
	// --- Namespaces ---
	public void defaultNamespace(NamespaceURI uri) throws IOException {
		switch(state) {
		case START:
		case VERSION:
		case DTD:
			break;
		default:
			throw new MalformedXMLException("Root Namespace modified after root element started");
		}
		
		elementWriter.defaultNamespace(uri);
	}
	
	public void namespace(NamespaceURI uri) throws IOException {
		switch(state) {
		case START:
		case VERSION:
		case DTD:
			break;
		default:
			throw new MalformedXMLException("Root Namespace modified after root element started");
		}
		
		elementWriter.namespace(uri);
	}
	
	// --- Root Element ---
	public ContentWriter rootElement(Name elementName) throws IOException {
		return rootElement(elementName, (Attribute[]) null);
	}
	
	public ContentWriter rootElement(Name elementName, Attribute... attributes) throws IOException {
		
		switch(state) {
			case ROOT:
			case END:
				throw new MalformedXMLException("Root element declared more than once.");
			case DTD:
				closeDTDWriter();
		}
		state = State.ROOT;
		
		elementWriter.open(elementName);
		
		if (attributes != null) {
			Arrays.sort(attributes);
			for (Attribute a : attributes)
				elementWriter.attribute(a);
		}
		
		elementWriter.content();
		
		return elementWriter;
	}
	
	public void emptyRootElement(Name elementName) throws IOException {
		emptyRootElement(elementName, (Attribute[]) null);
	}
	
	public void emptyRootElement(Name elementName, Attribute... attributes) throws IOException {
		
		switch(state) {
			case ROOT:
			case END:
				throw new MalformedXMLException("Root element declared more than once.");
			case DTD:
				closeDTDWriter();
		}
		state = State.ROOT;
	
		elementWriter.open(elementName);
		
		if (attributes != null) {
			Arrays.sort(attributes);
			for (Attribute a : attributes)
				elementWriter.attribute(a);
		}
		
		elementWriter.close();
	}
	
	// --- Misc Document Parts ---
	
	public void comment(Comment c) throws IOException {
		
		switch(state) {
			case START:
			case END:
				throw new MalformedXMLException("Comment created at illegal location.");
			case DTD:
				closeDTDWriter();
				break;
			case ROOT:
				elementWriter.close();	
		}
		
		out.writer.write(COMMENT_START);
		out.writer.write(c);
		out.writer.write(COMMENT_END);
	}
	
	public void pi(Target target, Instruction instruction) throws IOException {
		
		switch(state) {
			case START:
			case END:
				throw new MalformedXMLException("Processing Instruction created at illegal location.");
			case DTD:
				closeDTDWriter();
				break;
			case ROOT:
				elementWriter.close();	
		}
		
		out.writer.write(PI_START);
		out.writer.write(target);
		if (instruction != null) {
			out.writer.write(XMLChar.SPACE_CHAR);
			out.writer.write(instruction);
		}
		out.writer.write(PI_END);
	}
	
	public void space(Whitespace space) throws IOException {
		
		switch(state) {
			case START:
			case END:
				throw new MalformedXMLException("White space created at illegal location.");
			case DTD:
				closeDTDWriter();
				break;
			case ROOT:
				elementWriter.close();	
		}
		
		out.writer.write(space);
	}
	
	// --- Closing ---	
	public void close() throws IOException {
		
		switch(state) {
			case DTD:
				closeDTDWriter();
			case START:
			case VERSION:
				throw new MalformedXMLException("Document closed without a root element.");
			case END:
				return; // I guess it's okay to close a document more than once...
			case ROOT:
				elementWriter.close();	
		}
		state = State.END;
		
		out.writer.flush();
	}
	
	// *** DTDWriter Methods ***
	// none yet!

	// *** Public Methods ***
	
	public XMLChunkWriter getXMLChunkWriter() {
		
		return out.writer;
	}
	
	public void reset() throws IOException {
		
		if (state != State.END)
			close();
		
		state = State.START;
	}

	// *** Protected Methods ***
	
	protected void closeDTDWriter() throws IOException {
		//if (state == State.DTD)
			out.writer.write(XMLChar.GREATER_THAN_CHAR);
	}
	
	/* This can be overridden by subclasses to provide subclasses of ElementWriter */
	protected BasicElementWriter createRootElementWriter(XMLOutputContext out) {
		
		return new BasicElementWriter(out);
	}

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***

}






// end