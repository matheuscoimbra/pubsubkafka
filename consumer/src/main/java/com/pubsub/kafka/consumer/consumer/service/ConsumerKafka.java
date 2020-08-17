package com.pubsub.kafka.consumer.consumer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pubsub.kafka.consumer.consumer.dto.PersonDTO;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log
@Service
public class ConsumerKafka {

    @SneakyThrows
    @KafkaListener(topics = "${person.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(final ConsumerRecord<String, String> record) {
        ObjectMapper mapper = new ObjectMapper();
        var obj = mapper.readValue(record.value(),PersonDTO.class);
        log.info(obj.toString());
    }
}
