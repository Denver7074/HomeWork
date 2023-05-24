package com.example.demo.entities;

import com.example.demo.entities.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity extends BaseEntity{

    String name;
    Integer age;
    String surname;
    @Getter(AccessLevel.NONE)
    String password;
    LocalDate birth;
    String patronymic;
    LocalDate createDate = LocalDate.now();
    @Enumerated(EnumType.STRING)
    Status status;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    Organization organization;

}
