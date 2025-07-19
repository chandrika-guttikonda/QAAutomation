package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static Object[][] readExcelData(String filePath, String sheetName) throws IOException {
		//Opens the Excel file on your disk so Java can read it.
		FileInputStream fis = new FileInputStream(filePath);
		
		//Creates an in-memory object representing the entire Excel workbook.Uses the opened file stream fis to load content
		Workbook workbook = new XSSFWorkbook(fis);
		
		//reads the mentioned sheet name 
		Sheet sheet = workbook.getSheet(sheetName);
		
		//Counts the actual non-empty rows present in the sheet.
		int rows = sheet.getPhysicalNumberOfRows();
		
		//Counts number of columns in the first row (row 0 → header row).
		int cols = sheet.getRow(0).getPhysicalNumberOfCells();
		
		//Create a 2D array to hold the test data. with row-1 because first row is a header
		Object[][] data = new Object[rows - 1][cols];
		
		//loop through each row. starting from 1 cause top row is a header
		for (int i = 1; i < rows; i++) {
			//to get the row of mentioned index
			Row row = sheet.getRow(i);
			
			//loop through the columns of the specified row
			for (int j = 0; j < cols; j++) {
				//store the value of cell in the data object 
				//if cell is missing, treat as blank cell instead of returning null (avoids NullPointerException).
				//toString is for converting it to string
				data[i - 1][j] = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
				System.out.println(data[i-1][j]);
			}
		}
		
		//closing the workbook
		workbook.close();
		
		//closing the file
		fis.close();
		return data;
	}
}
