package com.kasprzak.kamil.demoapp.notification.query.get;

import com.kasprzak.kamil.demoapp.common.query.QueryHandler;
import com.kasprzak.kamil.demoapp.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationsQueryHandler implements QueryHandler<NotificationsQuery, NotificationsQueryResult> {

    private final NotificationService notificationService;

    public NotificationsQueryResult handle(NotificationsQuery query) {
        var notifications = notificationService.getNotifications(query.userId());
        return NotificationsQueryResult.builder()
                .notifications(notifications)
                .build();
    }

}
