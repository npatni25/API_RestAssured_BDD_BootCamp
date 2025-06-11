package stepDefinitions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import Utils.ExcelUtils;

public class getDataFromExcelTest {

	public static void main(String[] args) {
		
		
		String filepath = "./TestData/testData.xlsx";
		        String sheetName = "Sheet1";
		        int rowNum =1;

		        List<String> columns = Arrays.asList("userID", "UserFirstName", "UserLastName", "UserEmailId", "UserContactNumber");

		        Map<String, String> rowData = ExcelUtils.getRowDataByColumnNames(filepath, sheetName, rowNum, columns);

		        System.out.println("Reading from row index: " + rowNum);
		        System.out.println("Fetched Data:");
		 
		        rowData.forEach((key, value) -> System.out.println(key + ": " + value));
		    }
		

	}


