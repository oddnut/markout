/*
	JavaSourceGenerator.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.gen;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.markout.types.Attribute;
import net.markout.types.Name;

/**
 * JavaSourceGenerator
 * 
 * Comment here.
 */
public class JavaSourceGenerator {
	// *** Class Members ***
	public static List<String> javaReservedWords = Arrays.asList(
			"abstract","continue","for","new","switch",
			"assert","default","goto","package","synchronized",
			"boolean","do","if","private","this",
			"break","double","implements","protected","throw",
			"byte","else","import","public","throws",
			"case","enum","instanceof","return","transient",
			"catch","extends","int","short","try",
			"char","final","interface","static","void",
			"class","finally","long","strictfp","volatile",
			"const","float","native","super","while",
			"true","false","null");

	// *** Instance Members ***
	private Map<Name, String> substitutions;

	// *** Constructors ***
	public JavaSourceGenerator() {
		
		substitutions = new HashMap<Name,String>();
	}

	// *** Interface Methods ***

	// *** Public Methods ***
	public void addSubstitution(Name name, String methodName) {
		
		checkValidMethodName(methodName);
		
		substitutions.put(name, methodName);
	}
	
	public String asMethodName(Name name) {
		
		if (substitutions.containsKey(name))
			return substitutions.get(name);
		
		String method = name.toString();
		if (javaReservedWords.contains(name))
			return method + "_";
		
		// probably could do other substitutions here, but for now:
		checkValidMethodName(method);
		
		return method;
	}
	
	public String asConstantName(Name name) {
		String n = substitutions.containsKey(name) ? (String) substitutions.get(name) : name.toString();
		return asConstant(n);
	}
	
	public String asConstantName(Attribute a) {
		Name name = a.getName();
		String n = substitutions.containsKey(name) ? (String) substitutions.get(name) : name.toString();
		return asConstant(n + "_" + a.getValueString());
	}
	
	public String asConstant(String name) {
		StringBuilder sb = new StringBuilder();
		
		int length = name.length();
		for (int i = 0 ; i < length ; i++) {
			char c = name.charAt(i);
			if (Character.isLetterOrDigit(c))
				sb.append(Character.toUpperCase(c));
			else
				sb.append('_');
		}
		
		return sb.toString();
	}
	
	public static String capitalizeFirst(String name) {
		return name.toString().substring(0,1).toUpperCase() + name.toString().substring(1);
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***
	
	private void checkValidMethodName(String method) {
		int len = method.length();
		for (int i = 0 ; i < len ; i++) {
			char c = method.charAt(i);
			if (i == 0 && !Character.isJavaIdentifierStart(c))
				throw new IllegalArgumentException("method name doesn't begin with a valid java identifier start character");
			if (!Character.isJavaIdentifierPart(c))
				throw new IllegalArgumentException("illegal java identifier character at index = " + i);
		}
	}

	// *** Private Classes ***
}
