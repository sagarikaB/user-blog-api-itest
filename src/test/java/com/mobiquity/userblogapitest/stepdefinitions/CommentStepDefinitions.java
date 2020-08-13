package com.mobiquity.userblogapitest.stepdefinitions;

import com.mobiquity.userblogapitest.UserState;
import com.mobiquity.userblogapitest.model.Comment;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Condition;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;
import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class CommentStepDefinitions {
    private final UserState userState;

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private Condition<String> validEmail = new Condition<>(email -> VALID_EMAIL_ADDRESS_REGEX.matcher(email).matches(), "check email validity");

    @And("get comments of all posts of the user")
    public void get_comments_of_all_posts_of_the_user() {
        List<Comment> allComments = userState.getPosts().stream()
                .map(post -> get_comments_of_post_async(post.getId()))
                .map(CompletableFuture::join)
                .flatMap(Collection::stream)
                .collect(toList());

        assertThat(allComments).isNotEmpty();
        userState.setAllComments(allComments);
    }

    @Then("validate email of the users commented")
    public void validate_emails() {
        List<Comment> allComments = userState.getAllComments();
        allComments.forEach(comment -> assertThat(comment).extracting(Comment::getEmail).is(validEmail));
    }

    private CompletableFuture<List<Comment>> get_comments_of_post_async(Long postId) {
        return CompletableFuture.supplyAsync(() -> {
            Comment[] comments = given().pathParam("postId", postId)
                    .when()
                    .get("/posts/{postId}/comments")
                    .then()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .extract()
                    .as(Comment[].class);
            return Arrays.asList(comments);
        });
    }

}
