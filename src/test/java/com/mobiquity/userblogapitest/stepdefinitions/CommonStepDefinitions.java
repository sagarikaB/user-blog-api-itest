package com.mobiquity.userblogapitest.stepdefinitions;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import org.springframework.beans.factory.annotation.Value;

public class CommonStepDefinitions {
    @Value("${application.url}")
    private String applicationUrl;
    @Before
    public void setup() {
        RestAssured.baseURI = applicationUrl;
        RestAssured.port = 443;
    }
}
