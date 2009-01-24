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
	public ${contentWriterClassName} ${method_name}() throws IOException;
	public ${contentWriterClassName} ${method_name}(Attribute... attributes) throws IOException;
	</#if>
	</#list>
}

