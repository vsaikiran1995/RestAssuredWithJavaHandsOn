package restAPIXML;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.internal.path.xml.NodeChildrenImpl;
import io.restassured.response.Response;

public class XMLTest {
	@Test
	public void test1()	{
		
		RestAssured.given()
        .baseUri("https://chercher.tech/sample/api/books.xml")
        .when()
        .get()
        .then()
        .log()
        .body()
        .statusCode(200);
		
	}
	
	@Test
	public void test2()	{
		
		Response response = RestAssured.given()
                           .baseUri("https://chercher.tech/sample/api/books.xml")
                            .when()
                            .get();
		NodeChildrenImpl books = response.then().extract().path("bookstore.book.title");
		System.out.println("All the books are : "+ books.toString());
		
		NodeChildrenImpl bookstag = response.then().extract().path("bookstore.book");
		
		for(int i=0;i<bookstag.size();i++) {
			System.out.println(bookstag.get(i).getAttribute("category"));
		}
		
	}

}
