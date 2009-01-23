/*
	EnhancedDocumentWriterGenerator.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.gen;

import java.io.*;
import java.util.*;

import net.markout.types.Name;

import freemarker.template.*;

/**
 * EnhancedDocumentWriterGenerator
 * 
 * Comment here.
 */
public class EnhancedDocumentWriterGenerator extends JavaSourceGenerator {
	// *** Class Members ***

	// *** Instance Members ***
	String packageName;
	Name rootElementName;
	Set<Name> elementNames;

	// *** Constructors ***
	public EnhancedDocumentWriterGenerator(
			String packageName,
			Name rootElementName,
			Collection<Name> elementNames) {
		
		this.packageName = packageName;
		this.rootElementName = rootElementName;
		this.elementNames = new TreeSet<Name>(elementNames); // should sort alphabetically
	}

	// *** Interface Methods ***

	// *** Public Methods ***
	public void writeTo(File sourceRootDir) throws IOException, TemplateException {
		
		Configuration config = new Configuration();
		config.setClassForTemplateLoading(this.getClass(), "");
		config.setObjectWrapper(new DefaultObjectWrapper());
		
		Template doc_template = config.getTemplate("EnhancedDocumentWriter.ftl", "UTF-8");
		Template cw_template = config.getTemplate("EnhancedContentWriter.ftl", "UTF-8");
		Template ew_template = config.getTemplate("EnhancedElementWriter.ftl", "UTF-8");
		
		String name = capitalizeFirst(asMethodName(rootElementName));
		String docWriterClassName = name + "DocumentWriter";
		String contentWriterClassName = name + "ContentWriter";
		String elementWriterClassName = name + "ElementWriter";
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("docWriterClassName", docWriterClassName);
		model.put("elementWriterClassName", elementWriterClassName);
		model.put("contentWriterClassName", contentWriterClassName);
		model.put("packageName", packageName);
		model.put("rootElementName", rootElementName);
		model.put("elementNames", elementNames);
		model.put("generator", this);
		
		File dir = new File(sourceRootDir, packageName.replaceAll("\\.", "/"));
		dir.mkdirs();
		
		String docWriterFileName = docWriterClassName + ".java";
		FileOutputStream fileOut = new FileOutputStream(new File(dir, docWriterFileName), false);
		Writer out = new OutputStreamWriter(fileOut, "UTF-8");
		doc_template.process(model, out);
		out.close();
		
		String contentWriterFile = contentWriterClassName + ".java";
		fileOut = new FileOutputStream(new File(dir, contentWriterFile), false);
		out = new OutputStreamWriter(fileOut, "UTF-8");
		cw_template.process(model, out);
		out.close();
		
		String elementWriterFileName = elementWriterClassName + ".java";
		fileOut = new FileOutputStream(new File(dir, elementWriterFileName), false);
		out = new OutputStreamWriter(fileOut, "UTF-8");
		ew_template.process(model, out);
		out.close();
	}
	
	//public String asMethodPrefix(Name elementName) {}
	
	//public String asMethodSuffic(Name elementName) {}
	

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}
