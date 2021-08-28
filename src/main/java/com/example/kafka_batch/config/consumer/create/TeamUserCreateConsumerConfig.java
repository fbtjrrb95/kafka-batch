package com.example.kafka_batch.config.consumer.create;

import com.example.kafka_batch.config.consumer.TeamUserConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TeamUserCreateConsumerConfig extends TeamUserConsumerConfig {

    @Value("${kafka.topic.teams-users.create}")
    private String topicName;

    @Override
    public String getTopicName() {
        return this.topicName;
    }

}
