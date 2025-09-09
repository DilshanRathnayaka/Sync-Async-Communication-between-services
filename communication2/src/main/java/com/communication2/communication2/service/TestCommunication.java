package com.communication2.communication2.service;

import com.communication2.communication2.dto.TestDTO;

import java.util.List;

public interface TestCommunication {
    TestDTO saveTest(TestDTO testDTO);

    TestDTO getTestById(Integer id);

    List<TestDTO> getAllTests();

    String deleteTestById(Integer id);

    List<TestDTO> getAllTestsFeign();
}
