/*
	GeneratedSourceDocument.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.support;

// *** imports ***

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import net.markout.DocumentWriter;
import net.markout.XML;
import net.markout.types.*;

/**
 * GeneratedSourceDocument
 *
 * Comment here.  Author: David Fogel
 */
public abstract class GeneratedSourceDocument {
	// *** Class Members ***
	
	private static Map<String, Name> ELEMENT_NAMES = new HashMap<String, Name>();
	private static Map<String, Name> ATT_NAMES = new HashMap<String, Name>();
	private static Map<String, AttValue> ATT_VALUES = new HashMap<String, AttValue>();
	private static Map<String, Whitespace> SPACES = new HashMap<String, Whitespace>();
	private static Map<String, Name> ENTITY_NAMES = new HashMap<String, Name>();

	// *** Instance Members ***

	// *** Constructors ***
	
	public GeneratedSourceDocument() {
		
	}

	// *** Interface Methods ***

	// *** Public Methods ***
	
	public void writeTo(OutputStream out, String charset) throws IOException {
		writeTo(XML.documentWriter(out, charset));
	}
	
	public void writeTo(Writer out) throws IOException {
		writeTo(XML.documentWriter(out));
	}
	
	abstract public void writeTo(DocumentWriter dw) throws IOException;
	
	
	public Name el(String name) {
		Name n = ELEMENT_NAMES.get(name);
		if (n == null) {
			n = new Name(name);
			ELEMENT_NAMES.put(name, n);
		}
		return n;
	}
	
	public Name att(String name) {
		Name n = ATT_NAMES.get(name);
		if (n == null) {
			n = new Name(name);
			ATT_NAMES.put(name, n);
		}
		return n;
	}
	
	public AttValue val(String val) {
		AttValue v = ATT_VALUES.get(val);
		if (v == null) {
			v = new AttValue(val);
			ATT_VALUES.put(val, v);
		}
		return v;
	}
	
	public Whitespace sp(String space) {
		Whitespace s = SPACES.get(space);
		if (s == null) {
			s = new Whitespace(space);
			SPACES.put(space, s);
		}
		return s;
	}
	
	public Name ref(String name) {
		Name n = ENTITY_NAMES.get(name);
		if (n == null) {
			n = new Name(name);
			ENTITY_NAMES.put(name, n);
		}
		return n;
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










/* end */