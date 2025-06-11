package stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utils.generateDataUtils;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestCreateUSer_POST {
	
	private Response response;
    private JSONObject requestBody;
   
    @BeforeClass 
   public void login()
   
   { given()
    .auth().preemptive().basic("Numpy@gmail.com", "userapi@2025")
    .when()
    .get("https://userserviceapp-f5a54828541b.herokuapp.com")
    .then()
    .statusCode(200);
   }
	
    @Test
	@Given("the request body contains valid first name, last name, contact number, email, and address")
	public void prepare_request_body() 
	{
	    JSONObject address = new JSONObject();
	    address.put("addressId",21748);
	    address.put("plotNumber", "12-5");
	    address.put("street", "Main Street");
	    address.put("state", "Texas");
	    address.put("country", "USA");
	    address.put("zipCode", "750");
	    
	    requestBody = new JSONObject();
	    requestBody.put("userFirstName", generateDataUtils.getFirstName());
	    requestBody.put("userLastName", generateDataUtils.getFirstName());
	    requestBody.put("userContactNumber", "9876545679");
	    requestBody.put("userEmailId", generateDataUtils.getEmailId());
	    requestBody.put("userAddress", "address");
	    
	    
	    
	}

	@When("When post request is sent")
	public void when_post_request_is_sent() 
	{
	 
		response = given()
					.baseUri("https://userserviceapp-f5a54828541b.herokuapp.com")
					.header("content-Type", "application/json")
					.body(requestBody.toString())
				.when()
					.post("/uap/createusers");
		
		
	}

	@Then("the response status code should be {int} with Message:created")
	public void the_response_status_code_should_be_with_message_created(Integer int1)
	{
		
		response.then()
				.statusCode(201)
				.body("message", equalTo("User Created"));
		
		response.body().print();
		
		
	}

}

