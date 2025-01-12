package com.kasprzak.kamil.demoapp.demoapp.post.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentDTO {

    private  long id;
    private long userId;
    private String content;
}
