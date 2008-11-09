/*
	XHTMLElementConstants.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.xhtml;

// *** imports ***

import java.util.HashMap;
import java.util.Map;

import net.markout.types.Name;

/**
 * XHTMLElementConstants
 *
 * Comment here.  Author: David Fogel
 */
public class XHTMLElementConstants {
	// *** Element Names ***
	public static final Name A = new Name("a");
	public static final Name ABBR = new Name("abbr");
	public static final Name ACRONYM = new Name("acronym");
	public static final Name ADDRESS = new Name("address");
	public static final Name APPLET = new Name("applet");
	public static final Name AREA = new Name("area");
	public static final Name B = new Name("b");
	public static final Name BASE = new Name("base");
	public static final Name BASEFONT = new Name("basefont");
	public static final Name BDO = new Name("bdo");
	public static final Name BIG = new Name("big");
	public static final Name BLOCKQUOTE = new Name("blockquote");
	public static final Name BODY = new Name("body");
	public static final Name BR = new Name("br");
	public static final Name BUTTON = new Name("button");
	public static final Name CAPTION = new Name("caption");
	public static final Name CENTER = new Name("center");
	public static final Name CITE = new Name("cite");
	public static final Name CODE = new Name("code");
	public static final Name COL = new Name("col");
	public static final Name COLGROUP = new Name("colgroup");
	public static final Name DD = new Name("dd");
	public static final Name DEL = new Name("del");
	public static final Name DFN = new Name("dfn");
	public static final Name DIR = new Name("dir");
	public static final Name DIV = new Name("div");
	public static final Name DL = new Name("dl");
	public static final Name DT = new Name("dt");
	public static final Name EM = new Name("em");
	public static final Name FIELDSET = new Name("fieldset");
	public static final Name FONT = new Name("font");
	public static final Name FORM = new Name("form");
	public static final Name FRAME = new Name("frame");
	public static final Name FRAMESET = new Name("frameset");
	public static final Name H1 = new Name("h1");
	public static final Name H2 = new Name("h2");
	public static final Name H3 = new Name("h3");
	public static final Name H4 = new Name("h4");
	public static final Name H5 = new Name("h5");
	public static final Name H6 = new Name("h6");
	public static final Name HEAD = new Name("head");
	public static final Name HR = new Name("hr");
	public static final Name HTML = new Name("html");
	public static final Name I = new Name("i");
	public static final Name IFRAME = new Name("iframe");
	public static final Name IMG = new Name("img");
	public static final Name INPUT = new Name("input");
	public static final Name INS = new Name("ins");
	public static final Name ISINDEX = new Name("isindex");
	public static final Name KBD = new Name("kbd");
	public static final Name LABEL = new Name("label");
	public static final Name LEGEND = new Name("legend");
	public static final Name LI = new Name("li");
	public static final Name LINK = new Name("link");
	public static final Name MAP = new Name("map");
	public static final Name MENU = new Name("menu");
	public static final Name META = new Name("meta");
	public static final Name NOFRAMES = new Name("noframes");
	public static final Name NOSCRIPT = new Name("noscript");
	public static final Name OBJECT = new Name("object");
	public static final Name OL = new Name("ol");
	public static final Name OPTGROUP = new Name("optgroup");
	public static final Name OPTION = new Name("option");
	public static final Name P = new Name("p");
	public static final Name PARAM = new Name("param");
	public static final Name PRE = new Name("pre");
	public static final Name Q = new Name("q");
	public static final Name S = new Name("s");
	public static final Name SAMP = new Name("samp");
	public static final Name SCRIPT = new Name("script");
	public static final Name SELECT = new Name("select");
	public static final Name SMALL = new Name("small");
	public static final Name SPAN = new Name("span");
	public static final Name STRIKE = new Name("strike");
	public static final Name STRONG = new Name("strong");
	public static final Name STYLE = new Name("style");
	public static final Name SUB = new Name("sub");
	public static final Name SUP = new Name("sup");
	public static final Name TABLE = new Name("table");
	public static final Name TBODY = new Name("tbody");
	public static final Name TD = new Name("td");
	public static final Name TEXTAREA = new Name("textarea");
	public static final Name TFOOT = new Name("tfoot");
	public static final Name TH = new Name("th");
	public static final Name THEAD = new Name("thead");
	public static final Name TITLE = new Name("title");
	public static final Name TR = new Name("tr");
	public static final Name TT = new Name("tt");
	public static final Name U = new Name("u");
	public static final Name UL = new Name("ul");
	public static final Name VAR = new Name("var");
	
	private static Map NAMES;
	
	static {
		
		NAMES = new HashMap();
		
		NAMES.put("a", A);
		NAMES.put("abbr", ABBR);
		NAMES.put("acronym", ACRONYM);
		NAMES.put("address", ADDRESS);
		NAMES.put("applet", APPLET);
		NAMES.put("area", AREA);
		NAMES.put("b", B);
		NAMES.put("base", BASE);
		NAMES.put("basefont", BASEFONT);
		NAMES.put("bdo", BDO);
		NAMES.put("big", BIG);
		NAMES.put("blockquote", BLOCKQUOTE);
		NAMES.put("body", BODY);
		NAMES.put("br", BR);
		NAMES.put("button", BUTTON);
		NAMES.put("caption", CAPTION);
		NAMES.put("center", CENTER);
		NAMES.put("cite", CITE);
		NAMES.put("code", CODE);
		NAMES.put("col", COL);
		NAMES.put("colgroup", COLGROUP);
		NAMES.put("dd", DD);
		NAMES.put("del", DEL);
		NAMES.put("dfn", DFN);
		NAMES.put("dir", DIR);
		NAMES.put("div", DIV);
		NAMES.put("dl", DL);
		NAMES.put("dt", DT);
		NAMES.put("em", EM);
		NAMES.put("fieldset", FIELDSET);
		NAMES.put("font", FONT);
		NAMES.put("form", FORM);
		NAMES.put("frame", FRAME);
		NAMES.put("frameset", FRAMESET);
		NAMES.put("h1", H1);
		NAMES.put("h2", H2);
		NAMES.put("h3", H3);
		NAMES.put("h4", H4);
		NAMES.put("h5", H5);
		NAMES.put("h6", H6);
		NAMES.put("head", HEAD);
		NAMES.put("hr", HR);
		NAMES.put("html", HTML);
		NAMES.put("i", I);
		NAMES.put("iframe", IFRAME);
		NAMES.put("img", IMG);
		NAMES.put("input", INPUT);
		NAMES.put("ins", INS);
		NAMES.put("isindex", ISINDEX);
		NAMES.put("kbd", KBD);
		NAMES.put("label", LABEL);
		NAMES.put("legend", LEGEND);
		NAMES.put("li", LI);
		NAMES.put("link", LINK);
		NAMES.put("map", MAP);
		NAMES.put("menu", MENU);
		NAMES.put("meta", META);
		NAMES.put("noframes", NOFRAMES);
		NAMES.put("noscript", NOSCRIPT);
		NAMES.put("object", OBJECT);
		NAMES.put("ol", OL);
		NAMES.put("optgroup", OPTGROUP);
		NAMES.put("option", OPTION);
		NAMES.put("p", P);
		NAMES.put("param", PARAM);
		NAMES.put("pre", PRE);
		NAMES.put("q", Q);
		NAMES.put("s", S);
		NAMES.put("samp", SAMP);
		NAMES.put("script", SCRIPT);
		NAMES.put("select", SELECT);
		NAMES.put("small", SMALL);
		NAMES.put("span", SPAN);
		NAMES.put("strike", STRIKE);
		NAMES.put("strong", STRONG);
		NAMES.put("style", STYLE);
		NAMES.put("sub", SUB);
		NAMES.put("sup", SUP);
		NAMES.put("table", TABLE);
		NAMES.put("tbody", TBODY);
		NAMES.put("td", TD);
		NAMES.put("textarea", TEXTAREA);
		NAMES.put("tfoot", TFOOT);
		NAMES.put("th", TH);
		NAMES.put("thead", THEAD);
		NAMES.put("title", TITLE);
		NAMES.put("tr", TR);
		NAMES.put("tt", TT);
		NAMES.put("u", U);
		NAMES.put("ul", UL);
		NAMES.put("var", VAR);
	}
	
	public static Name elementNameFor(String name) {
		return (Name) NAMES.get(name);
	}
}










/* end */