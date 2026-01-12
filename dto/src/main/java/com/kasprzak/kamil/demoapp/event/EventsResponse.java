package com.kasprzak.kamil.demoapp.event;

import lombok.Builder;

import java.util.List;

@Builder
public record EventsResponse(
        List<Event> events
) {
}


