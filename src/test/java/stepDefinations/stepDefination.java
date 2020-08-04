package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Locationdetails;
import resources.TestDataBuild;
import resources.Utils;

public class stepDefination extends Utils{

	RequestSpecification res;
	ResponseSpecification responsespec;
	Response response;
	TestDataBuild data = new TestDataBuild();
	
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String language, String name, String address) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
			res=given().spec(requestSpecification())
					.body(data.addplace(language,name,address));
	}


	@When("User calls {string} API with Post http request")
	public void user_calls_api_with_post_http_request(String string) {
	    // Write code here that turns the phrase above into concrete actions
		responsespec = new ResponseSpecBuilder().expectStatusCode(200).build();
		response = res.when().post("maps/api/place/add/json")
				.then().spec(responsespec).extract().response();
	}
	@Then("The Api call is success with response coe as {int}")
	public void the_api_call_is_success_with_response_coe_as(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(response.getStatusCode(),200);
	}
	@Then("The response body {string} is {string}")
	public void the_response_body_is(String KeyValue, String ExpectedValue) {
	    // Write code here that turns the phrase above into concrete actions
		String responsestring = response.asString();
		JsonPath js = new JsonPath(responsestring);
		assertEquals(js.get(KeyValue).toString(),ExpectedValue);
	}

	
}
