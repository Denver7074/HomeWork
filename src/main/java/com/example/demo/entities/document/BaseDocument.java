package com.example.demo.entities.document;

import com.example.demo.entities.structure.Organization;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@MappedSuperclass
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class BaseDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String title;
//    String description;
//    @OneToOne
//    CategoryDocument category;
    LocalDate dateWriteOffInTheArchive;
    LocalDate dateCompleteRemoval;
//    LocalDate createJournal = LocalDate.now();
//    LocalDate dateUpdate;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    Organization organization;
}
