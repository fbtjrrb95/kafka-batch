package com.example.kafka_batch.config.consumer.update;

import com.example.kafka_batch.config.consumer.UserConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserUpdateConsumerConfig extends UserConsumerConfig {

    @Value("${kafka.topic.users.update}")
    private String topicName;

    @Override
    public String getTopicName() {
        return this.topicName;
    }

}
