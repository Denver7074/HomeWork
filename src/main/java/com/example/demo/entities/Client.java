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
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String patronymic;
    String surname;
    int age;
    LocalDate birth;
    LocalDate createDate = LocalDate.now();
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "client")
    List<Journal> journalList = new ArrayList<>();

    public Client(String name, String patronymic, String surname, LocalDate birth) {
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.birth = birth;
    }
}
