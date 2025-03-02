package com.kasprzak.kamil.demoapp.common.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class KafkaConsumerService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Map<Class<?>, KafkaMessageHandler<?>> handlerMap;
    private final Map<String, Class<?>> eventTypeMap;

    @Autowired
    public KafkaConsumerService(List<KafkaMessageHandler<?>> messageHandlers) {
        this.handlerMap = messageHandlers.stream()
                .collect(Collectors.toMap(KafkaMessageHandler::getEventType, handler -> handler));
        this.eventTypeMap = messageHandlers.stream()
                .collect(Collectors.toMap(handler -> handler.getEventType().getName(), KafkaMessageHandler::getEventType));
    }

    @KafkaListener(topics = "topic", groupId = "my-group")
    public void consume(final ConsumerRecord<String, String> record) {

        try {
            var eventTypeString = getHeader(record.headers(), "event-type");
            if (eventTypeString == null) {
                throw new IllegalArgumentException("Missing event-type header");
            }

            var eventType = eventTypeMap.get(eventTypeString);
            if (eventType == null) {
                throw new IllegalArgumentException("Unsupported event type: " + eventTypeString);
            }

            var event = objectMapper.readValue(record.value(), eventType);
            var handler = (KafkaMessageHandler<Object>) handlerMap.get(eventType);
            handler.handle(event);
        } catch (Exception e) {
        }
    }

    private String getHeader(final Headers headers, final String key) {
        Header header = headers.lastHeader(key);
        return header != null ? new String(header.value(), StandardCharsets.UTF_8) : null;
    }
}