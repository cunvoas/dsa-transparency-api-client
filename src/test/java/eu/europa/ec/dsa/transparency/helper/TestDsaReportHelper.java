package eu.europa.ec.dsa.transparency.helper;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import eu.europa.ec.dsa.transparency.model.enums.EnumKeyword;
import eu.europa.ec.dsa.transparency.model.enums.EnumStatementCategories;
import eu.europa.ec.dsa.transparency.model.file.Model01ReportIdentification;

class TestDsaReportHelper {

    private DsaReportHelper helper;

    @BeforeEach
    void setUp() {
        helper = new DsaReportHelper();
    }

    @Test
    void testGetTemplatePath_nullLang() {
        String path = helper.getTemplatePath(null);
        assertEquals("templates/Annex_I__Templates_for_Transparency_Reports.XLSX", path);
    }

    @Test
    void testGetTemplatePath_emptyLang() {
        String path = helper.getTemplatePath("");
        assertEquals("templates/Annex_I__Templates_for_Transparency_Reports.XLSX", path);
    }

    @Test
    void testGetTemplatePath_invalidLang() {
        String path = helper.getTemplatePath("eng");
        assertEquals("templates/Annex_I__Templates_for_Transparency_Reports.XLSX", path);
    }

    @Test
    void testGetTemplatePath_validLang() {
        String path = helper.getTemplatePath("fr");
        assertEquals("templates/FR_Annex_I__Templates_for_Transparency_Reports.XLSX", path);
    }

    @Test
    void testSetCellValue_string() throws Exception {
        Cell cell = mock(Cell.class);
        var method = helper.getClass().getDeclaredMethod("setCellValue", Cell.class, Object.class);
        method.setAccessible(true);
        method.invoke(helper, cell, "test");
        verify(cell).setCellValue("test");
    }

    @Test
    void testSetCellValue_double() throws Exception {
        Cell cell = mock(Cell.class);
        var method = helper.getClass().getDeclaredMethod("setCellValue", Cell.class, Object.class);
        method.setAccessible(true);
        method.invoke(helper, cell, 1.23d);
        verify(cell).setCellValue("1.23");
    }

    @Test
    void testSetCellValue_integer() throws Exception {
        Cell cell = mock(Cell.class);
        var method = helper.getClass().getDeclaredMethod("setCellValue", Cell.class, Object.class);
        method.setAccessible(true);
        method.invoke(helper, cell, 42);
        verify(cell).setCellValue("42");
    }

    @Test
    void testSetCellValue_float() throws Exception {
        Cell cell = mock(Cell.class);
        var method = helper.getClass().getDeclaredMethod("setCellValue", Cell.class, Object.class);
        method.setAccessible(true);
        method.invoke(helper, cell, 3.14f);
        verify(cell).setCellValue("3.14");
    }

    @Test
    void testSetCellValue_bigDecimal() throws Exception {
        Cell cell = mock(Cell.class);
        var method = helper.getClass().getDeclaredMethod("setCellValue", Cell.class, Object.class);
        method.setAccessible(true);
        method.invoke(helper, cell, new BigDecimal("99.99"));
        verify(cell).setCellValue("99.99");
    }

    @Test
    void testSetCellValue_boolean() throws Exception {
        Cell cell = mock(Cell.class);
        var method = helper.getClass().getDeclaredMethod("setCellValue", Cell.class, Object.class);
        method.setAccessible(true);
        method.invoke(helper, cell, true);
        verify(cell).setCellValue(true);
    }

    @Test
    void testSetCellValue_null() throws Exception {
        Cell cell = mock(Cell.class);
        var method = helper.getClass().getDeclaredMethod("setCellValue", Cell.class, Object.class);
        method.setAccessible(true);
        method.invoke(helper, cell, null);
        verify(cell).setCellValue("");
    }

    @Test
    void testGetCellValue_string() throws Exception {
        Cell cell = mock(Cell.class);
        when(cell.getCellType()).thenReturn(CellType.STRING);
        when(cell.getStringCellValue()).thenReturn("abc");
        var method = helper.getClass().getDeclaredMethod("getCellValue", Cell.class);
        method.setAccessible(true);
        String value = (String) method.invoke(helper, cell);
        assertEquals("abc", value);
    }

    @Test
    void testGetCellValue_numeric() throws Exception {
        Cell cell = mock(Cell.class);
        when(cell.getCellType()).thenReturn(CellType.NUMERIC);
        when(cell.getNumericCellValue()).thenReturn(123.45);
        var method = helper.getClass().getDeclaredMethod("getCellValue", Cell.class);
        method.setAccessible(true);
        String value = (String) method.invoke(helper, cell);
        assertEquals("123.45", value);
    }

    @Test
    void testGetCellValue_boolean() throws Exception {
        Cell cell = mock(Cell.class);
        when(cell.getCellType()).thenReturn(CellType.BOOLEAN);
        when(cell.getBooleanCellValue()).thenReturn(true);
        var method = helper.getClass().getDeclaredMethod("getCellValue", Cell.class);
        method.setAccessible(true);
        String value = (String) method.invoke(helper, cell);
        assertEquals("true", value);
    }

    @Test
    void testGetCellValue_nullCell() throws Exception {
        var method = helper.getClass().getDeclaredMethod("getCellValue", Cell.class);
        method.setAccessible(true);
        String value = (String) method.invoke(helper, (Cell) null);
        assertEquals("", value);
    }

    @Test
    void testWriteFolder01() throws Exception {
        Workbook workbook = mock(Workbook.class);
        Sheet sheet = mock(Sheet.class);
        Row row = mock(Row.class);
        Cell cell0 = mock(Cell.class);
        Cell cell1 = mock(Cell.class);
        Cell cell2 = mock(Cell.class);
        Cell cell3 = mock(Cell.class);

        when(workbook.getSheet("1_report_identification")).thenReturn(sheet);
        when(sheet.getRow(1)).thenReturn(row);
        when(row.getCell(0)).thenReturn(cell0);
        when(row.getCell(1)).thenReturn(cell1);
        when(row.getCell(2)).thenReturn(cell2);
        when(row.getCell(3)).thenReturn(cell3);

        Model01ReportIdentification report = new Model01ReportIdentification("applicability", "service", "indicator", "value");

        List<Model01ReportIdentification> reportList = Arrays.asList(report);

        helper.writeFolder01(workbook, reportList);

        verify(cell0).setCellValue("applicability");
        verify(cell1).setCellValue("service");
        verify(cell2).setCellValue("indicator");
        verify(cell3).setCellValue("value");
    }


    @Test
    void testAllCategoriesHaveKeywordsList() {
        MemberStateOrders instance = MemberStateOrders.getInstance();
        Map<EnumStatementCategories, List<EnumKeyword>> map = instance.get();
        for (EnumStatementCategories category : EnumStatementCategories.values()) {
            assertTrue(map.containsKey(category), "Map should contain category: " + category);
            assertNotNull(map.get(category), "Keywords list should not be null for category: " + category);
        }
    }

    @Test
    void testKeywordsContentForKnownCategories() {
        MemberStateOrders instance = MemberStateOrders.getInstance();
        // Example: Animal Welfare
        List<EnumKeyword> animalWelfare = instance.get(EnumStatementCategories.STATEMENT_CATEGORY_ANIMAL_WELFARE);
        assertTrue(animalWelfare.contains(EnumKeyword.KEYWORD_ANIMAL_HARM));
        assertTrue(animalWelfare.contains(EnumKeyword.KEYWORD_UNLAWFUL_SALE_ANIMALS));
        assertTrue(animalWelfare.contains(EnumKeyword.KEYWORD_OTHER));
    }

    @Test
    void testThreadSafetySingleton() throws InterruptedException {
        final MemberStateOrders[] instances = new MemberStateOrders[2];
        Thread t1 = new Thread(() -> instances[0] = MemberStateOrders.getInstance());
        Thread t2 = new Thread(() -> instances[1] = MemberStateOrders.getInstance());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        assertSame(instances[0], instances[1], "Singleton should be thread-safe");
    }

    @Test
    void testGetReturnsSameMapReference() {
        MemberStateOrders instance = MemberStateOrders.getInstance();
        Map<EnumStatementCategories, List<EnumKeyword>> map1 = instance.get();
        Map<EnumStatementCategories, List<EnumKeyword>> map2 = instance.get();
        assertSame(map1, map2, "get() should always return the same map reference");
    }
}
