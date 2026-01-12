package com.kasprzak.kamil.demoapp.post;

import lombok.Builder;

import java.util.List;

@Builder
public record GetPostsResponse(
        List<PostDTO> posts
) {}


