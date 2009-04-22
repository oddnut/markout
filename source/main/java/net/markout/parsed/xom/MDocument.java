/*
	MDocument.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.parsed.xom;

import java.io.IOException;

import net.markout.ContentWriter;
import net.markout.parsed.EmptyElementPolicy;
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
public class MDocument extends Document implements net.markout.parsed.Document {
	// *** Class Members ***

	// *** Instance Members ***
	private EmptyElementPolicy emptyPolicy = null;

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
	
	// *** net.markout.parsed.Document Methods ***
	
	public void writeTo(ContentWriter out) throws IOException {
		writeTo(out, null, (NamespaceURI[]) null);
	}
	
	public void writeTo(ContentWriter out, String xpath) throws IOException {
		writeTo(out, xpath, (NamespaceURI[]) null);
	}
	
	public void writeTo(ContentWriter out, String xpath, NamespaceURI... namespaceURIs) throws IOException {
		
		if (xpath == null) {
			
			XOMAdapter.writeTo(out, getRootElement());
			return;
		}
		
		XPathContext xpc = null;
		
		if (namespaceURIs != null && namespaceURIs.length > 0) {
			xpc = new XPathContext();
			for (NamespaceURI ns : namespaceURIs) {
				Name prefix = ns.getPreferredPrefix();
				xpc.addNamespace(prefix != null ? prefix.toString() : "", ns.getValueString());
			}
		}
		
		Nodes nodes = query(xpath, xpc);
		
		if (emptyPolicy != null)
			XOMAdapter.writeTo(out, nodes, emptyPolicy);
		else
			XOMAdapter.writeTo(out, nodes);
	}

	// *** Public Methods ***
	public void setEmptyElementPolicy(EmptyElementPolicy emptyPolicy) {
		this.emptyPolicy = emptyPolicy;
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}
