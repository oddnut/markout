/*
	SimpleStateMachine.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.support;

// *** imports ***

import java.util.HashMap;
import java.util.Map;

/**
 * SimpleStateMachine
 *
 * Comment here.  Author: David Fogel
 */
public abstract class SimpleStateMachine {
	// *** Class Members ***

	// *** Instance Members ***
	
	private Map<String, Map<String, String>> theStates;
	private String theCurrentState;

	// *** Constructors ***
	
	protected SimpleStateMachine() {
		theStates = new HashMap<String, Map<String, String>>();
		theCurrentState = null;
	}

	// *** Interface Methods ***

	// *** Public Methods ***
	
	public boolean transition(String transitionName) {
		Map<String, String> trans = theStates.get(theCurrentState);
		String newState = trans.get(transitionName);
		if (newState == null) {
			handleIllegalTransition(transitionName);
			return false;
		} else {
			String oldState = theCurrentState;
			theCurrentState = newState;
			handleTransition(oldState, transitionName);
			return true;
		}
	}

	public String currentState() {
		return theCurrentState;
	}
	
	// *** Protected Methods ***
	
	protected void addState(String stateName) {
		if (theStates.containsKey(stateName))
			throw new IllegalArgumentException("Can't add a state twice!");
		theStates.put(stateName, new HashMap<String, String>());
	}
	
	protected void addTransition(String fromState, String transitionName, String toState) {
		if ( ! theStates.containsKey(fromState))
			throw new IllegalArgumentException("No such state as " + fromState);
		if ( ! theStates.containsKey(toState))
			throw new IllegalArgumentException("No such state as " + toState);
		Map<String, String> trans = theStates.get(fromState);
		if (trans.containsKey(transitionName))
			throw new IllegalArgumentException("Can't add a transition twice to the same state!");
		trans.put(transitionName, toState);
	}
	
	protected void start(String startState) {
		if (theCurrentState != null)
			throw new IllegalStateException("Can't call start more than once.");
		if ( ! theStates.containsKey(startState))
			throw new IllegalArgumentException("No such state as " + startState);
		theCurrentState = startState;
	}
	
	protected void setCurrentState(String stateName) {
		if (theCurrentState == null)
			throw new IllegalStateException("Must call start() first");
		if ( ! theStates.containsKey(stateName))
			throw new IllegalArgumentException("No such state as " + stateName);
	}
	
	protected void handleIllegalTransition(String transitionName) {
		// default behavior
		throw new IllegalStateException("Illegal transition: " + transitionName + 
										" from state: " + theCurrentState);
	}
	
	protected void handleTransition(String fromState, String transitionName) {
		// default do nothing
	}

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










// end
