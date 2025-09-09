package com.communication2.communication2.feignClient;

import com.communication2.communication2.dto.TestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "communication",url = "http://localhost:8081/")
public interface TestCommunication2 {

    @GetMapping("api/")
    List<TestDTO> getAllTests();

    @PostMapping("api/save")
    TestDTO saveTest(TestDTO testDTO);

}
