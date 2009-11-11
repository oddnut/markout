/*
	DTDEnhancedFactoryGenerator.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.gen;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URI;
import java.util.StringTokenizer;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DeclHandler;

import net.markout.DocumentWriter;
import net.markout.XML;
import net.markout.types.Name;
import net.markout.types.NamespaceURI;
import net.markout.types.PublicIDLiteral;
import net.markout.types.SystemLiteral;

/**
 * DTDEnhancedFactoryGenerator
 * 
 * Comment here.
 */
public class DTDEnhancedFactoryGenerator extends EnhancedFactoryGenerator {
	// *** Class Members ***

	// *** Instance Members ***

	// *** Constructors ***
	public DTDEnhancedFactoryGenerator(
			NamespaceURI defaultNamespaceURI,
			String packageName,
			String factoryClassName,
			String writerClassPrefix,
			EmptyPolicy emptyPolicy) throws IOException {
		
		super(defaultNamespaceURI, packageName, factoryClassName, writerClassPrefix, emptyPolicy);
	}

	// *** EnhancedFactoryGenerator Methods ***

	// *** Public Methods ***
	
	public void parseDTD(
			String shortName,
			Name root,
			PublicIDLiteral publicID,
			SystemLiteral system) 
	throws IOException, SAXException, ParserConfigurationException {
		
		parseDTD(shortName, root, publicID, system, null);
	}
	
	public void parseDTD(
			String shortName,
			Name root,
			PublicIDLiteral publicID,
			SystemLiteral system,
			URI downloadURI) 
	throws IOException, SAXException, ParserConfigurationException {
		
		addDocTypeInfo(shortName, publicID, system);
		addRoot(root);
		
		// now generate a stub XML file which declares the specified DTD
		StringWriter sw = new StringWriter();
		DocumentWriter doc = XML.documentWriter(sw);
		doc.xmlVersion();
		doc.dtd(root, publicID, system);
		doc.rootElement(root);
		doc.close();
		sw.close();
		
		Handler handler = new Handler();
		XMLReader xmlr = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
		xmlr.setProperty("http://xml.org/sax/properties/declaration-handler", handler);
		
		if (downloadURI != null) {
			
			final String sysID = system.getStringNoQuotes();
			final String uri = downloadURI.toString();
			
			xmlr.setEntityResolver(new EntityResolver() {
				public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
					if (sysID.equals(systemId))
						return new InputSource(uri);
					return null;
				}
			});
		}
		
		xmlr.parse(new InputSource(new StringReader(sw.toString())));
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
	private class Handler implements DeclHandler {

		public void attributeDecl(	String elName, 
									String attName, 
									String type,
									String mode,
									String value) throws SAXException {
			
			NamespaceURI uri = namespace.getDefaultNamespaceURI();
			int colon = attName.indexOf(':');
			if (colon >= 0) {
				String prefix = attName.substring(0, colon);
				attName = attName.substring(colon + 1);
				uri = namespace.findNamespaceURI(new Name(prefix));
				
				if (uri == null) {
					System.out.println("WARNING! Skipped attribute with unknown prefix- " + prefix + ":" + attName);
					return;
				}
			}
			
			Name name = new Name(uri, attName);
			addAttributeName(name);
			
			int i = type.indexOf('(');
			if (i >= 0) {
				String s = type.substring(i+1, type.indexOf(')'));
				StringTokenizer st = new StringTokenizer(s, "|");
				while(st.hasMoreTokens()) {
					String val = st.nextToken();
					addAttribute(name.att(val));
				}
			}
			
			if (value != null)
				addAttribute(name.att(value));
		}

		public void elementDecl(String name, String model) throws SAXException {
			
			NamespaceURI uri = namespace.getDefaultNamespaceURI();
			int colon = name.indexOf(':');
			if (colon >= 0) {
				String prefix = name.substring(0, colon);
				name = name.substring(colon + 1);
				uri = namespace.findNamespaceURI(new Name(prefix));
				
				if (uri == null) {
					System.out.println("WARNING! Skipped element with unknown prefix- " + prefix + ":" + name);
					return;
				}
			}
			
			Name n = new Name(uri, name);
			
			Model m;
			if (model.equals("EMPTY"))
				m = Model.empty;
			else if (model.equals("ANY"))
				m = Model.any;
			else if (model.contains("#PCDATA"))
				m = Model.mixed;
			else
				m = Model.children;
			
			addElement(n, m);
		}

		public void externalEntityDecl(String name, String publicId, String systemId) throws SAXException {
			// do nothing
		}

		public void internalEntityDecl(String name, String value) throws SAXException {
			// do nothing
		}
	}
}
