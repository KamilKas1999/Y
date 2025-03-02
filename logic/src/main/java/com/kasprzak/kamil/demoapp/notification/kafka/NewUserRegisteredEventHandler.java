package com.kasprzak.kamil.demoapp.notification.kafka;

import com.kasprzak.kamil.demoapp.auth.event.NewUserRegisteredEvent;
import com.kasprzak.kamil.demoapp.common.kafka.consumer.KafkaMessageHandler;
import com.kasprzak.kamil.demoapp.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewUserRegisteredEventHandler implements KafkaMessageHandler<NewUserRegisteredEvent> {

    private final NotificationService notificationService;


    @Override
    public boolean supports(Class<?> eventType) {
        return NewUserRegisteredEvent.class.equals(eventType);
    }

    @Override
    public void handle(NewUserRegisteredEvent event) {
        System.out.println("Event received");
        notificationService.createNotification(event.getUserId(), "Welcome!", "Welcome!");
    }

    @Override
    public Class<NewUserRegisteredEvent> getEventType() {
        return NewUserRegisteredEvent.class;
    }
}