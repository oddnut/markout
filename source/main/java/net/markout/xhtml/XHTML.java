/*
	XHTML.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.xhtml;

import java.io.*;

import net.markout.*;
import net.markout.support.*;
import net.markout.types.*;

/**
 * XHTML
 * 
 * THIS IS A GENERATED FILE, DO NOT EDIT!
 */
public class XHTML extends DocumentWriterFactory {
	// *** Class Members ***
	public static final NamespaceURI NAMESPACE = new NamespaceURI("http://www.w3.org/1999/xhtml");
	public static final NamespaceURI XML_NAMESPACE = new NamespaceURI("http://www.w3.org/XML/1998/namespace", "xml");
	
	public static final Name A = NAMESPACE.name("a");
	public static final Name ABBR = NAMESPACE.name("abbr");
	public static final Name ACCEPT = NAMESPACE.name("accept");
	public static final Name ACCEPT_CHARSET = NAMESPACE.name("accept-charset");
	public static final Name ACCESSKEY = NAMESPACE.name("accesskey");
	public static final Name ACRONYM = NAMESPACE.name("acronym");
	public static final Name ACTION = NAMESPACE.name("action");
	public static final Name ADDRESS = NAMESPACE.name("address");
	public static final Name ALIGN = NAMESPACE.name("align");
	public static final Name ALINK = NAMESPACE.name("alink");
	public static final Name ALT = NAMESPACE.name("alt");
	public static final Name APPLET = NAMESPACE.name("applet");
	public static final Name ARCHIVE = NAMESPACE.name("archive");
	public static final Name AREA = NAMESPACE.name("area");
	public static final Name AXIS = NAMESPACE.name("axis");
	public static final Name B = NAMESPACE.name("b");
	public static final Name BACKGROUND = NAMESPACE.name("background");
	public static final Name BASE = NAMESPACE.name("base");
	public static final Name BASEFONT = NAMESPACE.name("basefont");
	public static final Name BDO = NAMESPACE.name("bdo");
	public static final Name BGCOLOR = NAMESPACE.name("bgcolor");
	public static final Name BIG = NAMESPACE.name("big");
	public static final Name BLOCKQUOTE = NAMESPACE.name("blockquote");
	public static final Name BODY = NAMESPACE.name("body");
	public static final Name BORDER = NAMESPACE.name("border");
	public static final Name BR = NAMESPACE.name("br");
	public static final Name BUTTON = NAMESPACE.name("button");
	public static final Name CAPTION = NAMESPACE.name("caption");
	public static final Name CELLPADDING = NAMESPACE.name("cellpadding");
	public static final Name CELLSPACING = NAMESPACE.name("cellspacing");
	public static final Name CENTER = NAMESPACE.name("center");
	public static final Name CHAR = NAMESPACE.name("char");
	public static final Name CHAROFF = NAMESPACE.name("charoff");
	public static final Name CHARSET = NAMESPACE.name("charset");
	public static final Name CHECKED = NAMESPACE.name("checked");
	public static final Name CITE = NAMESPACE.name("cite");
	public static final Name CLASS = NAMESPACE.name("class");
	public static final Name CLASSID = NAMESPACE.name("classid");
	public static final Name CLEAR = NAMESPACE.name("clear");
	public static final Name CODE = NAMESPACE.name("code");
	public static final Name CODEBASE = NAMESPACE.name("codebase");
	public static final Name CODETYPE = NAMESPACE.name("codetype");
	public static final Name COL = NAMESPACE.name("col");
	public static final Name COLGROUP = NAMESPACE.name("colgroup");
	public static final Name COLOR = NAMESPACE.name("color");
	public static final Name COLS = NAMESPACE.name("cols");
	public static final Name COLSPAN = NAMESPACE.name("colspan");
	public static final Name COMPACT = NAMESPACE.name("compact");
	public static final Name CONTENT = NAMESPACE.name("content");
	public static final Name COORDS = NAMESPACE.name("coords");
	public static final Name DATA = NAMESPACE.name("data");
	public static final Name DATETIME = NAMESPACE.name("datetime");
	public static final Name DD = NAMESPACE.name("dd");
	public static final Name DECLARE = NAMESPACE.name("declare");
	public static final Name DEFER = NAMESPACE.name("defer");
	public static final Name DEL = NAMESPACE.name("del");
	public static final Name DFN = NAMESPACE.name("dfn");
	public static final Name DIR = NAMESPACE.name("dir");
	public static final Name DISABLED = NAMESPACE.name("disabled");
	public static final Name DIV = NAMESPACE.name("div");
	public static final Name DL = NAMESPACE.name("dl");
	public static final Name DT = NAMESPACE.name("dt");
	public static final Name EM = NAMESPACE.name("em");
	public static final Name ENCTYPE = NAMESPACE.name("enctype");
	public static final Name FACE = NAMESPACE.name("face");
	public static final Name FIELDSET = NAMESPACE.name("fieldset");
	public static final Name FONT = NAMESPACE.name("font");
	public static final Name FOR = NAMESPACE.name("for");
	public static final Name FORM = NAMESPACE.name("form");
	public static final Name FRAME = NAMESPACE.name("frame");
	public static final Name FRAMEBORDER = NAMESPACE.name("frameborder");
	public static final Name FRAMESET = NAMESPACE.name("frameset");
	public static final Name H1 = NAMESPACE.name("h1");
	public static final Name H2 = NAMESPACE.name("h2");
	public static final Name H3 = NAMESPACE.name("h3");
	public static final Name H4 = NAMESPACE.name("h4");
	public static final Name H5 = NAMESPACE.name("h5");
	public static final Name H6 = NAMESPACE.name("h6");
	public static final Name HEAD = NAMESPACE.name("head");
	public static final Name HEADERS = NAMESPACE.name("headers");
	public static final Name HEIGHT = NAMESPACE.name("height");
	public static final Name HR = NAMESPACE.name("hr");
	public static final Name HREF = NAMESPACE.name("href");
	public static final Name HREFLANG = NAMESPACE.name("hreflang");
	public static final Name HSPACE = NAMESPACE.name("hspace");
	public static final Name HTML = NAMESPACE.name("html");
	public static final Name HTTP_EQUIV = NAMESPACE.name("http-equiv");
	public static final Name I = NAMESPACE.name("i");
	public static final Name ID = NAMESPACE.name("id");
	public static final Name IFRAME = NAMESPACE.name("iframe");
	public static final Name IMG = NAMESPACE.name("img");
	public static final Name INPUT = NAMESPACE.name("input");
	public static final Name INS = NAMESPACE.name("ins");
	public static final Name ISINDEX = NAMESPACE.name("isindex");
	public static final Name ISMAP = NAMESPACE.name("ismap");
	public static final Name KBD = NAMESPACE.name("kbd");
	public static final Name LABEL = NAMESPACE.name("label");
	public static final Name LANG = NAMESPACE.name("lang");
	public static final Name LANGUAGE = NAMESPACE.name("language");
	public static final Name LEGEND = NAMESPACE.name("legend");
	public static final Name LI = NAMESPACE.name("li");
	public static final Name LINK = NAMESPACE.name("link");
	public static final Name LONGDESC = NAMESPACE.name("longdesc");
	public static final Name MAP = NAMESPACE.name("map");
	public static final Name MARGINHEIGHT = NAMESPACE.name("marginheight");
	public static final Name MARGINWIDTH = NAMESPACE.name("marginwidth");
	public static final Name MAXLENGTH = NAMESPACE.name("maxlength");
	public static final Name MEDIA = NAMESPACE.name("media");
	public static final Name MENU = NAMESPACE.name("menu");
	public static final Name META = NAMESPACE.name("meta");
	public static final Name METHOD = NAMESPACE.name("method");
	public static final Name MULTIPLE = NAMESPACE.name("multiple");
	public static final Name NAME = NAMESPACE.name("name");
	public static final Name NOFRAMES = NAMESPACE.name("noframes");
	public static final Name NOHREF = NAMESPACE.name("nohref");
	public static final Name NORESIZE = NAMESPACE.name("noresize");
	public static final Name NOSCRIPT = NAMESPACE.name("noscript");
	public static final Name NOSHADE = NAMESPACE.name("noshade");
	public static final Name NOWRAP = NAMESPACE.name("nowrap");
	public static final Name OBJECT = NAMESPACE.name("object");
	public static final Name OL = NAMESPACE.name("ol");
	public static final Name ONBLUR = NAMESPACE.name("onblur");
	public static final Name ONCHANGE = NAMESPACE.name("onchange");
	public static final Name ONCLICK = NAMESPACE.name("onclick");
	public static final Name ONDBLCLICK = NAMESPACE.name("ondblclick");
	public static final Name ONFOCUS = NAMESPACE.name("onfocus");
	public static final Name ONKEYDOWN = NAMESPACE.name("onkeydown");
	public static final Name ONKEYPRESS = NAMESPACE.name("onkeypress");
	public static final Name ONKEYUP = NAMESPACE.name("onkeyup");
	public static final Name ONLOAD = NAMESPACE.name("onload");
	public static final Name ONMOUSEDOWN = NAMESPACE.name("onmousedown");
	public static final Name ONMOUSEMOVE = NAMESPACE.name("onmousemove");
	public static final Name ONMOUSEOUT = NAMESPACE.name("onmouseout");
	public static final Name ONMOUSEOVER = NAMESPACE.name("onmouseover");
	public static final Name ONMOUSEUP = NAMESPACE.name("onmouseup");
	public static final Name ONRESET = NAMESPACE.name("onreset");
	public static final Name ONSELECT = NAMESPACE.name("onselect");
	public static final Name ONSUBMIT = NAMESPACE.name("onsubmit");
	public static final Name ONUNLOAD = NAMESPACE.name("onunload");
	public static final Name OPTGROUP = NAMESPACE.name("optgroup");
	public static final Name OPTION = NAMESPACE.name("option");
	public static final Name P = NAMESPACE.name("p");
	public static final Name PARAM = NAMESPACE.name("param");
	public static final Name PRE = NAMESPACE.name("pre");
	public static final Name PROFILE = NAMESPACE.name("profile");
	public static final Name PROMPT = NAMESPACE.name("prompt");
	public static final Name Q = NAMESPACE.name("q");
	public static final Name READONLY = NAMESPACE.name("readonly");
	public static final Name REL = NAMESPACE.name("rel");
	public static final Name REV = NAMESPACE.name("rev");
	public static final Name ROWS = NAMESPACE.name("rows");
	public static final Name ROWSPAN = NAMESPACE.name("rowspan");
	public static final Name RULES = NAMESPACE.name("rules");
	public static final Name S = NAMESPACE.name("s");
	public static final Name SAMP = NAMESPACE.name("samp");
	public static final Name SCHEME = NAMESPACE.name("scheme");
	public static final Name SCOPE = NAMESPACE.name("scope");
	public static final Name SCRIPT = NAMESPACE.name("script");
	public static final Name SCROLLING = NAMESPACE.name("scrolling");
	public static final Name SELECT = NAMESPACE.name("select");
	public static final Name SELECTED = NAMESPACE.name("selected");
	public static final Name SHAPE = NAMESPACE.name("shape");
	public static final Name SIZE = NAMESPACE.name("size");
	public static final Name SMALL = NAMESPACE.name("small");
	public static final Name SPAN = NAMESPACE.name("span");
	public static final Name SRC = NAMESPACE.name("src");
	public static final Name STANDBY = NAMESPACE.name("standby");
	public static final Name START = NAMESPACE.name("start");
	public static final Name STRIKE = NAMESPACE.name("strike");
	public static final Name STRONG = NAMESPACE.name("strong");
	public static final Name STYLE = NAMESPACE.name("style");
	public static final Name SUB = NAMESPACE.name("sub");
	public static final Name SUMMARY = NAMESPACE.name("summary");
	public static final Name SUP = NAMESPACE.name("sup");
	public static final Name TABINDEX = NAMESPACE.name("tabindex");
	public static final Name TABLE = NAMESPACE.name("table");
	public static final Name TARGET = NAMESPACE.name("target");
	public static final Name TBODY = NAMESPACE.name("tbody");
	public static final Name TD = NAMESPACE.name("td");
	public static final Name TEXT = NAMESPACE.name("text");
	public static final Name TEXTAREA = NAMESPACE.name("textarea");
	public static final Name TFOOT = NAMESPACE.name("tfoot");
	public static final Name TH = NAMESPACE.name("th");
	public static final Name THEAD = NAMESPACE.name("thead");
	public static final Name TITLE = NAMESPACE.name("title");
	public static final Name TR = NAMESPACE.name("tr");
	public static final Name TT = NAMESPACE.name("tt");
	public static final Name TYPE = NAMESPACE.name("type");
	public static final Name U = NAMESPACE.name("u");
	public static final Name UL = NAMESPACE.name("ul");
	public static final Name USEMAP = NAMESPACE.name("usemap");
	public static final Name VALIGN = NAMESPACE.name("valign");
	public static final Name VALUE = NAMESPACE.name("value");
	public static final Name VALUETYPE = NAMESPACE.name("valuetype");
	public static final Name VAR = NAMESPACE.name("var");
	public static final Name VLINK = NAMESPACE.name("vlink");
	public static final Name VSPACE = NAMESPACE.name("vspace");
	public static final Name WIDTH = NAMESPACE.name("width");
	public static final Name XMLNS = NAMESPACE.name("xmlns");
	public static final Name XML_LANG = XML_NAMESPACE.name("lang");
	public static final Name XML_SPACE = XML_NAMESPACE.name("space");
	
	public static final Attribute ALIGN_BOTTOM = ALIGN.att("bottom");
	public static final Attribute ALIGN_CENTER = ALIGN.att("center");
	public static final Attribute ALIGN_CHAR = ALIGN.att("char");
	public static final Attribute ALIGN_JUSTIFY = ALIGN.att("justify");
	public static final Attribute ALIGN_LEFT = ALIGN.att("left");
	public static final Attribute ALIGN_MIDDLE = ALIGN.att("middle");
	public static final Attribute ALIGN_RIGHT = ALIGN.att("right");
	public static final Attribute ALIGN_TOP = ALIGN.att("top");
	public static final Attribute CHECKED_CHECKED = CHECKED.att("checked");
	public static final Attribute CLEAR_ALL = CLEAR.att("all");
	public static final Attribute CLEAR_LEFT = CLEAR.att("left");
	public static final Attribute CLEAR_NONE = CLEAR.att("none");
	public static final Attribute CLEAR_RIGHT = CLEAR.att("right");
	public static final Attribute COLSPAN_1 = COLSPAN.att("1");
	public static final Attribute COMPACT_COMPACT = COMPACT.att("compact");
	public static final Attribute DECLARE_DECLARE = DECLARE.att("declare");
	public static final Attribute DEFER_DEFER = DEFER.att("defer");
	public static final Attribute DIR_LTR = DIR.att("ltr");
	public static final Attribute DIR_RTL = DIR.att("rtl");
	public static final Attribute DISABLED_DISABLED = DISABLED.att("disabled");
	public static final Attribute ENCTYPE_APPLICATION_X_WWW_FORM_URLENCODED = ENCTYPE.att("application/x-www-form-urlencoded");
	public static final Attribute FRAME_ABOVE = FRAME.att("above");
	public static final Attribute FRAME_BELOW = FRAME.att("below");
	public static final Attribute FRAME_BORDER = FRAME.att("border");
	public static final Attribute FRAME_BOX = FRAME.att("box");
	public static final Attribute FRAME_HSIDES = FRAME.att("hsides");
	public static final Attribute FRAME_LHS = FRAME.att("lhs");
	public static final Attribute FRAME_RHS = FRAME.att("rhs");
	public static final Attribute FRAME_VOID = FRAME.att("void");
	public static final Attribute FRAME_VSIDES = FRAME.att("vsides");
	public static final Attribute FRAMEBORDER_0 = FRAMEBORDER.att("0");
	public static final Attribute FRAMEBORDER_1 = FRAMEBORDER.att("1");
	public static final Attribute ISMAP_ISMAP = ISMAP.att("ismap");
	public static final Attribute METHOD_GET = METHOD.att("get");
	public static final Attribute METHOD_POST = METHOD.att("post");
	public static final Attribute MULTIPLE_MULTIPLE = MULTIPLE.att("multiple");
	public static final Attribute NOHREF_NOHREF = NOHREF.att("nohref");
	public static final Attribute NORESIZE_NORESIZE = NORESIZE.att("noresize");
	public static final Attribute NOSHADE_NOSHADE = NOSHADE.att("noshade");
	public static final Attribute NOWRAP_NOWRAP = NOWRAP.att("nowrap");
	public static final Attribute READONLY_READONLY = READONLY.att("readonly");
	public static final Attribute ROWSPAN_1 = ROWSPAN.att("1");
	public static final Attribute RULES_ALL = RULES.att("all");
	public static final Attribute RULES_COLS = RULES.att("cols");
	public static final Attribute RULES_GROUPS = RULES.att("groups");
	public static final Attribute RULES_NONE = RULES.att("none");
	public static final Attribute RULES_ROWS = RULES.att("rows");
	public static final Attribute SCOPE_COL = SCOPE.att("col");
	public static final Attribute SCOPE_COLGROUP = SCOPE.att("colgroup");
	public static final Attribute SCOPE_ROW = SCOPE.att("row");
	public static final Attribute SCOPE_ROWGROUP = SCOPE.att("rowgroup");
	public static final Attribute SCROLLING_AUTO = SCROLLING.att("auto");
	public static final Attribute SCROLLING_NO = SCROLLING.att("no");
	public static final Attribute SCROLLING_YES = SCROLLING.att("yes");
	public static final Attribute SELECTED_SELECTED = SELECTED.att("selected");
	public static final Attribute SHAPE_CIRCLE = SHAPE.att("circle");
	public static final Attribute SHAPE_DEFAULT = SHAPE.att("default");
	public static final Attribute SHAPE_POLY = SHAPE.att("poly");
	public static final Attribute SHAPE_RECT = SHAPE.att("rect");
	public static final Attribute SPAN_1 = SPAN.att("1");
	public static final Attribute TYPE_BUTTON = TYPE.att("button");
	public static final Attribute TYPE_CHECKBOX = TYPE.att("checkbox");
	public static final Attribute TYPE_CIRCLE = TYPE.att("circle");
	public static final Attribute TYPE_DISC = TYPE.att("disc");
	public static final Attribute TYPE_FILE = TYPE.att("file");
	public static final Attribute TYPE_HIDDEN = TYPE.att("hidden");
	public static final Attribute TYPE_IMAGE = TYPE.att("image");
	public static final Attribute TYPE_PASSWORD = TYPE.att("password");
	public static final Attribute TYPE_RADIO = TYPE.att("radio");
	public static final Attribute TYPE_RESET = TYPE.att("reset");
	public static final Attribute TYPE_SQUARE = TYPE.att("square");
	public static final Attribute TYPE_SUBMIT = TYPE.att("submit");
	public static final Attribute TYPE_TEXT = TYPE.att("text");
	public static final Attribute VALIGN_BASELINE = VALIGN.att("baseline");
	public static final Attribute VALIGN_BOTTOM = VALIGN.att("bottom");
	public static final Attribute VALIGN_MIDDLE = VALIGN.att("middle");
	public static final Attribute VALIGN_TOP = VALIGN.att("top");
	public static final Attribute VALUETYPE_DATA = VALUETYPE.att("data");
	public static final Attribute VALUETYPE_OBJECT = VALUETYPE.att("object");
	public static final Attribute VALUETYPE_REF = VALUETYPE.att("ref");
	public static final Attribute XMLNS_HTTP___WWW_W3_ORG_1999_XHTML = XMLNS.att("http://www.w3.org/1999/xhtml");
	public static final Attribute XML_SPACE_PRESERVE = XML_SPACE.att("preserve");
	
	public static final PublicIDLiteral STRICT_PUBLIC_ID = new PublicIDLiteral("-//W3C//DTD XHTML 1.0 Strict//EN");
	public static final SystemLiteral STRICT_SYSTEM_ID = new SystemLiteral("http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd");
	public static final PublicIDLiteral TRANSITIONAL_PUBLIC_ID = new PublicIDLiteral("-//W3C//DTD XHTML 1.0 Transitional//EN");
	public static final SystemLiteral TRANSITIONAL_SYSTEM_ID = new SystemLiteral("http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd");
	public static final PublicIDLiteral FRAMESET_PUBLIC_ID = new PublicIDLiteral("-//W3C//DTD XHTML 1.0 Frameset//EN");
	public static final SystemLiteral FRAMESET_SYSTEM_ID = new SystemLiteral("http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd");
	
	public static final EmptyElementPolicy EMPTY_ELEMENT_POLICY = 
		new NamedEmptyElementPolicy(AREA, BASE, BASEFONT, BR, COL, FRAME, HR, IMG, INPUT, ISINDEX, LINK, META, PARAM);
	static {
		((NamedEmptyElementPolicy) EMPTY_ELEMENT_POLICY).setRequiresSpaceBeforeClosing(true);
	}

	// *** Public Methods ***
	
	public static HtmlDocumentWriterImpl htmlDocumentWriter(OutputStream out) throws IOException {
		return htmlDocumentWriter(out, "UTF-8");
	}
	
	public static HtmlDocumentWriterImpl htmlDocumentWriter(OutputStream out, String charset) throws IOException {
		return htmlDocumentWriter(new OSXMLChunkWriter(out, charset));
	}
	
	public static HtmlDocumentWriterImpl htmlDocumentWriter(Writer out) throws IOException {
		return htmlDocumentWriter(new WriterXMLChunkWriter(out));
	}
	
	public static HtmlDocumentWriterImpl htmlDocumentWriter(XMLChunkWriter out) throws IOException {
	
		EnhancedXMLOutputContext oc = new EnhancedXMLOutputContext(out);
		
		
		oc.setEmptyElementPolicy(EMPTY_ELEMENT_POLICY);
		
		HtmlDocumentWriterImpl dw = new HtmlDocumentWriterImpl(oc);
		
		dw.defaultNamespace(NAMESPACE);
		
		return dw;
	}
	
}



