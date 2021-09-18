package com.example.kafka_batch.service;

import com.example.kafka_batch.domain.Team;
import com.example.kafka_batch.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public Team save(Team team) {
        return teamRepository.save(team);
    }

    public Team update(Team team) {
        return teamRepository.save(team);
    }

    public void delete(Team team) {
        teamRepository.delete(team);
    }

}
