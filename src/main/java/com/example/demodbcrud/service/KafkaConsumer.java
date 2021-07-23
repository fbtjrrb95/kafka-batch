package com.example.demodbcrud.service;

import com.example.demodbcrud.dto.EventType;
import com.example.demodbcrud.dto.Member;
import com.example.demodbcrud.dto.MemberEvent;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class KafkaConsumer {

//   private final MemberService memberService;

    private Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

//    public KafkaConsumer(MemberService memberService) {
//        this.memberService = memberService;
//    }

    @KafkaListener(topics="${kafka.topic}")
    public void receive(MemberEvent memberEvent){

        logger.info("consume message"  + memberEvent.toString());
        Member member = memberEvent.getMember();


//        if(memberEvent.getType() == EventType.CREATE) {
//            memberService.addMember(member);
//            return;
//        }
//
//        if(memberEvent.getType() == EventType.UPDATE) {
//            memberService.updateMember(member);
//            return;
//        }

    }

}
