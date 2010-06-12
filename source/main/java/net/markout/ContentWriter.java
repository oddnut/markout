/*
	ContentWriter.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import net.markout.content.Content;
import net.markout.types.*;

/**
 * ContentWriter
 *
 * Comment here.  Author: David Fogel
 */
public interface ContentWriter {
	// *** Class Members ***

	// *** Public Methods ***
	
	// --- Writer State ---
	public Name getName();
	public List<Name> getElementNameStack();
	
	// --- Escaped Text Content ---
	public void text(Text text) throws IOException;
	public void text(String text) throws IOException;
	public Writer text() throws IOException;
	public Writer cdata() throws IOException;
	
	// --- Character Data Content---
	public void characters(CharData charData) throws IOException;
	public void cdata(CData cdata) throws IOException;
	
	// --- Reference Content ---
	public void reference(CharRef charRef) throws IOException;
	public void reference(Name entityName) throws IOException;
	
	// --- Namespaces ---
	public void defaultNamespace(NamespaceURI uri) throws IOException;
	public void namespace(NamespaceURI uri) throws IOException;
	
	// --- Element Content ---
	public ContentWriter element(Name elementName) throws IOException;
	public ContentWriter element(Name elementName, Attribute... attributes) throws IOException;
	
	// --- Misc Content ---
	public void comment(Comment c) throws IOException;
	public void pi(Target target, Instruction instruction) throws IOException;
	public void space(Whitespace space) throws IOException;
	
	// --- Custom Content ---
	public void content(Content c) throws IOException;
}










// end
