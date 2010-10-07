/*
	GenerateXHTMLFactory.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.gen;

import java.io.File;
import java.io.IOException;
import java.net.URI;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import freemarker.template.TemplateException;

import net.markout.gen.EnhancedFactoryGenerator.EmptyPolicy;
import net.markout.types.*;

/**
 * GenerateXHTMLFactory
 * 
 * Comment here.
 */
public class GenerateXHTMLFactory {
	static NamespaceURI XHTML_NS = new NamespaceURI("http://www.w3.org/1999/xhtml", "xhtml");
	static Name HTML_ROOT = XHTML_NS.name("html");
	
	static PublicIDLiteral STRICT_PUBLIC_ID = new PublicIDLiteral("-//W3C//DTD XHTML 1.0 Strict//EN");
	static SystemLiteral STRICT_SYSTEM_ID = new SystemLiteral("http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd");
	static PublicIDLiteral TRANSITIONAL_PUBLIC_ID = new PublicIDLiteral("-//W3C//DTD XHTML 1.0 Transitional//EN");
	static SystemLiteral TRANSITIONAL_SYSTEM_ID = new SystemLiteral("http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd");
	static PublicIDLiteral FRAMESET_PUBLIC_ID = new PublicIDLiteral("-//W3C//DTD XHTML 1.0 Frameset//EN");
	static SystemLiteral FRAMESET_SYSTEM_ID = new SystemLiteral("http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd");

	public static void main(String[] args)
	throws IOException, TemplateException, ParserConfigurationException, SAXException {
		
		DTDEnhancedFactoryGenerator gen = new DTDEnhancedFactoryGenerator(
				XHTML_NS,
				"net.markout.xhtml",
				"XHTML",
				"Html",
				EmptyPolicy.content_model_with_space);
		
		File dtdDir = new File("source/main/java/net/markout/xhtml/");
		URI strictURI = new File(dtdDir, "xhtml1-strict.dtd").toURI();
		URI transitionalURI = new File(dtdDir, "xhtml1-transitional.dtd").toURI();
		URI framesetURI = new File(dtdDir, "xhtml1-frameset.dtd").toURI();
					
		gen.parseDTD("strict", HTML_ROOT, STRICT_PUBLIC_ID, STRICT_SYSTEM_ID, strictURI);

		gen.parseDTD("transitional", HTML_ROOT, TRANSITIONAL_PUBLIC_ID, TRANSITIONAL_SYSTEM_ID, transitionalURI);

		gen.parseDTD("frameset", HTML_ROOT, FRAMESET_PUBLIC_ID, FRAMESET_SYSTEM_ID, framesetURI);
		
		File dir = new File("source/main/java/");
		
		gen.writeTo(dir);
	}
}



