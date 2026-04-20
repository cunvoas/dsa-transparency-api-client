package eu.europa.ec.dsa.transparency.file;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import eu.europa.ec.dsa.transparency.helper.DsaReportDto;
import eu.europa.ec.dsa.transparency.helper.DsaReportHelper;
import eu.europa.ec.dsa.transparency.model.file.Model01ReportIdentification;
import eu.europa.ec.dsa.transparency.model.file.Model03MemberStatesOrders;
import eu.europa.ec.dsa.transparency.model.file.Model05OwnInitiativeIllegal;
import eu.europa.ec.dsa.transparency.model.file.Model06OwnInitiativeTC;
import eu.europa.ec.dsa.transparency.model.file.Model07AppealsAndRecidivism;
import eu.europa.ec.dsa.transparency.model.file.Model08AutomatedMeans;
import eu.europa.ec.dsa.transparency.model.file.Model09HumanResources;
import eu.europa.ec.dsa.transparency.model.file.Model10Amar;
import eu.europa.ec.dsa.transparency.model.file.Model11Qualitative;
import eu.europa.ec.dsa.transparency.model.file.ModelDsaFile;

class TestDsaFileService {
    private DsaFileService service;
    private DsaReportHelper helper;

    @BeforeEach
    void setUp() throws Exception {
        service = new DsaFileService();
        helper = mock(DsaReportHelper.class);
        // Inject mock helper using reflection
        Field field = DsaFileService.class.getDeclaredField("dsaReportHelper");
        field.setAccessible(true);
        field.set(service, helper);
        // Mock template and workbook
        when(helper.getTemplatePath(anyString())).thenReturn("template.xlsx");
        when(helper.openWorkbookFromTemplate(anyString())).thenReturn(new DsaReportDto());
    }

    @AfterEach
    void tearDown() {
        service = null;
        helper = null;
    }

    @Test
    void testProduce_allSheetsPopulated() throws Exception {
        // Create sample data for all sheets
        ModelDsaFile model = new ModelDsaFile(
            List.of(new Model01ReportIdentification("a","b","c","d")),
            List.of(mock(Model03MemberStatesOrders.class)),
            List.of(mock(Model05OwnInitiativeIllegal.class)),
            List.of(mock(Model06OwnInitiativeTC.class)),
            List.of(mock(Model07AppealsAndRecidivism.class)),
            List.of(mock(Model08AutomatedMeans.class)),
            List.of(mock(Model09HumanResources.class)),
            List.of(mock(Model10Amar.class)),
            List.of(mock(Model11Qualitative.class))
        );
        DsaReportDto file = service.produce("fr", model);
//        assertNotNull(file);
//        assertTrue(file.exists());
//        assertTrue(file.length() > 0);
        // Verify helper methods called
        verify(helper).writeFolder01(any(), any());
        verify(helper).writeFolder03(any(), any());
        verify(helper).writeFolder05(any(), any());
        verify(helper).writeFolder06(any(), any());
        verify(helper).writeFolder07(any(), any());
        verify(helper).writeFolder08(any(), any());
        verify(helper).writeFolder09(any(), any());
        verify(helper).writeFolder10(any(), any());
        verify(helper).writeFolder11(any(), any());
//        file.delete();
    }

    @Test
    void testProduce_someSheetsEmptyOrNull() throws Exception {
        ModelDsaFile model = new ModelDsaFile(
            List.of(new Model01ReportIdentification("a","b","c","d")), // populated
            List.of(), // empty
            null, // null
            List.of(mock(Model06OwnInitiativeTC.class)), // populated
            List.of(), // empty
            null, // null
            List.of(mock(Model09HumanResources.class)), // populated
            List.of(), // empty
            null // null
        );
        DsaReportDto file = service.produce("en", model);
//        assertNotNull(file);
//        assertTrue(file.exists());
//        assertTrue(file.length() > 0);
        // Only populated sheets should trigger helper methods
        verify(helper).writeFolder01(any(), any());
        verify(helper, never()).writeFolder03(any(), any());
        verify(helper, never()).writeFolder05(any(), any());
        verify(helper).writeFolder06(any(), any());
        verify(helper, never()).writeFolder07(any(), any());
        verify(helper, never()).writeFolder08(any(), any());
        verify(helper).writeFolder09(any(), any());
        verify(helper, never()).writeFolder10(any(), any());
        verify(helper, never()).writeFolder11(any(), any());
//        file.delete();
    }

    @Test
    void testProduce_allSheetsEmptyOrNull() throws Exception {
        ModelDsaFile model = new ModelDsaFile(
            List.of(),
            null,
            List.of(),
            null,
            List.of(),
            null,
            List.of(),
            null,
            List.of()
        );
        DsaReportDto file = service.produce("en", model);
//        assertNotNull(file);
//        assertTrue(file.exists());
//        assertTrue(file.length() > 0);
        // No helper methods should be called
        verify(helper, never()).writeFolder01(any(), any());
        verify(helper, never()).writeFolder03(any(), any());
        verify(helper, never()).writeFolder05(any(), any());
        verify(helper, never()).writeFolder06(any(), any());
        verify(helper, never()).writeFolder07(any(), any());
        verify(helper, never()).writeFolder08(any(), any());
        verify(helper, never()).writeFolder09(any(), any());
        verify(helper, never()).writeFolder10(any(), any());
        verify(helper, never()).writeFolder11(any(), any());
//        file.delete();
    }
}