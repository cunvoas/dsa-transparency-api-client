package eu.europa.ec.dsa.transparency.model.api; 
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import eu.europa.ec.dsa.transparency.model.enums.EnumAccountType;
import eu.europa.ec.dsa.transparency.model.enums.EnumAutomatedDecision;
import eu.europa.ec.dsa.transparency.model.enums.EnumAutomatedDetection;
import eu.europa.ec.dsa.transparency.model.enums.EnumContentType;
import eu.europa.ec.dsa.transparency.model.enums.EnumDecisionAccount;
import eu.europa.ec.dsa.transparency.model.enums.EnumDecisionGrounds;
import eu.europa.ec.dsa.transparency.model.enums.EnumDecisionMonetaries;
import eu.europa.ec.dsa.transparency.model.enums.EnumDecisionProvisions;
import eu.europa.ec.dsa.transparency.model.enums.EnumDecisionVisibilities;
import eu.europa.ec.dsa.transparency.model.enums.EnumIncompatibleContentIllegals;
import eu.europa.ec.dsa.transparency.model.enums.EnumSourceType;
import eu.europa.ec.dsa.transparency.model.enums.EnumStatementCategories;
import eu.europa.ec.dsa.transparency.model.enums.EnumTerritorialScope;

/**
 * Model representing a statement.
 */
public class StatementModel{
    public ContentId content_id;
    public List<EnumDecisionVisibilities> decision_visibility;
    public EnumDecisionMonetaries decision_monetary;
    public EnumDecisionProvisions decision_provision;
    public EnumDecisionAccount decision_account;
    public EnumAccountType account_type;
    public EnumDecisionGrounds decision_ground;
    public String decision_ground_reference_url;
    public String incompatible_content_ground;
    public String incompatible_content_explanation;
    public EnumIncompatibleContentIllegals incompatible_content_illegal;
    public List<EnumContentType> content_type;
    public EnumStatementCategories category;
    public List<EnumTerritorialScope> territorial_scope;
    public String content_language;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date content_date;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date application_date;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date end_date_monetary_restriction;
    public String decision_facts;
    public EnumSourceType source_type;
    public EnumAutomatedDetection automated_detection;
    public EnumAutomatedDecision automated_decision;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date  end_date_visibility_restriction;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date  end_date_account_restriction;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date  end_date_service_restriction;
    public String uuid;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    public Date created_at;
    public Long id;
    public String platform_name;
    public String permalink;
    public String self;
    public String puid;
}
