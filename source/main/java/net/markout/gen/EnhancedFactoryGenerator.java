/*
	EnhancedFactoryGenerator.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.gen;

import java.io.*;
import java.util.*;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import net.markout.ContentWriter;
import net.markout.support.ContentWriterProxy;
import net.markout.types.*;

/**
 * EnhancedFactoryGenerator
 * 
 * Comment here.
 */
public class EnhancedFactoryGenerator extends JavaSourceGenerator {
	// *** Class Members ***
	public enum Model {empty, any, mixed, children}
	
	public enum EmptyPolicy {
		any, 
		any_with_space, 
		content_model, 
		content_model_with_space, 
		named_elements, 
		named_elements_with_space,
		class_name
	}
	
	private static class ExternalWriter {
		NamespaceURI uri;
		String contentWriterClass;
		String proxyClass;
	}

	// *** Instance Members ***
	
	private String packageName;
	private String factoryClassName;
	private String writerClassPrefix;
	private EmptyPolicy emptyPolicy;
	
	private boolean generateFactoryClass;
	private boolean generateEnhancedWriters;
	
	private Set<Name> roots;
	
	private List<DocType> docTypes;
	
	private Set<Name> names;
	private Map<Name, Model> elements;
	private Set<Attribute> attributes;
	
	private List<ExternalWriter> externalWriters;
	
	private Configuration config;
	private Template factoryTemplate;
	private Template docTemplate;
	private Template docImplTemplate;
	private Template cwTemplate;
	private Template cwProxyTemplate;
	private Template ewTemplate;

	// *** Constructors ***
	
	public EnhancedFactoryGenerator(
			NamespaceURI defaultNamespaceURI,
			String packageName,
			String factoryClassName,
			String writerClassPrefix,
			EmptyPolicy emptyPolicy) throws IOException {
		
		String defaultPrefix = "CHANGE_ME";
		if (defaultNamespaceURI != null) {
			
			namespace.setDefaultNamespaceURI(defaultNamespaceURI);
			
			if (defaultNamespaceURI.getPreferredPrefix() != null)
				defaultPrefix = capitalizeFirst(asMethodName(defaultNamespaceURI.getPreferredPrefix()));
		}
		
		this.packageName = packageName != null ? packageName : defaultPrefix.toLowerCase();
		this.factoryClassName = factoryClassName != null ? factoryClassName : defaultPrefix;
		this.writerClassPrefix = writerClassPrefix != null ? writerClassPrefix : defaultPrefix;
		this.emptyPolicy = emptyPolicy != null ? emptyPolicy : EmptyPolicy.any;
		
		generateFactoryClass = true;
		generateEnhancedWriters = true;
		
		roots = new TreeSet<Name>();
		
		docTypes = new ArrayList<DocType>();
		
		names = new TreeSet<Name>();
		elements = new TreeMap<Name, Model>();
		attributes = new TreeSet<Attribute>();
		
		externalWriters = new ArrayList<ExternalWriter>();
		
		initTemplates();
	}

	// *** Interface Methods ***

	// *** Public Methods ***
	
	public void setGenerateFactoryClass(boolean generateFactoryClass) {this.generateFactoryClass = generateFactoryClass;}
	public void setGenerateEnhancedWriters(boolean generateEnhancedWriters) {this.generateEnhancedWriters = generateEnhancedWriters;}
	
	public void addElement(Name name) {
		addElement(name, Model.any);
	}
	
	public void addElement(Name name, Model model) {
		names.add(name);
		elements.put(name, model);
	}
	
	public void addAttributeName(Name name) {
		names.add(name);
	}
	
	public void addAttribute(Attribute attribute) {
		names.add(attribute.getName());
		attributes.add(attribute);
	}
	
	public void addRoot(Name root) {
		roots.add(root);
	}
	
	public void addDocTypeInfo(String shortName, PublicIDLiteral publicID, SystemLiteral system) {
		DocType dt = new DocType();
		dt.shortName = shortName;
		dt.publicID = publicID;
		dt.system = system;
		
		docTypes.add(dt);
	}
	
	public void addExternalWriter(
			NamespaceURI uri, 
			Class<? extends ContentWriter> writerClass, 
			Class<? extends ContentWriterProxy> proxyClass) {
		
		namespace.namespaceURIPrefix(uri);
		
		ExternalWriter ew = new ExternalWriter();
		ew.uri = uri;
		ew.contentWriterClass = writerClass.getName();
		ew.proxyClass = proxyClass.getName();
		
		externalWriters.add(ew);
	}
	
	public void addExternalWriter(
			NamespaceURI uri, 
			String writerClass, 
			String proxyClass) {
		
		namespace.namespaceURIPrefix(uri);
		
		ExternalWriter ew = new ExternalWriter();
		ew.uri = uri;
		ew.contentWriterClass = writerClass;
		ew.proxyClass = proxyClass;
		
		externalWriters.add(ew);
	}
	
	public void writeTo(File sourceRootDir) throws IOException, TemplateException {
		
		String docWriterClassName = writerClassPrefix + "DocumentWriter";
		String docWriterImplClassName = writerClassPrefix + "DocumentWriterImpl";
		String contentWriterClassName = writerClassPrefix + "ContentWriter";
		String contentWriterProxyClassName = writerClassPrefix + "ContentWriterProxy";
		String elementWriterClassName = writerClassPrefix + "ElementWriter";
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("factoryClassName", factoryClassName);
		model.put("docWriterClassName", docWriterClassName);
		model.put("docWriterImplClassName", docWriterImplClassName);
		model.put("elementWriterClassName", elementWriterClassName);
		model.put("contentWriterClassName", contentWriterClassName);
		model.put("contentWriterProxyClassName", contentWriterProxyClassName);
		model.put("factoryMethodPrefix", writerClassPrefix.toLowerCase());
		
		model.put("packageName", packageName);
		
		model.put("roots", roots);
		
		model.put("namespace", namespace);
		
		model.put("names", names);
		model.put("elements", elements.keySet());
		model.put("attributes", attributes);
		model.put("docTypes", docTypes);
		model.put("generateFactoryClass", new Boolean(generateFactoryClass));
		model.put("generateEnhancedWriters", new Boolean(generateEnhancedWriters));
		model.put("emptyPolicy", emptyPolicy.name());
		model.put("generator", this);
		
		FileOutputStream fileOut;
		Writer out;
		File dir = new File(sourceRootDir, packageName.replaceAll("\\.", "/"));
		dir.mkdirs();
		
		if (generateFactoryClass) {
			String fileName = factoryClassName + ".java";
			fileOut = new FileOutputStream(new File(dir, fileName), false);
			out = new OutputStreamWriter(fileOut, "UTF-8");
			factoryTemplate.process(model, out);
			out.close();
		}
		
		if (generateEnhancedWriters) {
			String docWriterFileName = docWriterClassName + ".java";
			fileOut = new FileOutputStream(new File(dir, docWriterFileName), false);
			out = new OutputStreamWriter(fileOut, "UTF-8");
			docTemplate.process(model, out);
			out.close();
			
			String docWriterImplFileName = docWriterImplClassName + ".java";
			fileOut = new FileOutputStream(new File(dir, docWriterImplFileName), false);
			out = new OutputStreamWriter(fileOut, "UTF-8");
			docImplTemplate.process(model, out);
			out.close();
			
			String contentWriterFile = contentWriterClassName + ".java";
			fileOut = new FileOutputStream(new File(dir, contentWriterFile), false);
			out = new OutputStreamWriter(fileOut, "UTF-8");
			cwTemplate.process(model, out);
			out.close();
			
			String contentWriterProxyFile = contentWriterProxyClassName + ".java";
			fileOut = new FileOutputStream(new File(dir, contentWriterProxyFile), false);
			out = new OutputStreamWriter(fileOut, "UTF-8");
			cwProxyTemplate.process(model, out);
			out.close();
			
			String elementWriterFileName = elementWriterClassName + ".java";
			fileOut = new FileOutputStream(new File(dir, elementWriterFileName), false);
			out = new OutputStreamWriter(fileOut, "UTF-8");
			ewTemplate.process(model, out);
			out.close();
		}
	}
	
	public Model getElementModel(Name elementName) {
		return elements.get(elementName);
	}
	
	public String[] getExternalContentWriterClasses() {
		String[] result = new String[externalWriters.size()];
		
		for (int i = 0 ; i < result.length ; i++)
			result[i] = externalWriters.get(i).contentWriterClass;
		
		return result;
	}
	
	public String getExternalContentWriterClass(NamespaceURI uri) {
		
		if (namespace.isDefaultNamespaceURI(uri))
			return writerClassPrefix + "ContentWriter"; // TODO this shouldn't be repeated here.  change naming strategy?
		
		for (ExternalWriter ew : externalWriters) {
			if (ew.uri.equals(uri)) {
				if (ew.contentWriterClass.indexOf('.') < 0)
					return ew.contentWriterClass;
				else
					return ew.contentWriterClass.substring(ew.contentWriterClass.lastIndexOf('.') + 1);
			}
		}
		
		//return ContentWriter.class.getSimpleName();
		throw new IllegalArgumentException("No External Writer registered for " + uri);
	}
	
	public String[] getExternalProxyClasses() {
		String[] result = new String[externalWriters.size()];
		
		for (int i = 0 ; i < result.length ; i++)
			result[i] = externalWriters.get(i).proxyClass;
		
		return result;
	}
	
	public NamespaceURI[] getExternalNamespaceURIs() {
		NamespaceURI[] result = new NamespaceURI[externalWriters.size()];
		
		for (int i = 0 ; i < result.length ; i++)
			result[i] = externalWriters.get(i).uri;
		
		return result;
	}
	
	public String getExternalProxyClass(NamespaceURI uri) {
		
		for (ExternalWriter ew : externalWriters) {
			if (ew.uri.equals(uri)) {
				if (ew.proxyClass.indexOf('.') < 0)
					return ew.proxyClass;
				else
					return ew.proxyClass.substring(ew.proxyClass.lastIndexOf('.') + 1);
			}
		}
		
		throw new IllegalArgumentException("No External Writer registered for " + uri);
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***
	private void initTemplates() throws IOException {
		config = new Configuration();
		config.setClassForTemplateLoading(this.getClass(), "");
		config.setObjectWrapper(new DefaultObjectWrapper());
		
		factoryTemplate = config.getTemplate("EnhancedFactoryGenerator.ftl", "UTF-8");
		docTemplate = config.getTemplate("EnhancedDocumentWriter.ftl", "UTF-8");
		docImplTemplate = config.getTemplate("EnhancedDocumentWriterImpl.ftl", "UTF-8");
		cwTemplate = config.getTemplate("EnhancedContentWriter.ftl", "UTF-8");
		cwProxyTemplate = config.getTemplate("EnhancedContentWriterProxy.ftl", "UTF-8");
		ewTemplate = config.getTemplate("EnhancedElementWriter.ftl", "UTF-8");
	}

	// *** Private Classes ***
	
	public class DocType {
		
		public String shortName;
		public PublicIDLiteral publicID;
		public SystemLiteral system;
		
		public String getShortName() {return shortName;}
		public PublicIDLiteral getPublicID() {return publicID;}
		public SystemLiteral getSystem() {return system;}
	}
	
}
