/*
	XHTML.java

	Author: David Fogel
	Copyright 2009 David Fogel
	All rights reserved.
*/

package net.markout.xhtml;

import java.io.IOException;

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
	public static final Name A = new Name("a");
	public static final Name ABBR = new Name("abbr");
	public static final Name ACCEPT = new Name("accept");
	public static final Name ACCEPT_CHARSET = new Name("accept-charset");
	public static final Name ACCESSKEY = new Name("accesskey");
	public static final Name ACRONYM = new Name("acronym");
	public static final Name ACTION = new Name("action");
	public static final Name ADDRESS = new Name("address");
	public static final Name ALIGN = new Name("align");
	public static final Name ALT = new Name("alt");
	public static final Name ARCHIVE = new Name("archive");
	public static final Name AREA = new Name("area");
	public static final Name AXIS = new Name("axis");
	public static final Name B = new Name("b");
	public static final Name BASE = new Name("base");
	public static final Name BDO = new Name("bdo");
	public static final Name BIG = new Name("big");
	public static final Name BLOCKQUOTE = new Name("blockquote");
	public static final Name BODY = new Name("body");
	public static final Name BORDER = new Name("border");
	public static final Name BR = new Name("br");
	public static final Name BUTTON = new Name("button");
	public static final Name CAPTION = new Name("caption");
	public static final Name CELLPADDING = new Name("cellpadding");
	public static final Name CELLSPACING = new Name("cellspacing");
	public static final Name CHAR = new Name("char");
	public static final Name CHAROFF = new Name("charoff");
	public static final Name CHARSET = new Name("charset");
	public static final Name CHECKED = new Name("checked");
	public static final Name CITE = new Name("cite");
	public static final Name CLASS = new Name("class");
	public static final Name CLASSID = new Name("classid");
	public static final Name CODE = new Name("code");
	public static final Name CODEBASE = new Name("codebase");
	public static final Name CODETYPE = new Name("codetype");
	public static final Name COL = new Name("col");
	public static final Name COLGROUP = new Name("colgroup");
	public static final Name COLS = new Name("cols");
	public static final Name COLSPAN = new Name("colspan");
	public static final Name CONTENT = new Name("content");
	public static final Name COORDS = new Name("coords");
	public static final Name DATA = new Name("data");
	public static final Name DATETIME = new Name("datetime");
	public static final Name DD = new Name("dd");
	public static final Name DECLARE = new Name("declare");
	public static final Name DEFER = new Name("defer");
	public static final Name DEL = new Name("del");
	public static final Name DFN = new Name("dfn");
	public static final Name DIR = new Name("dir");
	public static final Name DISABLED = new Name("disabled");
	public static final Name DIV = new Name("div");
	public static final Name DL = new Name("dl");
	public static final Name DT = new Name("dt");
	public static final Name EM = new Name("em");
	public static final Name ENCTYPE = new Name("enctype");
	public static final Name FIELDSET = new Name("fieldset");
	public static final Name FOR = new Name("for");
	public static final Name FORM = new Name("form");
	public static final Name FRAME = new Name("frame");
	public static final Name H1 = new Name("h1");
	public static final Name H2 = new Name("h2");
	public static final Name H3 = new Name("h3");
	public static final Name H4 = new Name("h4");
	public static final Name H5 = new Name("h5");
	public static final Name H6 = new Name("h6");
	public static final Name HEAD = new Name("head");
	public static final Name HEADERS = new Name("headers");
	public static final Name HEIGHT = new Name("height");
	public static final Name HR = new Name("hr");
	public static final Name HREF = new Name("href");
	public static final Name HREFLANG = new Name("hreflang");
	public static final Name HTML = new Name("html");
	public static final Name HTTP_EQUIV = new Name("http-equiv");
	public static final Name I = new Name("i");
	public static final Name ID = new Name("id");
	public static final Name IMG = new Name("img");
	public static final Name INPUT = new Name("input");
	public static final Name INS = new Name("ins");
	public static final Name ISMAP = new Name("ismap");
	public static final Name KBD = new Name("kbd");
	public static final Name LABEL = new Name("label");
	public static final Name LANG = new Name("lang");
	public static final Name LEGEND = new Name("legend");
	public static final Name LI = new Name("li");
	public static final Name LINK = new Name("link");
	public static final Name LONGDESC = new Name("longdesc");
	public static final Name MAP = new Name("map");
	public static final Name MAXLENGTH = new Name("maxlength");
	public static final Name MEDIA = new Name("media");
	public static final Name META = new Name("meta");
	public static final Name METHOD = new Name("method");
	public static final Name MULTIPLE = new Name("multiple");
	public static final Name NAME = new Name("name");
	public static final Name NOHREF = new Name("nohref");
	public static final Name NOSCRIPT = new Name("noscript");
	public static final Name OBJECT = new Name("object");
	public static final Name OL = new Name("ol");
	public static final Name ONBLUR = new Name("onblur");
	public static final Name ONCHANGE = new Name("onchange");
	public static final Name ONCLICK = new Name("onclick");
	public static final Name ONDBLCLICK = new Name("ondblclick");
	public static final Name ONFOCUS = new Name("onfocus");
	public static final Name ONKEYDOWN = new Name("onkeydown");
	public static final Name ONKEYPRESS = new Name("onkeypress");
	public static final Name ONKEYUP = new Name("onkeyup");
	public static final Name ONLOAD = new Name("onload");
	public static final Name ONMOUSEDOWN = new Name("onmousedown");
	public static final Name ONMOUSEMOVE = new Name("onmousemove");
	public static final Name ONMOUSEOUT = new Name("onmouseout");
	public static final Name ONMOUSEOVER = new Name("onmouseover");
	public static final Name ONMOUSEUP = new Name("onmouseup");
	public static final Name ONRESET = new Name("onreset");
	public static final Name ONSELECT = new Name("onselect");
	public static final Name ONSUBMIT = new Name("onsubmit");
	public static final Name ONUNLOAD = new Name("onunload");
	public static final Name OPTGROUP = new Name("optgroup");
	public static final Name OPTION = new Name("option");
	public static final Name P = new Name("p");
	public static final Name PARAM = new Name("param");
	public static final Name PRE = new Name("pre");
	public static final Name PROFILE = new Name("profile");
	public static final Name Q = new Name("q");
	public static final Name READONLY = new Name("readonly");
	public static final Name REL = new Name("rel");
	public static final Name REV = new Name("rev");
	public static final Name ROWS = new Name("rows");
	public static final Name ROWSPAN = new Name("rowspan");
	public static final Name RULES = new Name("rules");
	public static final Name SAMP = new Name("samp");
	public static final Name SCHEME = new Name("scheme");
	public static final Name SCOPE = new Name("scope");
	public static final Name SCRIPT = new Name("script");
	public static final Name SELECT = new Name("select");
	public static final Name SELECTED = new Name("selected");
	public static final Name SHAPE = new Name("shape");
	public static final Name SIZE = new Name("size");
	public static final Name SMALL = new Name("small");
	public static final Name SPAN = new Name("span");
	public static final Name SRC = new Name("src");
	public static final Name STANDBY = new Name("standby");
	public static final Name STRONG = new Name("strong");
	public static final Name STYLE = new Name("style");
	public static final Name SUB = new Name("sub");
	public static final Name SUMMARY = new Name("summary");
	public static final Name SUP = new Name("sup");
	public static final Name TABINDEX = new Name("tabindex");
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
	public static final Name TYPE = new Name("type");
	public static final Name UL = new Name("ul");
	public static final Name USEMAP = new Name("usemap");
	public static final Name VALIGN = new Name("valign");
	public static final Name VALUE = new Name("value");
	public static final Name VALUETYPE = new Name("valuetype");
	public static final Name VAR = new Name("var");
	public static final Name WIDTH = new Name("width");
	public static final Name XML_LANG = new Name("xml:lang");
	public static final Name XML_SPACE = new Name("xml:space");
	public static final Name XMLNS = new Name("xmlns");
	
	public static final Attribute ALIGN_CENTER = ALIGN.att(center);
	public static final Attribute ALIGN_CHAR = ALIGN.att(char);
	public static final Attribute ALIGN_JUSTIFY = ALIGN.att(justify);
	public static final Attribute ALIGN_LEFT = ALIGN.att(left);
	public static final Attribute ALIGN_RIGHT = ALIGN.att(right);
	public static final Attribute CHECKED_CHECKED = CHECKED.att(checked);
	public static final Attribute COLSPAN_1 = COLSPAN.att(1);
	public static final Attribute DECLARE_DECLARE = DECLARE.att(declare);
	public static final Attribute DEFER_DEFER = DEFER.att(defer);
	public static final Attribute DIR_LTR = DIR.att(ltr);
	public static final Attribute DIR_RTL = DIR.att(rtl);
	public static final Attribute DISABLED_DISABLED = DISABLED.att(disabled);
	public static final Attribute ENCTYPE_APPLICATION_X_WWW_FORM_URLENCODED = ENCTYPE.att(application/x-www-form-urlencoded);
	public static final Attribute FRAME_ABOVE = FRAME.att(above);
	public static final Attribute FRAME_BELOW = FRAME.att(below);
	public static final Attribute FRAME_BORDER = FRAME.att(border);
	public static final Attribute FRAME_BOX = FRAME.att(box);
	public static final Attribute FRAME_HSIDES = FRAME.att(hsides);
	public static final Attribute FRAME_LHS = FRAME.att(lhs);
	public static final Attribute FRAME_RHS = FRAME.att(rhs);
	public static final Attribute FRAME_VOID = FRAME.att(void);
	public static final Attribute FRAME_VSIDES = FRAME.att(vsides);
	public static final Attribute ISMAP_ISMAP = ISMAP.att(ismap);
	public static final Attribute METHOD_GET = METHOD.att(get);
	public static final Attribute METHOD_POST = METHOD.att(post);
	public static final Attribute MULTIPLE_MULTIPLE = MULTIPLE.att(multiple);
	public static final Attribute NOHREF_NOHREF = NOHREF.att(nohref);
	public static final Attribute READONLY_READONLY = READONLY.att(readonly);
	public static final Attribute ROWSPAN_1 = ROWSPAN.att(1);
	public static final Attribute RULES_ALL = RULES.att(all);
	public static final Attribute RULES_COLS = RULES.att(cols);
	public static final Attribute RULES_GROUPS = RULES.att(groups);
	public static final Attribute RULES_NONE = RULES.att(none);
	public static final Attribute RULES_ROWS = RULES.att(rows);
	public static final Attribute SCOPE_COL = SCOPE.att(col);
	public static final Attribute SCOPE_COLGROUP = SCOPE.att(colgroup);
	public static final Attribute SCOPE_ROW = SCOPE.att(row);
	public static final Attribute SCOPE_ROWGROUP = SCOPE.att(rowgroup);
	public static final Attribute SELECTED_SELECTED = SELECTED.att(selected);
	public static final Attribute SHAPE_CIRCLE = SHAPE.att(circle);
	public static final Attribute SHAPE_DEFAULT = SHAPE.att(default);
	public static final Attribute SHAPE_POLY = SHAPE.att(poly);
	public static final Attribute SHAPE_RECT = SHAPE.att(rect);
	public static final Attribute SPAN_1 = SPAN.att(1);
	public static final Attribute TYPE_BUTTON = TYPE.att(button);
	public static final Attribute TYPE_CHECKBOX = TYPE.att(checkbox);
	public static final Attribute TYPE_FILE = TYPE.att(file);
	public static final Attribute TYPE_HIDDEN = TYPE.att(hidden);
	public static final Attribute TYPE_IMAGE = TYPE.att(image);
	public static final Attribute TYPE_PASSWORD = TYPE.att(password);
	public static final Attribute TYPE_RADIO = TYPE.att(radio);
	public static final Attribute TYPE_RESET = TYPE.att(reset);
	public static final Attribute TYPE_SUBMIT = TYPE.att(submit);
	public static final Attribute TYPE_TEXT = TYPE.att(text);
	public static final Attribute VALIGN_BASELINE = VALIGN.att(baseline);
	public static final Attribute VALIGN_BOTTOM = VALIGN.att(bottom);
	public static final Attribute VALIGN_MIDDLE = VALIGN.att(middle);
	public static final Attribute VALIGN_TOP = VALIGN.att(top);
	public static final Attribute VALUETYPE_DATA = VALUETYPE.att(data);
	public static final Attribute VALUETYPE_OBJECT = VALUETYPE.att(object);
	public static final Attribute VALUETYPE_REF = VALUETYPE.att(ref);
	public static final Attribute XML_SPACE_PRESERVE = XML_SPACE.att(preserve);
	public static final Attribute XMLNS_HTTP___WWW_W3_ORG_1999_XHTML = XMLNS.att(http://www.w3.org/1999/xhtml);
	
	public static final PublicIDLiteral HTML_PUBLIC_ID = new PublicIDLiteral("-//W3C//DTD XHTML 1.0 Strict//EN");
	public static final SystemLiteral HTML_SYSTEM_ID = new SystemLiteral("http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd");

	// *** Public Methods ***
	
	public static HtmlDocumentWriter htmlDocumentWriter(boolean declareVersion, boolean declareDTD, OutputStream out) {
		return htmlDocumentWriter(declareVersion, declareDTD, out, "UTF-8");
	}
	public static HtmlDocumentWriter htmlDocumentWriter(boolean declareVersion, boolean declareDTD, OutputStream out, String charset) {
		HtmlDocumentWriter dw = new HtmlDocumentWriter(new OSXMLChunkWriter(out, charset);
		if (declareVersion)
			dw.xmlVersion();
		if (declareDTD)
			dw.dtd(HTML, HTML_PUBLIC_ID, HTML_SYSTEM_ID);
		return dw;
	}
	public static HtmlDocumentWriter htmlDocumentWriter(boolean declareVersion, boolean declareDTD, Writer out) {
		HtmlDocumentWriter dw = new HtmlDocumentWriter(new WriterXMLChunkWriter(out);
		if (declareVersion)
			dw.xmlVersion();
		if (declareDTD)
			dw.dtd(HTML, HTML_PUBLIC_ID, HTML_SYSTEM_ID);
		return dw;
	}
	
}



