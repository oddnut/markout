/*
	MElement.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.content.xom;

import java.io.IOException;
import java.util.*;

import net.markout.ContentWriter;
import net.markout.content.Content;
import net.markout.content.SelectableContent;
import net.markout.content.XPath;
import net.markout.types.Name;
import net.markout.types.NamespaceURI;
import nu.xom.Element;
import nu.xom.Node;
import nu.xom.Nodes;
import nu.xom.XPathContext;

/**
 * MElement
 * 
 * Comment here.
 */
public class MElement extends Element implements SelectableContent {
	// *** Class Members ***

	// *** Instance Members ***
	private Name name;
	private Map<String, NamespaceURI> markoutNamespaces;

	// *** Constructors ***
	public MElement(String qname, String namespace) {
		super(qname, namespace);
		
		updateName();
	}
	
	public MElement(Element element) {
		super(element);
		
		if (element instanceof MElement)
			name = ((MElement) element).getName();
		else
			updateName();
	}

	// *** Element Methods ***

	@Override
	public void setLocalName(String localName) {
		super.setLocalName(localName);
		
		updateName();
	}

	@Override
	public void setNamespacePrefix(String prefix) {
		super.setNamespacePrefix(prefix);
		
		updateName();
	}

	@Override
	public void setNamespaceURI(String uri) {
		super.setNamespaceURI(uri);
		
		updateName();
	}

	@Override
	protected Element shallowCopy() {
		return new MElement(getQualifiedName(), getNamespaceURI());
	}

	@Override
	public Node copy() {
		return new MElement(this);
	}

	@Override
	public void addNamespaceDeclaration(String prefix, String uri) {
		// first do the super call, so if it fails we don't have to do anything
		super.addNamespaceDeclaration(prefix, uri);
		
		if (markoutNamespaces == null)
			markoutNamespaces = new HashMap<String, NamespaceURI>();
		
		markoutNamespaces.put(prefix, new NamespaceURI(uri, prefix));
	}

	@Override
	public void removeNamespaceDeclaration(String prefix) {
		
		super.removeNamespaceDeclaration(prefix);
		
		if (markoutNamespaces != null)
			markoutNamespaces.remove(prefix);
	}
	
	// *** Content Methods ***
	public void writeTo(ContentWriter out) throws IOException {
		XOMAdapter.writeElementTo(out, this);
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
	public Name getName() {
		return name;
	}
	
	public Collection<NamespaceURI> getMarkoutNamespaces() {
		if (markoutNamespaces == null)
			return null;
		return markoutNamespaces.values();
	}
	
	public static Name createMarkoutName(Element e) {
		
		NamespaceURI uri = null;
		
		String nsuri = e.getNamespaceURI();
		if (nsuri != null && nsuri.length() > 0) {
			String prefix = e.getNamespacePrefix();
			if ("".equals(prefix))
				prefix = null;
			uri = new NamespaceURI(nsuri, prefix);
		}
		
		return new Name(uri, e.getLocalName());
	}
	
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

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***
	private void updateName() {
		this.name = createMarkoutName(this);
	}

	// *** Private Classes ***
}
