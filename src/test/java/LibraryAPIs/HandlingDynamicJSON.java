package LibraryAPIs;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CRUD.BookData;
import io.restassured.RestAssured;

@Test(dataProvider="booksData")
public class HandlingDynamicJSON
{
	public void registerMultipleBooks(String isbn,String aisle) {
		RestAssured.baseURI = "http://216.10.245.166";
		given().log().all().header("Content-Type","application/json")
		.body(BookData.bookData(isbn,aisle)).when().post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200);
		
	}
	
	@DataProvider(name="booksData")
	public Object[][] getData()
	{
		return new Object[][] {{"sdf101","fdb101"},{"db102","xcv102"},{"xfb103","rr103"}};
	}

	
	
}
