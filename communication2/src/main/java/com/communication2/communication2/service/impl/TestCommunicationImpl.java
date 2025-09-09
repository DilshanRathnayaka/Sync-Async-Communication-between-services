package com.communication2.communication2.service.impl;

import com.communication2.communication2.config.KafkaConfig;
import com.communication2.communication2.dto.TestDTO;
import com.communication2.communication2.exception.TestCommunicationException;
import com.communication2.communication2.feignClient.TestCommunication2;
import com.communication2.communication2.mapper.TestMapper;
import com.communication2.communication2.repo.TestRepo;
import com.communication2.communication2.service.TestCommunication;
import com.communication2.communication2.service.helper.ProducerService;
import com.communication2.communication2.service.helper.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TestCommunicationImpl implements TestCommunication {

    private final TestRepo testRepo;
    private final TestMapper testMapper;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final TestCommunication2 testCommunication2;
    private final ProducerService producerService;

    @Value("${communication.getAll.url}")
    private String url;

    public TestDTO saveTest(TestDTO testDTO) {
        try{
            String VALUE = objectMapper.writeValueAsString(testDTO);
            producerService.saveWithKafka(KafkaConfig.TOPIC,VALUE);
            return testMapper.entityToDto(testRepo.save(testMapper.dtoToEntity(testDTO)));
        }catch (Exception e){
            throw  new TestCommunicationException(e.getMessage());
        }
    }

    /// Rest Template Example
    public List<TestDTO> getAllTests() {
        List<TestDTO> testDTOs;
        testDTOs = testMapper.entityListToDtoList(testRepo.findAll());
        try {
            try{
                TestDTO[] test = objectMapper.readValue(restTemplate.get(url, String.class), TestDTO[].class);
                testDTOs.addAll(Arrays.asList(test));
            }catch (Exception e){
                throw  new TestCommunicationException(e.getMessage());
            }
            return testDTOs;
        }catch (Exception e) {
            throw new TestCommunicationException(e.getMessage());
        }
    }

    /// Feign Client Example
    public List<TestDTO> getAllTestsFeign() {
        List<TestDTO> test = testCommunication2.getAllTests();
        System.out.println(test.size());
        return test;
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

}
