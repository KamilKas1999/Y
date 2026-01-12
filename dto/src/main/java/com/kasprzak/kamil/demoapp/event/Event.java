package com.kasprzak.kamil.demoapp.event;

import lombok.Builder;

@Builder
public record Event(
        long id,
        long userId,
        String content
) {
}
