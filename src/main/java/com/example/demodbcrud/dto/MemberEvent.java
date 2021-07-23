package com.example.demodbcrud.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberEvent {
    private EventType type;
    private Member member;

}
