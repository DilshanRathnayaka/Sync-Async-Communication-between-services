package com.communication2.communication2.service.helper;

import com.communication2.communication2.dto.TestDTO;

public interface ProducerService {
    void saveWithKafka(String topic,String testDTO);
}
