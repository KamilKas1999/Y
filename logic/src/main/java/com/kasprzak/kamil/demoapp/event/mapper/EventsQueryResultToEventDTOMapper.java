package com.kasprzak.kamil.demoapp.event.mapper;

import com.kasprzak.kamil.demoapp.common.mapper.Mapper;
import com.kasprzak.kamil.demoapp.event.Event;
import com.kasprzak.kamil.demoapp.event.EventsResponse;
import com.kasprzak.kamil.demoapp.event.query.get.EventsQueryResult;

import java.util.stream.Collectors;

public class EventsQueryResultToEventDTOMapper implements Mapper<EventsQueryResult, EventsResponse> {

    @Override
    public Class<EventsQueryResult> getSourceType() {
        return null;
    }

    @Override
    public Class<EventsResponse> getTargetType() {
        return null;
    }

    @Override
    public EventsResponse map(EventsQueryResult source) {
        return EventsResponse
                .builder()
                .events(source.getEvents().stream()
                        .map(eventEntity -> Event
                                .builder()
                                .id(eventEntity.getId())
                                .userId(eventEntity.getUser().getId())
                                .content(eventEntity.getContent())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
