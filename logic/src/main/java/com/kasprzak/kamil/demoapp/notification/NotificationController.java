package com.kasprzak.kamil.demoapp.notification;

import com.kasprzak.kamil.demoapp.common.command.CommandExecutor;
import com.kasprzak.kamil.demoapp.common.exceptions.BusinesException;
import com.kasprzak.kamil.demoapp.common.mapper.MapperExecutor;
import com.kasprzak.kamil.demoapp.common.query.QueryExecutor;
import com.kasprzak.kamil.demoapp.notification.query.get.NotificationsQuery;
import com.kasprzak.kamil.demoapp.notification.query.get.NotificationsQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private QueryExecutor queryExecutor;

    @Autowired
    private CommandExecutor commandExecutor;

    @Autowired
    private MapperExecutor mapperExecutor;


    @GetMapping("/{userId}")
    public NotificationsRequest getNotification(@PathVariable Long userId) throws BusinesException {
        var queryResult = queryExecutor.execute(new NotificationsQuery(userId), NotificationsQueryResult.class);
        return mapperExecutor.map(queryResult, NotificationsRequest.class);
    }

}
