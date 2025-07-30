package com.deliveryboy.deliveryboy.service;

import com.deliveryboy.deliveryboy.config.AppConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    private Logger logger = LoggerFactory.getLogger(KafkaService.class);

    public boolean updateLocation(String location) {
        try {
            kafkaTemplate.send("location-update-topic", location);
            return true;
        } catch (org.springframework.kafka.KafkaException e) {
            // log error and handle gracefully
            logger.error("Kafka send failed: {}", e.getMessage());
            return false;
        }
    }
}
