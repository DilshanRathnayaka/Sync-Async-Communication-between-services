package com.communication2.communication2.service.impl;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @KafkaListener(topics = "users",groupId = "user-group",topicPartitions = {@TopicPartition(topic = "users",partitions = {"2"})})
    public void listen(String message) {
        System.out.println("Received Message: "+message);
    }
}
