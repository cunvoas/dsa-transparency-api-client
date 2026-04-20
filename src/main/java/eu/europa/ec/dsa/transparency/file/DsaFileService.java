package eu.europa.ec.dsa.transparency.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.europa.ec.dsa.transparency.helper.DsaReportDto;
import eu.europa.ec.dsa.transparency.helper.DsaReportHelper;
import eu.europa.ec.dsa.transparency.model.file.ModelDsaFile;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DsaFileService {

	@Autowired
	private DsaReportHelper dsaReportHelper;
	
	public DsaReportDto produce(String lang, ModelDsaFile modelDsa) {
		DsaReportDto dto = null;
		String path = dsaReportHelper.getTemplatePath(lang);
		System.out.println(path);
		try {
			dto = dsaReportHelper.openWorkbookFromTemplate(path);
			Workbook workbook = dto.getWorkbook();
			

			if (modelDsa.sheet01() != null && !modelDsa.sheet01().isEmpty()) {
				dsaReportHelper.writeFolder01(workbook, modelDsa.sheet01());
			}
			if (modelDsa.sheet03() != null && !modelDsa.sheet03().isEmpty()) {
				dsaReportHelper.writeFolder03(workbook, modelDsa.sheet03());
			}
			if (modelDsa.sheet05() != null && !modelDsa.sheet05().isEmpty()) {
				dsaReportHelper.writeFolder05(workbook, modelDsa.sheet05());
			}
			if (modelDsa.sheet06() != null && !modelDsa.sheet06().isEmpty()) {
				dsaReportHelper.writeFolder06(workbook, modelDsa.sheet06());
			}
			if (modelDsa.sheet07() != null && !modelDsa.sheet07().isEmpty()) {
				dsaReportHelper.writeFolder07(workbook, modelDsa.sheet07());
			}
			if (modelDsa.sheet08() != null && !modelDsa.sheet08().isEmpty()) {
				dsaReportHelper.writeFolder08(workbook, modelDsa.sheet08());
			}
			if (modelDsa.sheet09() != null && !modelDsa.sheet09().isEmpty()) {
				dsaReportHelper.writeFolder09(workbook, modelDsa.sheet09());
			}
			if (modelDsa.sheet10() != null && !modelDsa.sheet10().isEmpty()) {
				dsaReportHelper.writeFolder10(workbook, modelDsa.sheet10());
			}
			if (modelDsa.sheet11() != null && !modelDsa.sheet11().isEmpty()) {
				dsaReportHelper.writeFolder11(workbook, modelDsa.sheet11());
			}
			
			dsaReportHelper.writeTheEnd(dto);

			Path dst = Path.of("/home/cus/Bureau/DSA-DEMO.xlsx");
			dto.setWorkbookPath(dst);
			Files.copy(dto.getWorkbookPathTmp(), dst,  StandardCopyOption.REPLACE_EXISTING);
			log.info("File written to: " + dst.toAbsolutePath());
			
			
//			Files.deleteIfExists(dto.getWorkbookPathTmp());
			dto.setWorkbookPathTmp(null);
			
		} catch (IOException e) {
			log.error("Error producing DSA report", e);
			throw new RuntimeException("Error producing DSA report", e);
		}
		return dto;
	}
	
}