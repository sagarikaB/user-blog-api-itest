package com.mobiquity.userblogapitest;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@PropertySource("classpath:application.properties")
public abstract class ITContextConfiguration {
}
