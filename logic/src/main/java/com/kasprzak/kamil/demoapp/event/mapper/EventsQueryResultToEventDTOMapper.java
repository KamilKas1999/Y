package com.kasprzak.kamil.demoapp.event.mapper;

import com.kasprzak.kamil.demoapp.common.mapper.Mapper;
import com.kasprzak.kamil.demoapp.event.EventDTO;
import com.kasprzak.kamil.demoapp.event.EventsDTO;
import com.kasprzak.kamil.demoapp.event.query.get.EventsQueryResult;

import java.util.stream.Collectors;

public class EventsQueryResultToEventDTOMapper implements Mapper<EventsQueryResult, EventsDTO> {

    @Override
    public Class<EventsQueryResult> getSourceType() {
        return null;
    }

    @Override
    public Class<EventsDTO> getTargetType() {
        return null;
    }

    @Override
    public EventsDTO map(EventsQueryResult source) {
        return EventsDTO
                .builder()
                .events(source.getEvents().stream()
                        .map(eventEntity -> EventDTO
                                .builder()
                                .id(eventEntity.getId())
                                .userId(eventEntity.getUser().getId())
                                .content(eventEntity.getContent())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
