/*
	ContentModel.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.dtd;

// *** imports ***

/**
 * ContentModel
 *
 * Comment here.  Author: David Fogel
 */
public interface ContentModel {
	// *** Class Members ***
	
	public static final ContentModel EMPTY = new EmptyContentModel();
	
	public static final ContentModel ANY = new AnyContentModel();

	// *** Public Methods ***
	
	public ContentValidator getValidator();
}










/* end */