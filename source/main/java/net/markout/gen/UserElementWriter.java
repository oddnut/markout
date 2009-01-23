/*
	UserElementWriter.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.gen;

import java.io.IOException;

//import net.markout.*;
import net.markout.support.*;
import net.markout.types.*;

/**
 * UserElementWriter
 * 
 * THIS IS A GENERATED FILE, DO NOT EDIT!
 */
public class UserElementWriter extends BasicElementWriter implements UserContentWriter{
	// *** Class Members ***
	private static final Name FIRST = new Name("first");
	private static final Name LAST = new Name("last");
	private static final Name SSN = new Name("ssn");
	private static final Name USER = new Name("user");
	
	// *** Constructors ***
	public UserElementWriter(XMLChunkWriter out) {super(out);}

	// *** UserContentWriter Methods ***
	
	public UserContentWriter first(Attribute... attributes) throws IOException {
		return (UserContentWriter) element(FIRST, attributes);
	}
	public void emptyFirst(Attribute... attributes) throws IOException {
		emptyElement(FIRST, attributes);
	}
	
	public UserContentWriter last(Attribute... attributes) throws IOException {
		return (UserContentWriter) element(LAST, attributes);
	}
	public void emptyLast(Attribute... attributes) throws IOException {
		emptyElement(LAST, attributes);
	}
	
	public UserContentWriter ssn(Attribute... attributes) throws IOException {
		return (UserContentWriter) element(SSN, attributes);
	}
	public void emptySsn(Attribute... attributes) throws IOException {
		emptyElement(SSN, attributes);
	}
	
	public UserContentWriter user(Attribute... attributes) throws IOException {
		return (UserContentWriter) element(USER, attributes);
	}
	public void emptyUser(Attribute... attributes) throws IOException {
		emptyElement(USER, attributes);
	}

	// *** Protected Methods ***
	protected BasicElementWriter createChildElementWriter(XMLChunkWriter out) {
		return new UserElementWriter(out);
	}

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}

