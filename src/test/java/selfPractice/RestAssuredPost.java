package selfPractice;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;


public class RestAssuredPost {

	@Test
	public void createPlaceAPI()
	{//Task 1 grab the id from response
	RestAssured.baseURI="http://216.10.245.166";
	
	given().

	queryParam("key","qaclick123").
	body("{"+
	  "\"location\": {"+
	    "\"lat\": -33.8669710,"+
	    "\"lng\": 151.1958750"+
	  "},"+
	  "\"accuracy\": 50,"+
	  "\"name\": \"Google Shoes!\","+
	  "\"phone_number\": \"(02) 9374 4000\","+
	  "\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\","+
	  "\"types\": [\"shoe_store\"],"+
	  "\"website\": \"http://www.google.com.au/\","+
	  "\"language\": \"en-AU\""+
	"}").
	when().
	post("/maps/api/place/add/json").
	then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
	body("status",equalTo("OK")).extract().response();

											


	}
	
}
