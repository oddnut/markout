/*
	NamespaceURI.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.types;

/**
 * NamespaceURI
 * 
 * Comment here.
 */
public class NamespaceURI extends AttValue implements Comparable<NamespaceURI>{
	// *** Class Members ***
	public static final NamespaceURI XML_URI = new NamespaceURI("http://www.w3.org/XML/1998/namespace", "xml");
	public static final NamespaceURI XMLNS_URI = new NamespaceURI("http://www.w3.org/2000/xmlns/", "xmlns");
	public static final Name XMLNS_PREFIX = XMLNS_URI.getPreferredPrefix();
	public static final Name XML_PREFIX = XML_URI.getPreferredPrefix();

	// *** Instance Members ***
	private Name prefix;

	// *** Constructors ***
	public NamespaceURI(String uri) {
		this(uri, null);
	}
	
	public NamespaceURI(String uri, String preferredPrefix) {
		super(uri, QuoteType.DOUBLE);
		
		prefix = preferredPrefix != null ? new Name(this, preferredPrefix) : null;
	}
	
	private NamespaceURI() {}

	// *** Object Methods ***
	public String toString() {
		return value;
	}
	
	public boolean equals(Object o) {
		if (o == null || !(o instanceof NamespaceURI))
			return false;
		NamespaceURI n = (NamespaceURI) o;
		return value.equals(n.value);
	}
	
	public int hashCode() {
		return value.hashCode();
	}
	
	// *** Comparable Methods ***
	public int compareTo(NamespaceURI n) {
		return value.compareTo(n.value);
	}

	// *** Public Methods ***
	public Name getPreferredPrefix() {
		return prefix;
	}
	
	public NamespaceURI withPreferredPrefix(String prefix) {
		NamespaceURI n = new NamespaceURI();
		n.quoteType = quoteType;
		n.value = value;
		n.prefix = new Name(prefix);
		return n;
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}
