/*
	EnhanceTest.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.gen;

import java.io.IOException;

import net.markout.ContentWriter;
import net.markout.support.EnhancedElementWriter;
import net.markout.support.ContentWriterProxy;
import net.markout.types.Name;

/**
 * EnhanceTest
 * 
 * Comment here.
 */
public class EnhanceTest {
	// *** Class Members ***
	
	public static Name FOO = new Name("foo");
	
	public static interface FooCW extends ContentWriter {
		public FooCW foo() throws IOException;
	}
	
	public static class FooCWProxy extends ContentWriterProxy implements FooCW {
		
		public FooCWProxy(ContentWriter target) {super(target);}
		
		public FooCW foo() throws IOException {
			EnhancedElementWriter ew = (EnhancedElementWriter) target.element(FOO);
			return ew.as(FooCW.class);
		}
	}

	// *** Instance Members ***

	// *** Constructors ***

	// *** Interface Methods ***

	// *** Public Methods ***

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}
