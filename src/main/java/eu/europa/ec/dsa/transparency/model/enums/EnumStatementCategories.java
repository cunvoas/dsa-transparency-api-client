package eu.europa.ec.dsa.transparency.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Statement Categroy.
 */
public enum EnumStatementCategories {
	
    STATEMENT_CATEGORY_ANIMAL_WELFARE("STATEMENT_CATEGORY_ANIMAL_WELFARE", "Animal welfare"),
    STATEMENT_CATEGORY_CONSUMER_INFORMATION("STATEMENT_CATEGORY_CONSUMER_INFORMATION", "Consumer information infringements"),
    STATEMENT_CATEGORY_CYBER_VIOLENCE("STATEMENT_CATEGORY_CYBER_VIOLENCE", "Cyber violence"),
    STATEMENT_CATEGORY_CYBER_VIOLENCE_AGAINST_WOMEN("STATEMENT_CATEGORY_CYBER_VIOLENCE_AGAINST_WOMEN", "Cyber violence against women"),
    STATEMENT_CATEGORY_DATA_PROTECTION_AND_PRIVACY_VIOLATIONS("STATEMENT_CATEGORY_DATA_PROTECTION_AND_PRIVACY_VIOLATIONS", "Data protection and privacy violations"),
    STATEMENT_CATEGORY_ILLEGAL_OR_HARMFUL_SPEECH("STATEMENT_CATEGORY_ILLEGAL_OR_HARMFUL_SPEECH", "Illegal or harmful speech"),
    STATEMENT_CATEGORY_INTELLECTUAL_PROPERTY_INFRINGEMENTS("STATEMENT_CATEGORY_INTELLECTUAL_PROPERTY_INFRINGEMENTS", "Intellectual property infringements"),
    STATEMENT_CATEGORY_NEGATIVE_EFFECTS_ON_CIVIC_DISCOURSE_OR_ELECTIONS("STATEMENT_CATEGORY_NEGATIVE_EFFECTS_ON_CIVIC_DISCOURSE_OR_ELECTIONS", "Negative effects on civic discourse or elections"),
    STATEMENT_CATEGORY_NOT_SPECIFIED_NOTICE("STATEMENT_CATEGORY_NOT_SPECIFIED_NOTICE", "Type of alleged illegal content not specified by the notifier"),
    STATEMENT_CATEGORY_OTHER_VIOLATION_TC("STATEMENT_CATEGORY_OTHER_VIOLATION_TC", "Other violation of provider’s terms and conditions"),
    STATEMENT_CATEGORY_PROTECTION_OF_MINORS("STATEMENT_CATEGORY_PROTECTION_OF_MINORS", "Protection of minors"),
    STATEMENT_CATEGORY_RISK_FOR_PUBLIC_SECURITY("STATEMENT_CATEGORY_RISK_FOR_PUBLIC_SECURITY", "Risk for public security"),
    STATEMENT_CATEGORY_SCAMS_AND_FRAUD("STATEMENT_CATEGORY_SCAMS_AND_FRAUD", "Scams and/or fraud"),
    STATEMENT_CATEGORY_SELF_HARM("STATEMENT_CATEGORY_SELF_HARM", "Self-harm"),
    STATEMENT_CATEGORY_UNSAFE_AND_PROHIBITED_PRODUCTS("STATEMENT_CATEGORY_UNSAFE_AND_PROHIBITED_PRODUCTS", "Unsafe, non-compliant or prohibited products"),
    STATEMENT_CATEGORY_VIOLENCE("STATEMENT_CATEGORY_VIOLENCE", "Violence"),

	// OTHER Case
	STATEMENT_CATEGORY_NOT_SPECIFIED_ORDER("STATEMENT_CATEGORY_NOT_SPECIFIED_ORDER", "NO SPECIFIED ORDER");
	
	private EnumStatementCategories(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	private final String code;
	private final String desc;
	
	@JsonValue
	public String getCode() {
		return this.code;
	}
	public String getDesc() {
		return this.desc;
	}
	public String toString() {
		return this.code + this.desc;
	}
}
