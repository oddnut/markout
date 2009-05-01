/*
	ContentLoader.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.content;

import java.io.IOException;

import net.markout.MalformedXMLException;
import net.markout.types.SystemLiteral;

import org.xml.sax.InputSource;

/**
 * ContentLoader
 * 
 * Comment here.
 */
public interface ContentLoader {
	// *** Class Members ***
	
	public enum LoadType {lazy, async}

	// *** Public Methods ***
	
	public Content parse(InputSource xml, XPath xpath) throws IOException, MalformedXMLException;
	
	public Content load(LoadType type, InputSource xml, XPath xpath);
	
	public void setSource(SystemLiteral systemID, InputSource source) throws IOException;
	
}
