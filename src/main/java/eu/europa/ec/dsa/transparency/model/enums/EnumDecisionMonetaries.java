package eu.europa.ec.dsa.transparency.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EnumDecisionMonetaries {

    DECISION_MONETARY_SUSPENSION ("DECISION_MONETARY_SUSPENSION", "Suspension of monetary payments"),
    DECISION_MONETARY_TERMINATION ("DECISION_MONETARY_TERMINATION", "Termination of monetary payments"),
    DECISION_MONETARY_OTHER ("DECISION_MONETARY_OTHER", "Other restriction (please specify)");

    
	private EnumDecisionMonetaries(String code, String desc) {
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
