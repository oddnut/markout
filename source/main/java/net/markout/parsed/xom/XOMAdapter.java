/*
	XOMAdapter.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.parsed.xom;

import java.io.IOException;
import java.util.Collection;

import net.markout.ContentWriter;
import net.markout.parsed.EmptyElementPolicy;
import net.markout.types.Attribute;
import net.markout.types.Instruction;
import net.markout.types.Name;
import net.markout.types.NamespaceURI;
import net.markout.types.Target;
import nu.xom.Comment;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Node;
import nu.xom.Nodes;
import nu.xom.ProcessingInstruction;
import nu.xom.Text;

/**
 * XOMAdapter
 * 
 * Comment here.
 */
public class XOMAdapter {
	// *** Class Members ***
	
	public static EmptyElementPolicy DEFAULT_EMPTY_ELEMENT_POLICY = new EmptyElementPolicy() {
		public boolean isRenderedAsEmptyElement(Name elementName) {
			return true;
		}
	};
	
	public static void writeTo(ContentWriter out, Document doc) throws IOException {
		writeElementTo(out, doc.getRootElement(), DEFAULT_EMPTY_ELEMENT_POLICY);
	}
	
	public static void writeTo(ContentWriter out, Document doc, EmptyElementPolicy emptyPolicy) throws IOException {
		writeElementTo(out, doc.getRootElement(), emptyPolicy);
	}
	
	public static void writeTo(ContentWriter out, Nodes nodes) throws IOException {
		writeTo(out, nodes, DEFAULT_EMPTY_ELEMENT_POLICY);
	}
	
	public static void writeTo(ContentWriter out, Nodes nodes, EmptyElementPolicy emptyPolicy) throws IOException {
		int size = nodes.size();
		for (int i = 0 ; i < size ; i++) {
			writeTo(out, nodes.get(i));
		}
	}
	
	public static void writeTo(ContentWriter out, Node node) throws IOException {
		writeTo(out, node, DEFAULT_EMPTY_ELEMENT_POLICY);
	}
	
	public static void writeTo(ContentWriter out, Node node, EmptyElementPolicy emptyPolicy) throws IOException {
		
		if (node instanceof Element)
			writeElementTo(out, (Element) node, emptyPolicy);
		else if (node instanceof Text)
			writeTextTo(out, (Text) node);
		else if (node instanceof Comment)
			writeCommentTo(out, (Comment) node);
		else if (node instanceof ProcessingInstruction)
			writePITo(out, (ProcessingInstruction) node);
		else if (node instanceof Document)
			writeElementTo(out, ((Document) node).getRootElement(), emptyPolicy);
		else
			throw new UnsupportedOperationException("Unsupported Node subclass: " + 
					node.getClass().getCanonicalName());
	}
	
	public static void writeElementTo(ContentWriter out, Element e) throws IOException {
		writeElementTo(out, e, DEFAULT_EMPTY_ELEMENT_POLICY);
	}
	
	public static void writeElementTo(ContentWriter out, Element e, EmptyElementPolicy emptyPolicy) throws IOException {
		
		Name name = null;
		
		if (e instanceof MElement) {
			
			MElement me = (MElement) e;
			Collection<NamespaceURI> nss = me.getMarkoutNamespaces();
			if (nss != null) {
				for (NamespaceURI ns : nss)
					out.namespace(ns);
			}
			
			name = me.getName();
			
		} else {
			
			int nscount = e.getNamespaceDeclarationCount();
			if (nscount > 1) {// I guess the first one in XOM is always the element's own?
				for (int i = 1 ; i < nscount ; i++) {
					String prefix = e.getNamespacePrefix(i);
					String uri = e.getNamespaceURI(prefix);
					out.namespace(new NamespaceURI(uri, "".equals(prefix) ? null : prefix));
				}
			}
			
			name = MElement.createMarkoutName(e);
		}
		
		Attribute[] atts = null;
		int attCount = e.getAttributeCount();
		if (attCount > 0) {
			
			atts = new Attribute[attCount];
			
			for (int i = 0 ; i < attCount ; i++) {
				nu.xom.Attribute xa = e.getAttribute(i);
				if (xa instanceof MAttribute)
					atts[i] = ((MAttribute) xa).getAttribute();
				else
					atts[i] = MAttribute.createMarkoutAttribute(xa);
			}
		}
		
		int childCount = e.getChildCount();
		// here's where we make sure to render elements as "empty elements"
		// only if they are allowed according to an EmptyElementPolicy
		// e.g. <img /> versus <img></img>
		if (childCount == 0 && emptyPolicy.isRenderedAsEmptyElement(name)) {
			
			if (atts == null)
				out.emptyElement(name);
			else
				out.emptyElement(name, atts);
			
		} else {
			ContentWriter cw = null;
			
			if (atts == null)
				cw = out.element(name);
			else
				cw = out.element(name, atts);
			
			for (int i = 0 ; i < childCount ; i++) {
				
				writeTo(cw, e.getChild(i), emptyPolicy);
			}
		}
	}
	
	public static void writeTextTo(ContentWriter out, Text t) throws IOException {

		if (t instanceof MText) {
			
			MText mt = (MText) t;
			out.text(mt.getMarkoutText());
			
		} else {
			
			out.text(t.getValue());
		}
	}
	
	public static void writeCommentTo(ContentWriter out, Comment c) throws IOException {
		
		if (c instanceof MComment) {
			
			MComment mc = (MComment) c;
			out.comment(mc.getComment());
			
		} else {
			
			out.comment(new net.markout.types.Comment(c.getValue()));
		}
	}
	
	public static void writePITo(ContentWriter out, ProcessingInstruction pi) throws IOException {
		
		if (pi instanceof MProcessingInstruction) {
			
			MProcessingInstruction mpi = (MProcessingInstruction) pi;
			out.pi(mpi.getMarkoutTarget(), mpi.getMarkoutInstruction());
			
		} else {
			
			out.pi(new Target(pi.getTarget()), new Instruction(pi.getValue()));
		}
	}

	// *** Instance Members ***

	// *** Constructors ***

	// *** Interface Methods ***

	// *** Public Methods ***

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}
