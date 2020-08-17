package com.pubsub.kafka.producer.resource;

import com.pubsub.kafka.producer.dto.PersonDTO;
import com.pubsub.kafka.producer.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("producer")
public class KafkaResource {

    @Autowired
    KafkaService service;

    @PostMapping
    public ResponseEntity<?> send(@RequestBody PersonDTO personDTO){
        service.send(personDTO);
        return ResponseEntity.ok("mensagem enviada");
    }

}
