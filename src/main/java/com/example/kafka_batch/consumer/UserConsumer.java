package com.example.kafka_batch.consumer;

import com.example.kafka_batch.domain.User;
import com.example.kafka_batch.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserConsumer {

    @Autowired
    private UserService userService;


    @KafkaListener(topics = "${kafka.topic.users.create}", groupId = "${kafka.group.id.users}", containerFactory = "userKafkaListenerContainerFactory")
    public void receiveMessage(User user) {

        log.info("consume user and create user {} ", user.toString());
        userService.save(user);

    }

    @KafkaListener(topics = "${kafka.topic.users.update}", groupId = "${kafka.group.id.users}", containerFactory = "userKafkaListenerContainerFactory")
    public void consumeUpdateTopic(User user) {

        log.info("consume user and update user {} ", user.toString());
        userService.update(user);

    }

    @KafkaListener(topics = "${kafka.topic.users.delete}", groupId = "${kafka.group.id.users}", containerFactory = "userKafkaListenerContainerFactory")
    public void deleteUser(User user) {

        log.info("consume user and delete user{} ", user.toString());
        userService.delete(user);

    }

}
