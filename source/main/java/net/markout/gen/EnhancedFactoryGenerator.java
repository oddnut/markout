/*
	EnhancedFactoryGenerator.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.gen;

import java.io.*;
import java.util.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DeclHandler;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import net.markout.*;
import net.markout.types.*;

/**
 * EnhancedFactoryGenerator
 * 
 * Comment here.
 */
public class EnhancedFactoryGenerator extends JavaSourceGenerator {
	// *** Class Members ***
	public enum Model {empty, any, mixed, children}

	// *** Instance Members ***
	private Name rootElement;
	private List<PublicIDLiteral> publicIDs;
	private List<SystemLiteral> systems;
	private List<String> methodPrefixes;
	private List<String> docs;
	
	private boolean isParsed = false;
	
	private Set<Name> names;
	private Map<Name, Model> elements;
	private Set<Attribute> attributes;
	
	private Configuration config;
	private Template factoryTemplate;
	private Template docTemplate;
	private Template cwTemplate;
	private Template ewTemplate;

	// *** Constructors ***
	public EnhancedFactoryGenerator(
			Name rootElement,
			PublicIDLiteral publicID,
			SystemLiteral systemID) throws IOException {
		this(rootElement, publicID, systemID, null);
	}
	
	public EnhancedFactoryGenerator(
			Name rootElement,
			PublicIDLiteral publicID,
			SystemLiteral systemID,
			String factoryMethodPrefix) throws IOException {
		
		this.rootElement = rootElement;
		
		publicIDs = new ArrayList<PublicIDLiteral>();
		systems = new ArrayList<SystemLiteral>();
		methodPrefixes = new ArrayList<String>();
		
		docs = new ArrayList<String>();
		
		names = new TreeSet<Name>();
		elements = new TreeMap<Name, Model>();
		attributes = new TreeSet<Attribute>();
		
		addDTD(publicID, systemID, factoryMethodPrefix != null ? factoryMethodPrefix : rootElement.toString());
		
		initTemplates();
	}

	// *** Interface Methods ***

	// *** Public Methods ***
	public void addDTD(PublicIDLiteral publicID, SystemLiteral systemID, String factoryMethodPrefix) {
		publicIDs.add(publicID);
		systems.add(systemID);
		methodPrefixes.add(factoryMethodPrefix);
		
		// now generate a stub XML file which declares the specified DTD
		try {
			StringWriter sw = new StringWriter();
			DocumentWriter doc = XML.documentWriter(sw);
			
			doc.xmlVersion();
			doc.dtd(rootElement, publicID, systemID);
			doc.rootElement(rootElement);
			doc.close();
			sw.close();
			
			docs.add(sw.toString());
			
		} catch (IOException ioe) {
			// shouldn't happen, using a StringWriter
			System.out.println("BAD!!!!");
		}
	}
	
	public void parse() throws IOException, SAXException, ParserConfigurationException {
		
		if (isParsed)
			return;
		
		Handler handler = new Handler();
		
		for (String doc : docs) {
			XMLReader xmlr = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
			xmlr.setProperty("http://xml.org/sax/properties/declaration-handler", handler);
			xmlr.parse(new InputSource(new StringReader(doc)));
		}
		
		isParsed = true;
	}
	
	public void writeTo(File sourceRootDir,
						String packageName,
						String factoryClassName,
						boolean generateFactoryClass,
						boolean generateEnhancedWriters) throws IOException, TemplateException {
		// parse only once if it's not happened yet:
		if (!isParsed) {
			try {
				parse();
			} catch (SAXException se) {
				se.printStackTrace();
			} catch (ParserConfigurationException pce) {
				pce.printStackTrace();
			}
		}
		
		String name = capitalizeFirst(asMethodName(rootElement));
		if (factoryClassName == null)
			factoryClassName = name;
		String docWriterClassName = name + "DocumentWriter";
		String contentWriterClassName = name + "ContentWriter";
		String elementWriterClassName = name + "ElementWriter";
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("factoryClassName", factoryClassName);
		model.put("docWriterClassName", docWriterClassName);
		model.put("elementWriterClassName", elementWriterClassName);
		model.put("contentWriterClassName", contentWriterClassName);
		
		model.put("packageName", packageName);
		
		model.put("rootElementName", rootElement);
		
		model.put("names", names);
		model.put("elements", elements.keySet());
		model.put("attributes", attributes);
		model.put("publicIDs", publicIDs);
		model.put("systems", systems);
		model.put("factoryMethodPrefixes", methodPrefixes);
		model.put("generateFactoryClass", new Boolean(generateFactoryClass));
		model.put("generateEnhancedWriters", new Boolean(generateEnhancedWriters));
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
			
			String contentWriterFile = contentWriterClassName + ".java";
			fileOut = new FileOutputStream(new File(dir, contentWriterFile), false);
			out = new OutputStreamWriter(fileOut, "UTF-8");
			cwTemplate.process(model, out);
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

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***
	private void initTemplates() throws IOException {
		config = new Configuration();
		config.setClassForTemplateLoading(this.getClass(), "");
		config.setObjectWrapper(new DefaultObjectWrapper());
		
		factoryTemplate = config.getTemplate("EnhancedFactoryGenerator.ftl", "UTF-8");
		docTemplate = config.getTemplate("EnhancedDocumentWriter.ftl", "UTF-8");
		cwTemplate = config.getTemplate("EnhancedContentWriter.ftl", "UTF-8");
		ewTemplate = config.getTemplate("EnhancedElementWriter.ftl", "UTF-8");
	}

	// *** Private Classes ***
	private class Handler implements DeclHandler {

		public void attributeDecl(	String elName, 
									String attName, 
									String type,
									String mode,
									String value) throws SAXException {
			
			Name name = new Name(attName);
			names.add(name);
			
			int i = type.indexOf('(');
			if (i >= 0) {
				String s = type.substring(i+1, type.indexOf(')'));
				StringTokenizer st = new StringTokenizer(s, "|");
				while(st.hasMoreTokens()) {
					String val = st.nextToken();
					attributes.add(name.att(val));
				}
			}
			
			if (value != null)
				attributes.add(name.att(value));
		}

		public void elementDecl(String name, String model) throws SAXException {
			Name n = new Name(name);
			names.add(n);
			
			Model m;
			if (model.equals("EMPTY"))
				m = Model.empty;
			else if (model.equals("ANY"))
				m = Model.any;
			else if (model.contains("#PCDATA"))
				m = Model.mixed;
			else
				m = Model.children;
			
			elements.put(n, m);
		}

		public void externalEntityDecl(String name, String publicId, String systemId) throws SAXException {
			// do nothing
		}

		public void internalEntityDecl(String name, String value) throws SAXException {
			// do nothing
		}
	}
}
