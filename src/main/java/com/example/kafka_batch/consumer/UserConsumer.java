package com.example.kafka_batch.consumer;

import com.example.kafka_batch.domain.User;
import com.example.kafka_batch.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserConsumer {

    @Autowired
    private UserService userService;

    @KafkaListener(id = "users-create", topics = "${kafka.topic.users.create}", containerFactory = "kafkaListenerUserContainerFactory")
    public void createUser(User user) {

        log.info("consume user and create user {} ", user.toString());
        userService.save(user);

    }

    @KafkaListener(id = "users-update", topics = "${kafka.topic.users.update}", containerFactory = "kafkaListenerUserContainerFactory")
    public void updateUser(User user) {

        log.info("consume user and update user {} ", user.toString());
        userService.update(user);

    }

    @KafkaListener(id = "users-delete", topics = "${kafka.topic.users.delete}", containerFactory = "kafkaListenerUserContainerFactory")
    public void deleteUser(User user) {

        log.info("consume user and delete user{} ", user.toString());
        userService.delete(user);

    }

}
