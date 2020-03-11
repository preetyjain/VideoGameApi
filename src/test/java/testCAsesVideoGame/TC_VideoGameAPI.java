package testCAsesVideoGame;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class TC_VideoGameAPI {
	
	//Prerequisit Server is running run code    VideoGameDB-master\gradlew bootRun
		/*given()
		 		set cookies, add authrization, add parameter, set headers info etc.
		  when()
		  		GET, PUT, POST, DELETE....
		  then()
		  		validate status code, extract response, extract headers cookies & response body	......	  		
		 	
		 */
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
	@Test(priority=3)
		public void test_getVideoGames()
		{
			given()
			.when()
					.get("http://localhost:8080/app/videogames/103")
			.then()
					.statusCode(200)
					.log().body()
					.body("videoGames.id",equalTo("103"))
					.body("videoGame.name", equalTo("Spider-Man"));
		}
		
@Test(priority=4)
		public void test_UpdateVideoGame()
		{
			HashMap data=new HashMap();
			
			  data.put("id","103");
			  data.put("name", "Pac-Man");
			  data.put("releaseDate", "2020-01-18T00:16:43.928Z");
			  data.put("reviewSfcore", "5");
			  data.put("catehgory", "Adventure");
			  data.put("ratking", "Universal");
			  
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

