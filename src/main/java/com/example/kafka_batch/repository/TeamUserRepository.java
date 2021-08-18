package com.example.kafka_batch.repository;

import com.example.kafka_batch.domain.TeamUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamUserRepository extends JpaRepository<TeamUser, Long> {
}
