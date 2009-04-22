/*
	MarkoutBuilder.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.parsed.xom;

import org.xml.sax.XMLReader;

import net.markout.parsed.EmptyElementPolicy;
import nu.xom.Builder;
import nu.xom.NodeFactory;

/**
 * MarkoutBuilder
 * 
 * Comment here.
 */
public class MarkoutBuilder extends Builder {
	// *** Class Members ***
	private static NodeFactory DEFAULT_NODE_FACTORY = new MarkoutNodeFactory();

	// *** Instance Members ***

	// *** Constructors ***
	public MarkoutBuilder() {
		super(DEFAULT_NODE_FACTORY);
	}
	
	public MarkoutBuilder(EmptyElementPolicy emptyPolicy) {
		super(new MarkoutNodeFactory(emptyPolicy));
	}
	
	public MarkoutBuilder(boolean validate) {
		super(validate, DEFAULT_NODE_FACTORY);
	}
	
	public MarkoutBuilder(boolean validate, EmptyElementPolicy emptyPolicy) {
		super(validate, new MarkoutNodeFactory(emptyPolicy));
	}
	
	public MarkoutBuilder(XMLReader parser, boolean validate) {
		super(parser, validate, DEFAULT_NODE_FACTORY);
	}
	
	public MarkoutBuilder(XMLReader parser, boolean validate, EmptyElementPolicy emptyPolicy) {
		super(parser, validate, new MarkoutNodeFactory(emptyPolicy));
	}

	// *** Interface Methods ***

	// *** Public Methods ***

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}
