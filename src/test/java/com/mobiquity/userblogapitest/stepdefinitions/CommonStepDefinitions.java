package com.mobiquity.userblogapitest.stepdefinitions;

import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class CommonStepDefinitions {
    @Before
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RestAssured.port = 443;
    }
}
