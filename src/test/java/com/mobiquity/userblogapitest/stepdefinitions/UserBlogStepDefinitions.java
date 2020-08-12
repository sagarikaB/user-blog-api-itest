package com.mobiquity.userblogapitest.stepdefinitions;

import io.cucumber.java.en.Given;

public class UserBlogStepDefinitions {
    @Given("user {string} available")
    public void user_available(String userName) {
        System.out.println("entering into stepdfinitions....s");
    }
}
