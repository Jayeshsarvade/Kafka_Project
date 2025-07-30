package config;

import com.deliveryboy.deliveryboy.config.KafkaConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KafkaConfigTest {

    @Test
    @DisplayName("topic bean creates topic with correct name")
    void topicBeanCreatesTopicWithCorrectName() {
        KafkaConfig config = new KafkaConfig();
        NewTopic topic = config.topic();
        assertEquals("location-update-topic", topic.name());
    }
}
