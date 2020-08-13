package com.mobiquity.userblogapitest.stepdefinitions;

import com.mobiquity.userblogapitest.model.Post;
import com.mobiquity.userblogapitest.UserState;
import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class PostStepDefinitions {
    private final UserState userState;

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

}
