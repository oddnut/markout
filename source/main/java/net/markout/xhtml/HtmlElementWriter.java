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

/**
 * HtmlElementWriter
 * 
 * THIS IS A GENERATED FILE, DO NOT EDIT!
 */
public class HtmlElementWriter extends BasicElementWriter implements HtmlContentWriter{
	// *** Class Members ***
	private static final Name A = new Name("a");
	private static final Name ABBR = new Name("abbr");
	private static final Name ACRONYM = new Name("acronym");
	private static final Name ADDRESS = new Name("address");
	private static final Name APPLET = new Name("applet");
	private static final Name AREA = new Name("area");
	private static final Name B = new Name("b");
	private static final Name BASE = new Name("base");
	private static final Name BASEFONT = new Name("basefont");
	private static final Name BDO = new Name("bdo");
	private static final Name BIG = new Name("big");
	private static final Name BLOCKQUOTE = new Name("blockquote");
	private static final Name BODY = new Name("body");
	private static final Name BR = new Name("br");
	private static final Name BUTTON = new Name("button");
	private static final Name CAPTION = new Name("caption");
	private static final Name CENTER = new Name("center");
	private static final Name CITE = new Name("cite");
	private static final Name CODE = new Name("code");
	private static final Name COL = new Name("col");
	private static final Name COLGROUP = new Name("colgroup");
	private static final Name DD = new Name("dd");
	private static final Name DEL = new Name("del");
	private static final Name DFN = new Name("dfn");
	private static final Name DIR = new Name("dir");
	private static final Name DIV = new Name("div");
	private static final Name DL = new Name("dl");
	private static final Name DT = new Name("dt");
	private static final Name EM = new Name("em");
	private static final Name FIELDSET = new Name("fieldset");
	private static final Name FONT = new Name("font");
	private static final Name FORM = new Name("form");
	private static final Name FRAME = new Name("frame");
	private static final Name FRAMESET = new Name("frameset");
	private static final Name H1 = new Name("h1");
	private static final Name H2 = new Name("h2");
	private static final Name H3 = new Name("h3");
	private static final Name H4 = new Name("h4");
	private static final Name H5 = new Name("h5");
	private static final Name H6 = new Name("h6");
	private static final Name HEAD = new Name("head");
	private static final Name HR = new Name("hr");
	private static final Name HTML = new Name("html");
	private static final Name I = new Name("i");
	private static final Name IFRAME = new Name("iframe");
	private static final Name IMG = new Name("img");
	private static final Name INPUT = new Name("input");
	private static final Name INS = new Name("ins");
	private static final Name ISINDEX = new Name("isindex");
	private static final Name KBD = new Name("kbd");
	private static final Name LABEL = new Name("label");
	private static final Name LEGEND = new Name("legend");
	private static final Name LI = new Name("li");
	private static final Name LINK = new Name("link");
	private static final Name MAP = new Name("map");
	private static final Name MENU = new Name("menu");
	private static final Name META = new Name("meta");
	private static final Name NOFRAMES = new Name("noframes");
	private static final Name NOSCRIPT = new Name("noscript");
	private static final Name OBJECT = new Name("object");
	private static final Name OL = new Name("ol");
	private static final Name OPTGROUP = new Name("optgroup");
	private static final Name OPTION = new Name("option");
	private static final Name P = new Name("p");
	private static final Name PARAM = new Name("param");
	private static final Name PRE = new Name("pre");
	private static final Name Q = new Name("q");
	private static final Name S = new Name("s");
	private static final Name SAMP = new Name("samp");
	private static final Name SCRIPT = new Name("script");
	private static final Name SELECT = new Name("select");
	private static final Name SMALL = new Name("small");
	private static final Name SPAN = new Name("span");
	private static final Name STRIKE = new Name("strike");
	private static final Name STRONG = new Name("strong");
	private static final Name STYLE = new Name("style");
	private static final Name SUB = new Name("sub");
	private static final Name SUP = new Name("sup");
	private static final Name TABLE = new Name("table");
	private static final Name TBODY = new Name("tbody");
	private static final Name TD = new Name("td");
	private static final Name TEXTAREA = new Name("textarea");
	private static final Name TFOOT = new Name("tfoot");
	private static final Name TH = new Name("th");
	private static final Name THEAD = new Name("thead");
	private static final Name TITLE = new Name("title");
	private static final Name TR = new Name("tr");
	private static final Name TT = new Name("tt");
	private static final Name U = new Name("u");
	private static final Name UL = new Name("ul");
	private static final Name VAR = new Name("var");
	
	// *** Constructors ***
	public HtmlElementWriter(XMLChunkWriter out) {super(out);}

	// *** HtmlContentWriter Methods ***
	
	public HtmlContentWriter a(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(A, attributes);
	}
	public void emptyA(Attribute... attributes) throws IOException {
		emptyElement(A, attributes);
	}
	
	public HtmlContentWriter abbr(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(ABBR, attributes);
	}
	public void emptyAbbr(Attribute... attributes) throws IOException {
		emptyElement(ABBR, attributes);
	}
	
	public HtmlContentWriter acronym(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(ACRONYM, attributes);
	}
	public void emptyAcronym(Attribute... attributes) throws IOException {
		emptyElement(ACRONYM, attributes);
	}
	
	public HtmlContentWriter address(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(ADDRESS, attributes);
	}
	public void emptyAddress(Attribute... attributes) throws IOException {
		emptyElement(ADDRESS, attributes);
	}
	
	public HtmlContentWriter applet(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(APPLET, attributes);
	}
	public void emptyApplet(Attribute... attributes) throws IOException {
		emptyElement(APPLET, attributes);
	}
	
	public HtmlContentWriter area(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(AREA, attributes);
	}
	public void emptyArea(Attribute... attributes) throws IOException {
		emptyElement(AREA, attributes);
	}
	
	public HtmlContentWriter b(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(B, attributes);
	}
	public void emptyB(Attribute... attributes) throws IOException {
		emptyElement(B, attributes);
	}
	
	public HtmlContentWriter base(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(BASE, attributes);
	}
	public void emptyBase(Attribute... attributes) throws IOException {
		emptyElement(BASE, attributes);
	}
	
	public HtmlContentWriter basefont(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(BASEFONT, attributes);
	}
	public void emptyBasefont(Attribute... attributes) throws IOException {
		emptyElement(BASEFONT, attributes);
	}
	
	public HtmlContentWriter bdo(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(BDO, attributes);
	}
	public void emptyBdo(Attribute... attributes) throws IOException {
		emptyElement(BDO, attributes);
	}
	
	public HtmlContentWriter big(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(BIG, attributes);
	}
	public void emptyBig(Attribute... attributes) throws IOException {
		emptyElement(BIG, attributes);
	}
	
	public HtmlContentWriter blockquote(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(BLOCKQUOTE, attributes);
	}
	public void emptyBlockquote(Attribute... attributes) throws IOException {
		emptyElement(BLOCKQUOTE, attributes);
	}
	
	public HtmlContentWriter body(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(BODY, attributes);
	}
	public void emptyBody(Attribute... attributes) throws IOException {
		emptyElement(BODY, attributes);
	}
	
	public HtmlContentWriter br(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(BR, attributes);
	}
	public void emptyBr(Attribute... attributes) throws IOException {
		emptyElement(BR, attributes);
	}
	
	public HtmlContentWriter button(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(BUTTON, attributes);
	}
	public void emptyButton(Attribute... attributes) throws IOException {
		emptyElement(BUTTON, attributes);
	}
	
	public HtmlContentWriter caption(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(CAPTION, attributes);
	}
	public void emptyCaption(Attribute... attributes) throws IOException {
		emptyElement(CAPTION, attributes);
	}
	
	public HtmlContentWriter center(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(CENTER, attributes);
	}
	public void emptyCenter(Attribute... attributes) throws IOException {
		emptyElement(CENTER, attributes);
	}
	
	public HtmlContentWriter cite(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(CITE, attributes);
	}
	public void emptyCite(Attribute... attributes) throws IOException {
		emptyElement(CITE, attributes);
	}
	
	public HtmlContentWriter code(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(CODE, attributes);
	}
	public void emptyCode(Attribute... attributes) throws IOException {
		emptyElement(CODE, attributes);
	}
	
	public HtmlContentWriter col(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(COL, attributes);
	}
	public void emptyCol(Attribute... attributes) throws IOException {
		emptyElement(COL, attributes);
	}
	
	public HtmlContentWriter colgroup(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(COLGROUP, attributes);
	}
	public void emptyColgroup(Attribute... attributes) throws IOException {
		emptyElement(COLGROUP, attributes);
	}
	
	public HtmlContentWriter dd(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(DD, attributes);
	}
	public void emptyDd(Attribute... attributes) throws IOException {
		emptyElement(DD, attributes);
	}
	
	public HtmlContentWriter del(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(DEL, attributes);
	}
	public void emptyDel(Attribute... attributes) throws IOException {
		emptyElement(DEL, attributes);
	}
	
	public HtmlContentWriter dfn(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(DFN, attributes);
	}
	public void emptyDfn(Attribute... attributes) throws IOException {
		emptyElement(DFN, attributes);
	}
	
	public HtmlContentWriter dir(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(DIR, attributes);
	}
	public void emptyDir(Attribute... attributes) throws IOException {
		emptyElement(DIR, attributes);
	}
	
	public HtmlContentWriter div(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(DIV, attributes);
	}
	public void emptyDiv(Attribute... attributes) throws IOException {
		emptyElement(DIV, attributes);
	}
	
	public HtmlContentWriter dl(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(DL, attributes);
	}
	public void emptyDl(Attribute... attributes) throws IOException {
		emptyElement(DL, attributes);
	}
	
	public HtmlContentWriter dt(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(DT, attributes);
	}
	public void emptyDt(Attribute... attributes) throws IOException {
		emptyElement(DT, attributes);
	}
	
	public HtmlContentWriter em(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(EM, attributes);
	}
	public void emptyEm(Attribute... attributes) throws IOException {
		emptyElement(EM, attributes);
	}
	
	public HtmlContentWriter fieldset(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(FIELDSET, attributes);
	}
	public void emptyFieldset(Attribute... attributes) throws IOException {
		emptyElement(FIELDSET, attributes);
	}
	
	public HtmlContentWriter font(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(FONT, attributes);
	}
	public void emptyFont(Attribute... attributes) throws IOException {
		emptyElement(FONT, attributes);
	}
	
	public HtmlContentWriter form(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(FORM, attributes);
	}
	public void emptyForm(Attribute... attributes) throws IOException {
		emptyElement(FORM, attributes);
	}
	
	public HtmlContentWriter frame(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(FRAME, attributes);
	}
	public void emptyFrame(Attribute... attributes) throws IOException {
		emptyElement(FRAME, attributes);
	}
	
	public HtmlContentWriter frameset(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(FRAMESET, attributes);
	}
	public void emptyFrameset(Attribute... attributes) throws IOException {
		emptyElement(FRAMESET, attributes);
	}
	
	public HtmlContentWriter h1(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(H1, attributes);
	}
	public void emptyH1(Attribute... attributes) throws IOException {
		emptyElement(H1, attributes);
	}
	
	public HtmlContentWriter h2(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(H2, attributes);
	}
	public void emptyH2(Attribute... attributes) throws IOException {
		emptyElement(H2, attributes);
	}
	
	public HtmlContentWriter h3(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(H3, attributes);
	}
	public void emptyH3(Attribute... attributes) throws IOException {
		emptyElement(H3, attributes);
	}
	
	public HtmlContentWriter h4(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(H4, attributes);
	}
	public void emptyH4(Attribute... attributes) throws IOException {
		emptyElement(H4, attributes);
	}
	
	public HtmlContentWriter h5(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(H5, attributes);
	}
	public void emptyH5(Attribute... attributes) throws IOException {
		emptyElement(H5, attributes);
	}
	
	public HtmlContentWriter h6(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(H6, attributes);
	}
	public void emptyH6(Attribute... attributes) throws IOException {
		emptyElement(H6, attributes);
	}
	
	public HtmlContentWriter head(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(HEAD, attributes);
	}
	public void emptyHead(Attribute... attributes) throws IOException {
		emptyElement(HEAD, attributes);
	}
	
	public HtmlContentWriter hr(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(HR, attributes);
	}
	public void emptyHr(Attribute... attributes) throws IOException {
		emptyElement(HR, attributes);
	}
	
	public HtmlContentWriter html(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(HTML, attributes);
	}
	public void emptyHtml(Attribute... attributes) throws IOException {
		emptyElement(HTML, attributes);
	}
	
	public HtmlContentWriter i(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(I, attributes);
	}
	public void emptyI(Attribute... attributes) throws IOException {
		emptyElement(I, attributes);
	}
	
	public HtmlContentWriter iframe(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(IFRAME, attributes);
	}
	public void emptyIframe(Attribute... attributes) throws IOException {
		emptyElement(IFRAME, attributes);
	}
	
	public HtmlContentWriter img(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(IMG, attributes);
	}
	public void emptyImg(Attribute... attributes) throws IOException {
		emptyElement(IMG, attributes);
	}
	
	public HtmlContentWriter input(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(INPUT, attributes);
	}
	public void emptyInput(Attribute... attributes) throws IOException {
		emptyElement(INPUT, attributes);
	}
	
	public HtmlContentWriter ins(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(INS, attributes);
	}
	public void emptyIns(Attribute... attributes) throws IOException {
		emptyElement(INS, attributes);
	}
	
	public HtmlContentWriter isindex(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(ISINDEX, attributes);
	}
	public void emptyIsindex(Attribute... attributes) throws IOException {
		emptyElement(ISINDEX, attributes);
	}
	
	public HtmlContentWriter kbd(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(KBD, attributes);
	}
	public void emptyKbd(Attribute... attributes) throws IOException {
		emptyElement(KBD, attributes);
	}
	
	public HtmlContentWriter label(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(LABEL, attributes);
	}
	public void emptyLabel(Attribute... attributes) throws IOException {
		emptyElement(LABEL, attributes);
	}
	
	public HtmlContentWriter legend(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(LEGEND, attributes);
	}
	public void emptyLegend(Attribute... attributes) throws IOException {
		emptyElement(LEGEND, attributes);
	}
	
	public HtmlContentWriter li(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(LI, attributes);
	}
	public void emptyLi(Attribute... attributes) throws IOException {
		emptyElement(LI, attributes);
	}
	
	public HtmlContentWriter link(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(LINK, attributes);
	}
	public void emptyLink(Attribute... attributes) throws IOException {
		emptyElement(LINK, attributes);
	}
	
	public HtmlContentWriter map(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(MAP, attributes);
	}
	public void emptyMap(Attribute... attributes) throws IOException {
		emptyElement(MAP, attributes);
	}
	
	public HtmlContentWriter menu(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(MENU, attributes);
	}
	public void emptyMenu(Attribute... attributes) throws IOException {
		emptyElement(MENU, attributes);
	}
	
	public HtmlContentWriter meta(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(META, attributes);
	}
	public void emptyMeta(Attribute... attributes) throws IOException {
		emptyElement(META, attributes);
	}
	
	public HtmlContentWriter noframes(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(NOFRAMES, attributes);
	}
	public void emptyNoframes(Attribute... attributes) throws IOException {
		emptyElement(NOFRAMES, attributes);
	}
	
	public HtmlContentWriter noscript(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(NOSCRIPT, attributes);
	}
	public void emptyNoscript(Attribute... attributes) throws IOException {
		emptyElement(NOSCRIPT, attributes);
	}
	
	public HtmlContentWriter object(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(OBJECT, attributes);
	}
	public void emptyObject(Attribute... attributes) throws IOException {
		emptyElement(OBJECT, attributes);
	}
	
	public HtmlContentWriter ol(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(OL, attributes);
	}
	public void emptyOl(Attribute... attributes) throws IOException {
		emptyElement(OL, attributes);
	}
	
	public HtmlContentWriter optgroup(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(OPTGROUP, attributes);
	}
	public void emptyOptgroup(Attribute... attributes) throws IOException {
		emptyElement(OPTGROUP, attributes);
	}
	
	public HtmlContentWriter option(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(OPTION, attributes);
	}
	public void emptyOption(Attribute... attributes) throws IOException {
		emptyElement(OPTION, attributes);
	}
	
	public HtmlContentWriter p(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(P, attributes);
	}
	public void emptyP(Attribute... attributes) throws IOException {
		emptyElement(P, attributes);
	}
	
	public HtmlContentWriter param(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(PARAM, attributes);
	}
	public void emptyParam(Attribute... attributes) throws IOException {
		emptyElement(PARAM, attributes);
	}
	
	public HtmlContentWriter pre(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(PRE, attributes);
	}
	public void emptyPre(Attribute... attributes) throws IOException {
		emptyElement(PRE, attributes);
	}
	
	public HtmlContentWriter q(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(Q, attributes);
	}
	public void emptyQ(Attribute... attributes) throws IOException {
		emptyElement(Q, attributes);
	}
	
	public HtmlContentWriter s(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(S, attributes);
	}
	public void emptyS(Attribute... attributes) throws IOException {
		emptyElement(S, attributes);
	}
	
	public HtmlContentWriter samp(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(SAMP, attributes);
	}
	public void emptySamp(Attribute... attributes) throws IOException {
		emptyElement(SAMP, attributes);
	}
	
	public HtmlContentWriter script(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(SCRIPT, attributes);
	}
	public void emptyScript(Attribute... attributes) throws IOException {
		emptyElement(SCRIPT, attributes);
	}
	
	public HtmlContentWriter select(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(SELECT, attributes);
	}
	public void emptySelect(Attribute... attributes) throws IOException {
		emptyElement(SELECT, attributes);
	}
	
	public HtmlContentWriter small(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(SMALL, attributes);
	}
	public void emptySmall(Attribute... attributes) throws IOException {
		emptyElement(SMALL, attributes);
	}
	
	public HtmlContentWriter span(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(SPAN, attributes);
	}
	public void emptySpan(Attribute... attributes) throws IOException {
		emptyElement(SPAN, attributes);
	}
	
	public HtmlContentWriter strike(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(STRIKE, attributes);
	}
	public void emptyStrike(Attribute... attributes) throws IOException {
		emptyElement(STRIKE, attributes);
	}
	
	public HtmlContentWriter strong(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(STRONG, attributes);
	}
	public void emptyStrong(Attribute... attributes) throws IOException {
		emptyElement(STRONG, attributes);
	}
	
	public HtmlContentWriter style(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(STYLE, attributes);
	}
	public void emptyStyle(Attribute... attributes) throws IOException {
		emptyElement(STYLE, attributes);
	}
	
	public HtmlContentWriter sub(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(SUB, attributes);
	}
	public void emptySub(Attribute... attributes) throws IOException {
		emptyElement(SUB, attributes);
	}
	
	public HtmlContentWriter sup(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(SUP, attributes);
	}
	public void emptySup(Attribute... attributes) throws IOException {
		emptyElement(SUP, attributes);
	}
	
	public HtmlContentWriter table(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(TABLE, attributes);
	}
	public void emptyTable(Attribute... attributes) throws IOException {
		emptyElement(TABLE, attributes);
	}
	
	public HtmlContentWriter tbody(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(TBODY, attributes);
	}
	public void emptyTbody(Attribute... attributes) throws IOException {
		emptyElement(TBODY, attributes);
	}
	
	public HtmlContentWriter td(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(TD, attributes);
	}
	public void emptyTd(Attribute... attributes) throws IOException {
		emptyElement(TD, attributes);
	}
	
	public HtmlContentWriter textarea(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(TEXTAREA, attributes);
	}
	public void emptyTextarea(Attribute... attributes) throws IOException {
		emptyElement(TEXTAREA, attributes);
	}
	
	public HtmlContentWriter tfoot(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(TFOOT, attributes);
	}
	public void emptyTfoot(Attribute... attributes) throws IOException {
		emptyElement(TFOOT, attributes);
	}
	
	public HtmlContentWriter th(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(TH, attributes);
	}
	public void emptyTh(Attribute... attributes) throws IOException {
		emptyElement(TH, attributes);
	}
	
	public HtmlContentWriter thead(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(THEAD, attributes);
	}
	public void emptyThead(Attribute... attributes) throws IOException {
		emptyElement(THEAD, attributes);
	}
	
	public HtmlContentWriter title(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(TITLE, attributes);
	}
	public void emptyTitle(Attribute... attributes) throws IOException {
		emptyElement(TITLE, attributes);
	}
	
	public HtmlContentWriter tr(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(TR, attributes);
	}
	public void emptyTr(Attribute... attributes) throws IOException {
		emptyElement(TR, attributes);
	}
	
	public HtmlContentWriter tt(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(TT, attributes);
	}
	public void emptyTt(Attribute... attributes) throws IOException {
		emptyElement(TT, attributes);
	}
	
	public HtmlContentWriter u(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(U, attributes);
	}
	public void emptyU(Attribute... attributes) throws IOException {
		emptyElement(U, attributes);
	}
	
	public HtmlContentWriter ul(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(UL, attributes);
	}
	public void emptyUl(Attribute... attributes) throws IOException {
		emptyElement(UL, attributes);
	}
	
	public HtmlContentWriter var(Attribute... attributes) throws IOException {
		return (HtmlContentWriter) element(VAR, attributes);
	}
	public void emptyVar(Attribute... attributes) throws IOException {
		emptyElement(VAR, attributes);
	}

	// *** Protected Methods ***
	protected BasicElementWriter createChildElementWriter(XMLChunkWriter out) {
		return new HtmlElementWriter(out);
	}

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}

