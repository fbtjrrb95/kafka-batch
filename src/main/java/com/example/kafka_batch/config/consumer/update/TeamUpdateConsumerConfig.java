package com.example.kafka_batch.config.consumer.update;

import com.example.kafka_batch.config.consumer.TeamConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TeamUpdateConsumerConfig extends TeamConsumerConfig {

    @Value("${kafka.topic.teams.update}")
    private String topicName;

    @Override
    public String getTopicName() {
        return this.topicName;
    }

}
