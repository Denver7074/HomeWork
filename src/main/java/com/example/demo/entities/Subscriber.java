package com.example.demo.entities;

import com.example.demo.entities.enums.Role;
import com.example.demo.entities.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String patronymic;
    String surname;
    LocalDate birth;
    int age;
    LocalDate createDate = LocalDate.now();
    @Enumerated(EnumType.STRING)
    Role role;
    @Enumerated(EnumType.STRING)
    Status status;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    Organization organization;
    public Subscriber(String name, String patronymic, String surname, LocalDate birth, int age,Organization organization) {
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.birth = birth;
        this.organization = organization;
    }
}
