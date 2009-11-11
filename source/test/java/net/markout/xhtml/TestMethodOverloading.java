/*
	TestMethodOverloading.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.xhtml;

import java.io.IOException;
import static net.markout.xhtml.XHTML.*;

/**
 * TestMethodOverloading
 * 
 * Comment here.
 */
public class TestMethodOverloading {
	// *** Class Members ***
	public static void main(String[] args) throws IOException {
		
		HtmlDocumentWriter dw = XHTML.htmlDocumentWriter(System.out);
		dw.dtd(HTML, STRICT_PUBLIC_ID, STRICT_SYSTEM_ID);
		HtmlContentWriter cw = dw.html(XML_LANG.att("en"), LANG.att("en"));
		
		cw.head().title().text("Here comes dave");
		cw = cw.body();
		cw.h1(CLASS.att("foo")).text("Yeah yeah yeah!");
		cw.p().a(HREF.att("http://markout.net/")).text("booya");
		cw.img(SRC.att("http://foo.com/img.jpg"));
		cw.p();
		
		dw.close();
	}

	// *** Instance Members ***

	// *** Constructors ***

	// *** Interface Methods ***

	// *** Public Methods ***

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}
