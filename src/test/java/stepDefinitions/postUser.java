package stepDefinitions;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utils.generateDataUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class postUser {

	JSONObject map = new JSONObject();
	
	
	@Test
	public void setData()
	{
		JSONObject address = new JSONObject();
		address.put("addressId",21748);
	    address.put("plotNumber", "12-5");
	    address.put("street", "Main Street");
	    address.put("state", "Texas");
	    address.put("country", "USA");
	    address.put("zipCode", "750");
		
	    
	    map.put("userFirstName", "Nehab");
		map.put("userLastName", "Patnib");
		map.put("userContactNumber", "9567345609");
		map.put("userEmailId", "neha5@gmail.com");
		map.put("userAddress", "address");	
		
		RestAssured.baseURI="https://userserviceapp-f5a54828541b.herokuapp.com";
		RestAssured.basePath="/uap/createusers";
		
	}
	@Test
	public void postData()
	{
		given()
			.auth().preemptive().basic("Numpy@gmail.com", "userapi@2025")
			.header("content-Type", "application/json")
			.body(map.toString())
		.when()
			.post()
		.then()
			.statusCode(201)
			.log().body();
			
	}
	
	
	
}
