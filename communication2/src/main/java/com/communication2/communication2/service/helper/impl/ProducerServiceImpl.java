package com.communication2.communication2.service.helper.impl;

import com.communication2.communication2.service.helper.ProducerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ProducerServiceImpl.class);

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void saveWithKafka(String topic,String testDTO) {
        kafkaTemplate.send(topic, testDTO).whenComplete((res, ex) -> {
            if (ex != null) {
                LOGGER.error("Failed to push TestDTO: {}",ex.getMessage());
            }else  {
                LOGGER.info("Published TestDTO to topic={}, partition={}, offset={}",
                        res.getRecordMetadata().topic(),
                        res.getRecordMetadata().partition(),
                        res.getRecordMetadata().offset());
            }
        });
    }
}
