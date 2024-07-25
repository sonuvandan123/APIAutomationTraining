package CRUD;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;


public class First_Add_Employee {

	public static void main(String[] args) {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\":\"Vandan Mishra\",\r\n"
				+ "  \"phone_number\": \"+91 9315362800\",\r\n"
				+ "  \"address\": \"Kanpur galla mandi\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://vandan.com\",\r\n"
				+ "  \"language\": \"Hindi\"\r\n"
				+ "}\r\n"
				+ "").when().log().all().post("maps/api/place/add/json")
		.then().log().all().statusCode(200);

	}

}
