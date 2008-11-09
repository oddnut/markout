/*
	SAXContentHandlerAdapter.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.support;

// *** imports ***

import java.io.IOException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.*;
import org.xml.sax.ext.DeclHandler;
import org.xml.sax.ext.LexicalHandler;

import net.markout.*;
import net.markout.dtd.ValidationException;
import net.markout.types.*;

/**
 * SAXContentHandlerAdapter
 *
 * Comment here.  Author: David Fogel
 */
public class SAXContentHandlerAdapter 
	implements DTDHandler, ContentHandler, ErrorHandler, 
				DeclHandler, LexicalHandler {
	// *** Class Members ***
	
	private static Logger LOG = LoggerFactory.getLogger(SAXContentHandlerAdapter.class);

	// *** Instance Members ***
	
	private Locator theLocator;
	
	private DocumentWriter theDocWriter;
	
	private ArrayList theStack;
	
	private DTDWriter theDTDWriter;

	// *** Constructors ***
	public SAXContentHandlerAdapter(DocumentWriter docWriter) {
		theDocWriter = docWriter;
		theStack = new ArrayList();
	}

	// *** ContentHandler Methods ***
	
	public void setDocumentLocator (Locator locator) {
		theLocator = locator;
	}
	
	public void startDocument () throws SAXException {
		try {
			
			theDocWriter.xmlVersion();
			
		} catch (IOException ioe) {LOG.error("IOException", ioe);}
		catch (IllegalXMLException xmle) {LOG.error("Bad XML {}", getLocationString(), xmle);}
		catch (ValidationException ve) {LOG.error("Invalid XML {}", getLocationString(), ve);}
	}
	
	public void endDocument() throws SAXException {
		try {
			
			theDocWriter.close();
			
		} catch (IOException ioe) {LOG.error("IOException", ioe);}
		catch (IllegalXMLException xmle) {LOG.error("Bad XML {}", getLocationString(), xmle);}
		catch (ValidationException ve) {LOG.error("Invalid XML {}", getLocationString(), ve);}
	}
	
	public void startPrefixMapping (String prefix, String uri) throws SAXException {
		// ignore
	}
	
	public void endPrefixMapping (String prefix) throws SAXException {
		// ignore
	}
	
	public void startElement (String namespaceURI, String localName,
			String qName, org.xml.sax.Attributes atts) throws SAXException {
		
		try {
			ElementWriter ew = peek();
			if (ew != null) {
				
				ew = ew.content().elementWriter(new Name(qName));
				
			} else {
				// at root element;
				ew = theDocWriter.rootElementWriter(new Name(qName));
			}
			
			int n = atts.getLength();
			for (int i = 0 ; i < n ; i++) {
				ew.attribute(new Name(atts.getQName(i)), new AttValue(atts.getValue(i)));
			}
			
			push(ew);
			
		} catch (IOException ioe) {LOG.error("IOException", ioe);}
		catch (IllegalXMLException xmle) {LOG.error("Bad XML {}", getLocationString(), xmle);}
		catch (ValidationException ve) {LOG.error("Invalid XML {}", getLocationString(), ve);}
	}
	
	public void endElement (String namespaceURI, String localName, String qName) throws SAXException {
		
			/*ElementWriter ew = */pop();
	}
	
	public void characters (char ch[], int start, int length) throws SAXException {
		try {
			ElementWriter ew = peek();
			
			if (ew != null) {
				
				boolean isReallyWhitespace = true;
				for (int i = start ; i < (start + length) ; i++) {
					if ( ! XMLChar.isWhiteSpaceChar(ch[i])) {
						isReallyWhitespace = false;
						break;
					}
				}
				
				if (isReallyWhitespace)
					ew.content().space(new Whitespace(new String(ch, start, length)));
				else
					ew.content().text().write(ch, start, length);
				
			} else {
				// this shouldn't happen, because characters should only
				// arrive at element content.  I think.
				LOG.warn("Got characters outside of root element, converting to comment, {}", 
						getLocationString());
				
				theDocWriter.comment(new Comment(new String(ch, start, length)));
				
			}
			
		} catch (IOException ioe) {LOG.error("IOException", ioe);}
		catch (IllegalXMLException xmle) {LOG.error("Bad XML {}", getLocationString(), xmle);}
		catch (ValidationException ve) {LOG.error("Invalid XML {}", getLocationString(), ve);}
	}
	
	public void ignorableWhitespace (char ch[], int start, int length) throws SAXException {
		try {
			ElementWriter ew = peek();
			
			if (ew != null) {
				
				ew.content().space(new Whitespace(new String(ch, start, length)));
				
			} else {
				
				theDocWriter.space(new Whitespace(new String(ch, start, length)));
				
			}
			
		} catch (IOException ioe) {LOG.error("IOException", ioe);}
		catch (IllegalXMLException xmle) {LOG.error("Bad XML {}", getLocationString(), xmle);}
		catch (ValidationException ve) {LOG.error("Invalid XML {}", getLocationString(), ve);}
	}
	
	public void processingInstruction (String target, String data) throws SAXException {
		try {
			ElementWriter ew = peek();
			
			if (ew != null) {
				
				ew.content().pi(new Target(target), new Instruction(data));
				
			} else {
				
				theDocWriter.pi(new Target(target), new Instruction(data));
				
			}
			
		} catch (IOException ioe) {LOG.error("IOException", ioe);}
		catch (IllegalXMLException xmle) {LOG.error("Bad XML {}", getLocationString(), xmle);}
		catch (ValidationException ve) {LOG.error("Invalid XML {}", getLocationString(), ve);}
	}
	
	public void skippedEntity (String name) throws SAXException {
		try {
			ElementWriter ew = peek();
			
			if (ew != null) {
				
				// not sure if this is right.  going to try:
				ew.content().reference(new Name(name));
				
			} else {
				// really don't know what this would be.
				// maybe in the DTD?
				LOG.warn("skipping Entity: " + name + getLocationString());
			}
			
		} catch (IOException ioe) {LOG.error("IOException", ioe);}
		catch (IllegalXMLException xmle) {LOG.error("Bad XML {}", getLocationString(), xmle);}
		catch (ValidationException ve) {LOG.error("Invalid XML {}", getLocationString(), ve);}
	}
	
	// *** DTDHandler Methods ***
	
	public void notationDecl (String name, String publicId, String systemId) throws SAXException {
		// waiting for DTDWriter
	}
	
	public void unparsedEntityDecl (String name, String publicId, 
							String systemId, String notationName) throws SAXException {
		
		// waiting for DTDWriter
	}
	
	// *** DeclHandler Methods ***
	
	public void elementDecl (String name, String model) throws SAXException {
		// just for testing..
		/*try {
			theDocWriter.comment(new Comment("Element Declared: " + name + " : " + model));
		} catch (IOException ioe) {LOG.error("IOException", ioe);}
		catch (IllegalXMLException xmle) {LOG.error("Bad XML", xmle);}*/
	}
	
	public void attributeDecl (String eName,
								String aName,
								String type,
								String valueDefault,
								String value) throws SAXException {
		
		// just for testing..
		/*try {
			theDocWriter.comment(new Comment("Attribute: element:" + eName + 
												" name: " + aName +
												" type: " + type +
												" default: " + valueDefault +
												" value: " + value));
		} catch (IOException ioe) {LOG.error("IOException", ioe);}
		catch (IllegalXMLException xmle) {LOG.error("Bad XML", xmle);}*/
	}
	
	public void internalEntityDecl (String name, String value) throws SAXException {
		// just for testing..
		/*try {
			theDocWriter.comment(new Comment("Internal Entity: " + name + " = " + value));
		} catch (IOException ioe) {LOG.error("IOException", ioe);}
		catch (IllegalXMLException xmle) {LOG.error("Bad XML", xmle);}*/
	}
	
	public void externalEntityDecl (String name, String publicId, String systemId)
		throws SAXException {
		
		// just for testing..
		/*try {
			theDocWriter.comment(new Comment("External Entity: " + name + " = " + 
												publicId + ", " + systemId));
		} catch (IOException ioe) {LOG.error("IOException", ioe);}
		catch (IllegalXMLException xmle) {LOG.error("Bad XML", xmle);}*/
	}
	
	// *** LexicalHandler Methods ***
	
	public void startDTD (String name, String publicId, String systemId) throws SAXException {
		try {
			
			theDTDWriter = theDocWriter.dtd(new Name(name), new PublicIDLiteral(publicId), new SystemLiteral(systemId));
		
		} catch (IOException ioe) {LOG.error("IOException", ioe);}
		catch (IllegalXMLException xmle) {LOG.error("Bad XML", xmle);}
		catch (ValidationException ve) {LOG.error("Invalid XML" + getLocationString(), ve);}
	}
	
	public void endDTD () throws SAXException {
		
		theDTDWriter = null;
		// it'll auto-close
	}
	
	public void startEntity (String name) throws SAXException {
		//LOG.warn("startEntity: " + name);
	}
	
	public void endEntity (String name) throws SAXException {
		//LOG.warn("endEntity: " + name);
	}
	
	public void startCDATA () throws SAXException {
		// we don't really care about CData, text() will take care of it.
	}
	
	public void endCDATA () throws SAXException {
		// we don't really care about CData, text() will take care of it.	
	}
	
	public void comment (char ch[], int start, int length) throws SAXException {
		try {
			
			Comment c = new Comment(new String(ch, start, length));
			ElementWriter ew = peek();
			if (ew != null) {
				
				ew.content().comment(c);
				
			} else if (theDTDWriter != null) {
				
				// ignore for now.
				
			} else {
				
				theDocWriter.comment(c);
			}
			
		} catch (IOException ioe) {LOG.error("IOException", ioe);}
		catch (IllegalXMLException xmle) {LOG.error("Bad XML {}", getLocationString(), xmle);}
		catch (ValidationException ve) {LOG.error("Invalid XML {}", getLocationString(), ve);}
	}
	
	// *** ErrorHandler Methods ***
	
	public void warning (SAXParseException exception) throws SAXException {
		//LOG.warn("SAXParser warning" + getLocationString(), exception);
	}
	
	public void error (SAXParseException exception) throws SAXException {
		LOG.error("SAXParser error" + getLocationString(), exception);
	}
	
	public void fatalError (SAXParseException exception) throws SAXException {
		LOG.error("Fatal SAXParser error {}", getLocationString(), exception);
	}

	// *** Public Methods ***

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***
	
	private void push(ElementWriter elWriter) {
		theStack.add(elWriter);
	}
	
	private ElementWriter peek() {
		
		if (theStack.isEmpty())
			return null;
		
		return (ElementWriter) theStack.get(theStack.size() - 1);
	}
	
	private ElementWriter pop() {
		
		if (theStack.isEmpty())
			return null;
		
		return (ElementWriter) theStack.remove(theStack.size() - 1);
	}
	
	private String getLocationString() {
		if (theLocator != null)
			return "(line " + theLocator.getLineNumber() + 
					", column " + theLocator.getColumnNumber() + ") ";
		return " (unknown location) ";
	}

	// *** Private Classes ***
}










/* end */
