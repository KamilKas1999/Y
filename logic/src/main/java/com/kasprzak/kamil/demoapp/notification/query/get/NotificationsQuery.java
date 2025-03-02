package com.kasprzak.kamil.demoapp.notification.query.get;

import com.kasprzak.kamil.demoapp.common.query.Query;

public record NotificationsQuery(
        Long userId
) implements Query<NotificationsQueryResult> {
}
