package com.example.demodbcrud.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "members")
@Data
public class Member {

    @Id
    private long id;

    private String name;
    private long num;
}
