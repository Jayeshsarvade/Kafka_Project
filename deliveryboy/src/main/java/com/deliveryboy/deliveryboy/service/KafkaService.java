package com.deliveryboy.deliveryboy.service;

import com.deliveryboy.deliveryboy.config.AppConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    /**
     * KafkaTemplate for sending messages to Kafka topics.
     */
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    /**
     * Logger instance for logging events in KafkaService.
     */
    private final Logger logger = LoggerFactory.getLogger(KafkaService.class);

    /**
     * Sends a location update message to the Kafka topic "location-update-topic".
     *
     * @param location the location data to be sent
     * @return true if the message was sent successfully, false otherwise
     */
    public boolean updateLocation(String location) {
        try {
            kafkaTemplate.send(AppConst.LOCATION_TOPIC_NAME, location);
            return true;
        } catch (org.springframework.kafka.KafkaException e) {
            // log error and handle gracefully
            logger.error("Kafka send failed: {}", e.getMessage());
            return false;
        }
    }
}