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
	
	private SortedMap theMap;
	private SortedMap theUnmodMap;

	// *** Constructors ***
	
	public Attributes() {
		theMap = new TreeMap();
		theUnmodMap = Collections.unmodifiableSortedMap(theMap);
	}

	// *** Object Methods ***
	
	

	// *** Public Methods ***
	
	public AttValue get(Name name) {
		return (AttValue) theMap.get(name);
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
	
	public Set nameSet() {
		return theUnmodMap.keySet();
	}
	
	public Map getReadableMap() {
		return theUnmodMap;
	}
	
	public int size() {
		return theMap.size();
	}
	
	public String toString() {
		return theMap.toString();
	}
	
	public void writeTo(ElementWriter elWriter) throws IOException {
		Iterator i = theMap.entrySet().iterator();
		while(i.hasNext()) {
			Map.Entry e = (Map.Entry) i.next();
			
			elWriter.attribute((Name)e.getKey(), (AttValue) e.getValue());
		}
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










// end
