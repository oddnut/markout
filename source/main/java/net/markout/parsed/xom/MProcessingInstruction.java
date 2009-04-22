/*
	MProcessingInstruction.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.parsed.xom;

import net.markout.types.Instruction;
import net.markout.types.Target;
import nu.xom.Node;
import nu.xom.ProcessingInstruction;

/**
 * MProcessingInstruction
 * 
 * Comment here.
 */
public class MProcessingInstruction extends ProcessingInstruction {
	// *** Class Members ***

	// *** Instance Members ***
	private Target target;
	private Instruction instruction;

	// *** Constructors ***
	public MProcessingInstruction(String target, String data) {
		super(target, data);
		
		updatePI();
	}
	
	public MProcessingInstruction(ProcessingInstruction pi) {
		super(pi);
		
		updatePI();
	}

	// *** ProcessingInstruction Methods ***

	@Override
	public Node copy() {
		return new MProcessingInstruction(getTarget(), getValue());
	}

	@Override
	public void setTarget(String target) {
		super.setTarget(target);
		
		updatePI();
	}

	@Override
	public void setValue(String data) {
		super.setValue(data);
		
		updatePI();
	}

	// *** Public Methods ***
	public Target getMarkoutTarget() {
		return target;
	}
	
	public Instruction getMarkoutInstruction() {
		return instruction;
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***
	public void updatePI() {
		target = new Target(getTarget());
		instruction = new Instruction(getValue());
	}

	// *** Private Classes ***
}
