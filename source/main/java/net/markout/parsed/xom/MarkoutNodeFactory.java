/*
	MarkoutNodeFactory.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.parsed.xom;

import nu.xom.Document;
import nu.xom.Element;
import nu.xom.NodeFactory;
import nu.xom.Nodes;
import nu.xom.Attribute.Type;

/**
 * MarkoutNodeFactory
 * 
 * Comment here.
 */
public class MarkoutNodeFactory extends NodeFactory {
	// *** Class Members ***

	// *** Instance Members ***

	// *** Constructors ***

	// *** NodeFactory Methods ***
	
	@Override
	public Document startMakingDocument() {
		return new MDocument(new Element("root", "http://www.xom.nu/fakeRoot"));
	}

	@Override
	public Nodes makeAttribute(String name, String URI, String value, Type type) {
		return new Nodes(new MAttribute(name, URI, value, type));
	}

	@Override
	public Nodes makeComment(String data) {
		return new Nodes(new MComment(data));
	}

	@Override
	public Nodes makeDocType(String rootElementName, String publicID, String systemID) {
		return new Nodes(new MDocType(rootElementName, publicID, systemID));
	}

	@Override
	public Nodes makeProcessingInstruction(String target, String data) {
		return new Nodes(new MProcessingInstruction(target, data));
	}

	@Override
	public Nodes makeText(String data) {
		return new Nodes(new MText(data));
	}

	@Override
	public Element startMakingElement(String name, String namespace) {
		return new MElement(name, namespace);
	}

	// *** Public Methods ***

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}
