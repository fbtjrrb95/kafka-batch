package com.example.kafka_batch.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Table(name = "User")
@Entity
public class User extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;

    @Column(name = "lat")
    private double latitude;

    @Column(name = "lng")
    private double longitude;

}