package com.example.kafka_batch.controller;

import com.example.kafka_batch.domain.Team;
import com.example.kafka_batch.domain.TeamUser;
import com.example.kafka_batch.domain.User;
import com.example.kafka_batch.producer.TeamProducer;
import com.example.kafka_batch.producer.TeamUserProducer;
import com.example.kafka_batch.producer.UserProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/batch")
public class BatchController {

    private final UserProducer usersProducer;
    private final TeamProducer teamsProducer;
    private final TeamUserProducer teamUserProducer;

    // create
    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        usersProducer.publishCreateTopic(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/team")
    public ResponseEntity<Team> createTeam(@RequestBody Team team) {
        teamsProducer.publishCreateTopic(team);
        return ResponseEntity.ok(team);
    }

    @PostMapping("/team-user")
    public ResponseEntity<TeamUser> createTeamUser(@RequestBody TeamUser teamUser) {
        teamUserProducer.publishCreateTopic(teamUser);
        return ResponseEntity.ok(teamUser);
    }

    // update
    @PutMapping("/user")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        usersProducer.publishUpdateTopic(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/team")
    public ResponseEntity<Team> updateTeam(@RequestBody Team team) {
        teamsProducer.publishUpdateTopic(team);
        return ResponseEntity.ok(team);
    }

    @PutMapping("/team-user")
    public ResponseEntity<TeamUser> updateTeamUser(@RequestBody TeamUser teamUser) {
        teamUserProducer.publishUpdateTopic(teamUser);
        return ResponseEntity.ok(teamUser);
    }

    // delete
    @DeleteMapping("/user")
    public ResponseEntity<User> deleteUser(@RequestBody User user) {
        usersProducer.publishDeleteTopic(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/team")
    public ResponseEntity<Team> deleteTeam(@RequestBody Team team) {
        teamsProducer.publishDeleteTopic(team);
        return ResponseEntity.ok(team);
    }

    @DeleteMapping("/team-user")
    public ResponseEntity<TeamUser> deleteTeamUser(@RequestBody TeamUser teamUser) {
        teamUserProducer.publishDeleteTopic(teamUser);
        return ResponseEntity.ok(teamUser);
    }


}
