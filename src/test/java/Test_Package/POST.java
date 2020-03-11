package Test_Package;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import BASERestAssuedBDDProject.BaseRestAssuredBDD;
import constantsRESTaSSUREDbdD.ConstantVideogame;
import io.restassured.response.Response;

public class POST extends BaseRestAssuredBDD implements ConstantVideogame{
	@Test(priority=2)
	public void test_POSTVideoGames()
	{
		HashMap data=new HashMap();
		
			  data.put("id","103");
			  data.put("name", "Spider-Man");
			  data.put("releaseDate", "2020-01-18T00:16:43.928Z");
			  data.put("reviewScore", "5");
			  data.put("category", "Adventure");
			  data.put("rating", "Universal");
			  
			  Response res=
					  given()
					 		.contentType("application/json")
					 		.body(data)
					 .when()
					 		.post("http://localhost:8080/app/videogames")
					 .then()
					  		.statusCode(200)
					  		.log().body()
					  		.extract().response();
			  String jsonString=res.asString();
			  Assert.assertEquals(jsonString.contains("Record Added Successfully"), true);
					 
			
	}

}
