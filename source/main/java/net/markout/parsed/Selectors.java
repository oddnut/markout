/*
	Selectors.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.parsed;

import java.util.List;

import net.markout.types.Attribute;
import net.markout.types.Name;

/**
 * Selectors
 * 
 * Comment here.
 */
public class Selectors {
	// *** Class Members ***
	
	public static final ContentSelector ROOT_ELEMENT = new ContentSelector() {
		public Selection select(List<Name> elementNameStack, Name currentElement, Attribute[] attributes) {
			return Selection.element;
		}
	};
	
	public static final ContentSelector ROOT_CONTENT = new ContentSelector() {
		public Selection select(List<Name> elementNameStack, Name currentElement, Attribute[] attributes) {
			return Selection.element_content;
		}
	};
	
	public static ContentSelector elementsWithName(final Name elementName) {
		return new ElSelector(elementName, false);
	}
	
	public static ContentSelector contentOfElementsWithName(final Name elementName) {
		return new ElSelector(elementName, true);
	}
	
	public static ContentSelector elementsWithAttribute(Attribute attribute) {
		return new AttSelector(attribute, false);
	}
	
	public static ContentSelector contentOfElementsWithAttribute(Attribute attribute) {
		return new AttSelector(attribute, true);
	}
	

	// *** Instance Members ***

	// *** Constructors ***
	private Selectors() {}

	// *** Interface Methods ***

	// *** Public Methods ***

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
	private static class ElSelector implements ContentSelector {
		private Name name;
		private boolean onlyContent;
		public ElSelector(Name name, boolean onlyContent) {
			this.name = name;
			this.onlyContent = onlyContent;
		}
		public Selection select(List<Name> elementNameStack, Name currentElement, Attribute[] attributes) {
			return currentElement.equals(name) ? (onlyContent ? Selection.element_content : Selection.element) : Selection.skip;
		}
	}
	
	private static class AttSelector implements ContentSelector {
		private Attribute attribute;
		private boolean onlyContent;
		public AttSelector(Attribute attribute, boolean onlyContent) {
			this.attribute = attribute;
			this.onlyContent = onlyContent;
		}
		public Selection select(List<Name> elementNameStack, Name currentElement, Attribute[] attributes) {
			if (attributes == null)
				return Selection.skip;
			for (Attribute a : attributes)
				if (a.equals(attribute))
					return onlyContent ? Selection.element_content : Selection.element;
			return Selection.skip;
		}
	}
}





