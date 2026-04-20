package eu.europa.ec.dsa.transparency.helper;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import eu.europa.ec.dsa.transparency.model.enums.EnumKeyword;
import eu.europa.ec.dsa.transparency.model.enums.EnumStatementCategories;

/**
 * Helper for correct keyworks by Statement.
 * @see https://digital-strategy.ec.europa.eu/en/library/implementing-regulation-laying-down-templates-concerning-transparency-reporting-obligations
 * @see 2 - Annex II - Instructions for filling in the transparency reports templates under Annex I (PDF)
 * @see https://ec.europa.eu/newsroom/dae/redirection/document/109691
 * @see from folder "2_categories_names"
 */
public class MemberStateOrders {
	
	// map which set right Keyword in the right Statement Category
	private static final Map<EnumStatementCategories, List<EnumKeyword>> STMNT_CATEG4KWRD = new HashMap<>();
	
	private static volatile MemberStateOrders instance = null;
	
    public static MemberStateOrders getInstance() {
        if (instance == null) {
            synchronized (MemberStateOrders.class) {
                if (instance == null) {
                    instance = new MemberStateOrders();
                }
            }
        }
        return instance;
    }
    
    public Map<EnumStatementCategories, List<EnumKeyword>> get() {
    	return STMNT_CATEG4KWRD;
    }
    
    public List<EnumKeyword> get(EnumStatementCategories e) {
    	return STMNT_CATEG4KWRD.get(e);
    }
    
	private MemberStateOrders() {
		
		List<EnumKeyword> keyworks = new LinkedList<>();
		
		// Category 1
		// STATEMENT_CATEGORY_ANIMAL_WELFARE
		keyworks.add(EnumKeyword.KEYWORD_ANIMAL_HARM);
		keyworks.add(EnumKeyword.KEYWORD_UNLAWFUL_SALE_ANIMALS);
		keyworks.add(EnumKeyword.KEYWORD_OTHER);
		STMNT_CATEG4KWRD.put(EnumStatementCategories.STATEMENT_CATEGORY_ANIMAL_WELFARE, keyworks);

		// Category 2
		// STATEMENT_CATEGORY_CONSUMER_INFORMATION
		keyworks = new LinkedList<>();
		keyworks.add(EnumKeyword.KEYWORD_HIDDEN_ADVERTISEMENT);
		keyworks.add(EnumKeyword.KEYWORD_INSUFFICIENT_INFORMATION_ON_TRADERS);
		keyworks.add(EnumKeyword.KEYWORD_MISLEADING_INFO_GOODS_SERVICES);
		keyworks.add(EnumKeyword.KEYWORD_MISLEADING_INFO_CONSUMER_RIGHTS);
		keyworks.add(EnumKeyword.KEYWORD_NONCOMPLIANCE_PRICING);
		keyworks.add(EnumKeyword.KEYWORD_OTHER);
		STMNT_CATEG4KWRD.put(EnumStatementCategories.STATEMENT_CATEGORY_CONSUMER_INFORMATION, keyworks);

		// Category 
		// STATEMENT_CATEGORY_CYBER_VIOLENCE
		keyworks = new LinkedList<>();				
		keyworks.add(EnumKeyword.KEYWORD_CYBER_BULLYING_INTIMIDATION);
		keyworks.add(EnumKeyword.KEYWORD_CYBER_HARASSMENT);
		keyworks.add(EnumKeyword.KEYWORD_CYBER_INCITEMENT);
		keyworks.add(EnumKeyword.KEYWORD_CYBER_STALKING);
		keyworks.add(EnumKeyword.KEYWORD_NON_CONSENSUAL_IMAGE_SHARING);
		keyworks.add(EnumKeyword.KEYWORD_NON_CONSENSUAL_MATERIAL_DEEPFAKE);
		keyworks.add(EnumKeyword.KEYWORD_OTHER);
		STMNT_CATEG4KWRD.put(EnumStatementCategories.STATEMENT_CATEGORY_CYBER_VIOLENCE, keyworks);
		
		// Category 4
		// STATEMENT_CATEGORY_CYBER_VIOLENCE_AGAINST_WOMEN
		keyworks = new LinkedList<>();				
		keyworks.add(EnumKeyword.KEYWORD_BULLYING_AGAINST_GIRLS);
		keyworks.add(EnumKeyword.KEYWORD_CYBER_HARASSMENT_AGAINST_WOMEN);
		keyworks.add(EnumKeyword.KEYWORD_CYBER_STALKING_AGAINST_WOMEN);
		keyworks.add(EnumKeyword.KEYWORD_FEMALE_GENDERED_DISINFORMATION);
		keyworks.add(EnumKeyword.KEYWORD_INCITEMENT_AGAINST_WOMEN);
		keyworks.add(EnumKeyword.KEYWORD_NON_CONSENSUAL_IMAGE_SHARING_AGAINST_WOMEN);
		keyworks.add(EnumKeyword.KEYWORD_NON_CONSENSUAL_MATERIAL_DEEPFAKE_AGAINST_WOMEN);
		keyworks.add(EnumKeyword.KEYWORD_OTHER);
		STMNT_CATEG4KWRD.put(EnumStatementCategories.STATEMENT_CATEGORY_CYBER_VIOLENCE_AGAINST_WOMEN, keyworks);
		
		// Category 5
		// STATEMENT_CATEGORY_DATA_PROTECTION_AND_PRIVACY_VIOLATIONS
		keyworks = new LinkedList<>();
		keyworks.add(EnumKeyword.KEYWORD_BIOMETRIC_DATA_BREACH);
		keyworks.add(EnumKeyword.KEYWORD_DATA_FALSIFICATION);
		keyworks.add(EnumKeyword.KEYWORD_MISSING_PROCESSING_GROUND);
		keyworks.add(EnumKeyword.KEYWORD_RIGHT_TO_BE_FORGOTTEN);
		keyworks.add(EnumKeyword.KEYWORD_OTHER);
		STMNT_CATEG4KWRD.put(EnumStatementCategories.STATEMENT_CATEGORY_DATA_PROTECTION_AND_PRIVACY_VIOLATIONS, keyworks);
		
		// Category 6
		// STATEMENT_CATEGORY_ILLEGAL_OR_HARMFUL_SPEECH
		keyworks = new LinkedList<>();
		keyworks.add(EnumKeyword.KEYWORD_DEFAMATION);
		keyworks.add(EnumKeyword.KEYWORD_DISCRIMINATION);
		keyworks.add(EnumKeyword.KEYWORD_HATE_SPEECH);
		keyworks.add(EnumKeyword.KEYWORD_OTHER);
		STMNT_CATEG4KWRD.put(EnumStatementCategories.STATEMENT_CATEGORY_ILLEGAL_OR_HARMFUL_SPEECH, keyworks);
		
		// Category 7
		// STATEMENT_CATEGORY_INTELLECTUAL_PROPERTY_INFRINGEMENTS
		keyworks = new LinkedList<>();
		keyworks.add(EnumKeyword.KEYWORD_COPYRIGHT_INFRINGEMENT);
		keyworks.add(EnumKeyword.KEYWORD_DESIGN_INFRINGEMENT);
		keyworks.add(EnumKeyword.KEYWORD_GEOGRAPHIC_INDICATIONS_INFRINGEMENT);
		keyworks.add(EnumKeyword.KEYWORD_PATENT_INFRINGEMENT);
		keyworks.add(EnumKeyword.KEYWORD_TRADE_SECRET_INFRINGEMENT);
		keyworks.add(EnumKeyword.KEYWORD_TRADEMARK_INFRINGEMENT);
		keyworks.add(EnumKeyword.KEYWORD_OTHER);
		STMNT_CATEG4KWRD.put(EnumStatementCategories.STATEMENT_CATEGORY_INTELLECTUAL_PROPERTY_INFRINGEMENTS, keyworks);
		
		// Category 8
		// STATEMENT_CATEGORY_NEGATIVE_EFFECTS_ON_CIVIC_DISCOURSE_OR_ELECTIONS
		keyworks = new LinkedList<>();
		keyworks.add(EnumKeyword.KEYWORD_MISINFORMATION_DISINFORMATION);
		keyworks.add(EnumKeyword.KEYWORD_VIOLATION_EU_LAW);
		keyworks.add(EnumKeyword.KEYWORD_VIOLATION_NATIONAL_LAW);
		keyworks.add(EnumKeyword.KEYWORD_OTHER);
		STMNT_CATEG4KWRD.put(EnumStatementCategories.STATEMENT_CATEGORY_NEGATIVE_EFFECTS_ON_CIVIC_DISCOURSE_OR_ELECTIONS, keyworks);
		
		// Category 9
		// STATEMENT_CATEGORY_PROTECTION_OF_MINORS
		keyworks = new LinkedList<>();
		keyworks.add(EnumKeyword.KEYWORD_AGE_SPECIFIC_RESTRICTIONS_MINORS);
		keyworks.add(EnumKeyword.KEYWORD_CHILD_SEXUAL_ABUSE_MATERIAL);
		keyworks.add(EnumKeyword.KEYWORD_CHILD_SEXUAL_ABUSE_MATERIAL_DEEPFAKE);
		keyworks.add(EnumKeyword.KEYWORD_GROOMING_SEXUAL_ENTICEMENT_MINORS);
		keyworks.add(EnumKeyword.KEYWORD_UNSAFE_CHALLENGES);
		keyworks.add(EnumKeyword.KEYWORD_OTHER);
		STMNT_CATEG4KWRD.put(EnumStatementCategories.STATEMENT_CATEGORY_PROTECTION_OF_MINORS, keyworks);
		
		// Category 10
		// STATEMENT_CATEGORY_RISK_FOR_PUBLIC_SECURITY
		keyworks = new LinkedList<>();
		keyworks.add(EnumKeyword.KEYWORD_ILLEGAL_ORGANIZATIONS);
		keyworks.add(EnumKeyword.KEYWORD_RISK_ENVIRONMENTAL_DAMAGE);
		keyworks.add(EnumKeyword.KEYWORD_RISK_PUBLIC_HEALTH);
		keyworks.add(EnumKeyword.KEYWORD_TERRORIST_CONTENT);
		keyworks.add(EnumKeyword.KEYWORD_OTHER);
		STMNT_CATEG4KWRD.put(EnumStatementCategories.STATEMENT_CATEGORY_RISK_FOR_PUBLIC_SECURITY, keyworks);
		
		// Category 11
		// STATEMENT_CATEGORY_SCAMS_AND_FRAUD
		keyworks = new LinkedList<>();
		keyworks.add(EnumKeyword.KEYWORD_IMPERSONATION_ACCOUNT_HIJACKING);
		keyworks.add(EnumKeyword.KEYWORD_INAUTHENTIC_ACCOUNTS);
		keyworks.add(EnumKeyword.KEYWORD_INAUTHENTIC_LISTINGS);
		keyworks.add(EnumKeyword.KEYWORD_INAUTHENTIC_USER_REVIEWS);
		keyworks.add(EnumKeyword.KEYWORD_PHISHING);
		keyworks.add(EnumKeyword.KEYWORD_PYRAMID_SCHEMES);
		keyworks.add(EnumKeyword.KEYWORD_OTHER);
		STMNT_CATEG4KWRD.put(EnumStatementCategories.STATEMENT_CATEGORY_SCAMS_AND_FRAUD, keyworks);
		
		// Category 12
		// STATEMENT_CATEGORY_SELF_HARM
		keyworks = new LinkedList<>();
		keyworks.add(EnumKeyword.KEYWORD_CONTENT_PROMOTING_EATING_DISORDERS);
		keyworks.add(EnumKeyword.KEYWORD_SELF_MUTILATION);
		keyworks.add(EnumKeyword.KEYWORD_SUICIDE);
		keyworks.add(EnumKeyword.KEYWORD_OTHER);
		STMNT_CATEG4KWRD.put(EnumStatementCategories.STATEMENT_CATEGORY_SELF_HARM, keyworks);
		
		// Category 13
		// STATEMENT_CATEGORY_UNSAFE_AND_PROHIBITED_PRODUCTS
		keyworks = new LinkedList<>();
		keyworks.add(EnumKeyword.KEYWORD_PROHIBITED_PRODUCTS);
		keyworks.add(EnumKeyword.KEYWORD_UNSAFE_PRODUCTS);
		keyworks.add(EnumKeyword.KEYWORD_OTHER);
		STMNT_CATEG4KWRD.put(EnumStatementCategories.STATEMENT_CATEGORY_UNSAFE_AND_PROHIBITED_PRODUCTS, keyworks);
		
		// Category 14
		// STATEMENT_CATEGORY_VIOLENCE
		keyworks = new LinkedList<>();
		keyworks.add(EnumKeyword.KEYWORD_COORDINATED_HARM);
		keyworks.add(EnumKeyword.KEYWORD_INCITEMENT_VIOLENCE_HATRED);
		keyworks.add(EnumKeyword.KEYWORD_HUMAN_EXPLOITATION);
		keyworks.add(EnumKeyword.KEYWORD_HUMAN_TRAFFICKING);
		keyworks.add(EnumKeyword.KEYWORD_TRAFFICKING_WOMEN_GIRLS);
		keyworks.add(EnumKeyword.KEYWORD_OTHER);
		STMNT_CATEG4KWRD.put(EnumStatementCategories.STATEMENT_CATEGORY_VIOLENCE, keyworks);

		// Category 15
		// STATEMENT_CATEGORY_OTHER_VIOLATION_TC
		keyworks = new LinkedList<>();
		keyworks.add(EnumKeyword.KEYWORD_ADULT_SEXUAL_MATERIAL);
		keyworks.add(EnumKeyword.KEYWORD_AGE_SPECIFIC_RESTRICTIONS);
		keyworks.add(EnumKeyword.KEYWORD_GEOGRAPHICAL_REQUIREMENTS);
		keyworks.add(EnumKeyword.KEYWORD_GOODS_SERVICES_NOT_PERMITTED);
		keyworks.add(EnumKeyword.KEYWORD_LANGUAGE_REQUIREMENTS);
		keyworks.add(EnumKeyword.KEYWORD_NUDITY);
		keyworks.add(EnumKeyword.KEYWORD_OTHER);
		STMNT_CATEG4KWRD.put(EnumStatementCategories.STATEMENT_CATEGORY_OTHER_VIOLATION_TC, keyworks);
		

		// Category 16
		// STATEMENT_CATEGORY_NOT_SPECIFIED_ORDER
		keyworks = new LinkedList<>();
		STMNT_CATEG4KWRD.put(EnumStatementCategories.STATEMENT_CATEGORY_NOT_SPECIFIED_ORDER, keyworks);

		// Category 17
		// STATEMENT_CATEGORY_NOT_SPECIFIED_NOTICE
		keyworks = new LinkedList<>();
		STMNT_CATEG4KWRD.put(EnumStatementCategories.STATEMENT_CATEGORY_NOT_SPECIFIED_NOTICE, keyworks);
		
	}
}
