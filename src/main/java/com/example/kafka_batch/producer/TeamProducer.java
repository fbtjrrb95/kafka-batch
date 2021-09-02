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

    @Value("${kafka.topic.teams.create}")
    private String CREATE_TOPIC;

    @Value("${kafka.topic.teams.update}")
    private String UPDATE_TOPIC;

    @Value("${kafka.topic.teams.delete}")
    private String DELETE_TOPIC;

    private final KafkaTemplate<String, Team> kafkaTemplate;

    public void publishCreateTopic(Team team){
        log.info("publish team and create team {}", team.toString());
        this.kafkaTemplate.send(CREATE_TOPIC, team);
    }

    public void publishUpdateTopic(Team team){
        log.info("publish team and update team {}", team.toString());
        this.kafkaTemplate.send(UPDATE_TOPIC, team);
    }

    public void publishDeleteTopic(Team team){
        log.info("publish team and delete team {}", team.toString());
        this.kafkaTemplate.send(DELETE_TOPIC, team);
    }

}
