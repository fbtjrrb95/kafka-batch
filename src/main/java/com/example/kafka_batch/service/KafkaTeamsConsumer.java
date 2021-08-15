package com.example.kafka_batch.service;

import com.example.kafka_batch.domain.Team;
import com.example.kafka_batch.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaTeamsConsumer {

    private final TeamRepository teamRepository;

    @KafkaListener(id = "teams", topics="${kafka.topic.teams}", containerFactory = "kafkaListenerTeamContainerFactory")
    public void receive(Team team){

        log.info("consume team {} ", team.toString());
        teamRepository.save(team);

    }

}
