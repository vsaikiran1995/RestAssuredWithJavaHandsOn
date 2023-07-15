package restAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRequest {
	@Test
	public void test1()
	{
		RestAssured.baseURI = "http://localhost:3000/employees";
		RequestSpecification request = RestAssured.given();
		Response response = request.delete("/8");
		
		System.out.println("response code is "+response.statusCode());
		System.out.println("response header are "+response.getHeader("Content-Type"));
		System.out.println("response header are "+response.getHeaders().asList());
		
		Assert.assertEquals(response.statusCode(), 200);
		
	}
}
