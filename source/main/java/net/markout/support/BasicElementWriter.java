/*
	BasicElementWriter.java

	Copyright 2004-2007 David Fogel
	All rights reserved.
*/

// *** package ***
package net.markout.support;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

import net.markout.*;
import net.markout.types.*;

// *** imports ***

public class BasicElementWriter implements ElementWriter {
	// *** Class Members ***
	
	private static final XMLString COMMENT_START = new XMLString("<!--");
	private static final XMLString COMMENT_END = new XMLString("-->");
	
	private static final XMLString PI_START = new XMLString("<?");
	private static final XMLString PI_END = new XMLString("?>");
	
	private static final XMLString TAG_CLOSE_EMPTY = new XMLString("/>");
	private static final XMLString END_TAG_OPEN = new XMLString("</");
	
	private enum State {CLOSED, OPEN_NEEDS_SPACE, OPEN, CONTENT, TEXT, CHILD}

	// *** Instance Members ****
	
	private XMLChunkWriter theWriter;
	
	private TextWriter theTextWriter;
	
	private BasicElementWriter theCurrentChild;
	
	private Name theName;
	
	private Namespace theNamespace;
	
	private ElementNameStack theElementNameStack;
	
	private State theState;

	// *** Constructors ***
	
	public BasicElementWriter(XMLChunkWriter out) {
		
		theWriter = out;
		theTextWriter = null;
		theCurrentChild = null;
		theName = null;
		theNamespace = new Namespace();
		theElementNameStack = null;
		
		theState = State.CLOSED;
	}
	
	// *** ElementWriter Methods ***
	
	// --- Namespace ---
	public void prepareNamespace(Namespace parentNamespace) {
		if (theState != State.CLOSED)
			throw new MalformedXMLException("ElementWriter already opened.");
		
		theNamespace.setParent(parentNamespace);
	}
	
	// --- Opening ---
	public void open(Name elementName) throws IOException {
		open(elementName, null);
	}
	
	public void open(Name elementName, List<Name> parentElementNames) throws IOException {
		
		if (theState != State.CLOSED)
			throw new MalformedXMLException("ElementWriter already opened.");
		theState = State.OPEN_NEEDS_SPACE;
		
		theName = elementName;
		
		if (theElementNameStack == null || theElementNameStack.getParent() != parentElementNames)
			theElementNameStack = new ElementNameStack(parentElementNames, elementName);
		else
			theElementNameStack.set(elementName);
		
		theWriter.write(XMLChar.LESS_THAN_CHAR);
		writeName(theName);
	}
	
	// --- Attributes ---
	public void attribute(Attribute att) throws IOException {
		
		switch(theState) {
		case CLOSED:
			throw new MalformedXMLException("Attribute written on a closed ElementWriter");
		
		case CONTENT:
		case TEXT:
		case CHILD:
			throw new MalformedXMLException("Attribute written on an ElementWriter with content.");
			
		case OPEN_NEEDS_SPACE:
			theWriter.write(XMLChar.SPACE_CHAR); // need minimum whitespace between attributes
		}
		
		theState = State.OPEN_NEEDS_SPACE;
		
		writeName(att.getName());
		theWriter.write(XMLChar.EQUALS_CHAR);
		XMLChar quoteChar = att.getQuoteChar();
		theWriter.write(quoteChar);
		theWriter.write(att);
		theWriter.write(quoteChar);
	}
	
	// --- Writer State ---
	public List<Name> getElementNameStack() {
		
		if (theState == State.CLOSED)
			throw new MalformedXMLException("ElementNameStack accessed on a closed ElementWriter.");
		
		return theElementNameStack;
	}
	
	public Name getName() {
		
		if (theState == State.CLOSED)
			throw new MalformedXMLException("getName called on closed ContentWriter.");
		
		return theName;
	}
	
	// --- Escaped Text Content ---
	public void text(Text text) throws IOException {
		
		prepareForContent();
		
		theWriter.write(text);
	}
	
	public void text(String text) throws IOException {
		
		text().write(text);
	}
	
	public Writer text() throws IOException {
		
		switch(theState) {
		case CLOSED:
		case OPEN:
		case OPEN_NEEDS_SPACE:
			content();
			break;
			
		case TEXT:
			return theTextWriter;
		
		case CHILD:
			theCurrentChild.close();
			break;
		}
		
		theState = State.TEXT;
		
		if (theTextWriter == null)
			theTextWriter = new TextWriter(theWriter);
		
		theTextWriter.open();
		
		return theTextWriter;
	}
	
	// --- Character Data Content---
	public void characters(CharData charData) throws IOException {
		
		prepareForContent();
		
		theWriter.write(charData);
	}
	
	public void cdata(CData cdata) throws IOException {
		
		prepareForContent();
		
		theWriter.write(cdata);
	}
	
	// --- Reference Content ---
	public void reference(CharRef charRef) throws IOException {
		
		prepareForContent();
		
		theWriter.write(charRef);
	}
	
	public void reference(Name entityName) throws IOException {

		prepareForContent();
		
		theWriter.write(XMLChar.AMPERSAND_CHAR);
		theWriter.write(entityName);
		theWriter.write(XMLChar.SEMICOLON_CHAR);
	}
	
	// --- Namespaces ---
	public void defaultNamespace(NamespaceURI uri) throws IOException {
		if (theState == State.CLOSED) {
			
			theNamespace.setDefaultNamespaceURI(uri);
			
		} else {
			
			prepareForContent();
			
			prepareChildElementWriter();
			
			theCurrentChild.defaultNamespace(uri);
		}
	}
	
	public void namespace(NamespaceURI uri) throws IOException {
		if (theState == State.CLOSED) {
			
			theNamespace.namespaceURIPrefix(uri);
			
		} else {
			
			prepareForContent();
			
			prepareChildElementWriter();
			
			theCurrentChild.namespace(uri);
		}
	}
	
	// --- Element Content ---
	public ContentWriter element(Name elementName) throws IOException {
		return element(elementName, (Attribute[]) null);
	}
	
	public ContentWriter element(Name elementName, Attribute... attributes) throws IOException {
		
		prepareForContent();
		
		theState = State.CHILD;
		
		prepareChildElementWriter();
		
		theCurrentChild.open(elementName, theElementNameStack);
		
		if (attributes != null) {
			Arrays.sort(attributes);
			for (Attribute a : attributes)
				theCurrentChild.attribute(a);
		}
		
		theCurrentChild.content();
		
		return theCurrentChild;	
	}
	
	public void emptyElement(Name elementName) throws IOException {
		emptyElement(elementName, (Attribute[]) null);
	}
	
	public void emptyElement(Name elementName, Attribute... attributes) throws IOException {
		
		prepareForContent();
		
		theState = State.CHILD;
		
		prepareChildElementWriter();
		
		theCurrentChild.open(elementName, theElementNameStack);
		
		if (attributes != null) {
			Arrays.sort(attributes);
			for (Attribute a : attributes)
				theCurrentChild.attribute(a);
		}
		
		theCurrentChild.close();
		
		theState = State.CONTENT;
	}
	
	// --- Misc Content ---
	public void comment(Comment c) throws IOException {
		
		prepareForContent();
		
		theWriter.write(COMMENT_START);
		theWriter.write(c);
		theWriter.write(COMMENT_END);
	}
	
	public void pi(Target target, Instruction instruction) throws IOException {
		
		prepareForContent();
		
		theWriter.write(PI_START);
		theWriter.write(target);
		if (instruction != null) {
			theWriter.write(XMLChar.SPACE_CHAR);
			theWriter.write(instruction);
		}
		theWriter.write(PI_END);
	}
	
	public void space(Whitespace space) throws IOException {
		
		// There are two general categories for when space() is called,
		// within the open element tag, and within content.
		// notice the return after case OPEN.
		
		switch(theState) {
		case CLOSED:
			throw new MalformedXMLException("Space written on a closed ElementWritter");
			
		case OPEN_NEEDS_SPACE:
			theState = State.OPEN;
			//fall through
		case OPEN:
			theWriter.write(space);
			return;
		
		case TEXT:
			theTextWriter.close();
			break;
			
		case CHILD:
			theCurrentChild.close();
			break;
		}
		
		theState = State.CONTENT;
		
		theWriter.write(space);
	}
	
	// --- Closing ---
	public void close() throws IOException {
		
		switch(theState) {
		case CLOSED:
			return;// It's okay to call close() more than once?
		
		case OPEN_NEEDS_SPACE:
			theWriter.write(XMLChar.SPACE_CHAR); // need minimum whitespace before close
			theState = State.OPEN;
			break;
			
		case TEXT:
			theTextWriter.close();
			theState = State.CONTENT;
			break;
			
		case CHILD:
			theCurrentChild.close();
			theState = State.CONTENT;
			break;
		}
		
		switch(theState) {
		case OPEN:
			writeNamespaceDeclarations();
			theWriter.write(TAG_CLOSE_EMPTY);
			break;
			
		case CONTENT:
			theWriter.write(END_TAG_OPEN);
			writeName(theName);
			theWriter.write(XMLChar.GREATER_THAN_CHAR);
			break;
		}
		
		theNamespace.clear();
		
		theState = State.CLOSED;
		
		theWriter.flush();
		
		theName = null;
	}

	// *** Public Methods ***

	// *** Protected Methods ***
	protected BasicElementWriter createChildElementWriter(XMLChunkWriter out) {
		
		return new BasicElementWriter(out);
	}

	// *** Package Methods ***
	void content() throws IOException {
		
		switch(theState) {
		case CLOSED:
			throw new MalformedXMLException("Content written on closed ElementWriter.");
			
		case CONTENT:
		case TEXT:
		case CHILD:
			return; // already has content
		
		case OPEN_NEEDS_SPACE:
			//theWriter.write(XMLChar.SPACE_CHAR); // actually don't want this
		}
		
		writeNamespaceDeclarations();
		
		theWriter.write(XMLChar.GREATER_THAN_CHAR);
		
		theState = State.CONTENT;
	}

	// *** Private Methods ***
	
	private final void prepareChildElementWriter() {
		
		if (theCurrentChild == null)
			theCurrentChild = createChildElementWriter(theWriter);
		
		theCurrentChild.prepareNamespace(theNamespace);
	}
	
	private void prepareForContent() throws IOException {
		switch(theState) {
		case CLOSED:
		case OPEN:
		case OPEN_NEEDS_SPACE:
			content();
			break;
			
		case TEXT:
			theTextWriter.close();
			break;
		
		case CHILD:
			theCurrentChild.close();
			break;
		}
		
		theState = State.CONTENT;
	}
	
	private final void writeName(Name name) throws IOException {
		NamespaceURI uri = name.getNamespaceURI();
		if (uri == null || theNamespace.isDefaultNamespaceURI(uri)) {
			
			theWriter.write(name);
			
		} else {
			
			theWriter.write(theNamespace.namespaceURIPrefix(uri));
			theWriter.write(XMLChar.COLON_CHAR);
			theWriter.write(name);
		}
	}
	
	private final void writeNamespaceDeclarations() throws IOException {
		
		if (!theNamespace.isOpen())
			throw new MalformedXMLException("can't write namespace declaration more than once");
		
		NamespaceURI defaultNS = theNamespace.getOwnDefaultNamespaceURI();
		if (defaultNS != null) {
			theWriter.write(Whitespace.SPACE);
			theWriter.write(NamespaceURI.XMLNS_PREFIX);
			theWriter.write(XMLChar.EQUALS_CHAR);
			XMLChar q = defaultNS.getQuoteChar();
			theWriter.write(q);
			theWriter.write(defaultNS);
			theWriter.write(q);
		}
		
		List<NamespaceURI> prefixed = theNamespace.getOwnPrefixedNamespaceURIs();
		if (prefixed != null && !prefixed.isEmpty()) {
			int len = prefixed.size();
			for (int i = 0 ; i < len ; i++) {
				NamespaceURI uri = prefixed.get(i);
				theWriter.write(Whitespace.SPACE);
				theWriter.write(NamespaceURI.XMLNS_PREFIX);
				theWriter.write(XMLChar.COLON_CHAR);
				theWriter.write(uri.getPreferredPrefix());
				theWriter.write(XMLChar.EQUALS_CHAR);
				XMLChar q = uri.getQuoteChar();
				theWriter.write(q);
				theWriter.write(uri);
				theWriter.write(q);
			}
		}
			
		theNamespace.close();
	}

	// *** Private Classes ***

}






// end