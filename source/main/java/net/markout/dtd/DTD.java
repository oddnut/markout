/*
	DTD.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.dtd;

// *** imports ***

import net.markout.types.Name;

/**
 * DTD
 *
 * Comment here.  Author: David Fogel
 */
public interface DTD {
	// *** Class Members ***

	// *** Public Methods ***
	
	public Name getRootElementName();
	
	public ElementType getElementType(Name elementName);
	
	public Entity getGeneralEntity(Name entityName);
	
	public Entity getParameterEntity(Name entityName);
	
	public Notation getNotation(Name notationName);
	
	public UnparsedEntity getUnparsedEntity(Name unparsedEntityName);

}










/* end */