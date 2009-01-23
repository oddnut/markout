/*
	UserDocumentWriter.java

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
 * UserDocumentWriter
 * 
 * THIS IS A GENERATED FILE, DO NOT EDIT!
 */
public class UserDocumentWriter extends BasicDocumentWriter {
	// *** Class Members ***
	private static final Name ROOT_ELEMENT = new Name("user");

	// *** Constructors ***
	public UserDocumentWriter(XMLChunkWriter out) {super(out);}

	// *** Public Methods ***
	
	public UserContentWriter user(Attribute... attributes) throws IOException {
		return (UserContentWriter) rootElement(ROOT_ELEMENT, attributes);
	}
	
	public void emptyUser(Attribute... attributes) throws IOException {
		emptyRootElement(ROOT_ELEMENT, attributes);
	}

	// *** Protected Methods ***
	protected BasicElementWriter createRootElementWriter(XMLChunkWriter out) {
		return new UserElementWriter(out);
	}

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}



