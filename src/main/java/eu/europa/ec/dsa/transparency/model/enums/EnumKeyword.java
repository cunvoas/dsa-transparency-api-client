package eu.europa.ec.dsa.transparency.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EnumKeyword {


    KEYWORD_ANIMAL_HARM("KEYWORD_ANIMAL_HARM", "Animal harm"),
    KEYWORD_ADULT_SEXUAL_MATERIAL("KEYWORD_ADULT_SEXUAL_MATERIAL", "Adult sexual material"),
    KEYWORD_AGE_SPECIFIC_RESTRICTIONS_MINORS("KEYWORD_AGE_SPECIFIC_RESTRICTIONS_MINORS", "Age-specific restrictions concerning minors"),
    KEYWORD_AGE_SPECIFIC_RESTRICTIONS("KEYWORD_AGE_SPECIFIC_RESTRICTIONS", "Age-specific restrictions"),
    KEYWORD_BIOMETRIC_DATA_BREACH("KEYWORD_BIOMETRIC_DATA_BREACH", "Biometric data breach"),
    KEYWORD_BULLYING_AGAINST_GIRLS("KEYWORD_BULLYING_AGAINST_GIRLS", "Cyber bullying and intimidation against girls"),
    KEYWORD_CHILD_SEXUAL_ABUSE_MATERIAL("KEYWORD_CHILD_SEXUAL_ABUSE_MATERIAL", "Child sexual abuse material"),
    KEYWORD_CHILD_SEXUAL_ABUSE_MATERIAL_DEEPFAKE("KEYWORD_CHILD_SEXUAL_ABUSE_MATERIAL_DEEPFAKE", "Child sexual abuse material containing deepfake or similar technology"),
    KEYWORD_CONTENT_PROMOTING_EATING_DISORDERS("KEYWORD_CONTENT_PROMOTING_EATING_DISORDERS", "Content promoting eating disorders"),
    KEYWORD_COORDINATED_HARM("KEYWORD_COORDINATED_HARM", "Coordinated harm"),
    KEYWORD_COPYRIGHT_INFRINGEMENT("KEYWORD_COPYRIGHT_INFRINGEMENT", "Copyright infringements"),
    KEYWORD_CYBER_BULLYING_INTIMIDATION("KEYWORD_CYBER_BULLYING_INTIMIDATION", "Cyber bullying and intimidation"),
    KEYWORD_CYBER_HARASSMENT("KEYWORD_CYBER_HARASSMENT", "Cyber harassment"),
    KEYWORD_CYBER_HARASSMENT_AGAINST_WOMEN("KEYWORD_CYBER_HARASSMENT_AGAINST_WOMEN", "Cyber harassment against women"),
    KEYWORD_CYBER_INCITEMENT("KEYWORD_CYBER_INCITEMENT", "Cyber incitement to hatred or violence"),
    KEYWORD_CYBER_STALKING("KEYWORD_CYBER_STALKING", "Cyber stalking"),
    KEYWORD_CYBER_STALKING_AGAINST_WOMEN("KEYWORD_CYBER_STALKING_AGAINST_WOMEN", "Cyber stalking against women"),
    KEYWORD_DANGEROUS_TOYS("KEYWORD_DANGEROUS_TOYS", "Dangerous toys"),
    KEYWORD_DATA_FALSIFICATION("KEYWORD_DATA_FALSIFICATION", "Data falsification"),
    KEYWORD_DEFAMATION("KEYWORD_DEFAMATION", "Defamation"),
    KEYWORD_DESIGN_INFRINGEMENT("KEYWORD_DESIGN_INFRINGEMENT", "Design infringements"),
    KEYWORD_DISCRIMINATION("KEYWORD_DISCRIMINATION", "Discrimination"),
    KEYWORD_FEMALE_GENDERED_DISINFORMATION("KEYWORD_FEMALE_GENDERED_DISINFORMATION", "Gendered disinformation"),
    KEYWORD_GEOGRAPHIC_INDICATIONS_INFRINGEMENT("KEYWORD_GEOGRAPHIC_INDICATIONS_INFRINGEMENT", "Geographic indications infringements"),
    KEYWORD_GEOGRAPHICAL_REQUIREMENTS("KEYWORD_GEOGRAPHICAL_REQUIREMENTS", "Geographical requirements"),
    KEYWORD_GOODS_SERVICES_NOT_PERMITTED("KEYWORD_GOODS_SERVICES_NOT_PERMITTED", "Goods/services not permitted to be offered on the platform"),
    KEYWORD_GROOMING_SEXUAL_ENTICEMENT_MINORS("KEYWORD_GROOMING_SEXUAL_ENTICEMENT_MINORS", "Grooming/sexual enticement of minors"),
    KEYWORD_HATE_SPEECH("KEYWORD_HATE_SPEECH", "Illegal incitement to violence and hatred based on protected characteristics (hate speech)"),
    KEYWORD_HIDDEN_ADVERTISEMENT("KEYWORD_HIDDEN_ADVERTISEMENT", "Hidden advertisement or commercial communication, including by influencers"),
    KEYWORD_HUMAN_EXPLOITATION("KEYWORD_HUMAN_EXPLOITATION", "Human exploitation"),
    KEYWORD_HUMAN_TRAFFICKING("KEYWORD_HUMAN_TRAFFICKING", "Human trafficking"),
    KEYWORD_ILLEGAL_ORGANIZATIONS("KEYWORD_ILLEGAL_ORGANIZATIONS", "Illegal organizations"),
    KEYWORD_IMPERSONATION_ACCOUNT_HIJACKING("KEYWORD_IMPERSONATION_ACCOUNT_HIJACKING", "Impersonation or account hijacking"),
    KEYWORD_INAUTHENTIC_ACCOUNTS("KEYWORD_INAUTHENTIC_ACCOUNTS", "Inauthentic accounts"),
    KEYWORD_INAUTHENTIC_LISTINGS("KEYWORD_INAUTHENTIC_LISTINGS", "Inauthentic listings"),
    KEYWORD_INAUTHENTIC_USER_REVIEWS("KEYWORD_INAUTHENTIC_USER_REVIEWS", "Inauthentic user reviews"),
    KEYWORD_INCITEMENT_AGAINST_WOMEN("KEYWORD_INCITEMENT_AGAINST_WOMEN", "Illegal incitement to violence and hatred against women"),
    KEYWORD_INCITEMENT_VIOLENCE_HATRED("KEYWORD_INCITEMENT_VIOLENCE_HATRED", "General calls or incitement to violence and/or hatred"),
    KEYWORD_INSUFFICIENT_INFORMATION_ON_TRADERS("KEYWORD_INSUFFICIENT_INFORMATION_ON_TRADERS", "Insufficient information on traders"),
    KEYWORD_LANGUAGE_REQUIREMENTS("KEYWORD_LANGUAGE_REQUIREMENTS", "Language requirements"),
    KEYWORD_MISINFORMATION_DISINFORMATION("KEYWORD_MISINFORMATION_DISINFORMATION", "Misinformation, disinformation, foreign information manipulation and interference"),
    KEYWORD_MISLEADING_INFO_CONSUMER_RIGHTS("KEYWORD_MISLEADING_INFO_CONSUMER_RIGHTS", "Misleading information about the consumer\'s rights"),
    KEYWORD_MISLEADING_INFO_GOODS_SERVICES("KEYWORD_MISLEADING_INFO_GOODS_SERVICES", "Misleading information about the characteristics of the goods and services"),
    KEYWORD_MISSING_PROCESSING_GROUND("KEYWORD_MISSING_PROCESSING_GROUND", "Missing processing ground for data"),
    KEYWORD_NON_CONSENSUAL_IMAGE_SHARING("KEYWORD_NON_CONSENSUAL_IMAGE_SHARING", "Non-consensual (intimate) material sharing, including (image-based) sexual abuse (excluding content depicting minors)"),
    KEYWORD_NON_CONSENSUAL_IMAGE_SHARING_AGAINST_WOMEN("KEYWORD_NON_CONSENSUAL_IMAGE_SHARING_AGAINST_WOMEN", "Non-consensual (intimate) material sharing against women, including (image-based) sexual abuse against women (excluding content depicting minors)"),
    KEYWORD_NON_CONSENSUAL_MATERIAL_DEEPFAKE("KEYWORD_NON_CONSENSUAL_MATERIAL_DEEPFAKE", "Non-consensual sharing of material containing deepfake or similar technology using a third party\'s features (excluding content depicting minors)"),
    KEYWORD_NON_CONSENSUAL_MATERIAL_DEEPFAKE_AGAINST_WOMEN("KEYWORD_NON_CONSENSUAL_MATERIAL_DEEPFAKE_AGAINST_WOMEN", "Non-consensual sharing of material containing deepfake or similar technology using a third party\'s features against women (excluding content depicting minors)"),
    KEYWORD_NONCOMPLIANCE_PRICING("KEYWORD_NONCOMPLIANCE_PRICING", "Non-compliance with pricing regulations"),
    KEYWORD_NUDITY("KEYWORD_NUDITY", "Nudity"),
    KEYWORD_PATENT_INFRINGEMENT("KEYWORD_PATENT_INFRINGEMENT", "Patent infringements"),
    KEYWORD_PHISHING("KEYWORD_PHISHING", "Phishing"),
    KEYWORD_PROHIBITED_PRODUCTS("KEYWORD_PROHIBITED_PRODUCTS", "Prohibited or restricted products"),
    KEYWORD_PYRAMID_SCHEMES("KEYWORD_PYRAMID_SCHEMES", "Pyramid schemes"),
    KEYWORD_RIGHT_TO_BE_FORGOTTEN("KEYWORD_RIGHT_TO_BE_FORGOTTEN", "Right to be forgotten"),
    KEYWORD_RISK_ENVIRONMENTAL_DAMAGE("KEYWORD_RISK_ENVIRONMENTAL_DAMAGE", "Risk for environmental damage"),
    KEYWORD_RISK_PUBLIC_HEALTH("KEYWORD_RISK_PUBLIC_HEALTH", "Risk for public health"),
    KEYWORD_SELF_MUTILATION("KEYWORD_SELF_MUTILATION", "Self-mutilation"),
    KEYWORD_STALKING("KEYWORD_STALKING", "Stalking"),
    KEYWORD_SUICIDE("KEYWORD_SUICIDE", "Suicide"),
    KEYWORD_TRADE_SECRET_INFRINGEMENT("KEYWORD_TRADE_SECRET_INFRINGEMENT", "Trade secret infringements"),
    KEYWORD_TRADEMARK_INFRINGEMENT("KEYWORD_TRADEMARK_INFRINGEMENT", "Trademark infringements"),
    KEYWORD_TRAFFICKING_WOMEN_GIRLS("KEYWORD_TRAFFICKING_WOMEN_GIRLS", "Trafficking in women and girls"),
    KEYWORD_TERRORIST_CONTENT("KEYWORD_TERRORIST_CONTENT", "Terrorist content"),
    KEYWORD_UNLAWFUL_SALE_ANIMALS("KEYWORD_UNLAWFUL_SALE_ANIMALS", "Unlawful sale of animals"),
    KEYWORD_UNSAFE_CHALLENGES("KEYWORD_UNSAFE_CHALLENGES", "Unsafe challenges"),
    KEYWORD_UNSAFE_PRODUCTS("KEYWORD_UNSAFE_PRODUCTS", "Unsafe or non-compliant products"),
    KEYWORD_VIOLATION_EU_LAW("KEYWORD_VIOLATION_EU_LAW", "Violation of EU law relevant to civic discourse or elections"),
    KEYWORD_VIOLATION_NATIONAL_LAW("KEYWORD_VIOLATION_NATIONAL_LAW", "Violation of national law relevant to civic discourse or elections"),
    KEYWORD_OTHER("KEYWORD_OTHER", "Not captured by any other keyword");
	
	private EnumKeyword(String code, String desc) {
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
