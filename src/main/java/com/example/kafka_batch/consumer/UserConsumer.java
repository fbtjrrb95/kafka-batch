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

    @KafkaListener(id="users", topics="${kafka.topic.users}", containerFactory = "kafkaListenerUserContainerFactory")
    public void receive(User user){

        log.info("consume user {} ", user.toString());
        userService.save(user);

    }

}
