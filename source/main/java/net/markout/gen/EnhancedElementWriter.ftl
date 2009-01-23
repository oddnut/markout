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

/**
 * ${elementWriterClassName}
 * 
 * THIS IS A GENERATED FILE, DO NOT EDIT!
 */
public class ${elementWriterClassName} extends BasicElementWriter implements ${contentWriterClassName}{
	// *** Class Members ***
	<#list elementNames as name>
	<#assign method_name = generator.asMethodName(name) />
	<#assign constant_name = method_name?upper_case />
	private static final Name ${constant_name} = new Name("${name}");
	</#list>
	
	// *** Constructors ***
	public ${elementWriterClassName}(XMLChunkWriter out) {super(out);}

	// *** ${contentWriterClassName} Methods ***
	<#list elementNames as name>
	<#assign method_name = generator.asMethodName(name) />
	<#assign constant_name = method_name?upper_case />
	
	public ${contentWriterClassName} ${method_name}(Attribute... attributes) throws IOException {
		return (${contentWriterClassName}) element(${constant_name}, attributes);
	}
	public void empty${method_name?cap_first}(Attribute... attributes) throws IOException {
		emptyElement(${constant_name}, attributes);
	}
	</#list>

	// *** Protected Methods ***
	protected BasicElementWriter createChildElementWriter(XMLChunkWriter out) {
		return new ${elementWriterClassName}(out);
	}

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}

