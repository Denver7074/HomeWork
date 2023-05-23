package com.example.demo.entities;

import com.example.demo.entities.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity extends BaseEntity{

    int age;
    String name;
    String surname;
    String password;
    LocalDate birth;
    String patronymic;
    LocalDate createDate = LocalDate.now();
    @Enumerated(EnumType.STRING)
    Status status;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    Organization organization;
    public UserEntity(String name, String patronymic, String surname, LocalDate birth, int age, Organization organization) {
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.birth = birth;
        this.organization = organization;
    }
}
