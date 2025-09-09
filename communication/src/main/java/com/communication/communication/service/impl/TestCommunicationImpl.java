package com.communication.communication.service.impl;

import com.communication.communication.dto.TestDTO;
import com.communication.communication.exception.TestCommunicationException;
import com.communication.communication.mapper.TestMapper;
import com.communication.communication.repo.TestRepo;
import com.communication.communication.service.TestCommunication;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class TestCommunicationImpl implements TestCommunication {

    private final TestRepo testRepo;
    private final TestMapper testMapper;
    private final ObjectMapper objectMapper;

    public TestDTO saveTest(TestDTO testDTO) {
        try{
            System.out.println(testDTO.getDescription());
            return testMapper.entityToDto(testRepo.save(testMapper.dtoToEntity(testDTO)));
        }catch (Exception e){
            throw  new TestCommunicationException(e.getMessage());
        }
    }

    public List<TestDTO> getAllTests() {
        try {
            return testMapper.entityListToDtoList(testRepo.findAll());
        }catch (Exception e) {
            throw new TestCommunicationException(e.getMessage());
        }
    }

    public TestDTO getTestById(Integer id) {
        try{
            return testMapper.entityToDto(testRepo.findById(id).get());
        }catch(Exception e){
            throw new TestCommunicationException(e.getMessage());
        }
    }

    public String deleteTestById(Integer id) {
        try{
            testRepo.deleteById(id);
            return "Test has been deleted";
        }catch (Exception e){
            throw new TestCommunicationException(e.getMessage());
        }
    }

    @KafkaListener(topics = "test.testdto.saved",groupId = "communication-service")
    public void onMessage(String message) {
        log.info("Received TestDTO {}", message);
        try {
            TestDTO testD = objectMapper.readValue(message, TestDTO.class);
            System.out.println(testD);
            saveTest(testD);
        }catch (Exception e){
            throw new TestCommunicationException(e.getMessage());
        }

    }

}
