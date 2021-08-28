package com.example.kafka_batch.config.consumer.create;

import com.example.kafka_batch.config.consumer.TeamConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TeamCreateConsumerConfig extends TeamConsumerConfig {

    @Value("${kafka.topic.teams.create}")
    private String topicName;

    @Override
    public String getTopicName() {
        return this.topicName;
    }

}
