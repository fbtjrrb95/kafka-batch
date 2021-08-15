package com.example.kafka_batch.repository;

import com.example.kafka_batch.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
