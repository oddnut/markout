/*
	StrictDTD.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.xhtml;

// *** imports ***

import java.util.Arrays;

import net.markout.dtd.*;
import net.markout.types.AttValue;
import net.markout.types.Name;

/**
 * StrictDTD
 *
 * Comment here.  Author: David Fogel
 */
class StrictDTD extends StandardDTD {
	// *** Class Members ***

	// *** Instance Members ***
	
	private ContentModelGrammarParser theGrammarParser = new ContentModelGrammarParser();

	// *** Constructors ***
	
	StrictDTD(DTD parent) {
		super(XHTML.HTML, parent);
		
		Name a = XHTML.elementNameFor("a");
		Name abbr = XHTML.elementNameFor("abbr");
		Name acronym = XHTML.elementNameFor("acronym");
		Name address = XHTML.elementNameFor("address");
		Name area = XHTML.elementNameFor("area");
		Name b = XHTML.elementNameFor("b");
		Name base = XHTML.elementNameFor("base");
		Name bdo = XHTML.elementNameFor("bdo");
		Name big = XHTML.elementNameFor("big");
		Name blockquote = XHTML.elementNameFor("blockquote");
		Name body = XHTML.elementNameFor("body");
		Name br = XHTML.elementNameFor("br");
		Name button = XHTML.elementNameFor("button");
		Name caption = XHTML.elementNameFor("caption");
		Name cite = XHTML.elementNameFor("cite");
		Name code = XHTML.elementNameFor("code");
		Name col = XHTML.elementNameFor("col");
		Name colgroup = XHTML.elementNameFor("colgroup");
		Name dd = XHTML.elementNameFor("dd");
		Name del = XHTML.elementNameFor("del");
		Name dfn = XHTML.elementNameFor("dfn");
		Name div = XHTML.elementNameFor("div");
		Name dl = XHTML.elementNameFor("dl");
		Name dt = XHTML.elementNameFor("dt");
		Name em = XHTML.elementNameFor("em");
		Name fieldset = XHTML.elementNameFor("fieldset");
		Name form = XHTML.elementNameFor("form");
		Name h1 = XHTML.elementNameFor("h1");
		Name h2 = XHTML.elementNameFor("h2");
		Name h3 = XHTML.elementNameFor("h3");
		Name h4 = XHTML.elementNameFor("h4");
		Name h5 = XHTML.elementNameFor("h5");
		Name h6 = XHTML.elementNameFor("h6");
		Name head = XHTML.elementNameFor("head");
		Name hr = XHTML.elementNameFor("hr");
		Name html = XHTML.elementNameFor("html");
		Name i = XHTML.elementNameFor("i");
		Name img = XHTML.elementNameFor("img");
		Name input = XHTML.elementNameFor("input");
		Name ins = XHTML.elementNameFor("ins");
		Name kbd = XHTML.elementNameFor("kbd");
		Name label = XHTML.elementNameFor("label");
		Name legend = XHTML.elementNameFor("legend");
		Name li = XHTML.elementNameFor("li");
		Name link = XHTML.elementNameFor("link");
		Name map = XHTML.elementNameFor("map");
		Name meta = XHTML.elementNameFor("meta");
		Name noscript = XHTML.elementNameFor("noscript");
		Name object = XHTML.elementNameFor("object");
		Name ol = XHTML.elementNameFor("ol");
		Name optgroup = XHTML.elementNameFor("optgroup");
		Name option = XHTML.elementNameFor("option");
		Name p = XHTML.elementNameFor("p");
		Name param = XHTML.elementNameFor("param");
		Name pre = XHTML.elementNameFor("pre");
		Name q = XHTML.elementNameFor("q");
		Name samp = XHTML.elementNameFor("samp");
		Name script = XHTML.elementNameFor("script");
		Name select = XHTML.elementNameFor("select");
		Name small = XHTML.elementNameFor("small");
		Name span = XHTML.elementNameFor("span");
		Name strong = XHTML.elementNameFor("strong");
		Name style = XHTML.elementNameFor("style");
		Name sub = XHTML.elementNameFor("sub");
		Name sup = XHTML.elementNameFor("sup");
		Name table = XHTML.elementNameFor("table");
		Name tbody = XHTML.elementNameFor("tbody");
		Name td = XHTML.elementNameFor("td");
		Name textarea = XHTML.elementNameFor("textarea");
		Name tfoot = XHTML.elementNameFor("tfoot");
		Name th = XHTML.elementNameFor("th");
		Name thead = XHTML.elementNameFor("thead");
		Name title = XHTML.elementNameFor("title");
		Name tr = XHTML.elementNameFor("tr");
		Name tt = XHTML.elementNameFor("tt");
		Name ul = XHTML.elementNameFor("ul");
		Name var = XHTML.elementNameFor("var");


		AttributeDef a_abbr = new AttributeDef(XHTML.attributeNameFor("abbr"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_accept = new AttributeDef(XHTML.attributeNameFor("accept"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_accept_charset = new AttributeDef(XHTML.attributeNameFor("accept-charset"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_accesskey = new AttributeDef(XHTML.attributeNameFor("accesskey"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_action = new AttributeDef(XHTML.attributeNameFor("action"), AttributeDef.CDATA_TYPE, true);
		AttributeDef a_align = new AttributeDef(XHTML.attributeNameFor("align"), AttributeDef.ENUMERATION_TYPE,
				Arrays.asList(new AttValue[] {
						XHTML.attributeValueFor("left"), XHTML.attributeValueFor("center"), XHTML.attributeValueFor("right"), XHTML.attributeValueFor("justify"),
						XHTML.attributeValueFor("char")}), false);
		AttributeDef a_alt2 = new AttributeDef(XHTML.attributeNameFor("alt"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_alt = new AttributeDef(XHTML.attributeNameFor("alt"), AttributeDef.CDATA_TYPE, true);
		AttributeDef a_archive = new AttributeDef(XHTML.attributeNameFor("archive"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_axis = new AttributeDef(XHTML.attributeNameFor("axis"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_border = new AttributeDef(XHTML.attributeNameFor("border"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_cellpadding = new AttributeDef(XHTML.attributeNameFor("cellpadding"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_cellspacing = new AttributeDef(XHTML.attributeNameFor("cellspacing"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_char = new AttributeDef(XHTML.attributeNameFor("char"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_charoff = new AttributeDef(XHTML.attributeNameFor("charoff"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_charset = new AttributeDef(XHTML.attributeNameFor("charset"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_checked = new AttributeDef(XHTML.attributeNameFor("checked"), AttributeDef.ENUMERATION_TYPE,
				Arrays.asList(new AttValue[] {
						XHTML.attributeValueFor("checked")}), false);
		AttributeDef a_cite = new AttributeDef(XHTML.attributeNameFor("cite"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_class = new AttributeDef(XHTML.attributeNameFor("class"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_classid = new AttributeDef(XHTML.attributeNameFor("classid"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_codebase = new AttributeDef(XHTML.attributeNameFor("codebase"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_codetype = new AttributeDef(XHTML.attributeNameFor("codetype"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_cols = new AttributeDef(XHTML.attributeNameFor("cols"), AttributeDef.CDATA_TYPE, true);
		AttributeDef a_colspan = new AttributeDef(XHTML.attributeNameFor("colspan"), AttributeDef.CDATA_TYPE, XHTML.attributeValueFor("1"), false);
		AttributeDef a_content = new AttributeDef(XHTML.attributeNameFor("content"), AttributeDef.CDATA_TYPE, true);
		AttributeDef a_coords = new AttributeDef(XHTML.attributeNameFor("coords"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_data = new AttributeDef(XHTML.attributeNameFor("data"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_datetime = new AttributeDef(XHTML.attributeNameFor("datetime"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_declare = new AttributeDef(XHTML.attributeNameFor("declare"), AttributeDef.ENUMERATION_TYPE,
				Arrays.asList(new AttValue[] {
						XHTML.attributeValueFor("declare")}), false);
		AttributeDef a_defer = new AttributeDef(XHTML.attributeNameFor("defer"), AttributeDef.ENUMERATION_TYPE,
				Arrays.asList(new AttValue[] {
						XHTML.attributeValueFor("defer")}), false);
		AttributeDef a_dir = new AttributeDef(XHTML.attributeNameFor("dir"), AttributeDef.ENUMERATION_TYPE,
				Arrays.asList(new AttValue[] {
						XHTML.attributeValueFor("ltr"), XHTML.attributeValueFor("rtl")}), false);
		AttributeDef a_dir2 = new AttributeDef(XHTML.attributeNameFor("dir"), AttributeDef.ENUMERATION_TYPE,
				Arrays.asList(new AttValue[] {
						XHTML.attributeValueFor("ltr"), XHTML.attributeValueFor("rtl")}), true);
		AttributeDef a_disabled = new AttributeDef(XHTML.attributeNameFor("disabled"), AttributeDef.ENUMERATION_TYPE,
				Arrays.asList(new AttValue[] {
						XHTML.attributeValueFor("disabled")}), false);
		AttributeDef a_enctype = new AttributeDef(XHTML.attributeNameFor("enctype"), AttributeDef.CDATA_TYPE, XHTML.attributeValueFor("application/x-www-form-urlencoded"), false);
		AttributeDef a_for = new AttributeDef(XHTML.attributeNameFor("for"), AttributeDef.IDREF_TYPE, false);
		AttributeDef a_frame = new AttributeDef(XHTML.attributeNameFor("frame"), AttributeDef.ENUMERATION_TYPE,
				Arrays.asList(new AttValue[] {
						XHTML.attributeValueFor("void"), XHTML.attributeValueFor("above"), XHTML.attributeValueFor("below"), XHTML.attributeValueFor("hsides"),
						XHTML.attributeValueFor("lhs"), XHTML.attributeValueFor("rhs"), XHTML.attributeValueFor("vsides"), XHTML.attributeValueFor("box"),
						XHTML.attributeValueFor("border")}), false);
		AttributeDef a_headers = new AttributeDef(XHTML.attributeNameFor("headers"), AttributeDef.IDREFS_TYPE, false);
		AttributeDef a_height = new AttributeDef(XHTML.attributeNameFor("height"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_href2 = new AttributeDef(XHTML.attributeNameFor("href"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_href = new AttributeDef(XHTML.attributeNameFor("href"), AttributeDef.CDATA_TYPE, true);
		AttributeDef a_hreflang = new AttributeDef(XHTML.attributeNameFor("hreflang"), AttributeDef.NMTOKEN_TYPE, false);
		AttributeDef a_http_equiv = new AttributeDef(XHTML.attributeNameFor("http-equiv"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_id = new AttributeDef(XHTML.attributeNameFor("id"), AttributeDef.ID_TYPE, false);
		AttributeDef a_id2 = new AttributeDef(XHTML.attributeNameFor("id"), AttributeDef.ID_TYPE, true);
		AttributeDef a_ismap = new AttributeDef(XHTML.attributeNameFor("ismap"), AttributeDef.ENUMERATION_TYPE,
				Arrays.asList(new AttValue[] {
						XHTML.attributeValueFor("ismap")}), false);
		AttributeDef a_label2 = new AttributeDef(XHTML.attributeNameFor("label"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_label = new AttributeDef(XHTML.attributeNameFor("label"), AttributeDef.CDATA_TYPE, true);
		AttributeDef a_lang = new AttributeDef(XHTML.attributeNameFor("lang"), AttributeDef.NMTOKEN_TYPE, false);
		AttributeDef a_longdesc = new AttributeDef(XHTML.attributeNameFor("longdesc"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_maxlength = new AttributeDef(XHTML.attributeNameFor("maxlength"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_media = new AttributeDef(XHTML.attributeNameFor("media"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_method = new AttributeDef(XHTML.attributeNameFor("method"), AttributeDef.ENUMERATION_TYPE,
				Arrays.asList(new AttValue[] {
						XHTML.attributeValueFor("get"), XHTML.attributeValueFor("post")}), XHTML.attributeValueFor("get"), false);
		AttributeDef a_multiple = new AttributeDef(XHTML.attributeNameFor("multiple"), AttributeDef.ENUMERATION_TYPE,
				Arrays.asList(new AttValue[] {
						XHTML.attributeValueFor("multiple")}), false);
		AttributeDef a_name = new AttributeDef(XHTML.attributeNameFor("name"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_name2 = new AttributeDef(XHTML.attributeNameFor("name"), AttributeDef.NMTOKEN_TYPE, false);
		AttributeDef a_nohref = new AttributeDef(XHTML.attributeNameFor("nohref"), AttributeDef.ENUMERATION_TYPE,
				Arrays.asList(new AttValue[] {
						XHTML.attributeValueFor("nohref")}), false);
		AttributeDef a_onblur = new AttributeDef(XHTML.attributeNameFor("onblur"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_onchange = new AttributeDef(XHTML.attributeNameFor("onchange"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_onclick = new AttributeDef(XHTML.attributeNameFor("onclick"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_ondblclick = new AttributeDef(XHTML.attributeNameFor("ondblclick"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_onfocus = new AttributeDef(XHTML.attributeNameFor("onfocus"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_onkeydown = new AttributeDef(XHTML.attributeNameFor("onkeydown"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_onkeypress = new AttributeDef(XHTML.attributeNameFor("onkeypress"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_onkeyup = new AttributeDef(XHTML.attributeNameFor("onkeyup"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_onload = new AttributeDef(XHTML.attributeNameFor("onload"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_onmousedown = new AttributeDef(XHTML.attributeNameFor("onmousedown"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_onmousemove = new AttributeDef(XHTML.attributeNameFor("onmousemove"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_onmouseout = new AttributeDef(XHTML.attributeNameFor("onmouseout"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_onmouseover = new AttributeDef(XHTML.attributeNameFor("onmouseover"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_onmouseup = new AttributeDef(XHTML.attributeNameFor("onmouseup"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_onreset = new AttributeDef(XHTML.attributeNameFor("onreset"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_onselect = new AttributeDef(XHTML.attributeNameFor("onselect"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_onsubmit = new AttributeDef(XHTML.attributeNameFor("onsubmit"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_onunload = new AttributeDef(XHTML.attributeNameFor("onunload"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_profile = new AttributeDef(XHTML.attributeNameFor("profile"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_readonly = new AttributeDef(XHTML.attributeNameFor("readonly"), AttributeDef.ENUMERATION_TYPE,
				Arrays.asList(new AttValue[] {
						XHTML.attributeValueFor("readonly")}), false);
		AttributeDef a_rel = new AttributeDef(XHTML.attributeNameFor("rel"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_rev = new AttributeDef(XHTML.attributeNameFor("rev"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_rows = new AttributeDef(XHTML.attributeNameFor("rows"), AttributeDef.CDATA_TYPE, true);
		AttributeDef a_rowspan = new AttributeDef(XHTML.attributeNameFor("rowspan"), AttributeDef.CDATA_TYPE, XHTML.attributeValueFor("1"), false);
		AttributeDef a_rules = new AttributeDef(XHTML.attributeNameFor("rules"), AttributeDef.ENUMERATION_TYPE,
				Arrays.asList(new AttValue[] {
						XHTML.attributeValueFor("none"), XHTML.attributeValueFor("groups"), XHTML.attributeValueFor("rows"), XHTML.attributeValueFor("cols"),
						XHTML.attributeValueFor("all")}), false);
		AttributeDef a_scheme = new AttributeDef(XHTML.attributeNameFor("scheme"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_scope = new AttributeDef(XHTML.attributeNameFor("scope"), AttributeDef.ENUMERATION_TYPE,
				Arrays.asList(new AttValue[] {
						XHTML.attributeValueFor("row"), XHTML.attributeValueFor("col"), XHTML.attributeValueFor("rowgroup"), XHTML.attributeValueFor("colgroup")}), false);
		AttributeDef a_selected = new AttributeDef(XHTML.attributeNameFor("selected"), AttributeDef.ENUMERATION_TYPE,
				Arrays.asList(new AttValue[] {
						XHTML.attributeValueFor("selected")}), false);
		AttributeDef a_shape = new AttributeDef(XHTML.attributeNameFor("shape"), AttributeDef.ENUMERATION_TYPE,
				Arrays.asList(new AttValue[] {
						XHTML.attributeValueFor("rect"), XHTML.attributeValueFor("circle"), XHTML.attributeValueFor("poly"), XHTML.attributeValueFor("default")}), XHTML.attributeValueFor("rect"), false);
		AttributeDef a_size = new AttributeDef(XHTML.attributeNameFor("size"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_span = new AttributeDef(XHTML.attributeNameFor("span"), AttributeDef.CDATA_TYPE, XHTML.attributeValueFor("1"), false);
		AttributeDef a_src = new AttributeDef(XHTML.attributeNameFor("src"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_src2 = new AttributeDef(XHTML.attributeNameFor("src"), AttributeDef.CDATA_TYPE, true);
		AttributeDef a_standby = new AttributeDef(XHTML.attributeNameFor("standby"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_style = new AttributeDef(XHTML.attributeNameFor("style"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_summary = new AttributeDef(XHTML.attributeNameFor("summary"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_tabindex = new AttributeDef(XHTML.attributeNameFor("tabindex"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_title = new AttributeDef(XHTML.attributeNameFor("title"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_type4 = new AttributeDef(XHTML.attributeNameFor("type"), AttributeDef.ENUMERATION_TYPE,
				Arrays.asList(new AttValue[] {
						XHTML.attributeValueFor("button"), XHTML.attributeValueFor("submit"), XHTML.attributeValueFor("reset")}), XHTML.attributeValueFor("submit"), false);
		AttributeDef a_type3 = new AttributeDef(XHTML.attributeNameFor("type"), AttributeDef.ENUMERATION_TYPE,
				Arrays.asList(new AttValue[] {
						XHTML.attributeValueFor("text"), XHTML.attributeValueFor("password"), XHTML.attributeValueFor("checkbox"), XHTML.attributeValueFor("radio"),
						XHTML.attributeValueFor("submit"), XHTML.attributeValueFor("reset"), XHTML.attributeValueFor("file"), XHTML.attributeValueFor("hidden"),
						XHTML.attributeValueFor("image"), XHTML.attributeValueFor("button")}), XHTML.attributeValueFor("text"), false);
		AttributeDef a_type = new AttributeDef(XHTML.attributeNameFor("type"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_type2 = new AttributeDef(XHTML.attributeNameFor("type"), AttributeDef.CDATA_TYPE, true);
		AttributeDef a_usemap = new AttributeDef(XHTML.attributeNameFor("usemap"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_valign = new AttributeDef(XHTML.attributeNameFor("valign"), AttributeDef.ENUMERATION_TYPE,
				Arrays.asList(new AttValue[] {
						XHTML.attributeValueFor("top"), XHTML.attributeValueFor("middle"), XHTML.attributeValueFor("bottom"), XHTML.attributeValueFor("baseline")}), false);
		AttributeDef a_value = new AttributeDef(XHTML.attributeNameFor("value"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_valuetype = new AttributeDef(XHTML.attributeNameFor("valuetype"), AttributeDef.ENUMERATION_TYPE,
				Arrays.asList(new AttValue[] {
						XHTML.attributeValueFor("data"), XHTML.attributeValueFor("ref"), XHTML.attributeValueFor("object")}), XHTML.attributeValueFor("data"), false);
		AttributeDef a_width = new AttributeDef(XHTML.attributeNameFor("width"), AttributeDef.CDATA_TYPE, false);
		AttributeDef a_xml_lang = new AttributeDef(XHTML.attributeNameFor("xml:lang"), AttributeDef.NMTOKEN_TYPE, false);
		AttributeDef a_xml_space = new AttributeDef(XHTML.attributeNameFor("xml:space"), AttributeDef.ENUMERATION_TYPE,
				Arrays.asList(new AttValue[] {
						XHTML.attributeValueFor("preserve")}), XHTML.attributeValueFor("preserve"), true);
		AttributeDef a_xmlns = new AttributeDef(XHTML.attributeNameFor("xmlns"), AttributeDef.CDATA_TYPE, XHTML.attributeValueFor("http://www.w3.org/1999/xhtml"), true);
		

		addElementType(new ElementType( a,
				new MixedContentModel(Arrays.asList(new Name[] {
						br, span, bdo, map, object, img, tt, i, b, big,
						small, em, strong, dfn, code, q, samp, kbd, var, cite,
						abbr, acronym, sub, sup, input, select, textarea, label, button, ins,
						del, script})),
						Arrays.asList(new AttributeDef[] {
								a_accesskey, a_charset, a_class, a_coords, a_dir, a_href2, a_hreflang,
								a_id, a_lang, a_name2, a_onblur, a_onclick, a_ondblclick, a_onfocus,
								a_onkeydown, a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover,
								a_onmouseup, a_rel, a_rev, a_shape, a_style, a_tabindex, a_title,
								a_type, a_xml_lang}), null));

		addElementType(new ElementType( abbr,
				new MixedContentModel(Arrays.asList(new Name[] {
						a, br, span, bdo, map, object, img, tt, i, b,
						big, small, em, strong, dfn, code, q, samp, kbd, var,
						cite, abbr, acronym, sub, sup, input, select, textarea, label, button,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( acronym,
				new MixedContentModel(Arrays.asList(new Name[] {
						a, br, span, bdo, map, object, img, tt, i, b,
						big, small, em, strong, dfn, code, q, samp, kbd, var,
						cite, abbr, acronym, sub, sup, input, select, textarea, label, button,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( address,
				new MixedContentModel(Arrays.asList(new Name[] {
						a, br, span, bdo, map, object, img, tt, i, b,
						big, small, em, strong, dfn, code, q, samp, kbd, var,
						cite, abbr, acronym, sub, sup, input, select, textarea, label, button,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( area,
				ContentModel.EMPTY,
				Arrays.asList(new AttributeDef[] {
						a_accesskey, a_alt, a_class, a_coords, a_dir, a_href2, a_id,
						a_lang, a_nohref, a_onblur, a_onclick, a_ondblclick, a_onfocus, a_onkeydown,
						a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
						a_shape, a_style, a_tabindex, a_title, a_xml_lang}), null));

		addElementType(new ElementType( b,
				new MixedContentModel(Arrays.asList(new Name[] {
						a, br, span, bdo, map, object, img, tt, i, b,
						big, small, em, strong, dfn, code, q, samp, kbd, var,
						cite, abbr, acronym, sub, sup, input, select, textarea, label, button,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( base,
				ContentModel.EMPTY,
				Arrays.asList(new AttributeDef[] {
						a_href, a_id}), null));

		addElementType(new ElementType( bdo,
				new MixedContentModel(Arrays.asList(new Name[] {
						a, br, span, bdo, map, object, img, tt, i, b,
						big, small, em, strong, dfn, code, q, samp, kbd, var,
						cite, abbr, acronym, sub, sup, input, select, textarea, label, button,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir2, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( big,
				new MixedContentModel(Arrays.asList(new Name[] {
						a, br, span, bdo, map, object, img, tt, i, b,
						big, small, em, strong, dfn, code, q, samp, kbd, var,
						cite, abbr, acronym, sub, sup, input, select, textarea, label, button,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( blockquote,
				theGrammarParser.parseGrammar(
				"(p|h1|h2|h3|h4|h5|h6|div|ul|ol|dl|pre|hr|blockquote|address|fieldset|table|form|noscript|ins|del|script)*"),
				Arrays.asList(new AttributeDef[] {
						a_cite, a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick,
						a_onkeydown, a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover,
						a_onmouseup, a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( body,
				theGrammarParser.parseGrammar(
				"(p|h1|h2|h3|h4|h5|h6|div|ul|ol|dl|pre|hr|blockquote|address|fieldset|table|form|noscript|ins|del|script)*"),
				Arrays.asList(new AttributeDef[] {
						a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
						a_onkeypress, a_onkeyup, a_onload, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover,
						a_onmouseup, a_onunload, a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( br,
				ContentModel.EMPTY,
				Arrays.asList(new AttributeDef[] {
						a_class, a_id, a_style, a_title}), null));

		addElementType(new ElementType( button,
				new MixedContentModel(Arrays.asList(new Name[] {
						p, h1, h2, h3, h4, h5, h6, div, ul, ol,
						dl, pre, hr, blockquote, address, table, br, span, bdo, map,
						object, img, tt, i, b, big, small, em, strong, dfn,
						code, q, samp, kbd, var, cite, abbr, acronym, sub, sup,
						noscript, ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_accesskey, a_class, a_dir, a_disabled, a_id, a_lang, a_name,
								a_onblur, a_onclick, a_ondblclick, a_onfocus, a_onkeydown, a_onkeypress, a_onkeyup,
								a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup, a_style, a_tabindex,
								a_title, a_type4, a_value, a_xml_lang}), null));

		addElementType(new ElementType( caption,
				new MixedContentModel(Arrays.asList(new Name[] {
						a, br, span, bdo, map, object, img, tt, i, b,
						big, small, em, strong, dfn, code, q, samp, kbd, var,
						cite, abbr, acronym, sub, sup, input, select, textarea, label, button,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( cite,
				new MixedContentModel(Arrays.asList(new Name[] {
						a, br, span, bdo, map, object, img, tt, i, b,
						big, small, em, strong, dfn, code, q, samp, kbd, var,
						cite, abbr, acronym, sub, sup, input, select, textarea, label, button,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( code,
				new MixedContentModel(Arrays.asList(new Name[] {
						a, br, span, bdo, map, object, img, tt, i, b,
						big, small, em, strong, dfn, code, q, samp, kbd, var,
						cite, abbr, acronym, sub, sup, input, select, textarea, label, button,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( col,
				ContentModel.EMPTY,
				Arrays.asList(new AttributeDef[] {
						a_align, a_char, a_charoff, a_class, a_dir, a_id, a_lang,
						a_onclick, a_ondblclick, a_onkeydown, a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove,
						a_onmouseout, a_onmouseover, a_onmouseup, a_span, a_style, a_title, a_valign,
						a_width, a_xml_lang}), null));

		addElementType(new ElementType( colgroup,
				theGrammarParser.parseGrammar(
				"(col)*"),
				Arrays.asList(new AttributeDef[] {
						a_align, a_char, a_charoff, a_class, a_dir, a_id, a_lang,
						a_onclick, a_ondblclick, a_onkeydown, a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove,
						a_onmouseout, a_onmouseover, a_onmouseup, a_span, a_style, a_title, a_valign,
						a_width, a_xml_lang}), null));

		addElementType(new ElementType( dd,
				new MixedContentModel(Arrays.asList(new Name[] {
						p, h1, h2, h3, h4, h5, h6, div, ul, ol,
						dl, pre, hr, blockquote, address, fieldset, table, form, a, br,
						span, bdo, map, object, img, tt, i, b, big, small,
						em, strong, dfn, code, q, samp, kbd, var, cite, abbr,
						acronym, sub, sup, input, select, textarea, label, button, noscript, ins,
						del, script})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( del,
				new MixedContentModel(Arrays.asList(new Name[] {
						p, h1, h2, h3, h4, h5, h6, div, ul, ol,
						dl, pre, hr, blockquote, address, fieldset, table, form, a, br,
						span, bdo, map, object, img, tt, i, b, big, small,
						em, strong, dfn, code, q, samp, kbd, var, cite, abbr,
						acronym, sub, sup, input, select, textarea, label, button, noscript, ins,
						del, script})),
						Arrays.asList(new AttributeDef[] {
								a_cite, a_class, a_datetime, a_dir, a_id, a_lang, a_onclick,
								a_ondblclick, a_onkeydown, a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout,
								a_onmouseover, a_onmouseup, a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( dfn,
				new MixedContentModel(Arrays.asList(new Name[] {
						a, br, span, bdo, map, object, img, tt, i, b,
						big, small, em, strong, dfn, code, q, samp, kbd, var,
						cite, abbr, acronym, sub, sup, input, select, textarea, label, button,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( div,
				new MixedContentModel(Arrays.asList(new Name[] {
						p, h1, h2, h3, h4, h5, h6, div, ul, ol,
						dl, pre, hr, blockquote, address, fieldset, table, form, a, br,
						span, bdo, map, object, img, tt, i, b, big, small,
						em, strong, dfn, code, q, samp, kbd, var, cite, abbr,
						acronym, sub, sup, input, select, textarea, label, button, noscript, ins,
						del, script})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( dl,
				theGrammarParser.parseGrammar(
				"(dt|dd)+"),
				Arrays.asList(new AttributeDef[] {
						a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
						a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
						a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( dt,
				new MixedContentModel(Arrays.asList(new Name[] {
						a, br, span, bdo, map, object, img, tt, i, b,
						big, small, em, strong, dfn, code, q, samp, kbd, var,
						cite, abbr, acronym, sub, sup, input, select, textarea, label, button,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( em,
				new MixedContentModel(Arrays.asList(new Name[] {
						a, br, span, bdo, map, object, img, tt, i, b,
						big, small, em, strong, dfn, code, q, samp, kbd, var,
						cite, abbr, acronym, sub, sup, input, select, textarea, label, button,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( fieldset,
				new MixedContentModel(Arrays.asList(new Name[] {
						legend, p, h1, h2, h3, h4, h5, h6, div, ul,
						ol, dl, pre, hr, blockquote, address, fieldset, table, form, a,
						br, span, bdo, map, object, img, tt, i, b, big,
						small, em, strong, dfn, code, q, samp, kbd, var, cite,
						abbr, acronym, sub, sup, input, select, textarea, label, button, noscript,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( form,
				theGrammarParser.parseGrammar(
				"(p|h1|h2|h3|h4|h5|h6|div|ul|ol|dl|pre|hr|blockquote|address|fieldset|table|noscript|ins|del|script)*"),
				Arrays.asList(new AttributeDef[] {
						a_accept, a_accept_charset, a_action, a_class, a_dir, a_enctype, a_id,
						a_lang, a_method, a_onclick, a_ondblclick, a_onkeydown, a_onkeypress, a_onkeyup,
						a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup, a_onreset, a_onsubmit,
						a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( h1,
				new MixedContentModel(Arrays.asList(new Name[] {
						a, br, span, bdo, map, object, img, tt, i, b,
						big, small, em, strong, dfn, code, q, samp, kbd, var,
						cite, abbr, acronym, sub, sup, input, select, textarea, label, button,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( h2,
				new MixedContentModel(Arrays.asList(new Name[] {
						a, br, span, bdo, map, object, img, tt, i, b,
						big, small, em, strong, dfn, code, q, samp, kbd, var,
						cite, abbr, acronym, sub, sup, input, select, textarea, label, button,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( h3,
				new MixedContentModel(Arrays.asList(new Name[] {
						a, br, span, bdo, map, object, img, tt, i, b,
						big, small, em, strong, dfn, code, q, samp, kbd, var,
						cite, abbr, acronym, sub, sup, input, select, textarea, label, button,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( h4,
				new MixedContentModel(Arrays.asList(new Name[] {
						a, br, span, bdo, map, object, img, tt, i, b,
						big, small, em, strong, dfn, code, q, samp, kbd, var,
						cite, abbr, acronym, sub, sup, input, select, textarea, label, button,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( h5,
				new MixedContentModel(Arrays.asList(new Name[] {
						a, br, span, bdo, map, object, img, tt, i, b,
						big, small, em, strong, dfn, code, q, samp, kbd, var,
						cite, abbr, acronym, sub, sup, input, select, textarea, label, button,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( h6,
				new MixedContentModel(Arrays.asList(new Name[] {
						a, br, span, bdo, map, object, img, tt, i, b,
						big, small, em, strong, dfn, code, q, samp, kbd, var,
						cite, abbr, acronym, sub, sup, input, select, textarea, label, button,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( head,
				theGrammarParser.parseGrammar(
				"((script|style|meta|link|object)*,((title,(script|style|meta|link|object)*,(base,(script|style|meta|link|object)*)?)|(base,(script|style|meta|link|object)*,(title,(script|style|meta|link|object)*))))"),
				Arrays.asList(new AttributeDef[] {
						a_dir, a_id, a_lang, a_profile, a_xml_lang}), null));

		addElementType(new ElementType( hr,
				ContentModel.EMPTY,
				Arrays.asList(new AttributeDef[] {
						a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
						a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
						a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( html,
				theGrammarParser.parseGrammar(
				"(head,body)"),
				Arrays.asList(new AttributeDef[] {
						a_dir, a_id, a_lang, a_xml_lang, a_xmlns}), null));

		addElementType(new ElementType( i,
				new MixedContentModel(Arrays.asList(new Name[] {
						a, br, span, bdo, map, object, img, tt, i, b,
						big, small, em, strong, dfn, code, q, samp, kbd, var,
						cite, abbr, acronym, sub, sup, input, select, textarea, label, button,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( img,
				ContentModel.EMPTY,
				Arrays.asList(new AttributeDef[] {
						a_alt, a_class, a_dir, a_height, a_id, a_ismap, a_lang,
						a_longdesc, a_onclick, a_ondblclick, a_onkeydown, a_onkeypress, a_onkeyup, a_onmousedown,
						a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup, a_src2, a_style, a_title,
						a_usemap, a_width, a_xml_lang}), null));

		addElementType(new ElementType( input,
				ContentModel.EMPTY,
				Arrays.asList(new AttributeDef[] {
						a_accept, a_accesskey, a_alt2, a_checked, a_class, a_dir, a_disabled,
						a_id, a_lang, a_maxlength, a_name, a_onblur, a_onchange, a_onclick,
						a_ondblclick, a_onfocus, a_onkeydown, a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove,
						a_onmouseout, a_onmouseover, a_onmouseup, a_onselect, a_readonly, a_size, a_src,
						a_style, a_tabindex, a_title, a_type3, a_usemap, a_value, a_xml_lang}), null));

		addElementType(new ElementType( ins,
				new MixedContentModel(Arrays.asList(new Name[] {
						p, h1, h2, h3, h4, h5, h6, div, ul, ol,
						dl, pre, hr, blockquote, address, fieldset, table, form, a, br,
						span, bdo, map, object, img, tt, i, b, big, small,
						em, strong, dfn, code, q, samp, kbd, var, cite, abbr,
						acronym, sub, sup, input, select, textarea, label, button, noscript, ins,
						del, script})),
						Arrays.asList(new AttributeDef[] {
								a_cite, a_class, a_datetime, a_dir, a_id, a_lang, a_onclick,
								a_ondblclick, a_onkeydown, a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout,
								a_onmouseover, a_onmouseup, a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( kbd,
				new MixedContentModel(Arrays.asList(new Name[] {
						a, br, span, bdo, map, object, img, tt, i, b,
						big, small, em, strong, dfn, code, q, samp, kbd, var,
						cite, abbr, acronym, sub, sup, input, select, textarea, label, button,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( label,
				new MixedContentModel(Arrays.asList(new Name[] {
						a, br, span, bdo, map, object, img, tt, i, b,
						big, small, em, strong, dfn, code, q, samp, kbd, var,
						cite, abbr, acronym, sub, sup, input, select, textarea, label, button,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_accesskey, a_class, a_dir, a_for, a_id, a_lang, a_onblur,
								a_onclick, a_ondblclick, a_onfocus, a_onkeydown, a_onkeypress, a_onkeyup, a_onmousedown,
								a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup, a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( legend,
				new MixedContentModel(Arrays.asList(new Name[] {
						a, br, span, bdo, map, object, img, tt, i, b,
						big, small, em, strong, dfn, code, q, samp, kbd, var,
						cite, abbr, acronym, sub, sup, input, select, textarea, label, button,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_accesskey, a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick,
								a_onkeydown, a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover,
								a_onmouseup, a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( li,
				new MixedContentModel(Arrays.asList(new Name[] {
						p, h1, h2, h3, h4, h5, h6, div, ul, ol,
						dl, pre, hr, blockquote, address, fieldset, table, form, a, br,
						span, bdo, map, object, img, tt, i, b, big, small,
						em, strong, dfn, code, q, samp, kbd, var, cite, abbr,
						acronym, sub, sup, input, select, textarea, label, button, noscript, ins,
						del, script})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( link,
				ContentModel.EMPTY,
				Arrays.asList(new AttributeDef[] {
						a_charset, a_class, a_dir, a_href2, a_hreflang, a_id, a_lang,
						a_media, a_onclick, a_ondblclick, a_onkeydown, a_onkeypress, a_onkeyup, a_onmousedown,
						a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup, a_rel, a_rev, a_style,
						a_title, a_type, a_xml_lang}), null));

		addElementType(new ElementType( map,
				theGrammarParser.parseGrammar(
				"((p|h1|h2|h3|h4|h5|h6|div|ul|ol|dl|pre|hr|blockquote|address|fieldset|table|form|noscript|ins|del|script)+|area+)"),
				Arrays.asList(new AttributeDef[] {
						a_class, a_dir, a_id2, a_lang, a_name2, a_onclick, a_ondblclick,
						a_onkeydown, a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover,
						a_onmouseup, a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( meta,
				ContentModel.EMPTY,
				Arrays.asList(new AttributeDef[] {
						a_content, a_dir, a_http_equiv, a_id, a_lang, a_name, a_scheme,
						a_xml_lang}), null));

		addElementType(new ElementType( noscript,
				theGrammarParser.parseGrammar(
				"(p|h1|h2|h3|h4|h5|h6|div|ul|ol|dl|pre|hr|blockquote|address|fieldset|table|form|noscript|ins|del|script)*"),
				Arrays.asList(new AttributeDef[] {
						a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
						a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
						a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( object,
				new MixedContentModel(Arrays.asList(new Name[] {
						param, p, h1, h2, h3, h4, h5, h6, div, ul,
						ol, dl, pre, hr, blockquote, address, fieldset, table, form, a,
						br, span, bdo, map, object, img, tt, i, b, big,
						small, em, strong, dfn, code, q, samp, kbd, var, cite,
						abbr, acronym, sub, sup, input, select, textarea, label, button, noscript,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_archive, a_class, a_classid, a_codebase, a_codetype, a_data, a_declare,
								a_dir, a_height, a_id, a_lang, a_name2, a_onclick, a_ondblclick,
								a_onkeydown, a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover,
								a_onmouseup, a_standby, a_style, a_tabindex, a_title, a_type, a_usemap,
								a_width, a_xml_lang}), null));

		addElementType(new ElementType( ol,
				theGrammarParser.parseGrammar(
				"(li)+"),
				Arrays.asList(new AttributeDef[] {
						a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
						a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
						a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( optgroup,
				theGrammarParser.parseGrammar(
				"(option)+"),
				Arrays.asList(new AttributeDef[] {
						a_class, a_dir, a_disabled, a_id, a_label, a_lang, a_onclick,
						a_ondblclick, a_onkeydown, a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout,
						a_onmouseover, a_onmouseup, a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( option,
				new MixedContentModel(Arrays.asList(new Name[] {
				})),
				Arrays.asList(new AttributeDef[] {
						a_class, a_dir, a_disabled, a_id, a_label2, a_lang, a_onclick,
						a_ondblclick, a_onkeydown, a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout,
						a_onmouseover, a_onmouseup, a_selected, a_style, a_title, a_value, a_xml_lang}), null));

		addElementType(new ElementType( p,
				new MixedContentModel(Arrays.asList(new Name[] {
						a, br, span, bdo, map, object, img, tt, i, b,
						big, small, em, strong, dfn, code, q, samp, kbd, var,
						cite, abbr, acronym, sub, sup, input, select, textarea, label, button,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( param,
				ContentModel.EMPTY,
				Arrays.asList(new AttributeDef[] {
						a_id, a_name, a_type, a_value, a_valuetype}), null));

		addElementType(new ElementType( pre,
				new MixedContentModel(Arrays.asList(new Name[] {
						a, tt, i, b, big, small, em, strong, dfn, code,
						q, samp, kbd, var, cite, abbr, acronym, sub, sup, br,
						span, bdo, map, ins, del, script, input, select, textarea, label,
						button})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang, a_xml_space}), null));

		addElementType(new ElementType( q,
				new MixedContentModel(Arrays.asList(new Name[] {
						a, br, span, bdo, map, object, img, tt, i, b,
						big, small, em, strong, dfn, code, q, samp, kbd, var,
						cite, abbr, acronym, sub, sup, input, select, textarea, label, button,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_cite, a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick,
								a_onkeydown, a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover,
								a_onmouseup, a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( samp,
				new MixedContentModel(Arrays.asList(new Name[] {
						a, br, span, bdo, map, object, img, tt, i, b,
						big, small, em, strong, dfn, code, q, samp, kbd, var,
						cite, abbr, acronym, sub, sup, input, select, textarea, label, button,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( script,
				new MixedContentModel(Arrays.asList(new Name[] {
				})),
				Arrays.asList(new AttributeDef[] {
						a_charset, a_defer, a_id, a_src, a_type2, a_xml_space}), null));

		addElementType(new ElementType( select,
				theGrammarParser.parseGrammar(
				"(optgroup|option)+"),
				Arrays.asList(new AttributeDef[] {
						a_class, a_dir, a_disabled, a_id, a_lang, a_multiple, a_name,
						a_onblur, a_onchange, a_onclick, a_ondblclick, a_onfocus, a_onkeydown, a_onkeypress,
						a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup, a_size,
						a_style, a_tabindex, a_title, a_xml_lang}), null));

		addElementType(new ElementType( small,
				new MixedContentModel(Arrays.asList(new Name[] {
						a, br, span, bdo, map, object, img, tt, i, b,
						big, small, em, strong, dfn, code, q, samp, kbd, var,
						cite, abbr, acronym, sub, sup, input, select, textarea, label, button,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( span,
				new MixedContentModel(Arrays.asList(new Name[] {
						a, br, span, bdo, map, object, img, tt, i, b,
						big, small, em, strong, dfn, code, q, samp, kbd, var,
						cite, abbr, acronym, sub, sup, input, select, textarea, label, button,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( strong,
				new MixedContentModel(Arrays.asList(new Name[] {
						a, br, span, bdo, map, object, img, tt, i, b,
						big, small, em, strong, dfn, code, q, samp, kbd, var,
						cite, abbr, acronym, sub, sup, input, select, textarea, label, button,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( style,
				new MixedContentModel(Arrays.asList(new Name[] {
				})),
				Arrays.asList(new AttributeDef[] {
						a_dir, a_id, a_lang, a_media, a_title, a_type2, a_xml_lang,
						a_xml_space}), null));

		addElementType(new ElementType( sub,
				new MixedContentModel(Arrays.asList(new Name[] {
						a, br, span, bdo, map, object, img, tt, i, b,
						big, small, em, strong, dfn, code, q, samp, kbd, var,
						cite, abbr, acronym, sub, sup, input, select, textarea, label, button,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( sup,
				new MixedContentModel(Arrays.asList(new Name[] {
						a, br, span, bdo, map, object, img, tt, i, b,
						big, small, em, strong, dfn, code, q, samp, kbd, var,
						cite, abbr, acronym, sub, sup, input, select, textarea, label, button,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( table,
				theGrammarParser.parseGrammar(
				"(caption?,(col*|colgroup*),thead?,tfoot?,(tbody+|tr+))"),
				Arrays.asList(new AttributeDef[] {
						a_border, a_cellpadding, a_cellspacing, a_class, a_dir, a_frame, a_id,
						a_lang, a_onclick, a_ondblclick, a_onkeydown, a_onkeypress, a_onkeyup, a_onmousedown,
						a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup, a_rules, a_style, a_summary,
						a_title, a_width, a_xml_lang}), null));

		addElementType(new ElementType( tbody,
				theGrammarParser.parseGrammar(
				"(tr)+"),
				Arrays.asList(new AttributeDef[] {
						a_align, a_char, a_charoff, a_class, a_dir, a_id, a_lang,
						a_onclick, a_ondblclick, a_onkeydown, a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove,
						a_onmouseout, a_onmouseover, a_onmouseup, a_style, a_title, a_valign, a_xml_lang}), null));

		addElementType(new ElementType( td,
				new MixedContentModel(Arrays.asList(new Name[] {
						p, h1, h2, h3, h4, h5, h6, div, ul, ol,
						dl, pre, hr, blockquote, address, fieldset, table, form, a, br,
						span, bdo, map, object, img, tt, i, b, big, small,
						em, strong, dfn, code, q, samp, kbd, var, cite, abbr,
						acronym, sub, sup, input, select, textarea, label, button, noscript, ins,
						del, script})),
						Arrays.asList(new AttributeDef[] {
								a_abbr, a_align, a_axis, a_char, a_charoff, a_class, a_colspan,
								a_dir, a_headers, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_rowspan, a_scope, a_style, a_title, a_valign, a_xml_lang}), null));

		addElementType(new ElementType( textarea,
				new MixedContentModel(Arrays.asList(new Name[] {
				})),
				Arrays.asList(new AttributeDef[] {
						a_accesskey, a_class, a_cols, a_dir, a_disabled, a_id, a_lang,
						a_name, a_onblur, a_onchange, a_onclick, a_ondblclick, a_onfocus, a_onkeydown,
						a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
						a_onselect, a_readonly, a_rows, a_style, a_tabindex, a_title, a_xml_lang}), null));

		addElementType(new ElementType( tfoot,
				theGrammarParser.parseGrammar(
				"(tr)+"),
				Arrays.asList(new AttributeDef[] {
						a_align, a_char, a_charoff, a_class, a_dir, a_id, a_lang,
						a_onclick, a_ondblclick, a_onkeydown, a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove,
						a_onmouseout, a_onmouseover, a_onmouseup, a_style, a_title, a_valign, a_xml_lang}), null));

		addElementType(new ElementType( th,
				new MixedContentModel(Arrays.asList(new Name[] {
						p, h1, h2, h3, h4, h5, h6, div, ul, ol,
						dl, pre, hr, blockquote, address, fieldset, table, form, a, br,
						span, bdo, map, object, img, tt, i, b, big, small,
						em, strong, dfn, code, q, samp, kbd, var, cite, abbr,
						acronym, sub, sup, input, select, textarea, label, button, noscript, ins,
						del, script})),
						Arrays.asList(new AttributeDef[] {
								a_abbr, a_align, a_axis, a_char, a_charoff, a_class, a_colspan,
								a_dir, a_headers, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_rowspan, a_scope, a_style, a_title, a_valign, a_xml_lang}), null));

		addElementType(new ElementType( thead,
				theGrammarParser.parseGrammar(
				"(tr)+"),
				Arrays.asList(new AttributeDef[] {
						a_align, a_char, a_charoff, a_class, a_dir, a_id, a_lang,
						a_onclick, a_ondblclick, a_onkeydown, a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove,
						a_onmouseout, a_onmouseover, a_onmouseup, a_style, a_title, a_valign, a_xml_lang}), null));

		addElementType(new ElementType( title,
				new MixedContentModel(Arrays.asList(new Name[] {
				})),
				Arrays.asList(new AttributeDef[] {
						a_dir, a_id, a_lang, a_xml_lang}), null));

		addElementType(new ElementType( tr,
				theGrammarParser.parseGrammar(
				"(th|td)+"),
				Arrays.asList(new AttributeDef[] {
						a_align, a_char, a_charoff, a_class, a_dir, a_id, a_lang,
						a_onclick, a_ondblclick, a_onkeydown, a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove,
						a_onmouseout, a_onmouseover, a_onmouseup, a_style, a_title, a_valign, a_xml_lang}), null));

		addElementType(new ElementType( tt,
				new MixedContentModel(Arrays.asList(new Name[] {
						a, br, span, bdo, map, object, img, tt, i, b,
						big, small, em, strong, dfn, code, q, samp, kbd, var,
						cite, abbr, acronym, sub, sup, input, select, textarea, label, button,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( ul,
				theGrammarParser.parseGrammar(
				"(li)+"),
				Arrays.asList(new AttributeDef[] {
						a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
						a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
						a_style, a_title, a_xml_lang}), null));

		addElementType(new ElementType( var,
				new MixedContentModel(Arrays.asList(new Name[] {
						a, br, span, bdo, map, object, img, tt, i, b,
						big, small, em, strong, dfn, code, q, samp, kbd, var,
						cite, abbr, acronym, sub, sup, input, select, textarea, label, button,
						ins, del, script})),
						Arrays.asList(new AttributeDef[] {
								a_class, a_dir, a_id, a_lang, a_onclick, a_ondblclick, a_onkeydown,
								a_onkeypress, a_onkeyup, a_onmousedown, a_onmousemove, a_onmouseout, a_onmouseover, a_onmouseup,
								a_style, a_title, a_xml_lang}), null));
		
		
		/* Element Prohibitions
		 -a must not contain other a elements.
		 -pre must not contain the img, object, big, small, sub, or sup elements.
		 -button must not contain the input, select, textarea, 
		 	label, button, form, fieldset, iframe or isindex elements.
		 -label must not contain other label elements.
		 -form must not contain other form elements.
		 */
		ElementType t = getElementType(XHTML.A);
		t.addDescendantProhibition(XHTML.A);
		
		t = getElementType(XHTML.PRE);
		t.addDescendantProhibition(XHTML.IMG);
		t.addDescendantProhibition(XHTML.OBJECT);
		t.addDescendantProhibition(XHTML.BIG);
		t.addDescendantProhibition(XHTML.SMALL);
		t.addDescendantProhibition(XHTML.SUB);
		t.addDescendantProhibition(XHTML.SUP);
		
		t = getElementType(XHTML.BUTTON);
		t.addDescendantProhibition(XHTML.INPUT);
		t.addDescendantProhibition(XHTML.SELECT);
		t.addDescendantProhibition(XHTML.TEXTAREA);
		t.addDescendantProhibition(XHTML.LABEL);
		t.addDescendantProhibition(XHTML.BUTTON);
		t.addDescendantProhibition(XHTML.FORM);
		t.addDescendantProhibition(XHTML.FIELDSET);
		t.addDescendantProhibition(XHTML.IFRAME);
		t.addDescendantProhibition(XHTML.ISINDEX);
		
		t = getElementType(XHTML.LABEL);
		t.addDescendantProhibition(XHTML.LABEL);
		
		t = getElementType(XHTML.FORM);
		t.addDescendantProhibition(XHTML.FORM);
	}

	// *** Interface Methods ***

	// *** Public Methods ***

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










/* end */