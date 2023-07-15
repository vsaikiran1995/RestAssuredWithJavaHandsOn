package restAPIBDD;

import java.util.List;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetRequestBDD {
	@Test
	public void test1()	{
		
		RestAssured.given()
		            .baseUri("http://localhost:3000/employees")
		            .when()
		            .get()
		            .then()
		            .log()
		            .body()
		            .statusCode(200)
		            .body("[4].name", Matchers.equalTo("Rohan"))
		            ;
		
	}
	@Test
	public void test2() {
		
		RestAssured.given()
        .baseUri("http://localhost:3000/employees")
        .when()
        .get("/3")
        .then()
        .log()
        .everything()
        .statusCode(200)
		.body("name", Matchers.equalTo("Vidhya"));

	}
	@Test
	public void test3()	{
		
		Response response = RestAssured.given()
	            .baseUri("http://localhost:3000/employees")
	            .when()
	            .get();
		System.out.println(response.body().asString());
		Assert.assertEquals(response.statusCode(), 200);
		
		JsonPath json = response.jsonPath();
		List<String> names = json.get("name");
		List<Integer> ids = json.get("id");
		int empid =11;
		for(int i=0;i<ids.size();i++) {
			if(ids.get(i)==empid) {
				System.out.println(names.get(i));
				Assert.assertEquals(names.get(i), "Greg");
			}
		}
		
		
	}
}
