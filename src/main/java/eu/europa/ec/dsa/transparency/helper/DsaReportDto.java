package eu.europa.ec.dsa.transparency.helper;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;

import org.apache.poi.ss.usermodel.Workbook;

public class DsaReportDto {
	private Workbook workbook;
	private Path workbookPath;
	private Path workbookPathTmp;
	private InputStream fis;
	private OutputStream fos;
	
	
	public Workbook getWorkbook() {
		return workbook;
	}
	public void setWorkbook(Workbook workbook) {
		this.workbook = workbook;
	}
	public Path getWorkbookPath() {
		return workbookPath;
	}
	public void setWorkbookPath(Path workbookPath) {
		this.workbookPath = workbookPath;
	}
	public Path getWorkbookPathTmp() {
		return workbookPathTmp;
	}
	public void setWorkbookPathTmp(Path workbookPathTmp) {
		this.workbookPathTmp = workbookPathTmp;
	}
	public InputStream getFis() {
		return fis;
	}
	public void setFis(InputStream fis) {
		this.fis = fis;
	}
	public OutputStream getFos() {
		return fos;
	}
	public void setFos(OutputStream fos) {
		this.fos = fos;
	}
}
