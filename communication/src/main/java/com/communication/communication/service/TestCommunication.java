package com.communication.communication.service;

import com.communication.communication.dto.TestDTO;

import java.util.List;

public interface TestCommunication {
    TestDTO saveTest(TestDTO testDTO);

    TestDTO getTestById(Integer id);

    List<TestDTO> getAllTests();

    String deleteTestById(Integer id);
}
