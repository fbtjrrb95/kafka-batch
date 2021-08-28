package com.example.kafka_batch.config.consumer.create;

import com.example.kafka_batch.config.consumer.UserConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserCreateConsumerConfig extends UserConsumerConfig {

    @Value("${kafka.topic.users.create}")
    private String topicName;

    @Override
    public String getTopicName() {
        return this.topicName;
    }

}
