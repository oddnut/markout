package net;

import java.io.IOException;

import net.markout.*;
import net.markout.types.*;
import net.markout.xhtml.*;
import static net.markout.xhtml.XHTMLAttributeConstants.*;
import static net.markout.xhtml.XHTMLElementConstants.*;

public class TestCode {
	
	private static final Name book = new Name("book");
	private static final Name chapter = new Name("chapter");
	private static final Comment comment = new Comment("Here's an entry");

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		
		DocumentWriter doc = XML.documentWriter(System.out);
		
		doc.xmlVersion();
		
		ContentWriter root = doc.rootElement(book);
		
		root.element(chapter).text("this is chapter 1");
		root.element(chapter).text("this is chapter 2");
		root.element(chapter).text("this is chapter 3");
		
		doc.close();
		
		System.out.println("now lets try XHTML");
		
		doc = XHTML.strictDocumentWriter(true, true, System.out);
		
		ContentWriter html = doc.rootElement(XHTML.HTML);
		
		html.element(HEAD).element(XHTML.TITLE).text("My Document");
		ContentWriter body = html.element(BODY);
		
		body.element(H1).element(A).text("Here's my anchored heading");
		
		for (int i = 0 ; i < 10 ; i++)
			doParagraph(body);
		
		doc.close();
		
		//ContentWriter div = body.elementWriter(DIV).set(CLASS, "post").set(ID, "123").content();
	}
	
	public static void doParagraph(ContentWriter body) throws IOException {
		body.space(Whitespace.NEW_LINE);
		body.comment(comment);
		ContentWriter p = body.element(XHTML.P, new Attribute(CLASS, new AttValue("post")));
		p.text("Some text ");
		p.text("Hi there");
	}

}
