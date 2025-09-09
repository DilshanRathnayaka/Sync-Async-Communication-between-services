package com.communication.communication.service.helper.impl;

import com.communication.communication.config.KafkaConfig;
import com.communication.communication.service.helper.ProducerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService {
    private static final Logger log = LoggerFactory.getLogger(ProducerServiceImpl.class);
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topic ,String message) {
        kafkaTemplate.send(topic, message).whenComplete((res, ex) -> {
            if (ex != null) {
                log.error("Failed to Push: {}", ex.getMessage());
            }else  {
                log.info("Message sent to Producer topic={},partition={},offset={}",
                        res.getRecordMetadata().topic(),
                        res.getRecordMetadata().partition(),
                        res.getRecordMetadata().offset()
                        );
            }
        });
    }

}
