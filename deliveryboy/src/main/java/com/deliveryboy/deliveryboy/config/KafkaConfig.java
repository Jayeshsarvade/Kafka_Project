package com.deliveryboy.deliveryboy.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Kafka configuration class for defining topics.
 */
@Configuration
public class KafkaConfig {

    /**
     * Creates a new Kafka topic named 'location-update-topic'.
     *
     * @return NewTopic instance for 'location-update-topic'
     */
    @Bean
    public NewTopic topic(){
        return TopicBuilder
                .name("location-update-topic")
                // .partitions()
                // .replicas()
                .build();
    }
}