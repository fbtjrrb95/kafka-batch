package com.example.kafka_batch.consumer;

import com.example.kafka_batch.domain.TeamUser;
import com.example.kafka_batch.service.TeamUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TeamUserConsumer {

    private final TeamUserService teamUserService;

    @KafkaListener(topics = "${kafka.topic.teams-users.create}", groupId = "${kafka.group.id.teams-users}", containerFactory = "teamUserKafkaListenerContainerFactory")
    public void createTeamUser(TeamUser teamUser) {

        log.info("consume teamUser and create teamUser {} ", teamUser.toString());
        teamUserService.save(teamUser);

    }

    @KafkaListener(topics = "${kafka.topic.teams-users.update}", groupId = "${kafka.group.id.teams-users}", containerFactory = "teamUserKafkaListenerContainerFactory")
    public void updateTeamUser(TeamUser teamUser) {

        log.info("consume teamUser and update teamUser{} ", teamUser.toString());
        teamUserService.update(teamUser);

    }

    @KafkaListener(topics = "${kafka.topic.teams-users.delete}", groupId = "${kafka.group.id.teams-users}", containerFactory = "teamUserKafkaListenerContainerFactory")
    public void deleteTeamUser(TeamUser teamUser) {

        log.info("consume teamUser and delete teamUser {} ", teamUser.toString());
        teamUserService.delete(teamUser);

    }
}
