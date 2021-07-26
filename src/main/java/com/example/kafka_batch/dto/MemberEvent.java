package com.example.kafka_batch.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberEvent {
    private EventType type;
    private Member member;

}
