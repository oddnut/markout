/*
	AttributeDef.java
	
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
 * AttributeDef
 *
 * Comment here.  Author: David Fogel
 */
public class AttributeDef {
	// *** Class Members ***
	
	public static final int CDATA_TYPE = 0;
	public static final int ID_TYPE = 1;
	public static final int IDREF_TYPE = 2;
	public static final int IDREFS_TYPE = 3;
	public static final int ENTITY_TYPE = 4;
	public static final int ENTITIES_TYPE = 5;
	public static final int NMTOKEN_TYPE = 6;
	public static final int NMTOKENS_TYPE = 7;
	public static final int ENUMERATION_TYPE = 8;
	public static final int NOTATION_TYPE = 9;
	
	public static final int TYPE_CODE_MIN_VAL = 0;
	public static final int TYPE_CODE_MAX_VAL = 9;

	// *** Instance Members ***
	
	private Name theName;
	
	private int theTypeCode;
	
	private Set theEnumValues;
	
	private boolean isRequired;
	private boolean isFixed;
	private AttValue theDefault;

	// *** Constructors ***
	
	public AttributeDef(Name name,
						int typeCode,
						boolean required) {
		theName = name;
		
		checkTypeCodeRange(typeCode);
		
		if (theTypeCode == ENUMERATION_TYPE ||
			theTypeCode == NOTATION_TYPE)
			throw new IllegalArgumentException("Attribute types of Enumeration and Notation require enum values.");
		
		theTypeCode = typeCode;
		theEnumValues = null;
		
		isRequired = required;
		isFixed = false;
		theDefault = null;
	}
	
	public AttributeDef(Name name,
						int typeCode,
						AttValue defaultValue,
						boolean fixed) {
		theName = name;
		
		checkTypeCodeRange(typeCode);
		
		if (theTypeCode == ENUMERATION_TYPE ||
				theTypeCode == NOTATION_TYPE)
			throw new IllegalArgumentException("Attribute types of Enumeration and Notation require enum values.");
		
		theTypeCode = typeCode;
		theEnumValues = null;
		
		if (defaultValue == null)
			throw new IllegalArgumentException("Default value must not be null.");
		
		isFixed = fixed;
		isRequired = false;
		theDefault = defaultValue;
	}
	
	public AttributeDef(Name name,
						int typeCode,
						Collection enumVals,
						boolean required) {
		theName = name;
		
		checkTypeCodeRange(typeCode);
		
		theTypeCode = typeCode;
		
		if (theTypeCode != ENUMERATION_TYPE &&
				theTypeCode != NOTATION_TYPE)
			throw new IllegalArgumentException("Must be of type Enumartion or Notation to have enum values");
		
		if (enumVals == null)
			throw new IllegalArgumentException("enumVals must not be null.");
		
		theEnumValues = new HashSet();
		theEnumValues.addAll(enumVals);
		
		isRequired = required;
		isFixed = false;
		theDefault = null;
	}
	
	public AttributeDef(Name name,
						int typeCode,
						Collection enumVals,
						AttValue defaultValue,
						boolean fixed) {
		theName = name;
		
		checkTypeCodeRange(typeCode);
		
		theTypeCode = typeCode;
		
		if (theTypeCode != ENUMERATION_TYPE &&
				theTypeCode != NOTATION_TYPE)
			throw new IllegalArgumentException("Must be of type Enumartion or Notation to have enum values");
		
		if (enumVals == null)
			throw new IllegalArgumentException("enumVals must not be null.");
		
		theEnumValues = new HashSet();
		theEnumValues.addAll(enumVals);
		
		if (defaultValue == null)
			throw new IllegalArgumentException("Default value must not be null.");
		
		if ( ! theEnumValues.contains(defaultValue))
			throw new IllegalArgumentException("The default value must be one of the enum vals.");
		
		isFixed = fixed;
		isRequired = false;
		theDefault = defaultValue;
	}

	// *** Object Methods ***
	
	public boolean equals(Object o) {
		if( o == null || !(o instanceof AttributeDef))
			return false;
		AttributeDef ad = (AttributeDef) o;
		if ( ! theName.equals(ad.theName) ||
				theTypeCode != ad.theTypeCode ||
				isRequired != ad.isRequired)
			return false;
		if (theDefault != ad.theDefault)
			return false;
		if (theDefault != null && !theDefault.equals(ad.theDefault))
			return false;
		if (theEnumValues != ad.theEnumValues)
			return false;
		if (theEnumValues != null && !theEnumValues.equals(ad.theEnumValues))
			return false;
		return true;
	}

	// *** Public Methods ***
	
	public Name getName() {
		return theName;
	}
	
	public int getTypeCode() {
		return theTypeCode;
	}
	
	public boolean isRequired() {
		return isRequired;
	}
	
	public boolean isFixed() {
		return isFixed;
	}
	
	public AttValue getDefault() {
		return theDefault;
	}
	
	public Set getEnumValues() {
		return theEnumValues;
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***
	
	private void checkTypeCodeRange(int code) {
		if (code < TYPE_CODE_MIN_VAL ||
			code > TYPE_CODE_MAX_VAL)
			throw new IllegalArgumentException("Illegal Type Code");
	}

	// *** Private Classes ***
}










/* end */