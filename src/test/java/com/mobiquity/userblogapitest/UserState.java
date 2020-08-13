package com.mobiquity.userblogapitest;

import com.mobiquity.userblogapitest.model.Comment;
import com.mobiquity.userblogapitest.model.Post;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class UserState {
    private Long userId;
    private List<Post> posts;
    /**
     * comments from all posts
     */
    private List<Comment> allComments;
}
