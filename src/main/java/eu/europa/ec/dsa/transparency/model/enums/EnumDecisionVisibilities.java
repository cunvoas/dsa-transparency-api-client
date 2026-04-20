package eu.europa.ec.dsa.transparency.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EnumDecisionVisibilities {


    DECISION_VISIBILITY_CONTENT_REMOVED ("DECISION_VISIBILITY_CONTENT_REMOVED", "Removal of content"),
    DECISION_VISIBILITY_CONTENT_DISABLED ("DECISION_VISIBILITY_CONTENT_DISABLED", "Disabling access to content"),
    DECISION_VISIBILITY_CONTENT_DEMOTED ("DECISION_VISIBILITY_CONTENT_DEMOTED", "Demotion of content"),
    DECISION_VISIBILITY_CONTENT_AGE_RESTRICTED ("DECISION_VISIBILITY_CONTENT_AGE_RESTRICTED", "Age restricted content"),
    DECISION_VISIBILITY_CONTENT_INTERACTION_RESTRICTED ("DECISION_VISIBILITY_CONTENT_INTERACTION_RESTRICTED", "Restricting interaction with content"),
    DECISION_VISIBILITY_CONTENT_LABELLED ("DECISION_VISIBILITY_CONTENT_LABELLED", "Labelled content"),
    DECISION_VISIBILITY_OTHER ("DECISION_VISIBILITY_OTHER", "Other restriction (please specify)");

    
	private EnumDecisionVisibilities(String code, String desc) {
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
