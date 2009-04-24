/*
	${elementWriterClassName}.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package ${packageName};

import java.io.IOException;

//import net.markout.*;
import net.markout.support.*;
import net.markout.types.*;

<#if generateFactoryClass>
import static ${packageName}.${factoryClassName}.*;
</#if>

/**
 * ${elementWriterClassName}
 * 
 * THIS IS A GENERATED FILE, DO NOT EDIT!
 */
public class ${elementWriterClassName} extends BasicElementWriter implements ${contentWriterClassName}{
	// *** Class Members ***
	<#if !generateFactoryClass>
	<#list elements as name>
	private static final Name ${generator.asConstantName(name)} = new Name("${name}");
	</#list>
	</#if>
	
	// *** Constructors ***
	public ${elementWriterClassName}(XMLOutputContext out) {super(out);}

	// *** ${contentWriterClassName} Methods ***
	<#list elements as name>
	<#assign method_name = generator.asMethodName(name) />
	<#assign constant_name = generator.asConstantName(name) />
	<#assign model = generator.getElementModel(name) />
	
	<#if model.name() == "empty">
	public void ${method_name}() throws IOException {
		emptyElement(${constant_name});
	}
	public void ${method_name}(Attribute... attributes) throws IOException {
		emptyElement(${constant_name}, attributes);
	}
	<#else>
	public ${contentWriterClassName} ${method_name}() throws IOException {
		return (${contentWriterClassName}) element(${constant_name});
	}
	public ${contentWriterClassName} ${method_name}(Attribute... attributes) throws IOException {
		return (${contentWriterClassName}) element(${constant_name}, attributes);
	}
	</#if>
	</#list>

	// *** Protected Methods ***
	protected BasicElementWriter createChildElementWriter(XMLOutputContext out) {
		return new ${elementWriterClassName}(out);
	}

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}

