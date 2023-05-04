package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonAlias;
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
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    Organization organization;

}
