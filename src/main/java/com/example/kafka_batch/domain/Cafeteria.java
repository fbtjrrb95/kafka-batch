package com.example.kafka_batch.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "cafeteria")
@Entity
public class Cafeteria extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String memo;
    private String address;
    private double latitude;
    private double longitude;

}
