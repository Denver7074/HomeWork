package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Organization extends BaseEntity{

    String name;
    String area;
    String workDescription;
    String accreditationNumber;
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "organization")
    List<Journal> journals = new ArrayList<>();
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "organization")
    List<Equipment> equipmentList = new ArrayList<>();
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "organization")
    List<UserEntity> userEntities = new ArrayList<>();


}
