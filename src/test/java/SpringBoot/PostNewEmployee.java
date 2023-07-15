package SpringBoot;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostNewEmployee {
	@Test
	public void test1()
	{
		JSONObject jobj =  new JSONObject();
		jobj.put("firstName", "Greg");
		jobj.put("lastName", "Greg");
		jobj.put("salary", "3000");
		jobj.put("email", "Greg@gmail.com");
		

		RestAssured.baseURI = "http://localhost:8088/employees";
		RequestSpecification request = RestAssured.given();
		Response response = request.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(jobj.toString())
				.post();

		String body = response.getBody().asString();
		System.out.println("Response body is : " + body);

		System.out.println("response code is " + response.statusCode());
		Assert.assertEquals(response.statusCode(), 201);
	}
}
