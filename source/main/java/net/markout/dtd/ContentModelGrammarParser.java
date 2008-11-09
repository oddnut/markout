/*
	ContentModelGrammarParser.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.dtd;

// *** imports ***

import java.io.StringWriter;
import java.util.*;

import net.markout.IllegalXMLCharacterException;
import net.markout.types.Name;
import net.markout.types.XMLChar;

/**
 * ContentModelGrammarParser
 *
 * Comment here.  Author: David Fogel
 */
public class ContentModelGrammarParser {
	// *** Class Members ***

	// *** Instance Members ***
	
	private Map theParsedGrammars;

	// *** Constructors ***
	
	public ContentModelGrammarParser() {
		theParsedGrammars = new HashMap();
	}

	// *** Interface Methods ***

	// *** Public Methods ***
	
	public ContentModel parseGrammar(String grammer) {
		
		if (grammer == null || grammer.indexOf('(') < 0)
			throw new IllegalArgumentException("grammer string value is malformed.");
		
		return parseGrammarImpl(normalize(grammer));
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***
	
	private ContentModel parseGrammarImpl(String grammer) {
		
		ContentModel result = (ContentModel) theParsedGrammars.get(grammer);
		
		if (result != null) {
			//System.out.println("Returning previously parsed grammer:\n" + grammer + " ==>\n" + result);
			return result;
		}
		
		int length = grammer.length();
		char last = grammer.charAt(length - 1);
		
		if (last == '?' || last == '*' || last == '+') {
			
			ContentModel m = parseGrammarImpl(grammer.substring(0, length - 1));
			
			result = new RecurrenceContentModel(last, m);
			
		} else if (grammer.charAt(0) == '(') {
			
			List children = new ArrayList();
			
			int level = -1;// the first '(' will bump this to 0
			char sep = 0;
			int start = 1; // after the initial '('
			for (int i = 0 ; i < length ; i++) {
				char c = grammer.charAt(i);
				switch(c) {
					case '(' :
						level++;
						break;
						
					case ')' :
						if (level == 0)
							children.add(parseGrammarImpl(grammer.substring(start, i))); // and we're done.
						level--;
						break;
						
					case ',' : 
						if (level == 0) {
							if (sep == 0) sep = ',';
							children.add(parseGrammarImpl(grammer.substring(start, i)));
							start = i + 1;
						}
						break;
						
					case '|' :
						if (level == 0) {
							if (sep == 0) sep = '|';
							children.add(parseGrammarImpl(grammer.substring(start, i)));
							start = i + 1;
						}
						break;
						
					default:
						break;
				}
			}
			
			if (children.size() == 1)
				result = (ContentModel) children.get(0); // don't need either, I think
			
			else if (sep == ',')
				result = new SequenceContentModel(children);
			
			else
			 	result = new ChoiceContentModel(children);
			
		} else {
			
			result = new NameContentModel(new Name(grammer));
		}
		
		theParsedGrammars.put(grammer, result);
		
		//System.out.println("Adding new parsed grammer:\n" + grammer + " ==>\n" + result);
		
		return result;
	}
	
	private String normalize(String grammer) {
		
		int parensCount = 0;
		boolean inName = false;
		
		StringWriter sw = new StringWriter();
		
		int length = grammer.length();
		for (int i = 0 ; i < length ; i++) {
			char c = grammer.charAt(i);
			
			switch (c) {
				case '(' :
					parensCount++;
					inName = false;
					sw.write(c);
					break;
				
				case ')' :
					parensCount--;
					inName = false;
					sw.write(c);
					break;
				
				case ',' :
				case '|' :
				case '?' :
				case '*' :
				case '+' :
					inName = false;
					sw.write(c);
					break;
					
				default :
					if ( ! XMLChar.isWhiteSpaceChar(c)) {
						if (inName) {
							
							if (XMLChar.isNameChar(c))
								sw.write(c);
							else
								throw new IllegalXMLCharacterException(c);
							
						} else {
							
							if (XMLChar.isNameStartChar(c)) {
								inName = true;
								sw.write(c);
							} else
								throw new IllegalXMLCharacterException(c);
						}
					}
					// else it's whitespace, ignore it.
			}
		}
		
		if (parensCount != 0)
			throw new IllegalArgumentException("Malformed Grammer string.");
		
		return sw.toString();
	}

	// *** Private Classes ***
}










/* end */