package stepDefinitions;

import io.cucumber.java.en.*;

public class ApiSteps {
    @Given("users given api url {string}")
    public void users_given_api_url(String url) {
        System.out.println("users given api url"+url);
    }

    @Given("set api end point {string}")
    public void set_api_end_point(String endpoint) {
        System.out.println("set api end point"+endpoint);
    }

    @Given("User creates new user with request body \"Fatih Turk,\"male,{string},{string}")
    public void user_creates_new_user_with_request_body_fatih_turk_male(String email, String status) {
        System.out.println("User creates new user with request body Fatih Turk male " +email+" " +status);
    }

    @Then("validate the status code {int}")
    public void validate_the_status_code(Integer statusCode) {
        System.out.println("validate the status code" +statusCode);
    }

    @Then("validate the userId is not null")
    public void validate_the_user_ıd_is_not_null() {
        System.out.println("validate the userId is not null");
    }

    @Then("validate the user name is {string}")
    public void validate_the_user_name_is(String name) {
        System.out.println("validate the user name is"+name);
    }

    @Then("validate the user Gender is {string}")
    public void validate_the_user_gender_is(String gender) {
        System.out.println("validate the user Gender is"+gender);
    }

    @Then("validate the user Email is {string}")
    public void validate_the_user_email_is(String email) {
        System.out.println("validate the user Email is"+email);
    }

    @Then("validate the user Status is {string}")
    public void validate_the_user_status_is(String status) {
        System.out.println("validate the user Status is"+status);
    }

}
