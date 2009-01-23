/*
	Attribute.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.types;

/**
 * Attribute
 * 
 * Comment here.
 */
public class Attribute implements Comparable<Attribute>{
	// *** Class Members ***
	

	// *** Instance Members ***
	private Name name;
	private AttValue value;

	// *** Constructors ***
	public Attribute(Name name, String value) {
		this(name, new AttValue(value));
	}
	public Attribute(Name name, AttValue value) {
		this.name = name;
		this.value = value;
	}

	// *** Object Methods ***
	public String toString() {
		char q = value.getQuoteChar();
		return name.toString() + "=" + q + value.toString() + q;
	}
	
	public String getValueString() {
		return value.getUnquotedValue();
	}
	
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Attribute))
			return false;
		Attribute a = (Attribute) o;
		return name.equals(a.name) && value.equals(a.value);
	}
	
	public int hashCode() {
		return name.hashCode() ^ value.hashCode();
	}
	
	// *** Comparable Methods ***
	public int compareTo(Attribute o) {
		int c = name.compareTo(o.name);
		if (c == 0)
			c = value.compareTo(o.value);
		return c;
	}

	// *** Public Methods ***
	public Name getName() {return name;}

	public AttValue getValue() {return value;}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}
