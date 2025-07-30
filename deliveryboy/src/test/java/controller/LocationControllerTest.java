package controller;

import com.deliveryboy.deliveryboy.controller.LocationController;
import com.deliveryboy.deliveryboy.service.KafkaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class LocationControllerTest {


    @Mock
    private KafkaService kafkaService;

    @InjectMocks
    private LocationController locationController;

    public LocationControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("updateLocation returns OK and message when all Kafka sends succeed")
    void updateLocationReturnsOkWhenKafkaSendSucceeds() {
        when(kafkaService.updateLocation(anyString())).thenReturn(true);
        ResponseEntity<?> response = locationController.updateLocation();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("location updated", ((Map<?, ?>)response.getBody()).get("message"));
        verify(kafkaService, times(100000)).updateLocation(anyString());
    }

    @Test
    @DisplayName("updateLocation still returns OK if some Kafka sends fail")
    void updateLocationReturnsOkWhenSomeKafkaSendFails() {
        when(kafkaService.updateLocation(anyString()))
                .thenReturn(true)
                .thenReturn(false);
        ResponseEntity<?> response = locationController.updateLocation();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("location updated", ((Map<?, ?>)response.getBody()).get("message"));
        verify(kafkaService, times(100000)).updateLocation(anyString());
    }
}
