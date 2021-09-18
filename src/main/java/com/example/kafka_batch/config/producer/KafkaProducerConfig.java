package com.example.kafka_batch.config.producer;

import com.example.kafka_batch.domain.Team;
import com.example.kafka_batch.domain.TeamUser;
import com.example.kafka_batch.domain.User;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;

    public Map<String, Object> producerConfigs() {

        Map<String, Object> props = new HashMap<>();
        props.put(org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return props;
    }


    public ProducerFactory<String, User> userProducerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }


    public ProducerFactory<String, Team> teamProducerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }


    public ProducerFactory<String, TeamUser> teamUserProducerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, User> userKafkaTemplate() {
        return new KafkaTemplate<>(userProducerFactory());
    }

    @Bean
    public KafkaTemplate<String, Team> teamKafkaTemplate() {
        return new KafkaTemplate<>(teamProducerFactory());
    }

    @Bean
    public KafkaTemplate<String, TeamUser> teamUserKafkaTemplate() {
        return new KafkaTemplate<>(teamUserProducerFactory());
    }


}
