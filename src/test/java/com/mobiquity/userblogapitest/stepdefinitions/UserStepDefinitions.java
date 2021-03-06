package com.mobiquity.userblogapitest.stepdefinitions;

import com.mobiquity.userblogapitest.ResponseState;
import com.mobiquity.userblogapitest.UserState;
import com.mobiquity.userblogapitest.model.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class UserStepDefinitions {

    private final UserState userState;
    private final ResponseState responseState;

    @Given("user {string} is available")
    public void user_available(String username) {
        User[] users = given().queryParam("username", username)
                .when()
                .get("/users")
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .extract()
                .as(User[].class);
        List<User> userList = Arrays.asList(users);

        assertThat(userList).hasSize(1);
        assertThat(userList).extracting(User::getUsername).contains(username);

        userState.setUserId(userList.get(0).getId());
    }

    @Given("search for user {string}")
    public void get_user(String username) {
        Response response = given().queryParam("username", username)
                .when()
                .get("/users");
        responseState.setResponse(response);
    }

    @Then("should return with status {int}")
    public void validate_status_code(int statusCode) {
        Response response = responseState.getResponse();
        assertThat(response.getStatusCode()).isEqualTo(statusCode);
    }

    @When("search for profileid {string}")
    public void search_for_Profileid(String profileid) {
            Response response = given().queryParam("profileid", profileid)
                    .when()
                    .get("/posts");
            responseState.setResponse(response);
    }

    @When("try to delete user {string}")
    public void tryToDeleteUser(String userid) {
        Response response = given().queryParam("userid", userid)
                .when()
                .delete("/users");
        responseState.setResponse(response);

    }
}
