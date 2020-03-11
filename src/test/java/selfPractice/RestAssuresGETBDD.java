package selfPractice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RestAssuresGETBDD {

	@Test
public void getPlaceAPI()
{
		// TODO Auto-generated method stub

		//BaseURL or Host
		RestAssured.baseURI="https://maps.googleapis.com";
		//We have given(): reuest header(key value), parameter(key value), request cookie(key value),
		//when(), get(ressource)/post(ressource)/put(ressource)/then() put asserstion: 
		//Extract(),block
		given().
		//paramenter, in key value pair
		       param("location","-33.8670522,151.1957362").
		       param("radius","500").
		       param("key","AIzaSyDIQgAh0B4p0SdyYkyW8tlG-y0yJMfss5Y").
		when(). // all resources goes in get
		       get("/maps/api/place/nearbysearch/json").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		       body("results[0].name",equalTo("Sydney")).and().
		       body("results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and().
		       header("Server","pablo");
		       
		       
		       /*header("dfd","fsdfds").
		       cookie("dsfs","csder").
		       body()*/
		//Status code of the response
		//Content type 
		//Body
		//Header responses
	
}

}
