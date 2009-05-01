/*
	XOMContentLoader.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.content.xom;

import java.io.*;

import org.xml.sax.InputSource;

import net.markout.MalformedXMLException;
import net.markout.content.AbstractContentLoader;
import net.markout.content.ContentParsingException;
import net.markout.content.SelectableContent;
import nu.xom.ParsingException;

/**
 * XOMContentLoader
 * 
 * Comment here.
 */
public class XOMContentLoader extends AbstractContentLoader {
	// *** Class Members ***

	// *** Instance Members ***
	private MarkoutBuilder builder;

	// *** Constructors ***
	public XOMContentLoader() {
		
		builder = new MarkoutBuilder();
	}

	// *** AbstractContentLoader Methods ***
	protected SelectableContent parseDocument(InputSource xml) throws IOException, MalformedXMLException {
		
		// This is all very annoying- Xom Builder should accept an InputSource,
		// and it should allow me to set the character encoding for an inputstream
		try {
			
			String systemID = xml.getSystemId();
			Reader r = null;
			
			InputStream is = xml.getByteStream();
			String encoding = xml.getEncoding();
			
			if (is != null && encoding != null) {
				// switch to a Reader since it looks like XOM doesn't accept char encoding
				try {
					r = new InputStreamReader(is, encoding);
				} catch (UnsupportedEncodingException uee) {
					// do nothing, reader will be null
				}
			}
			
			if (r == null && is != null) {
				if (systemID != null)
					return (MDocument) builder.build(is, systemID);
				else
					return (MDocument) builder.build(is);
			}
			
			if (r == null)
				r = xml.getCharacterStream();
			if (r != null) {
				if (systemID != null)
					return (MDocument) builder.build(r, systemID);
				else
					return (MDocument) builder.build(r);
			}
			
			return (MDocument) builder.build(systemID);
			
		} catch (ParsingException pe) {
			
			throw new ContentParsingException("Xom parser encountered a problem", pe);
		}
	}

	// *** Public Methods ***

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}
