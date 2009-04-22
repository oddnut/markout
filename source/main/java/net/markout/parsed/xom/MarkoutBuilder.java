/*
	MarkoutBuilder.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.parsed.xom;

import org.xml.sax.XMLReader;

import nu.xom.Builder;
import nu.xom.NodeFactory;

/**
 * MarkoutBuilder
 * 
 * Comment here.
 */
public class MarkoutBuilder extends Builder {
	// *** Class Members ***
	private static NodeFactory NODE_FACTORY = new MarkoutNodeFactory();

	// *** Instance Members ***

	// *** Constructors ***
	public MarkoutBuilder() {
		super(NODE_FACTORY);
	}
	
	public MarkoutBuilder(boolean validate) {
		super(validate, NODE_FACTORY);
	}
	
	public MarkoutBuilder(XMLReader parser, boolean validate) {
		super(parser, validate, NODE_FACTORY);
	}

	// *** Interface Methods ***

	// *** Public Methods ***

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}
