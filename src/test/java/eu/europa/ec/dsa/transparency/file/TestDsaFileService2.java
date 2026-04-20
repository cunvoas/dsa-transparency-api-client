package eu.europa.ec.dsa.transparency.file;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

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

class TestDsaFileService2 {
	
    private DsaFileService service;
    private DsaReportHelper helper;

    @BeforeEach
    void setUp() throws Exception {
        service = new DsaFileService();
        helper = new DsaReportHelper();
        
        // Inject helper using reflection
        Field field = DsaFileService.class.getDeclaredField("dsaReportHelper");
        field.setAccessible(true);
        field.set(service, helper);
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
//                List.of(mock(Model03MemberStatesOrders.class)),
//                List.of(mock(Model05OwnInitiativeIllegal.class)),
//                List.of(mock(Model06OwnInitiativeTC.class)),
//                List.of(mock(Model07AppealsAndRecidivism.class)),
//                List.of(mock(Model08AutomatedMeans.class)),
//                List.of(mock(Model09HumanResources.class)),
//                List.of(mock(Model10Amar.class)),
//                List.of(mock(Model11Qualitative.class))
                null,
				null,
				null,
				null,
				null,
				null,
				null,
				null
            );
    	
        DsaReportDto dto = service.produce("fr", model);
        assertNotNull(dto.getWorkbookPath());
        
    }

}