package com.communication.communication.mapper;

import com.communication.communication.dto.UserDTO;
import com.communication.communication.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO entityToUserDTO(User user);

    User userDTOTOEntity(UserDTO userDTO);
}
