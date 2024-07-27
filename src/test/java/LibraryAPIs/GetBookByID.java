package LibraryAPIs;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetBookByID {

	public static void main(String[] args) {
		
			RestAssured.baseURI = "http://216.10.245.166";
			String bookData=given().log().all().header("Content-Type","application/json")
			.body("{\r\n"
					+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
					+ "\"isbn\":\"ebook102\",\r\n"
					+ "\"aisle\":\"102\",\r\n"
					+ "\"author\":\"Vandan Mishra\"\r\n"
					+ "}\r\n"
					+ "").when().post("Library/Addbook.php")
			.then().log().all().assertThat().statusCode(200).extract().response().asString();
			
			JsonPath jsonPath= new JsonPath(bookData);
			String ID=jsonPath.get("ID");
			System.out.println(ID);
		

	}

}
