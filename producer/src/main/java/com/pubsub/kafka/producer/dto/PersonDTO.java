package com.pubsub.kafka.producer.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PersonDTO implements Serializable {

    private String name;
    private String nickname;
    private String birthDate;

}
