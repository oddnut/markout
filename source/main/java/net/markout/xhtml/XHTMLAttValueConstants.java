/*
	XHTMLAttValueConstants.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.xhtml;

// *** imports ***

import java.util.HashMap;
import java.util.Map;

import net.markout.types.AttValue;

/**
 * XHTMLAttValueConstants
 *
 * Comment here.  Author: David Fogel
 */
public class XHTMLAttValueConstants {
	// *** Attribute Values ***
	public static final AttValue ZERO = new AttValue("0");
	public static final AttValue ONE = new AttValue("1");
	public static final AttValue ABOVE = new AttValue("above");
	public static final AttValue ALL = new AttValue("all");
	public static final AttValue APPLICATION_X_WWW_FORM_URLENCODED = new AttValue("application/x-www-form-urlencoded");
	public static final AttValue AUTO = new AttValue("auto");
	public static final AttValue BASELINE = new AttValue("baseline");
	public static final AttValue BELOW = new AttValue("below");
	public static final AttValue BORDER = new AttValue("border");
	public static final AttValue BOTTOM = new AttValue("bottom");
	public static final AttValue BOX = new AttValue("box");
	public static final AttValue BUTTON = new AttValue("button");
	public static final AttValue CENTER = new AttValue("center");
	public static final AttValue CHAR = new AttValue("char");
	public static final AttValue CHECKBOX = new AttValue("checkbox");
	public static final AttValue CIRCLE = new AttValue("circle");
	public static final AttValue COL = new AttValue("col");
	public static final AttValue COLGROUP = new AttValue("colgroup");
	public static final AttValue COLS = new AttValue("cols");
	public static final AttValue DATA = new AttValue("data");
	public static final AttValue DEFAULT = new AttValue("default");
	public static final AttValue DISC = new AttValue("disc");
	public static final AttValue FILE = new AttValue("file");
	public static final AttValue GET = new AttValue("get");
	public static final AttValue GROUPS = new AttValue("groups");
	public static final AttValue HIDDEN = new AttValue("hidden");
	public static final AttValue HSIDES = new AttValue("hsides");
	public static final AttValue HTTP___WWW_W3_ORG_1999_XHTML = new AttValue("http://www.w3.org/1999/xhtml");
	public static final AttValue IMAGE = new AttValue("image");
	public static final AttValue JUSTIFY = new AttValue("justify");
	public static final AttValue LEFT = new AttValue("left");
	public static final AttValue LHS = new AttValue("lhs");
	public static final AttValue LTR = new AttValue("ltr");
	public static final AttValue MIDDLE = new AttValue("middle");
	public static final AttValue NO = new AttValue("no");
	public static final AttValue NONE = new AttValue("none");
	public static final AttValue OBJECT = new AttValue("object");
	public static final AttValue PASSWORD = new AttValue("password");
	public static final AttValue POLY = new AttValue("poly");
	public static final AttValue POST = new AttValue("post");
	public static final AttValue PRESERVE = new AttValue("preserve");
	public static final AttValue RADIO = new AttValue("radio");
	public static final AttValue RECT = new AttValue("rect");
	public static final AttValue REF = new AttValue("ref");
	public static final AttValue RESET = new AttValue("reset");
	public static final AttValue RHS = new AttValue("rhs");
	public static final AttValue RIGHT = new AttValue("right");
	public static final AttValue ROW = new AttValue("row");
	public static final AttValue ROWGROUP = new AttValue("rowgroup");
	public static final AttValue ROWS = new AttValue("rows");
	public static final AttValue RTL = new AttValue("rtl");
	public static final AttValue SQUARE = new AttValue("square");
	public static final AttValue SUBMIT = new AttValue("submit");
	public static final AttValue TEXT = new AttValue("text");
	public static final AttValue TOP = new AttValue("top");
	public static final AttValue VOID = new AttValue("void");
	public static final AttValue VSIDES = new AttValue("vsides");
	public static final AttValue YES = new AttValue("yes");
	
	private static Map<String, AttValue> VALUES;
	
	static {
		VALUES = new HashMap<String, AttValue>();
		
		VALUES.put("0", ZERO);
		VALUES.put("1", ONE);
		VALUES.put("above", ABOVE);
		VALUES.put("all", ALL);
		VALUES.put("application/x-www-form-urlencoded", APPLICATION_X_WWW_FORM_URLENCODED);
		VALUES.put("auto", AUTO);
		VALUES.put("baseline", BASELINE);
		VALUES.put("below", BELOW);
		VALUES.put("border", BORDER);
		VALUES.put("bottom", BOTTOM);
		VALUES.put("box", BOX);
		VALUES.put("button", BUTTON);
		VALUES.put("center", CENTER);
		VALUES.put("char", CHAR);
		VALUES.put("checkbox", CHECKBOX);
		VALUES.put("circle", CIRCLE);
		VALUES.put("col", COL);
		VALUES.put("colgroup", COLGROUP);
		VALUES.put("cols", COLS);
		VALUES.put("data", DATA);
		VALUES.put("default", DEFAULT);
		VALUES.put("disc", DISC);
		VALUES.put("file", FILE);
		VALUES.put("get", GET);
		VALUES.put("groups", GROUPS);
		VALUES.put("hidden", HIDDEN);
		VALUES.put("hsides", HSIDES);
		VALUES.put("http://www.w3.org/1999/xhtml", HTTP___WWW_W3_ORG_1999_XHTML);
		VALUES.put("image", IMAGE);
		VALUES.put("justify", JUSTIFY);
		VALUES.put("left", LEFT);
		VALUES.put("lhs", LHS);
		VALUES.put("ltr", LTR);
		VALUES.put("middle", MIDDLE);
		VALUES.put("no", NO);
		VALUES.put("none", NONE);
		VALUES.put("object", OBJECT);
		VALUES.put("password", PASSWORD);
		VALUES.put("poly", POLY);
		VALUES.put("post", POST);
		VALUES.put("preserve", PRESERVE);
		VALUES.put("radio", RADIO);
		VALUES.put("rect", RECT);
		VALUES.put("ref", REF);
		VALUES.put("reset", RESET);
		VALUES.put("rhs", RHS);
		VALUES.put("right", RIGHT);
		VALUES.put("row", ROW);
		VALUES.put("rowgroup", ROWGROUP);
		VALUES.put("rows", ROWS);
		VALUES.put("rtl", RTL);
		VALUES.put("square", SQUARE);
		VALUES.put("submit", SUBMIT);
		VALUES.put("text", TEXT);
		VALUES.put("top", TOP);
		VALUES.put("void", VOID);
		VALUES.put("vsides", VSIDES);
		VALUES.put("yes", YES);
	}
	
	public static AttValue attributeValueFor(String value) {
		return VALUES.get(value);
	}
}










/* end */