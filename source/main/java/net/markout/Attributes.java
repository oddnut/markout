/*
	Attributes.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout;

// *** imports ***

import java.io.IOException;
import java.util.*;

import net.markout.types.AttValue;
import net.markout.types.Name;

/**
 * Attributes
 *
 * Comment here.  Author: David Fogel
 */
public class Attributes {
	// *** Class Members ***

	// *** Instance Members ***
	
	private SortedMap<Name, AttValue> theMap;
	private SortedMap<Name, AttValue> theUnmodMap;

	// *** Constructors ***
	
	public Attributes() {
		theMap = new TreeMap<Name, AttValue>();
		theUnmodMap = Collections.unmodifiableSortedMap(theMap);
	}

	// *** Object Methods ***
	
	

	// *** Public Methods ***
	
	public AttValue get(Name name) {
		return theMap.get(name);
	}
	
	public void set(Name name, AttValue value) {
		theMap.put(name, value);
	}
	
	public void remove(Name name) {
		theMap.remove(name);
	}
	
	public void removeAllAttributes() {
		theMap.clear();
	}
	
	public void addAttributes(Attributes source) {
		theMap.putAll(source.theMap);
	}
	
	public boolean containsName(Name name) {
		return theMap.containsKey(name);
	}
	
	public Set<Name> nameSet() {
		return theUnmodMap.keySet();
	}
	
	public Map<Name, AttValue> getReadableMap() {
		return theUnmodMap;
	}
	
	public int size() {
		return theMap.size();
	}
	
	public String toString() {
		return theMap.toString();
	}
	
	public void writeTo(ElementWriter elWriter) throws IOException {
		
		for (Map.Entry<Name, AttValue> e : theMap.entrySet())
			elWriter.attribute(e.getKey(), e.getValue());
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










// end
