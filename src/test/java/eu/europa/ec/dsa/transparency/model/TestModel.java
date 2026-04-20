package eu.europa.ec.dsa.transparency.model;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import eu.europa.ec.dsa.transparency.model.api.ContentId;
import eu.europa.ec.dsa.transparency.model.api.StatementModel;
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

class TestModel {
	
	ObjectMapper mapper = new ObjectMapper();

	@Test
	void test() {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		StatementModel st = new StatementModel();
		
		ContentId ci = new ContentId();
		ci.gtin="123456790123";
		st.content_id=ci;
		
		List<EnumDecisionVisibilities> dv = new ArrayList<>();
		dv.add(EnumDecisionVisibilities.DECISION_VISIBILITY_CONTENT_AGE_RESTRICTED);
		dv.add(EnumDecisionVisibilities.DECISION_VISIBILITY_CONTENT_REMOVED);
		st.decision_visibility=dv;
		
		st.decision_monetary=EnumDecisionMonetaries.DECISION_MONETARY_OTHER;
		st.decision_provision=EnumDecisionProvisions.DECISION_PROVISION_PARTIAL_SUSPENSION;
		st.decision_account=EnumDecisionAccount.DECISION_ACCOUNT_SUSPENDED;
		
		st.account_type=EnumAccountType.ACCOUNT_TYPE_BUSINESS;
		st.decision_ground=EnumDecisionGrounds.DECISION_GROUND_ILLEGAL_CONTENT;
		st.decision_ground_reference_url="the_url";
		st.incompatible_content_ground="bla";
		st.incompatible_content_explanation="bla";
		st.incompatible_content_illegal=EnumIncompatibleContentIllegals.INCOMPATIBLE_CONTENT_ILLEGAL_NO;
		
		List<EnumContentType> ct = new ArrayList<>();
		ct.add(EnumContentType.CONTENT_TYPE_PRODUCT);
		st.content_type=ct;
		
		st.category=EnumStatementCategories.STATEMENT_CATEGORY_CONSUMER_INFORMATION;
		
		List<EnumTerritorialScope> ts = new ArrayList<>();
		ts.add(EnumTerritorialScope.FRANCE);
		ts.add(EnumTerritorialScope.ITALY);
		st.territorial_scope=ts;
		
		st.content_language=Locale.FRENCH.toLanguageTag();
		st.content_date=new Date();
		st.application_date=new Date();
		st.end_date_monetary_restriction=new Date();
		st.decision_facts="text_decision_facts";
		st.source_type=EnumSourceType.SOURCE_ARTICLE_16;
		st.automated_detection=EnumAutomatedDetection.AUTOMATED_DETECTION_YES;
		st.automated_decision=EnumAutomatedDecision.AUTOMATED_DECISION_PARTIALLY;
		st.end_date_visibility_restriction=new Date();
		st.end_date_account_restriction=new Date();
		st.end_date_service_restriction=new Date();
		st.uuid="the_uuid";
		st.created_at=new Date();
		st.id=Long.MAX_VALUE;
		st.platform_name="the_platform_name";
		st.permalink="the_permalink";
		st.self="the_selft_link";
		st.puid="the_puid";
		
		try {
			String json = mapper.writeValueAsString(st);
			System.out.println(json);
			Assert.notNull(json, "json message");
			
			
			StatementModel resp = mapper.readValue(json, StatementModel.class);
			Assert.notNull(resp, "response obj");
			
			System.out.println(resp.decision_visibility);
		} catch (JsonProcessingException e) {
			fail(e.getMessage());
		}
	}

}
