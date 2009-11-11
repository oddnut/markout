/*
	${docWriterClassName}.java

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
 * ${docWriterClassName}
 * 
 * THIS IS A GENERATED FILE, DO NOT EDIT!
 */
public class ${docWriterClassName} extends BasicDocumentWriter {
	// *** Class Members ***
	
	<#if !generateFactoryClass>
	<#list roots as root>
	private static final Name ${generator.asConstantName(root)} = new Name("${root}");
	</#list>
	</#if>

	// *** Constructors ***
	public ${docWriterClassName}(XMLOutputContext out) {super(out);}

	// *** Public Methods ***
	
	<#list roots as root>
	<#assign method_name = generator.asMethodName(root) />
	<#assign constant_name = generator.asConstantName(root) />
	<#assign model = generator.getElementModel(root) />
	<#if model.name() == "empty">
	public void ${method_name}() throws IOException {
		emptyRootElement(${constant_name});
	}
	public void ${method_name}(Attribute... attributes) throws IOException {
		emptyRootElement(${constant_name}, attributes);
	}
	<#else>
	public ${contentWriterClassName} ${method_name}() throws IOException {
		return (${contentWriterClassName}) rootElement(${constant_name});
	}
	public ${contentWriterClassName} ${method_name}(Attribute... attributes) throws IOException {
		return (${contentWriterClassName}) rootElement(${constant_name}, attributes);
	}
	</#if>
	</#list>

	// *** Protected Methods ***
	protected BasicElementWriter createRootElementWriter(XMLOutputContext out) {
		return new ${elementWriterClassName}(out);
	}

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}



