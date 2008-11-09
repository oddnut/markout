/*
	RecurrenceContentModel.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.dtd;

// *** imports ***

import net.markout.types.Name;

/**
 * RecurrenceContentModel
 *
 * Comment here.  Author: David Fogel
 */
public class RecurrenceContentModel implements ContentModel {
	// *** Class Members ***

	public static final char ZERO_OR_ONE = '?';
	public static final char ZERO_OR_MORE = '*';
	public static final char ONE_OR_MORE = '+';
	
	// *** Instance Members ***
	
	private char theMode;
	private ContentModel theModel;

	// *** Constructors ***
	
	public RecurrenceContentModel(char recurrenceMode, ContentModel model) {
		theModel = model;
		theMode = recurrenceMode;
		
		if (theMode != ZERO_OR_ONE &&
			theMode != ZERO_OR_MORE &&
			theMode != ONE_OR_MORE)
			throw new IllegalArgumentException("Illegal recurrence mode value");
	}

	// *** ContentModel Methods ***
	
	public ContentValidator getValidator() {
		return new RecurrentValidator(theModel.getValidator());
	}

	// *** Public Methods ***
	
	public String toString() {
		return theModel.toString() + theMode;
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
	
	private class RecurrentValidator implements ContentValidator {
		
		ContentValidator theValidator;
		int theCount;
		boolean isStarted;
		
		public RecurrentValidator(ContentValidator validator) {
			theValidator = validator;
			theCount = 0;
			isStarted = false;
		}
		
		public void reset() {
			theValidator.reset();
			theCount = 0;
			isStarted = false;
		}
		
		public boolean validateCharData() {
			
			return false;
		}
		
		public boolean validateNext(Name elementName) {
			
			while(true) {
			
				if (theCount == 1 &&
					(theMode == ZERO_OR_ONE))
					return false;
				
				if (theValidator.validateNext(elementName)) {
					isStarted = true;
					return true;
				}
				
				if ( 	! isStarted || // if we'll never be able to start...
						! theValidator.validateClose()) // ...or we've started but can't close
					return false;
				
				theValidator.reset();
				isStarted = false;
				theCount++;
			}
		}
		
		public boolean validateClose() {
			
			if (isStarted) {
				if ( ! theValidator.validateClose())
					return false;
				
				theValidator.reset();
				isStarted = false;
				theCount++;
			}
			
			if (theCount == 0)
				return (theMode == ZERO_OR_ONE || theMode == ZERO_OR_MORE);
			
			if (theCount == 1)
				return true;
			
			//(theCount > 1)
			return (theMode == ZERO_OR_MORE || theMode == ONE_OR_MORE);
		}
	}
}










/* end */