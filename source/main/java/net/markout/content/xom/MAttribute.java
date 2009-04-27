/*
	MAttribute.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.content.xom;

import net.markout.types.Name;
import net.markout.types.NamespaceURI;
import nu.xom.Attribute;
import nu.xom.Node;

/**
 * MAttribute
 * 
 * Comment here.
 */
public class MAttribute extends Attribute {
	// *** Class Members ***

	// *** Instance Members ***
	private net.markout.types.Attribute attribute;

	// *** Constructors ***
	public MAttribute(String name, String URI, String value, Attribute.Type type) {
		super(name, URI, value, type);
		
		updateAttribute();
	}
	
	public MAttribute(Attribute attribute) {
		super(attribute);
		
		updateAttribute();
	}

	// *** Attribute Methods ***

	@Override
	public Node copy() {
		return new MAttribute(this);
	}

	@Override
	public void setLocalName(String localName) {
		super.setLocalName(localName);
		
		updateAttribute();
	}

	@Override
	public void setNamespace(String prefix, String URI) {
		super.setNamespace(prefix, URI);
		
		updateAttribute();
	}

	@Override
	public void setValue(String value) {
		super.setValue(value);
		
		updateAttribute();
	}

	// *** Public Methods ***
	public net.markout.types.Attribute getAttribute() {
		return attribute;
	}
	
	public static net.markout.types.Attribute createMarkoutAttribute(Attribute a) {
		
		NamespaceURI uri = null;
		
		String nsuri = a.getNamespaceURI();
		if (nsuri != null && nsuri.length() > 0) {
			String prefix = a.getNamespacePrefix();
			if ("".equals(prefix))
				prefix = null;
			uri = new NamespaceURI(nsuri, prefix);
		}
		
		Name name = new Name(uri, a.getLocalName());
		
		return new net.markout.types.Attribute(name, a.getValue());
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***
	private void updateAttribute() {
		
		this.attribute = createMarkoutAttribute(this);
	}

	// *** Private Classes ***
}
