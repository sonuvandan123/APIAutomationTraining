package HandlingNestedJson;

import io.restassured.path.json.JsonPath;

public class JsonHandleMain 
{
	public static void main(String[] args) {
		JsonPath jsonPath= new JsonPath(NestedJsonData.jsonData());
		String secondCourseTitle=jsonPath.getString("courses[1].title");
		System.out.println(secondCourseTitle);
		int totalAmmount=0;
		int noOfCourse=jsonPath.getInt("courses.size()");
		System.out.println(noOfCourse);
		for(int i=0;i<noOfCourse;i++)
		{
			System.out.println(jsonPath.getInt("courses["+i+"].price"));
		}
		System.out.println(totalAmmount);
	}
			
}
