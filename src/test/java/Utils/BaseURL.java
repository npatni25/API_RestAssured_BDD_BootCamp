package Utils;
import io.restassured.RestAssured;



public class BaseURL {
	
	public static void baseurl()
	{
		RestAssured.baseURI="https://userserviceapp-f5a54828541b.herokuapp.com";
		
	}
	

}
