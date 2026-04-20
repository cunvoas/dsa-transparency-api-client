package eu.europa.ec.dsa.transparency.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EnumDecisionGrounds {

	DECISION_GROUND_ILLEGAL_CONTENT("DECISION_GROUND_ILLEGAL_CONTENT", "Illegal Content"),
	DECISION_GROUND_INCOMPATIBLE_CONTENT("DECISION_GROUND_INCOMPATIBLE_CONTENT", "Content incompatible with terms and conditions");

    
	private EnumDecisionGrounds(String code, String desc) {
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
