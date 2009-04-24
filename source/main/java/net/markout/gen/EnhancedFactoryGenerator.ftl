/*
	${factoryClassName}.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package ${packageName};

import java.io.*;

<#if generateEnhancedWriters>//</#if>import net.markout.*;
import net.markout.support.*;
import net.markout.types.*;

/**
 * ${factoryClassName}
 * 
 * THIS IS A GENERATED FILE, DO NOT EDIT!
 */
public class ${factoryClassName} extends DocumentWriterFactory {
	// *** Class Members ***
	<#if namespace.defaultNamespaceURI??>
	public static final NamespaceURI ${generator.asConstantName(namespace.defaultNamespaceURI)} = new NamespaceURI("${namespace.defaultNamespaceURI}");
	</#if>
	<#list namespace.allPrefixedNamespaceURIs as uri>
	public static final NamespaceURI ${generator.asConstantName(uri)} = new NamespaceURI("${uri}", "${uri.preferredPrefix}");
	</#list>
	
	<#list names as name>
	<#assign uri = name.getNamespaceURI() />
	public static final Name ${generator.asConstantName(name)} = new Name(${generator.asConstantName(uri)},"${name}");
	</#list>
	
	<#list attributes as attribute>
	public static final Attribute ${generator.asConstantName(attribute)} = ${generator.asConstantName(attribute.name)}.att("${attribute.valueString}");
	</#list>
	
	<#list factoryMethodPrefixes as prefix>
	public static final PublicIDLiteral ${generator.asConstant(prefix)}_PUBLIC_ID = new PublicIDLiteral(${publicIDs[prefix_index]});
	public static final SystemLiteral ${generator.asConstant(prefix)}_SYSTEM_ID = new SystemLiteral(${systems[prefix_index]});
	</#list>

	// *** Public Methods ***
	<#if generateEnhancedWriters>
	
	<#list factoryMethodPrefixes as prefix>
	public static ${docWriterClassName} ${prefix}DocumentWriter(boolean declareVersion, boolean declareDTD, OutputStream out) throws IOException {
		return ${prefix}DocumentWriter(declareVersion, declareDTD, out, "UTF-8");
	}
	public static ${docWriterClassName} ${prefix}DocumentWriter(boolean declareVersion, boolean declareDTD, OutputStream out, String charset) throws IOException {
		XMLChunkWriter cw = new OSXMLChunkWriter(out, charset);
		XMLOutputContext oc = new XMLOutputContext(cw);
		${docWriterClassName} dw = new ${docWriterClassName}(oc);
		if (declareVersion)
			dw.xmlVersion();
		if (declareDTD)
			dw.dtd(${generator.asConstantName(rootElementName)}, ${generator.asConstant(prefix)}_PUBLIC_ID, ${generator.asConstant(prefix)}_SYSTEM_ID);
		<#if namespace.defaultNamespaceURI??>
		dw.defaultNamespace(${generator.asConstantName(namespace.defaultNamespaceURI)});
		</#if>
		return dw;
	}
	public static ${docWriterClassName} ${prefix}DocumentWriter(boolean declareVersion, boolean declareDTD, Writer out) throws IOException {
		XMLChunkWriter cw = new WriterXMLChunkWriter(out);
		XMLOutputContext oc = new XMLOutputContext(cw);
		${docWriterClassName} dw = new ${docWriterClassName}(oc);
		if (declareVersion)
			dw.xmlVersion();
		if (declareDTD)
			dw.dtd(${generator.asConstantName(rootElementName)}, ${generator.asConstant(prefix)}_PUBLIC_ID, ${generator.asConstant(prefix)}_SYSTEM_ID);
		<#if namespace.defaultNamespaceURI??>
		dw.defaultNamespace(${generator.asConstantName(namespace.defaultNamespaceURI)});
		</#if>
		return dw;
	}
	</#list>
	
	<#else>
	
	<#list factoryMethodPrefixes as prefix>
	public static DocumentWriter ${prefix}DocumentWriter(boolean declareVersion, boolean declareDTD, OutputStream out) throws IOException {
		return ${prefix}DocumentWriter(declareVersion, declareDTD, out, "UTF-8");
	}
	public static DocumentWriter ${prefix}DocumentWriter(boolean declareVersion, boolean declareDTD, OutputStream out, String charset) throws IOException {
		XMLChunkWriter cw = new OSXMLChunkWriter(out, charset);
		XMLOutputContext oc = new XMLOutputContext(cw);
		DocumentWriter dw = new BasicDocumentWriter(oc);
		if (declareVersion)
			dw.xmlVersion();
		if (declareDTD)
			dw.dtd(${generator.asConstantName(rootElementName)}, ${generator.asConstant(prefix)}_PUBLIC_ID, ${generator.asConstant(prefix)}_SYSTEM_ID);
		<#if namespace.defaultNamespaceURI??>
		dw.defaultNamespace(${generator.asConstantName(namespace.defaultNamespaceURI)});
		</#if>
		return dw;
	}
	public static DocumentWriter ${prefix}DocumentWriter(boolean declareVersion, boolean declareDTD, Writer out) throws IOException {
		XMLChunkWriter cw = new WriterXMLChunkWriter(out);
		XMLOutputContext oc = new XMLOutputContext(cw);
		DocumentWriter dw = new BasicDocumentWriter(oc);
		if (declareVersion)
			dw.xmlVersion();
		if (declareDTD)
			dw.dtd(${generator.asConstantName(rootElementName)}, ${generator.asConstant(prefix)}_PUBLIC_ID, ${generator.asConstant(prefix)}_SYSTEM_ID);
		<#if namespace.defaultNamespaceURI??>
		dw.defaultNamespace(${generator.asConstantName(namespace.defaultNamespaceURI)});
		</#if>
		return dw;
	}
	</#list>
	
	</#if>
}



