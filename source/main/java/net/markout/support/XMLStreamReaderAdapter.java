/*
	XMLStreamReaderAdapter.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.support;

import java.io.IOException;
import java.util.*;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import static javax.xml.stream.XMLStreamConstants.*;

import net.markout.*;

/**
 * XMLStreamReaderAdapter
 * 
 * Comment here.
 */
public class XMLStreamReaderAdapter {
	// *** Class Members ***

	// *** Instance Members ***
	

	// *** Constructors ***
	public XMLStreamReaderAdapter() {
		
	}

	// *** Interface Methods ***

	// *** Public Methods ***
	public void write(XMLStreamReader in, DocumentWriter out) throws IOException, XMLStreamException {
		write(in, out, null);
	}
	
	public void write(XMLStreamReader in, ContentWriter out) throws IOException, XMLStreamException {
		write(in, null, out);
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***
	private void write(XMLStreamReader in, DocumentWriter doc, ContentWriter cw) throws IOException, XMLStreamException {
		
		List<ContentWriter> stack = new ArrayList<ContentWriter>();
		if (cw != null)
			stack.add(cw);
		
		while (in.hasNext()) {
			int type = in.next();
			
			switch(type) {
			
			case START_DOCUMENT:
				if (doc != null) {
					String version = in.getVersion();
					//shouldn't do this, we don't want to risk mis-labeling the encoding, which is set on the document writer outside the scope of this class...
					//String enc = in.getCharacterEncodingScheme();
					// similar with "standalone"
					if (version != null)
						doc.xmlVersion();
				}
				break;
				
			case DTD:
				if (doc != null) {
					// STOPPED HERE
				}
				break;
				
			case NOTATION_DECLARATION:
				
				break;
				
			case ENTITY_DECLARATION:
				
				break;
				
			case START_ELEMENT:
				
				break;
				
			case ATTRIBUTE:
				
				break;
				
			case NAMESPACE:
				
				break;
				
			case CHARACTERS:
				
				break;
				
			case CDATA:
				
				break;
				
			case SPACE:
				
				break;
				
			case COMMENT:
				
				break;
				
			case ENTITY_REFERENCE:
				
				break;
				
			case PROCESSING_INSTRUCTION:
				
				break;
				
			case END_ELEMENT:
				
				break;
				
			case END_DOCUMENT:
				
				break;
				
			
			
			}
		}
	}

	// *** Private Classes ***
}








