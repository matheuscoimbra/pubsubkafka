package com.pubsub.kafka.consumer.consumer.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class PersonDTO implements Serializable {

    private String name;
    private String nickname;
    private String birthDate;

}
