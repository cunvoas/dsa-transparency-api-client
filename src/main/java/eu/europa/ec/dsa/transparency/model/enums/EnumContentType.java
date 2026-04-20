package eu.europa.ec.dsa.transparency.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EnumContentType {

    CONTENT_TYPE_APP ("CONTENT_TYPE_APP", "App"),
    CONTENT_TYPE_AUDIO ("CONTENT_TYPE_AUDIO", "Audio"),
    CONTENT_TYPE_PRODUCT ("CONTENT_TYPE_PRODUCT", "Product"),
    CONTENT_TYPE_SYNTHETIC_MEDIA ("CONTENT_TYPE_SYNTHETIC_MEDIA", "Synthetic Media"),
    CONTENT_TYPE_TEXT ("CONTENT_TYPE_TEXT", "Text"),
    CONTENT_TYPE_VIDEO ("CONTENT_TYPE_VIDEO", "Video"),
    CONTENT_TYPE_IMAGE ("CONTENT_TYPE_IMAGE", "Image"),
    CONTENT_TYPE_OTHER ("CONTENT_TYPE_OTHER", "Other");

	
	private EnumContentType(String code, String desc) {
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
