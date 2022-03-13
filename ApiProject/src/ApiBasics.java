import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

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
		given().log().all().queryParam("Key", "qaclick123").header("Content-Type", "application/json")
		.body(" {\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Samuel Sam\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "").when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200);

	}

}
