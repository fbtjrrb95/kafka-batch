package com.example.demodbcrud.service;

import com.example.demodbcrud.dto.MemberEvent;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducer {

    @Value("${kafka.topic}")
    private String TOPIC;

    private final KafkaTemplate<String, MemberEvent> kafkaTemplate;
    private Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    public KafkaProducer(KafkaTemplate<String, MemberEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(MemberEvent memberEvent){
        logger.info(String.format("publish message = " +  memberEvent.toString()));
        this.kafkaTemplate.send(TOPIC, memberEvent);
    }

}
