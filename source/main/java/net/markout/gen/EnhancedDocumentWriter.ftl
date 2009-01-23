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

/**
 * ${docWriterClassName}
 * 
 * THIS IS A GENERATED FILE, DO NOT EDIT!
 */
public class ${docWriterClassName} extends BasicDocumentWriter {
	// *** Class Members ***
	private static final Name ROOT_ELEMENT = new Name("${rootElementName}");

	// *** Constructors ***
	public ${docWriterClassName}(XMLChunkWriter out) {super(out);}

	// *** Public Methods ***
	<#assign root_method = generator.asMethodName(rootElementName) />
	
	public ${contentWriterClassName} ${root_method}(Attribute... attributes) throws IOException {
		return (${contentWriterClassName}) rootElement(ROOT_ELEMENT, attributes);
	}
	
	public void empty${root_method?cap_first}(Attribute... attributes) throws IOException {
		emptyRootElement(ROOT_ELEMENT, attributes);
	}

	// *** Protected Methods ***
	protected BasicElementWriter createRootElementWriter(XMLChunkWriter out) {
		return new ${elementWriterClassName}(out);
	}

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}



