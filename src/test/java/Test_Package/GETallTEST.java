package Test_Package;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import BASERestAssuedBDDProject.BaseRestAssuredBDD;
import constantsRESTaSSUREDbdD.ConstantVideogame;

public class GETallTEST extends BaseRestAssuredBDD implements ConstantVideogame{
	@Test(priority=1)
	public void test_GETALLVideoGames()
	{
		 given()
		.when()
			.get("http://localhost:8080/app/videogames")
		.then().
			statusCode(200)
			.log().body();
	}

}
