/*
	SAXDTDGenerator.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.support;

// *** imports ***

import java.io.IOException;
import java.io.Writer;
import java.util.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.*;
import org.xml.sax.ext.DeclHandler;
import org.xml.sax.ext.LexicalHandler;

/**
 * SAXDTDGenerator
 *
 * Comment here.  Author: David Fogel
 */
public class SAXDTDGenerator implements DTDHandler, DeclHandler, LexicalHandler {
	// *** Class Members ***

	// *** Instance Members ***
	
	private Map theNotations;
	private Map theUnparsed;
	private Map theParamEntities;
	private Map theGeneralEntities;
	private Map theElements;
	private Map theUniqueAttributes;
	private Set theAttributeVariables;
	private String theRootElement;
	private String thePublicID;
	private String theSystemID;
	
	private String theDTDMethodTarget;
	private String theGrammarMethodTarget;
	private String theNewElementNamePrefix;
	private String theNewAttributeNamePrefix;
	private String theNewAttributeValuePrefix;

	// *** Constructors ***
	
	public SAXDTDGenerator() {
		this(null, null, null, null, null);
	}
	
	public SAXDTDGenerator(	String dtdMethodTarget,
							String grammarMethodTarget,
							String newElementNamePrefix,
							String newAttributeNamePrefix,
							String newAttributeValuePrefix) {
		theNotations = new HashMap();
		theUnparsed = new HashMap();
		theParamEntities = new HashMap();
		theGeneralEntities = new HashMap();
		theElements = new HashMap();
		theUniqueAttributes = new HashMap();
		theAttributeVariables = new HashSet();
		theRootElement = null;
		thePublicID = null;
		theSystemID = null;
		
		theDTDMethodTarget = dtdMethodTarget;
		theGrammarMethodTarget = grammarMethodTarget;
		theNewElementNamePrefix = newElementNamePrefix;
		theNewAttributeNamePrefix = newAttributeNamePrefix;
		theNewAttributeValuePrefix = newAttributeValuePrefix;
	}

	// *** DTDHandler Methods ***
	
	public void notationDecl (String name, String publicId, String systemId) throws SAXException {
		
		theNotations.put(name, new String[] {publicId, systemId});
	}
	
	public void unparsedEntityDecl (String name, String publicId, 
			String systemId, String notationName) throws SAXException {
		
		theUnparsed.put(name, new String[] {publicId, systemId, notationName});
	}
	
	// *** DeclHandler Methods ***
	
	public void elementDecl (String name, String model) throws SAXException {
		if (theElements.containsKey(name))
			throw new IllegalArgumentException("duplicate element declarations");
		theElements.put(name, new Object[] {model, new HashSet()});
	}
	
	public void attributeDecl (	String eName,
								String aName,
								String type,
								String valueDefault,
								String value) throws SAXException {
		
		Object[] el = (Object[]) theElements.get(eName);
		
		if (el == null)
			throw new IllegalArgumentException("Attribute declaration before relevant element declaration");
		
		Set atts = (Set) el[1];
		
		AttDefInfo info = new AttDefInfo(aName, type, valueDefault, value);
		
		if (atts.contains(info))
			throw new IllegalArgumentException("duplicate Attribute declaration for same element");
		
		atts.add(info);
		if ( ! theUniqueAttributes.containsKey(info))
			theUniqueAttributes.put(info, uniqueVariable(info));
	}
	
	private String uniqueVariable(AttDefInfo info) {
		
		String clean = clean(info.name);
		
		String result = "a_" + clean;
		if (! theAttributeVariables.contains(result)) {
			theAttributeVariables.add(result);
			return result;
		}
		
		for (int i = 2 ; true ; i++) {
			result = "a_" + clean + i;
			if ( ! theAttributeVariables.contains(result)) {
				theAttributeVariables.add(result);
				return result;
			}
		}
	}
	
	private String clean(String name) {
		StringBuffer sb = new StringBuffer();
		
		int length = name.length();
		for (int i = 0 ; i < length ; i++) {
			char c = name.charAt(i);
			if (Character.isLetterOrDigit(c))
				sb.append(c);
			else
				sb.append('_');
		}
		
		return sb.toString();
	}
	
	public void internalEntityDecl (String name, String value) throws SAXException {
		
		if (name.startsWith("%"))
			theParamEntities.put(name.substring(1), value);
		else
			theGeneralEntities.put(name, value);
	}
	
	public void externalEntityDecl (String name, String publicId, String systemId)
	throws SAXException {
		
		if (name.startsWith("%"))
			theParamEntities.put(name.substring(1), new String[] {publicId, systemId});
		else
			theGeneralEntities.put(name, new String[] {publicId, systemId});
	}
	
	// *** LexicalHandler Methods ***
	
	public void startDTD (String name, String publicId, String systemId) throws SAXException {
		theRootElement = name;
		thePublicID = publicId;
		theSystemID = systemId;
	}
	
	public void endDTD () throws SAXException {}
	
	public void startEntity (String name) throws SAXException {}
	
	public void endEntity (String name) throws SAXException {}
	
	public void startCDATA () throws SAXException {}
	
	public void endCDATA () throws SAXException {}
	
	public void comment (char ch[], int start, int length) throws SAXException {}

	// *** Public Methods ***
	
	public void parse(InputSource xmlIn) throws SAXException, ParserConfigurationException, IOException {
		XMLReader xmlr = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
		//xmlr.setContentHandler(this);
		//xmlr.setErrorHandler(this);
		xmlr.setProperty("http://xml.org/sax/properties/lexical-handler", this);
		xmlr.setDTDHandler(this);
		xmlr.setProperty("http://xml.org/sax/properties/declaration-handler", this);
		xmlr.parse(xmlIn);
	}
	
	public void writeTo(Writer out) throws IOException{
		
		ArrayList names = new ArrayList();
		
		/*out.write("\n\nStandardDTD dtd = new StandardDTD(");
		out.write(theRootElement);
		out.write(", null);");*/
		
		out.write("\n\n");
		
		// notations:
		names.clear();
		names.addAll(theNotations.keySet());
		Collections.sort(names);
		Iterator i = names.iterator();
		while(i.hasNext()) {
			String name = (String) i.next();
			String[] vals = (String[]) theNotations.get(name);
			if (theDTDMethodTarget != null) {
				out.write(theDTDMethodTarget);
				out.write(".");
			}
			out.write("addNotation(new Notation(");
			writeNewName(out, name);
			out.write(", ");
			writeNewTypeOrNull(out, "PublicIDLiteral", vals[0]);
			out.write(", ");
			writeNewTypeOrNull(out, "SysteLiteral", vals[1]);
			out.write(");\n");
		}
		
		out.write("\n\n");
		
		// unparsed entities:
		names.clear();
		names.addAll(theUnparsed.keySet());
		Collections.sort(names);
		i = names.iterator();
		while(i.hasNext()) {
			String name = (String) i.next();
			String[] vals = (String[]) theUnparsed.get(name);
			if (theDTDMethodTarget != null) {
				out.write(theDTDMethodTarget);
				out.write(".");
			}
			out.write("addUnparsedEntity(new UnparsedEntity(");
			writeNewName(out, name);
			out.write(", ");
			writeNewTypeOrNull(out, "PublicIDLiteral", vals[0]);
			out.write(", ");
			writeNewTypeOrNull(out, "SysteLiteral", vals[1]);
			out.write(", ");
			writeNewTypeOrNull(out, "Name", vals[2]);
			out.write(");\n");
		}
		
		out.write("\n\n");
		
		// parameter entities:
		names.clear();
		names.addAll(theParamEntities.keySet());
		Collections.sort(names);
		i = names.iterator();
		while(i.hasNext()) {
			String name = (String) i.next();
			
			if (theDTDMethodTarget != null) {
				out.write(theDTDMethodTarget);
				out.write(".");
			}
			out.write("addParameterEntity(");
			
			Object o = theParamEntities.get(name);
			if (o instanceof String)
				writeNewInternalEntity(out, name, (String) o);
			else
				writeNewExternalEntity(out, name, (String[]) o);
			
			out.write(");\n");
		}
		
		out.write("\n\n");
		
		// general entities:
		names.clear();
		names.addAll(theGeneralEntities.keySet());
		Collections.sort(names);
		i = names.iterator();
		while(i.hasNext()) {
			String name = (String) i.next();
			
			if (theDTDMethodTarget != null) {
				out.write(theDTDMethodTarget);
				out.write(".");
			}
			out.write("addGeneralEntity(");
			
			Object o = theGeneralEntities.get(name);
			if (o instanceof String)
				writeNewInternalEntity(out, name, (String) o);
			else
				writeNewExternalEntity(out, name, (String[]) o);
			
			out.write(");\n");
		}
		
		out.write("\n\n");
		
		// Element Names 
		
		names.clear();
		names.addAll(theElements.keySet());
		Collections.sort(names);
		i = names.iterator();
		while(i.hasNext()) {
			String name = (String) i.next();
			
			out.write("Name ");
			out.write(name);
			out.write(" = ");
			writeNewElName(out, name);
			out.write(";\n");
		}
		
		out.write("\n\n");
		
		// Attribute Defs
		
		List uniqueAtts = new ArrayList(theUniqueAttributes.keySet());
		Collections.sort(uniqueAtts);
		i = uniqueAtts.iterator();
		while(i.hasNext()) {
			AttDefInfo info = (AttDefInfo) i.next();
			String variable = (String) theUniqueAttributes.get(info);
			
			out.write("AttributeDef ");
			out.write(variable);
			out.write(" = ");
			writeNewAttributeDef(out, info);
			out.write(";\n");
		}
		
		out.write("\n\n");
		
		// Elements
		
		i = names.iterator();
		while(i.hasNext()) {
			String name = (String) i.next();
			Object[] vals = (Object[]) theElements.get(name);
			String model = (String) vals[0];
			List atts = new ArrayList((Set) vals[1]);
			Collections.sort(atts);
			
			if (theDTDMethodTarget != null) {
				out.write(theDTDMethodTarget);
				out.write(".");
			}
			out.write("addElementType(new ElementType( ");
			
			out.write(name);
			out.write(",\n\t");
			
			if ("ANY".equals(model)) {
				out.write("ContentModel.ANY");
			} else if ("EMPTY".equals(model)) {
				out.write("ContentModel.EMPTY");
			} else if (model.indexOf("#PCDATA") >= 0) {
				out.write("new MixedContentModel(Arrays.asList(new Name[] {\n\t\t");
				List allowed = parseEnumVals(model);
				Iterator ai = allowed.iterator();
				int count = 1;
				while(ai.hasNext()) {
					String a = (String) ai.next();
					if ("#PCDATA".equals(a))
						continue;
					out.write(a);
					if (ai.hasNext()) {
						if (count % 10 == 0)
							out.write(",\n\t\t");
						else
							out.write(", ");
						count++;
					}
				}
				out.write("}))");
			} else {
				if (theGrammarMethodTarget != null) {
					out.write(theGrammarMethodTarget);
					out.write(".");
				}
				out.write("parseGrammar(\n\t\t\"");
				out.write(model);
				out.write("\")");
			}
			out.write(",\n\t");
			
			out.write("Arrays.asList(new AttributeDef[] {\n\t\t");
			Iterator ai = atts.iterator();
			int count = 1;
			while(ai.hasNext()) {
				AttDefInfo info = (AttDefInfo) ai.next();
				String variable = (String) theUniqueAttributes.get(info);
				out.write(variable);
				if (ai.hasNext()) {
					if (count % 7 == 0)
						out.write(",\n\t\t");
					else
						out.write(", ");
					count++;
				}
			}
			out.write("})");
			
			out.write(", null");
			
			out.write("));\n\n");
		}
		
		out.write("\n\n");
		
		out.close();
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***
	
	private void writeNewAttributeDef(Writer out, AttDefInfo info) throws IOException {
		out.write("new AttributeDef(");
		writeNewAttName(out, info.name);
		out.write(", ");
		
		if (info.type.indexOf("(") >= 0 || 
			Character.isLowerCase(info.type.charAt(0))) { // bug in sax parser?
			
			List vals;
			if (info.type.startsWith("NOTATION")) {
				out.write("AttributeDef.NOTATION_TYPE,\n\t\t");
				vals = parseEnumVals(info.type.substring(8));
			} else {
				out.write("AttributeDef.ENUMERATION_TYPE,\n\t\t");
				vals = parseEnumVals(info.type);
			}
			out.write("Arrays.asList(new AttValue[] {\n\t\t");
			Iterator i = vals.iterator();
			int count = 1;
			while(i.hasNext()) {
				String v = (String) i.next();
				writeNewAttValue(out, v);
				if (i.hasNext()) {
					if (count % 4 == 0)
						out.write(",\n\t\t");
					else
						out.write(", ");
					count++;
				}
			}
			out.write("})");
		} else {
		
			out.write("AttributeDef.");
			out.write(info.type);
			out.write("_TYPE");
		}
		
		out.write(", ");
		
		if (info.value != null) {
			writeNewAttValue(out, info.value);
			out.write(", ");
			if ("#FIXED".equals(info.valueDefault))
				out.write("true");
			else
				out.write("false");
		} else {
			if ("#REQUIRED".equals(info.valueDefault))
				out.write("true");
			else
				out.write("false");
		}
		
		out.write(")");
	}
	
	private List parseEnumVals(String s) {
		List result = new ArrayList();
		StringTokenizer st = new StringTokenizer(s, "(|) ");
		while(st.hasMoreTokens())
			result.add(st.nextToken());
		return result;
	}
	
	private void writeNewInternalEntity(Writer out, String name, String value) throws IOException {
		out.write("new InternalEntity(");
		writeNewName(out, name);
		out.write(", ");
		writeNewTypeOrNull(out, "EntityValue", value);
		out.write(")");
	}
	
	private void writeNewExternalEntity(Writer out, String name, String[] vals) throws IOException {
		out.write("new ExternalEntity(");
		writeNewName(out, name);
		out.write(", ");
		writeNewTypeOrNull(out, "PublicIDLiteral", vals[0]);
		out.write(", ");
		writeNewTypeOrNull(out, "SystemLiteral", vals[1]);
		out.write(")");
	}
	
	private void writeNewName(Writer out, String param) throws IOException {
		out.write("new Name(\"");
		out.write(param);
		out.write("\")");
	}
	
	private void writeNewElName(Writer out, String param) throws IOException {
		if (theNewElementNamePrefix != null)
			out.write(theNewElementNamePrefix);
		else
			out.write("new Name");
		out.write("(\"");
		out.write(param);
		out.write("\")");
	}
	
	private void writeNewAttName(Writer out, String param) throws IOException {
		if (theNewAttributeNamePrefix != null)
			out.write(theNewAttributeNamePrefix);
		else
			out.write("new Name");
		out.write("(\"");
		out.write(param);
		out.write("\")");
	}
	
	private void writeNewAttValue(Writer out, String val) throws IOException {
		if (theNewAttributeValuePrefix != null)
			out.write(theNewAttributeValuePrefix);
		else
			out.write("new AttValue");
		out.write("(\"");
		out.write(val);
		out.write("\")");
	}
	
	private void writeNewTypeOrNull(Writer out, String className, String param) throws IOException {
		if (param == null)
			out.write("null");
		else {
			out.write("new ");
			out.write(className);
			out.write("(\"");
			out.write(param);
			out.write("\")");
		}
	}

	// *** Private Classes ***
	
	private class AttDefInfo implements Comparable{
		
		String name;
		String type;
		String valueDefault;
		String value;
		
		public AttDefInfo(String name, String type, String valueDefault, String value) {
			this.name = name;
			this.type = type;
			this.valueDefault = valueDefault;
			this.value = value;
		}
		
		public int compareTo(Object o) {
			AttDefInfo a = (AttDefInfo) o;
			int result = name.compareTo(a.name);
			if (result != 0)
				return result;
			result = compareStringsSafe(type, a.type);
			if (result != 0)
				return result;
			result = compareStringsSafe(valueDefault, a.valueDefault);
			if (result != 0)
				return result;
			return compareStringsSafe(value, a.value);
		}
		
		private final int compareStringsSafe(String s1, String s2) {
			if (s1 == null)
				return s2 == null ? 0 : -1;
			if (s2 == null)
				return 1;
			return s1.compareTo(s2);
		}
		
		public int hashCode() {
			int result = name.hashCode();
			if ( type != null)
				result ^= type.hashCode();
			if ( valueDefault != null)
				result ^= valueDefault.hashCode();
			if ( value != null)
				result ^= value.hashCode();
			return result;
		}
		
		public boolean equals(Object o) {
			if ( o == null || ! (o instanceof AttDefInfo))
				return false;
			AttDefInfo a = (AttDefInfo) o;
			return equalOrNull(name, a.name) &&
					equalOrNull(type, a.type) &&
					equalOrNull(valueDefault, a.valueDefault) &&
					equalOrNull(value, a.value);
		}
		
		private final boolean equalOrNull(String s1, String s2) {
			if (s1 == null) return s2 == null;
			return s1.equals(s2);
		}
	}
}










/* end */