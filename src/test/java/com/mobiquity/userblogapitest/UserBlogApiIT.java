package com.mobiquity.userblogapitest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.mobiquity.userblogapitest.stepdefinitions"},
        features = "classpath:features",
        plugin = {"pretty","html:build/cucumber", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","junit:target/cucumber/cucumber.junit", "html:target/cucumber/cucumber.html"})
public class UserBlogApiIT {
}

