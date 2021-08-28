package com.example.kafka_batch.config.consumer.update;

import com.example.kafka_batch.config.consumer.TeamUserConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TeamUserUpdateConsumerConfig extends TeamUserConsumerConfig {

    @Value("${kafka.topic.teams-users.update}")
    private String topicName;

    @Override
    public String getTopicName() {
        return this.topicName;
    }

}
