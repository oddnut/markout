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
import net.markout.content.Content;
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
	
	private enum State {CLOSED, OPEN, CONTENT, TEXT, CHILD}

	// *** Instance Members ****
	
	private XMLOutputContext out;
	
	private TextWriter textWriter;
	
	private BasicElementWriter currentChild;
	
	private Name name;
	
	private Namespace namespace;
	
	private ElementNameStack elementNameStack;
	
	private State state;

	// *** Constructors ***
	
	public BasicElementWriter(XMLOutputContext out) {
		
		this.out = out;
		textWriter = null;
		currentChild = null;
		name = null;
		namespace = new Namespace();
		elementNameStack = null;
		
		state = State.CLOSED;
	}
	
	// *** ElementWriter Methods ***
	
	// --- Namespace ---
	public void prepareNamespace(Namespace parentNamespace) {
		if (state != State.CLOSED)
			throw new MalformedXMLException("ElementWriter already opened.");
		
		namespace.setParent(parentNamespace);
	}
	
	// --- Opening ---
	public void open(Name elementName) throws IOException {
		open(elementName, null);
	}
	
	public void open(Name elementName, List<Name> parentElementNames) throws IOException {
		
		if (state != State.CLOSED)
			throw new MalformedXMLException("ElementWriter already opened.");
		state = State.OPEN;
		
		name = elementName;
		
		if (elementNameStack == null || elementNameStack.getParent() != parentElementNames)
			elementNameStack = new ElementNameStack(parentElementNames, elementName);
		else
			elementNameStack.set(elementName);
		
		out.writer.write(XMLChar.LESS_THAN_CHAR);
		writeName(name);
	}
	
	// --- Attributes ---
	public void attribute(Attribute att) throws IOException {
		
		switch(state) {
		case CLOSED:
			throw new MalformedXMLException("Attribute written on a closed ElementWriter");
		
		case CONTENT:
		case TEXT:
		case CHILD:
			throw new MalformedXMLException("Attribute written on an ElementWriter with content.");
			
		}
		
		state = State.OPEN;
		
		out.writer.write(XMLChar.SPACE_CHAR); // need minimum whitespace between attributes
		
		writeName(att.getName());
		out.writer.write(XMLChar.EQUALS_CHAR);
		XMLChar quoteChar = att.getQuoteChar();
		out.writer.write(quoteChar);
		out.writer.write(att);
		out.writer.write(quoteChar);
	}
	
	// --- Writer State ---
	public List<Name> getElementNameStack() {
		
		if (state == State.CLOSED)
			throw new MalformedXMLException("ElementNameStack accessed on a closed ElementWriter.");
		
		return elementNameStack;
	}
	
	public Name getName() {
		
		if (state == State.CLOSED)
			throw new MalformedXMLException("getName called on closed ContentWriter.");
		
		return name;
	}
	
	// --- Escaped Text Content ---
	public void text(Text text) throws IOException {
		
		prepareForContent();
		
		out.writer.write(text);
	}
	
	public void text(String text) throws IOException {
		
		text().write(text);
	}
	
	public Writer text() throws IOException {
		
		switch(state) {
		case CLOSED:
		case OPEN:
			content();
			break;
			
		case TEXT:
			return textWriter;
		
		case CHILD:
			currentChild.close();
			break;
		}
		
		state = State.TEXT;
		
		if (textWriter == null)
			textWriter = new TextWriter(out.writer);
		
		textWriter.open();
		
		return textWriter;
	}
	
	// --- Character Data Content---
	public void characters(CharData charData) throws IOException {
		
		prepareForContent();
		
		out.writer.write(charData);
	}
	
	public void cdata(CData cdata) throws IOException {
		
		prepareForContent();
		
		out.writer.write(cdata);
	}
	
	// --- Reference Content ---
	public void reference(CharRef charRef) throws IOException {
		
		prepareForContent();
		
		out.writer.write(charRef);
	}
	
	public void reference(Name entityName) throws IOException {

		prepareForContent();
		
		out.writer.write(XMLChar.AMPERSAND_CHAR);
		out.writer.write(entityName);
		out.writer.write(XMLChar.SEMICOLON_CHAR);
	}
	
	// --- Namespaces ---
	public void defaultNamespace(NamespaceURI uri) throws IOException {
		if (state == State.CLOSED) {
			
			namespace.setDefaultNamespaceURI(uri);
			
		} else {
			
			prepareForContent();
			
			prepareChildElementWriter();
			
			currentChild.defaultNamespace(uri);
		}
	}
	
	public void namespace(NamespaceURI uri) throws IOException {
		if (state == State.CLOSED) {
			
			namespace.namespaceURIPrefix(uri);
			
		} else {
			
			prepareForContent();
			
			prepareChildElementWriter();
			
			currentChild.namespace(uri);
		}
	}
	
	// --- Element Content ---
	public ContentWriter element(Name elementName) throws IOException {
		return element(elementName, (Attribute[]) null);
	}
	
	public ContentWriter element(Name elementName, Attribute... attributes) throws IOException {
		
		prepareForContent();
		
		state = State.CHILD;
		
		prepareChildElementWriter();
		
		currentChild.open(elementName, elementNameStack);
		
		if (attributes != null) {
			Arrays.sort(attributes);
			for (Attribute a : attributes)
				currentChild.attribute(a);
		}
		
		// Is this okay to take out?
		//currentChild.content();
		
		return currentChild;	
	}
	
	public void emptyElement(Name elementName) throws IOException {
		emptyElement(elementName, (Attribute[]) null);
	}
	
	public void emptyElement(Name elementName, Attribute... attributes) throws IOException {
		
		prepareForContent();
		
		state = State.CHILD;
		
		prepareChildElementWriter();
		
		currentChild.open(elementName, elementNameStack);
		
		if (attributes != null) {
			Arrays.sort(attributes);
			for (Attribute a : attributes)
				currentChild.attribute(a);
		}
		
		currentChild.close();
		
		state = State.CONTENT;
	}
	
	// --- Misc Content ---
	public void comment(Comment c) throws IOException {
		
		prepareForContent();
		
		out.writer.write(COMMENT_START);
		out.writer.write(c);
		out.writer.write(COMMENT_END);
	}
	
	public void pi(Target target, Instruction instruction) throws IOException {
		
		prepareForContent();
		
		out.writer.write(PI_START);
		out.writer.write(target);
		if (instruction != null) {
			out.writer.write(XMLChar.SPACE_CHAR);
			out.writer.write(instruction);
		}
		out.writer.write(PI_END);
	}
	
	public void space(Whitespace space) throws IOException {
		
		// There are two general categories for when space() is called,
		// within the open element tag, and within content.
		// notice the return after case OPEN.
		
		switch(state) {
		case CLOSED:
			throw new MalformedXMLException("Space written on a closed ElementWritter");

		case OPEN:
			out.writer.write(space);
			return;
		
		case TEXT:
			textWriter.close();
			break;
			
		case CHILD:
			currentChild.close();
			break;
		}
		
		state = State.CONTENT;
		
		out.writer.write(space);
	}
	
	// --- Custom Content ---
	public void content(Content c) throws IOException {
		c.writeTo(this);
	}
	
	// --- Closing ---
	public void close() throws IOException {
		
		switch(state) {
		case CLOSED:
			return;// It's okay to call close() more than once?
			
		case TEXT:
			textWriter.close();
			state = State.CONTENT;
			break;
			
		case CHILD:
			currentChild.close();
			state = State.CONTENT;
			break;
		}
		
		switch(state) {
		case OPEN:
			
			if (out.getEmptyElementPolicy().isRenderableAsEmptyElement(name)) {
				
				if (out.getEmptyElementPolicy().requiresSpaceBeforeClosing())
					out.writer.write(Whitespace.SPACE);
				
				writeNamespaceDeclarations();
				out.writer.write(TAG_CLOSE_EMPTY);
				break;  // <- notice this break
			}
			//else
			content();
			// fall through!
			
		case CONTENT:
			out.writer.write(END_TAG_OPEN);
			writeName(name);
			out.writer.write(XMLChar.GREATER_THAN_CHAR);
			break;
		}
		
		namespace.clear();
		
		state = State.CLOSED;
		
		out.writer.flush();
		
		name = null;
	}

	// *** Public Methods ***

	// *** Protected Methods ***
	protected BasicElementWriter createChildElementWriter(XMLOutputContext out) {
		
		return new BasicElementWriter(out);
	}

	// *** Package Methods ***
	void content() throws IOException {
		
		switch(state) {
		case CLOSED:
			throw new MalformedXMLException("Content written on closed ElementWriter.");
			
		case CONTENT:
		case TEXT:
		case CHILD:
			return; // already has content
		}
		
		writeNamespaceDeclarations();
		
		out.writer.write(XMLChar.GREATER_THAN_CHAR);
		
		state = State.CONTENT;
	}

	// *** Private Methods ***
	
	private final void prepareChildElementWriter() {
		
		if (currentChild == null)
			currentChild = createChildElementWriter(out);
		
		currentChild.prepareNamespace(namespace);
	}
	
	private void prepareForContent() throws IOException {
		switch(state) {
		case CLOSED:
		case OPEN:
			content();
			break;
			
		case TEXT:
			textWriter.close();
			break;
		
		case CHILD:
			currentChild.close();
			break;
		}
		
		state = State.CONTENT;
	}
	
	private final void writeName(Name name) throws IOException {
		NamespaceURI uri = name.getNamespaceURI();
		if (uri == null || namespace.isDefaultNamespaceURI(uri)) {
			
			out.writer.write(name);
			
		} else {
			
			out.writer.write(namespace.namespaceURIPrefix(uri));
			out.writer.write(XMLChar.COLON_CHAR);
			out.writer.write(name);
		}
	}
	
	private final void writeNamespaceDeclarations() throws IOException {
		
		if (!namespace.isOpen())
			throw new MalformedXMLException("can't write namespace declaration more than once");
		
		NamespaceURI defaultNS = namespace.getOwnDefaultNamespaceURI();
		if (defaultNS != null) {
			out.writer.write(Whitespace.SPACE);
			out.writer.write(NamespaceURI.XMLNS_PREFIX);
			out.writer.write(XMLChar.EQUALS_CHAR);
			XMLChar q = defaultNS.getQuoteChar();
			out.writer.write(q);
			out.writer.write(defaultNS);
			out.writer.write(q);
		}
		
		List<NamespaceURI> prefixed = namespace.getOwnPrefixedNamespaceURIs();
		if (prefixed != null && !prefixed.isEmpty()) {
			int len = prefixed.size();
			for (int i = 0 ; i < len ; i++) {
				NamespaceURI uri = prefixed.get(i);
				out.writer.write(Whitespace.SPACE);
				out.writer.write(NamespaceURI.XMLNS_PREFIX);
				out.writer.write(XMLChar.COLON_CHAR);
				out.writer.write(uri.getPreferredPrefix());
				out.writer.write(XMLChar.EQUALS_CHAR);
				XMLChar q = uri.getQuoteChar();
				out.writer.write(q);
				out.writer.write(uri);
				out.writer.write(q);
			}
		}
			
		namespace.close();
	}

	// *** Private Classes ***

}






// end