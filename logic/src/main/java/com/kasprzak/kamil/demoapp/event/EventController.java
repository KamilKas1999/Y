package com.kasprzak.kamil.demoapp.event;

import com.kasprzak.kamil.demoapp.common.command.CommandExecutor;
import com.kasprzak.kamil.demoapp.common.exceptions.BusinesException;
import com.kasprzak.kamil.demoapp.common.mapper.MapperExecutor;
import com.kasprzak.kamil.demoapp.common.query.QueryExecutor;
import com.kasprzak.kamil.demoapp.event.query.get.EventsQuery;
import com.kasprzak.kamil.demoapp.event.query.get.EventsQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private QueryExecutor queryExecutor;

    @Autowired
    private CommandExecutor commandExecutor;

    @Autowired
    private MapperExecutor mapperExecutor;

    @GetMapping("/{userId}")
    public EventsResponse getEvents(@PathVariable Long userId) throws BusinesException {
        var queryResult = queryExecutor.execute(new EventsQuery(userId), EventsQueryResult.class);
        return mapperExecutor.map(queryResult, EventsResponse.class);
    }
}
