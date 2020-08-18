package com.mobiquity.userblogapitest;

import io.restassured.response.Response;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ResponseState {
    private Response response;
}
