package com.communication.communication.service;

import com.communication.communication.dto.UserDTO;

public interface UserService {

    UserDTO saveUser(UserDTO userDTO);

    UserDTO byId(Integer id);
}
