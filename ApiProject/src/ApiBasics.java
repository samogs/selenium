import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.ReUsableMethods;
import files.payload;

public class ApiBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Validate if "Add Place API" is working as expected
		
//		Rest Assured works on 3 principles: 
//		Given:- In this method, you will give all the input details here.
//		When:- 	In this method, you will submit the API
//		Then:-	In this method, you will validate the response.
		
//		First, set base url
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		
//		Starting with "Given Method"
		String response = given().log().all().queryParam("Key", "qaclick123").header("Content-Type", "application/json")
		.body(payload.AddPlace()).when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		JsonPath js = new JsonPath(response);  // For passing Json
		String placeId = js.getString("place_id");
		
		System.out.println(placeId);
		
//		Update Place
		
//		First, creating a variable to store new address
		String newAddress = "No. 25, Nzenei, Asaba, Delta State";
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body("{\r\n"
				+ "    \"place_id\":\""+placeId+"\",\r\n"
				+ "    \"address\":\""+newAddress+"\",\r\n"
				+ "    \"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
//		Get Place
		String getPlaceResponse = given().log().all().queryParam("key", "qaclick123")
		.queryParam("place_id", placeId)
		.when().get("maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
		
		JsonPath js1 = ReUsableMethods.rawJson(getPlaceResponse);
		String actualAddress = js1.getString("address");
		System.out.println(actualAddress);
		Assert.assertEquals(actualAddress, newAddress);
	}

}
