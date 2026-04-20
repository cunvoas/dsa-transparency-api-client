package eu.europa.ec.dsa.transparency.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EnumAutomatedDecision {

	AUTOMATED_DECISION_FULLY("AUTOMATED_DECISION_FULLY", "Fully automated"),
	AUTOMATED_DECISION_PARTIALLY("AUTOMATED_DECISION_PARTIALLY", "Partially automated"),
	AUTOMATED_DECISION_NOT_AUTOMATED("AUTOMATED_DECISION_NOT_AUTOMATED", "Not Automated");


	private EnumAutomatedDecision(String code, String desc) {
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
