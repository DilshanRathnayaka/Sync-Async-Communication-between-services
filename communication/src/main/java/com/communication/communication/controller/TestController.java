package com.communication.communication.controller;

import com.communication.communication.dto.TestDTO;
import com.communication.communication.service.TestCommunication;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class TestController {
    private final TestCommunication testCommunication;


    @PostMapping("save")
    public ResponseEntity<TestDTO> saveTest(@RequestBody TestDTO testDTO) {
        return new ResponseEntity<>(testCommunication.saveTest(testDTO), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<TestDTO>> getAllTests() {
        return new ResponseEntity<>(testCommunication.getAllTests(),HttpStatus.OK);
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<String> deleteTestById(@PathVariable Integer id) {
        return new ResponseEntity<>(testCommunication.deleteTestById(id),HttpStatus.OK);
    }

    @PostMapping("{id}")
    public ResponseEntity<TestDTO> getTestById(@PathVariable Integer id) {
        return new ResponseEntity<>(testCommunication.getTestById(id),HttpStatus.OK);
    }

}
