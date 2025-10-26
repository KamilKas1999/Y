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
    private final Map<Class<?>, List<KafkaMessageHandler<?>>> handlerMap;
    private final Map<String, Class<?>> eventTypeMap;

    @Autowired
    public KafkaConsumerService(List<KafkaMessageHandler<?>> messageHandlers) {
        // Mapowanie: typ eventu -> lista handlerów
        this.handlerMap = messageHandlers.stream()
                .collect(Collectors.groupingBy(KafkaMessageHandler::getEventType));

        // Mapowanie: nazwa klasy (ze stringa w nagłówku Kafka) -> klasa typu eventu
        this.eventTypeMap = messageHandlers.stream()
                .collect(Collectors.toMap(
                        handler -> handler.getEventType().getName(),
                        KafkaMessageHandler::getEventType,
                        (a, b) -> a // ignoruje duplikaty
                ));
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

            var handlers = handlerMap.get(eventType);
            if (handlers == null || handlers.isEmpty()) {
                throw new IllegalArgumentException("No handler registered for event type: " + eventTypeString);
            }

            for (KafkaMessageHandler<?> handler : handlers) {
                @SuppressWarnings("unchecked")
                KafkaMessageHandler<Object> typedHandler = (KafkaMessageHandler<Object>) handler;
                typedHandler.handle(event);
            }

        } catch (Exception e) {
            // Logowanie błędu, najlepiej przez logger zamiast sout
            e.printStackTrace();
        }
    }

    private String getHeader(final Headers headers, final String key) {
        Header header = headers.lastHeader(key);
        return header != null ? new String(header.value(), StandardCharsets.UTF_8) : null;
    }
}