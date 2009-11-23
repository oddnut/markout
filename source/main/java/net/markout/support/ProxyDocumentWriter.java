/*
	ProxyDocumentWriter.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.support;

import java.io.IOException;

import net.markout.ContentWriter;
import net.markout.DTDWriter;
import net.markout.DocumentWriter;
import net.markout.EmptyElementPolicy;
import net.markout.WhitespacePolicy;
import net.markout.types.Attribute;
import net.markout.types.Comment;
import net.markout.types.EncName;
import net.markout.types.Instruction;
import net.markout.types.Name;
import net.markout.types.NamespaceURI;
import net.markout.types.PublicIDLiteral;
import net.markout.types.SystemLiteral;
import net.markout.types.Target;
import net.markout.types.Whitespace;

/**
 * ProxyDocumentWriter
 * 
 * Comment here.
 */
public class ProxyDocumentWriter implements DocumentWriter {
	// *** Class Members ***

	// *** Instance Members ***
	protected DocumentWriter target;

	// *** Constructors ***
	public ProxyDocumentWriter(DocumentWriter target) {
		this.target = target;
	}

	// *** DocumentWriter Methods ***
	
	// --- Whitespace Policy ---
	final public void setWhitespacePolicy(WhitespacePolicy policy) {target.setWhitespacePolicy(policy);}
	
	// --- Empty Element Policy ---
	final public void setEmptyElementPolicy(EmptyElementPolicy emptyPolicy) {target.setEmptyElementPolicy(emptyPolicy);}
	
	// --- XML Version Declaration ---
	final public void xmlVersion() throws IOException {target.xmlVersion();}
	final public void xmlVersion(EncName encoding) throws IOException {target.xmlVersion(encoding);}
	final public void xmlVersion(EncName encoding, Boolean standalone) throws IOException {target.xmlVersion(encoding, standalone);}
	
	// --- Document Type Definition ---
	final public DTDWriter dtd(	Name rootElementName,
							PublicIDLiteral publicID,
							SystemLiteral systemID) throws IOException {return target.dtd(rootElementName, publicID, systemID);}
	
	// --- Namespaces ---
	final public void defaultNamespace(NamespaceURI uri) throws IOException {target.defaultNamespace(uri);}
	final public void namespace(NamespaceURI uri) throws IOException {target.namespace(uri);}
	
	// --- Root Element ---
	final public ContentWriter rootElement(Name elementName) throws IOException {return target.rootElement(elementName);}
	final public ContentWriter rootElement(Name elementName, Attribute... attributes) throws IOException {return target.rootElement(elementName, attributes);}
	
	// --- Misc Document Parts ---
	final public void comment(Comment c) throws IOException {target.comment(c);}
	final public void pi(Target target, Instruction instruction) throws IOException {this.target.pi(target, instruction);}
	final public void space(Whitespace space) throws IOException {target.space(space);}
	
	// --- Closing and Resetting ---	
	final public void close() throws IOException {target.close();}

	// *** Public Methods ***
	public DocumentWriter getTarget() {return target;}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}
