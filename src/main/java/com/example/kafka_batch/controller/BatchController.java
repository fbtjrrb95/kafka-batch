package com.example.kafka_batch.controller;

import com.example.kafka_batch.domain.Team;
import com.example.kafka_batch.domain.User;
import com.example.kafka_batch.service.KafkaTeamsProducer;
import com.example.kafka_batch.service.KafkaUsersProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/batch")
public class BatchController {

    private final KafkaUsersProducer usersProducer;
    private final KafkaTeamsProducer teamsProducer;

    @PostMapping("/users")
    public ResponseEntity<User> batchUsers(@RequestBody User user) {
        usersProducer.sendMessage(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/teams")
    public ResponseEntity<Team> batchTeams(@RequestBody Team team) {
        teamsProducer.sendMessage(team);
        return ResponseEntity.ok(team);
    }

}
