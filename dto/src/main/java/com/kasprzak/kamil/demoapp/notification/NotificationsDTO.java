package com.kasprzak.kamil.demoapp.notification;

import lombok.Builder;

import java.util.List;

@Builder
public record NotificationsDTO(
        List<NotificationDTO> notifications
) {}


