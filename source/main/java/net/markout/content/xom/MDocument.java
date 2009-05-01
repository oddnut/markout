/*
	MDocument.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.content.xom;

import java.io.IOException;
import java.util.Set;

import net.markout.ContentWriter;
import net.markout.content.Content;
import net.markout.content.SelectableContent;
import net.markout.content.XPath;
import net.markout.types.Name;
import net.markout.types.NamespaceURI;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Node;
import nu.xom.Nodes;
import nu.xom.XPathContext;

/**
 * MDocument
 * 
 * Comment here.
 */
public class MDocument extends Document implements SelectableContent {
	// *** Class Members ***

	// *** Instance Members ***

	// *** Constructors ***
	public MDocument(Element root) {
		super(root);
	}
	
	public MDocument(Document doc) {
		super(doc);
	}

	// *** nu.xom.Document Methods ***
	
	@Override
	public Node copy() {
		return new MDocument(this);
	}
	
	// *** Content Methods ***
	
	public void writeTo(ContentWriter out) throws IOException {
		
		XOMAdapter.writeTo(out, getRootElement());
	}
	
	// *** SelectableContent Methods ***
	public Content select(XPath xpath) {
		
		Set<NamespaceURI> uris = xpath.getNamespaceURIs();
		Nodes nodes = query(xpath.getExpression(), uris.toArray(new NamespaceURI[uris.size()]));
		
		if (nodes.size() == 1 && nodes.get(0) instanceof MElement)
			return (MElement) nodes.get(0);
		
		return new XOMNodesContent(nodes);
	}
	
	// *** Public Methods ***
	
	/*  Probably don't need this, but keep it around to maybe add later?
	public Content rootContent() {
		
		Element el = getRootElement();
		if (el instanceof MElement)
			return (MElement) el;
		
		return new XOMNodesContent(new Nodes(el));
	}*/
	
	public Nodes query(String xpath, NamespaceURI... namespaceURIs) {
		if (namespaceURIs == null || namespaceURIs.length == 0)
			return query(xpath);
		
		XPathContext xpc = new XPathContext();
		for (NamespaceURI ns : namespaceURIs) {
			Name prefix = ns.getPreferredPrefix();
			xpc.addNamespace(prefix != null ? prefix.toString() : "", ns.getValueString());
		}
		
		return query(xpath, xpc);
	}
	
	public void writeTo(ContentWriter out, String xpath) throws IOException {
		writeTo(out, xpath, (NamespaceURI[]) null);
	}
	
	public void writeTo(ContentWriter out, String xpath, NamespaceURI... xpathNamespaceURIs) throws IOException {
		
		if (xpath == null) {
			
			XOMAdapter.writeTo(out, getRootElement());
			return;
		}
		
		Nodes nodes = query(xpath, xpathNamespaceURIs);
		
		XOMAdapter.writeTo(out, nodes);
	}
	
	

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}
