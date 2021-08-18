package com.example.kafka_batch.producer;

import com.example.kafka_batch.domain.TeamUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TeamUserProducer {

    @Value("${kafka.topic.teams-users}")
    private String TOPIC;

    private final KafkaTemplate<String, TeamUser> kafkaTemplate;

    public void sendMessage(TeamUser teamUser){
        log.info("publish team {}", teamUser.toString());
        this.kafkaTemplate.send(TOPIC, teamUser);
    }

}
