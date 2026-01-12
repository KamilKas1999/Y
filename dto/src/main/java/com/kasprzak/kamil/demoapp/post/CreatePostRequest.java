package com.kasprzak.kamil.demoapp.post;

import lombok.Data;

@Data
public class CreatePostRequest {

    private long userId;
    private String content;
}
