package com.deliveryboy.deliveryboy.controller;

import com.deliveryboy.deliveryboy.service.KafkaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * REST controller for handling location updates.
 */
@RestController
@RequestMapping("/location")
public class LocationController {

    private final KafkaService kafkaService;

    public LocationController(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    private final Logger logger = LoggerFactory.getLogger(LocationController.class);

    /**
     * Updates the location by producing 100,000 random location messages to Kafka.
     *
     * @return ResponseEntity containing a success message and HTTP status OK.
     */
    @PostMapping("/update")
    public ResponseEntity<Map<String, String>> updateLocation() {
        for (int i = 1; i <= 100000; i++) {
            kafkaService.updateLocation("(" + Math.round(Math.random() * 100) + "," + Math.round(Math.random() * 100) + ")");
            logger.info("Message Produced {}", i);
            logger.info("------------------------");
        }
        return new ResponseEntity<>(Map.of("message", "location updated"), HttpStatus.OK);
    }
}