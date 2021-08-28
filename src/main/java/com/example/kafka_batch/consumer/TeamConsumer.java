package com.example.kafka_batch.consumer;

import com.example.kafka_batch.domain.Team;
import com.example.kafka_batch.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TeamConsumer {

    private final TeamService teamService;

    @KafkaListener(id = "teams-create", topics = "${kafka.topic.teams.create}", containerFactory = "kafkaListenerTeamContainerFactory")
    public void createTeam(Team team) {

        log.info("consume team and create team {} ", team.toString());
        teamService.save(team);

    }

    @KafkaListener(id = "teams-update", topics = "${kafka.topic.teams.update}", containerFactory = "kafkaListenerTeamContainerFactory")
    public void updateTeam(Team team) {

        log.info("consume team and update team {} ", team.toString());
        teamService.update(team);

    }

    @KafkaListener(id = "teams-delete", topics = "${kafka.topic.teams.delete}", containerFactory = "kafkaListenerTeamContainerFactory")
    public void deleteTeam(Team team) {

        log.info("consume team and delete team {} ", team.toString());
        teamService.delete(team);

    }

}
