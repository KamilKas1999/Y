package com.kasprzak.kamil.demoapp.demoapp.post.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentPostDTO {

    private long postId;
    private long userId;
    private String content;
}
