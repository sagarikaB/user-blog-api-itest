package com.mobiquity.userblogapitest.stepdefinitions;

import com.mobiquity.userblogapitest.ITContextConfiguration;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = ITContextConfiguration.class)
public class CucumberSpringConfiguration {
}
