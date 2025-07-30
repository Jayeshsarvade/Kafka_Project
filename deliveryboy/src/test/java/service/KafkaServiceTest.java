package service;

import com.deliveryboy.deliveryboy.service.KafkaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class KafkaServiceTest {

    @Mock
    private KafkaTemplate<String, String> kafkaTemplate;

    @InjectMocks
    private KafkaService kafkaService;

    public KafkaServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("updateLocation returns true when Kafka send succeeds")
    void updateLocationReturnsTrueOnSuccess() {
        when(kafkaTemplate.send(anyString(), anyString())).thenReturn(null);
        boolean result = kafkaService.updateLocation("location1");
        assertTrue(result);
        verify(kafkaTemplate).send(anyString(), eq("location1"));
    }

    @Test
    @DisplayName("updateLocation returns false when KafkaException is thrown")
    void updateLocationReturnsFalseOnKafkaException() {
        doThrow(new KafkaException("Kafka error")).when(kafkaTemplate).send(anyString(), anyString());
        boolean result = kafkaService.updateLocation("location2");
        assertFalse(result);
        verify(kafkaTemplate).send(anyString(), eq("location2"));
    }

    @Test
    @DisplayName("updateLocation handles null location gracefully")
    void updateLocationHandlesNullLocation() {
        when(kafkaTemplate.send(anyString(), isNull())).thenReturn(null);
        boolean result = kafkaService.updateLocation(null);
        assertTrue(result);
        verify(kafkaTemplate).send(anyString(), isNull());
    }
}
