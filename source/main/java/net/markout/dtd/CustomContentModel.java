/*
	CustomContentModel.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.dtd;

// *** imports ***


/**
 * CustomContentModel
 *
 * Comment here.  Author: David Fogel
 */
public abstract class CustomContentModel implements ContentModel {
	// *** Class Members ***

	// *** Instance Members ***

	// *** Constructors ***
	
	public CustomContentModel() {
	}

	// *** ContentModel Methods ***
			
	public boolean allowsCharData() {
		return false;
	}
	
	abstract public ContentValidator getValidator();
	/*
	public ContentValidator getValidator() {
		ContentValidator result = null;
		try {
			result = (ContentValidator) theValidatorClass.newInstance();
		} catch (IllegalAccessException eae) {
			throw new ValidationException(
					"IllegalAccessException while trying to create Validator for class " + 
					theValidatorClass.toString());
		} catch (InstantiationException ie) {
			throw new ValidationException(
					"InstantiationException while trying to create Validator for class " + 
					theValidatorClass.toString());
		}
		return result;
	}*/

	// *** Public Methods ***

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










/* end */