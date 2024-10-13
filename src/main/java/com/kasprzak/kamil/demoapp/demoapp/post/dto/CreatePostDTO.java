package com.kasprzak.kamil.demoapp.demoapp.post.dto;

import lombok.Data;

@Data
public class CreatePostDTO {

    private long userId;
    private String content;
}
