package eu.europa.ec.dsa.transparency.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EnumAutomatedDetection {

	AUTOMATED_DETECTION_YES("AUTOMATED_DETECTION_YES", "Yes"),
	AUTOMATED_DETECTION_NO("AUTOMATED_DETECTION_NO", "No");
	
	private EnumAutomatedDetection(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	private final String code;
	@JsonValue
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
