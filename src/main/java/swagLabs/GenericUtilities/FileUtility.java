package swagLabs.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	
	public String readDataFromPropertiesFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(".\\commonData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		return pobj.getProperty(key);
	}
	public String getDataFromExcel(String SheetName,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\Sample.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row r = sh.getRow(rownum);
		Cell c = r.getCell(cellnum);
		return c.toString();
	}
	
}
