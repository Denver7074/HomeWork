package com.example.demo.entities;

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
    int age;
    LocalDate birth;
    LocalDate createDate = LocalDate.now();
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "subscriber")
    List<Journal> journalList = new ArrayList<>();

    public Subscriber(String name, String patronymic, String surname, LocalDate birth) {
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.birth = birth;
    }
}
