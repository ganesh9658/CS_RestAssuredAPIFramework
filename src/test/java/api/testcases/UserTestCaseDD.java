package api.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.userEndPoints;
import api.payload.user;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class UserTestCaseDD {
	Response response;
	
	@Test(priority = 1,dataProvider = "AllData" ,dataProviderClass = DataProviders.class)
	public void CreateUser(String userID,String Username,String fname,String lname,String Email,String phone,String password)
	{
		System.out.println("============ User is Created by Using DD ===================");
		user UserPayload = new user();
		
		UserPayload.setId(Integer.parseInt(userID));
		UserPayload.setUsername(Username);
		UserPayload.setFirstName(fname);
		UserPayload.setLastName(lname);
		UserPayload.setEmail(Email);
		UserPayload.setPassword(password);
		UserPayload.setPhone(phone);
		
		
		
		response =userEndPoints.CreateUser(UserPayload);
		
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), 200);
		
	}
	
	@Test(priority = 2,dataProvider = "UserName" ,dataProviderClass = DataProviders.class)
	public void DeleteUserData(String UserNameDD)
	{
		System.out.println("============ Delete user Data using DD ===================");
		response=userEndPoints.DeleteUser(UserNameDD);
		
        response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), 200);
		
	}

}
