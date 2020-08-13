package com.mobiquity.userblogapitest.stepdefinitions;

import com.mobiquity.userblogapitest.model.User;
import com.mobiquity.userblogapitest.UserState;
import io.cucumber.java.en.Given;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class UserStepDefinitions {

    private final UserState userState;

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
}
