/*
	HtmlElementWriter.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.xhtml;

import java.io.IOException;

//import net.markout.*;
import net.markout.support.*;
import net.markout.types.*;

import static net.markout.xhtml.XHTML.*;

/**
 * HtmlElementWriter
 * 
 * THIS IS A GENERATED FILE, DO NOT EDIT!
 */
public class HtmlElementWriter extends BasicElementWriter implements HtmlContentWriter{
	// *** Class Members ***
	
	// *** Constructors ***
	public HtmlElementWriter(XMLOutputContext out) {super(out);}

	// *** HtmlContentWriter Methods ***
	
	public HtmlContentWriter a() throws IOException {
		return (HtmlContentWriter) element(A);
	}
	public HtmlContentWriter a(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(A, attributes);
	}
	
	public HtmlContentWriter abbr() throws IOException {
		return (HtmlContentWriter) element(ABBR);
	}
	public HtmlContentWriter abbr(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(ABBR, attributes);
	}
	
	public HtmlContentWriter acronym() throws IOException {
		return (HtmlContentWriter) element(ACRONYM);
	}
	public HtmlContentWriter acronym(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(ACRONYM, attributes);
	}
	
	public HtmlContentWriter address() throws IOException {
		return (HtmlContentWriter) element(ADDRESS);
	}
	public HtmlContentWriter address(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(ADDRESS, attributes);
	}
	
	public HtmlContentWriter applet() throws IOException {
		return (HtmlContentWriter) element(APPLET);
	}
	public HtmlContentWriter applet(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(APPLET, attributes);
	}
	
	public void area() throws IOException {
		element(AREA);
	}
	public void area(Attribute... attributes) throws IOException {
		element(AREA, attributes);
	}
	
	public HtmlContentWriter b() throws IOException {
		return (HtmlContentWriter) element(B);
	}
	public HtmlContentWriter b(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(B, attributes);
	}
	
	public void base() throws IOException {
		element(BASE);
	}
	public void base(Attribute... attributes) throws IOException {
		element(BASE, attributes);
	}
	
	public void basefont() throws IOException {
		element(BASEFONT);
	}
	public void basefont(Attribute... attributes) throws IOException {
		element(BASEFONT, attributes);
	}
	
	public HtmlContentWriter bdo() throws IOException {
		return (HtmlContentWriter) element(BDO);
	}
	public HtmlContentWriter bdo(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(BDO, attributes);
	}
	
	public HtmlContentWriter big() throws IOException {
		return (HtmlContentWriter) element(BIG);
	}
	public HtmlContentWriter big(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(BIG, attributes);
	}
	
	public HtmlContentWriter blockquote() throws IOException {
		return (HtmlContentWriter) element(BLOCKQUOTE);
	}
	public HtmlContentWriter blockquote(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(BLOCKQUOTE, attributes);
	}
	
	public HtmlContentWriter body() throws IOException {
		return (HtmlContentWriter) element(BODY);
	}
	public HtmlContentWriter body(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(BODY, attributes);
	}
	
	public void br() throws IOException {
		element(BR);
	}
	public void br(Attribute... attributes) throws IOException {
		element(BR, attributes);
	}
	
	public HtmlContentWriter button() throws IOException {
		return (HtmlContentWriter) element(BUTTON);
	}
	public HtmlContentWriter button(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(BUTTON, attributes);
	}
	
	public HtmlContentWriter caption() throws IOException {
		return (HtmlContentWriter) element(CAPTION);
	}
	public HtmlContentWriter caption(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(CAPTION, attributes);
	}
	
	public HtmlContentWriter center() throws IOException {
		return (HtmlContentWriter) element(CENTER);
	}
	public HtmlContentWriter center(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(CENTER, attributes);
	}
	
	public HtmlContentWriter cite() throws IOException {
		return (HtmlContentWriter) element(CITE);
	}
	public HtmlContentWriter cite(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(CITE, attributes);
	}
	
	public HtmlContentWriter code() throws IOException {
		return (HtmlContentWriter) element(CODE);
	}
	public HtmlContentWriter code(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(CODE, attributes);
	}
	
	public void col() throws IOException {
		element(COL);
	}
	public void col(Attribute... attributes) throws IOException {
		element(COL, attributes);
	}
	
	public HtmlContentWriter colgroup() throws IOException {
		return (HtmlContentWriter) element(COLGROUP);
	}
	public HtmlContentWriter colgroup(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(COLGROUP, attributes);
	}
	
	public HtmlContentWriter dd() throws IOException {
		return (HtmlContentWriter) element(DD);
	}
	public HtmlContentWriter dd(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(DD, attributes);
	}
	
	public HtmlContentWriter del() throws IOException {
		return (HtmlContentWriter) element(DEL);
	}
	public HtmlContentWriter del(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(DEL, attributes);
	}
	
	public HtmlContentWriter dfn() throws IOException {
		return (HtmlContentWriter) element(DFN);
	}
	public HtmlContentWriter dfn(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(DFN, attributes);
	}
	
	public HtmlContentWriter dir() throws IOException {
		return (HtmlContentWriter) element(DIR);
	}
	public HtmlContentWriter dir(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(DIR, attributes);
	}
	
	public HtmlContentWriter div() throws IOException {
		return (HtmlContentWriter) element(DIV);
	}
	public HtmlContentWriter div(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(DIV, attributes);
	}
	
	public HtmlContentWriter dl() throws IOException {
		return (HtmlContentWriter) element(DL);
	}
	public HtmlContentWriter dl(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(DL, attributes);
	}
	
	public HtmlContentWriter dt() throws IOException {
		return (HtmlContentWriter) element(DT);
	}
	public HtmlContentWriter dt(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(DT, attributes);
	}
	
	public HtmlContentWriter em() throws IOException {
		return (HtmlContentWriter) element(EM);
	}
	public HtmlContentWriter em(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(EM, attributes);
	}
	
	public HtmlContentWriter fieldset() throws IOException {
		return (HtmlContentWriter) element(FIELDSET);
	}
	public HtmlContentWriter fieldset(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(FIELDSET, attributes);
	}
	
	public HtmlContentWriter font() throws IOException {
		return (HtmlContentWriter) element(FONT);
	}
	public HtmlContentWriter font(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(FONT, attributes);
	}
	
	public HtmlContentWriter form() throws IOException {
		return (HtmlContentWriter) element(FORM);
	}
	public HtmlContentWriter form(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(FORM, attributes);
	}
	
	public void frame() throws IOException {
		element(FRAME);
	}
	public void frame(Attribute... attributes) throws IOException {
		element(FRAME, attributes);
	}
	
	public HtmlContentWriter frameset() throws IOException {
		return (HtmlContentWriter) element(FRAMESET);
	}
	public HtmlContentWriter frameset(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(FRAMESET, attributes);
	}
	
	public HtmlContentWriter h1() throws IOException {
		return (HtmlContentWriter) element(H1);
	}
	public HtmlContentWriter h1(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(H1, attributes);
	}
	
	public HtmlContentWriter h2() throws IOException {
		return (HtmlContentWriter) element(H2);
	}
	public HtmlContentWriter h2(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(H2, attributes);
	}
	
	public HtmlContentWriter h3() throws IOException {
		return (HtmlContentWriter) element(H3);
	}
	public HtmlContentWriter h3(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(H3, attributes);
	}
	
	public HtmlContentWriter h4() throws IOException {
		return (HtmlContentWriter) element(H4);
	}
	public HtmlContentWriter h4(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(H4, attributes);
	}
	
	public HtmlContentWriter h5() throws IOException {
		return (HtmlContentWriter) element(H5);
	}
	public HtmlContentWriter h5(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(H5, attributes);
	}
	
	public HtmlContentWriter h6() throws IOException {
		return (HtmlContentWriter) element(H6);
	}
	public HtmlContentWriter h6(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(H6, attributes);
	}
	
	public HtmlContentWriter head() throws IOException {
		return (HtmlContentWriter) element(HEAD);
	}
	public HtmlContentWriter head(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(HEAD, attributes);
	}
	
	public void hr() throws IOException {
		element(HR);
	}
	public void hr(Attribute... attributes) throws IOException {
		element(HR, attributes);
	}
	
	public HtmlContentWriter html() throws IOException {
		return (HtmlContentWriter) element(HTML);
	}
	public HtmlContentWriter html(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(HTML, attributes);
	}
	
	public HtmlContentWriter i() throws IOException {
		return (HtmlContentWriter) element(I);
	}
	public HtmlContentWriter i(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(I, attributes);
	}
	
	public HtmlContentWriter iframe() throws IOException {
		return (HtmlContentWriter) element(IFRAME);
	}
	public HtmlContentWriter iframe(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(IFRAME, attributes);
	}
	
	public void img() throws IOException {
		element(IMG);
	}
	public void img(Attribute... attributes) throws IOException {
		element(IMG, attributes);
	}
	
	public void input() throws IOException {
		element(INPUT);
	}
	public void input(Attribute... attributes) throws IOException {
		element(INPUT, attributes);
	}
	
	public HtmlContentWriter ins() throws IOException {
		return (HtmlContentWriter) element(INS);
	}
	public HtmlContentWriter ins(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(INS, attributes);
	}
	
	public void isindex() throws IOException {
		element(ISINDEX);
	}
	public void isindex(Attribute... attributes) throws IOException {
		element(ISINDEX, attributes);
	}
	
	public HtmlContentWriter kbd() throws IOException {
		return (HtmlContentWriter) element(KBD);
	}
	public HtmlContentWriter kbd(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(KBD, attributes);
	}
	
	public HtmlContentWriter label() throws IOException {
		return (HtmlContentWriter) element(LABEL);
	}
	public HtmlContentWriter label(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(LABEL, attributes);
	}
	
	public HtmlContentWriter legend() throws IOException {
		return (HtmlContentWriter) element(LEGEND);
	}
	public HtmlContentWriter legend(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(LEGEND, attributes);
	}
	
	public HtmlContentWriter li() throws IOException {
		return (HtmlContentWriter) element(LI);
	}
	public HtmlContentWriter li(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(LI, attributes);
	}
	
	public void link() throws IOException {
		element(LINK);
	}
	public void link(Attribute... attributes) throws IOException {
		element(LINK, attributes);
	}
	
	public HtmlContentWriter map() throws IOException {
		return (HtmlContentWriter) element(MAP);
	}
	public HtmlContentWriter map(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(MAP, attributes);
	}
	
	public HtmlContentWriter menu() throws IOException {
		return (HtmlContentWriter) element(MENU);
	}
	public HtmlContentWriter menu(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(MENU, attributes);
	}
	
	public void meta() throws IOException {
		element(META);
	}
	public void meta(Attribute... attributes) throws IOException {
		element(META, attributes);
	}
	
	public HtmlContentWriter noframes() throws IOException {
		return (HtmlContentWriter) element(NOFRAMES);
	}
	public HtmlContentWriter noframes(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(NOFRAMES, attributes);
	}
	
	public HtmlContentWriter noscript() throws IOException {
		return (HtmlContentWriter) element(NOSCRIPT);
	}
	public HtmlContentWriter noscript(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(NOSCRIPT, attributes);
	}
	
	public HtmlContentWriter object() throws IOException {
		return (HtmlContentWriter) element(OBJECT);
	}
	public HtmlContentWriter object(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(OBJECT, attributes);
	}
	
	public HtmlContentWriter ol() throws IOException {
		return (HtmlContentWriter) element(OL);
	}
	public HtmlContentWriter ol(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(OL, attributes);
	}
	
	public HtmlContentWriter optgroup() throws IOException {
		return (HtmlContentWriter) element(OPTGROUP);
	}
	public HtmlContentWriter optgroup(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(OPTGROUP, attributes);
	}
	
	public HtmlContentWriter option() throws IOException {
		return (HtmlContentWriter) element(OPTION);
	}
	public HtmlContentWriter option(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(OPTION, attributes);
	}
	
	public HtmlContentWriter p() throws IOException {
		return (HtmlContentWriter) element(P);
	}
	public HtmlContentWriter p(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(P, attributes);
	}
	
	public void param() throws IOException {
		element(PARAM);
	}
	public void param(Attribute... attributes) throws IOException {
		element(PARAM, attributes);
	}
	
	public HtmlContentWriter pre() throws IOException {
		return (HtmlContentWriter) element(PRE);
	}
	public HtmlContentWriter pre(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(PRE, attributes);
	}
	
	public HtmlContentWriter q() throws IOException {
		return (HtmlContentWriter) element(Q);
	}
	public HtmlContentWriter q(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(Q, attributes);
	}
	
	public HtmlContentWriter s() throws IOException {
		return (HtmlContentWriter) element(S);
	}
	public HtmlContentWriter s(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(S, attributes);
	}
	
	public HtmlContentWriter samp() throws IOException {
		return (HtmlContentWriter) element(SAMP);
	}
	public HtmlContentWriter samp(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(SAMP, attributes);
	}
	
	public HtmlContentWriter script() throws IOException {
		return (HtmlContentWriter) element(SCRIPT);
	}
	public HtmlContentWriter script(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(SCRIPT, attributes);
	}
	
	public HtmlContentWriter select() throws IOException {
		return (HtmlContentWriter) element(SELECT);
	}
	public HtmlContentWriter select(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(SELECT, attributes);
	}
	
	public HtmlContentWriter small() throws IOException {
		return (HtmlContentWriter) element(SMALL);
	}
	public HtmlContentWriter small(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(SMALL, attributes);
	}
	
	public HtmlContentWriter span() throws IOException {
		return (HtmlContentWriter) element(SPAN);
	}
	public HtmlContentWriter span(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(SPAN, attributes);
	}
	
	public HtmlContentWriter strike() throws IOException {
		return (HtmlContentWriter) element(STRIKE);
	}
	public HtmlContentWriter strike(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(STRIKE, attributes);
	}
	
	public HtmlContentWriter strong() throws IOException {
		return (HtmlContentWriter) element(STRONG);
	}
	public HtmlContentWriter strong(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(STRONG, attributes);
	}
	
	public HtmlContentWriter style() throws IOException {
		return (HtmlContentWriter) element(STYLE);
	}
	public HtmlContentWriter style(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(STYLE, attributes);
	}
	
	public HtmlContentWriter sub() throws IOException {
		return (HtmlContentWriter) element(SUB);
	}
	public HtmlContentWriter sub(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(SUB, attributes);
	}
	
	public HtmlContentWriter sup() throws IOException {
		return (HtmlContentWriter) element(SUP);
	}
	public HtmlContentWriter sup(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(SUP, attributes);
	}
	
	public HtmlContentWriter table() throws IOException {
		return (HtmlContentWriter) element(TABLE);
	}
	public HtmlContentWriter table(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(TABLE, attributes);
	}
	
	public HtmlContentWriter tbody() throws IOException {
		return (HtmlContentWriter) element(TBODY);
	}
	public HtmlContentWriter tbody(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(TBODY, attributes);
	}
	
	public HtmlContentWriter td() throws IOException {
		return (HtmlContentWriter) element(TD);
	}
	public HtmlContentWriter td(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(TD, attributes);
	}
	
	public HtmlContentWriter textarea() throws IOException {
		return (HtmlContentWriter) element(TEXTAREA);
	}
	public HtmlContentWriter textarea(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(TEXTAREA, attributes);
	}
	
	public HtmlContentWriter tfoot() throws IOException {
		return (HtmlContentWriter) element(TFOOT);
	}
	public HtmlContentWriter tfoot(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(TFOOT, attributes);
	}
	
	public HtmlContentWriter th() throws IOException {
		return (HtmlContentWriter) element(TH);
	}
	public HtmlContentWriter th(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(TH, attributes);
	}
	
	public HtmlContentWriter thead() throws IOException {
		return (HtmlContentWriter) element(THEAD);
	}
	public HtmlContentWriter thead(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(THEAD, attributes);
	}
	
	public HtmlContentWriter title() throws IOException {
		return (HtmlContentWriter) element(TITLE);
	}
	public HtmlContentWriter title(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(TITLE, attributes);
	}
	
	public HtmlContentWriter tr() throws IOException {
		return (HtmlContentWriter) element(TR);
	}
	public HtmlContentWriter tr(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(TR, attributes);
	}
	
	public HtmlContentWriter tt() throws IOException {
		return (HtmlContentWriter) element(TT);
	}
	public HtmlContentWriter tt(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(TT, attributes);
	}
	
	public HtmlContentWriter u() throws IOException {
		return (HtmlContentWriter) element(U);
	}
	public HtmlContentWriter u(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(U, attributes);
	}
	
	public HtmlContentWriter ul() throws IOException {
		return (HtmlContentWriter) element(UL);
	}
	public HtmlContentWriter ul(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(UL, attributes);
	}
	
	public HtmlContentWriter var() throws IOException {
		return (HtmlContentWriter) element(VAR);
	}
	public HtmlContentWriter var(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(VAR, attributes);
	}

	// *** Protected Methods ***
	protected BasicElementWriter createChildElementWriter(XMLOutputContext out) {
		return new HtmlElementWriter(out);
	}

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}

