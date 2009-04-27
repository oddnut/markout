/*
	MText.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.content.xom;

import nu.xom.Node;
import nu.xom.Text;

/**
 * MText
 * 
 * Comment here.
 */
public class MText extends Text {
	// *** Class Members ***

	// *** Instance Members ***
	private net.markout.types.Text markoutText;

	// *** Constructors ***
	public MText(String data) {
		super(data);
		
		updateText();
	}
	
	public MText(Text text) {
		super(text);
		
		updateText();
	}

	// *** Text Methods ***

	@Override
	public Node copy() {
		return new MText(getValue());
	}

	@Override
	public void setValue(String data) {
		super.setValue(data);
		
		updateText();
	}

	// *** Public Methods ***
	public net.markout.types.Text getMarkoutText() {
		return markoutText;
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***
	private void updateText() {
		markoutText = new net.markout.types.Text(getValue());
	}

	// *** Private Classes ***
}
