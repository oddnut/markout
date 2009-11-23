/*
	${contentWriterClassName}.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package ${packageName};

import java.io.IOException;

import net.markout.*;
import net.markout.types.*;
<#list generator.getExternalContentWriterClasses() as externalCW>
import ${externalCW};
</#list>

/**
 * ${contentWriterClassName}
 * 
 * THIS IS A GENERATED FILE, DO NOT EDIT!
 */
public interface ${contentWriterClassName} extends ContentWriter {
	// *** Class Members ***

	// *** Public Methods ***
	<#list elements as name>
	<#assign method_name = generator.asMethodName(name) />
	<#assign model = generator.getElementModel(name) />
	<#if model.name() == "empty">
	public void ${method_name}() throws IOException;
	public void ${method_name}(Attribute... attributes) throws IOException;
	<#else>
		<#if namespace.isDefaultNamespaceURI(name.namespaceURI)>
		<#assign classname = contentWriterClassName />
		<#else>
		<#assign classname = generator.getExternalContentWriterClass(name.namespaceURI) />
		</#if>
	public ${classname} ${method_name}() throws IOException;
	public ${classname} ${method_name}(Attribute... attributes) throws IOException;
	</#if>
	</#list>
}

