package com.example.kafka_batch.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable {

    @LastModifiedDate
    private LocalDateTime lastModifiedAt;

    @CreatedDate
    private LocalDateTime createdAt;

    @PreUpdate
    public void onPreUpdate(){
        this.lastModifiedAt = LocalDateTime.now();
    }

    @PrePersist
    public void onPersist(){
        this.createdAt = LocalDateTime.now();
    }
}
