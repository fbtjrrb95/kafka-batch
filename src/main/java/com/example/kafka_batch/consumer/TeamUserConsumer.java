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

    @KafkaListener(id = "teams-users", topics="${kafka.topic.teams-users}", containerFactory = "kafkaListenerTeamUserContainerFactory")
    public void receive(TeamUser teamUser){

        log.info("consume teamUser  {} ", teamUser.toString());
        teamUserService.save(teamUser);

    }
}
