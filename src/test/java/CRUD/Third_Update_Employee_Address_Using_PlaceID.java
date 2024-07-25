package CRUD;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Third_Update_Employee_Address_Using_PlaceID {

public static void main(String[] args) {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
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
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath jsonPath= new JsonPath(response);
		String placeID=jsonPath.get("place_id");
		System.out.println("PlaceID is "+placeID);
		
		// updating employee address
		String response2=given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeID+"\",\r\n"
				+ "\"address\":\"Ghaziabad, India\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "").when().put("maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		
		JsonPath jsonPath2= new JsonPath(response2);
		String msg=	jsonPath2.get("msg");
		System.out.println(msg);
		 // getting updated address
		  
		 String res= given().log().all().queryParam("key","qaclick123").
				 queryParam("place_id",placeID).
				 when().get("maps/api/place/get/json")
			.then().log().all().assertThat().statusCode(200).extract().response().asString();
		 
		 JsonPath jsonPath3= new JsonPath(res); 
		 String val =jsonPath3.getString("address");
		  System.out.println(val);
	}

}
