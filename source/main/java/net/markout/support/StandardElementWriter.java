/*
	StandardElementWriter.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.support;

// *** imports ***

import java.io.IOException;
import java.util.List;
import java.util.Set;

import net.markout.*;
import net.markout.dtd.*;
import net.markout.types.*;

/**
 * StandardElementWriter
 *
 * Comment here.  Author: David Fogel
 */
class StandardElementWriter implements ElementWriter {
	// *** Class Members ***

	// *** Instance Members ***
	
	private boolean isOpen;
	private boolean needsSpace;
	private boolean hasContent;
	
	private ElementNameStack theElementNameStack;
	
	private Name theName;
	private ElementWhitespacePolicy theWhitespacePolicy;
	
	private XMLChunkWriter theWriter;
	
	private StandardContentWriter theContentWriter;
	
	private StandardDocumentWriter theDocWriter;
	
	private DTD theDTD;
	private DocumentValidator theDocValidator;
	
	private ElementType theElementType;
	private AttributeValidator theAttValidator;

	// *** Constructors ***
	
	public StandardElementWriter(StandardDocumentWriter docWriter) {
		
		theDocWriter = docWriter;
		
		theWriter = theDocWriter.getXMLChunkWriter();
		
		theDTD = theDocWriter.getDTD();
		theDocValidator = theDocWriter.getDocumentValidator();
		
		theName = null;
		theWhitespacePolicy = null;
		
		theContentWriter = null;
		
		isOpen = false;
		needsSpace = false;
		hasContent = false;
	}

	// *** ElementWriter Methods ***
	
	public Name getName() {
		if (!isOpen)
			throw new MalformedXMLException("getName called on closed ElementWriter.");
		
		return theName;
	}
	
	public List<Name> getElementNameStack() {
		
		if (!isOpen)
			throw new IllegalStateException("ElementNameStack accessed on a closed ElementWriter.");
		
		return theElementNameStack;
	}
	
	public void attributes(Attributes attributes) throws IOException {
		
		attributes.writeTo(this);
	}
	
	public void attribute(Name name, AttValue value) throws IOException{
		
		checkOpen();
		
		if (hasContent)
			throw new MalformedXMLException("Attribute written after element content.");
		
		if (theDTD != null) {
			theAttValidator.validateNext(name, value, theDocValidator);
		}
		
		if (needsSpace) {
			Whitespace betweenSpace = theWhitespacePolicy.betweenAttributes(depth());
			if (betweenSpace != null)
				theWriter.write(betweenSpace);
			else // need minimum whitespace:
				theWriter.write(XMLChar.SPACE_CHAR);
		}
		
		theWriter.write(name);
		theWriter.write(XMLChar.EQUALS_CHAR);
		theWriter.write(value);
		
		needsSpace = true;
	}
	
	public void space(Whitespace space) throws IOException {
		
		checkOpen();
		
		if (hasContent)
			throw new MalformedXMLException("whitespace written after element content.");
		
		theWriter.write(space);
		
		needsSpace = false;
	}
	
	public ContentWriter content() throws IOException {
		
		checkOpen();
		
		if (hasContent)
			return theContentWriter;
		
		if (theDTD != null) {
			if (theElementType.getContentModel() == ContentModel.EMPTY)
				throw new ValidationException("Elements with EMPTY content model can't have content.");
		}		
		writeIfNotNull(theWhitespacePolicy.afterLastAttribute(depth()));
		
		theWriter.write(XMLChar.GREATER_THAN_CHAR);
		
		writeIfNotNull(theWhitespacePolicy.afterStartTag(depth()));
		
		if (theContentWriter == null)
			theContentWriter = new StandardContentWriter(this);
		
		theContentWriter.open();
		
		hasContent = true;
		needsSpace = false;
		
		return theContentWriter;
	}
	
	// *** Public Methods ***
	
	private static final XMLString TAG_CLOSE_EMPTY = new XMLString("/>");
	private static final XMLString END_TAG_OPEN = new XMLString("</");
	
	public void open(Name elementName) throws IOException {
		open(elementName, null);
	}
	
	public void open(Name elementName, List<Name> parentElementNames) throws IOException {
		
		if (isOpen)
			throw new MalformedXMLException("ElementWriter already open.");
		
		if (theDTD != null) {
			
			theElementType = theDTD.getElementType(elementName);
			
			theAttValidator = theElementType.getAttributeValidator();
			
			Set<Name> prohibitions = theElementType.getDescendantProhibitions();
			if ( ! prohibitions.isEmpty())
				theDocValidator.pushProhibitionSet(prohibitions);
		}
		
		theName = elementName;
		if (theElementNameStack == null || theElementNameStack.getParent() != parentElementNames)
			theElementNameStack = new ElementNameStack(parentElementNames, elementName);
		else
			theElementNameStack.set(elementName);
		
		theWhitespacePolicy = theDocWriter.getWhitespacePolicy().forElement(theName);
		
		// NOTE - this block used to be at the bottom, but now depth() calls CheckOpen, so - REVISIT
		isOpen = true;
		needsSpace = true;
		hasContent = false;
		
		writeIfNotNull(theWhitespacePolicy.beforeElement(depth()));
		
		theWriter.write(XMLChar.LESS_THAN_CHAR);
		theWriter.write(theName);
	}
	
	public boolean isOpen() {
		return isOpen;
	}
	
	public void close() throws IOException {
		
		checkOpen();
		
		if (theDTD != null) {
			
			theAttValidator.close();
			
			Set<Name> prohibitions = theElementType.getDescendantProhibitions();
			if ( ! prohibitions.isEmpty())
				theDocValidator.popProhibitionSet();
			
			theElementType = null;
		}
		
		if (!hasContent) {
			
			writeIfNotNull(theWhitespacePolicy.afterLastAttribute(depth()));
			
			theWriter.write(TAG_CLOSE_EMPTY);
			
			writeIfNotNull(theWhitespacePolicy.afterEmptyElement(depth()));
			
		} else { // CONTENT has been created.
			
			theContentWriter.close();
			
			writeIfNotNull(theWhitespacePolicy.beforeEndTag(depth()));
			
			theWriter.write(END_TAG_OPEN);
			theWriter.write(theName);
			theWriter.write(XMLChar.GREATER_THAN_CHAR);
			
			writeIfNotNull(theWhitespacePolicy.afterEndTag(depth()));
		}
				
		isOpen = false;
		hasContent = false;
		needsSpace = false;
		
		theWriter.flush();
	}
	
	public StandardDocumentWriter getDocumentWriter() {
		return theDocWriter;
	}
	
	public int depth() {
		
		checkOpen();
		
		return theElementNameStack.size() - 1;
	}
	
	public ElementWriter current() {
		
		checkOpen();
		
		if (!hasContent)
			return this;
		
		return theContentWriter.currentElementWriter();
	}
	
	public ElementWriter current(int depth) {
		
		checkOpen();
		
		if (depth < depth())
			throw new IllegalArgumentException("Depth can't be less than element depth.");
		
		if (depth == depth())
			return this;
		
		if (!hasContent)
			throw new IllegalArgumentException("requested depth is greater than current element depth");
		
		return theContentWriter.currentElementWriter(depth);
	}
	
	public ElementType getElementType() {
		return theElementType;
	}

	// *** Protected Methods ***
	
	protected final void writeIfNotNull(XMLChunk chunk) throws IOException {
		if (chunk != null)
			theWriter.write(chunk);
	}

	// *** Package Methods ***

	// *** Private Methods ***
	
	private final void checkOpen() {
		if ( !isOpen)
			throw new MalformedXMLException("ElementWriter is closed.");
	}

	// *** Private Classes ***
}










// end
