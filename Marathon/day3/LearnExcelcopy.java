package week5.day5Marathon;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LearnExcelcopy {
	
	//Excel Integration - Step 1: Change main method to static method
	public static String[][] readExcel(String filename) throws IOException {
		
		XSSFWorkbook wb = new XSSFWorkbook("./data/"+filename+".xlsx");
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int RowCount = sheet.getLastRowNum();
		System.out.println("Row count: " +RowCount);
		short ColCount = sheet.getRow(0).getLastCellNum();
		System.out.println("Column Count: "+ColCount);
		//Step 2: Declare 2D array to store data values
		String[][] data	= new String[RowCount][ColCount];
		
		System.out.println("-----Excel Values-----");
		for (int i = 1; i <= RowCount; i++) {
			for (int j = 0; j < ColCount; j++) {
				String CellValue = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(CellValue);
				data[i-1][j]= CellValue; //To match data in array(index starts from 0) and excel(includes header at index 0)
				
			}
			
		} 
		wb.close();
		//Step 3: Return data and change return type to String
		return data;
		
	}

}
