package stepDefinitions;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utils.generateDataUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class postUser {

	public static HashMap<Object, Object> map = new HashMap();
	public static HashMap<Object, Object> address = new HashMap();
	
	@BeforeClass
	public void setData()
	{
		address.put("addressId",21748);
	    address.put("plotNumber", "12-5");
	    address.put("street", "Main Street");
	    address.put("state", "Texas");
	    address.put("country", "USA");
	    address.put("zipCode", "750");
		address.put("", address);
		
		map.put("userFirstName", generateDataUtils.getFirstName());
		map.put("userLastName", generateDataUtils.getLastName());
		map.put("userContactNumber", "1234323456");
		map.put("userEmailId", generateDataUtils.getEmailId());
		map.put("userAddress", address);	
		
		RestAssured.baseURI="https://userserviceapp-f5a54828541b.herokuapp.com";
		RestAssured.basePath="/uap/createusers";
		
	}
	@Test
	public void postData()
	{
		given()
			.baseUri("https://userserviceapp-f5a54828541b.herokuapp.com")
			.auth().preemptive().basic("Numpy@gmail.com", "userapi@2025")
			.contentType("application/json")
			.body(map)
		.when()
			.post()
		.then()
			.statusCode(201);
			
	}
	
	
	
}
