package com.communication2.communication2.mapper;

import com.communication2.communication2.dto.TestDTO;
import com.communication2.communication2.model.Test;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TestMapper {
    Test dtoToEntity(TestDTO testDTO);
    TestDTO entityToDto(Test test);

    List<TestDTO> entityListToDtoList(List<Test> tests);


}
