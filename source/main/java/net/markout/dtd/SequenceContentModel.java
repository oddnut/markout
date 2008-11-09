/*
	SequenceContentModel.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.dtd;

// *** imports ***

import java.util.ArrayList;
import java.util.List;

import net.markout.types.Name;

/**
 * SequenceContentModel
 *
 * Comment here.  Author: David Fogel
 */
public class SequenceContentModel implements ContentModel {
	// *** Class Members ***

	// *** Instance Members ***
	
	private List theChildren;

	// *** Constructors ***
	
	public SequenceContentModel(List children) {
		theChildren = new ArrayList(children);
	}

	// *** ContentModel Methods ***
	
	public ContentValidator getValidator() {
		return new SequenceValidator();
	}

	// *** Public Methods ***
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append('(');
		
		int length = theChildren.size();
		for (int i = 0 ; i < length ; i++) {
			if (i > 0)
				sb.append(',');
			sb.append(theChildren.get(i).toString());
		}
		
		sb.append(')');
		
		return sb.toString();
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
	
	private class SequenceValidator implements ContentValidator {
		
		ContentValidator theCurrentValidator;
		int theCurrentIndex;
		
		public SequenceValidator() {
			theCurrentValidator = null;
			theCurrentIndex = -1;
		}
		
		public void reset() {
			theCurrentValidator = null;
			theCurrentIndex = -1;
		}
		
		public boolean validateCharData() {
			return false;
		}
		
		public boolean validateNext(Name elementName) {
			
			if (theCurrentValidator != null) {
				// try the current one
				if (theCurrentValidator.validateNext(elementName))
					return true;
				// or try to close it.
				if (!theCurrentValidator.validateClose())
					return false;
			}
			
			theCurrentIndex++;
			
			if (theCurrentIndex >= theChildren.size())
				return false;
			
			ContentModel model = (ContentModel) theChildren.get(theCurrentIndex);
			
			theCurrentValidator = model.getValidator();
			
			return validateNext(elementName); // recursive call with next validator set
			
		}
		
		public boolean validateClose() {
			
			int length = theChildren.size();
			
			if (length == 0)
				return true;
			
			if (theCurrentValidator != null) {
				if ( ! theCurrentValidator.validateClose())
					return false;
			}
			
			theCurrentIndex++;
					
			while (theCurrentIndex < length) {
				ContentModel model = (ContentModel) theChildren.get(theCurrentIndex);
				if ( ! model.getValidator().validateClose())
					return false;
				theCurrentIndex++;
			}
			
			return true;
		}
	}
}










/* end */