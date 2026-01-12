package com.kasprzak.kamil.demoapp.notification.mapper;

import com.kasprzak.kamil.demoapp.common.mapper.Mapper;
import com.kasprzak.kamil.demoapp.notification.NotificationDTO;
import com.kasprzak.kamil.demoapp.notification.NotificationsRequest;
import com.kasprzak.kamil.demoapp.notification.query.get.NotificationsQueryResult;

import java.util.stream.Collectors;

public class NotificationsQueryResultToNotificationDTOMapper implements Mapper<NotificationsQueryResult, NotificationsRequest> {
    @Override
    public Class<NotificationsQueryResult> getSourceType() {
        return NotificationsQueryResult.class;
    }

    @Override
    public Class<NotificationsRequest> getTargetType() {
        return NotificationsRequest.class;
    }

    @Override
    public NotificationsRequest map(NotificationsQueryResult source) {
        return NotificationsRequest
                .builder()
                .notifications(source.getNotifications().stream()
                        .map(notificationEntity -> NotificationDTO
                                .builder()
                                .id(notificationEntity.getId())
                                .topic(notificationEntity.getTopic())
                                .content(notificationEntity.getContent())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
