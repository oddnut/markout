/*
	${docWriterClassName}.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package ${packageName};

import java.io.IOException;

import net.markout.*;
import net.markout.types.*;

/**
 * ${docWriterClassName}
 * 
 * THIS IS A GENERATED FILE, DO NOT EDIT!
 */
public interface ${docWriterClassName} extends DocumentWriter {
	// *** Class Members ***

	// *** Public Methods ***
	
	<#list roots as root>
	<#assign method_name = generator.asMethodName(root) />
	<#assign model = generator.getElementModel(root) />
	<#if model.name() == "empty">
	public void ${method_name}() throws IOException;
	public void ${method_name}(Attribute... attributes) throws IOException;
	<#else>
	public ${contentWriterClassName} ${method_name}() throws IOException;
	public ${contentWriterClassName} ${method_name}(Attribute... attributes) throws IOException;
	</#if>
	</#list>
	
}



