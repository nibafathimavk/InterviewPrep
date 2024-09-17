package UtilityPkg;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static XSSFWorkbook w;
	public static XSSFSheet s;
	public static FileInputStream f;

	public static String readStringData(int i, int j) throws IOException {
		f = new FileInputStream(System.getProperty("C:\\Users\\ASUS\\eclipse-workspace\\InterviewPrep\\src\\main\\resources\\Excel\\LoginCredentialExcel.xlsx"));
		w = new XSSFWorkbook(f);
		s = w.getSheet("LoginSheet");//sheet name to be added here
		Row r = s.getRow(i);
		Cell c = r.getCell(j);
		return c.getStringCellValue();
	
	}
	public static String readIntegerData(int i, int j) throws IOException {
		f = new FileInputStream(System.getProperty("C:\\Users\\ASUS\\eclipse-workspace\\InterviewPrep\\src\\main\\resources\\Excel\\LoginCredentialExcel.xlsx"));
		w = new XSSFWorkbook(f);
		s = w.getSheet("LoginSheet");
		Row r = s.getRow(i);
		Cell c = r.getCell(j);
		int value = (int) c.getNumericCellValue();
		return String.valueOf(value);
	}
}

