package com.example.kafka_batch.config.consumer;

import com.example.kafka_batch.domain.Team;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public abstract class TeamConsumerConfig {

    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;

    public abstract String getTopicName();

    @Bean
    public Map<String, Object> teamConsumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, getTopicName());
        return props;
    }

    @Bean
    public ConsumerFactory<String, Team> teamConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(teamConsumerConfigs(), new StringDeserializer(),
                new JsonDeserializer<>(Team.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Team> kafkaListenerTeamContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Team> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(teamConsumerFactory());
        return factory;
    }
}
