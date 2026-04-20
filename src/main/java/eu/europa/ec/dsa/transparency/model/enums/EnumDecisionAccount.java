package eu.europa.ec.dsa.transparency.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EnumDecisionAccount {

	DECISION_ACCOUNT_SUSPENDED("DECISION_ACCOUNT_SUSPENDED", "Suspension of the account"),
	DECISION_ACCOUNT_TERMINATED("DECISION_ACCOUNT_TERMINATED", "Termination of the account");

    
	private EnumDecisionAccount(String code, String desc) {
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
