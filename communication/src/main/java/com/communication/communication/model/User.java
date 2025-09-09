package com.communication.communication.model;

import com.communication.communication.utill.Step;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Data
public class User extends BaseEntity {
    @UuidGenerator
    private UUID uuid;

    private String name;

    private String email;

    private String phone;

    @Enumerated(EnumType.STRING)
    private Step stepType;

}
