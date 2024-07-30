package CRUD;

public class BookData {

	public static String bookData(String isbn, String aisle)
	{
		return "{\r\n"
				+ "\r\n"
				+ "\"name\":\"API Automation\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"Vandan Mishra\"\r\n"
				+ "}";
	}
}
