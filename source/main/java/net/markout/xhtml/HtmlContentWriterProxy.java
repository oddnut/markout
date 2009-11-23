/*
	HtmlContentWriterProxy.java

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
 * HtmlContentWriterProxy
 * 
 * THIS IS A GENERATED FILE, DO NOT EDIT!
 */
public class HtmlContentWriterProxy extends EnhancedContentWriterProxy implements HtmlContentWriter{
	// *** Class Members ***
	
	// *** Constructors ***
	public HtmlContentWriterProxy(EnhancedElementWriter out) {super(out);}

	// *** HtmlContentWriter Methods ***
	
	public HtmlContentWriter a() throws IOException {
		return ((EnhancedElementWriter) target.element(A)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter a(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(A, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter abbr() throws IOException {
		return ((EnhancedElementWriter) target.element(ABBR)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter abbr(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(ABBR, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter acronym() throws IOException {
		return ((EnhancedElementWriter) target.element(ACRONYM)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter acronym(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(ACRONYM, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter address() throws IOException {
		return ((EnhancedElementWriter) target.element(ADDRESS)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter address(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(ADDRESS, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter applet() throws IOException {
		return ((EnhancedElementWriter) target.element(APPLET)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter applet(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(APPLET, attributes)).as(HtmlContentWriter.class);
	}
	
	public void area() throws IOException {
		target.element(AREA);
	}
	public void area(Attribute... attributes) throws IOException {
		target.element(AREA, attributes);
	}
	
	public HtmlContentWriter b() throws IOException {
		return ((EnhancedElementWriter) target.element(B)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter b(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(B, attributes)).as(HtmlContentWriter.class);
	}
	
	public void base() throws IOException {
		target.element(BASE);
	}
	public void base(Attribute... attributes) throws IOException {
		target.element(BASE, attributes);
	}
	
	public void basefont() throws IOException {
		target.element(BASEFONT);
	}
	public void basefont(Attribute... attributes) throws IOException {
		target.element(BASEFONT, attributes);
	}
	
	public HtmlContentWriter bdo() throws IOException {
		return ((EnhancedElementWriter) target.element(BDO)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter bdo(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(BDO, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter big() throws IOException {
		return ((EnhancedElementWriter) target.element(BIG)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter big(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(BIG, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter blockquote() throws IOException {
		return ((EnhancedElementWriter) target.element(BLOCKQUOTE)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter blockquote(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(BLOCKQUOTE, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter body() throws IOException {
		return ((EnhancedElementWriter) target.element(BODY)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter body(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(BODY, attributes)).as(HtmlContentWriter.class);
	}
	
	public void br() throws IOException {
		target.element(BR);
	}
	public void br(Attribute... attributes) throws IOException {
		target.element(BR, attributes);
	}
	
	public HtmlContentWriter button() throws IOException {
		return ((EnhancedElementWriter) target.element(BUTTON)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter button(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(BUTTON, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter caption() throws IOException {
		return ((EnhancedElementWriter) target.element(CAPTION)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter caption(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(CAPTION, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter center() throws IOException {
		return ((EnhancedElementWriter) target.element(CENTER)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter center(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(CENTER, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter cite() throws IOException {
		return ((EnhancedElementWriter) target.element(CITE)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter cite(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(CITE, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter code() throws IOException {
		return ((EnhancedElementWriter) target.element(CODE)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter code(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(CODE, attributes)).as(HtmlContentWriter.class);
	}
	
	public void col() throws IOException {
		target.element(COL);
	}
	public void col(Attribute... attributes) throws IOException {
		target.element(COL, attributes);
	}
	
	public HtmlContentWriter colgroup() throws IOException {
		return ((EnhancedElementWriter) target.element(COLGROUP)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter colgroup(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(COLGROUP, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter dd() throws IOException {
		return ((EnhancedElementWriter) target.element(DD)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter dd(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(DD, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter del() throws IOException {
		return ((EnhancedElementWriter) target.element(DEL)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter del(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(DEL, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter dfn() throws IOException {
		return ((EnhancedElementWriter) target.element(DFN)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter dfn(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(DFN, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter dir() throws IOException {
		return ((EnhancedElementWriter) target.element(DIR)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter dir(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(DIR, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter div() throws IOException {
		return ((EnhancedElementWriter) target.element(DIV)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter div(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(DIV, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter dl() throws IOException {
		return ((EnhancedElementWriter) target.element(DL)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter dl(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(DL, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter dt() throws IOException {
		return ((EnhancedElementWriter) target.element(DT)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter dt(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(DT, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter em() throws IOException {
		return ((EnhancedElementWriter) target.element(EM)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter em(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(EM, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter fieldset() throws IOException {
		return ((EnhancedElementWriter) target.element(FIELDSET)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter fieldset(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(FIELDSET, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter font() throws IOException {
		return ((EnhancedElementWriter) target.element(FONT)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter font(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(FONT, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter form() throws IOException {
		return ((EnhancedElementWriter) target.element(FORM)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter form(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(FORM, attributes)).as(HtmlContentWriter.class);
	}
	
	public void frame() throws IOException {
		target.element(FRAME);
	}
	public void frame(Attribute... attributes) throws IOException {
		target.element(FRAME, attributes);
	}
	
	public HtmlContentWriter frameset() throws IOException {
		return ((EnhancedElementWriter) target.element(FRAMESET)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter frameset(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(FRAMESET, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter h1() throws IOException {
		return ((EnhancedElementWriter) target.element(H1)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter h1(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(H1, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter h2() throws IOException {
		return ((EnhancedElementWriter) target.element(H2)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter h2(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(H2, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter h3() throws IOException {
		return ((EnhancedElementWriter) target.element(H3)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter h3(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(H3, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter h4() throws IOException {
		return ((EnhancedElementWriter) target.element(H4)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter h4(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(H4, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter h5() throws IOException {
		return ((EnhancedElementWriter) target.element(H5)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter h5(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(H5, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter h6() throws IOException {
		return ((EnhancedElementWriter) target.element(H6)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter h6(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(H6, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter head() throws IOException {
		return ((EnhancedElementWriter) target.element(HEAD)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter head(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(HEAD, attributes)).as(HtmlContentWriter.class);
	}
	
	public void hr() throws IOException {
		target.element(HR);
	}
	public void hr(Attribute... attributes) throws IOException {
		target.element(HR, attributes);
	}
	
	public HtmlContentWriter html() throws IOException {
		return ((EnhancedElementWriter) target.element(HTML)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter html(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(HTML, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter i() throws IOException {
		return ((EnhancedElementWriter) target.element(I)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter i(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(I, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter iframe() throws IOException {
		return ((EnhancedElementWriter) target.element(IFRAME)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter iframe(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(IFRAME, attributes)).as(HtmlContentWriter.class);
	}
	
	public void img() throws IOException {
		target.element(IMG);
	}
	public void img(Attribute... attributes) throws IOException {
		target.element(IMG, attributes);
	}
	
	public void input() throws IOException {
		target.element(INPUT);
	}
	public void input(Attribute... attributes) throws IOException {
		target.element(INPUT, attributes);
	}
	
	public HtmlContentWriter ins() throws IOException {
		return ((EnhancedElementWriter) target.element(INS)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter ins(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(INS, attributes)).as(HtmlContentWriter.class);
	}
	
	public void isindex() throws IOException {
		target.element(ISINDEX);
	}
	public void isindex(Attribute... attributes) throws IOException {
		target.element(ISINDEX, attributes);
	}
	
	public HtmlContentWriter kbd() throws IOException {
		return ((EnhancedElementWriter) target.element(KBD)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter kbd(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(KBD, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter label() throws IOException {
		return ((EnhancedElementWriter) target.element(LABEL)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter label(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(LABEL, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter legend() throws IOException {
		return ((EnhancedElementWriter) target.element(LEGEND)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter legend(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(LEGEND, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter li() throws IOException {
		return ((EnhancedElementWriter) target.element(LI)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter li(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(LI, attributes)).as(HtmlContentWriter.class);
	}
	
	public void link() throws IOException {
		target.element(LINK);
	}
	public void link(Attribute... attributes) throws IOException {
		target.element(LINK, attributes);
	}
	
	public HtmlContentWriter map() throws IOException {
		return ((EnhancedElementWriter) target.element(MAP)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter map(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(MAP, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter menu() throws IOException {
		return ((EnhancedElementWriter) target.element(MENU)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter menu(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(MENU, attributes)).as(HtmlContentWriter.class);
	}
	
	public void meta() throws IOException {
		target.element(META);
	}
	public void meta(Attribute... attributes) throws IOException {
		target.element(META, attributes);
	}
	
	public HtmlContentWriter noframes() throws IOException {
		return ((EnhancedElementWriter) target.element(NOFRAMES)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter noframes(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(NOFRAMES, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter noscript() throws IOException {
		return ((EnhancedElementWriter) target.element(NOSCRIPT)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter noscript(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(NOSCRIPT, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter object() throws IOException {
		return ((EnhancedElementWriter) target.element(OBJECT)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter object(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(OBJECT, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter ol() throws IOException {
		return ((EnhancedElementWriter) target.element(OL)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter ol(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(OL, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter optgroup() throws IOException {
		return ((EnhancedElementWriter) target.element(OPTGROUP)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter optgroup(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(OPTGROUP, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter option() throws IOException {
		return ((EnhancedElementWriter) target.element(OPTION)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter option(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(OPTION, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter p() throws IOException {
		return ((EnhancedElementWriter) target.element(P)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter p(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(P, attributes)).as(HtmlContentWriter.class);
	}
	
	public void param() throws IOException {
		target.element(PARAM);
	}
	public void param(Attribute... attributes) throws IOException {
		target.element(PARAM, attributes);
	}
	
	public HtmlContentWriter pre() throws IOException {
		return ((EnhancedElementWriter) target.element(PRE)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter pre(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(PRE, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter q() throws IOException {
		return ((EnhancedElementWriter) target.element(Q)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter q(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(Q, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter s() throws IOException {
		return ((EnhancedElementWriter) target.element(S)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter s(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(S, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter samp() throws IOException {
		return ((EnhancedElementWriter) target.element(SAMP)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter samp(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(SAMP, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter script() throws IOException {
		return ((EnhancedElementWriter) target.element(SCRIPT)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter script(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(SCRIPT, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter select() throws IOException {
		return ((EnhancedElementWriter) target.element(SELECT)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter select(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(SELECT, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter small() throws IOException {
		return ((EnhancedElementWriter) target.element(SMALL)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter small(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(SMALL, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter span() throws IOException {
		return ((EnhancedElementWriter) target.element(SPAN)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter span(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(SPAN, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter strike() throws IOException {
		return ((EnhancedElementWriter) target.element(STRIKE)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter strike(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(STRIKE, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter strong() throws IOException {
		return ((EnhancedElementWriter) target.element(STRONG)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter strong(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(STRONG, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter style() throws IOException {
		return ((EnhancedElementWriter) target.element(STYLE)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter style(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(STYLE, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter sub() throws IOException {
		return ((EnhancedElementWriter) target.element(SUB)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter sub(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(SUB, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter sup() throws IOException {
		return ((EnhancedElementWriter) target.element(SUP)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter sup(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(SUP, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter table() throws IOException {
		return ((EnhancedElementWriter) target.element(TABLE)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter table(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(TABLE, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter tbody() throws IOException {
		return ((EnhancedElementWriter) target.element(TBODY)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter tbody(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(TBODY, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter td() throws IOException {
		return ((EnhancedElementWriter) target.element(TD)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter td(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(TD, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter textarea() throws IOException {
		return ((EnhancedElementWriter) target.element(TEXTAREA)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter textarea(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(TEXTAREA, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter tfoot() throws IOException {
		return ((EnhancedElementWriter) target.element(TFOOT)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter tfoot(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(TFOOT, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter th() throws IOException {
		return ((EnhancedElementWriter) target.element(TH)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter th(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(TH, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter thead() throws IOException {
		return ((EnhancedElementWriter) target.element(THEAD)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter thead(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(THEAD, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter title() throws IOException {
		return ((EnhancedElementWriter) target.element(TITLE)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter title(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(TITLE, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter tr() throws IOException {
		return ((EnhancedElementWriter) target.element(TR)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter tr(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(TR, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter tt() throws IOException {
		return ((EnhancedElementWriter) target.element(TT)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter tt(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(TT, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter u() throws IOException {
		return ((EnhancedElementWriter) target.element(U)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter u(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(U, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter ul() throws IOException {
		return ((EnhancedElementWriter) target.element(UL)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter ul(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(UL, attributes)).as(HtmlContentWriter.class);
	}
	
	public HtmlContentWriter var() throws IOException {
		return ((EnhancedElementWriter) target.element(VAR)).as(HtmlContentWriter.class);
	}
	public HtmlContentWriter var(Attribute... attributes) throws IOException {
		return ((EnhancedElementWriter) target.element(VAR, attributes)).as(HtmlContentWriter.class);
	}

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}

