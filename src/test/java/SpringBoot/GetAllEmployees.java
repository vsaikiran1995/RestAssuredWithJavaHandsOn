package SpringBoot;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllEmployees {
	@Test
	public void test1()
	{
		RestAssured.baseURI = "http://localhost:8088/employees";
		RequestSpecification request = RestAssured.given();
		Response response = request.get();
		String body = response.getBody().asString();
		System.out.println("Response body is : "+body);
		
		System.out.println("response code is "+response.statusCode());
		System.out.println("response header are "+response.getHeader("Content-Type"));
		System.out.println("response header are "+response.getHeaders().asList());
		
		Assert.assertEquals(response.statusCode(), 200);
		
	}
}
