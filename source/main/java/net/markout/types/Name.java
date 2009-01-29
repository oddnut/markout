/*
	Name.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.types;

// *** imports ***

import java.io.IOException;
import java.io.Writer;

import net.markout.IllegalXMLStringException;

/**
 * Name
 *
 * Comment here.  Author: David Fogel
 */
public class Name extends XMLChunk implements Comparable<Name> {
	// *** Class Members ***

	// *** Instance Members ***
	private NamespaceURI namespaceURI;
	protected String value;

	// *** Constructors ***
	public Name(String name) {
		this(null, name);
	}
	
	public Name(NamespaceURI namespaceURI, String name) {
		this.namespaceURI = namespaceURI;
		this.value = name;
		check();
	}
	
	// *** Object Methods ***
	public String toString() {
		return value;
	}
	
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Name))
			return false;
		Name n = (Name) o;
		return namespaceURI == null ? (n.namespaceURI == null && value.equals(n.value))
									: (namespaceURI.equals(n.namespaceURI) && value.equals(n.value));
	}
	
	public int hashCode() {
		return value.hashCode() ^ (namespaceURI != null ? namespaceURI.hashCode() : "NO_NAMESPACE".hashCode());
	}
	
	// *** Comparable Methods ***
	
	public int compareTo(Name n) {
		if (namespaceURI == null) {
			if (n.namespaceURI == null)
				return value.compareTo(n.value);
			else
				return -1;
		} else if (n.namespaceURI == null) {
			return 1;
		} else {
			if (namespaceURI.equals(n.namespaceURI))
				return value.compareTo(n.value);
			else
				return namespaceURI.compareTo(n.namespaceURI);
		}
	}
	
	// *** XMLChunk Methods ***
	public void writeTo(Writer out) throws IOException {
		out.write(value);
	}

	// *** Public Methods ***
	public NamespaceURI getNamespaceURI() {
		return namespaceURI;
	}
	
	public boolean isNamespaced() {
		return namespaceURI != null;
	}
	
	public Attribute att(String attValue) {
		
		return new Attribute(this, attValue);
	}
	
	public String toQualifiedString() {
		if (namespaceURI != null)
			return new StringBuilder().append('{').append(namespaceURI).append('}').append(value).toString();
		else
			return value;
	}
	
	// *** Protected Methods ***
	protected void check() {
		
		int length = value.length();
		
		if (length == 0)
			throw new IllegalXMLStringException("XML Names can't be zero-length");
		
		char c = value.charAt(0);
		if ( ! XMLChar.isNameStartChar(c))
			throw new IllegalXMLStringException(value, "Name");
		
		for (int i = 1 ; i < length ; i++) {
			c = value.charAt(i);
			if ( ! XMLChar.isNameChar(c))
				throw new IllegalXMLStringException(value, "Name");
		}
	}

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










// end
