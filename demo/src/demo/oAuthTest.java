package demo;
import static io.restassured.RestAssured.given;

public class oAuthTest {

	public static void main(String[] args) {
		
		String response = given().queryParam("access_koken", "")
		.when()
		.get("https://rahulshettyacademy.com/getCourse.php").asString();
		
		System.out.println(response);
	}


}
