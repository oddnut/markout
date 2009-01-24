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
	<#assign method_name = generator.asMethodName(rootElementName) />
	<#assign constant_name = generator.asConstantName(rootElementName) />
	<#assign model = generator.getElementModel(rootElementName) />
	
	<#if !generateFactoryClass>
	private static final Name ${constant_name} = new Name("${rootElementName}");
	</#if>

	// *** Constructors ***
	public ${docWriterClassName}(XMLChunkWriter out) {super(out);}

	// *** Public Methods ***
	
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

	// *** Protected Methods ***
	protected BasicElementWriter createRootElementWriter(XMLChunkWriter out) {
		return new ${elementWriterClassName}(out);
	}

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}



