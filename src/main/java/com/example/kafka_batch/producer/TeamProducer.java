package com.example.kafka_batch.producer;

import com.example.kafka_batch.domain.Team;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamProducer {

    @Value("${kafka.topic.teams}")
    private String TOPIC;

    private final KafkaTemplate<String, Team> kafkaTemplate;

    public void sendMessage(Team team){
        log.info("publish team {}", team.toString());
        this.kafkaTemplate.send(TOPIC, team);
    }
}
