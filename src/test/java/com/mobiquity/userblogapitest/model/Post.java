package com.mobiquity.userblogapitest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {
    private Long userId;
    private Long id;
    private String title;
    private String body;
}
