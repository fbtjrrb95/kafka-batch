package com.example.kafka_batch.service;

import com.example.kafka_batch.dto.MemberEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducer {

    @Value("${kafka.topic}")
    private String TOPIC;

    private final KafkaTemplate<String, MemberEvent> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, MemberEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(MemberEvent memberEvent){
        log.info(String.format("publish message = " +  memberEvent.toString()));
        this.kafkaTemplate.send(TOPIC, memberEvent);
    }

}
