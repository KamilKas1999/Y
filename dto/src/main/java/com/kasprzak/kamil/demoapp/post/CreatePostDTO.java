package com.kasprzak.kamil.demoapp.post;

import lombok.Data;

@Data
public class CreatePostDTO {

    private long userId;
    private String content;
}
