package stepDefinitions;

import static io.restassured.RestAssured.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import Utils.ExcelUtils;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;



public class exceltest {
	
	
	
	@When("Click on Run button")
	public void click_on_run_button() {
	   
	String filepath = "./TestData/testData.xlsx";
    String sheetName = "Sheet1";
    int rowNum =1;

    List<String> columns = Arrays.asList("UserFirstName");

    Map<String, String> rowData = ExcelUtils.getRowDataByColumnNames(filepath, sheetName, rowNum, columns);

	 Response response = given()
    					.queryParam("UserFirstName", columns)
    					.when()
    					.get("https://userserviceapp-f5a54828541b.herokuapp.com/uap/users")
    					.then()
    					.statusCode(200)
    					.extract()
    					.response();
 
    	
	
    
	 }
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    

