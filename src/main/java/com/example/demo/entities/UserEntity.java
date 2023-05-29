package com.example.demo.entities;

import com.example.demo.entities.BaseEntity;
import com.example.demo.entities.Organization;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class UserEntity extends BaseEntity {
    @NotBlank
    String inn;
//    String SNILS;
    String userName;
//    Integer age;
//    String surname;
//    @Getter(AccessLevel.NONE)
//    String password;
//    LocalDate birth;
//    String patronymic;
//    LocalDate createDate = LocalDate.now();


    @OneToMany(mappedBy = "userEntity")
    List<UserOrganization> userOrganizations = new ArrayList<>();


}
