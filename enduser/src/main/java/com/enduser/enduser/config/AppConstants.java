package com.enduser.enduser.config;

/**
 * Application-wide constants used for configuration.
 */
public class AppConstants {
    /**
     * Kafka topic for location updates.
     */
    public static final String LOCATION_UPDATE_TOPIC = "location-update-topic";

    /**
     * Kafka consumer group ID.
     */
    public static final String GROUP_ID = "group-1";

    private AppConstants() {
        throw new UnsupportedOperationException("Utility class should not be instantiated");
    }
}