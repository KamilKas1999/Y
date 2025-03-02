package com.kasprzak.kamil.demoapp.notification;

import lombok.Builder;

@Builder
public record NotificationDTO(
        long id,
        String topic,
        String content
) {}
