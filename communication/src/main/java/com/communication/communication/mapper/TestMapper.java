package com.communication.communication.mapper;

import com.communication.communication.dto.TestDTO;
import com.communication.communication.model.Test;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TestMapper {
    Test dtoToEntity(TestDTO testDTO);
    TestDTO entityToDto(Test test);

    List<TestDTO> entityListToDtoList(List<Test> tests);

}
