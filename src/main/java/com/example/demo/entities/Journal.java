package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Journal extends BaseEntity {

    String title;
    String description;
    @OneToOne
    CategoryDocument category;
    LocalDate createJournal = LocalDate.now();
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    Organization organization;

}
