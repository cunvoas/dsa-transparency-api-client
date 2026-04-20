package eu.europa.ec.dsa.transparency.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EnumAccountType {

    ACCOUNT_TYPE_BUSINESS("ACCOUNT_TYPE_BUSINESS","Business"),
    ACCOUNT_TYPE_PRIVATE("ACCOUNT_TYPE_PRIVATE","Private");

	
	private EnumAccountType(String code, String desc) {
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
		return this.code +" "+ this.desc;
	}
}
