package com.deliveryboy.deliveryboy.controller;

import com.deliveryboy.deliveryboy.service.KafkaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private KafkaService kafkaService;

    private Logger logger = LoggerFactory.getLogger(LocationController.class);

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation() {
        for (int i = 1;i<=100000;i++) {
            kafkaService.updateLocation("(" + Math.round(Math.random() * 100) + "," + Math.round(Math.random() * 100) + ")");
            logger.info("Message Produced " + i);
            System.out.println("------------------------");
        }
        return new ResponseEntity<>(Map.of("message", "location updated"), HttpStatus.OK);
    }
}
