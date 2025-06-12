	
	package stepDefinitions;

	import java.util.HashMap;

	import static io.restassured.RestAssured.*;
	import static org.hamcrest.Matchers.*;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	import io.restassured.RestAssured;
	import io.restassured.response.Response;

	public class PATCHRequest_final {
		
		public static HashMap map = new HashMap();
		
		@BeforeClass
		public void putData()
		{
			RestAssured.baseURI = "https://userserviceapp-f5a54828541b.herokuapp.com";
			RestAssured.basePath = "/uap/updateuserfields/23695";
					  
		    map.put("userEmailId", "nehaa@gmail.com");
		    
		}
		
		@Test(priority=1)
		public void testPATCHRequest()
		{
		
	Response response=	given()
							.log().all()
							.auth().preemptive().basic("Numpy@gmail.com", "userapi@2025")
							.header("Content-Type", "application/json")
							.body(map)
						.when()
							.log().all()
							.patch()
						.then()
							.statusCode(200)
							.assertThat().body("userEmailId", equalTo("nehaa@gmail.com"))
							.extract().response();

			System.out.println("===== Response Body =====");
		    System.out.println(response.asPrettyString());
		}
		
		
	}



