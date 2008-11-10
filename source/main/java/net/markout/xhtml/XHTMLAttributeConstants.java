/*
	XHTMLAttributeConstants.java
	
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
 * XHTMLAttributeConstants
 *
 * Comment here.  Author: David Fogel
 */
public class XHTMLAttributeConstants {
	// *** Attribute Names ***
	public static final Name ABBR = new Name("abbr");
	public static final Name ACCEPT = new Name("accept");
	public static final Name ACCEPT_CHARSET = new Name("accept-charset");
	public static final Name ACCESSKEY = new Name("accesskey");
	public static final Name ACTION = new Name("action");
	public static final Name ALIGN = new Name("align");
	public static final Name ALINK = new Name("alink");
	public static final Name ALT = new Name("alt");
	public static final Name ARCHIVE = new Name("archive");
	public static final Name AXIS = new Name("axis");
	public static final Name BACKGROUND = new Name("background");
	public static final Name BGCOLOR = new Name("bgcolor");
	public static final Name BORDER = new Name("border");
	public static final Name CELLPADDING = new Name("cellpadding");
	public static final Name CELLSPACING = new Name("cellspacing");
	public static final Name CHAR = new Name("char");
	public static final Name CHAROFF = new Name("charoff");
	public static final Name CHARSET = new Name("charset");
	public static final Name CHECKED = new Name("checked");
	public static final Name CITE = new Name("cite");
	public static final Name CLASS = new Name("class");
	public static final Name CLASSID = new Name("classid");
	public static final Name CLEAR = new Name("clear");
	public static final Name CODE = new Name("code");
	public static final Name CODEBASE = new Name("codebase");
	public static final Name CODETYPE = new Name("codetype");
	public static final Name COLOR = new Name("color");
	public static final Name COLS = new Name("cols");
	public static final Name COLSPAN = new Name("colspan");
	public static final Name COMPACT = new Name("compact");
	public static final Name CONTENT = new Name("content");
	public static final Name COORDS = new Name("coords");
	public static final Name DATA = new Name("data");
	public static final Name DATETIME = new Name("datetime");
	public static final Name DECLARE = new Name("declare");
	public static final Name DEFER = new Name("defer");
	public static final Name DIR = new Name("dir");
	public static final Name DISABLED = new Name("disabled");
	public static final Name ENCTYPE = new Name("enctype");
	public static final Name FACE = new Name("face");
	public static final Name FOR = new Name("for");
	public static final Name FRAME = new Name("frame");
	public static final Name FRAMEBORDER = new Name("frameborder");
	public static final Name HEADERS = new Name("headers");
	public static final Name HEIGHT = new Name("height");
	public static final Name HREF = new Name("href");
	public static final Name HREFLANG = new Name("hreflang");
	public static final Name HSPACE = new Name("hspace");
	public static final Name HTTP_EQUIV = new Name("http-equiv");
	public static final Name ID = new Name("id");
	public static final Name ISMAP = new Name("ismap");
	public static final Name LABEL = new Name("label");
	public static final Name LANG = new Name("lang");
	public static final Name LANGUAGE = new Name("language");
	public static final Name LINK = new Name("link");
	public static final Name LONGDESC = new Name("longdesc");
	public static final Name MARGINHEIGHT = new Name("marginheight");
	public static final Name MARGINWIDTH = new Name("marginwidth");
	public static final Name MAXLENGTH = new Name("maxlength");
	public static final Name MEDIA = new Name("media");
	public static final Name METHOD = new Name("method");
	public static final Name MULTIPLE = new Name("multiple");
	public static final Name NAME = new Name("name");
	public static final Name NOHREF = new Name("nohref");
	public static final Name NORESIZE = new Name("noresize");
	public static final Name NOSHADE = new Name("noshade");
	public static final Name NOWRAP = new Name("nowrap");
	public static final Name OBJECT = new Name("object");
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
	public static final Name PROFILE = new Name("profile");
	public static final Name PROMPT = new Name("prompt");
	public static final Name READONLY = new Name("readonly");
	public static final Name REL = new Name("rel");
	public static final Name REV = new Name("rev");
	public static final Name ROWS = new Name("rows");
	public static final Name ROWSPAN = new Name("rowspan");
	public static final Name RULES = new Name("rules");
	public static final Name SCHEME = new Name("scheme");
	public static final Name SCOPE = new Name("scope");
	public static final Name SCROLLING = new Name("scrolling");
	public static final Name SELECTED = new Name("selected");
	public static final Name SHAPE = new Name("shape");
	public static final Name SIZE = new Name("size");
	public static final Name SPAN = new Name("span");
	public static final Name SRC = new Name("src");
	public static final Name STANDBY = new Name("standby");
	public static final Name START = new Name("start");
	public static final Name STYLE = new Name("style");
	public static final Name SUMMARY = new Name("summary");
	public static final Name TABINDEX = new Name("tabindex");
	public static final Name TARGET = new Name("target");
	public static final Name TEXT = new Name("text");
	public static final Name TITLE = new Name("title");
	public static final Name TYPE = new Name("type");
	public static final Name USEMAP = new Name("usemap");
	public static final Name VALIGN = new Name("valign");
	public static final Name VALUE = new Name("value");
	public static final Name VALUETYPE = new Name("valuetype");
	public static final Name VLINK = new Name("vlink");
	public static final Name VSPACE = new Name("vspace");
	public static final Name WIDTH = new Name("width");
	public static final Name XML_LANG = new Name("xml:lang");
	public static final Name XML_SPACE = new Name("xml:space");
	public static final Name XMLNS = new Name("xmlns");
	
	private static Map<String, Name> NAMES;
	
	static {
		
		NAMES = new HashMap<String, Name>();
		
		NAMES.put("abbr", ABBR);
		NAMES.put("accept", ACCEPT);
		NAMES.put("accept-charset", ACCEPT_CHARSET);
		NAMES.put("accesskey", ACCESSKEY);
		NAMES.put("action", ACTION);
		NAMES.put("align", ALIGN);
		NAMES.put("alink", ALINK);
		NAMES.put("alt", ALT);
		NAMES.put("archive", ARCHIVE);
		NAMES.put("axis", AXIS);
		NAMES.put("background", BACKGROUND);
		NAMES.put("bgcolor", BGCOLOR);
		NAMES.put("border", BORDER);
		NAMES.put("cellpadding", CELLPADDING);
		NAMES.put("cellspacing", CELLSPACING);
		NAMES.put("char", CHAR);
		NAMES.put("charoff", CHAROFF);
		NAMES.put("charset", CHARSET);
		NAMES.put("checked", CHECKED);
		NAMES.put("cite", CITE);
		NAMES.put("class", CLASS);
		NAMES.put("classid", CLASSID);
		NAMES.put("clear", CLEAR);
		NAMES.put("code", CODE);
		NAMES.put("codebase", CODEBASE);
		NAMES.put("codetype", CODETYPE);
		NAMES.put("color", COLOR);
		NAMES.put("cols", COLS);
		NAMES.put("colspan", COLSPAN);
		NAMES.put("compact", COMPACT);
		NAMES.put("content", CONTENT);
		NAMES.put("coords", COORDS);
		NAMES.put("data", DATA);
		NAMES.put("datetime", DATETIME);
		NAMES.put("declare", DECLARE);
		NAMES.put("defer", DEFER);
		NAMES.put("dir", DIR);
		NAMES.put("disabled", DISABLED);
		NAMES.put("enctype", ENCTYPE);
		NAMES.put("face", FACE);
		NAMES.put("for", FOR);
		NAMES.put("frame", FRAME);
		NAMES.put("frameborder", FRAMEBORDER);
		NAMES.put("headers", HEADERS);
		NAMES.put("height", HEIGHT);
		NAMES.put("href", HREF);
		NAMES.put("hreflang", HREFLANG);
		NAMES.put("hspace", HSPACE);
		NAMES.put("http-equiv", HTTP_EQUIV);
		NAMES.put("id", ID);
		NAMES.put("ismap", ISMAP);
		NAMES.put("label", LABEL);
		NAMES.put("lang", LANG);
		NAMES.put("language", LANGUAGE);
		NAMES.put("link", LINK);
		NAMES.put("longdesc", LONGDESC);
		NAMES.put("marginheight", MARGINHEIGHT);
		NAMES.put("marginwidth", MARGINWIDTH);
		NAMES.put("maxlength", MAXLENGTH);
		NAMES.put("media", MEDIA);
		NAMES.put("method", METHOD);
		NAMES.put("multiple", MULTIPLE);
		NAMES.put("name", NAME);
		NAMES.put("nohref", NOHREF);
		NAMES.put("noresize", NORESIZE);
		NAMES.put("noshade", NOSHADE);
		NAMES.put("nowrap", NOWRAP);
		NAMES.put("object", OBJECT);
		NAMES.put("onblur", ONBLUR);
		NAMES.put("onchange", ONCHANGE);
		NAMES.put("onclick", ONCLICK);
		NAMES.put("ondblclick", ONDBLCLICK);
		NAMES.put("onfocus", ONFOCUS);
		NAMES.put("onkeydown", ONKEYDOWN);
		NAMES.put("onkeypress", ONKEYPRESS);
		NAMES.put("onkeyup", ONKEYUP);
		NAMES.put("onload", ONLOAD);
		NAMES.put("onmousedown", ONMOUSEDOWN);
		NAMES.put("onmousemove", ONMOUSEMOVE);
		NAMES.put("onmouseout", ONMOUSEOUT);
		NAMES.put("onmouseover", ONMOUSEOVER);
		NAMES.put("onmouseup", ONMOUSEUP);
		NAMES.put("onreset", ONRESET);
		NAMES.put("onselect", ONSELECT);
		NAMES.put("onsubmit", ONSUBMIT);
		NAMES.put("onunload", ONUNLOAD);
		NAMES.put("profile", PROFILE);
		NAMES.put("prompt", PROMPT);
		NAMES.put("readonly", READONLY);
		NAMES.put("rel", REL);
		NAMES.put("rev", REV);
		NAMES.put("rows", ROWS);
		NAMES.put("rowspan", ROWSPAN);
		NAMES.put("rules", RULES);
		NAMES.put("scheme", SCHEME);
		NAMES.put("scope", SCOPE);
		NAMES.put("scrolling", SCROLLING);
		NAMES.put("selected", SELECTED);
		NAMES.put("shape", SHAPE);
		NAMES.put("size", SIZE);
		NAMES.put("span", SPAN);
		NAMES.put("src", SRC);
		NAMES.put("standby", STANDBY);
		NAMES.put("start", START);
		NAMES.put("style", STYLE);
		NAMES.put("summary", SUMMARY);
		NAMES.put("tabindex", TABINDEX);
		NAMES.put("target", TARGET);
		NAMES.put("text", TEXT);
		NAMES.put("title", TITLE);
		NAMES.put("type", TYPE);
		NAMES.put("usemap", USEMAP);
		NAMES.put("valign", VALIGN);
		NAMES.put("value", VALUE);
		NAMES.put("valuetype", VALUETYPE);
		NAMES.put("vlink", VLINK);
		NAMES.put("vspace", VSPACE);
		NAMES.put("width", WIDTH);
		NAMES.put("xml:lang", XML_LANG);
		NAMES.put("xml:space", XML_SPACE);
		NAMES.put("xmlns", XMLNS);
	}
	
	public static Name attributeNameFor(String name) {
		return NAMES.get(name);
	}
}










/* end */