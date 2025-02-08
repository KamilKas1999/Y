package com.kasprzak.kamil.demoapp.post;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentPostDTO {

    private long postId;
    private long userId;
    private String content;
}
