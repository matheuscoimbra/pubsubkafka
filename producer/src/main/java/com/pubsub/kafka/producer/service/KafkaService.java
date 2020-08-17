package com.pubsub.kafka.producer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pubsub.kafka.producer.dto.PersonDTO;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Service
public class KafkaService {
    @Value("${person.topic}")
    private String orderTopic;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaService(final KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @SneakyThrows
    public void send(PersonDTO order) {
        final String mensageKey = UUID.randomUUID().toString();
        ObjectMapper obj = new ObjectMapper();
        var strObj = obj.writeValueAsString(order);
        kafkaTemplate.send(orderTopic, mensageKey,  strObj);
    }
}
