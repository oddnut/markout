/*
	EnhancedElementWriter.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.support;

import java.util.ArrayList;
import java.util.List;

import net.markout.ContentWriter;

/**
 * EnhancedElementWriter
 * 
 * Comment here.
 */
public class EnhancedElementWriter extends BasicElementWriter implements EnhancedContentWriter {
	// *** Class Members ***

	// *** Instance Members ***
	private List<ContentWriter> proxies;

	// *** Constructors ***
	public EnhancedElementWriter(EnhancedXMLOutputContext out) {
		super(out);
		proxies = null;
	}

	// *** BasicElementWriter Methods ***
	
	protected BasicElementWriter createChildElementWriter(XMLOutputContext out) {
		
		return new EnhancedElementWriter((EnhancedXMLOutputContext) out);
	}
	
	// *** Public Methods ***
	
	@SuppressWarnings("unchecked")
	public <T extends ContentWriter> T as(Class<T> enhancedType) {
		
		// first see if this contentwriter can itself fulfill the request:
		if (enhancedType.isAssignableFrom(this.getClass()))
			return (T) this;
		
		// then see if we already have a proxy instantiated:
		int s = proxies != null ? proxies.size() : 0;
		for (int i = 0 ; i < s ; i++) {
			ContentWriter proxy = proxies.get(i);
			if (enhancedType.isAssignableFrom(proxy.getClass()))
				return (T) proxy;
		}
		
		// finally try to get an appropriate proxy created:
		EnhancedXMLOutputContext exoc = (EnhancedXMLOutputContext) getXMLOutputContext();
		
		if (proxies == null) {
			s = exoc.getRegisteredProxyTypeCount();
			proxies = new ArrayList<ContentWriter>(s > 0 ? s : 2);
		}
		
		ContentWriter proxy = exoc.proxy(this, enhancedType);
		proxies.add(proxy);
		
		return (T) proxy;
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}
