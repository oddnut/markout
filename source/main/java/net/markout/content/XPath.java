/*
	XPath.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.content;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import net.markout.content.XPathBuilder.What;
import net.markout.types.NamespaceURI;

/**
 * XPath
 * 
 * Comment here.
 */
public class XPath {
	// *** Class Members ***
	
	public static XPathBuilder element() {
		return new XPathBuilder(What.first_element);
	}
	
	public static XPathBuilder elements() {
		return new XPathBuilder(What.all_elements);
	}
	
	public static XPathBuilder contentOfElement() {
		return new XPathBuilder(What.first_element_content);
	}
	
	public static XPathBuilder contentOfElements() {
		return new XPathBuilder(What.all_element_content);
	}

	// *** Instance Members ***
	private String expression;
	private Set<NamespaceURI> namespaceURIs;

	// *** Constructors ***
	public XPath(String expression, NamespaceURI... namespaceURIs) {
		this.expression = expression;
		this.namespaceURIs = new HashSet<NamespaceURI>(Arrays.asList(namespaceURIs));
	}

	// *** Object Methods ***
	public String toString() {
		return expression;
	}
	
	// *** Public Methods ***
	public String getExpression() {
		return expression;
	}
	
	public Set<NamespaceURI> getNamespaceURIs() {
		return namespaceURIs;
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}
