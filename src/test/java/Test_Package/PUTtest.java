package Test_Package;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

import BASERestAssuedBDDProject.BaseRestAssuredBDD;
import constantsRESTaSSUREDbdD.ConstantVideogame;

public class PUTtest extends BaseRestAssuredBDD implements ConstantVideogame {
	@Test(priority=4)
	public void test_UpdateVideoGame()
	{
		HashMap data = BaseRestAssuredBDD.PUT_DATA();
		  
		  given()
		  		.contentType("application/json")
		  		.body(data)
		 .when()
		 		.put("http://localhost:8080/app/videogames/103")
		 .then()
		 		.statusCode(200)
		 		.log().body()
		 		.body("videoGames.id",equalTo("103"))
		 		.body("videoGame.name", equalTo("Pac-Man"));
		  
	}

	
}
