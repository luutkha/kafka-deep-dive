package kafka.deep.dive.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaListenerService {

    @KafkaListener(topics = "sampleTopic", groupId = "spring.kafka.consumer.group-id")
    public void listenGroupFoo(String message) {
        log.debug("Received Message in group foo: {}", message);
    }

    @KafkaListener(topics = "topicName")
    public void listenWithHeaders(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED) int partition) {
        log.debug("Received Message: {}from partition: {}", message, partition);
    }
}
