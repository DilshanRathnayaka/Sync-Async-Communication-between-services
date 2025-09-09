package com.communication.communication.service.helper;

public interface ProducerService {
    void sendMessage(String topic, String message);
}
