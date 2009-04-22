/*
	MComment.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.parsed.xom;

import nu.xom.Comment;
import nu.xom.Node;

/**
 * MComment
 * 
 * Comment here.
 */
public class MComment extends Comment {
	// *** Class Members ***

	// *** Instance Members ***
	private net.markout.types.Comment comment;

	// *** Constructors ***
	public MComment(String data) {
		super(data);
		
		updateComment();
	}
	
	public MComment(Comment comment) {
		super(comment);
		
		updateComment();
	}

	// *** Comment Methods ***

	@Override
	public Node copy() {
		return new MComment(getValue());
	}

	@Override
	public void setValue(String data) {
		super.setValue(data);
		
		updateComment();
	}

	// *** Public Methods ***
	public net.markout.types.Comment getComment() {
		return comment;
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***
	private void updateComment() {
		comment = new net.markout.types.Comment(getValue());
	}

	// *** Private Classes ***
}
