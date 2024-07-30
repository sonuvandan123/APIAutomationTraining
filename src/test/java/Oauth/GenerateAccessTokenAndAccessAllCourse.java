package Oauth;
import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
public class GenerateAccessTokenAndAccessAllCourse {

	public static void main(String[] args) {
		
		// authorizing client server using form data 
	String response=	given().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
			.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.formParam("grant_type", "client_credentials")
		.formParam("scope","scope").when().post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token")
	.asString();
	System.out.println(response);
	
	JsonPath jsonPath= new JsonPath(response);
	String access_token=jsonPath.getString("access_token");
	System.out.println(access_token);
	
	// get All courses
	String courses=given().queryParam("access_token",access_token).get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
	.asString();
	System.out.println(courses);
	
	}

}
