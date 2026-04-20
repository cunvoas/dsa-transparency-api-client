package eu.europa.ec.dsa.transparency.helper;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Map;
import eu.europa.ec.dsa.transparency.model.enums.EnumKeyword;
import eu.europa.ec.dsa.transparency.model.enums.EnumStatementCategories;

class TestMemberStateOrders {
    @Test
    void testSingletonInstance() {
        MemberStateOrders instance1 = MemberStateOrders.getInstance();
        MemberStateOrders instance2 = MemberStateOrders.getInstance();
        assertSame(instance1, instance2, "Instances should be the same (singleton)");
    }

    @Test
    void testGetMapNotNull() {
        MemberStateOrders instance = MemberStateOrders.getInstance();
        Map<EnumStatementCategories, List<EnumKeyword>> map = instance.get();
        assertNotNull(map, "Map should not be null");
    }

    @Test
    void testGetKeywordsForCategory() {
        MemberStateOrders instance = MemberStateOrders.getInstance();
        List<EnumKeyword> keywords = instance.get(EnumStatementCategories.STATEMENT_CATEGORY_ANIMAL_WELFARE);
        assertNotNull(keywords, "Keywords list should not be null");
        assertTrue(keywords.contains(EnumKeyword.KEYWORD_ANIMAL_HARM), "Should contain KEYWORD_ANIMAL_HARM");
    }

    @Test
    void testEmptyKeywordsForNotSpecifiedOrder() {
        MemberStateOrders instance = MemberStateOrders.getInstance();
        List<EnumKeyword> keywords = instance.get(EnumStatementCategories.STATEMENT_CATEGORY_NOT_SPECIFIED_ORDER);
        assertNotNull(keywords, "Keywords list should not be null");
        assertTrue(keywords.isEmpty(), "Keywords list should be empty for NOT_SPECIFIED_ORDER");
    }
}
