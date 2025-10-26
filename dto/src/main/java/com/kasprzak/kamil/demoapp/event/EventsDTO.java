package com.kasprzak.kamil.demoapp.event;

import com.kasprzak.kamil.demoapp.notification.NotificationDTO;
import lombok.Builder;

import java.util.List;

@Builder
public record EventsDTO(
        List<EventDTO> events
) {
}


