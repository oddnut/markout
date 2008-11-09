/*
	StandardDocumentWriter.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.support;

// *** imports ***

import java.io.IOException;

import net.markout.*;
import net.markout.dtd.*;
import net.markout.types.*;

/**
 * StandardDocumentWriter
 *
 * Comment here.  Author: David Fogel
 */
public class StandardDocumentWriter implements DocumentWriter {
	// *** Class Members ***

	private static final String START_STATE = "start";
	private static final String VERSION_STATE = "version";
	private static final String DTD_STATE = "dtd";
	private static final String ROOT_STATE = "root";
	private static final String END_STATE = "end";
	
	private static final String DO_VERSION = "version";
	private static final String DO_DTD = "dtd";
	private static final String DO_MISC = "misc";
	private static final String DO_ROOT = "root";
	private static final String DO_END = "end";
	private static final String DO_RESET = "reset";
	
	private class DocState extends SimpleStateMachine {
		public DocState() {
			addState(START_STATE);
			addState(VERSION_STATE);
			addState(DTD_STATE);
			addState(ROOT_STATE);
			addState(END_STATE);
			
			addTransition(START_STATE, DO_VERSION, VERSION_STATE);
			addTransition(START_STATE, DO_DTD, DTD_STATE);
			addTransition(START_STATE, DO_ROOT, ROOT_STATE);
			
			addTransition(VERSION_STATE, DO_MISC, VERSION_STATE);
			addTransition(VERSION_STATE, DO_DTD, DTD_STATE);
			addTransition(VERSION_STATE, DO_ROOT, ROOT_STATE);
			
			addTransition(DTD_STATE, DO_MISC, DTD_STATE);
			addTransition(DTD_STATE, DO_ROOT, ROOT_STATE);
			
			addTransition(ROOT_STATE, DO_MISC, ROOT_STATE);
			addTransition(ROOT_STATE, DO_END, END_STATE);
			
			addTransition(END_STATE, DO_RESET, START_STATE);
			
			start(START_STATE);
		}
		
		protected void handleIllegalTransition(String transitionName) {
			// do nothing, check success in transition() method return val.
		}
	}
	
	// *** XMLStrings ***
	
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

	// *** Instance Members ***
	
	protected DocState theState;
	
	protected StandardDTDWriter theDTDWriter;
	protected StandardElementWriter theElementWriter;
	
	protected WhitespacePolicy theWhitespacePolicy;
	
	private XMLChunkWriter theWriter;
	
	private DTD theDTD;
	private DocumentValidator theDocValidator;

	// *** Constructors ***
	public StandardDocumentWriter(XMLChunkWriter out) {
		this(out, null);
	}
	
	public StandardDocumentWriter(XMLChunkWriter out, DTD validationDTD) {
		
		theWriter = out;
		
		theDTD = validationDTD;
		
		theDocValidator = theDTD != null ? new DocumentValidator(theDTD) : null;
		
		theDTDWriter = new StandardDTDWriter(this);
		
		theElementWriter = new StandardElementWriter(this);
		
		theWhitespacePolicy = new DefaultWhitespacePolicy();
		
		theState = new DocState();
	}

	// *** DocumentWriter Methods ***
	
	// --- Whitespace Policy ---
	
	public void setWhitespacePolicy(WhitespacePolicy policy) {
		if (policy == null)
			theWhitespacePolicy = new DefaultWhitespacePolicy();
		else
			theWhitespacePolicy = policy;
	}
	
	// --- Writer State ---
	
	public ElementWriter currentElementWriter() {
		
		if (theState.currentState() != ROOT_STATE)
			return null;
		
		return theElementWriter.current();
	}
	
	public ElementWriter currentElementWriter(int depth) {
		
		if (depth < 0)
			throw new IllegalArgumentException("Depth can not be negative.");

		if (theState.currentState() != ROOT_STATE)
			return null;
		
		return theElementWriter.current(depth);
	}
	
	// --- XML Version Declaration ---
	
	public void xmlVersion() throws IOException {
		
		if (! theState.transition(DO_VERSION))
			throw new MalformedXMLException("Can't declare XML Version at this location.");
		
		theWriter.write(VERSION_START);
		theWriter.write(VERSION_END);
		
		writeIfNotNull(theWhitespacePolicy.afterXMLVersion());
	}
	
	public void xmlVersion(EncName encoding) throws IOException {
		
		if (! theState.transition(DO_VERSION))
			throw new MalformedXMLException("Can't declare XML Version at this location.");
		
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
		
		writeIfNotNull(theWhitespacePolicy.afterXMLVersion());
	}
	
	public void xmlVersion(EncName encoding, boolean standalone) throws IOException {
		
		if (! theState.transition(DO_VERSION))
			throw new MalformedXMLException("Can't declare XML Version at this location.");
		
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
		
		writeIfNotNull(theWhitespacePolicy.afterXMLVersion());
	}
	
	// --- Document Type Definition ---
	
	public DTDWriter dtd(	Name rootElementType,
							PublicIDLiteral publicID,
							SystemLiteral systemID) throws IOException {
		
		if (! theState.transition(DO_DTD))
			throw new MalformedXMLException("Can't declare DTD Version at this location.");
		
		if (theDTD != null) {
			if ( ! rootElementType.equals(theDTD.getRootElementName()))
				throw new ValidationException("DTD root element doesn't match DTD.");
		}
		
		theDTDWriter.open(rootElementType, publicID, systemID);
		
		return theDTDWriter;
	}
	
	// --- Root Element ---
	
	public ElementWriter rootElementWriter(Name elementType) throws IOException {
		
		if (theState.currentState() == DTD_STATE)
			closeDTDWriter();
		
		if (! theState.transition(DO_ROOT))
			throw new MalformedXMLException("Can't declare root element at this location.");
		
		if (theDTD != null) {
			
			if (theDTD.getElementType(elementType) == null)
				throw new ValidationException("Unknown element type.");
			
			if ( ! elementType.equals(theDTD.getRootElementName()))
				throw new ValidationException("Root element doesn't match DTD root element.");
		}
		
		theElementWriter.open(elementType, null);
		
		return theElementWriter;
	}
	
	public ContentWriter rootElement(Name elementType) throws IOException {
		return rootElementWriter(elementType).content();
	}
	
	public ContentWriter rootElement(Name elementType, Attributes attributes) throws IOException {
		rootElementWriter(elementType);
		if (attributes != null) {
			attributes.writeTo(theElementWriter);
		}
		return theElementWriter.content();
	}
	
	public void emptyRootElement(Name elementType) throws IOException {
		rootElementWriter(elementType);
		closeElementWriter();
	}
	
	public void emptyRootElement(Name elementType, Attributes attributes) throws IOException {
		rootElementWriter(elementType);
		if (attributes != null) {
			attributes.writeTo(theElementWriter);
		}
		closeElementWriter();
	}
	
	
	// --- Misc Document Parts ---
	
	public void comment(Comment c) throws IOException {
		
		if (theState.currentState() == DTD_STATE)
			closeDTDWriter();
		
		if (theState.currentState() == ROOT_STATE)
			closeElementWriter();
		
		if (! theState.transition(DO_MISC))
			throw new MalformedXMLException("Can't create a comment at this location.");
		
		theWriter.write(COMMENT_START);
		theWriter.write(c);
		theWriter.write(COMMENT_END);
		
		writeIfNotNull(theWhitespacePolicy.afterComment());
	}
	
	public void pi(Target target, Instruction instruction) throws IOException {
		
		if (theState.currentState() == DTD_STATE)
			closeDTDWriter();
		
		if (theState.currentState() == ROOT_STATE)
			closeElementWriter();
		
		if (! theState.transition(DO_MISC))
			throw new MalformedXMLException("Can't create a processing instruction at this location.");
		
		theWriter.write(PI_START);
		theWriter.write(target);
		if (instruction != null) {
			theWriter.write(XMLChar.SPACE_CHAR);
			theWriter.write(instruction);
		}
		theWriter.write(PI_END);
		
		writeIfNotNull(theWhitespacePolicy.afterPI());
	}
	
	public void space(Whitespace space) throws IOException {
		
		if (theState.currentState() == DTD_STATE)
			closeDTDWriter();
		
		if (theState.currentState() == ROOT_STATE)
			closeElementWriter();
		
		if (! theState.transition(DO_MISC))
			throw new MalformedXMLException("Can't add WhiteSpace at this location.");
		
		theWriter.write(space);
	}
	
	// --- Closing and Resetting ---
	
	public void close() throws IOException {
		
		if (theState.currentState() == END_STATE)
			return; // I suppose it's okay to call close() more than once....?
			//throw new MalformedXMLException("Can't close document more than once.");
		
		if (theState.currentState() == DTD_STATE)
			closeDTDWriter();
		
		if (theState.currentState() == ROOT_STATE)
			closeElementWriter();
		
		if (! theState.transition(DO_END))
			throw new MalformedXMLException("Can't end document at this location. no root element.");
		
		writeIfNotNull(theWhitespacePolicy.beforeClose());
		
		theWriter.flush();
	}
	/*
	public void reset() throws IOException {
		
		if (theState.currentState() != END_STATE)
			close();
		
		if (! theState.transition(DO_RESET))
			throw new MalformedXMLException("Can't reset the document at this location.");
	}*/

	// *** Public Methods ***
	
	public XMLChunkWriter getXMLChunkWriter() {
		return theWriter;
	}
	
	public WhitespacePolicy getWhitespacePolicy() {
		return theWhitespacePolicy;
	}
	
	public DTD getDTD() {
		return theDTD;
	}
	
	public DocumentValidator getDocumentValidator() {
		return theDocValidator;
	}

	// *** Protected Methods ***
	
	protected void closeDTDWriter() throws IOException {
		
		if (theDTDWriter.isOpen()) {
			theDTDWriter.close();
			writeIfNotNull(theWhitespacePolicy.afterDTD());
		}
	}
	
	protected void closeElementWriter() throws IOException {
		if (theElementWriter.isOpen()) {
			theElementWriter.close();
			writeIfNotNull(theWhitespacePolicy.afterRoot());
		}
	}
	
	protected final void writeIfNotNull(XMLChunk chunk) throws IOException {
		if (chunk != null)
			theWriter.write(chunk);
	}

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










// end
