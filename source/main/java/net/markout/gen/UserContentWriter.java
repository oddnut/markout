/*
	UserContentWriter.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.gen;

import java.io.IOException;

import net.markout.*;
import net.markout.types.*;

/**
 * UserContentWriter
 * 
 * THIS IS A GENERATED FILE, DO NOT EDIT!
 */
public interface UserContentWriter extends ContentWriter {
	// *** Class Members ***

	// *** Public Methods ***
	
	public UserContentWriter first(Attribute... attributes) throws IOException;
	public void emptyFirst(Attribute... attributes) throws IOException;
	
	public UserContentWriter last(Attribute... attributes) throws IOException;
	public void emptyLast(Attribute... attributes) throws IOException;
	
	public UserContentWriter ssn(Attribute... attributes) throws IOException;
	public void emptySsn(Attribute... attributes) throws IOException;
	
	public UserContentWriter user(Attribute... attributes) throws IOException;
	public void emptyUser(Attribute... attributes) throws IOException;
}

