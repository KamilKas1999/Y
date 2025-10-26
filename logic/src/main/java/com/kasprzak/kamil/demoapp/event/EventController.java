package com.kasprzak.kamil.demoapp.event;

import com.kasprzak.kamil.demoapp.common.command.CommandExecutor;
import com.kasprzak.kamil.demoapp.common.query.QueryExecutor;
import com.kasprzak.kamil.demoapp.notification.NotificationDTO;
import com.kasprzak.kamil.demoapp.notification.NotificationsDTO;
import com.kasprzak.kamil.demoapp.notification.query.get.NotificationsQuery;
import com.kasprzak.kamil.demoapp.notification.query.get.NotificationsQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private QueryExecutor queryExecutor;

    @Autowired
    private CommandExecutor commandExecutor;


    @GetMapping("/{userId}")
    public NotificationsDTO getEvents(@PathVariable Long userId) {
        var result = queryExecutor.execute(new NotificationsQuery(userId), NotificationsQueryResult.class);
        return NotificationsDTO
                .builder()
                .notifications(result.getNotifications().stream()
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
