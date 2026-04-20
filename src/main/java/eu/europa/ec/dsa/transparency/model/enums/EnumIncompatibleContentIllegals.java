package eu.europa.ec.dsa.transparency.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EnumIncompatibleContentIllegals {


	INCOMPATIBLE_CONTENT_ILLEGAL_YES("INCOMPATIBLE_CONTENT_ILLEGAL_YES", "Yes"),
	INCOMPATIBLE_CONTENT_ILLEGAL_NO("INCOMPATIBLE_CONTENT_ILLEGAL_NO", "No");
	
	private EnumIncompatibleContentIllegals(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	private final String code;
	private final String desc;
	
	public String getCode() {
		return this.code;
	}
	@JsonValue
	public String getDesc() {
		return this.desc;
	}
	public String toString() {
		return this.code + this.desc;
	}
}
