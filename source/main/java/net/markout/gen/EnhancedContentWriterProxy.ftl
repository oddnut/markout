/*
	${contentWriterProxyClassName}.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package ${packageName};

import java.io.IOException;

//import net.markout.*;
import net.markout.support.*;
import net.markout.types.*;
<#list generator.getExternalContentWriterClasses() as externalCW>
import ${externalCW};
</#list>

<#if generateFactoryClass>
import static ${packageName}.${factoryClassName}.*;
</#if>

/**
 * ${contentWriterProxyClassName}
 * 
 * THIS IS A GENERATED FILE, DO NOT EDIT!
 */
public class ${contentWriterProxyClassName} extends EnhancedContentWriterProxy implements ${contentWriterClassName}{
	// *** Class Members ***
	<#if !generateFactoryClass>
	<#list elements as name>
	private static final Name ${generator.asConstantName(name)} = new Name("${name}");
	</#list>
	</#if>
	
	// *** Constructors ***
	public ${contentWriterProxyClassName}(EnhancedElementWriter out) {super(out);}

	// *** ${contentWriterClassName} Methods ***
	<#list elements as name>
	<#assign method_name = generator.asMethodName(name) />
	<#assign constant_name = generator.asConstantName(name) />
	<#assign model = generator.getElementModel(name) />
	
	<#if model.name() == "empty">
	public void ${method_name}() throws IOException {
		target.element(${constant_name});
	}
	public void ${method_name}(Attribute... attributes) throws IOException {
		target.element(${constant_name}, attributes);
	}
	<#else>
		<#if namespace.isDefaultNamespaceURI(name.namespaceURI)>
		<#assign classname = contentWriterClassName />
		<#else>
		<#assign classname = generator.getExternalContentWriterClass(name.namespaceURI) />
		</#if>
	public ${classname} ${method_name}() throws IOException {
		return ((EnhancedElementWriter) target.element(${constant_name})).as(${classname}.class);
	}
	public ${classname} ${method_name}(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(${constant_name}, attributes)).as(${classname}.class);
	}
	</#if>
	</#list>

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}

