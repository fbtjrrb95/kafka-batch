package com.example.kafka_batch.service;

import com.example.kafka_batch.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaUsersProducer {


    @Value("${kafka.topic.users}")
    private String TOPIC;
    private final KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User user){
        log.info(String.format("publish user {}", user.toString()));
        this.kafkaTemplate.send(TOPIC, user);
    }
}
