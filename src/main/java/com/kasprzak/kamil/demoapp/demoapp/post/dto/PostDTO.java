package com.kasprzak.kamil.demoapp.demoapp.post.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PostDTO {

    private long userId;
    private String content;
    private List<CommentDTO> comments;
}
