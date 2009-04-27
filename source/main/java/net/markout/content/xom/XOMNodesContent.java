/*
	XOMNodesContent.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.content.xom;

import java.io.IOException;

import net.markout.ContentWriter;
import net.markout.content.Content;
import nu.xom.Nodes;

/**
 * XOMNodesContent
 * 
 * Comment here.
 */
public class XOMNodesContent implements Content {
	// *** Class Members ***

	// *** Instance Members ***
	private Nodes nodes;

	// *** Constructors ***
	public XOMNodesContent(Nodes nodes) {
		this.nodes = nodes;
	}

	// *** Content Methods ***
	public void writeTo(ContentWriter out) throws IOException {
		XOMAdapter.writeTo(out, nodes);
	}

	// *** Public Methods ***
	public Nodes getNodes() {
		return nodes;
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}
