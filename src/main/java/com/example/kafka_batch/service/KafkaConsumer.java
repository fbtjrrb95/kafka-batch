package com.example.kafka_batch.service;

import com.example.kafka_batch.dto.Member;
import com.example.kafka_batch.dto.MemberEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics="${kafka.topic}")
    public void receive(MemberEvent memberEvent){
        try {
            Thread.sleep(3000);
            log.info("consume event "  + memberEvent.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Member member = memberEvent.getMember();
    }

}
