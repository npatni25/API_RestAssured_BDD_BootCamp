package stepDefinitions;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;



@Test
public class GetUser_final {

	
@Test
public void getUsermanually()
	{

		given()	
			.auth().preemptive().basic("Numpy@gmail.com", "userapi@2025")
		.when()
			.get("https://userserviceapp-f5a54828541b.herokuapp.com/uap/users/username/Nehaa")
		.then()
			.assertThat().statusCode(200)
			.assertThat().body("userFirstName", hasItem("Nehaa"))
			.assertThat().body("userId", hasItem(23695))
			.assertThat().header("Content-Type", "application/json")
			.extract().response().prettyPrint();	
	}

}
