/*
	DocumentWriter.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout;

import java.io.IOException;

import net.markout.types.*;

/**
 * DocumentWriter
 *
 * Comment here.  Author: David Fogel
 */
public interface DocumentWriter {
	// *** Class Members ***

	// *** Public Methods ***
	
	// --- Whitespace Policy ---
	// public void setWhitespacePolicy(WhitespacePolicy policy);
	
	// --- XML Version Declaration ---
	public void xmlVersion() throws IOException;
	public void xmlVersion(EncName encoding) throws IOException;
	public void xmlVersion(EncName encoding, boolean standalone) throws IOException;
	
	// --- Document Type Definition ---
	public DTDWriter dtd(	Name rootElementName,
							PublicIDLiteral publicID,
							SystemLiteral systemID) throws IOException;
	
	// --- Namespaces ---
	public void defaultNamespace(NamespaceURI uri) throws IOException;
	public void namespace(NamespaceURI uri) throws IOException;
	
	// --- Root Element ---
	public ContentWriter rootElement(Name elementName) throws IOException;
	public ContentWriter rootElement(Name elementName, Attribute... attributes) throws IOException;
	public void emptyRootElement(Name elementName) throws IOException;
	public void emptyRootElement(Name elementName, Attribute... attributes) throws IOException;
	
	// --- Misc Document Parts ---
	public void comment(Comment c) throws IOException;
	public void pi(Target target, Instruction instruction) throws IOException;
	public void space(Whitespace space) throws IOException;
	
	// --- Closing and Resetting ---	
	public void close() throws IOException;
}










// end
