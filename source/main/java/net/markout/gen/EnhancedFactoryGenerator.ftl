/*
	${factoryClassName}.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package ${packageName};

import java.io.*;

import net.markout.*;
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
	
	<#list docTypes as dt>
	public static final PublicIDLiteral ${generator.asConstant(dt.shortName)}_PUBLIC_ID = new PublicIDLiteral(${dt.publicID});
	public static final SystemLiteral ${generator.asConstant(dt.shortName)}_SYSTEM_ID = new SystemLiteral(${dt.system});
	</#list>
	
	public static final EmptyElementPolicy EMPTY_ELEMENT_POLICY = 
	<#if emptyPolicy == "content_model" || emptyPolicy == "content_model_with_space">
		<#assign isFirst = true />
		new NamedEmptyElementPolicy(<#list elements as name><#if generator.getElementModel(name) == "empty"><#if !isFirst>, </#if><#if isFirst><#assign isFirst = false /></#if>${generator.asConstantName(name)}</#if></#list>);
		<#if emptyPolicy == "content_model_with_space">
	static {
		((NamedEmptyElementPolicy) EMPTY_ELEMENT_POLICY).setRequiresSpaceBeforeClosing(true);
	}
		</#if>
	<#elseif emptyPolicy == "named_elements" || emptyPolicy == "named_elements_with_space">
		EmptyElementPolicy.DEFAULT; // NOT YET IMPLEMENTED for "named_elements*"
	<#elseif emptyPolicy == "class_name">
		EmptyElementPolicy.DEFAULT; // NOT YET IMPLEMENTED for "class_name"
	<#elseif emptyPolicy == "any_with_space">
		EmptyElementPolicy.DEFAULT_REQUIRES_SPACE;
	<#else>
		EmptyElementPolicy.DEFAULT;
	</#if>

	// *** Public Methods ***
	<#if generateEnhancedWriters>
		<#assign className = docWriterClassName />
	<#else>
		<#assign className = "DocumentWriter" />
	</#if>
	
	public static ${className} ${factoryMethodPrefix}DocumentWriter(OutputStream out) throws IOException {
		return ${factoryMethodPrefix}DocumentWriter(out, "UTF-8");
	}
	
	public static ${className} ${factoryMethodPrefix}DocumentWriter(OutputStream out, String charset) throws IOException {
		return ${factoryMethodPrefix}DocumentWriter(new OSXMLChunkWriter(out, charset));
	}
	
	public static ${className} ${factoryMethodPrefix}DocumentWriter(boolean declareVersion, boolean declareDTD, Writer out) throws IOException {
		return ${factoryMethodPrefix}DocumentWriter(new WriterXMLChunkWriter(out));
	}
	
	public static ${className} ${factoryMethodPrefix}DocumentWriter(XMLChunkWriter out) throws IOException {
	
		XMLOutputContext oc = new XMLOutputContext(out);
		
		oc.setEmptyElementPolicy(EMPTY_ELEMENT_POLICY);
		
		${className} dw = new ${className}(oc);
		
		<#if namespace.defaultNamespaceURI??>
		dw.defaultNamespace(${generator.asConstantName(namespace.defaultNamespaceURI)});
		</#if>
		
		return dw;
	}
	
}



