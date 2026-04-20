package eu.europa.ec.dsa.transparency.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EnumSourceType {

    SOURCE_ARTICLE_16("SOURCE_ARTICLE_16", "Notice submitted in accordance with Article 16 DSA"),
    SOURCE_TRUSTED_FLAGGER("SOURCE_TRUSTED_FLAGGER", "Notice submitted by a trusted flagger"),
    SOURCE_VOLUNTARY("SOURCE_VOLUNTARY", "Own voluntary initiative"),
    SOURCE_TYPE_OTHER_NOTIFICATION("SOURCE_TYPE_OTHER_NOTIFICATION", "Other type of notification");
	
	private EnumSourceType(String code, String desc) {
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
