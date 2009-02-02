/*
	SAXDTDConstantsGenerator.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.oldgen;

// *** imports ***
import java.io.IOException;
import java.io.Writer;
import java.util.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.*;
import org.xml.sax.ext.DeclHandler;

/**
 * SAXDTDConstantsGenerator
 *
 * Comment here.  Author: David Fogel
 */
public class SAXDTDConstantsGenerator implements DTDHandler, DeclHandler  {
	// *** Class Members ***
	
	

	// *** Instance Members ***
	
	private HashSet<String> theNotationNames;
	private HashSet<String> theUnparsedEntityNames;
	private HashSet<String> theParameterEntityNames;
	private HashSet<String> theGeneralEntityNames;
	private HashSet<String> theElementNames;
	private HashSet<String> theAttributeNames;
	private HashSet<String> theAttributeValues;

	// *** Constructors ***
	
	public SAXDTDConstantsGenerator() {
		theNotationNames = new HashSet<String>();
		theUnparsedEntityNames = new HashSet<String>();
		theParameterEntityNames = new HashSet<String>();
		theGeneralEntityNames = new HashSet<String>();
		theElementNames = new HashSet<String>();
		theAttributeNames = new HashSet<String>();
		theAttributeValues = new HashSet<String>();
	}

	// *** DTDHandler Methods ***
	
	public void notationDecl (String name, String publicId, String systemId) throws SAXException {
		
		theNotationNames.add(name);
	}
	
	public void unparsedEntityDecl (String name, String publicId, 
			String systemId, String notationName) throws SAXException {
		
		theUnparsedEntityNames.add(name);
	}
	
	// *** DeclHandler Methods ***
	
	public void elementDecl (String name, String model) throws SAXException {
		theElementNames.add(name);
	}
	
	public void attributeDecl (	String eName,
			String aName,
			String type,
			String valueDefault,
			String value) throws SAXException {
		
		theAttributeNames.add(aName);
		
		int i = type.indexOf('(');
		if (i >= 0) {
			String s = type.substring(i+1, type.indexOf(')'));
			StringTokenizer st = new StringTokenizer(s, "|");
			while(st.hasMoreTokens()) {
				String val = st.nextToken();
				theAttributeValues.add(val);
			}
		}
		
		if (value != null)
			theAttributeValues.add(value);
	}
	
	public void internalEntityDecl (String name, String value) throws SAXException {
		if (name.startsWith("%"))
			theParameterEntityNames.add(name.substring(1));
		else
			theGeneralEntityNames.add(name);
	}
	
	public void externalEntityDecl (String name, String publicId, String systemId)
	throws SAXException {
		
		if (name.startsWith("%"))
			theParameterEntityNames.add(name.substring(1));
		else
			theGeneralEntityNames.add(name);
	}

	// *** Public Methods ***
	
	public void parse(InputSource xmlIn) throws SAXException, ParserConfigurationException, IOException {
		XMLReader xmlr = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
		//xmlr.setContentHandler(this);
		//xmlr.setErrorHandler(this);
		//xmlr.setProperty("http://xml.org/sax/properties/lexical-handler", this);
		xmlr.setDTDHandler(this);
		xmlr.setProperty("http://xml.org/sax/properties/declaration-handler", this);
		xmlr.parse(xmlIn);
	}
	
	public void writeTo(Writer out) throws IOException {
		ArrayList<String> names = new ArrayList<String>();
		
		out.write("\n\n\t// *** Notation Names ***\n");
		names.clear();
		names.addAll(theNotationNames);
		Collections.sort(names);
		Iterator<String> i = names.iterator();
		while(i.hasNext()) {
			String name = i.next();
			out.write("\tpublic static final Name ");
			out.write(constant(name));
			out.write(" = new Name(\"");
			out.write(name);
			out.write("\");\n");
		}
		out.write("\t// *** Lookup ***\n");
		i = names.iterator();
		while(i.hasNext()) {
			String name = i.next();
			out.write("\t\tmap.put(\"");
			out.write(name);
			out.write("\", ");
			out.write(constant(name));
			out.write(");\n");
		}
		
		out.write("\n\n\t// *** Unparsed Entity Names ***\n");
		names.clear();
		names.addAll(theUnparsedEntityNames);
		Collections.sort(names);
		i = names.iterator();
		while(i.hasNext()) {
			String name = i.next();
			out.write("\tpublic static final Name ");
			out.write(constant(name));
			out.write(" = new Name(\"");
			out.write(name);
			out.write("\");\n");
		}
		out.write("\t// *** Lookup ***\n");
		i = names.iterator();
		while(i.hasNext()) {
			String name = i.next();
			out.write("\t\tmap.put(\"");
			out.write(name);
			out.write("\", ");
			out.write(constant(name));
			out.write(");\n");
		}
		
		out.write("\n\n\t// *** Parameter Entity Names ***\n");
		names.clear();
		names.addAll(theParameterEntityNames);
		Collections.sort(names);
		i = names.iterator();
		while(i.hasNext()) {
			String name = i.next();
			out.write("\tpublic static final Name ");
			out.write(constant(name));
			out.write(" = new Name(\"");
			out.write(name);
			out.write("\");\n");
		}
		out.write("\t// *** Lookup ***\n");
		i = names.iterator();
		while(i.hasNext()) {
			String name = i.next();
			out.write("\t\tmap.put(\"");
			out.write(name);
			out.write("\", ");
			out.write(constant(name));
			out.write(");\n");
		}
		
		out.write("\n\n\t// *** General Entity Names ***\n");
		names.clear();
		names.addAll(theGeneralEntityNames);
		Collections.sort(names);
		i = names.iterator();
		while(i.hasNext()) {
			String name = i.next();
			out.write("\tpublic static final Name ");
			out.write(constant(name, true));
			out.write(" = new Name(\"");
			out.write(name);
			out.write("\");\n");
		}
		out.write("\t// *** Lookup ***\n");
		i = names.iterator();
		while(i.hasNext()) {
			String name = i.next();
			out.write("\t\tmap.put(\"");
			out.write(name);
			out.write("\", ");
			out.write(constant(name, true));
			out.write(");\n");
		}
		
		out.write("\n\n\t// *** Element Names ***\n");
		names.clear();
		names.addAll(theElementNames);
		Collections.sort(names);
		i = names.iterator();
		while(i.hasNext()) {
			String name = i.next();
			out.write("\tpublic static final Name ");
			out.write(constant(name));
			out.write(" = new Name(\"");
			out.write(name);
			out.write("\");\n");
		}
		out.write("\t// *** Lookup ***\n");
		i = names.iterator();
		while(i.hasNext()) {
			String name = i.next();
			out.write("\t\tmap.put(\"");
			out.write(name);
			out.write("\", ");
			out.write(constant(name));
			out.write(");\n");
		}
		
		out.write("\n\n\t// *** Attribute Names ***\n");
		names.clear();
		names.addAll(theAttributeNames);
		Collections.sort(names);
		i = names.iterator();
		while(i.hasNext()) {
			String name = i.next();
			out.write("\tpublic static final Name ");
			out.write(constant(name));
			out.write(" = new Name(\"");
			out.write(name);
			out.write("\");\n");
		}
		out.write("\t// *** Lookup ***\n");
		i = names.iterator();
		while(i.hasNext()) {
			String name = i.next();
			out.write("\t\tmap.put(\"");
			out.write(name);
			out.write("\", ");
			out.write(constant(name));
			out.write(");\n");
		}
		
		out.write("\n\n\t// *** Attribute Values ***\n");
		names.clear();
		names.addAll(theAttributeValues);
		Collections.sort(names);
		i = names.iterator();
		while(i.hasNext()) {
			String name = i.next();
			out.write("\tpublic static final AttValue ");
			out.write(constant(name));
			out.write(" = new AttValue(\"");
			out.write(name);
			out.write("\");\n");
		}
		out.write("\t// *** Lookup ***\n");
		i = names.iterator();
		while(i.hasNext()) {
			String name = i.next();
			out.write("\t\tmap.put(\"");
			out.write(name);
			out.write("\", ");
			out.write(constant(name));
			out.write(");\n");
		}
		
		out.close();
	}

	// *** Protected Methods ***
	
	protected String constant(String name) {
		return constant(name, false);
	}
	
	protected String constant(String name, boolean suffixIfHasUpperCase) {
		StringBuffer sb = new StringBuffer();
		
		int length = name.length();
		boolean uc = false;
		for (int i = 0 ; i < length ; i++) {
			char c = name.charAt(i);
			if (Character.isUpperCase(c))
				uc = true;
			if (Character.isLetterOrDigit(c))
				sb.append(Character.toUpperCase(c));
			else
				sb.append('_');
		}
		
		if (uc && suffixIfHasUpperCase) {
			sb.append('_');
			sb.append("UC");
		}
		
		return sb.toString();
	}

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










/* end */