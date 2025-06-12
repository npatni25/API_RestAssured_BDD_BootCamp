package stepDefinitions;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UpdateUser_PUT_final {
	
	public static HashMap map = new HashMap();
	
	@BeforeClass
	public void putData()
	{
		RestAssured.baseURI = "https://userserviceapp-f5a54828541b.herokuapp.com";
		RestAssured.basePath = "/uap/updateuser/23695";
				
		HashMap address = new HashMap();
		address.put("addressId","21748");
	    address.put("plotNumber", "12-5");
	    address.put("street", "Main Street");
	    address.put("state", "Texas");
	    address.put("country", "USA");
	    address.put("zipCode", "750");
		
		map.put("userFirstName", "Nehaa");
	    map.put("userLastName", "Patni");
	    map.put("userContactNumber", "9876545679");
	    map.put("userEmailId", "neha@gmail.com");
	    map.put("userAddress", address);
	}
	
	@Test(priority=1)
	public void testPUTRequest()
	{
	
Response response=	given()
						.log().all()
						.auth().preemptive().basic("Numpy@gmail.com", "userapi@2025")
						.header("content-Type", "application/json")
						.body(map)
					.when()
						.log().all()
						.put()
					.then()
						.statusCode(200)
						.assertThat().body("userFirstName", equalTo("Nehaa"))
						.extract().response();

		System.out.println("===== Response Body =====");
	    System.out.println(response.asPrettyString());
	}
	
	
}
