package com.example.kafka_batch.service;

import com.example.kafka_batch.domain.User;
import com.example.kafka_batch.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaUsersConsumer {

    @Autowired
    private UserRepository userRepository;

    @KafkaListener(id="users", topics="${kafka.topic.users}", containerFactory = "kafkaListenerUserContainerFactory")
    public void receive(User user){

        log.info("consume user {} ", user.toString());
        userRepository.save(user);

    }

}
