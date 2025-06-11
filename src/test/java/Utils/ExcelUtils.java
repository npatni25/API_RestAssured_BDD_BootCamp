package Utils;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class ExcelUtils {
	
	//public static String filePath = System.getProperty("user.dir"+"/TestData/testData.xlsx");

	public static Map<String, String> getRowDataByColumnNames(String filePath, String sheetName, int rowNum, List<String> columnNames) {
	    Map<String, String> resultMap = new HashMap<>();

	    try (FileInputStream fis = new FileInputStream(new File(filePath));
	         Workbook workbook = WorkbookFactory.create(fis)) {

	        Sheet sheet = workbook.getSheet(sheetName);

	        if (sheet == null) {
	            throw new RuntimeException("Sheet " + sheetName + " not found.");
	        }

	        Row headerRow = sheet.getRow(0);
	        if (headerRow == null) {
	            throw new RuntimeException("Header row (row 0) is empty.");
	        }

	        // Map column names to indices
	        Map<String, Integer> colIndexMap = new HashMap<>();
	        for (Cell cell : headerRow) {
	            colIndexMap.put(cell.getStringCellValue().trim(), cell.getColumnIndex());
	        }

	        // DEBUG: Show available columns
	        System.out.println("Available columns: " + colIndexMap.keySet());

	        Row dataRow = sheet.getRow(rowNum);
	        if (dataRow == null) {
	            throw new RuntimeException("Row " + rowNum + " does not exist or is empty.");
	        }

	        for (String colName : columnNames) {
	            Integer colIndex = colIndexMap.get(colName);

	            if (colIndex == null) {
	                resultMap.put(colName, "❌ Column not found");
	            } else {
	                Cell cell = dataRow.getCell(colIndex);
	                resultMap.put(colName, getCellValueAsString(cell));
	            }
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return resultMap;
	}

	private static String getCellValueAsString(Cell cell) {
		if (cell == null) return "";

	    switch (cell.getCellType()) {
	        case STRING:
	            return cell.getStringCellValue();
	        case NUMERIC:
	            double numericValue = cell.getNumericCellValue();
	            // Format as int if it's a whole number
	            if (numericValue == Math.floor(numericValue)) {
	                return String.valueOf((long) numericValue); // or (int) if you're sure it's small
	            } else {
	                return String.valueOf(numericValue);
	            }
	        case BOOLEAN:
	            return String.valueOf(cell.getBooleanCellValue());
	        case FORMULA:
	            return cell.getCellFormula();
	        case BLANK:
	            return "";
	        default:
	            return "";
	    }
	}

	    
	}
