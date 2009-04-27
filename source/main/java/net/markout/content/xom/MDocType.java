/*
	MDocType.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.content.xom;

import net.markout.types.Name;
import net.markout.types.PublicIDLiteral;
import net.markout.types.SystemLiteral;
import nu.xom.DocType;
import nu.xom.Node;

/**
 * MDocType
 * 
 * Comment here.
 */
public class MDocType extends DocType {
	// *** Class Members ***

	// *** Instance Members ***
	private Name markoutName;
	private PublicIDLiteral markoutPublicID;
	private SystemLiteral markoutSystemID;
	

	// *** Constructors ***
	public MDocType(String rootElementName, String publicID, String systemID) {
		super(rootElementName, publicID, systemID);
		
		updateDocType();
	}

	// *** DocType Methods ***
	@Override
	public Node copy() {
		return new MDocType(getRootElementName(), getPublicID(), getSystemID());
	}

	@Override
	public void setPublicID(String id) {
		super.setPublicID(id);
		
		updateDocType();
	}

	@Override
	public void setRootElementName(String name) {
		super.setRootElementName(name);
		
		updateDocType();
	}

	@Override
	public void setSystemID(String id) {
		super.setSystemID(id);
		
		updateDocType();
	}

	// *** Public Methods ***
	public Name getMarkoutName() {
		return markoutName;
	}

	public PublicIDLiteral getMarkoutPublicID() {
		return markoutPublicID;
	}
	
	public SystemLiteral getMarkoutSystemID() {
		return markoutSystemID;
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***
	private void updateDocType() {
		markoutName = new Name(getRootElementName());
		markoutPublicID = new PublicIDLiteral(getPublicID());
		markoutSystemID = new SystemLiteral(getSystemID());
	}

	// *** Private Classes ***
}
