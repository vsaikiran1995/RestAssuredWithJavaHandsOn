package gitHub;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRepowithOauth2 {
	
	@Test
	public void test1()
	{
		RestAssured.baseURI = "https://api.github.com/repos/vsaikiran1995/RestAssuredDemo";
		RequestSpecification request = RestAssured.given();
		Response response = request.auth().oauth2("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").delete();
		System.out.println("response code is " + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
	}
}
