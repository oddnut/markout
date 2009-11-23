/*
	ContentWriterProxy.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.support;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import net.markout.ContentWriter;
import net.markout.content.Content;
import net.markout.types.Attribute;
import net.markout.types.CData;
import net.markout.types.CharData;
import net.markout.types.CharRef;
import net.markout.types.Comment;
import net.markout.types.Instruction;
import net.markout.types.Name;
import net.markout.types.NamespaceURI;
import net.markout.types.Target;
import net.markout.types.Text;
import net.markout.types.Whitespace;

/**
 * ContentWriterProxy
 * 
 * Comment here.
 */
public class ContentWriterProxy implements ContentWriter {
	// *** Class Members ***

	// *** Instance Members ***
	protected ContentWriter target;

	// *** Constructors ***
	public ContentWriterProxy(ContentWriter target) {
		
		this.target = target;
	}

	// *** ContentWriter Methods ***
	
	// --- Writer State ---
	final public Name getName() {return target.getName();}
	final public List<Name> getElementNameStack() {return target.getElementNameStack();}
	
	// --- Escaped Text Content ---
	final public void text(Text text) throws IOException {target.text(text);}
	final public void text(String text) throws IOException {target.text(text);}
	final public Writer text() throws IOException {return target.text();}
	
	// --- Character Data Content---
	final public void characters(CharData charData) throws IOException {target.characters(charData);}
	final public void cdata(CData cdata) throws IOException {target.cdata(cdata);}
	
	// --- Reference Content ---
	final public void reference(CharRef charRef) throws IOException {target.reference(charRef);}
	final public void reference(Name entityName) throws IOException {target.reference(entityName);}
	
	// --- Namespaces ---
	final public void defaultNamespace(NamespaceURI uri) throws IOException {target.defaultNamespace(uri);}
	final public void namespace(NamespaceURI uri) throws IOException {target.namespace(uri);}
	
	// --- Element Content ---
	final public ContentWriter element(Name elementName) throws IOException {return target.element(elementName);}
	final public ContentWriter element(Name elementName, Attribute... attributes) throws IOException {
		return target.element(elementName, attributes);}
	
	// --- Misc Content ---
	final public void comment(Comment c) throws IOException {target.comment(c);}
	final public void pi(Target target, Instruction instruction) throws IOException {this.target.pi(target, instruction);}
	final public void space(Whitespace space) throws IOException {target.space(space);}
	
	// --- Custom Content ---
	final public void content(Content c) throws IOException {target.content(c);}

	// *** Public Methods ***
	public ContentWriter getTarget() {return target;}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}
