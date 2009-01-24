/*
	GenerateXHTMLFactory.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.gen;

import java.io.File;
import java.io.IOException;

import freemarker.template.TemplateException;

import net.markout.types.*;

/**
 * GenerateXHTMLFactory
 * 
 * Comment here.
 */
public class GenerateXHTMLFactory {
	static PublicIDLiteral STRICT_PUBLIC_ID = new PublicIDLiteral("-//W3C//DTD XHTML 1.0 Strict//EN");
	static SystemLiteral STRICT_SYSTEM_ID = new SystemLiteral("http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd");
	static PublicIDLiteral TRANSITIONAL_PUBLIC_ID = new PublicIDLiteral("-//W3C//DTD XHTML 1.0 Transitional//EN");
	static SystemLiteral TRANSITIONAL_SYSTEM_ID = new SystemLiteral("http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd");
	static PublicIDLiteral FRAMESET_PUBLIC_ID = new PublicIDLiteral("-//W3C//DTD XHTML 1.0 Frameset//EN");
	static SystemLiteral FRAMESET_SYSTEM_ID = new SystemLiteral("http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd");

	public static void main(String[] args) throws IOException, TemplateException {
		
		EnhancedFactoryGenerator fgen = 
			new EnhancedFactoryGenerator(new Name("html"), STRICT_PUBLIC_ID, STRICT_SYSTEM_ID, "strict");

		fgen.addDTD(TRANSITIONAL_PUBLIC_ID, TRANSITIONAL_SYSTEM_ID, "transitional");

		fgen.addDTD(FRAMESET_PUBLIC_ID, FRAMESET_SYSTEM_ID, "frameset");
		
		File dir = new File("./source/main/java/");
		
		fgen.writeTo(dir, "net.markout.xhtml", "XHTML", true, true);
	}
}



