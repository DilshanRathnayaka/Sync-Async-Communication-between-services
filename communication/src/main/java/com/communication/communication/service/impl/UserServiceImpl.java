package com.communication.communication.service.impl;

import com.communication.communication.config.KafkaConfig;
import com.communication.communication.dto.UserDTO;
import com.communication.communication.exception.UserException;
import com.communication.communication.mapper.UserMapper;
import com.communication.communication.model.User;
import com.communication.communication.repo.UserRepo;
import com.communication.communication.service.UserService;
import com.communication.communication.service.helper.ProducerService;
import com.communication.communication.utill.Step;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final UserMapper userMapper;
    private final ProducerService producerService;

    public UserDTO saveUser(UserDTO userDTO) {
        try{
            User user = userMapper.userDTOTOEntity(userDTO);
            if(user.getUuid() == null){
                user.setUuid(UUID.randomUUID());
                System.out.println(user.getUuid());
            }
            if(user.getStepType().equals(Step.APPROVED)){
                producerService.sendMessage(KafkaConfig.TOPIC, user.toString());
            }
            return userMapper.entityToUserDTO(userRepo.save(user));
        }catch (Exception ex){
            throw new UserException(ex.getMessage());
        }
    }

    public UserDTO byId(Integer id) {
        try {
            return userMapper.entityToUserDTO(userRepo.findById(id).get());
        }catch (Exception ex){
            throw new UserException(ex.getMessage());
        }
    }

}
