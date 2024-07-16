package utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelReader {

	public static void main(String[] args) {
		readExcel();
	}
	public static Object[][] readExcel() {
		String path = "C:\\Users\\Usha\\OneDrive\\Desktop\\Usha_2024\\Vaibhav\\login-tdd.xls";
		try {
			Workbook workbook = new HSSFWorkbook(new FileInputStream(new File(path)));
			Sheet sh = workbook.getSheet("login-data");
			int totalRows = sh.getLastRowNum();
			String[][] data = new String[totalRows][sh.getRow(0).getLastCellNum()];
			for(int i = 1; i <= totalRows ; i++) {
				Row rw  = sh.getRow(i);
				int totalColumn = rw.getLastCellNum();
				for(int j = 0 ; j < totalColumn ; j++) {
					String value = rw.getCell(j).getStringCellValue();
					data[i-1][j] = value;
					System.out.println(value);
				}
				
			}
			workbook.close();
			return data;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
