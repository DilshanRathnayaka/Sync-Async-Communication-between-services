package com.communication.communication.dto;

import com.communication.communication.utill.Step;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
public class UserDTO {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private Step stepType;
    private String uuid;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;
}
