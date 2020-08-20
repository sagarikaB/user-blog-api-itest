package com.mobiquity.userblogapitest.stepdefinitions;

import com.mobiquity.userblogapitest.ResponseState;
import com.mobiquity.userblogapitest.UserState;
import com.mobiquity.userblogapitest.model.Post;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class PostStepDefinitions {
    private final UserState userState;
    private final ResponseState responseState;


    @Then("get the user posts")
    public void get_the_user_posts() {
        Post[] posts = given().queryParam("userId", userState.getUserId())
                .when()
                .get("/posts")
                .then()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Post[].class);
        List<Post> postList = Arrays.asList(posts);
        userState.setPosts(postList);
        assertThat(postList).isNotEmpty();
    }
    @Given("search for posts with userid {string}")
    public void get_user(String userid) {
        Response response = given().queryParam("userid", userid)
                .when()
                .get("/posts");
        responseState.setResponse(response);
    }

}
