package com.mobiquity.userblogapitest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.mobiquity.userblogapitest.stepdefinitions"},
        features = "classpath:features",
        plugin = {"pretty", "html:build/cucumber"})
public class UserBlogApiIT {
}

