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

    @Value("${kafka.topic.teams-users.create}")
    private String CREATE_TOPIC;

    @Value("${kafka.topic.teams-users.update}")
    private String UPDATE_TOPIC;

    @Value("${kafka.topic.teams-users.delete}")
    private String DELETE_TOPIC;

    private final KafkaTemplate<String, TeamUser> teamUserKafkaTemplate;

    public void publishCreateTopic(TeamUser teamUser) {
        log.info("publish teamUser and create teamUser {}", teamUser.toString());
        this.teamUserKafkaTemplate.send(CREATE_TOPIC, teamUser);
    }

    public void publishUpdateTopic(TeamUser teamUser) {
        log.info("publish teamUser and update teamUser {}", teamUser.toString());
        this.teamUserKafkaTemplate.send(UPDATE_TOPIC, teamUser);
    }

    public void publishDeleteTopic(TeamUser teamUser) {
        log.info("publish team and delete teamUser {}", teamUser.toString());
        this.teamUserKafkaTemplate.send(DELETE_TOPIC, teamUser);
    }

}
