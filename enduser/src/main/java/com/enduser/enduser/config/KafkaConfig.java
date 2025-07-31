package com.enduser.enduser.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
/**
 * Kafka configuration class for handling Kafka listeners.
 */
public class KafkaConfig {

    /**
     * Listens to location update messages from the specified Kafka topic.
     * @param value the message received from the topic
     */

    /**
     * Logger instance for logging within KafkaConfig.
     */
    private static final Logger logger = LoggerFactory.getLogger(KafkaConfig.class);

    @KafkaListener(topics = AppConstants.LOCATION_UPDATE_TOPIC, groupId = AppConstants.GROUP_ID)
    public void updatedLocation(String value){
        logger.info(value);
    }
}