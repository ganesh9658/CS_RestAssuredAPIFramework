package api.testcases;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;


import api.endpoints.userEndPoints2;
import api.payload.user;
import io.restassured.response.Response;

public class UserTestCase2 {
	
	Faker faker;
	user UserPayload;
	Response response;
	public static org.apache.logging.log4j.Logger logger;
	
	
	@BeforeClass
	public void GenerateTestData()
	{
		faker=new Faker();
		UserPayload = new user();
		
		UserPayload.setId(faker.idNumber().hashCode());
		UserPayload.setFirstName(faker.name().firstName());
		UserPayload.setUsername("raleigh.altenwerth");
		UserPayload.setLastName(faker.name().lastName());
		UserPayload.setEmail(faker.internet().safeEmailAddress());
		UserPayload.setPhone(faker.phoneNumber().phoneNumber());
		UserPayload.setPassword("password");
		logger=LogManager.getLogger("RestAssuredAutomationTestingFrameWork");
	}
	
	@Test(priority = 1)
	public void CreateUser()
	{
		System.out.println("============User is Created===================");
		response =userEndPoints2.CreateUser(UserPayload);
		
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), 200);
		
		logger.info("User Created");
		
	}
	@Test(priority = 2)
	public void getUserData()
	{
		System.out.println("============Get User Data===================");
		
		//System.out.println(this.UserPayload.getUsername());
		
		response=userEndPoints2.GetUser(this.UserPayload.getUsername());
		
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), 200);
		logger.info("Get User Details");
	}
	@Test(priority = 3)
	public void UpdateUserData()
	{
		System.out.println("============Before Update===================");
		Response response=userEndPoints2.GetUser(this.UserPayload.getUsername());
		response.then().log().all();
		
		System.out.println("============Update User Data===================");
		UserPayload.setFirstName(faker.name().firstName());
		response=userEndPoints2.UpdateUser(this.UserPayload.getUsername(), UserPayload);
		
        response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), 200);
		
		System.out.println("User first name is updated");
		
		Response updateresponse=userEndPoints2.GetUser(this.UserPayload.getUsername());
		
		updateresponse.prettyPrint();
		
		logger.info("Update User details");
	}
	@Test(priority = 4)
	public void DeleteUserData()
	{
		System.out.println("============Delete user Data===================");
		response=userEndPoints2.DeleteUser(this.UserPayload.getUsername());
		
        response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), 200);
		logger.info("Delete user Details");
	}
}
