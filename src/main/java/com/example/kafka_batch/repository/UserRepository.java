package com.example.kafka_batch.repository;

import com.example.kafka_batch.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
