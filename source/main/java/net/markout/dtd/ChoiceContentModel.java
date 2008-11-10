/*
	ChoiceContentModel.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.dtd;

// *** imports ***

import java.util.*;

import net.markout.types.Name;

/**
 * ChoiceContentModel
 *
 * Comment here.  Author: David Fogel
 */
public class ChoiceContentModel implements ContentModel {
	// *** Class Members ***

	// *** Instance Members ***
	
	private List<ContentModel> theChildren;

	// *** Constructors ***
	
	public ChoiceContentModel(Collection<ContentModel> children) {
		theChildren = new ArrayList<ContentModel>(children);
	}

	// *** ContentModel Methods ***
	
	public ContentValidator getValidator() {
		return new ChoiceValidator();
	}

	// *** Public Methods ***
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append('(');
		
		int length = theChildren.size();
		for (int i = 0 ; i < length ; i++) {
			if (i > 0)
				sb.append('|');
			sb.append(theChildren.get(i).toString());
		}
		
		sb.append(')');
		
		return sb.toString();
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
	
	private class ChoiceValidator implements ContentValidator {
		
		ContentValidator theCurrentValidator;
		
		public ChoiceValidator() {
			theCurrentValidator = null;
		}
		
		public void reset() {
			theCurrentValidator = null;
		}
		
		public boolean validateCharData() {
			return false;
		}
		
		public boolean validateNext(Name elementName) {
			
			if (theCurrentValidator != null) 
				return theCurrentValidator.validateNext(elementName);
			
			//else need to find one
			int length = theChildren.size();
			for (int i = 0 ; i < length ; i++) {
				ContentModel model = theChildren.get(i);
				ContentValidator val = model.getValidator();
				if (val.validateNext(elementName)) {
					theCurrentValidator = val;
					return true;
				}
			}
			return false; // none match
		}
		
		public boolean validateClose() {
			
			if (theCurrentValidator != null) 
				return theCurrentValidator.validateClose();
			
			//else need to find one
			int length = theChildren.size();
			for (int i = 0 ; i < length ; i++) {
				ContentModel model = theChildren.get(i);
				ContentValidator val = model.getValidator();
				if (val.validateClose()) {
					theCurrentValidator = val;
					return true;
				}
			}
			return false; // none match
		}
	}
}










/* end */