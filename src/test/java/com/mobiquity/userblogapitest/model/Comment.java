package com.mobiquity.userblogapitest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {
    private Long postId;
    private Long id;
    private String name;
    private String email;
    private String body;
}
