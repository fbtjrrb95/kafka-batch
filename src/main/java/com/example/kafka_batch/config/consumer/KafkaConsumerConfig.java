package com.example.kafka_batch.config.consumer;

import com.example.kafka_batch.domain.Team;
import com.example.kafka_batch.domain.TeamUser;
import com.example.kafka_batch.domain.User;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${kafka.group.id.users}")
    private String userGroupId;

    @Value("${kafka.group.id.teams}")
    private String teamGroupId;

    @Value("${kafka.group.id.teams-users}")
    private String teamUserGroupId;

    public Map<String, Object> consumerConfigs(String groupId) {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        return props;
    }

    public ConsumerFactory<String, User> userConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs(userGroupId), new StringDeserializer(),
                new JsonDeserializer<>(User.class));
    }

    public ConsumerFactory<String, Team> teamConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs(teamGroupId), new StringDeserializer(),
                new JsonDeserializer<>(Team.class));
    }

    public ConsumerFactory<String, TeamUser> teamUserConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs(teamUserGroupId), new StringDeserializer(),
                new JsonDeserializer<>(TeamUser.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, User> userKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, User> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(userConsumerFactory());
        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Team> teamKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Team> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(teamConsumerFactory());
        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, TeamUser> teamUserKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, TeamUser> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(teamUserConsumerFactory());
        return factory;
    }

}
