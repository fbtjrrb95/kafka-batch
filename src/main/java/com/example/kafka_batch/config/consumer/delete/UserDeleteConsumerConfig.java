package com.example.kafka_batch.config.consumer.delete;

import com.example.kafka_batch.config.consumer.UserConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserDeleteConsumerConfig extends UserConsumerConfig {

    @Value("${kafka.topic.users.delete}")
    private String topicName;

    @Override
    public String getTopicName() {
        return this.topicName;
    }

}
