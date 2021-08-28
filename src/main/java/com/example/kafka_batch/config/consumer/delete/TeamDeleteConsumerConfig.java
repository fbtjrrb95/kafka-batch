package com.example.kafka_batch.config.consumer.delete;

import com.example.kafka_batch.config.consumer.TeamConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TeamDeleteConsumerConfig extends TeamConsumerConfig {

    @Value("${kafka.topic.teams.delete}")
    private String topicName;

    @Override
    public String getTopicName() {
        return this.topicName;

    }
}
