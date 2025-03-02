package com.kasprzak.kamil.demoapp.common.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface KafkaMessageHandler<T> {
    boolean supports(Class<?> eventType);
    void handle(T event);
    Class<T> getEventType();
}
