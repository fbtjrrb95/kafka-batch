package com.example.kafka_batch.service;

import com.example.kafka_batch.domain.TeamUser;
import com.example.kafka_batch.repository.TeamUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamUserService {

    private final TeamUserRepository teamUserRepository;

    public TeamUser save(TeamUser teamUser) {
        return teamUserRepository.save(teamUser);
    }
    public TeamUser update(TeamUser teamUser) {
        return teamUserRepository.save(teamUser);
    }
    public void delete(TeamUser teamUser) {
         teamUserRepository.delete(teamUser);
    }
}
