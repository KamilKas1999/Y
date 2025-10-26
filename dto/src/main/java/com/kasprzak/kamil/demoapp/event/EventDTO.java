package com.kasprzak.kamil.demoapp.event;

import lombok.Builder;

@Builder
public record EventDTO(
        long id,
        long userId,
        String content
) {
}
