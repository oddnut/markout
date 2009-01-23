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
	<#list elementNames as name>
	<#assign method_name = generator.asMethodName(name) />
	<#assign constant_name = generator.asConstantName(name) />
	
	public ${contentWriterClassName} ${method_name}(Attribute... attributes) throws IOException;
	public void empty${method_name?cap_first}(Attribute... attributes) throws IOException;
	</#list>
}

