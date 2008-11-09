/*
	StandardContentWriter.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.support;

// *** imports ***

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import net.markout.*;
import net.markout.dtd.*;
import net.markout.types.*;

/**
 * StandardContentWriter
 *
 * Comment here.  Author: David Fogel
 */
class StandardContentWriter implements ContentWriter {
	// *** Class Members ***
	
	private static final XMLString COMMENT_START = new XMLString("<!--");
	private static final XMLString COMMENT_END = new XMLString("-->");
	
	private static final XMLString PI_START = new XMLString("<?");
	private static final XMLString PI_END = new XMLString("?>");

	// *** Instance Members ***
	
	private TextWriter theTextWriter;
	
	private XMLChunkWriter theWriter;
	
	private StandardElementWriter theParent;
	
	private StandardElementWriter theCurrentElement;
	
	private StandardDocumentWriter theDocWriter;
	
	private DTD theDTD;
	private DocumentValidator theDocValidator;
	private ElementType theElementType;
	private ContentValidator theValidator;
	
	private boolean isOpen;
	private boolean hasElement;
	private boolean hasText;

	// *** Constructors ***
	
	public StandardContentWriter(StandardElementWriter parent) {
		
		theParent = parent;
		
		theDocWriter = parent.getDocumentWriter();
		
		theWriter = theDocWriter.getXMLChunkWriter();
		
		theDTD = theDocWriter.getDTD();
		theDocValidator = theDocWriter.getDocumentValidator();
		
		theTextWriter = null;
		
		theCurrentElement = null;
		
		isOpen = false;
		hasElement = false;
		hasText = false;
	}

	// *** ContentWriter Methods ***
	
	public List<Name> getElementNameStack() {
		
		return theParent.getElementNameStack();
	}
	
	public Name getName() {
		
		return theParent.getName();
	}
	
	public void text(Text text) throws IOException {
		
		checkOpen();
		
		closeChildren();
		
		if (theDTD != null) {
			if ( ! theValidator.validateCharData())
				throw new ValidationException("Element " + theElementType.getName() +" can't contain character data");
		}
		
		theWriter.write(text);
	}
	
	public void text(String text) throws IOException {
		
		text().write(text);
	}
	
	public Writer text() throws IOException {
		
		checkOpen();
		
		if (hasText)
			return theTextWriter;
		
		closeChildren();
		
		if (theDTD != null) {
			if ( ! theValidator.validateCharData())
				throw new ValidationException("Element " + theElementType.getName() +" can't contain character data");
		}
		
		if (theTextWriter == null)
			theTextWriter = new TextWriter(theWriter);
		
		theTextWriter.open();
		
		hasText = true;
		
		return theTextWriter;
	}
	
	public void characters(CharData charData) throws IOException {
		
		checkOpen();
		
		closeChildren();
		
		if (theDTD != null) {
			if ( ! theValidator.validateCharData())
				throw new ValidationException("Element " + theElementType.getName() +" can't contain character data");
		}
		
		theWriter.write(charData);
	}
	
	public void cdata(CData cdata) throws IOException {
		
		checkOpen();
		
		closeChildren();
		
		if (theDTD != null) {
			if ( ! theValidator.validateCharData())
				throw new ValidationException("Element " + theElementType.getName() +" can't contain character data");
		}
		
		theWriter.write(cdata);
	}
	
	public void reference(CharRef charRef) throws IOException {
		
		checkOpen();
		
		closeChildren();
		
		if (theDTD != null) {
			if ( ! theValidator.validateCharData())
				throw new ValidationException("Element " + theElementType.getName() +" can't contain character data");
		}
		
		theWriter.write(charRef);
	}
	
	public void reference(Name entityName) throws IOException {

		checkOpen();
		
		closeChildren();
		
		if (theDTD != null) {
			
			// TODO we need to re-do EntityValues so that we can inspect them to find
			// out if they contain characters or markup.  This is a pain.
			// For now, we assume entity references contain character data.
			if ( ! theValidator.validateCharData())
				throw new ValidationException("Element " + theElementType.getName() +" can't contain character data");
		}
		
		theWriter.write(XMLChar.AMPERSAND_CHAR);
		theWriter.write(entityName);
		theWriter.write(XMLChar.SEMICOLON_CHAR);
	}
	
	
	public ElementWriter elementWriter(Name elementType) throws IOException {
		
		checkOpen();
		
		closeChildren();
		
		if (theDTD != null) {
			
			if (! theValidator.validateNext(elementType))
				throw new ValidationException(
						"Element " + theElementType.getName() +" can't contain child element " +
						elementType + " at this location. ContentModel is: " +
						theElementType.getContentModel());
			
			theDocValidator.validateDescendant(elementType);
		}
		
		if (theCurrentElement == null)
			theCurrentElement = new StandardElementWriter(theDocWriter);
		
		theCurrentElement.open(elementType, theParent.getElementNameStack());
		
		hasElement = true;
		
		return theCurrentElement;
	}
	
	public ContentWriter element(Name elementType) throws IOException {
		return elementWriter(elementType).content();
	}
	
	public ContentWriter element(Name elementType, Attributes attributes) throws IOException {
		elementWriter(elementType);
		if (attributes != null) {
			attributes.writeTo(theCurrentElement);
		}
		return theCurrentElement.content();
	}
	
	public void emptyElement(Name elementType) throws IOException {
		elementWriter(elementType);
		closeChildren();
	}
	
	public void emptyElement(Name elementType, Attributes attributes) throws IOException {
		elementWriter(elementType);
		if (attributes != null) {
			attributes.writeTo(theCurrentElement);
		}
		closeChildren();
	}
	
	
	public void comment(Comment c) throws IOException {
		
		checkOpen();
		
		closeChildren();
		
		theWriter.write(COMMENT_START);
		theWriter.write(c);
		theWriter.write(COMMENT_END);
	}
	
	public void pi(Target target, Instruction instruction) throws IOException {
		
		checkOpen();
		
		closeChildren();
		
		theWriter.write(PI_START);
		theWriter.write(target);
		if (instruction != null) {
			theWriter.write(XMLChar.SPACE_CHAR);
			theWriter.write(instruction);
		}
		theWriter.write(PI_END);
	}
	
	public void space(Whitespace space) throws IOException {
		
		checkOpen();
		
		closeChildren();
		
		theWriter.write(space);
	}
	

	// *** Public Methods ***
	
	public void open() throws IOException {
		
		if (isOpen)
			throw new MalformedXMLException("ContentWriter already open.");
		
		if (theDTD != null) {
			theElementType = theParent.getElementType();
			theValidator = theElementType.getContentModel().getValidator();
		}
		
		isOpen = true;
	}
	
	public boolean isOpen() {
		return isOpen;
	}
	
	public void close() throws IOException {
		
		closeChildren();
		
		if (theDTD != null) {
			
			if ( ! theValidator.validateClose())
				throw new ValidationException(
						"Element " + theElementType.getName() +
						" can't be closed at this location. ContentModel is: " +
						theElementType.getContentModel());
			
			theElementType = null;
		}
		
		isOpen = false;
	}
	
	public ElementWriter currentElementWriter() {
		
		checkOpen();
		
		if (hasElement)
			return theCurrentElement.current();
		else
			return theParent;
	}
	
	public ElementWriter currentElementWriter(int depth) {
		
		checkOpen();
		
		int parentDepth = theParent.depth();
		
		if (depth < parentDepth)
			throw new IllegalArgumentException("Depth can't be less than element depth.");
		
		if (parentDepth == depth)
			return theParent;
		
		if (!hasElement)
			throw new IllegalArgumentException("requested depth is greater than current element depth");
			
		return theCurrentElement.current(depth);
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***
	
	private final void checkOpen() {
		if (!isOpen)
			throw new MalformedXMLException("Can't write element content at this location.");
	}
	
	private final void closeChildren() throws IOException {
		
		if (hasElement) {
			
			theCurrentElement.close();
			hasElement = false;
		
		} else if (hasText) {
			
			theTextWriter.close();
			hasText = false;
		}
	}

	// *** Private Classes ***
}










// end
