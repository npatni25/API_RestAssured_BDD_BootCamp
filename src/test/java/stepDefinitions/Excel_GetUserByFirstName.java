package stepDefinitions;

import static io.restassured.RestAssured.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import Utils.ExcelUtils;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;



public class Excel_GetUserByFirstName {
	
	
	
	@Test
	public void read_firstName_fromExcel() {
		
		String filepath = "./TestData/testData.xlsx";
	    String sheetName = "Sheet1";
	    int rowNum =1;    
		    
		List<String> columns = Arrays.asList("UserFirstName");    
	    Map<String, String> rowData = ExcelUtils.getRowDataByColumnNames(filepath, sheetName, rowNum, columns);

	    String firstName = rowData.get("UserFirstName");
	    
	    if (firstName == null || firstName.isEmpty()) {
            System.out.println("UserFirstName is empty or not found in Excel");
            return;
        }

        System.out.println("First Name from Excel: " + firstName);

        // API base setup
        RestAssured.baseURI = "https://userserviceapp-f5a54828541b.herokuapp.com";
        RestAssured.basePath = "/uap/users/username/" + firstName;

		
	    Response response= 	given()
					    		.auth().basic("Numpy@gmail.com", "userapi@2025")
					    	.when()
					    		.get()
					    	.then()
					    		.statusCode(200)
					    		.log().all()
					    		.extract().response();
	    		
	    // Print response body
	    System.out.println("Response Body:");
	    System.out.println(response.asPrettyString());
	
	}
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    

