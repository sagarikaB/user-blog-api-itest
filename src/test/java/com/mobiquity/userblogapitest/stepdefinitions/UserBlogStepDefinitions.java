package com.mobiquity.userblogapitest.stepdefinitions;

import com.mobiquity.userblogapitest.model.User;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class UserBlogStepDefinitions {

    @Before
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RestAssured.port = 443;
    }

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

        assertThat(userList).isNotEmpty();
        assertThat(userList).extracting(User::getUsername).contains(username);
    }
}
