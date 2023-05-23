package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Journal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String title;
    String description;
    LocalDate createJournal = LocalDate.now();
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    Organization organization;
    public Journal(String title, String description,Organization organization) {
        this.title = title;
        this.description = description;
        this.organization = organization;
    }


}
