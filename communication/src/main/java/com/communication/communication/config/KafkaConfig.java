package com.communication.communication.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    public static final String TOPIC = "users";

    @Bean
    public NewTopic newTopic() {
        return TopicBuilder.name(TOPIC)
                .replicas(1)
                .partitions(2)
                .build();
    }
}
