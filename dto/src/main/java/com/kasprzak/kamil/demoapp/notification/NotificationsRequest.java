package com.kasprzak.kamil.demoapp.notification;

import lombok.Builder;

import java.util.List;

@Builder
public record NotificationsRequest(
        List<NotificationDTO> notifications
) {
}


