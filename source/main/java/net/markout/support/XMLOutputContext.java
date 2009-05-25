/*
	XMLOutputContext.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.support;

import net.markout.EmptyElementPolicy;
import net.markout.WhitespacePolicy;

/**
 * XMLOutputContext
 * 
 * Comment here.
 */
public class XMLOutputContext {
	// *** Class Members ***

	// *** Instance Members ***
	final XMLChunkWriter writer;
	private EmptyElementPolicy emptyPolicy;
	private WhitespacePolicy whitespacePolicy;

	// *** Constructors ***
	public XMLOutputContext(XMLChunkWriter writer) {
		this.writer = writer;
		this.emptyPolicy = EmptyElementPolicy.DEFAULT;
		this.whitespacePolicy = WhitespacePolicy.DEFAULT;
	}

	// *** Interface Methods ***

	// *** Public Methods ***
	public XMLChunkWriter getWriter() {
		return writer;
	}
	
	public EmptyElementPolicy getEmptyElementPolicy() {
		return emptyPolicy;
	}
	
	public void setEmptyElementPolicy(EmptyElementPolicy emptyPolicy) {
		this.emptyPolicy = emptyPolicy;
	}
	
	public WhitespacePolicy getWhitespacePolicy() {
		return whitespacePolicy;
	}
	
	public void setWhitespacePolicy(WhitespacePolicy whitespacePolicy) {
		this.whitespacePolicy = whitespacePolicy;
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}
