package com.example.kafka_batch.producer;

import com.example.kafka_batch.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserProducer {

    @Value("${kafka.topic.users.create}")
    private String CREATE_TOPIC;

    @Value("${kafka.topic.users.update}")
    private String UPDATE_TOPIC;

    @Value("${kafka.topic.users.delete}")
    private String DELETE_TOPIC;

    private final KafkaTemplate<String, User> userKafkaTemplate;

    public void publishCreateTopic(User user) {
        log.info("publish user and create user {}", user.toString());
        this.userKafkaTemplate.send(CREATE_TOPIC, user);

    }

    public void publishUpdateTopic(User user) {
        log.info(String.format("publish user and update user {}", user.toString()));
        this.userKafkaTemplate.send(UPDATE_TOPIC, user);
    }

    public void publishDeleteTopic(User user) {
        log.info(String.format("publish user and delete user {}", user.toString()));
        this.userKafkaTemplate.send(DELETE_TOPIC, user);
    }
}
