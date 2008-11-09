/*
	StandardDTD.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.dtd;

// *** imports ***

import java.util.HashMap;
import java.util.Map;

import net.markout.types.Name;

/**
 * StandardDTD
 *
 * Comment here.  Author: David Fogel
 */
public class StandardDTD implements DTD {
	// *** Class Members ***

	// *** Instance Members ***
	
	private Name theRootElementName;
	private Map theElementTypes;
	private Map theGeneralEntities;
	private Map theParameterEntities;
	private Map theUnparsedEntities;
	private Map theNotations;
	
	private DTD theParentDTD;

	// *** Constructors ***
	
	public StandardDTD(Name rootElementName, DTD parentDTD) {
		theParentDTD = parentDTD;
		if (theParentDTD != null && theParentDTD.getRootElementName() != null)
			theRootElementName = theParentDTD.getRootElementName();
		else
			theRootElementName = rootElementName;
		theElementTypes = new HashMap();
		theGeneralEntities = new HashMap();
		theParameterEntities = new HashMap();
		theNotations = new HashMap();
		theUnparsedEntities = new HashMap();
	}

	// *** DTD Methods ***
	
	public Name getRootElementName() {
		return theRootElementName;
	}
	
	public ElementType getElementType(Name elementName) {
		ElementType result = theParentDTD != null ? theParentDTD.getElementType(elementName) : null;
		if (result == null)
			result = (ElementType) theElementTypes.get(elementName);
		return result;
	}
	
	public Entity getGeneralEntity(Name entityName) {
		Entity result = theParentDTD != null ? theParentDTD.getGeneralEntity(entityName) : null;
		if (result == null)
			result = (Entity) theGeneralEntities.get(entityName);
		return result;
	}
	
	public Entity getParameterEntity(Name entityName) {
		Entity result = theParentDTD != null ? theParentDTD.getParameterEntity(entityName) : null;
		if (result == null)
			result = (Entity) theParameterEntities.get(entityName);
		return result;
	}
	
	public Notation getNotation(Name notationName) {
		Notation result = theParentDTD != null ? theParentDTD.getNotation(notationName) : null;
		if (result == null)
			result = (Notation) theNotations.get(notationName);
		return result;
	}
	
	public UnparsedEntity getUnparsedEntity(Name unparsedEntityName) {
		UnparsedEntity result = theParentDTD != null ? theParentDTD.getUnparsedEntity(unparsedEntityName) : null;
		if (result == null)
			result = (UnparsedEntity) theUnparsedEntities.get(unparsedEntityName);
		return result;
	}

	// *** Public Methods ***
	
	public void addElementType(ElementType elementType) {
		Name name = elementType.getName();
		if (theElementTypes.containsKey(name))
			throw new IllegalArgumentException("Duplicate ElementType declaration for name: " + name);
				
		theElementTypes.put(name, elementType);
	}
	
	public void addGeneralEntity(Entity entity) {
		Name name = entity.getName();
		if (theGeneralEntities.containsKey(name))
			throw new IllegalArgumentException("Duplicate Entity declaration for name: " + name);
		
		theGeneralEntities.put(name, entity);
	}
	
	public void addParameterEntity(Entity entity) {
		Name name = entity.getName();
		if (theParameterEntities.containsKey(name))
			throw new IllegalArgumentException("Duplicate Parameter Entity declaration for name: " + name);
		
		theParameterEntities.put(name, entity);
	}
	
	public void addNotation(Notation notation) {
		Name name = notation.getName();
		if (theNotations.containsKey(name))
			throw new IllegalArgumentException("Duplicate Entity declaration for name: " + name);
		
		theNotations.put(name, notation);
	}
	
	public void addUnparsedEntity(UnparsedEntity unparsedEntity) {
		Name name = unparsedEntity.getName();
		if (theUnparsedEntities.containsKey(name))
			throw new IllegalArgumentException("Duplicate UnparsedEntity declaration for name: " + name);
		
		theUnparsedEntities.put(name, unparsedEntity);
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










/* end */