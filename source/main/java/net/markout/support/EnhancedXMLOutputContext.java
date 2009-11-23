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
	private List<Constructor<? extends ContentWriterProxy>> proxyConstructors;

	// *** Constructors ***
	public EnhancedXMLOutputContext(XMLChunkWriter writer) {
		super(writer);
		
		proxyConstructors = new ArrayList<Constructor<? extends ContentWriterProxy>>();
	}

	// *** Interface Methods ***

	// *** Public Methods ***
	
	@SuppressWarnings("unchecked")
	public void registerEnhancedProxyType(Class<? extends ContentWriterProxy> proxyType) {
		
		Constructor<?>[] cons = proxyType.getConstructors();
		for (Constructor<?> con : cons) {
			Class<?>[] paramTypes = con.getParameterTypes();
			if (paramTypes.length == 1 && ContentWriter.class.isAssignableFrom(paramTypes[0])) {
				proxyConstructors.add((Constructor<? extends ContentWriterProxy>) con);
				return;
			}
		}
		
		throw new IllegalArgumentException(
					"ContentWriterProxy subclass must have a public constructor with a single ContentWriter param");
	}
	
	@SuppressWarnings("unchecked")
	public <T extends ContentWriter> T proxy(ContentWriter cw, Class<T> enhancedType) {
		
		int s = proxyConstructors.size();
		for (int i = 0 ; i < s ; i++) {
			Constructor<? extends ContentWriterProxy> cons = proxyConstructors.get(i);
			if (enhancedType.isAssignableFrom(cons.getDeclaringClass())) {
				try {
					ContentWriterProxy proxy = cons.newInstance(cw);
					return (T) proxy;
				}
				catch (Exception e) {
					throw new IllegalArgumentException(
							"Couldn't instantiate ContentWriterProxy class " + cons.getDeclaringClass(), e);
				}
			}
		}
		
		throw new IllegalArgumentException("No ContentWriterProxy class registered which implements " + enhancedType);
	}
	
	// *** Protected Methods ***

	// *** Package Methods ***
	
	int getRegisteredProxyTypeCount() {
		return proxyConstructors.size();
	}

	// *** Private Methods ***

	// *** Private Classes ***
}
