package com.example.demodbcrud.controller;

import com.example.demodbcrud.dto.EventType;
import com.example.demodbcrud.dto.Member;
import com.example.demodbcrud.dto.MemberEvent;
import com.example.demodbcrud.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/members")
public class MemberController {
    private final KafkaProducer producer;
//    private final MemberService memberService;

    private Logger logger = LoggerFactory.getLogger(MemberController.class);

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

//    @GetMapping
//    public ResponseEntity<Page<Member>> getMembers(@RequestParam String pageNum, @RequestParam String count, @RequestParam(required = false) String name){
//
//        if(name == null){
//            return ResponseEntity.ok(memberService.getAllMembers(Integer.parseInt(pageNum), Integer.parseInt(count)));
//        }
//
//        return ResponseEntity.ok(memberService.getMembers(name, Integer.parseInt(pageNum), Integer.parseInt(count)));
//    }

}
