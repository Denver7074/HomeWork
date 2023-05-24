package com.example.demo.DTO;

import com.example.demo.entities.UserEntity;
import com.example.demo.entities.enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {

    int age;
    Long id;
    String name;
    String surname;
    String patronymic;
    @Enumerated(EnumType.STRING)
    Status status;

    public static UserDTO userDTO(UserEntity userEntity){
        UserDTO user = new UserDTO();
        user.setId(userEntity.getId());
        user.setAge(userEntity.getAge());
        user.setName(userEntity.getName());
        user.setStatus(userEntity.getStatus());
        user.setSurname(userEntity.getSurname());
        user.setPatronymic(userEntity.getPatronymic());
        return user;
    }

}
