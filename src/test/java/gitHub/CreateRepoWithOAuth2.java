package gitHub;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateRepoWithOAuth2 {
	
	@Test
	public void test1() throws IOException
	{
		byte[] dataFile = Files.readAllBytes(Paths.get("repodata.json"));
		RestAssured.baseURI = "https://api.github.com/user/repos";
		RequestSpecification request = RestAssured.given();
		Response response = request.auth().oauth2("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").contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(dataFile)
				.post();

		String body = response.getBody().asString();
		System.out.println("Response body is : " + body);

		System.out.println("response code is " + response.statusCode());
		Assert.assertEquals(response.statusCode(), 201);
	}
}
