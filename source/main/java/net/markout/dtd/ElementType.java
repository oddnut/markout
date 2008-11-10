/*
	ElementType.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.dtd;

// *** imports ***

import java.util.*;

import net.markout.types.AttValue;
import net.markout.types.Name;

/**
 * ElementType
 *
 * Comment here.  Author: David Fogel
 */
public class ElementType {
	// *** Class Members ***

	// *** Instance Members ***
	
	private Name theName;
	private ContentModel theModel;
	
	private Map<Name, AttributeDef> theAttributeDefs;
	private Map<Name, AttributeDef> theUnmodDefs;
	
	private Collection<AttributeDef> theRequiredAttributes;
	
	private Set<Name> theDescendantProhibitions;
	private Set<Name> theUnmodProhibitions;

	// *** Constructors ***
	
	public ElementType(	Name name, 
						ContentModel model,
						Collection<AttributeDef> attributeDefs,
						Collection<Name> descendantProhibitions) {
		if (name == null)
			throw new IllegalArgumentException("Name can't be null");
		theName = name;
		theModel = model != null ? model : ContentModel.EMPTY;
		theAttributeDefs = new HashMap<Name, AttributeDef>();
		theRequiredAttributes = new ArrayList<AttributeDef>();
		if (attributeDefs != null) {
			Iterator<AttributeDef> i = attributeDefs.iterator();
			while(i.hasNext()) {
				AttributeDef def = i.next();
				Name n = def.getName();
				if ( ! theAttributeDefs.containsKey(n)) {
					theAttributeDefs.put(n, def);
					if (def.isRequired())
						theRequiredAttributes.add(def);
				}
			}
		}
		theUnmodDefs = Collections.unmodifiableMap(theAttributeDefs);
		
		theDescendantProhibitions = new HashSet<Name>();
		if (descendantProhibitions != null)
			theDescendantProhibitions.addAll(descendantProhibitions);
		theUnmodProhibitions = Collections.unmodifiableSet(theDescendantProhibitions);
	}

	// *** Object Methods ***
	
	public boolean equals(Object o) {
		if ( ! (o instanceof ElementType))
			return false;
		ElementType et = (ElementType) o;
		return theName.equals(et.theName) &&
				theModel.equals(et.theModel) &&
				theAttributeDefs.equals(et.theAttributeDefs);
	}
	
	public int hashCode() {
		return theName.hashCode() ^ theModel.hashCode() ^ theAttributeDefs.hashCode();
	}
	
	public String toString() {
		return "Element: " + theName.toString() + 
				" " + theModel.toString() + 
				" " + theAttributeDefs.toString();
	}

	// *** Public Methods ***
	
	public Name getName() {
		return theName;
	}
	
	public void addAttributeDef(AttributeDef def) {
		Name name = def.getName();
		if ( ! theAttributeDefs.containsKey(name)) {
			theAttributeDefs.put(name, def);
			if (def.isRequired())
				theRequiredAttributes.add(def);
		}
	}
	
	public Map<Name, AttributeDef> getAttributeDefMap() {
		return theUnmodDefs;
	}
	
	public AttributeValidator getAttributeValidator() {
		return new AttValidator();
	}
	
	public ContentModel getContentModel() {
		return theModel;
	}
	
	public ContentValidator getContentValidator() {
		return theModel.getValidator();
	}
	
	public void addDescendantProhibition(Name elementName) {
		theDescendantProhibitions.add(elementName);
	}
	
	public Set<Name> getDescendantProhibitions() {
		return theUnmodProhibitions;
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
	
	private class AttValidator implements AttributeValidator {
		
		private Set<AttributeDef> theRemainingRequired = Collections.emptySet();
		
		public AttValidator() {
			if (!theRequiredAttributes.isEmpty())
				theRemainingRequired = new HashSet<AttributeDef>(theRequiredAttributes);
		}
		
		public void validateNext(Name attributeName, AttValue value, DocumentValidator docValidator) {
			AttributeDef def = theAttributeDefs.get(attributeName);
			if (def == null)
				throw new ValidationException("Attribute " + attributeName + " not defined for element " + theName);
			
			switch (def.getTypeCode()) {
			
				case AttributeDef.CDATA_TYPE:
					break;
					
				case AttributeDef.ENUMERATION_TYPE:
				case AttributeDef.NOTATION_TYPE: // note: what about Notation Name?
					if ( ! def.getEnumValues().contains(value))
						throw new ValidationException("The value " + value + 
								" is not a legal value for attribute " + attributeName + 
								" in element " + theName);
					break;
					
				case AttributeDef.ID_TYPE:
					// TODO we should check to make sure we are a legal name...
					docValidator.validateIDValue(value);
					break;
					
				case AttributeDef.IDREF_TYPE:
					// TODO we need to check legal name here...
					docValidator.addIDRef(value);
					break;
					
				case AttributeDef.IDREFS_TYPE:
					// TODO this is totaly broken.  We're going to have to re-do AttValues. also see above
					StringTokenizer st = new StringTokenizer(value.getUnquotedValue(), " ");
					while(st.hasMoreTokens())
						docValidator.addIDRef(new AttValue(st.nextToken()));
					break;
					
				// TODO - this all will get easier if we re-do AttValues to have different types...
				case AttributeDef.ENTITY_TYPE:
				case AttributeDef.ENTITIES_TYPE:
				case AttributeDef.NMTOKEN_TYPE:
				case AttributeDef.NMTOKENS_TYPE:
				default:
					break;
			}
			
			theRemainingRequired.remove(def);
		}
		
		public void close() {
			if ( ! theRemainingRequired.isEmpty()) {
				StringBuffer sb = new StringBuffer();
				Iterator<AttributeDef> i = theRemainingRequired.iterator();
				sb.append(i.next().getName());
				while(i.hasNext()) {
					sb.append(", ");
					sb.append(i.next().getName());
				}
				throw new ValidationException("Missing required attributes: " + sb.toString());
			}
		}
	}
	
}










/* end */
