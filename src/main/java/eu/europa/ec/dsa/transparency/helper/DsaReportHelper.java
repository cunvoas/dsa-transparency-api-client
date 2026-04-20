package eu.europa.ec.dsa.transparency.helper;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.spi.FileSystemProvider;
import java.util.Collections;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import eu.europa.ec.dsa.transparency.model.file.Model01ReportIdentification;
import eu.europa.ec.dsa.transparency.model.file.Model03MemberStatesOrders;
import eu.europa.ec.dsa.transparency.model.file.Model05OwnInitiativeIllegal;
import eu.europa.ec.dsa.transparency.model.file.Model06OwnInitiativeTC;
import eu.europa.ec.dsa.transparency.model.file.Model07AppealsAndRecidivism;
import eu.europa.ec.dsa.transparency.model.file.Model08AutomatedMeans;
import eu.europa.ec.dsa.transparency.model.file.Model09HumanResources;
import eu.europa.ec.dsa.transparency.model.file.Model10Amar;
import eu.europa.ec.dsa.transparency.model.file.Model11Qualitative;
import lombok.extern.slf4j.Slf4j;


/**
 * Helper class for DSA report operations.
 * <p>
 * Provides methods to read, write, and manipulate DSA transparency report data in XLSX format.
 * Includes utilities for working with report models and Excel sheets.
 */
@Slf4j
public class DsaReportHelper {
	
	/**
	 * Récupère le chemin d'un fichier, y compris depuis un JAR en production.
	 * @param file nom du fichier à récupérer
	 * @return chemin du fichier sous forme de Path
	 * @throws URISyntaxException si l'URI est invalide
	 * @throws IOException si une erreur d'accès survient
	 */
	protected Path getFilePath(String file) throws URISyntaxException, IOException {
		URI uri = getClass().getClassLoader().getResource(file).toURI();

		if("jar".equals(uri.getScheme())){
		    for (FileSystemProvider provider: FileSystemProvider.installedProviders()) {
		        if (provider.getScheme().equalsIgnoreCase("jar")) {
		            try {
		                provider.getFileSystem(uri);
		            } catch (FileSystemNotFoundException e) {
		                // in this case we need to initialize it first:
		                provider.newFileSystem(uri, Collections.emptyMap());
		            }
		        }
		    }
		}
		return  Paths.get(uri);
	}
	
	public String getTemplatePath(String lang) {
		String prefix="";
		if (lang==null || lang.isEmpty() || lang.length()!=2) {
			prefix="";
		} else {
			prefix=lang.toUpperCase()+"_";
		}
		return "templates/" + prefix + "Annex_I__Templates_for_Transparency_Reports.XLSX";
	}

    public DsaReportDto openWorkbookFromTemplate(String templateLocation) throws IOException {
        Workbook workbook = null;
        DsaReportDto dto = new DsaReportDto();
        File tmpFile =null;
        try  {

        	Path templatePath = getFilePath(templateLocation);
        	
        	tmpFile =  File.createTempFile("dsa_report_template_", ".xlsx");
        	Path path2TmpFile =Path.of(tmpFile.getAbsolutePath());
        	log.info("TEMP File: {}", path2TmpFile.toString());
        	Files.copy(templatePath, path2TmpFile,  StandardCopyOption.REPLACE_EXISTING);
        	dto.setWorkbookPathTmp(path2TmpFile);
        	
        	
        	InputStream fis = Files.newInputStream(path2TmpFile);
        	
            workbook= new XSSFWorkbook(fis, true);
            dto.setWorkbook(workbook);
            dto.setFis(fis);
            
        } catch (Exception e) {
        	log.error("Error opening workbook from template: " + e.getMessage(), e);
           if (tmpFile!=null && tmpFile.exists()) {
               tmpFile.delete();
           }
           throw new IOException("Failed to open workbook from template: " + e.getMessage(), e);
        }
        return dto;
    }

    public void writeTheEnd( DsaReportDto dto) throws IOException {
	  try (FileOutputStream fos = new FileOutputStream(dto.getWorkbookPathTmp().toFile())) {
	        dto.getWorkbook().write(fos);
	    }
	    dto.getWorkbook().close();
	    log.debug("Workbook written and closed.");
	}
    		
    /**
     * Write Model01ReportIdentification data from an existing XLSX file.
     * @param filePath Path to the XLSX file.
     * @return List of Model01ReportIdentification objects.
     * @throws IOException If file cannot be read.
     */
    public void writeFolder01(Workbook workbook, List<Model01ReportIdentification> reportList) throws IOException {
        //Sheet sheet = workbook.getSheetAt(0);
        Sheet sheet = workbook.getSheet("1_identification_rapport");
        int rowIndex = 1;
        for (Model01ReportIdentification reportLine : reportList) {
            Row row = sheet.getRow(rowIndex);
            setCellValue(row.getCell(0), reportLine.applicability());
            setCellValue(row.getCell(1), reportLine.service());
            setCellValue(row.getCell(2), reportLine.indicator());
            setCellValue(row.getCell(3), reportLine.value());
            rowIndex++;
            
        }
    }

    /**
     * Write Model03MemberStatesOrders data to the "3_member_states_orders" sheet.
     * @param workbook The workbook to write to.
     * @param orderList List of Model03MemberStatesOrders objects.
     * @throws IOException If writing fails.
     */
    public void writeFolder03(Workbook workbook, List<Model03MemberStatesOrders> orderList) throws IOException {
        Sheet sheet = workbook.getSheetAt(2);
        int rowIndex = 2;
        for (Model03MemberStatesOrders orderLine : orderList) {
            Row row = sheet.getRow(rowIndex);
            setCellValue(row.getCell(0), orderLine.applicability());
            setCellValue(row.getCell(1), orderLine.service());
            setCellValue(row.getCell(2), orderLine.reportingPeriod());
            setCellValue(row.getCell(3), orderLine.categoryOfIllegalContent());
            setCellValue(row.getCell(4), orderLine.descriptionOfSubCategoryOther());
            setCellValue(row.getCell(5), orderLine.scope());
            setCellValue(row.getCell(6), orderLine.numberOfOrdersToActAgainstIllegalContentReceived());
            setCellValue(row.getCell(7), orderLine.numberOfSpecificItemsOfInformationIncludedInTotalNumberOfOrdersToActAgainstIllegalContent());
            setCellValue(row.getCell(8), orderLine.medianTimeToInformAuthorityOfReceiptOfOrderToActAgainstIllegalContent());
            setCellValue(row.getCell(9), orderLine.medianTimeToGiveEffectToOrderToActAgainstIllegalContent());
            setCellValue(row.getCell(10), orderLine.numberOfOrdersToProvideInformation());
            setCellValue(row.getCell(11), orderLine.medianTimeToInformAuthorityOfReceiptOfOrderToProvideInformation());
            setCellValue(row.getCell(12), orderLine.medianTimeToGiveEffectToOrderToProvideInformation());
            setCellValue(row.getCell(13), orderLine.contextualInfoOnNumberOfOrdersToActAgainstIllegalContentReceived());
            setCellValue(row.getCell(14), orderLine.contextualInfoOnNumberOfSpecificItemsOfInformationIncludedInTotalNumberOfOrdersToActAgainstIllegalContent());
            setCellValue(row.getCell(15), orderLine.contextualInfoOnMedianTimeToInformAuthorityOfReceiptOfOrderToActAgainstIllegalContent());
            setCellValue(row.getCell(16), orderLine.contextualInfoOnMedianTimeToGiveEffectToOrderToActAgainstIllegalContent());
            setCellValue(row.getCell(17), orderLine.contextualInfoOnNumberOfOrdersToProvideInformation());
            setCellValue(row.getCell(18), orderLine.contextualInfoOnMedianTimeToInformAuthorityOfReceiptOfOrderToProvideInformation());
            setCellValue(row.getCell(19), orderLine.contextualInfoOnMedianTimeToGiveEffectToOrderToProvideInformation());
            rowIndex++;
        }
    }

    /**
     * Write Model05OwnInitiativeIllegal data to the "5_own_initiative_illegal" sheet.
     * @param workbook The workbook to write to.
     * @param ownInitiativeList List of Model05OwnInitiativeIllegal objects.
     * @throws IOException If writing fails.
     */
    public void writeFolder05(Workbook workbook, List<Model05OwnInitiativeIllegal> ownInitiativeList) throws IOException {
        Sheet sheet = workbook.getSheetAt(4);
        int rowIndex = 2;
        for (Model05OwnInitiativeIllegal line : ownInitiativeList) {
            Row row = sheet.getRow(rowIndex);
            setCellValue(row.getCell(0), line.applicability());
            setCellValue(row.getCell(1), line.service());
            setCellValue(row.getCell(2), line.reportingPeriod());
            setCellValue(row.getCell(3), line.categoryOfIllegalContent());
            setCellValue(row.getCell(4), line.descriptionOfSubCategoryOther());
            setCellValue(row.getCell(5), line.numberOfNoticesReceived());
            setCellValue(row.getCell(6), line.numberOfNoticesReceivedFromTrustedFlaggers());
            setCellValue(row.getCell(7), line.numberOfSpecificItemsOfInformationIncludedInTotalNumberOfNotices());
            setCellValue(row.getCell(8), line.numberOfSpecificItemsOfInformationIncludedInTotalNumberOfNoticesByTrustedFlaggers());
            setCellValue(row.getCell(9), line.medianTimeToTakeAction());
            setCellValue(row.getCell(10), line.medianTimeToTakeActionTrustedFlaggerNotices());
            setCellValue(row.getCell(11), line.numberOfActionsTakenOnBasisOfLaw());
            setCellValue(row.getCell(12), line.numberOfActionsTakenOnBasisOfLawTrustedFlaggerNotices());
            setCellValue(row.getCell(13), line.numberOfActionsTakenOnBasisOfTermsAndConditions());
            setCellValue(row.getCell(14), line.numberOfActionsTakenOnBasisOfTermsAndConditionsTrustedFlaggerNotices());
            setCellValue(row.getCell(15), line.contextualInfoNumberOfNoticesReceived());
            setCellValue(row.getCell(16), line.contextualInfoNumberOfNoticesReceivedFromTrustedFlaggers());
            setCellValue(row.getCell(17), line.contextualInfoNumberOfSpecificItemsOfInformationIncludedInTotalNumberOfNotices());
            setCellValue(row.getCell(18), line.contextualInfoNumberOfSpecificItemsOfInformationIncludedInTotalNumberOfNoticesByTrustedFlaggers());
            setCellValue(row.getCell(19), line.contextualInfoMedianTimeToTakeAction());
            setCellValue(row.getCell(20), line.contextualInfoMedianTimeToTakeActionTrustedFlaggerNotices());
            setCellValue(row.getCell(21), line.contextualInfoNumberOfActionsTakenOnBasisOfLaw());
            setCellValue(row.getCell(22), line.contextualInfoNumberOfActionsTakenOnBasisOfLawTrustedFlaggerNotices());
            setCellValue(row.getCell(23), line.contextualInfoNumberOfActionsTakenOnBasisOfTermsAndConditions());
            setCellValue(row.getCell(24), line.contextualInfoNumberOfActionsTakenOnBasisOfTermsAndConditionsTrustedFlaggerNotices());
            rowIndex++;
        }
    }

    /**
     * Write Model06OwnInitiativeTC data to the "6_own_initiative_TC" sheet.
     * @param workbook The workbook to write to.
     * @param tcList List of Model06OwnInitiativeTC objects.
     * @throws IOException If writing fails.
     */
    public void writeFolder06(Workbook workbook, List<Model06OwnInitiativeTC> tcList) throws IOException {
        Sheet sheet = workbook.getSheetAt(5);
        int rowIndex = 2;
        for (Model06OwnInitiativeTC line : tcList) {
            Row row = sheet.getRow(rowIndex);
            setCellValue(row.getCell(0), line.applicability());
            setCellValue(row.getCell(1), line.service());
            setCellValue(row.getCell(2), line.reportingPeriod());
            setCellValue(row.getCell(3), line.categoryOfIncompatibilityWithProvidersTermsAndConditions());
            setCellValue(row.getCell(4), line.descriptionOfSubCategoryOther());
            setCellValue(row.getCell(5), line.numberOfMeasuresTakenAtProvidersOwnInitiative());
            setCellValue(row.getCell(6), line.numberOfMeasuresTakenAfterDetectionWithSolelyAutomatedMeans());
            setCellValue(row.getCell(7), line.visibilityRestrictionRemoval());
            setCellValue(row.getCell(8), line.visibilityRestrictionDisable());
            setCellValue(row.getCell(9), line.visibilityRestrictionDemoted());
            setCellValue(row.getCell(10), line.visibilityRestrictionAgeRestricted());
            setCellValue(row.getCell(11), line.visibilityRestrictionInteractionRestricted());
            setCellValue(row.getCell(12), line.visibilityRestrictionLabelled());
            setCellValue(row.getCell(13), line.visibilityRestrictionOther());
            setCellValue(row.getCell(14), line.monetaryRestrictionSuspension());
            setCellValue(row.getCell(15), line.monetaryRestrictionTermination());
            setCellValue(row.getCell(16), line.monetaryRestrictionOther());
            setCellValue(row.getCell(17), line.provisionOfServiceSuspension());
            setCellValue(row.getCell(18), line.provisionOfServiceTermination());
            setCellValue(row.getCell(19), line.accountRestrictionSuspension());
            setCellValue(row.getCell(20), line.accountRestrictionTermination());
            setCellValue(row.getCell(21), line.contextualInfoNumberOfMeasuresTakenAtProvidersOwnInitiative());
            setCellValue(row.getCell(22), line.contextualInfoNumberOfMeasuresTakenAfterDetectionWithSolelyAutomatedMeans());
            setCellValue(row.getCell(23), line.contextualInfoVisibilityRestrictionRemoval());
            setCellValue(row.getCell(24), line.contextualInfoVisibilityRestrictionDisable());
            setCellValue(row.getCell(25), line.contextualInfoVisibilityRestrictionDemoted());
            setCellValue(row.getCell(26), line.contextualInfoVisibilityRestrictionAgeRestricted());
            setCellValue(row.getCell(27), line.contextualInfoVisibilityRestrictionInteractionRestricted());
            setCellValue(row.getCell(28), line.contextualInfoVisibilityRestrictionLabelled());
            setCellValue(row.getCell(29), line.contextualInfoVisibilityRestrictionOther());
            setCellValue(row.getCell(30), line.contextualInfoMonetaryRestrictionSuspension());
            setCellValue(row.getCell(31), line.contextualInfoMonetaryRestrictionTermination());
            setCellValue(row.getCell(32), line.contextualInfoMonetaryRestrictionOther());
            setCellValue(row.getCell(33), line.contextualInfoProvisionOfServiceSuspension());
            setCellValue(row.getCell(34), line.contextualInfoProvisionOfServiceTermination());
            setCellValue(row.getCell(35), line.contextualInfoAccountRestrictionSuspension());
            setCellValue(row.getCell(36), line.contextualInfoAccountRestrictionTermination());
            rowIndex++;
        }
    }

    /**
     * Write Model07AppealsAndRecidivism data to the "7_appeals_and_recidivism" sheet.
     * @param workbook The workbook to write to.
     * @param appealsList List of Model07AppealsAndRecidivism objects.
     * @throws IOException If writing fails.
     */
    public void writeFolder07(Workbook workbook, List<Model07AppealsAndRecidivism> appealsList) throws IOException {
        Sheet sheet = workbook.getSheetAt(6);
        int rowIndex = 2;
        for (Model07AppealsAndRecidivism line : appealsList) {
            Row row = sheet.getRow(rowIndex);
            setCellValue(row.getCell(0), line.applicability());
            setCellValue(row.getCell(1), line.service());
            setCellValue(row.getCell(2), line.reportingPeriod());
            setCellValue(row.getCell(3), line.section());
            setCellValue(row.getCell(4), line.indicator());
            setCellValue(row.getCell(5), line.scope());
            setCellValue(row.getCell(6), line.value());
            setCellValue(row.getCell(7), line.contextualInformation());
            rowIndex++;
        }
    }

    /**
     * Write Model08AutomatedMeans data to the "8_automated_means" sheet.
     * @param workbook The workbook to write to.
     * @param automatedMeansList List of Model08AutomatedMeans objects.
     * @throws IOException If writing fails.
     */
    public void writeFolder08(Workbook workbook, List<Model08AutomatedMeans> automatedMeansList) throws IOException {
        Sheet sheet = workbook.getSheetAt(7);
        int rowIndex = 2;
        for (Model08AutomatedMeans line : automatedMeansList) {
            Row row = sheet.getRow(rowIndex);
            setCellValue(row.getCell(0), line.applicability());
            setCellValue(row.getCell(1), line.service());
            setCellValue(row.getCell(2), line.reportingPeriod());
            setCellValue(row.getCell(3), line.section());
            setCellValue(row.getCell(4), line.indicator());
            setCellValue(row.getCell(5), line.scope());
            setCellValue(row.getCell(6), line.value());
            setCellValue(row.getCell(7), line.contextualInformation());
            rowIndex++;
        }
    }

    /**
     * Write Model09HumanResources data to the "9_human_resources" sheet.
     * @param workbook The workbook to write to.
     * @param humanResourcesList List of Model09HumanResources objects.
     * @throws IOException If writing fails.
     */
    public void writeFolder09(Workbook workbook, List<Model09HumanResources> humanResourcesList) throws IOException {
        Sheet sheet = workbook.getSheetAt(8);
        int rowIndex = 2;
        for (Model09HumanResources line : humanResourcesList) {
            Row row = sheet.getRow(rowIndex);
            setCellValue(row.getCell(0), line.applicability());
            setCellValue(row.getCell(1), line.service());
            setCellValue(row.getCell(2), line.reportingPeriod());
            setCellValue(row.getCell(3), line.section());
            setCellValue(row.getCell(4), line.indicator());
            setCellValue(row.getCell(5), line.scope());
            setCellValue(row.getCell(6), line.value());
            setCellValue(row.getCell(7), line.contextualInformation());
            rowIndex++;
        }
    }

    /**
     * Write Model10Amar data to the "10_amar" sheet.
     * @param workbook The workbook to write to.
     * @param amarList List of Model10Amar objects.
     * @throws IOException If writing fails.
     */
    public void writeFolder10(Workbook workbook, List<Model10Amar> amarList) throws IOException {
        Sheet sheet = workbook.getSheetAt(9);
        int rowIndex = 2;
        for (Model10Amar line : amarList) {
            Row row = sheet.getRow(rowIndex);
            setCellValue(row.getCell(0), line.applicability());
            setCellValue(row.getCell(1), line.service());
            setCellValue(row.getCell(2), line.reportingPeriod());
            setCellValue(row.getCell(3), line.section());
            setCellValue(row.getCell(4), line.indicator());
            setCellValue(row.getCell(5), line.scope());
            setCellValue(row.getCell(6), line.value());
            rowIndex++;
        }
    }

    /**
     * Write Model11Qualitative data to the "11_qualitative" sheet.
     * @param workbook The workbook to write to.
     * @param qualitativeList List of Model11Qualitative objects.
     * @throws IOException If writing fails.
     */
    public void writeFolder11(Workbook workbook, List<Model11Qualitative> qualitativeList) throws IOException {
        Sheet sheet = workbook.getSheetAt(10);
        int rowIndex = 2;
        for (Model11Qualitative line : qualitativeList) {
            Row row = sheet.getRow(rowIndex);
            setCellValue(row.getCell(0), line.applicability());
            setCellValue(row.getCell(1), line.service());
            setCellValue(row.getCell(2), line.reportingPeriod());
            setCellValue(row.getCell(3), line.indicator());
            setCellValue(row.getCell(4), line.value());
            rowIndex++;
        }
    }




    private void setCellValue(Cell cell, Object value) {
		if (value instanceof String) {
			cell.setCellValue((String) value);
		} else if (value instanceof Double) {
			cell.setCellValue(String.valueOf((Double) value));
		} else if (value instanceof Integer) {
			cell.setCellValue(String.valueOf((Integer) value));
		} else if (value instanceof Float) {
			cell.setCellValue(String.valueOf((Float) value));
		} else if (value instanceof Double) {
			cell.setCellValue(String.valueOf((Double) value));
		} else if (value instanceof BigDecimal) {
			cell.setCellValue(String.valueOf((BigDecimal) value));
		} else if (value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
		} else if (value != null) {
			cell.setCellValue(value.toString());
		} else {
			cell.setCellValue("");
		}
    	
    }
    
    private String getCellValue(Cell cell) {
        if (cell == null) return "";
        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf(cell.getNumericCellValue());
        } else if (cell.getCellType() == CellType.BOOLEAN) {
            return String.valueOf(cell.getBooleanCellValue());
        } else {
            return "";
        }
    }
}