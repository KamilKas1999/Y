package com.kasprzak.kamil.demoapp.post;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
public record PostsDTO(
        List<PostDTO> posts
) {}


