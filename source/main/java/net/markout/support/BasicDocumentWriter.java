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
import static net.markout.WhitespacePolicy.DocPosition.*;

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
	
	
	private enum State {START, VERSIONED, DTD, BEFORE_ROOT, ROOT, AFTER_ROOT, END}

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
	
	// --- Whitespace Policy ---
	public void setWhitespacePolicy(WhitespacePolicy whitespacePolicy) {
		out.setWhitespacePolicy(whitespacePolicy);
	}
	
	// --- Empty Element Policy ---
	public void setEmptyElementPolicy(EmptyElementPolicy emptyPolicy) {
		out.setEmptyElementPolicy(emptyPolicy);
	}
	
	// --- XML Version Declaration ---
	public void xmlVersion() throws IOException {
		xmlVersion(null, null);
	}
	
	public void xmlVersion(EncName encoding) throws IOException {
		xmlVersion(encoding, null);
	}
	
	public void xmlVersion(EncName encoding, Boolean standalone) throws IOException {
		
		if (state != State.START)
			throw new MalformedXMLException("XML Version declared at illegal location.");
		
		writeXMLVersion(encoding, standalone);
		
		state = State.VERSIONED;
	}
	
	// --- Document Type Definition ---
	public DTDWriter dtd(	Name rootElementName,
							PublicIDLiteral publicID,
							SystemLiteral systemID) throws IOException {
		
		switch(state) {
			case START:
			case VERSIONED:
				break;
			default:
				throw new MalformedXMLException("DTD Version declared at illegal location.");
		}
		
		writeDTDOpen(rootElementName, publicID, systemID);
		
		state = State.DTD;
		
		return this;
	}
	
	// --- Namespaces ---
	public void defaultNamespace(NamespaceURI uri) throws IOException {
		switch(state) {
		case START:
		case VERSIONED:
		case DTD:
		case BEFORE_ROOT:
			break;
		default:
			throw new MalformedXMLException("Root Namespace modified after root element started");
		}
		
		elementWriter.defaultNamespace(uri);
	}
	
	public void namespace(NamespaceURI uri) throws IOException {
		switch(state) {
		case START:
		case VERSIONED:
		case DTD:
		case BEFORE_ROOT:
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
			case AFTER_ROOT:
			case END:
				throw new MalformedXMLException("Root element declared more than once.");
			case DTD:
				closeDTD();
		}
		
		elementWriter.open(elementName);
		
		if (attributes != null) {
			Arrays.sort(attributes);
			for (Attribute a : attributes)
				elementWriter.attribute(a);
		}
		
		elementWriter.content(); // do we still need this?
		
		state = State.ROOT;
		
		return elementWriter;
	}
	
	// --- Misc Document Parts ---
	
	public void comment(Comment c) throws IOException {
		
		switch(state) {
			case START:
			case END:
				throw new MalformedXMLException("Comment created at illegal location.");
			case DTD:
				closeDTD();
				break;
			case ROOT:
				closeRoot();
		}
		
		out.writer.write(COMMENT_START);
		out.writer.write(c);
		out.writer.write(COMMENT_END);
		writeWhitespace(after_comment, null);
	}
	
	public void pi(Target target, Instruction instruction) throws IOException {
		
		switch(state) {
			case START:
			case END:
				throw new MalformedXMLException("Processing Instruction created at illegal location.");
			case DTD:
				closeDTD();
				break;
			case ROOT:
				closeRoot();	
		}
		
		out.writer.write(PI_START);
		out.writer.write(target);
		if (instruction != null) {
			out.writer.write(XMLChar.SPACE_CHAR);
			out.writer.write(instruction);
		}
		out.writer.write(PI_END);
		writeWhitespace(after_pi, null);
	}
	
	public void space(Whitespace space) throws IOException {
		
		switch(state) {
			case START:
			case END:
				throw new MalformedXMLException("White space created at illegal location.");
			case DTD:
				closeDTD();
				break;
			case ROOT:
				closeRoot();
		}
		
		out.writer.write(space);
	}
	
	// --- Closing ---	
	public void close() throws IOException {
		
		switch(state) {
			case DTD:
				closeDTD();
				// fall through- state will be BEFORE_ROOT
			case START:
			case VERSIONED:
			case BEFORE_ROOT:
				throw new MalformedXMLException("Document closed without a root element.");
			case END:
				return; // I guess it's okay to close a document more than once...
			case ROOT:
				closeRoot();
		}
		
		writeWhitespace(before_close, null);
		
		out.writer.flush();
		
		state = State.END;
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
	
	protected final void writeXMLVersion(EncName encoding, Boolean standalone) throws IOException {
		
		out.writer.write(VERSION_START);
		if (encoding != null) {
			out.writer.write(XMLChar.SPACE_CHAR);
			out.writer.write(VERSION_ENC);
			out.writer.write(XMLChar.EQUALS_CHAR);
			out.writer.write(XMLChar.DOUBLE_QUOTE_CHAR);
			out.writer.write(encoding);
			out.writer.write(XMLChar.DOUBLE_QUOTE_CHAR);
		}
		if (standalone != null) {
			out.writer.write(XMLChar.SPACE_CHAR);
			out.writer.write(VERSION_SA);
			out.writer.write(XMLChar.EQUALS_CHAR);
			out.writer.write(XMLChar.DOUBLE_QUOTE_CHAR);
			if (standalone == true)
				out.writer.write(YES);
			else
				out.writer.write(NO);
			out.writer.write(XMLChar.DOUBLE_QUOTE_CHAR);
		}
		out.writer.write(VERSION_END);
		
		writeWhitespace(after_version, null);
	}
	
	protected final void writeDTDOpen(	Name rootElementName,
										PublicIDLiteral publicID,
										SystemLiteral systemID) throws IOException {
		
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
	}
	
	protected final void writeDTDClose() throws IOException {
		
		out.writer.write(XMLChar.GREATER_THAN_CHAR);
		writeWhitespace(after_dtd, null);
	}
	
	protected final void closeDTD() throws IOException {
		
		writeDTDClose();
		
		state = State.BEFORE_ROOT;
	}
	
	protected final void closeRoot() throws IOException {
		
		elementWriter.close();
		writeWhitespace(after_root, null);
		
		state = State.AFTER_ROOT;
	}
	
	/* This can be overridden by subclasses to provide subclasses of ElementWriter */
	protected BasicElementWriter createRootElementWriter(XMLOutputContext out) {
		
		return new BasicElementWriter(out);
	}

	// *** Package Methods ***

	// *** Private Methods ***
	private final void writeWhitespace(WhitespacePolicy.DocPosition position, Whitespace defaultWhitespace) 
	throws IOException {
		Whitespace space = defaultWhitespace;
		WhitespacePolicy policy = out.getWhitespacePolicy();
		if (policy != null)
			space = policy.forPosition(position);
		if (space != null)
			out.writer.write(space);
	}

	// *** Private Classes ***

}






// end