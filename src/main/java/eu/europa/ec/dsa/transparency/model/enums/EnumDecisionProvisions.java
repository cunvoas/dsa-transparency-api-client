package eu.europa.ec.dsa.transparency.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EnumDecisionProvisions {

    DECISION_PROVISION_PARTIAL_SUSPENSION ("DECISION_PROVISION_PARTIAL_SUSPENSION", "Partial suspension of the provision of the service"),
    DECISION_PROVISION_TOTAL_SUSPENSION ("DECISION_PROVISION_TOTAL_SUSPENSION", "Total suspension of the provision of the service"),
    DECISION_PROVISION_PARTIAL_TERMINATION ("DECISION_PROVISION_PARTIAL_TERMINATION", "Partial termination of the provision of the service"),
    DECISION_PROVISION_TOTAL_TERMINATION ("DECISION_PROVISION_TOTAL_TERMINATION", "Total termination of the provision of the service");

	private EnumDecisionProvisions(String code, String desc) {
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

