package Test_Package;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import BASERestAssuedBDDProject.BaseRestAssuredBDD;
import constantsRESTaSSUREDbdD.ConstantVideogame;
import io.restassured.response.Response;

public class DELETEtest extends BaseRestAssuredBDD implements ConstantVideogame {
	@Test(priority=5)
	public void test_DELETeVideoGame()
	{
		Response res=
		  
		  given()
		  		
		 .when()
		 		.delete("http://localhost:8080/app/videogames/103")
		 .then()
		 		.statusCode(200)
		 		.log().body()
		 		.extract().response();
				String jsonString=res.asString();
				Assert.assertEquals( jsonString.contains("Record Deleted Successfully"), true);
		  
	}
	
	

}
