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
public class Attribute extends AttValue implements Comparable<Attribute>{
	// *** Class Members ***

	// *** Instance Members ***
	private Name name;

	// *** Constructors ***
	public Attribute(Name name, String text) {
		this(name, text, QuoteType.DOUBLE);
	}
	
	public Attribute(Name name, String text, QuoteType quoteType) {
		super(text, quoteType);
		
		this.name = name;
	}
	
	private Attribute() {}

	// *** Object Methods ***
	public String toString() {
		char q = quoteType.getQuoteChar().getChar();
		return name.toString() + "=" + q + value.toString() + q;
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

	// *** Protected Methods ***

	// *** Package Methods ***
	static Attribute createAttribtueForPreparsedValue(Name name, String value, QuoteType quoteType) {
		Attribute result = new Attribute();
		result.name = name;
		result.value = value;
		result.quoteType = quoteType;
		return result;
	}

	// *** Private Methods ***

	// *** Private Classes ***
}
