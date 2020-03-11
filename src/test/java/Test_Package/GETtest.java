package Test_Package;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import BASERestAssuedBDDProject.BaseRestAssuredBDD;
import constantsRESTaSSUREDbdD.ConstantVideogame;

public class GETtest extends BaseRestAssuredBDD implements ConstantVideogame{



@Test(priority=3)
public void test_getVideoGames()
{String url=ConstantVideogame.BASE_URL+ConstantVideogame.URI_GETID;
	given()
	.when()
			.get(url)
	.then()
			.statusCode(200)
			.log().body()
			.body("videoGames.id",equalTo("103"))
			.body("videoGame.name", equalTo("Spider-Man"));
}

	

}
