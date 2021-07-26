package com.example.kafka_batch.controller;

import com.example.kafka_batch.dto.EventType;
import com.example.kafka_batch.dto.Member;
import com.example.kafka_batch.dto.MemberEvent;
import com.example.kafka_batch.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/members")
public class MemberController {

    private final KafkaProducer producer;

    public MemberController(KafkaProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public ResponseEntity<String> createMember(@RequestBody Member member){

        MemberEvent memberEvent = new MemberEvent(EventType.CREATE, member);
        producer.sendMessage(memberEvent);

        return ResponseEntity.ok("success");
    }

    @PutMapping
    public ResponseEntity<Member> updateMember(@RequestBody Member member){
        MemberEvent memberEvent= new MemberEvent(EventType.UPDATE, member);
        producer.sendMessage(memberEvent);

        return ResponseEntity.ok(member);
    }

}
