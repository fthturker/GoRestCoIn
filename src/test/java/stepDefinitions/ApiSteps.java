package stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import junit.framework.AssertionFailedError;
import org.junit.Assert;
import pages.ApiValidation;

import java.io.IOException;

public class ApiSteps extends ApiValidation {
    @Given("users given api url {string}")
    public void users_given_api_url(String url) {
        RestAssured.baseURI = url;
        System.out.println("users given api url" + url);
    }

    @Given("set api end point {string}")
    public void set_api_end_point(String endpoint) {
        RestAssured.basePath = endpoint;

        System.out.println("set api end point" + endpoint);
    }

    @And("User creates new user with request body {string},{string},{string},{string}")
    public void userCreatesNewUserWithRequestBody(String name, String gender, String email, String status) throws IOException {
        response = postMethod(name, gender, email, status);
        response.prettyPrint();


    }


    @Then("validate the status code {int}")
    public void validate_the_status_code(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        try {
            Assert.assertEquals(expectedStatusCode, actualStatusCode);
        } catch (AssertionFailedError ae) {
            ae.printStackTrace();
        }
        System.out.println("Assertion Successful");
    }

    @Then("validate the userId is not null")
    public void validate_the_user_ıd_is_not_null() {
        int id = response.jsonPath().getInt("id");
        Assert.assertTrue("id is empty", id != 0);

    }

    @Then("validate the user name is {string}")
    public void validate_the_user_name_is(String expectedName) {
        String actualName = response.jsonPath().getString("name");
        Assert.assertEquals(expectedName, actualName);
        System.out.println("Assertion Successful " + actualName);
    }

    @Then("validate the user Gender is {string}")
    public void validate_the_user_gender_is(String expectedGender) {
        String actualGender = response.jsonPath().getString("gender");
        Assert.assertEquals(expectedGender, actualGender);
        System.out.println("Assertion Successful " + actualGender);
    }

    @Then("validate the user Email is {string}")
    public void validate_the_user_email_is(String expectedEmail) {
        String actualEmail = response.jsonPath().getString("email");
        Assert.assertEquals(expectedEmail, actualEmail);
        System.out.println("Assertion Successful " + actualEmail);
    }

    @Then("validate the user Status is {string}")
    public void validate_the_user_status_is(String expectedStatus) {
        String actualStatus = response.jsonPath().getString("status");
        Assert.assertEquals(expectedStatus, actualStatus);
        System.out.println("Assertion Successful " + actualStatus);
    }


}
