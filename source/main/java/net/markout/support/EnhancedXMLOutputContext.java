/*
	EnhancedXMLOutputContext.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.support;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import net.markout.ContentWriter;

/**
 * EnhancedXMLOutputContext
 * 
 * Comment here.
 */
public class EnhancedXMLOutputContext extends XMLOutputContext {
	// *** Class Members ***

	// *** Instance Members ***
	private List<Constructor<ProxyContentWriter>> proxyConstructors;

	// *** Constructors ***
	public EnhancedXMLOutputContext(XMLChunkWriter writer) {
		super(writer);
		
		proxyConstructors = new ArrayList<Constructor<ProxyContentWriter>>();
	}

	// *** Interface Methods ***

	// *** Public Methods ***
	
	public void registerEnhancedProxyType(Class<ProxyContentWriter> proxyType) {
		try {
			proxyConstructors.add(proxyType.getConstructor(ContentWriter.class));
		}
		catch(NoSuchMethodException nsme) {
			throw new IllegalArgumentException(
					"ProxyContentWriter subclass must have a public constructor with a single ContentWriter param", nsme);
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T extends ContentWriter> T proxy(ContentWriter cw, Class<T> enhancedType) {
		
		int s = proxyConstructors.size();
		for (int i = 0 ; i < s ; i++) {
			Constructor<ProxyContentWriter> cons = proxyConstructors.get(i);
			if (enhancedType.isAssignableFrom(cons.getDeclaringClass())) {
				try {
					ProxyContentWriter proxy = cons.newInstance(cw);
					return (T) proxy;
				}
				catch (Exception e) {
					throw new IllegalArgumentException(
							"Couldn't instantiate ProxyContentWriter class " + cons.getDeclaringClass(), e);
				}
			}
		}
		
		throw new IllegalArgumentException("No ProxyContentWriter class registered which implements " + enhancedType);
	}
	
	// *** Protected Methods ***

	// *** Package Methods ***
	
	int getRegisteredProxyTypeCount() {
		return proxyConstructors.size();
	}

	// *** Private Methods ***

	// *** Private Classes ***
}
