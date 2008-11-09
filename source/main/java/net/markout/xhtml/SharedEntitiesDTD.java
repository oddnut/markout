/*
	SharedEntitiesDTD.java
	
	Author: David Fogel
	
	Copyright 2004-2007 David Fogel
	
	All rights reserved.
*/

// *** package ***
package net.markout.xhtml;

// *** imports ***

import net.markout.dtd.InternalEntity;
import net.markout.dtd.StandardDTD;
import net.markout.types.EntityValue;
import net.markout.types.Name;

/**
 * SharedEntitiesDTD
 *
 * Comment here.  Author: David Fogel
 */
class SharedEntitiesDTD extends StandardDTD {
	// *** Class Members ***

	// *** Instance Members ***

	// *** Constructors ***
	
	SharedEntitiesDTD() {
		super(null, null);
		
		addGeneralEntity(new InternalEntity(new Name("AElig"), new EntityValue("Æ")));
		addGeneralEntity(new InternalEntity(new Name("Aacute"), new EntityValue("Á")));
		addGeneralEntity(new InternalEntity(new Name("Acirc"), new EntityValue("Â")));
		addGeneralEntity(new InternalEntity(new Name("Agrave"), new EntityValue("À")));
		addGeneralEntity(new InternalEntity(new Name("Alpha"), new EntityValue("Α")));
		addGeneralEntity(new InternalEntity(new Name("Aring"), new EntityValue("Å")));
		addGeneralEntity(new InternalEntity(new Name("Atilde"), new EntityValue("Ã")));
		addGeneralEntity(new InternalEntity(new Name("Auml"), new EntityValue("Ä")));
		addGeneralEntity(new InternalEntity(new Name("Beta"), new EntityValue("Β")));
		addGeneralEntity(new InternalEntity(new Name("Ccedil"), new EntityValue("Ç")));
		addGeneralEntity(new InternalEntity(new Name("Chi"), new EntityValue("Χ")));
		addGeneralEntity(new InternalEntity(new Name("Dagger"), new EntityValue("‡")));
		addGeneralEntity(new InternalEntity(new Name("Delta"), new EntityValue("Δ")));
		addGeneralEntity(new InternalEntity(new Name("ETH"), new EntityValue("Ð")));
		addGeneralEntity(new InternalEntity(new Name("Eacute"), new EntityValue("É")));
		addGeneralEntity(new InternalEntity(new Name("Ecirc"), new EntityValue("Ê")));
		addGeneralEntity(new InternalEntity(new Name("Egrave"), new EntityValue("È")));
		addGeneralEntity(new InternalEntity(new Name("Epsilon"), new EntityValue("Ε")));
		addGeneralEntity(new InternalEntity(new Name("Eta"), new EntityValue("Η")));
		addGeneralEntity(new InternalEntity(new Name("Euml"), new EntityValue("Ë")));
		addGeneralEntity(new InternalEntity(new Name("Gamma"), new EntityValue("Γ")));
		addGeneralEntity(new InternalEntity(new Name("Iacute"), new EntityValue("Í")));
		addGeneralEntity(new InternalEntity(new Name("Icirc"), new EntityValue("Î")));
		addGeneralEntity(new InternalEntity(new Name("Igrave"), new EntityValue("Ì")));
		addGeneralEntity(new InternalEntity(new Name("Iota"), new EntityValue("Ι")));
		addGeneralEntity(new InternalEntity(new Name("Iuml"), new EntityValue("Ï")));
		addGeneralEntity(new InternalEntity(new Name("Kappa"), new EntityValue("Κ")));
		addGeneralEntity(new InternalEntity(new Name("Lambda"), new EntityValue("Λ")));
		addGeneralEntity(new InternalEntity(new Name("Mu"), new EntityValue("Μ")));
		addGeneralEntity(new InternalEntity(new Name("Ntilde"), new EntityValue("Ñ")));
		addGeneralEntity(new InternalEntity(new Name("Nu"), new EntityValue("Ν")));
		addGeneralEntity(new InternalEntity(new Name("OElig"), new EntityValue("Œ")));
		addGeneralEntity(new InternalEntity(new Name("Oacute"), new EntityValue("Ó")));
		addGeneralEntity(new InternalEntity(new Name("Ocirc"), new EntityValue("Ô")));
		addGeneralEntity(new InternalEntity(new Name("Ograve"), new EntityValue("Ò")));
		addGeneralEntity(new InternalEntity(new Name("Omega"), new EntityValue("Ω")));
		addGeneralEntity(new InternalEntity(new Name("Omicron"), new EntityValue("Ο")));
		addGeneralEntity(new InternalEntity(new Name("Oslash"), new EntityValue("Ø")));
		addGeneralEntity(new InternalEntity(new Name("Otilde"), new EntityValue("Õ")));
		addGeneralEntity(new InternalEntity(new Name("Ouml"), new EntityValue("Ö")));
		addGeneralEntity(new InternalEntity(new Name("Phi"), new EntityValue("Φ")));
		addGeneralEntity(new InternalEntity(new Name("Pi"), new EntityValue("Π")));
		addGeneralEntity(new InternalEntity(new Name("Prime"), new EntityValue("″")));
		addGeneralEntity(new InternalEntity(new Name("Psi"), new EntityValue("Ψ")));
		addGeneralEntity(new InternalEntity(new Name("Rho"), new EntityValue("Ρ")));
		addGeneralEntity(new InternalEntity(new Name("Scaron"), new EntityValue("Š")));
		addGeneralEntity(new InternalEntity(new Name("Sigma"), new EntityValue("Σ")));
		addGeneralEntity(new InternalEntity(new Name("THORN"), new EntityValue("Þ")));
		addGeneralEntity(new InternalEntity(new Name("Tau"), new EntityValue("Τ")));
		addGeneralEntity(new InternalEntity(new Name("Theta"), new EntityValue("Θ")));
		addGeneralEntity(new InternalEntity(new Name("Uacute"), new EntityValue("Ú")));
		addGeneralEntity(new InternalEntity(new Name("Ucirc"), new EntityValue("Û")));
		addGeneralEntity(new InternalEntity(new Name("Ugrave"), new EntityValue("Ù")));
		addGeneralEntity(new InternalEntity(new Name("Upsilon"), new EntityValue("Υ")));
		addGeneralEntity(new InternalEntity(new Name("Uuml"), new EntityValue("Ü")));
		addGeneralEntity(new InternalEntity(new Name("Xi"), new EntityValue("Ξ")));
		addGeneralEntity(new InternalEntity(new Name("Yacute"), new EntityValue("Ý")));
		addGeneralEntity(new InternalEntity(new Name("Yuml"), new EntityValue("Ÿ")));
		addGeneralEntity(new InternalEntity(new Name("Zeta"), new EntityValue("Ζ")));
		addGeneralEntity(new InternalEntity(new Name("aacute"), new EntityValue("á")));
		addGeneralEntity(new InternalEntity(new Name("acirc"), new EntityValue("â")));
		addGeneralEntity(new InternalEntity(new Name("acute"), new EntityValue("´")));
		addGeneralEntity(new InternalEntity(new Name("aelig"), new EntityValue("æ")));
		addGeneralEntity(new InternalEntity(new Name("agrave"), new EntityValue("à")));
		addGeneralEntity(new InternalEntity(new Name("alefsym"), new EntityValue("ℵ")));
		addGeneralEntity(new InternalEntity(new Name("alpha"), new EntityValue("α")));
		addGeneralEntity(new InternalEntity(new Name("and"), new EntityValue("∧")));
		addGeneralEntity(new InternalEntity(new Name("ang"), new EntityValue("∠")));
		addGeneralEntity(new InternalEntity(new Name("aring"), new EntityValue("å")));
		addGeneralEntity(new InternalEntity(new Name("asymp"), new EntityValue("≈")));
		addGeneralEntity(new InternalEntity(new Name("atilde"), new EntityValue("ã")));
		addGeneralEntity(new InternalEntity(new Name("auml"), new EntityValue("ä")));
		addGeneralEntity(new InternalEntity(new Name("bdquo"), new EntityValue("„")));
		addGeneralEntity(new InternalEntity(new Name("beta"), new EntityValue("β")));
		addGeneralEntity(new InternalEntity(new Name("brvbar"), new EntityValue("¦")));
		addGeneralEntity(new InternalEntity(new Name("bull"), new EntityValue("•")));
		addGeneralEntity(new InternalEntity(new Name("cap"), new EntityValue("∩")));
		addGeneralEntity(new InternalEntity(new Name("ccedil"), new EntityValue("ç")));
		addGeneralEntity(new InternalEntity(new Name("cedil"), new EntityValue("¸")));
		addGeneralEntity(new InternalEntity(new Name("cent"), new EntityValue("¢")));
		addGeneralEntity(new InternalEntity(new Name("chi"), new EntityValue("χ")));
		addGeneralEntity(new InternalEntity(new Name("circ"), new EntityValue("ˆ")));
		addGeneralEntity(new InternalEntity(new Name("clubs"), new EntityValue("♣")));
		addGeneralEntity(new InternalEntity(new Name("cong"), new EntityValue("≅")));
		addGeneralEntity(new InternalEntity(new Name("copy"), new EntityValue("©")));
		addGeneralEntity(new InternalEntity(new Name("crarr"), new EntityValue("↵")));
		addGeneralEntity(new InternalEntity(new Name("cup"), new EntityValue("∪")));
		addGeneralEntity(new InternalEntity(new Name("curren"), new EntityValue("¤")));
		addGeneralEntity(new InternalEntity(new Name("dArr"), new EntityValue("⇓")));
		addGeneralEntity(new InternalEntity(new Name("dagger"), new EntityValue("†")));
		addGeneralEntity(new InternalEntity(new Name("darr"), new EntityValue("↓")));
		addGeneralEntity(new InternalEntity(new Name("deg"), new EntityValue("°")));
		addGeneralEntity(new InternalEntity(new Name("delta"), new EntityValue("δ")));
		addGeneralEntity(new InternalEntity(new Name("diams"), new EntityValue("♦")));
		addGeneralEntity(new InternalEntity(new Name("divide"), new EntityValue("÷")));
		addGeneralEntity(new InternalEntity(new Name("eacute"), new EntityValue("é")));
		addGeneralEntity(new InternalEntity(new Name("ecirc"), new EntityValue("ê")));
		addGeneralEntity(new InternalEntity(new Name("egrave"), new EntityValue("è")));
		addGeneralEntity(new InternalEntity(new Name("empty"), new EntityValue("∅")));
		addGeneralEntity(new InternalEntity(new Name("emsp"), new EntityValue(" ")));
		addGeneralEntity(new InternalEntity(new Name("ensp"), new EntityValue(" ")));
		addGeneralEntity(new InternalEntity(new Name("epsilon"), new EntityValue("ε")));
		addGeneralEntity(new InternalEntity(new Name("equiv"), new EntityValue("≡")));
		addGeneralEntity(new InternalEntity(new Name("eta"), new EntityValue("η")));
		addGeneralEntity(new InternalEntity(new Name("eth"), new EntityValue("ð")));
		addGeneralEntity(new InternalEntity(new Name("euml"), new EntityValue("ë")));
		addGeneralEntity(new InternalEntity(new Name("euro"), new EntityValue("€")));
		addGeneralEntity(new InternalEntity(new Name("exist"), new EntityValue("∃")));
		addGeneralEntity(new InternalEntity(new Name("fnof"), new EntityValue("ƒ")));
		addGeneralEntity(new InternalEntity(new Name("forall"), new EntityValue("∀")));
		addGeneralEntity(new InternalEntity(new Name("frac12"), new EntityValue("½")));
		addGeneralEntity(new InternalEntity(new Name("frac14"), new EntityValue("¼")));
		addGeneralEntity(new InternalEntity(new Name("frac34"), new EntityValue("¾")));
		addGeneralEntity(new InternalEntity(new Name("frasl"), new EntityValue("⁄")));
		addGeneralEntity(new InternalEntity(new Name("gamma"), new EntityValue("γ")));
		addGeneralEntity(new InternalEntity(new Name("ge"), new EntityValue("≥")));
		addGeneralEntity(new InternalEntity(new Name("hArr"), new EntityValue("⇔")));
		addGeneralEntity(new InternalEntity(new Name("harr"), new EntityValue("↔")));
		addGeneralEntity(new InternalEntity(new Name("hearts"), new EntityValue("♥")));
		addGeneralEntity(new InternalEntity(new Name("hellip"), new EntityValue("…")));
		addGeneralEntity(new InternalEntity(new Name("iacute"), new EntityValue("í")));
		addGeneralEntity(new InternalEntity(new Name("icirc"), new EntityValue("î")));
		addGeneralEntity(new InternalEntity(new Name("iexcl"), new EntityValue("¡")));
		addGeneralEntity(new InternalEntity(new Name("igrave"), new EntityValue("ì")));
		addGeneralEntity(new InternalEntity(new Name("image"), new EntityValue("ℑ")));
		addGeneralEntity(new InternalEntity(new Name("infin"), new EntityValue("∞")));
		addGeneralEntity(new InternalEntity(new Name("int"), new EntityValue("∫")));
		addGeneralEntity(new InternalEntity(new Name("iota"), new EntityValue("ι")));
		addGeneralEntity(new InternalEntity(new Name("iquest"), new EntityValue("¿")));
		addGeneralEntity(new InternalEntity(new Name("isin"), new EntityValue("∈")));
		addGeneralEntity(new InternalEntity(new Name("iuml"), new EntityValue("ï")));
		addGeneralEntity(new InternalEntity(new Name("kappa"), new EntityValue("κ")));
		addGeneralEntity(new InternalEntity(new Name("lArr"), new EntityValue("⇐")));
		addGeneralEntity(new InternalEntity(new Name("lambda"), new EntityValue("λ")));
		addGeneralEntity(new InternalEntity(new Name("lang"), new EntityValue("〈")));
		addGeneralEntity(new InternalEntity(new Name("laquo"), new EntityValue("«")));
		addGeneralEntity(new InternalEntity(new Name("larr"), new EntityValue("←")));
		addGeneralEntity(new InternalEntity(new Name("lceil"), new EntityValue("⌈")));
		addGeneralEntity(new InternalEntity(new Name("ldquo"), new EntityValue("“")));
		addGeneralEntity(new InternalEntity(new Name("le"), new EntityValue("≤")));
		addGeneralEntity(new InternalEntity(new Name("lfloor"), new EntityValue("⌊")));
		addGeneralEntity(new InternalEntity(new Name("lowast"), new EntityValue("∗")));
		addGeneralEntity(new InternalEntity(new Name("loz"), new EntityValue("◊")));
		addGeneralEntity(new InternalEntity(new Name("lrm"), new EntityValue("‎")));
		addGeneralEntity(new InternalEntity(new Name("lsaquo"), new EntityValue("‹")));
		addGeneralEntity(new InternalEntity(new Name("lsquo"), new EntityValue("‘")));
		addGeneralEntity(new InternalEntity(new Name("macr"), new EntityValue("¯")));
		addGeneralEntity(new InternalEntity(new Name("mdash"), new EntityValue("—")));
		addGeneralEntity(new InternalEntity(new Name("micro"), new EntityValue("µ")));
		addGeneralEntity(new InternalEntity(new Name("middot"), new EntityValue("·")));
		addGeneralEntity(new InternalEntity(new Name("minus"), new EntityValue("−")));
		addGeneralEntity(new InternalEntity(new Name("mu"), new EntityValue("μ")));
		addGeneralEntity(new InternalEntity(new Name("nabla"), new EntityValue("∇")));
		addGeneralEntity(new InternalEntity(new Name("nbsp"), new EntityValue(" ")));
		addGeneralEntity(new InternalEntity(new Name("ndash"), new EntityValue("–")));
		addGeneralEntity(new InternalEntity(new Name("ne"), new EntityValue("≠")));
		addGeneralEntity(new InternalEntity(new Name("ni"), new EntityValue("∋")));
		addGeneralEntity(new InternalEntity(new Name("not"), new EntityValue("¬")));
		addGeneralEntity(new InternalEntity(new Name("notin"), new EntityValue("∉")));
		addGeneralEntity(new InternalEntity(new Name("nsub"), new EntityValue("⊄")));
		addGeneralEntity(new InternalEntity(new Name("ntilde"), new EntityValue("ñ")));
		addGeneralEntity(new InternalEntity(new Name("nu"), new EntityValue("ν")));
		addGeneralEntity(new InternalEntity(new Name("oacute"), new EntityValue("ó")));
		addGeneralEntity(new InternalEntity(new Name("ocirc"), new EntityValue("ô")));
		addGeneralEntity(new InternalEntity(new Name("oelig"), new EntityValue("œ")));
		addGeneralEntity(new InternalEntity(new Name("ograve"), new EntityValue("ò")));
		addGeneralEntity(new InternalEntity(new Name("oline"), new EntityValue("‾")));
		addGeneralEntity(new InternalEntity(new Name("omega"), new EntityValue("ω")));
		addGeneralEntity(new InternalEntity(new Name("omicron"), new EntityValue("ο")));
		addGeneralEntity(new InternalEntity(new Name("oplus"), new EntityValue("⊕")));
		addGeneralEntity(new InternalEntity(new Name("or"), new EntityValue("∨")));
		addGeneralEntity(new InternalEntity(new Name("ordf"), new EntityValue("ª")));
		addGeneralEntity(new InternalEntity(new Name("ordm"), new EntityValue("º")));
		addGeneralEntity(new InternalEntity(new Name("oslash"), new EntityValue("ø")));
		addGeneralEntity(new InternalEntity(new Name("otilde"), new EntityValue("õ")));
		addGeneralEntity(new InternalEntity(new Name("otimes"), new EntityValue("⊗")));
		addGeneralEntity(new InternalEntity(new Name("ouml"), new EntityValue("ö")));
		addGeneralEntity(new InternalEntity(new Name("para"), new EntityValue("¶")));
		addGeneralEntity(new InternalEntity(new Name("part"), new EntityValue("∂")));
		addGeneralEntity(new InternalEntity(new Name("permil"), new EntityValue("‰")));
		addGeneralEntity(new InternalEntity(new Name("perp"), new EntityValue("⊥")));
		addGeneralEntity(new InternalEntity(new Name("phi"), new EntityValue("φ")));
		addGeneralEntity(new InternalEntity(new Name("pi"), new EntityValue("π")));
		addGeneralEntity(new InternalEntity(new Name("piv"), new EntityValue("ϖ")));
		addGeneralEntity(new InternalEntity(new Name("plusmn"), new EntityValue("±")));
		addGeneralEntity(new InternalEntity(new Name("pound"), new EntityValue("£")));
		addGeneralEntity(new InternalEntity(new Name("prime"), new EntityValue("′")));
		addGeneralEntity(new InternalEntity(new Name("prod"), new EntityValue("∏")));
		addGeneralEntity(new InternalEntity(new Name("prop"), new EntityValue("∝")));
		addGeneralEntity(new InternalEntity(new Name("psi"), new EntityValue("ψ")));
		addGeneralEntity(new InternalEntity(new Name("rArr"), new EntityValue("⇒")));
		addGeneralEntity(new InternalEntity(new Name("radic"), new EntityValue("√")));
		addGeneralEntity(new InternalEntity(new Name("rang"), new EntityValue("〉")));
		addGeneralEntity(new InternalEntity(new Name("raquo"), new EntityValue("»")));
		addGeneralEntity(new InternalEntity(new Name("rarr"), new EntityValue("→")));
		addGeneralEntity(new InternalEntity(new Name("rceil"), new EntityValue("⌉")));
		addGeneralEntity(new InternalEntity(new Name("rdquo"), new EntityValue("”")));
		addGeneralEntity(new InternalEntity(new Name("real"), new EntityValue("ℜ")));
		addGeneralEntity(new InternalEntity(new Name("reg"), new EntityValue("®")));
		addGeneralEntity(new InternalEntity(new Name("rfloor"), new EntityValue("⌋")));
		addGeneralEntity(new InternalEntity(new Name("rho"), new EntityValue("ρ")));
		addGeneralEntity(new InternalEntity(new Name("rlm"), new EntityValue("‏")));
		addGeneralEntity(new InternalEntity(new Name("rsaquo"), new EntityValue("›")));
		addGeneralEntity(new InternalEntity(new Name("rsquo"), new EntityValue("’")));
		addGeneralEntity(new InternalEntity(new Name("sbquo"), new EntityValue("‚")));
		addGeneralEntity(new InternalEntity(new Name("scaron"), new EntityValue("š")));
		addGeneralEntity(new InternalEntity(new Name("sdot"), new EntityValue("⋅")));
		addGeneralEntity(new InternalEntity(new Name("sect"), new EntityValue("§")));
		addGeneralEntity(new InternalEntity(new Name("shy"), new EntityValue("­")));
		addGeneralEntity(new InternalEntity(new Name("sigma"), new EntityValue("σ")));
		addGeneralEntity(new InternalEntity(new Name("sigmaf"), new EntityValue("ς")));
		addGeneralEntity(new InternalEntity(new Name("sim"), new EntityValue("∼")));
		addGeneralEntity(new InternalEntity(new Name("spades"), new EntityValue("♠")));
		addGeneralEntity(new InternalEntity(new Name("sub"), new EntityValue("⊂")));
		addGeneralEntity(new InternalEntity(new Name("sube"), new EntityValue("⊆")));
		addGeneralEntity(new InternalEntity(new Name("sum"), new EntityValue("∑")));
		addGeneralEntity(new InternalEntity(new Name("sup"), new EntityValue("⊃")));
		addGeneralEntity(new InternalEntity(new Name("sup1"), new EntityValue("¹")));
		addGeneralEntity(new InternalEntity(new Name("sup2"), new EntityValue("²")));
		addGeneralEntity(new InternalEntity(new Name("sup3"), new EntityValue("³")));
		addGeneralEntity(new InternalEntity(new Name("supe"), new EntityValue("⊇")));
		addGeneralEntity(new InternalEntity(new Name("szlig"), new EntityValue("ß")));
		addGeneralEntity(new InternalEntity(new Name("tau"), new EntityValue("τ")));
		addGeneralEntity(new InternalEntity(new Name("there4"), new EntityValue("∴")));
		addGeneralEntity(new InternalEntity(new Name("theta"), new EntityValue("θ")));
		addGeneralEntity(new InternalEntity(new Name("thetasym"), new EntityValue("ϑ")));
		addGeneralEntity(new InternalEntity(new Name("thinsp"), new EntityValue(" ")));
		addGeneralEntity(new InternalEntity(new Name("thorn"), new EntityValue("þ")));
		addGeneralEntity(new InternalEntity(new Name("tilde"), new EntityValue("˜")));
		addGeneralEntity(new InternalEntity(new Name("times"), new EntityValue("×")));
		addGeneralEntity(new InternalEntity(new Name("trade"), new EntityValue("™")));
		addGeneralEntity(new InternalEntity(new Name("uArr"), new EntityValue("⇑")));
		addGeneralEntity(new InternalEntity(new Name("uacute"), new EntityValue("ú")));
		addGeneralEntity(new InternalEntity(new Name("uarr"), new EntityValue("↑")));
		addGeneralEntity(new InternalEntity(new Name("ucirc"), new EntityValue("û")));
		addGeneralEntity(new InternalEntity(new Name("ugrave"), new EntityValue("ù")));
		addGeneralEntity(new InternalEntity(new Name("uml"), new EntityValue("¨")));
		addGeneralEntity(new InternalEntity(new Name("upsih"), new EntityValue("ϒ")));
		addGeneralEntity(new InternalEntity(new Name("upsilon"), new EntityValue("υ")));
		addGeneralEntity(new InternalEntity(new Name("uuml"), new EntityValue("ü")));
		addGeneralEntity(new InternalEntity(new Name("weierp"), new EntityValue("℘")));
		addGeneralEntity(new InternalEntity(new Name("xi"), new EntityValue("ξ")));
		addGeneralEntity(new InternalEntity(new Name("yacute"), new EntityValue("ý")));
		addGeneralEntity(new InternalEntity(new Name("yen"), new EntityValue("¥")));
		addGeneralEntity(new InternalEntity(new Name("yuml"), new EntityValue("ÿ")));
		addGeneralEntity(new InternalEntity(new Name("zeta"), new EntityValue("ζ")));
		addGeneralEntity(new InternalEntity(new Name("zwj"), new EntityValue("‍")));
		addGeneralEntity(new InternalEntity(new Name("zwnj"), new EntityValue("‌")));
	}

	// *** Interface Methods ***

	// *** Public Methods ***

	// *** Protected Methods ***

	// *** Package Methods ***

	// *** Private Methods ***

	// *** Private Classes ***
}










/* end */