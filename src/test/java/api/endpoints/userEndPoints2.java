package api.endpoints;

import api.payload.user;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

public class userEndPoints2 {
	
	static ResourceBundle getUrl()
	{
		ResourceBundle routes=ResourceBundle.getBundle("Routes");//load Routes.properties
		return routes;
	}
	
	public static Response CreateUser(user payload)
	{
		String post_url= getUrl().getString("post_url");
		Response response = given()
							.accept(ContentType.JSON)
							.contentType(ContentType.JSON)
							.body(payload)

							.when().post(post_url);

		return response;
		
	}
	public static Response GetUser(String userName)
	{
		String get_url= getUrl().getString("get_url");
		Response response = given()
							.accept(ContentType.JSON)
							.pathParam("username", userName)
							

							.when()
							.get(get_url);

		return response;
		
	}
	public static Response UpdateUser(String userName,user payload)
	{
		String put_url= getUrl().getString("put_url");
		Response response = given()
							.accept(ContentType.JSON)
							.contentType(ContentType.JSON)
							.body(payload)
							.pathParam("username", userName)

							.when()
							.put(put_url);

		return response;
		
	}
	public static Response DeleteUser(String userName)
	{
		String delete_url= getUrl().getString("delete_url");
		Response response = given()
							.accept(ContentType.JSON)
							.pathParam("username", userName)

							.when()
							.delete(delete_url);

		return response;
		
	}

}
