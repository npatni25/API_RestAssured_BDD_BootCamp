package stepDefinitions;

import org.testng.annotations.Test;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import io.restassured.response.Response;

public class DeleteUser_final {

	
	@Test
	public void delUser()
	{
		RestAssured.baseURI="https://userserviceapp-f5a54828541b.herokuapp.com";
		RestAssured.basePath="/uap/deleteuser/21411";
		
Response response =	
		given()
			.auth().preemptive().basic("Numpy@gmail.com", "userapi@2025")
		.when()
			.delete()
		.then()
			.statusCode(200)
			.log().all()
			.extract().response();

		Assert.assertEquals(response.asString().contains("User is deleted successfully"), true );
		
		System.out.println(response.getStatusLine());
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());
		
	}
	
}
