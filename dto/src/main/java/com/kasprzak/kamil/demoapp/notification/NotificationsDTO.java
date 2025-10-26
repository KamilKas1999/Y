package com.kasprzak.kamil.demoapp.notification;

import com.kasprzak.kamil.demoapp.event.EventDTO;
import lombok.Builder;

import java.util.List;

@Builder
public record NotificationsDTO(
        List<NotificationDTO> notifications
) {
}


