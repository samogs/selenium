import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonPerse {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath js = new JsonPath(payload.CoursePrice());
		
//		1. Print No of courses returned by API
		int count = js.getInt("courses.size()");
		System.out.println(count);
		
//		Print Purchase Amount
		int purchAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(purchAmount);
		
//		Print Title of the first course	
		String firstCourseTitle = js.getString("courses[0].title");
		System.out.println(firstCourseTitle);
		
//		Print All course titles and their respective Prices		
//		Using "for loop" to iterate the count
		for(int i = 0; i < count; i++)
		{
			String courseTitles = js.getString("courses["+i+"].title");
//			Printing course titles
			System.out.println(courseTitles);
//			Printing all their various prices
			System.out.println(js.get("courses["+i+"].price").toString());
//			Printing No. of copies sold by all
			System.out.println(js.get("courses["+i+"].copies").toString());
		}
		
		
//		Printing No. of copies sold by only RPA
		System.out.println("Print No. of copies sold by only RPA");
		
		for(int i = 0; i < count; i++)
		{
			String courseTitles = js.get("courses["+i+"].title");
			if(courseTitles.equalsIgnoreCase("RPA"))
			{
				int copies = js.get("courses["+i+"].copies");
				System.out.println(copies);
				break;
			}
		}
	}

}
