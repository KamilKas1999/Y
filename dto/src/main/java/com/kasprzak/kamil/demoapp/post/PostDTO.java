package com.kasprzak.kamil.demoapp.post;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
public record PostDTO(
        long userId,
        String content,
        List<CommentDTO> comments
) {}
