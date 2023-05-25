package com.example.demo.entities;

import com.example.demo.entities.enums.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class UserEntity extends BaseEntity{
    @NotBlank
    String inn;
//    String SNILS;
    String userName;
//    Boolean dismissed;
//    Integer age;
//    String surname;
//    @Getter(AccessLevel.NONE)
//    String password;
//    LocalDate birth;
//    String patronymic;
//    LocalDate createDate = LocalDate.now();
//    @Enumerated(EnumType.STRING)
//    Status status;

    @ManyToMany()
    List<Organization> organizations = new ArrayList<>();

}
