package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Equipment{

    @Id
    @JsonAlias("vri_id")
    String idVerification;
    @JsonAlias("mi.mitnumber")
    String mitNumber;
    @JsonAlias("mi.number")
    String number;
    @JsonAlias("valid_date")
    LocalDate validDate;
    @JsonAlias("verification_date")
    LocalDate verificationDate;
    @JsonAlias("mi.modification")
    String miType;
    @JsonAlias("org_title")
    String orgTitle;

    @ManyToMany
    List<Organization> organizations = new ArrayList<>();

}
