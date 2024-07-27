package LibraryAPIs;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import CRUD.BookData;

public class AddBook {

	public static void main(String[] args) {
		RestAssured.baseURI = "http://216.10.245.166";
		given().log().all().header("Content-Type","application/json")
		.body(BookData.bookData()).when().post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200);
		
	}

}
