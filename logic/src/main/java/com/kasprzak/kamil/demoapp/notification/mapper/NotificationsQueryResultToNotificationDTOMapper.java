package com.kasprzak.kamil.demoapp.notification.mapper;

import com.kasprzak.kamil.demoapp.common.mapper.Mapper;
import com.kasprzak.kamil.demoapp.notification.NotificationDTO;
import com.kasprzak.kamil.demoapp.notification.NotificationsDTO;
import com.kasprzak.kamil.demoapp.notification.query.get.NotificationsQueryResult;

import java.util.stream.Collectors;

public class NotificationsQueryResultToNotificationDTOMapper implements Mapper<NotificationsQueryResult, NotificationsDTO> {
    @Override
    public Class<NotificationsQueryResult> getSourceType() {
        return NotificationsQueryResult.class;
    }

    @Override
    public Class<NotificationsDTO> getTargetType() {
        return NotificationsDTO.class;
    }

    @Override
    public NotificationsDTO map(NotificationsQueryResult source) {
        return NotificationsDTO
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
