/*
	XHTML.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.xhtml;

// *** imports ***

import java.io.*;

import net.markout.DocumentWriter;
import net.markout.XML;
import net.markout.dtd.DTD;
import net.markout.types.*;

/**
 * XHTML
 *
 * Comment here.  Author: David Fogel
 */
public class XHTML extends XHTMLElementConstants{
	// *** Class Members ***
	
	public static final class ATT extends XHTMLAttributeConstants {}
	public static final class VAL extends XHTMLAttValueConstants {}
	public static final class ENT extends XHTMLEntityConstants {}
	
	public static DTD SHARED_ENTITIES_DTD = new SharedEntitiesDTD();
	
	public static DTD FRAMESET_DTD = new FramesetDTD(SHARED_ENTITIES_DTD);
	
	public static DTD TRANSITIONAL_DTD = new TransitionalDTD(SHARED_ENTITIES_DTD);
	
	public static DTD STRICT_DTD = new StrictDTD(SHARED_ENTITIES_DTD);
	
	public static final PublicIDLiteral STRICT_PUBLIC_ID = 
		new PublicIDLiteral("-//W3C//DTD XHTML 1.0 Strict//EN");
	public static final SystemLiteral STRICT_SYSTEM_ID = 
		new SystemLiteral("http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd");
	
	public static final PublicIDLiteral TRANSITIONAL_PUBLIC_ID = 
		new PublicIDLiteral("-//W3C//DTD XHTML 1.0 Transitional//EN");
	public static final SystemLiteral TRANSITIONAL_SYSTEM_ID = 
		new SystemLiteral("http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd");
	
	public static final PublicIDLiteral FRAMESET_PUBLIC_ID = 
		new PublicIDLiteral("-//W3C//DTD XHTML 1.0 Frameset//EN");
	public static final SystemLiteral FRAMESET_SYSTEM_ID = 
		new SystemLiteral("http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd");
	
	// *** Instance Members ***
	
	// *** Constructors ***
	
	// *** Public Class Methods ***
	
	public static Name attributeNameFor(String name) {
		return XHTMLAttributeConstants.attributeNameFor(name);
	}
	
	public static AttValue attributeValueFor(String val) {
		return XHTMLAttValueConstants.attributeValueFor(val);
	}
	
	public static DocumentWriter strictDocumentWriter(
			boolean declareVersion, 
			boolean declareDTD,
			boolean validate,
			Writer dest) throws IOException {
		
		DocumentWriter dw;
		
		if (validate)
			dw = XML.documentWriter(dest, STRICT_DTD);
		else
			dw  = XML.documentWriter(dest);
		
		if (declareVersion)
			dw.xmlVersion();
		
		if (declareDTD)
			dw.dtd(HTML, STRICT_PUBLIC_ID, STRICT_SYSTEM_ID);
		
		return dw;
	}
	
	public static DocumentWriter strictDocumentWriter(
			boolean declareVersion, 
			boolean declareDTD,
			boolean validate,
			OutputStream dest) throws IOException {
		return strictDocumentWriter(declareVersion, declareDTD, validate, dest, "UTF-8");
	}
	
	public static DocumentWriter strictDocumentWriter(
			boolean declareVersion, 
			boolean declareDTD,
			boolean validate,
			OutputStream dest,
			String charset) throws IOException {
		
		DocumentWriter dw;
		
		if (validate)
			dw = XML.documentWriter(dest, charset, STRICT_DTD);
		else
			dw  = XML.documentWriter(dest, charset);
		
		if (declareVersion)
			dw.xmlVersion();
		
		if (declareDTD)
			dw.dtd(HTML, STRICT_PUBLIC_ID, STRICT_SYSTEM_ID);
		
		return dw;
	}
	
	public static DocumentWriter transitionalDocumentWriter(
			boolean declareVersion, 
			boolean declareDTD,
			boolean validate,
			Writer dest) throws IOException {
		
		DocumentWriter dw;
		
		if (validate)
			dw = XML.documentWriter(dest, TRANSITIONAL_DTD);
		else
			dw  = XML.documentWriter(dest);
		
		if (declareVersion)
			dw.xmlVersion();
		
		if (declareDTD)
			dw.dtd(HTML, TRANSITIONAL_PUBLIC_ID, TRANSITIONAL_SYSTEM_ID);
		
		return dw;
	}
	
	public static DocumentWriter transitionalDocumentWriter(
			boolean declareVersion, 
			boolean declareDTD,
			boolean validate,
			OutputStream dest) throws IOException {
		return transitionalDocumentWriter(declareVersion, declareDTD, validate, dest, "UTF-8");
	}
	
	public static DocumentWriter transitionalDocumentWriter(
			boolean declareVersion, 
			boolean declareDTD,
			boolean validate,
			OutputStream dest,
			String charset) throws IOException {
		
		DocumentWriter dw;
		
		if (validate)
			dw = XML.documentWriter(dest, charset, TRANSITIONAL_DTD);
		else
			dw  = XML.documentWriter(dest, charset);
		
		if (declareVersion)
			dw.xmlVersion();
		
		if (declareDTD)
			dw.dtd(HTML, TRANSITIONAL_PUBLIC_ID, TRANSITIONAL_SYSTEM_ID);
		
		return dw;
	}
	
	public static DocumentWriter framesetDocumentWriter(
			boolean declareVersion, 
			boolean declareDTD,
			boolean validate,
			Writer dest) throws IOException {
		
		DocumentWriter dw;
		
		if (validate)
			dw = XML.documentWriter(dest, FRAMESET_DTD);
		else
			dw  = XML.documentWriter(dest);
		
		if (declareVersion)
			dw.xmlVersion();
		
		if (declareDTD)
			dw.dtd(HTML, FRAMESET_PUBLIC_ID, FRAMESET_SYSTEM_ID);
		
		return dw;
	}
	
	public static DocumentWriter framesetDocumentWriter(
			boolean declareVersion, 
			boolean declareDTD,
			boolean validate,
			OutputStream dest) throws IOException {
		return framesetDocumentWriter(declareVersion, declareDTD, validate, dest, "UTF-8");
	}
	
	public static DocumentWriter framesetDocumentWriter(
			boolean declareVersion, 
			boolean declareDTD,
			boolean validate,
			OutputStream dest,
			String charset) throws IOException {
		
		DocumentWriter dw;
		
		if (validate)
			dw = XML.documentWriter(dest, charset, FRAMESET_DTD);
		else
			dw  = XML.documentWriter(dest, charset);
		
		if (declareVersion)
			dw.xmlVersion();
		
		if (declareDTD)
			dw.dtd(HTML, FRAMESET_PUBLIC_ID, FRAMESET_SYSTEM_ID);
		
		return dw;
	}
	
	// *** Public Methods ***
	
	// *** Protected Methods ***
	
	// *** Package Methods ***
	
	// *** Private Methods ***
	
	// *** Public Classes ***

}










/* end */
