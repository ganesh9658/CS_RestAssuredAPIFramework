package api.endpoints;

import api.payload.user;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class userEndPoints {
	
	public static Response CreateUser(user payload)
	{
		Response response = given()
							.accept(ContentType.JSON)
							.contentType(ContentType.JSON)
							.body(payload)

							.when().post(RoutesURL.post_url);

		return response;
		
	}
	public static Response GetUser(String userName)
	{
		Response response = given()
							.accept(ContentType.JSON)
							.pathParam("username", userName)
							

							.when()
							.get(RoutesURL.get_url);

		return response;
		
	}
	public static Response UpdateUser(String userName,user payload)
	{
		Response response = given()
							.accept(ContentType.JSON)
							.contentType(ContentType.JSON)
							.body(payload)
							.pathParam("username", userName)

							.when()
							.put(RoutesURL.put_url);

		return response;
		
	}
	public static Response DeleteUser(String userName)
	{
		Response response = given()
							.accept(ContentType.JSON)
							.pathParam("username", userName)

							.when()
							.delete(RoutesURL.delete_url);

		return response;
		
	}

}
